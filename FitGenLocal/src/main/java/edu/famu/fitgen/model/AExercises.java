package edu.famu.fitgen.model;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.firebase.database.annotations.Nullable;
import com.google.protobuf.util.Timestamps;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AExercises {
    @DocumentId
    private @Nullable String exerciseId; // References the user who completed the exercise.
    private String exerciseName;    // The name of the exercise.
    private double duration;        // The duration of the exercise in minutes.
    private int reps;               // The number of repetitions performed.

    private @Nullable Timestamp date; // The date and time the exercise was logged.

    public void setDate(String date) throws ParseException {
        this.date = Timestamp.fromProto(Timestamps.parse(date));
    }
}
