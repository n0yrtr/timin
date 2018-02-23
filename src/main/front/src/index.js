import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import registerServiceWorker from './registerServiceWorker';

window.renderOnClient =
    function (initialData) {  
        ReactDOM.render(  <App data={initialData} />,
                document.getElementById('root')
        ); };    
registerServiceWorker();
