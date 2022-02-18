import React,{useState,useEffect} from 'react'
import axios from 'axios'
import {Link, useNavigate} from 'react-router-dom'
const RegisterForm = () => {
    let navigate = useNavigate()

    const [form,setForm] = useState({
        email:'',
        email_cfg:'',
        password:'',
        password_cfg:'',
        username:''
    })
    const handlerOnChange=(event)=>{
        const {name,value}=event.target
        setForm({...form,[name]:value})
    }   

    const handlerOnSubmit=async(event)=>{
        event.preventDefault()
        try {
            await axios.post(`${process.env.REACT_APP_API_URL}/register`,form)
            navigate('/login')
            //console.log(res.data)
        } catch (error) {
            console.log(error.response.data)
        }
    }
    return (
        <form onSubmit={handlerOnSubmit}>
        <div>
            <label htmlFor='username'>Your username</label>
            <input
                type='username'
                name='username'
                value={form.username}
                placeholder='Enter your username'
                onChange={handlerOnChange}
                required={true}
                />
        </div>
        <div>
            <label htmlFor='email'>Your email</label>
            <input
                type='email'
                name='email'
                value={form.email}
                placeholder='Enter your email'
                onChange={handlerOnChange}
                required={true}
                />
        </div><div>
            <label htmlFor='email_cfg'>Your email_cfg</label>
            <input
                type='email_cfg'
                name='email_cfg'
                value={form.email_cfg}
                placeholder='Enter your email_cfg'
                onChange={handlerOnChange}
                required={true}
                />
        </div><div>
            <label htmlFor='password'>Your password</label>
            <input
                type='password'
                name='password'
                value={form.password}
                placeholder='Enter your password'
                onChange={handlerOnChange}
                required={true}
                />
        </div><div>
            <label htmlFor='password_cfg'>Your password_cfg</label>
            <input
                type='password_cfg'
                name='password_cfg'
                value={form.password_cfg}
                placeholder='Enter your password_cfg'
                onChange={handlerOnChange}
                required={true}
                />
        </div>
        <div>
            <button type='submit'>Create the user</button>
        </div>
        <div>
            <Link to="/login">Already have an account ?</Link>
        </div>
        </form>
    )
}

export default RegisterForm
