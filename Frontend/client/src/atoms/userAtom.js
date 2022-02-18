import {atom} from 'recoil'
const userState=atom({
    key:'userState',
    default:{
        isAuth:false,
        user:null
    },

})

export default userState
