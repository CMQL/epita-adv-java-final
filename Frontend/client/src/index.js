import ReactDOM from 'react-dom'
import {RecoilRoot} from 'recoil'

import { ThemeProvider } from './context/themes'

import App from './App'
import './index.css'

ReactDOM.render(
    <ThemeProvider>
      <RecoilRoot>
        <App />
      </RecoilRoot>
    </ThemeProvider>,
    document.getElementById('root')
)