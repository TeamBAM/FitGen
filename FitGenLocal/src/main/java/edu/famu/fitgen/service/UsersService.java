package edu.famu.fitgen.service;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;
import java.util.concurrent.ExecutionException;
import edu.famu.fitgen.model.Users;

@Service
public class UsersService {

    private Firestore firestore;

    private static final String USERS_COLLECTION = "Users";
    public UsersService() {
        this.firestore = FirestoreClient.getFirestore();
    }

    private Users documentToUser(DocumentSnapshot document) throws ParseException {
        if (document.exists()) {
            return new Users(document.getId(),document.getString("firstName"), document.getString("lastName"),
                    document.getString("email"), document.getTimestamp("createdAt"),
                    document.getTimestamp("updatedAt"), document.getLong("age"), document.getLong("height")
            ); // Make sure this is in the order of the users model
        }
        return null;
    }

    // Create User
    public String createUser(Users user) throws ExecutionException, InterruptedException {
        CollectionReference usersCollection = firestore.collection("Users");
        ApiFuture<DocumentReference> future = usersCollection.add(user);
        DocumentReference docRef = future.get();
        return docRef.getId();
    }


    // Read User by ID
    public Users getUser(String id) throws ExecutionException, InterruptedException {
        DocumentReference userDoc = firestore.collection("Users").document(id);
        DocumentSnapshot document = userDoc.get().get();
        if (document.exists()) {
            return document.toObject(Users.class);
        }
        return null;
    }

    public WriteResult updateUser(String id, Map<String, Object> updateValues) throws ExecutionException, InterruptedException {

        String[] allowed = {"age", "email", "updatedAt"};

        List<String> allowedFields = Arrays.asList(allowed);
        Map<String, Object> formattedValues = new HashMap<>();

        for(Map.Entry<String, Object> entry : updateValues.entrySet()) {
            String key = entry.getKey();
            if(allowedFields.contains(key)) {
                formattedValues.put(key, entry.getValue());

            }
        }
        DocumentReference userDoc = firestore.collection("Users").document(id);
        ApiFuture<WriteResult> result = userDoc.update(formattedValues);
        return result.get();
    }

    public WriteResult deleteUser(String id) throws ExecutionException, InterruptedException {
        DocumentReference userDoc = firestore.collection("Users").document(id);
        ApiFuture<WriteResult> writeResult = userDoc.delete();
        return writeResult.get();
    }
}
