import 'package:flutter/material.dart';
import 'package:flutter_app/rutas/constants.dart';
import 'package:flutter_app/ui/SplashScreen.dart';
import 'package:flutter_app/ui/user/HomeUserScreen.dart';
import 'package:flutter_app/ui/login/LoginScreen.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'App Para Helados',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSwatch(primarySwatch: Colors.brown),
      ),
      routes: {
        '/': (context) => SplashScreen(),
        LOGIN: (context) => LoginScreen(),
        HOME_USER: (context) => const HomeUserScreen(title: 'App para helados'),
      },
    );
  }
}
