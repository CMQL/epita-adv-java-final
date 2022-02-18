import React, { useContext } from 'react'
import {FaMoon,FaSun} from 'react-icons/fa'

import { ThemeContext } from '../context/themes'

const SwitcherMode = () => {
    const [{theme,isDark},toogleTheme] = useContext(ThemeContext)
    console.log(theme,isDark)
      return (
    <div>
        {isDark ? 
         <FaMoon onClick={toogleTheme}/>
        :
        <FaSun onClick={toogleTheme}/>
        }
    </div>
  )
}

export default SwitcherMode