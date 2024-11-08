package edu.famu.fitgen.controller;

import edu.famu.fitgen.model.Exercises;
import edu.famu.fitgen.service.ExercisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/exercises")
public class ExercisesController {

    @Autowired
    private ExercisesService exercisesService;

    // (Read/GET) Get exercises that have been logged
    @GetMapping
    public List<Exercises> getAllExercises() throws ExecutionException, InterruptedException {
        return exercisesService.getAllExercises();
    }

    // (Update/PUT) Edit exercise log
    @PutMapping("/{id}")
    public String updateExercise(@PathVariable String id, @RequestBody Map<String, Object> updateValues) throws ExecutionException, InterruptedException {
        exercisesService.updateExercise(id, updateValues);
        return "Exercise log updated successfully.";
    }

    // (DELETE) Delete exercise
    @DeleteMapping("/{id}")
    public String deleteExercise(@PathVariable String id) throws ExecutionException, InterruptedException {
        exercisesService.deleteExercise(id);
        return "Exercise log deleted successfully.";
    }

    // (Create/POST) Add exercise to log
    @PostMapping
    public String createExercise(@RequestBody Exercises exercise) throws ExecutionException, InterruptedException {
        return exercisesService.createExercise(exercise);
    }
}
