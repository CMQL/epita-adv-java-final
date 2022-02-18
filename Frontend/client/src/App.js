
import React,{useContext} from 'react'
import {BrowserRouter,Route, Routes} from 'react-router-dom'
import { ThemeContext } from './context/themes'
import Home from './pages/Home'
import Login from './pages/Login'
import Register from './pages/Register'
import Logout from './pages/Logout'
import Default from './layouts/Default'
import Movies from './pages/Movies'
import Users from './pages/Users'

export const App = () => {
  const [{theme}]=useContext(ThemeContext)

  return(<BrowserRouter>
      <div>
          <Routes>
            <Route path="/" element={<Default><Home /></Default>} />
            <Route path='/users' element={<Default><Users/></Default>}/>
            <Route path='/movies' element={<Default><Movies/></Default>} />
            <Route path="/login" element={<Default><Login /></Default>}/>
            <Route path="/register" element={<Default><Register /></Default>}/>
            <Route path='/logout' element={<Default><Logout /></Default>} />
          </Routes>
      </div>
  </BrowserRouter>)

}

export default App
