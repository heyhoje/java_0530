import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';

// ReactDOM.render("요소", root)랑 밑에 두줄이랑 같은 역할 함.
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <App />
);