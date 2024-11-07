package edu.famu.fitgen.service;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.ExecutionException;
import edu.famu.fitgen.model.Users;

@Service
@JsonSerialize
public class UsersService {

    private Firestore firestore;
    public UsersService() {
        this.firestore = FirestoreClient.getFirestore();
    }

    public Users documentSnapshotToUser(DocumentSnapshot document) {
        if (document.exists()) {
            return document.toObject(Users.class);
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
