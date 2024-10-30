package edu.famu.fitgen.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.ExecutionException;
import edu.famu.fitgen.model.Users;

@Service
public class UsersService {

    private final Firestore firestore;

    public UsersService(Firestore firestore) {
        this.firestore = firestore;
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

    // Update User
    public WriteResult updateUser(String id, Map<String, Object> updateValues) throws ExecutionException, InterruptedException {
        List<String> allowedFields = Arrays.asList("firstName", "lastName", "email", "age", "height", "updatedAt");
        Map<String, Object> formattedValues = new HashMap<>();
        for (Map.Entry<String, Object> entry : updateValues.entrySet()) {
            if (allowedFields.contains(entry.getKey())) {
                formattedValues.put(entry.getKey(), entry.getValue());
            }
        }
        DocumentReference userDoc = firestore.collection("Users").document(id);
        ApiFuture<WriteResult> result = userDoc.update(formattedValues);
        return result.get();
    }

    // Delete User
    public WriteResult deleteUser(String id) throws ExecutionException, InterruptedException {
        DocumentReference userDoc = firestore.collection("Users").document(id);
        ApiFuture<WriteResult> writeResult = userDoc.delete();
        return writeResult.get();
    }
}
