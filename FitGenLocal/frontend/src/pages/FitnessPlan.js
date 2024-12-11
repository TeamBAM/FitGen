import React, { useState, useEffect } from 'react';
import axios from 'axios';
import '../App.css';

const FitnessPlan = () => {
    const [fitnessPlan, setFitnessPlan] = useState(null);

    useEffect(() => {
        // Fetch the fitness plan from the backend
        axios.get('/api/fitness-plan')
            .then(response => {
                setFitnessPlan(response.data);
            })
            .catch(error => {
                console.error('Error fetching fitness plan:', error);
            });
    }, []);

    if (!fitnessPlan) {
        return (
            <div className="loading">
                <p>Loading your fitness plan...</p>
            </div>
        );
    }

    return (
        <div className="fitness-plan-container">
            <h2>Your Fitness Plan</h2>
            <div className="fitness-plan-summary">
                <h3>{fitnessPlan.planName}</h3>
                <p><strong>Target Areas:</strong> {fitnessPlan.targetAreas.join(', ')}</p>
                <p><strong>Fitness Goals:</strong> {fitnessPlan.fitnessGoals.join(', ')}</p>
                <p><strong>Duration:</strong> {fitnessPlan.duration} weeks</p>
                <p><strong>Start Date:</strong> {new Date(fitnessPlan.startDate).toLocaleDateString()}</p>
                <a href={fitnessPlan.routineLink} target="_blank" rel="noopener noreferrer" className="btn btn-primary">View Full Routine</a>
            </div>

            <h3>Weekly Plan</h3>
            <div className="weekly-plan">
                {fitnessPlan.weeks.map((week, index) => (
                    <div key={index} className="week">
                        <h4>Week {index + 1}</h4>
                        <ul>
                            {week.activities.map((activity, idx) => (
                                <li key={idx}>{activity}</li>
                            ))}
                        </ul>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default FitnessPlan;
