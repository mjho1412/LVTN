const express = require('express'),
http = require('http'),
app = express(),
server = http.createServer(app),
io = require('socket.io').listen(server);


app.get('/', (req, res) => {
  res.send('Mjho Server(web) is running on port 3003')
});

server.listen(3003,()=>{
  console.log('Mjho Server(app) is running on port 3003');
});



io.on('connection', (socket) => {

  console.log('A new user has just connected , id : '+socket.id);
  socket.emit('abc',"Testing");

  // Functions and variables here

  users = []

  function checkLogin(username, password) {

    var picked = users.find(o => o.username === username);
    return picked.password == password
  }

  function checkUser(username) {

    return users.find(o => o.username === username);
  }

  // Events here

  socket.on('login_kid', function (kidUsername, kidPassword) {

    console.log(kidUsername+' attempted to login with password : '+kidPassword +" ...");
    socket.emit('abc',"Testing");
  });

  socket.on('create_account', function (username, password) {

    console.log(username+' attempted to create acconunt with password : '+password +" ...");

    if(checkUser(username)) {

      console.log('User '+username+' already taken.');
    } else {

      users.push(new User(username, password));
      console.log(username+' successfully created !!!');
    }

    socket.emit('create_account_response',checkUser(username));
  });

  // socket.on('join', function(userNickname) {

  //         console.log(userNickname +" : has connected "  );

  //         socket.broadcast.emit('userjoinedthechat',userNickname +" : has joined the chat ");
  //     });

  // socket.on('messagedetection', (senderNickname,messageContent) => {
  //        console.log(senderNickname+" :" +messageContent)
  //        let  message = {"message":messageContent, "senderNickname":senderNickname}
  //           // send the message to the client side  
  //        io.emit('message', message );
       
  //       });
        
    
   socket.on('disconnect', function() {

      console.log( 'A user has just left ')
      socket.broadcast.emit("userdisconnect"," user has left ") 
  });



});


function User(username, password) {

    this.username = username;
    this.password = password;
}




