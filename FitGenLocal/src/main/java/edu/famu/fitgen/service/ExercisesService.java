package edu.famu.fitgen.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;

import java.util.ArrayList;
import java.util.HashMap; // not showing up?
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import edu.famu.fitgen.model.Exercises;
import edu.famu.fitgen.model.Users;
import org.springframework.stereotype.Service;

@Service
public class ExercisesService {
    private Firestore firestore;

    public ExercisesService() {
        this.firestore = FirestoreClient.getFirestore();
    }

    private Exercises documentToExercise(QueryDocumentSnapshot ds) throws ExecutionException, InterruptedException {
        if(ds.exists())
        {
            DocumentReference userRef = (DocumentReference) ds.get("userId");
            Users user = userRef!= null ? userRef.get().get().toObject(Users.class) : null;
            return new Exercises(ds.getId(), ds.getString("exerciseName"), ds.getDouble("duration"), Math.toIntExact(ds.getLong("reps")), ds.getTimestamp("date"), user);
        }
        return null; // this reference will be used for timestops or references
    }
    // (Read/GET) Get exercises that have been logged
    public List<Exercises> getAllExercises() throws ExecutionException, InterruptedException {
        CollectionReference exerciseCollection = firestore.collection("Exercises");
        ApiFuture<QuerySnapshot> future = exerciseCollection.get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        List<Exercises> exercises = documents.isEmpty() ? null : new ArrayList<>();

        for(QueryDocumentSnapshot document : documents)
        {
            exercises.add(documentToExercise(document));
        }
        return exercises;
    }

    // (Update/PUT) User can edit exercise log
    public WriteResult updateExercise(String id, Map<String, Object> updateValues) throws ExecutionException, InterruptedException {
        DocumentReference exerciseDoc = firestore.collection("Exercises").document(id);
        ApiFuture<WriteResult> result = exerciseDoc.update(updateValues);
        return result.get();
    }

    // (DELETE) User can delete exercise
    public WriteResult deleteExercise(String id) throws ExecutionException, InterruptedException {
        DocumentReference exerciseDoc = firestore.collection("Exercises").document(id);
        ApiFuture<WriteResult> writeResult = exerciseDoc.delete();
        return writeResult.get();
    }

    // (Create/POST) User can add exercise to log
    public String createExercise(Exercises exercise) throws ExecutionException, InterruptedException {
        CollectionReference exerciseCollection = firestore.collection("Exercises");
        ApiFuture<DocumentReference> future = exerciseCollection.add(exercise);
        DocumentReference docRef = future.get();
        return docRef.getId();
    }
}
