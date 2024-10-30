package edu.famu.fitgen.model;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.firebase.database.annotations.Nullable;
import com.google.protobuf.TextFormat;
import com.google.protobuf.util.Timestamps;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.google.cloud.Timestamp;

import java.text.ParseException;

@Data //creates setters and getters automatically
@AllArgsConstructor //creates constructor with all values automatically
@NoArgsConstructor //creates no argument constructor automatically
public class Users {
    @DocumentId
    private @Nullable String userId;
    private String firstName;
    private String lastName;
    private String email;

    private Timestamp createdAt ;
    private Timestamp updatedAt;

    private int age;
    private int height;

    public void setCreatedAt(String createdAt) throws TextFormat.ParseException, ParseException {
        this.createdAt = Timestamp.fromProto(Timestamps.parse(createdAt));
    }

    public void setUpdatedAt(String updatedAt) throws TextFormat.ParseException, ParseException {
        this.updatedAt = Timestamp.fromProto(Timestamps.parse(updatedAt));
    }
}
