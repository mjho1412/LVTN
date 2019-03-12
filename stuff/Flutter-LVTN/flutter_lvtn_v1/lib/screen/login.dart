import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_lvtn_v1/screen/checkpass.dart';
import 'package:flutter_lvtn_v1/global.dart' as global;

class LoginScreen extends StatefulWidget {
  @override
  _LoginScreenState createState() => new _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  @override
  Widget build(BuildContext context) {
//    return new Scaffold(
//      appBar: new AppBar(
//        title: new Text('LoginScreen'),
//      ),
//      body: new Center(
//        child: RaisedButton(
//          child: Text('Open route'),
//          onPressed: () {
//            Navigator.push(
//              context,
//              MaterialPageRoute(builder: (context) => CheckPassScreen()),
//            );
//          },
//        ),
//      ),
//    );
    void _onReceiveChatMessage(dynamic message) {
      print("Message from UFO: " + message);
    }
  
    return MaterialApp(
      home: DefaultTabController(
        length: 3,
        child: Scaffold(
          appBar: AppBar(
            bottom: TabBar(
              tabs: [
                Tab(icon: Icon(Icons.child_care)),
                Tab(icon: Icon(Icons.crop_square)),
                Tab(icon: Icon(Icons.person)),
              ],
            ),
            title: Text('Tabssss Demo'),
          ),
          body: TabBarView(
            children: [
              Icon(Icons.child_care),
              Icon(Icons.crop_square),
//              Icon(Icons.person),
              new Container(
                  child: new RaisedButton(
                    child:
                    const Text('CONNECT SOCKET 02', style: TextStyle(color: Colors.white)),
                    color: Theme.of(context).accentColor,
                    elevation: 0.0,
                    splashColor: Colors.blueGrey,
                    onPressed: () {
                      global.mSocket.sendMessage("login_kid", "sfdsfsdf");
                    },
                  )
              ),
            ],
          ),
        ),
      ),
    );

  }
}