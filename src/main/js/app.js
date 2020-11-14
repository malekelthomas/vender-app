import "core-js/stable";
import "regenerator-runtime/runtime";
import React from 'react';
import ReactDOM from 'react-dom';
import Container from './Container';


ReactDOM.render(
    <React.StrictMode>
        <Container/>
    </React.StrictMode>,
    document.getElementById('root')
)
