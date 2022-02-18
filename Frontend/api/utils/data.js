const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost:27117/moviesystem',
    {},
    (error)=>{
        if(error) throw error
        console.log('Mongodb connected !')
    })
