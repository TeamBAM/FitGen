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
public class AWeighIns {
    @DocumentId
    private @Nullable String weighInId;
    private int weight;
    private int bodyFat;

    private Timestamp weighDate;
    public void setWeighDate(String weighDate) throws TextFormat.ParseException, ParseException {
        this.weighDate = Timestamp.fromProto(Timestamps.parse(weighDate));
    }
}
