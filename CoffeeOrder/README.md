Coffee Order App
A multi-screen coffee ordering web application built using native for the frontend, Java (Servlets) for the backend, and SQLite for persistent cart storage. The application allows users to browse coffee options, customize their orders, and manage a shopping cart — complete with secure login functionality and session handling.
Features
•	• Add-to-cart functionality with local data persistence
•	• User authentication and session management
•	• Responsive UI with multiple views (Menu, Item Detail, Cart, Order Summary)
•	• SQLite integration to retain order history across sessions
•	• RESTful Java-based backend endpoints for structured data flow
Tech Stack
•	• Frontend: React native, HTML5, CSS3
•	• Backend: Java (Servlets)
•	• Database: SQLite (local)
•	• Version Control: Git
Sample Backend Endpoints
•	• POST /api/login – Authenticate users
•	• GET /api/menu – Retrieve available coffee options
•	• POST /api/cart/add – Add selected item to cart
•	• POST /api/order/submit – Submit cart as order
•	• GET /api/order/history – Fetch order history for logged-in user
