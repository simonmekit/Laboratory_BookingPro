# Capstone project - Laboratory Booking System

## Description
This project is a Laboratory Booking System built using Spring Boot, Hibernate, Spring Data JPA, and RESTful services. It provides functionalities for users to book appointments, view booking information, update profiles, and more. The system is designed to efficiently manage laboratory bookings and streamline the booking process.

## Tech Stack
- Core Java
- Spring Boot
- Hibernate
- Spring Data JPA
- RESTful Services
- MySQL Server 8.0
- HTML5
- CSS
- JavaScript
- Thymeleaf

## Project Structure
- **aspect:** Logging request/response results to a file.
- **configuration:** Project-related configurations.
- **controller:** Controllers for handling HTTP requests.
- **dto:** Data transfer objects.
- **repository:** Database operation-related classes.
- **services:** Business logic implementation classes.
- **resources:** Contains static resources, styles, scripts, and HTML templates.

## CRUD Operations
CRUD operations are demonstrated in the `UserRepositoryImpl` class.

## REST Web Services
RESTful web services are implemented in the `BookingRestController` class.

## Version Information
- **Java:** Amazon Corretto version 18.0.2
- **Build System:** Maven
- **Style Files:** Bootstrap versions 4.5.2 and 5.3.0
- **Database:** MySQL Server 8.0

## Accessing Views and Pages
The following endpoints are used to access functionalities of the Laboratory Booking System:
- **Login Page:** `/login`
- **Signup Page:** `/register`
- **Home Page:** `/home`
- **Update Profile:** `/profile`
- **Book Appointment:** `/booking`
- **Booking Information:** `/viewBookings`

## Menu Navigations
- **Services:** Contains sub-menus for signup, update profile, and book appointment pages.
- **Bookings:** Access booking information.

Feel free to explore the project and its functionalities using the provided endpoints and menu navigations. If you encounter any issues or have suggestions for improvement, please don't hesitate to contact the project team.
