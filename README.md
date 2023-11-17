# Vehicle Management System

Welcome to the Vehicle Management System, an Android Java project designed to simplify vehicle organization and information access for users. The system employs Firebase for secure user authentication and real-time database functionality.

## Features

- **User Authentication:**
  - Secure sign-up and login using Firebase Authentication.
  - AuthStateListener for monitoring user authentication status.

- **Explore Nearby Places:**
  - Discover nearby locations, including gas stations, car repair shops, and car wash facilities.
  - Location-based functionality with proper permission handling.

- **Firebase Realtime Database:**
  - Utilizes Firebase Realtime Database for storing and retrieving user account information and potentially vehicle details.
  
- **User Sign Out:**
  - Securely sign out users using the provided functionality.

## Project Structure

- **HomeActivity.java:** Main interface for exploring nearby places and accessing additional features.
- **LoginActivity.java:** Manages user login and redirects to HomeActivity upon successful authentication.
- **SignUpActivity.java:** Handles the user sign-up process and account creation.
- **NearByPlace.java:** Displays information about nearby places based on user preferences.
- **Firebase Integration:** Uses Firebase Authentication for user management and Firebase Realtime Database for data storage.

## Getting Started

1. Clone the repository.
2. Set up your Firebase project and replace the configuration details in the code.
3. Build and run the Android application.

## Future Enhancements

- Implement features for users to manage and track information about their vehicles.
- Include additional user preferences and customization options.
- Enhance the user interface and overall user experience.

## License

This project is licensed under the [MIT License](LICENSE).

Feel free to explore, contribute, and improve the Vehicle Management System!
