import React from 'react';
import './App.css';
import SignUp from './pages/SignUp';
import './App.css';
import {BrowserRouter as Router,Routes, Route} from "react-router-dom";

function App() {
  return (
    <div className="App">
      <header className="App-header">
      </header>
      <Router>
        <Routes>
          <Route path="/" element={<SignUp />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
