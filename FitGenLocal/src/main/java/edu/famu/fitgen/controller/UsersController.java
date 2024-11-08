package edu.famu.fitgen.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.cloud.firestore.WriteResult;
import edu.famu.fitgen.model.Users;
import edu.famu.fitgen.service.UsersService;
import edu.famu.fitgen.util.ApiResponse;
import edu.famu.fitgen.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/users")
@JsonSerialize

public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<String>> addUser(@RequestBody Users user) {
        try{
            String id = usersService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse<>(true, "User successfully created.", id, null));
        }
        catch(ExecutionException | InterruptedException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Error creating user.", null, e));
        }
    }


    // Read User (GET)
    @GetMapping(value = "/{userId}", produces = Utility.DEFAULT_MEDIA_TYPE)
    public ResponseEntity<ApiResponse<Users>> getUser(@PathVariable(name = "userId") String id) {
        try {
            Users user = usersService.getUser(id);
            return user != null
                    ? ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "User retrieved successfully.", user, null))
                    : ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "User not found.", null, null));
        } catch (ExecutionException | InterruptedException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Error retrieving user.", null, e));
        } catch (ParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(false, "Error retrieving user.", null, e));
        }
    }

    // Update User (PUT)
    @PutMapping(path="/{user_id}", produces = Utility.DEFAULT_MEDIA_TYPE, consumes =  Utility.DEFAULT_MEDIA_TYPE)
    public ResponseEntity<ApiResponse<WriteResult>> updateUser(@PathVariable(name="user_id") String id,@RequestBody Map<String,Object> updateValues){
        try {
            WriteResult result = usersService.updateUser(id, updateValues);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(true, "User successfully updated.", result, null));
        } catch (ExecutionException | InterruptedException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Error updating user.", null, e));
        }

    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable(name = "user_id") String id) {
        try {
            usersService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(true, "User successfully deleted.", id, null));
        } catch (ExecutionException | InterruptedException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Error deleting user.", null, e));
        }
    }
}
