import './App.css';
import Navbar from './components/navbar';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import login from './pages/auth/login'; // Login component
import register from './pages/auth/register'; // Register component
import Landing from './components/Landing';
import Personal from './components/Personal'; // Updated casing

function App() {
  return (
    <div className="App">
      <Router>
        <Navbar />
        <Routes>
          <Route path="/" element={<Landing />} />
          <Route path="/home" element={<Home />} />
          <Route path="/personal" element={<Personal />} />
          <Route path="/login" element={<login />} /> 
          <Route path="/register" element={<register />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
