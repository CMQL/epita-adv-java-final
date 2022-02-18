import React from 'react';
import { atom } from 'recoil';

const moviesState=atom({
    key: 'moviesState',
    default: [],
})



export default moviesState;
