/*package edu.famu.fitgen.controller;

import com.google.cloud.firestore.WriteResult;
import edu.famu.fitgen.model.WeighIns;
import edu.famu.fitgen.service.UsersService;
import edu.famu.fitgen.service.WeighInService;
import edu.famu.fitgen.util.ApiResponse;
import edu.famu.fitgen.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/weighins") // Changed to use /weighins path

public class WeighInsController {

    private final WeighInService weighInService;

    @Autowired
    public WeighInsController(WeighInService weighInService) {this.weighInService = weighInService;}

    // Create WeighIn
    @PostMapping("/{weighInId}")
    public ResponseEntity<ApiResponse<String>> addWeighIn(@RequestBody WeighIns weighIn) {
        try {
            String id = weighInService.createWeighIn(weighIn);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse<>(true, "Weigh-in successfully created.", id, null));
        } catch (ExecutionException | InterruptedException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Error creating weigh-in.", null, e));
        }
    }

    // Read WeighIn (GET)
    @GetMapping(value = "/{weighInId}", produces = Utility.DEFAULT_MEDIA_TYPE)
    public ResponseEntity<ApiResponse<WeighIns>> getWeighIn(@PathVariable(name = "weighInId") String id) {
        try {
            WeighIns weighIn = weighInService.getWeighIn(id);
            return weighIn != null
                    ? ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "Weigh-in retrieved successfully.", weighIn, null))
                    : ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Weigh-in not found.", null, null));
        } catch (ExecutionException | InterruptedException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Error retrieving weigh-in.", null, e));
        }
    }

    // Update WeighIn (PUT)
    @PutMapping(path="/{weighInId}", produces = Utility.DEFAULT_MEDIA_TYPE, consumes = Utility.DEFAULT_MEDIA_TYPE)
    public ResponseEntity<ApiResponse<WriteResult>> updateWeighIn(@PathVariable(name="weighInId") String id, @RequestBody Map<String, Object> updateValues) {
        try {
            WriteResult result = weighInService.updateWeighIn(id, updateValues);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(true, "Weigh-in successfully updated.", result, null));
        } catch (ExecutionException | InterruptedException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Error updating weigh-in.", null, e));
        }
    }

    // Delete WeighIn
    @DeleteMapping("/{weighInId}")
    public ResponseEntity<ApiResponse<String>> deleteWeighIn(@PathVariable(name = "weighInId") String id) {
        try {
            weighInService.deleteWeighIn(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(true, "Weigh-in successfully deleted.", id, null));
        } catch (ExecutionException | InterruptedException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Error deleting weigh-in.", null, e));
        }
    }
}*/
