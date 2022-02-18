import React,{useEffect,useState} from 'react'
import axios from 'axios'
import { useRecoilState } from 'recoil'
import userinfoState from'../atoms/userinfoAtom'



const UserForm = () => {
    const [users,setUsers]=useRecoilState(userinfoState)
    //dayjs.extend(relativeTime)


    const getData = async()=>{
      
        //
        //
        //
        //
        //const userres =await axios.get(`localhost:8080/users/${}`,{
        //    withCredentials:true
        //})
        //setUsers(res.data)
        //

        //

        //var adddate=new Date('2019-3-5')
        var userEx=[
            {username: "BLABLA",
            role:"normal",
            userid:"1111111"},
        {
            username:"ALI498",
            role:"special",
            userid:"5551623"
        }]
        //res.data
        setUsers(userEx)
    }

    useEffect(()=>{
        getData()   
    },[])
    






    return <div className='pt-40 w-50 mx-auto'>
        {users.map(user=> <div key={user._id} className='card mb-10 relative'>
            
                <div className='card-body' >
                    <p>{user.username}</p>
                    <p>{user.role}</p>
                    <p className='txt-small txt-right'>-- {user.userid}</p>
                    
                    </div>
                
            </div>)}
    </div>;
}

export default UserForm