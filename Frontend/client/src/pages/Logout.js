import axios from 'axios'
import React, { useEffect } from 'react'
import {useRecoilState} from "recoil"
import { useNavigate } from 'react-router-dom'

import userState from '../atoms/userAtom'

const Logout = () => {
    let navigate = useNavigate()
    const [user, setUser] = useRecoilState(userState)

    useEffect(()=>{
        const logout=async()=>{
            console.log('logout')
            if(user.isAuth)
            {
                await axios.get(`${process.env.REACT_APP_API_URL}`)
                setUser({
                    isAuth:false,
                    user:null
                })
            }
            
        }

    })
    return ('')
    
}

export default Logout
