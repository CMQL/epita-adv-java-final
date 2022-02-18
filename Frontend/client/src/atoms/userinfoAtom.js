import React from 'react';
import { atom } from 'recoil';

const userinfoState=atom({
    key: 'usersState',
    default: [],
})

export default userinfoState;
