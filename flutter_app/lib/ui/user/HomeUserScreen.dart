import 'package:flutter/material.dart';

class HomeUserScreen extends StatefulWidget {
  final String title;

  const HomeUserScreen({Key? key, required this.title}) : super(key: key);

  @override
  _HomeUserScreenState createState() => _HomeUserScreenState();
}

class _HomeUserScreenState extends State<HomeUserScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.redAccent,
        elevation: 0,
        leading: Icon(Icons.menu),
        title: Text(widget.title),
        actions: const [
          CircleAvatar(
            backgroundImage: AssetImage('../assets/images/HELADO1.png'), // Corrige esta línea
          ),
          SizedBox(width: 10),
        ],
      ),
      body: SingleChildScrollView(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Container(
              color: Colors.redAccent,
              padding: EdgeInsets.all(16),
              child: Row(
                children: [
                  const Expanded(
                    child: Text(
                      'Consumete un helado pe\'',
                      style: TextStyle(
                        color: Colors.white,
                        fontSize: 20,
                      ),
                    ),
                  ),
                  ElevatedButton(
                    onPressed: () {},
                    style: ElevatedButton.styleFrom(
                      backgroundColor: Colors.white,
                      foregroundColor: Colors.redAccent,
                    ),
                    child: Text('Order Now'),
                  ),
                ],
              ),
            ),
            IceCreamCard(
              imageUrl: '../assets/images/HELADO1.png', // Corrige esta línea
              title: 'Dulce Tropical',
              description: 'Helado de Fresa',
              price: 'S/. 3.00',
            ),
            IceCreamCard(
              imageUrl: '../assets/images/HELADO2.png', // Corrige esta línea
              title: 'Galaxia Dulce',
              description: 'Helado de Vainilla',
              price: 'S/. 5.00',
            ),
            IceCreamCard(
              imageUrl: '../assets/images/HELADO3.png', // Corrige esta línea
              title: 'Cap de Caramelo',
              description: 'Helado de Chocolate',
              price: 'S/. 6.00',
            ),
          ],
        ),
      ),
      bottomNavigationBar: BottomNavigationBar(
        selectedItemColor: Colors.redAccent,
        items: const [
          BottomNavigationBarItem(
            icon: Icon(Icons.home),
            label: 'Home',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.mail),
            label: 'Ajustes',
          ),
        ],
      ),
    );
  }
}

class IceCreamCard extends StatelessWidget {
  final String imageUrl;
  final String title;
  final String description;
  final String price;

  IceCreamCard({
    required this.imageUrl,
    required this.title,
    required this.description,
    required this.price,
  });

  @override
  Widget build(BuildContext context) {
    return Card(
      margin: EdgeInsets.all(16),
      child: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Row(
          children: [
            Image.asset(
              imageUrl,
              width: 80,
              height: 80,
            ),
            SizedBox(width: 16),
            Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  title,
                  style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
                ),
                Text(description),
                SizedBox(height: 8),
                Text(price),
                Row(
                  children: [
                    ElevatedButton(
                      onPressed: () {},
                      child: Text('Medium Size'),
                    ),
                    SizedBox(width: 8),
                    ElevatedButton(
                      onPressed: () {},
                      child: Text('Large Size'),
                    ),
                  ],
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
