import { createContext, useState,useEffect } from "react";

export const ThemeContext = createContext()

const themes={
    dark:{
        backgroundColor:"black",
        color:'white'
    },
    light:{
        backgroundColor:"White",
        color:"black"
    }
}

export const ThemeProvider=({children}) => {
    const [isDark,setIsDark]=useState(false)
    const theme=isDark ? themes.dark : themes.light

    const toogleTheme =()=>{
        localStorage.setItem("isDark",JSON.stringify(!isDark))
        setIsDark(!isDark)
    }

    useEffect(() => {
        const isDark = localStorage.getItem('isDark')==="true"
        setIsDark(isDark)
    }, [])

    return <ThemeContext.Provider value={[{theme,isDark}, toogleTheme]}>
        {children}
    </ThemeContext.Provider>
}