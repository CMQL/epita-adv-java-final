const express = require('express');
const bodyParser = require('body-parser')
const morgan = require("morgan")
const moviesRoute = require('./routes/movies')
const helmet = require("helmet")
const bcrypt = require("bcrypt")

const session = require('express-session')

const cors=require('cors')


require('./utils/data')

const authRoute=require('./routes/auth')

const app = express()
app.use(morgan('dev'))
app.use(helmet())
app.use(cors({
    credentials: true,
    origin:['http://localhost:3000']
}))


app.use(bodyParser.urlencoded({extended:true}));
app.use(bodyParser.json());


app.use(session({
    path:'/',
    httpOnly:true,
    secure:true,
    maxAge:null,
    secret:'Secret12'
}))

app.use(express.static('public'))

app.use('/api/movies',moviesRoute)
app.use('/api',authRoute)



app.get('/',(req,res)=>{
    res.status(200).json({"msg":"Hello"})
})

app.listen(5000,()=>{
    console.log('Server running on http://localhost:5000');
})