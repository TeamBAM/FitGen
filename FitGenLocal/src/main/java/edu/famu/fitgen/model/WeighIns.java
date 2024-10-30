package edu.famu.fitgen.model;

import com.google.firebase.database.annotations.Nullable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeighIns extends AWeighIns {

    private Users userId;

}