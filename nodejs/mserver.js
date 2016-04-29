var seneca = require('seneca')()

seneca.add( {generate:'id', type:'nid'}, function(message,done) {
    done(null,{id:''+"yuchao"})
}).listen()

