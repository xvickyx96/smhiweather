# Weather App with SMHI API and MongoDB

## Description
This application fetches weather data for 10 Swedish cities using the SMHI API and stores the data in a MongoDB database. The application allows users to select a city and view the corresponding weather forecast.

## Features
- Fetches weather data for 10 Swedish cities:
  1. Stockholm
  2. Gothenburg
  3. Malmö
  4. Uppsala
  5. Linköping
  6. Örebro
  7. Västerås
  8. Helsingborg
  9. Norrköping
  10. Borås
- Stores weather data in a MongoDB database.
- Provides a user-friendly menu for selecting cities and displaying weather information.

## Requirements
- Java (version 11 or higher)
- MongoDB (local or cloud instance)
- SMHI API key

## Installation
1. **Clone this repository:**
   ```bash
   git clone https://github.com/your-username/weatherapp.git
   cd weatherapp

2. **Set up MongoDB:**

Ensure MongoDB is installed and running locally or on a cloud service like MongoDB Atlas.
Create the usr.cfg file:

3. **In the project root directory, create a file named usr.cfg with the following content:**
properties

usr=yourMongoDBUsername
pw=yourMongoDBPassword
adr=mongodb://yourMongoDBHost:port/yourDatabaseName
smhiKey=yourSmhiApiKey
Replace the values with your own credentials:
yourMongoDBUsername: Your MongoDB username.
yourMongoDBPassword: Your MongoDB password.
yourMongoDBHost:port/yourDatabaseName: Your MongoDB connection string.
yourSmhiApiKey: Your API key for SMHI.
Compile and run the application:

4. **Use an IDE like IntelliJ IDEA or compile from the command line:**

javac -d target/classes src/main/java/*.java
java -cp target/classes Main
Configuration File (usr.cfg)
The usr.cfg file is required for the application to run. It contains sensitive information like database credentials and API keys. Below is an example of how the file should look:

properties

usr=exampleUser
pw=examplePassword
adr=mongodb://localhost:27017/weatherDB
smhiKey=exampleApiKey
Do not share this file publicly.
Add usr.cfg to your .gitignore file to prevent it from being included in version control.
Error Handling
If the usr.cfg file is missing or incorrectly configured, the application will display an error message and stop running.
Ensure all required fields in usr.cfg are properly set.
Testing
Populate MongoDB with test data if needed.

License
This project is licensed under the MIT License. See the LICENSE file for details.
