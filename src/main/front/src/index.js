import React from 'react';
import ReactDOM from 'react-dom';
import './css/index.css';
import App from './components/App';
import registerServiceWorker from './registerServiceWorker';

window.renderOnClient =
    function (initialData) {  
        ReactDOM.render(  <App data={initialData} />,
                document.getElementById('root')
        ); };    
registerServiceWorker();
