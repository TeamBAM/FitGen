package edu.famu.fitgen.controller;

import com.google.firestore.v1.WriteResult;
import edu.famu.fitgen.model.WeighIns;
import edu.famu.fitgen.service.WeighInService;
import edu.famu.fitgen.util.ApiResponse;
import edu.famu.fitgen.util.Utility;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/weighins")
public class WeighInsController {
/*
    @GetMapping("/{weighIn_id}")
    public ResponseEntity<ApiResponse<WeighIns>> getWeighInById(@PathVariable(name="weighIn_id") String id) {
        try {
            WeighIns weighIn = WeighInService.getWeighInById(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(true, "Weigh-In successfully retrieved.", weighIn, null));
        } catch (ExecutionException | InterruptedException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Error retrieving weigh-in.", null, e));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(false, e.getMessage(), null, e));
        }
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<String>> addWeighIn(@RequestBody WeighIns weighIn) {
        try {
            String id = WeighInService.createWeighIn(weighIn);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse<>(true, "Weigh-In successfully created.", id, null));
        } catch (ExecutionException | InterruptedException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Error creating weigh-in.", null, e));
        }
    }

    @PutMapping(path="/{weighIn_id}", produces = Utility.DEFAULT_MEDIA_TYPE, consumes = Utility.DEFAULT_MEDIA_TYPE)
    public ResponseEntity<ApiResponse<WriteResult>> updateWeighIn(
            @PathVariable(name="weighIn_id") String id,
            @RequestBody Map<String, Object> updateValues) {
        try {
            WriteResult result = WeighInService.updateWeighIn(id, updateValues);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(true, "Weigh-In successfully updated.", result, null));
        } catch (ExecutionException | InterruptedException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Error updating weigh-in.", null, e));
        }
    }

    @DeleteMapping("/{weighIn_id}")
    public ResponseEntity<ApiResponse<String>> deleteWeighIn(@PathVariable(name="weighIn_id") String id) {
        try {
            WeighInService.deleteWeighIn(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(true, "Weigh-In successfully deleted.", id, null));
        } catch (ExecutionException | InterruptedException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Error deleting weigh-in.", null, e));
        }
    }

*/
}
