const auth=(req,res,next)=>{
    if(req.session && req.session.user){
        next()
    }else{
        return res.this.status(500).json({msg:"you are not prepared."})
    }
}

module.exports=auth