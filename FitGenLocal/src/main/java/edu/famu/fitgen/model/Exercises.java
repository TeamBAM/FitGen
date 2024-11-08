package edu.famu.fitgen.model;

// import com.google.cloud.firestore.annotation.DocumentId;
// import com.google.firebase.database.annotations.Nullable;
// import com.google.protobuf.util.Timestamps;
// import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.google.cloud.Timestamp;

// import java.text.ParseException;

@Data // Creates setters and getters automatically
@NoArgsConstructor // Creates no argument constructor automatically
public class Exercises extends AExercises {

    private Users userId; // References the user who completed the exercise.

    public Exercises(String exerciseId, String exerciseName, double duration, int reps, Timestamp date, Users userId) {
        super(exerciseId, exerciseName, duration, reps, date);
        this.userId = userId;
    }
}

// may need to change the @nullable bc it will cause issues later
