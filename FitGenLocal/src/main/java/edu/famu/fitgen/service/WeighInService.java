/*package edu.famu.fitgen.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import edu.famu.fitgen.model.WeighIns;

public class WeighInService {
    private Firestore firestore;

    public WeighInService() {
        this.firestore = FirestoreClient.getFirestore();
    }

    public WeighIns documentSnapshotToWeighIn(DocumentSnapshot document) {
        if (document.exists()) {
            return document.toObject(WeighIns.class);
        }
        return null;
    }

    // Create WeighIn
    public String createWeighIn(WeighIns weighIn) throws ExecutionException, InterruptedException {
        CollectionReference weighInCollection = firestore.collection("WeighIns");
        ApiFuture<DocumentReference> future = weighInCollection.add(weighIn);
        DocumentReference docRef = future.get();
        return docRef.getId();
    }

    // Read WeighIn by ID
    public WeighIns getWeighIn(String id) throws ExecutionException, InterruptedException {
        DocumentReference weighInDoc = firestore.collection("WeighIns").document(id);
        DocumentSnapshot document = weighInDoc.get().get();
        if (document.exists()) {
            return document.toObject(WeighIns.class);
        }
        return null;
    }

    public WriteResult updateWeighIn(String id, Map<String, Object> updateValues) throws ExecutionException, InterruptedException {
        String[] allowed = {"weight", "bodyFat", "updatedAt"};

        List<String> allowedFields = Arrays.asList(allowed);
        Map<String, Object> formattedValues = new HashMap<>();

        for(Map.Entry<String, Object> entry : updateValues.entrySet()) {
            String key = entry.getKey();
            if(allowedFields.contains(key)) {
                formattedValues.put(key, entry.getValue());
            }
        }
        DocumentReference weighInDoc = firestore.collection("WeighIns").document(id);
        ApiFuture<WriteResult> result = weighInDoc.update(formattedValues);
        return result.get();
    }

    public WriteResult deleteWeighIn(String id) throws ExecutionException, InterruptedException {
        DocumentReference weighInDoc = firestore.collection("WeighIns").document(id);
        ApiFuture<WriteResult> writeResult = weighInDoc.delete();
        return writeResult.get();
    }
}*/
