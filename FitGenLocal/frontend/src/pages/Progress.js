import React, { useState, useEffect } from 'react';
import axios from 'axios';
import '../App.css';
import { Line } from 'react-chartjs-2';
import { Chart as ChartJS, CategoryScale, LinearScale, PointElement, LineElement, Title, Tooltip, Legend } from 'chart.js';

// Register chart.js components
ChartJS.register(CategoryScale, LinearScale, PointElement, LineElement, Title, Tooltip, Legend);

const Progress = () => {
    const [progressData, setProgressData] = useState(null);

    useEffect(() => {
        // Fetch the user's progress data from the backend
        axios.get('/api/progress')
            .then(response => {
                setProgressData(response.data);
            })
            .catch(error => {
                console.error('Error fetching progress data:', error);
            });
    }, []);

    if (!progressData) {
        return (
            <div className="loading">
                <p>Loading your progress...</p>
            </div>
        );
    }

    const chartData = {
        labels: progressData.dates,
        datasets: [
            {
                label: 'Weight (kg)',
                data: progressData.weights,
                fill: false,
                borderColor: 'rgba(75, 192, 192, 1)',
                tension: 0.1
            },
            {
                label: 'Body Fat (%)',
                data: progressData.bodyFats,
                fill: false,
                borderColor: 'rgba(255, 99, 132, 1)',
                tension: 0.1
            }
        ]
    };

    return (
        <div className="progress-container">
            <h2>Your Fitness Progress</h2>

            <div className="progress-summary">
                <h3>Progress Over Time</h3>
                <Line data={chartData} />
            </div>

            <h3>Weigh-ins</h3>
            <div className="weigh-ins">
                <table>
                    <thead>
                    <tr>
                        <th>Date</th>
                        <th>Weight</th>
                        <th>Body Fat %</th>
                    </tr>
                    </thead>
                    <tbody>
                    {progressData.weighIns.map((weighIn, index) => (
                        <tr key={index}>
                            <td>{new Date(weighIn.date).toLocaleDateString()}</td>
                            <td>{weighIn.weight} kg</td>
                            <td>{weighIn.bodyFat} %</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default Progress;
