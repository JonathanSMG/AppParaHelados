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
          icon: Icon(Icons.arrow_back, color: Colors.red),
          onPressed: () {},
        ),
        title: Text('Topings Screens', style: TextStyle(color: Colors.red)),
      ),
      body: SingleChildScrollView(
        child: Column(
          children: [
            Container(
              color: Colors.red,
              padding: EdgeInsets.all(16.0),
              child: Row(
                children: [
                  CircleAvatar(
                    radius: 30,
                    backgroundImage: AssetImage('assets/fresa.jpg'),
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
            _buildToppingItem('Caramelo', 'assets/caramelo.jpg', 15.00),
            _buildToppingItem('Fresas', 'assets/fresas.jpg', 10.00),
            _buildToppingItem('Cerezas', 'assets/cerezas.jpg', 10.00),
          ],
        ),
      ),
      bottomNavigationBar: BottomAppBar(
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: ElevatedButton(
            onPressed: () {},
            style: ElevatedButton.styleFrom(
              backgroundColor: Colors.red,
              padding: EdgeInsets.symmetric(vertical: 16.0),
              shape: RoundedRectangleBorder(
                borderRadius: BorderRadius.circular(10.0),
              ),
            ),
            child: Text(
              'ORDENAR AHORA',
              style: TextStyle(color: Colors.white, fontSize: 20),
            ),
          ),
        ),
      ),
      
    );
  }

  Widget _buildToppingItem(String title, String imagePath, double price) {
    return Card(
      margin: EdgeInsets.symmetric(horizontal: 16, vertical: 8),
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
