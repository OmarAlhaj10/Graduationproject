# Fitness and Nutrition Coaching Platform

<div align="center">
  <h3>A comprehensive web platform for diet recommendations, exercise planning, and fitness coaching</h3>
</div>

## 📋 Project Overview

This graduation project is a full-featured fitness and nutrition coaching platform that connects trainees with coaches and provides AI-powered diet recommendations. The system consists of multiple integrated components that work together to provide a complete solution for fitness enthusiasts and professionals.

### Key Features

- **AI-Powered Diet Recommendations**: Generate personalized diet plans based on user metrics
- **Exercise Planning**: Coaches can create and assign custom exercise routines to trainees
- **User Management**: Complete user authentication and profile management
- **Community Platform**: Social features allowing users to share posts and interact
- **Progress Tracking**: Tools for monitoring fitness and nutrition progress

## 🏗️ System Architecture

The project consists of several integrated components:

### 1. Diet Recommendation System

A content-based recommendation system that generates personalized diet plans based on user metrics (height, weight, age, etc.) and nutritional requirements.

- **Frontend**: Streamlit web application
- **Backend**: FastAPI service with machine learning model
- **Features**: BMI calculation, calorie estimation, meal planning

### 2. Gym Management System

A Java Spring Boot application for managing trainer-user relationships, exercise routines, and workout tracking.

- **Features**: User authentication, routine management, exercise assignment, measurement tracking
- **Technologies**: Java Spring Boot, Spring Security, JPA, Thymeleaf, MySQL

### 3. Community Blog

A platform for users to share posts, tips, and progress updates with the community.

- **Frontend**: React with TypeScript and Vite
- **Backend**: Spring Boot REST API

## 🔧 Technologies Used

### Backend
- Java Spring Boot
- FastAPI (Python)
- MySQL Database
- Postgresql Database
- Machine Learning (scikit-learn)

### Frontend
- Streamlit (Python)
- React with TypeScript
- Thymeleaf
- Bootstrap

### DevOps
- Docker & Docker Compose
- Git version control

## 🚀 Installation and Setup

### Prerequisites
- Docker and Docker Compose
- Java JDK 20
- Python 3.10+
- Node.js and npm
- MySQL

### Diet Recommendation System

1. Navigate to the Diet Recommendation System directory:
   ```bash
   cd Diet-Recommendation-System-main
   ```

2. Start the application using Docker Compose:
   ```bash
   docker-compose up -d --build
   ```

3. Access the application at http://localhost:8501

### Gym Management System

1. Navigate to the Gym Management System directory:
   ```bash
   cd Gym-Management-System-Java-Spring-Boot-main
   ```

2. Import the database dump:
   ```bash
   mysql -u root -p < "Database Script.sql"
   ```

3. Configure database permissions:
   ```sql
   CREATE USER 'admin_proyecto'@'localhost' IDENTIFIED BY 'admin_clave';
   GRANT ALL PRIVILEGES ON gymapp.* TO 'admin_proyecto'@'localhost';
   FLUSH PRIVILEGES;
   ```

4. Build and run the application:
   ```bash
   mvn clean install
   java -jar target/application.jar
   ```

5. Access the application at http://localhost:80

### Blog System

1. Navigate to the blog directory:
   ```bash
   cd blog
   ```

2. Start the backend:
   ```bash
   mvn spring-boot:run
   ```

3. Navigate to the frontend directory and install dependencies:
   ```bash
   cd blog-frontend-v2/blog
   npm install
   ```

4. Start the frontend development server:
   ```bash
   npm run dev
   ```

5. Access the blog at http://localhost:5173

## 📊 Use Cases

### For Trainees
- Register and create a profile
- Generate AI-powered diet recommendations based on personal metrics
- Subscribe to coaches for personalized exercise plans
- Track progress and measurements
- Share posts and interact with the community

### For Coaches
- Manage assigned trainees
- Create and modify exercise plans for trainees
- View trainee progress
- Share expertise through community posts

## 📝 Project Documentation

Additional documentation can be found in the following locations:
- System diagrams: `/Diagrams`
- API documentation: Available through Swagger UI when running the respective services
- Component-specific documentation: Available in each component's directory
