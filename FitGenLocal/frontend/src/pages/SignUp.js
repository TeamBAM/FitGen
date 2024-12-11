import React, { useState } from 'react';
import '../App.css';

const SignUp = () => {
    const [formData, setFormData] = useState({
        firstName: '',
        lastName: '',
        email: '',
    });
    const [error, setError] = useState('');
    const [success, setSuccess] = useState(false);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData((prevData) => ({ ...prevData, [name]: value }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError('');
        setSuccess(false);

        try {
            const response = await fetch('http://localhost:8080/api/users/', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    firstName: formData.firstName,
                    lastName: formData.lastName,
                    email: formData.email,
                    //createdAt: new Date(),
                    //updatedAt: new Date(),
                }),
            });

            if (!response.ok) {
                throw new Error('Failed to create user');
            }

            const result = await response.json();
            setSuccess(true);
            console.log('User created:', result);
        } catch (err) {
            console.error(err);
            setError('An error occurred while creating the user.');
        }
    };

    return (
        <div className="signup-container">
            <h1 className="signup-title">Sign Up</h1>
            <form className="signup-form" onSubmit={handleSubmit}>
                <label htmlFor="firstName">First Name</label>
                <input
                    type="text"
                    id="firstName"
                    name="firstName"
                    value={formData.firstName}
                    onChange={handleChange}
                    required
                />
                <label htmlFor="lastName">Last Name</label>
                <input
                    type="text"
                    id="lastName"
                    name="lastName"
                    value={formData.lastName}
                    onChange={handleChange}
                    required
                />
                <label htmlFor="email">Email</label>
                <input
                    type="email"
                    id="email"
                    name="email"
                    value={formData.email}
                    onChange={handleChange}
                    required
                />
                {error && <p className="error-text">{error}</p>}
                {success && <p className="success-text">User created successfully!</p>}
                <button type="submit" className="signup-button">
                    Sign Up
                </button>
            </form>
        </div>
    );
};

export default SignUp;
