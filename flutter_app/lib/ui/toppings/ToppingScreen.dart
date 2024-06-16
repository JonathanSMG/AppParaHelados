import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: ToppingsScreen(),
    );
  }
}

class ToppingsScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.white,
        elevation: 0,
        leading: IconButton(
          icon: const Icon(Icons.arrow_back, color: Colors.red),
          onPressed: () {},
        ),
        title: const Text('Toppings Screens', style: TextStyle(color: Colors.red)),
      ),
      body: SingleChildScrollView(
        child: Column(
          children: [
            Container(
              color: Colors.red,
              padding: EdgeInsets.all(16.0),
              child: const Row(
                children: [
                  CircleAvatar(
                    radius: 30,
                    backgroundImage: AssetImage('../assets/images/HELADO1.png'),
                  ),
                  SizedBox(width: 10),
                  Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        'Dulce Tropical',
                        style: TextStyle(color: Colors.white, fontSize: 20),
                      ),
                      Text(
                        'Helado de fresa',
                        style: TextStyle(color: Colors.white),
                      ),
                      Row(
                        children: [
                          Text('Mediano Size', style: TextStyle(color: Colors.white)),
                          SizedBox(width: 5),
                          Text('Grande Size', style: TextStyle(color: Colors.white)),
                        ],
                      ),
                    ],
                  ),
                  Spacer(),
                  Icon(Icons.favorite, color: Colors.white),
                ],
              ),
            ),

            //Metodo para contruir el topping. pasandole el nombre y la imagen
            _construirItemTopping('Caramelo', '../assets/images/caramelo.jpg', 15.00),
            _construirItemTopping('Fresas', '../assets/images/fresa.jpg', 10.00),
            _construirItemTopping('Cerezas', '../assets/images/cerezas.jpg', 10.00),

            Padding(
              padding: const EdgeInsets.all(56.0),
              child: ElevatedButton(
                onPressed: () {},
                style: ElevatedButton.styleFrom(
                  backgroundColor: Colors.red,
                  
                  padding: const EdgeInsets.symmetric(vertical: 25.0, horizontal: 10.0), //Regulo el padding del boton, o el tamaño, es lo mismo mor
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(10.0),
                  ),
                ),
                child: const Text(
                  'ORDENAR AHORA',
                  style: TextStyle(color: Colors.white, fontSize: 14, fontWeight: FontWeight.bold),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }

  Widget _construirItemTopping(String title, String imagePath, double price) {
    return Card(
      margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
      child: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Row(
          children: [
            Image.asset(imagePath, width: 50, height: 50, fit: BoxFit.cover),
            SizedBox(width: 16),
            Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(title, style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
                Text('\$$price', style: TextStyle(fontSize: 16)),
              ],
            ),
            Spacer(),
            Row(
              children: [
                IconButton(
                  icon: Icon(Icons.remove_circle, color: Colors.red),
                  onPressed: () {},
                ),
                Text('1', style: TextStyle(fontSize: 18)),
                IconButton(
                  icon: Icon(Icons.add_circle, color: Colors.red),
                  onPressed: () {},
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
