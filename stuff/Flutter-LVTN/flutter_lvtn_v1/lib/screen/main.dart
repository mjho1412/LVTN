// This sample shows adding an action to an [AppBar] that opens a shopping cart.

import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter_lvtn_v1/screen/login.dart';
import 'package:flutter_lvtn_v1/socket/flutter_socket_io.dart';
import 'package:flutter_lvtn_v1/socket/socket_io_manager.dart';
import 'package:flutter_lvtn_v1/global.dart' as global;

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Code Sample for material.AppBar.actions',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: new SplashScreen(),
      routes: <String, WidgetBuilder>{
        '/HomeScreen': (BuildContext context) => new LoginScreen()
      },
    );
  }
}

class SplashScreen extends StatefulWidget {

  @override
  _SplashScreenState createState() => new _SplashScreenState();
}

class _SplashScreenState extends State<SplashScreen> {


  startTime() async {
    connectToServer();
    _subscribes();
    var _duration = new Duration(seconds: 4);
    return new Timer(_duration, navigationPage);
  }

  void navigationPage() {
    Navigator.of(context).pushReplacementNamed('/HomeScreen');
  }

  @override
  void initState() {
    super.initState();
    startTime();
  }

  connectToServer() {
    //update your domain before using
    /*socketIO = new SocketIO("http://127.0.0.1:3000", "/chat",
        query: "userId=21031", socketStatusCallback: _socketStatus);*/
    global.mSocket = SocketIOManager().createSocketIO("http://192.168.1.102:3003", "", query: "userId=21031", socketStatusCallback: _socketStatus);

    //call init socket before doing anything
    global.mSocket.init();

    //subscribe event
    global.mSocket.subscribe("socket_info", _onSocketInfo);

    //connect socket
    global.mSocket.connect();
  }

  _socketStatus(dynamic data) {
    print("Socket status: " + data);
  }

  _onSocketInfo(dynamic data) {
    print("Socket info: " + data);
  }

  void _onReceiveChatMessage(dynamic message) {
    print("Message from UFO: " + message);
  }

  _subscribes() {
    if (global.mSocket != null) {
      global.mSocket.subscribe("abc", _onReceiveChatMessage);
    }
  }

  @override
  Widget build(BuildContext context) {
    var assetsImage = new AssetImage('assets/image/logo.png');
    var assetsBackground = new AssetImage('assets/image/background_1.jpg');
    return new DecoratedBox(
        decoration: BoxDecoration(
          image: DecorationImage(image: assetsBackground, fit: BoxFit.cover),
        ),
        child: new Container(
          margin: const EdgeInsets.only(bottom:50.0),
          child: Image(image: assetsImage,width: 300.0,height: 200.0)
        ),
    );
  }
}

//class MyStatelessWidget extends StatelessWidget {
//  MyStatelessWidget({Key key}) : super(key: key);
//
//  @override
//  Widget build(BuildContext context) {
//    return Scaffold(
//      appBar: AppBar(
//        title: Text('Hello World'),
//        actions: <Widget>[
//          IconButton(
//            icon: Icon(Icons.shopping_cart),
//            tooltip: 'Open shopping cart',
//            onPressed: () {
//              // ...
//            },
//          ),
//        ],
//      ),
//    );
//  }
//}
