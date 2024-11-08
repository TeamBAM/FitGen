package edu.famu.fitgen.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.firebase.database.annotations.Nullable;
import com.google.protobuf.TextFormat;
import com.google.protobuf.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;

@Data //creates setters and getters automatically

@AllArgsConstructor
@NoArgsConstructor

public class Users {
    @DocumentId
    private @Nullable String userId;
    private String firstName;
    private String lastName;
    private String email;

    private Timestamp createdAt;
    private Timestamp updatedAt;


    private int age;
    private int height;

    public Users(String id, String firstName, String lastName, String email, Long age, Timestamp createdAt, Timestamp updatedAt, Long age1, Long height) {
    }
    public void setCreatedAt(String createdAt) throws ParseException {
        this.createdAt = Timestamp.parseFrom(Timestamps.parse(createdAt));
    }

    public void setUpdatedAt(String updatedAt) throws ParseException {
        this.updatedAt = Timestamp.parseFrom(Timestamps.parse(updatedAt));
    }
}
