package edu.famu.fitgen.model;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.firebase.database.annotations.Nullable;
import com.google.protobuf.util.Timestamps;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.google.cloud.Timestamp;

import java.text.ParseException;

@Data // Creates setters and getters automatically
@AllArgsConstructor // Creates constructor with all values automatically
@NoArgsConstructor // Creates no argument constructor automatically

public class FitStats {
    @DocumentId
    private @Nullable String userId; // References the user this fit stat belongs to.
    private double weight;           // The user's current weight.
    private double bodyFat;          // The user's current body fat percentage.
    private String fitLevel;         // The user's fitness level.
    private String goals;            // The user's fitness goals.
    private String planName;         // The name of the fitness plan assigned to the user.

    private @Nullable Timestamp createdAt; // The date and time the fitness stats were created.
    private @Nullable Timestamp updatedAt; // The date and time the fitness stats were last updated.

    public void setCreatedAt(String createdAt) throws ParseException {
        this.createdAt = Timestamp.fromProto(Timestamps.parse(createdAt));
    }

    public void setUpdatedAt(String updatedAt) throws ParseException {
        this.updatedAt = Timestamp.fromProto(Timestamps.parse(updatedAt));
    }
}
