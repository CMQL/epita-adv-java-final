import React, { useState } from 'react'

const TestForm=()=>{
    const [form, setForm]=useState({
        input:'',
        f2:''

    })
    //const [f2, setInputValue2]=useState('')

    const handlerOnChange=(event)=>{
        const {value,name}=event.target
        console.log(name,value)
        setForm({...form,[name]: value})
    }
    
    const handlerOnSubmit=(event)=>{
        event.preventDefault()
        console.log(form)

    }

    /*const handlerOnListAnimals=(event)=>{
        event.preventDefault()
        
    }*/
    
    return (
        <form onSubmit={handlerOnSubmit}>
            <label htmlFor='test'>enter?</label>
            <input onChange={handlerOnChange} id ='test' type="text" value ={form.input} name="input" placeholder='Enter sth'/>
            <label htmlFor='field2'>Second</label>
            <input onChange={handlerOnChange} id ='f2' type="text" value ={form.f2} name="f2" placeholder='Enter sth'/>

            <input type="submit" value="send"/>
            <button type='submit'>Send 2</button>


        </form>
    )
}

export default TestForm