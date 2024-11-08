package edu.famu.fitgen.model;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RestExercises extends  AExercises{
    private DocumentReference useeId;

    public RestExercises(String exerciseId, String exerciseName, double duration, int reps, Timestamp date, DocumentReference useeId) {
        super(exerciseId, exerciseName, duration, reps, date);
        this.useeId = useeId;
    }

    public void setUserId(String id)
    {
        Firestore db = FirestoreClient.getFirestore();
        this.useeId = db.collection("Exercises").document(id);
    }
}
