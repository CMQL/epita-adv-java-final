const express = require("express")
const movie = require("../models/movies")
const multer=require("multer")
const path = require("path")

const movieModel=require('../models/movies')
const auth = require('../middlewares/auth')

let router = express.Router()

let movies = []

const storage=multer.diskStorage({
    destination:"./public/",
    filename:function(req,file,cb){
        cb(null,"IMAGE-"+Date.now()+path.extname(file.originalname))
    }
})

const upload=multer({
    storage,
    limits:{fileSize:1000000}
    })

router.get('/',auth,async(req,res)=>{
    try{
        if(req.session && req.session.user){
            movies=await movieModel.find({
                autor:req.session.user._id
            }).populate({path:'autor',select:'username email'})
            return res.status(200).json(movies)
        }else{
            return res.status(500).json('You are not connected !')
        }

    }catch(error){
        console.error(error)
        return res.status(500).json(error.message)
}
})

router.get('/:movieId',auth,async (req,res)=>{
    try{
        if(req.session && req.session.user)
        {
            let movie=movieModel.findOne({
                _id:req.params.movieId,
                autor:req.session.user._id
            }).populate({path:'autor',select:'username email'})
            return res.status(200).json(movie)
        }else{
            return res.status(500).json('You are not connected !')
        }

    }catch(error){
        console.error(error)
        return res.status(500).json(error.message)
    }
})

router.post('/',auth,upload.single('picture'),async(req,res)=>{
    try{
        if(!req.session.user){
            return res.status(500).json({msg: "You have to login to add movie !"})
        }



        const {content} = req.body

        console.log(req.body)
        if(req.file){
            picture=req.file.filename
        }else{
            picture=null
        }

        let movie=await movieModel.create({
            content:content,
            picture:picture,
            autor:req.session.user._id
        })

        await movie.populate({path:'autor',select:'username email'})

        return res.status(200).json(movie)
    }catch(error){
        console.error(error)
        return res.status(500).json(error.message)
    }
})

router.post('/:movieId',auth,upload.single('picture'),async(req,res)=>{
    try {
        if(!req.session.user){
            return res.status(500).json({msg: "You have to login to add movie !"})
        }
        const {content} = req.body
        console.log(req.body)
        if(req.file){
            picture=req.file.filename
        }else{
            picture=null
        }

        let movie=await movieModel.create({
            content:content,
            picture:picture,
            autor:req.session.user._id
        })

        await movie.populate({path:'autor',select:'username email'})

        return res.status(200).json(movie)
    } catch (error) {
        
    }
})
router.put('/:movieId',auth,upload.single('picture'),async (req,res)=>{
    try{
        if(!req.session.user)
        {
            return res.status(500).json({msg:"You have to login to modify this movie !"})
        }
        const {content} = req.body
        if(req.file){
            picture=req.file.filename
        }else{
            picture=null
        }

        let movie =await movieModel.findOneAndUpdate({
            _id: req.params.movieId,
            autor:req.session.user._id
        },
        {content:content,
            picture:picture,},
        {new:true})
        .populate({path:'autor',select:'username email'})
        return res.status(200).json(movie)
    }catch(error){
        console.error(error)
        return res.status(500).json(error.message)
    }
})

router.delete('/:movieId',auth,async(req,res)=>{
    try{
        if(!req.session.user)
        {
            return res.status(500).json({msg:"You have to login to delete this movie !"})
        }

        await movieModel.findOneAndDelete({
            _id:req.params.movieId,
            autor:req.session.user._id
        })

        return res.status(200).json({msg:"movie deleted!"})

    }catch(error){
        console.error(error)
        return res.status(500).json(error.message)
    }
})

module.exports = router
