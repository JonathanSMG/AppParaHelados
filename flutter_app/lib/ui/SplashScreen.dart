import 'dart:async';
import 'package:flutter/material.dart';
import 'package:flutter_app/constants/constants.dart'; // Asegúrate de importar tus constantes

class SplashScreen extends StatefulWidget {
  @override
  _SplashScreenState createState() => _SplashScreenState();
}

class _SplashScreenState extends State<SplashScreen>
    with SingleTickerProviderStateMixin {
  late AnimationController animationController;
  late Animation<double> animation;

  @override
  void initState() {
    super.initState();

    animationController = AnimationController(
      vsync: this,
      duration: const Duration(seconds: 2),
    );

    animation = CurvedAnimation(
      parent: animationController,
      curve: Curves.easeOut,
    );

    animationController.forward();

    Future.delayed(const Duration(seconds: 3), () {
      Navigator.of(context).pushReplacementNamed(LOGIN);
    });
  }

  @override
  void dispose() {
    animationController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Column(
              children: [
                ClipOval(
                  child: Container(
                    width: 250,
                    height: 250,
                    decoration: BoxDecoration(
                      border: Border.all(
                        color: Colors.black,
                        width: 3,
                      ),
                    ),
                    child: Image.asset(
                      'assets/images/logo.png',
                      fit: BoxFit.cover,
                    ),
                  ),
                ),
                const SizedBox(
                    height: 10), // Espacio entre la imagen y el primer texto
                const Text(
                  '¡Heladería Sammy!',
                  style: TextStyle(
                    fontSize: 28, // Aumenta el tamaño del primer texto a 28
                    fontWeight: FontWeight.bold,
                    color: Color.fromARGB(255, 75, 40, 190),
                  ),
                ),
                const SizedBox(height: 5), // Espacio entre los textos
                const Text(
                  '¡Bienvenido!',
                  style: TextStyle(
                    fontSize: 20, // Tamaño del segundo texto
                    color: Colors.black,
                  ),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
