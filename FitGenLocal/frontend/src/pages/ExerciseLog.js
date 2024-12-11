import React, { useState, useEffect } from 'react';
import axios from 'axios';
import '../App.css';

const ExerciseLog = () => {
    const [exercises, setExercises] = useState([]);
    const [exerciseName, setExerciseName] = useState('');
    const [sets, setSets] = useState('');
    const [reps, setReps] = useState('');
    const [weight, setWeight] = useState('');
    const [duration, setDuration] = useState('');

    useEffect(() => {
        // Fetch the user's exercise log from the backend
        axios.get('/api/exercise-log')
            .then(response => {
                setExercises(response.data);
            })
            .catch(error => {
                console.error('Error fetching exercise log:', error);
            });
    }, []);

    const handleSubmit = (e) => {
        e.preventDefault();
        const newExercise = {
            exerciseName,
            sets,
            reps,
            weight,
            duration,
        };

        // Send new exercise log to the backend
        axios.post('/api/exercise-log', newExercise)
            .then(response => {
                setExercises([...exercises, response.data]);
                // Clear form fields
                setExerciseName('');
                setSets('');
                setReps('');
                setWeight('');
                setDuration('');
            })
            .catch(error => {
                console.error('Error logging exercise:', error);
            });
    };

    return (
        <div className="exercise-log-container">
            <h2>Exercise Log</h2>

            <form className="exercise-form" onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="Exercise Name"
                    value={exerciseName}
                    onChange={(e) => setExerciseName(e.target.value)}
                    required
                />
                <input
                    type="number"
                    placeholder="Sets"
                    value={sets}
                    onChange={(e) => setSets(e.target.value)}
                    required
                />
                <input
                    type="number"
                    placeholder="Reps"
                    value={reps}
                    onChange={(e) => setReps(e.target.value)}
                    required
                />
                <input
                    type="number"
                    placeholder="Weight (kg)"
                    value={weight}
                    onChange={(e) => setWeight(e.target.value)}
                    required
                />
                <input
                    type="number"
                    placeholder="Duration (mins)"
                    value={duration}
                    onChange={(e) => setDuration(e.target.value)}
                    required
                />
                <button type="submit">Log Exercise</button>
            </form>

            <div className="exercise-log-list">
                <h3>Logged Exercises</h3>
                <table>
                    <thead>
                    <tr>
                        <th>Exercise</th>
                        <th>Sets</th>
                        <th>Reps</th>
                        <th>Weight (kg)</th>
                        <th>Duration (min)</th>
                    </tr>
                    </thead>
                    <tbody>
                    {exercises.map((exercise, index) => (
                        <tr key={index}>
                            <td>{exercise.exerciseName}</td>
                            <td>{exercise.sets}</td>
                            <td>{exercise.reps}</td>
                            <td>{exercise.weight}</td>
                            <td>{exercise.duration}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default ExerciseLog;
