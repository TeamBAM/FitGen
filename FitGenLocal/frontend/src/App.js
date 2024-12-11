import React from 'react';
import './App.css';
import SignUp from './pages/SignUp';
import ExerciseLog from './pages/ExerciseLog';
import FitnessPlan from './pages/FitnessPlan';
import Profile from './pages/Profile';
// import Progress from './pages/Progress';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';

function App() {
    return (
        <div className="App">
            <header className="App-header">
                {/* You can add your header content here */}
            </header>
            <Router>
                <div>
                    {/* Navigation links (use Link for client-side routing) */}
                    <nav>
                        <ul>
                            <li><Link to="/">Sign In</Link></li>
                            <li><Link to="/signup">Sign Up</Link></li>
                            <li><Link to="/fitness-plan">Fitness Plan</Link></li>
                            <li><Link to="/exercise-log">Exercise Log</Link></li>
                            <li><Link to="/profile">Profile</Link></li>
                        </ul>
                    </nav>

                    {/* Define Routes for each page */}
                    <Routes>
                        <Route path="/signup" element={<SignUp />} />
                        <Route path="/fitness-plan" element={<FitnessPlan />} />
                        <Route path="/exercise-log" element={<ExerciseLog />} />
                        <Route path="/profile" element={<Profile />} />
                        {/* Default route (Home or Landing page) */}
                        <Route path="/" element={<SignUp />} />
                    </Routes>
                </div>
            </Router>
        </div>
    );
}

export default App;
