import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import './Register.css';

const Register = () => {
    const [formData, setFormData] = useState({
        fullName: '',
        email: '',
        phoneNumber: '',
        passwordHash: '',
        citizenId: '',
        dateOfBirth: '',
        customerType: 'REGULAR',
        isEmailConfirmed: false,
        isDeleted: false,
        role: {
            id: 2 // Default role ID for regular customers
        }
    });
    const [error, setError] = useState('');
    const navigate = useNavigate();

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await axios.post('http://localhost:8080/api/customers/register', formData);
            navigate('/login');
        } catch (error) {
            setError('Registration failed. Please try again.');
        }
    };

    return (
        <div className="register-container">
            <form onSubmit={handleSubmit} className="register-form">
                <h2>Register</h2>
                {error && <div className="error-message">{error}</div>}
                
                <div className="form-group">
                    <label>Full Name:</label>
                    <input
                        type="text"
                        name="fullName"
                        value={formData.fullName}
                        onChange={handleChange}
                        required
                        maxLength={50}
                    />
                </div>

                <div className="form-group">
                    <label>Email:</label>
                    <input
                        type="email"
                        name="email"
                        value={formData.email}
                        onChange={handleChange}
                        required
                        maxLength={100}
                    />
                </div>

                <div className="form-group">
                    <label>Phone Number:</label>
                    <input
                        type="tel"
                        name="phoneNumber"
                        value={formData.phoneNumber}
                        onChange={handleChange}
                        required
                        maxLength={10}
                        pattern="[0-9]{10}"
                    />
                </div>

                <div className="form-group">
                    <label>Password:</label>
                    <input
                        type="password"
                        name="passwordHash"
                        value={formData.passwordHash}
                        onChange={handleChange}
                        required
                        maxLength={250}
                    />
                </div>

                <div className="form-group">
                    <label>Citizen ID:</label>
                    <input
                        type="text"
                        name="citizenId"
                        value={formData.citizenId}
                        onChange={handleChange}
                        pattern="[0-9]*"
                    />
                </div>

                <div className="form-group">
                    <label>Date of Birth:</label>
                    <input
                        type="date"
                        name="dateOfBirth"
                        value={formData.dateOfBirth}
                        onChange={handleChange}
                    />
                </div>

                <div className="form-group">
                    <label>Customer Type:</label>
                    <select
                        name="customerType"
                        value={formData.customerType}
                        onChange={handleChange}
                        required
                    >
                        <option value="REGULAR">Regular</option>
                        <option value="VIP">VIP</option>
                        <option value="PREMIUM">Premium</option>
                    </select>
                </div>

                <button type="submit">Register</button>
            </form>
        </div>
    );
};

export default Register; 