import React, {useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useRecoilState } from 'recoil';
import moviesState from '../atoms/moviesAtom'
import relativeTime from 'dayjs/plugin/relativeTime'
import dayjs from 'dayjs'

const Movies = () => {
    const [movies,setMovies]=useRecoilState(moviesState)
    dayjs.extend(relativeTime)
    let navigate=useNavigate()
    const[form,setForm]=useState({content:''})

    

    const handlerOnChange=async(event)=>{
        const {name,value} = event.target
        setForm({...form,[name]:value})
    }

    const handlerGoOnClick = async(event)=>{
        event.preventDefault()

        //var formData=new FormData()
        try {
            /*const res=await axios.get(`localhost:8080/users/${userid}`formData,{
                withCredentials:true,
                headers:{
                    'Content-Type': 'multipart/form-data'
                }})
                //let index = messages.indexOf(message)
                //setMessages([...messages, [0]: res.data])*/
                window.location.href='../users/'
                //windows.location.href=users+'/'+userid
        } catch (error) {
            console.log(error)
        }
    }   
    const handlerSearchOnClick=async(event)=>{
        event.preventDefault()

        console.log("???")

        //var formData=new FormData()
        //formData.append('content',form.content)
//--------------------------------------------
        //const res=await axios.get(`localhost:8080/seenmovies/${form.content}`})
//-----------------------------------------
        var adddate=new Date('2019-3-5')
        var seentoday=[
            {title: "ABC",
            added:adddate,
            external_id:"123"}]
        //res.data
        setMovies(seentoday)
    }


  return (
    <form className='w-50 mx-auto form-bordered'>
      <div className='form-group'>
            <textarea
                name="content"
                value={form.content}
                placeholder='yyyy-mm-dd'
                className='form-textarea'
                onChange={handlerOnChange}
            ></textarea>
        </div>
        <div className='form-group'>
            <button className='btn bg-red-400 txt-white w-100' onClick={handlerSearchOnClick}>
                Get Movies added in the day
            </button>
        </div>
        <div className='pt-40 w-50 mx-auto'>
        {movies.map(movie=> <div key={movie._id} className='card mb-10 relative'>
            <div className='card-body' >
                   <p>{movie.title}</p>
                    <p className='txt-small txt-right'>-- {movie.added.toDateString()}</p>
                    <button className='btn bg-red-400 txt-white w-100' onClick={handlerGoOnClick}>
                        Check who has seen the movie
                    </button>
                    </div>
                
            </div>)}
    </div>;
  </form>
  )
}

export default Movies