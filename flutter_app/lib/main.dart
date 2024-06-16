import 'package:flutter/material.dart';
import 'package:flutter_app/rutas/constants.dart';
import 'package:flutter_app/ui/SplashScreen.dart';
import 'package:flutter_app/ui/user/HomeUserScreen.dart';
import 'package:flutter_app/ui/login/LoginScreen.dart';
import 'package:google_fonts/google_fonts.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'App Para Helados',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: const Color.fromARGB(255, 255, 255, 255)), // Utiliza un color semilla
        textTheme: GoogleFonts.montserratTextTheme(
          Theme.of(context).textTheme,
        ),
      ),
      routes: {
        '/': (context) => SplashScreen(),
        LOGIN: (context) => LoginScreen(),
        HOME_USER: (context) => const HomeUserScreen(title: 'App para helados'),
        
      },
    );
  }
}
