import React,{useEffect,useState} from 'react'
import axios from 'axios'

const Fact = () => {
    const [fact,setFact] =useState(null)
    const getRandomFact =async()=>{
        const res =await axios.get('https://api.chucknorris.io/jokes/random')
        console.log(res.data.value)
        setFact(res.data.value)

    }
    useEffect(()=>{
        
        getRandomFact()
        
    },[])

    return (
        <div id='fact-container'>
            {!fact &&<>Loading...</>}
            {fact && <div class="fact">{fact}</div>}    
        </div>
    )
}

export default Fact
