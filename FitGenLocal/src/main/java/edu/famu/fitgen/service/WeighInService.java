package edu.famu.fitgen.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.firestore.v1.WriteResult;

import java.util.concurrent.ExecutionException;

import edu.famu.fitgen.model.WeighIns;

public class WeighInService {
/*
    public WeighIns getWeighInById(String id) throws ExecutionException, InterruptedException {
        DocumentReference weighInDoc = firestore.collection("WeighIns").document(id);
        ApiFuture<DocumentSnapshot> future = weighInDoc.get();
        DocumentSnapshot document = future.get();

        if (document.exists()) {
            return document.toObject(WeighIns.class);
        } else {
            throw new RuntimeException("Weigh-In with ID " + id + " not found.");
        }
    }

    public String createWeighIn(WeighIns weighIn) throws ExecutionException, InterruptedException {
        CollectionReference weighInsCollection = firestore.collection("WeighIns");
        ApiFuture<DocumentReference> future = weighInsCollection.add(weighIn);
        DocumentReference docRef = future.get();
        return docRef.getId();
    }

    public WriteResult updateWeighIn(String id, Map<String, Object> updateValues) throws ExecutionException, InterruptedException {
        String[] notAllowed = {"userId", "weighDate"};
        List<String> restrictedFields = Arrays.asList(notAllowed);
        Map<String, Object> formattedValues = new HashMap<>();

        for(Map.Entry<String, Object> entry : updateValues.entrySet()) {
            String key = entry.getKey();
            if(!restrictedFields.contains(key)) {
                formattedValues.put(key, entry.getValue());
            }
        }
        DocumentReference weighInDoc = firestore.collection("WeighIns").document(id);
        ApiFuture<WriteResult> result = weighInDoc.update(formattedValues);
        return result.get();
    }

    public com.google.cloud.firestore.WriteResult deleteWeighIn(String id) throws ExecutionException, InterruptedException {
        DocumentReference weighInRef = firestore.collection("WeighIns").document(id);
        return weighInRef.delete().get();
    }


*/

}
