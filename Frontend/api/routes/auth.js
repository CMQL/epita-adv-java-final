const express = require('express')

const userModel = require('../models/user')

const { validEmail, validPassword } = require('../utils/valid')
//const router = require('./messages')
const bcrypt = require("bcrypt")

let router = express.Router()

router.post('/register',async(req,res)=>{
    try{
        const {email,email_cfg,password,password_cfg,username}=req.body

        const inputDatas=req.body
        console.log(inputDatas)
        
        let errors = {
            email:[],
            email_cfg:[],
            password:[],
            password_cfg:[]
        }

        if(email!==email_cfg){
            errors.email.push("Email confirmation not match")
            errors.email_cfg.push("Email confirmation not match")
        }
        if (password !== password_cfg) {
            errors.password.push("Password confirmation not match")
            errors.password_cfg.push("Password Confirmation not match")
        }

        if(errors.length>0)
        {
            return res.status(500).json(errors)
        }

        errors = validEmail(errors, email)
        errors = validPassword(errors, password)

        if (errors.email.length > 0 || errors.email_cfg.length > 0 || errors.password.length > 0 || errors.password_cfg > 0) {
            return res.status(500).json(errors)
        }

        const saltRounds =10
        const salt = bcrypt.genSaltSync(saltRounds)
        const hash = bcrypt.hashSync(inputDatas.password, salt)

        const user = await userModel.findOne({email: inputDatas.email})

        if(!user)
        {
            await userModel.create({
                email:inputDatas.email,
                password:hash,
                username:inputDatas.username
            })
            return res.status(200).json({msg:"User well created!"})
        }else{
            return res.status(500).json({msg:"User already created!"})
        }

    }catch(error){
        console.error(error)
        return res.status(500).json(error.message)
    }
})

router.post('/login',async(req,res)=>{
    try{
        const {email,password}=req.body
        let errors={
            email:[],
            password:[]
        }

        errors=validEmail(errors,email)
        errors=validPassword(errors,password)
        if(errors.email.length>0 || errors.password.length>0){
            return res.status(500).json(errors)
        }
        const user = await userModel.findOne({email: email})
        if (user) {
            if (bcrypt.compareSync(password, user.password)) {
                req.session.user = user

                return res.status(200).json({msg: "Login success !",user:user})
            } else {
                return res.status(500).json({msg: "Login failed !"})
            }
        } else {
            return res.status(500).json({msg: "Login failed !"})
        }

    }catch(error){
        console.error(error)
        return res.status(500).json(error.message)
    }
})

router.get('/me',(req,res)=>{
    try{
        if(req.session && req.session.user)
        {
            return res.status(200).json(req.session.user)
        }
        else
        {
            return res.status(500).json({msg:"You are not logged"})
        }
    }catch(error)
    {
        console.error(error)
        return res.status(500).json(error.message)
    }
    
})


module.exports=router