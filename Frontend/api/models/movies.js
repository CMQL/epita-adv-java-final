
const mongoose =require('mongoose')

const movieSchema = new mongoose.Schema({
    autor: {
        type: mongoose.Types.ObjectId,
        ref:"User",
        required: true
    },
    title: {
        type: String,
        required: true
    },
    added:{
        type: Date,
        required: true
    },
    external_id:{
        type:String,
        required: false
    }
  });

  module.exports = mongoose.model('Movie',movieSchema)