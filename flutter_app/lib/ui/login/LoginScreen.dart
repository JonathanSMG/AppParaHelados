import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:flutter_app/rutas/constants.dart';

class LoginScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // Barra de la aplicación con el título
      appBar: AppBar(
        title: const Text(
          'Heladería Sammy',
          style: TextStyle(
            fontWeight: FontWeight.bold,
            color: Colors.white,
          ),
        ),
        backgroundColor: Color.fromARGB(255, 195, 79, 79),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              // Imagen del pingüino (logo)
              Image.asset(
                'assets/images/logo.png', // Ruta de la imagen en el proyecto
                height: 150,
              ),
              const SizedBox(height: 24),
              // Campo de texto para el correo electrónico
              const TextField(
                decoration: InputDecoration(
                  border: OutlineInputBorder(),
                  labelText: 'Correo electrónico',
                ),
              ),
              const SizedBox(height: 16),
              // Campo de texto para la contraseña
              const TextField(
                obscureText: true, // Para ocultar la contraseña
                decoration: InputDecoration(
                  border: OutlineInputBorder(),
                  labelText: 'Contraseña',
                  suffixIcon: Icon(Icons
                      .visibility_off), // Icono para mostrar/ocultar contraseña
                ),
              ),
              const SizedBox(height: 24),
              // Botón de inicio de sesión
              ElevatedButton(
                onPressed: () {
                  // Acción al presionar el botón
                },
                style: ElevatedButton.styleFrom(
                  backgroundColor: Colors.red, // Color de fondo del botón
                  padding:
                      const EdgeInsets.symmetric(horizontal: 50, vertical: 15),
                ),
                child: const Text(
                  'Iniciar Sesión',
                  style: TextStyle(
                    fontSize: 18,
                    color: Colors.white,
                  ),
                ),
              ),

              const SizedBox(height: 16),
              // Texto para la opción de registro
              RichText(
                text: TextSpan(
                  text: '¿No tienes cuenta? ',
                  style: const TextStyle(color: Colors.black),
                  children: <TextSpan>[
                    TextSpan(
                      text: 'Regístrate',
                      style: const TextStyle(color: Colors.blue),
                      // Acción al presionar 'Regístrate'
                      recognizer: TapGestureRecognizer()
                        ..onTap = () {
                          Navigator.of(context).pushReplacementNamed(REGISTRO);
                        },
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
