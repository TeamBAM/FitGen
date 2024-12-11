import React, { useState, useEffect } from 'react';
import axios from 'axios';
import '../App.css';

const Profile = () => {
    const [userData, setUserData] = useState({
        firstName: '',
        lastName: '',
        email: '',
        age: '',
        height: '',
        weight: '',
        gender: ''
    });

    const [isEditing, setIsEditing] = useState(false);

    useEffect(() => {
        // Fetch user profile data from the backend
        axios.get('/api/profile')
            .then(response => {
                setUserData(response.data);
            })
            .catch(error => {
                console.error('Error fetching user data:', error);
            });
    }, []);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setUserData({ ...userData, [name]: value });
    };

    const handleSave = () => {
        // Save updated profile data to the backend
        axios.put('/api/profile', userData)
            .then(response => {
                console.log('Profile updated successfully:', response);
                setIsEditing(false);
            })
            .catch(error => {
                console.error('Error updating profile:', error);
            });
    };

    return (
        <div className="profile-container">
            <h2>Profile</h2>
            {isEditing ? (
                <div className="profile-form">
                    <div className="form-group">
                        <label htmlFor="firstName">First Name</label>
                        <input
                            type="text"
                            id="firstName"
                            name="firstName"
                            value={userData.firstName}
                            onChange={handleChange}
                            className="form-control"
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="lastName">Last Name</label>
                        <input
                            type="text"
                            id="lastName"
                            name="lastName"
                            value={userData.lastName}
                            onChange={handleChange}
                            className="form-control"
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="email">Email</label>
                        <input
                            type="email"
                            id="email"
                            name="email"
                            value={userData.email}
                            onChange={handleChange}
                            className="form-control"
                            disabled
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="age">Age</label>
                        <input
                            type="number"
                            id="age"
                            name="age"
                            value={userData.age}
                            onChange={handleChange}
                            className="form-control"
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="height">Height (cm)</label>
                        <input
                            type="number"
                            id="height"
                            name="height"
                            value={userData.height}
                            onChange={handleChange}
                            className="form-control"
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="weight">Weight (kg)</label>
                        <input
                            type="number"
                            id="weight"
                            name="weight"
                            value={userData.weight}
                            onChange={handleChange}
                            className="form-control"
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="gender">Gender</label>
                        <select
                            id="gender"
                            name="gender"
                            value={userData.gender}
                            onChange={handleChange}
                            className="form-control"
                        >
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                            <option value="other">Other</option>
                        </select>
                    </div>
                    <button type="button" onClick={handleSave} className="btn btn-primary">Save Changes</button>
                </div>
            ) : (
                <div className="profile-info">
                    <p><strong>First Name:</strong> {userData.firstName}</p>
                    <p><strong>Last Name:</strong> {userData.lastName}</p>
                    <p><strong>Email:</strong> {userData.email}</p>
                    <p><strong>Age:</strong> {userData.age}</p>
                    <p><strong>Height:</strong> {userData.height} cm</p>
                    <p><strong>Weight:</strong> {userData.weight} kg</p>
                    <p><strong>Gender:</strong> {userData.gender}</p>
                    <button type="button" onClick={() => setIsEditing(true)} className="btn btn-secondary">Edit Profile</button>
                </div>
            )}
        </div>
    );
};

export default Profile;
