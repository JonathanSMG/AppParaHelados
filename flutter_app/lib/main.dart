import 'package:flutter/material.dart';
import 'package:flutter_app/constants/constants.dart';
import 'package:flutter_app/ui/SplashScreen.dart';
import 'package:flutter_app/ui/MyHomePage.dart';
import 'package:flutter_app/ui/SignInScreen.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSwatch(primarySwatch: Colors.deepPurple),
        // Otros temas y configuraciones
      ),
      // Definir las rutas de la aplicación
      routes: {
        '/': (context) => SplashScreen(), // Pantalla inicial
        SIGN_IN: (context) =>
            SignInScreen(), // Ejemplo de pantalla de inicio de sesión
        HOME_SCREEN: (context) => MyHomePage(
            title: 'Flutter Demo Home Page'), // Ejemplo de pantalla principal
      },
    );
  }
}
