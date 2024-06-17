import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(
        primarySwatch: Colors.red,
      ),
      home: AdminPage(),
    );
  }
}

class AdminPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.red,
        title: const Text('Administrador'),
          centerTitle: true,


      ),
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.end,
            children: [
               const Row(
                mainAxisAlignment: MainAxisAlignment.end,
                children: [
                  Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text('Welcome,', style: TextStyle(color: Color.fromARGB(255, 0, 0, 0), fontSize: 16)),
                      Text('ZAVALA REYES', style: TextStyle(color: Color.fromARGB(255, 2, 0, 0), fontSize: 20, fontWeight: FontWeight.bold)),
                    ],
                  ),
                  SizedBox(width: 10),
                  CircleAvatar(
                    radius: 30,
                    backgroundImage: AssetImage('../assets/images/fotoperfil.jpg'),
                  ),
                ],
              ),
              const SizedBox(height: 20),
              _buildSectionTitle('SABORES', context),
              _buildItemList('Chocolate', '../assets/images/chocolate.jpg'),
              _buildItemList('Vainilla', '../assets/images/vainilla.jpg'),
              _buildItemList('Fresa', '../assets/images/fresa.jpg'),
              const SizedBox(height: 20),
              _buildSectionTitle('TOPPINGS', context),
              _buildItemList('Granola', '../assets/images/granola.jpg'),
              _buildItemList('Galleta Triturada', '../assets/images/galleta.jpg'),
              _buildItemList('Coco', '../assets/images/coco.jpg'),
            ],
          ),
        ),
      ),
      bottomNavigationBar: BottomNavigationBar(
        items: const <BottomNavigationBarItem>[
          BottomNavigationBarItem(
            icon: Icon(Icons.home),
            label: 'Home',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.inbox),
            label: 'Inbox',
          ),
        ],
        selectedItemColor: Colors.amber[800],
      ),
    );
  }

  Widget _buildSectionTitle(String title, BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 16.0),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          Text(
            title,
            style: const TextStyle(
              fontSize: 24,
              fontWeight: FontWeight.bold,
              color: Colors.red,
            ),
          ),
          IconButton(
            icon: const Icon(Icons.add_circle, color: Colors.yellow),
            onPressed: () {},
          ),
        ],
      ),
    );
  }

  Widget _buildItemList(String title, String imagePath) {
    return Card(
      margin: const EdgeInsets.symmetric(vertical: 8),
      child: ListTile(
        leading: Image.asset(imagePath, width: 50, height: 50, fit: BoxFit.cover),
        title: Text(title, style: const TextStyle(fontWeight: FontWeight.bold)),
        trailing: Row(
          mainAxisSize: MainAxisSize.min,
          children: [
            TextButton(
              onPressed: () {},
              child: const Text('EDITAR', style: TextStyle(color: Colors.red)),
            ),
            TextButton(
              onPressed: () {},
              child: const Text('ELIMINAR', style: TextStyle(color: Colors.red)),
            ),
            IconButton(
              icon: const Icon(Icons.favorite, color: Colors.red),
              onPressed: () {},
            ),
          ],
        ),
      ),
    );
  }
}
