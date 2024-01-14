import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;

public class MongoDB {

    MongoDatabase db;
    MongoCollection< Document > collection;
    String connString;
    String DBName;
    String collectionName;
    MongoClient mongoClient;


    public MongoDB (String DBName, String collectionName) {
        this.DBName = DBName;
        this.collectionName = collectionName;
        setConnString();
        connect();
        deleteOldDoc();
    }

    public MongoDB (){
        this.DBName = "MongoWeather";
        this.collectionName = "weather";
        setConnString();
        connect();
        deleteOldDoc();
    }

    // Set connection string to MongoDB Atlas
    public void setConnString() {
        KeyReader key = new KeyReader();
        this.connString ="mongodb+srv://" + key.getUsr() + ":" + key.getPW() + "@" + key.getAdr();
    }

    // Connect to MongoDB Atlas
    public void connect() {

        try {
            ServerApi serverApi = ServerApi.builder()
                    .version(ServerApiVersion.V1)
                    .build();
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(connString))
                    .serverApi(serverApi)
                    .build();
            close();
            mongoClient = MongoClients.create(settings);
            db = mongoClient.getDatabase(DBName);
            System.out.println("Connected");
            this.collection = db.getCollection(collectionName);
        } catch (MongoException e) {
            System.out.println("Cannot connect!");
            System.out.println(e.getMessage());
        }
    }
    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }

    public void insertOne (Document document) {
        collection.insertOne(document);
    }

    public void insertOne(Weather weather) {
        try {
            Document weatherData = new Document("city", weather.getCity())
                    .append("date", weather.getDate())
                    .append("temperature", weather.getTemperature())
                    .append("wind_direction", weather.getWindDirection())
                    .append("wind_speed", weather.getWindSpeed());
            collection.insertOne(weatherData);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    // Get a list of days for a city
    public ArrayList<Weather> findByCity(String city) {
        try {
            Document query = new Document("city", city);
            FindIterable<Document> result = collection.find(query);
            ArrayList<Weather> weatherList = new ArrayList<>();
            for (Document doc : result) {
                weatherList.add(Weather.fromDocument(doc));
            }
            return weatherList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    // Get object for a city for a day
    public Weather findByCityAndDate(String city, String date) {
        try {
            Document query = new Document("city", city).append("date", date);
            FindIterable<Document> result = collection.find(query);
            Weather weather = null;
            for (Document doc : result) {
                weather = Weather.fromDocument(doc);
                break;
            }
            return weather;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    // get a list of cities for a day
    public ArrayList<Weather> findByDate(String date) {
        try {
            Document query = new Document("date", date);
            FindIterable<Document> result = collection.find(query);
            ArrayList<Weather> weathers = new ArrayList<>();
            for (Document doc : result) {
                weathers.add(Weather.fromDocument(doc));
            }
            return weathers;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void deleteAll() {
        collection.deleteMany(new Document());
    }

    public boolean documentExists(Document document) {
        String date = document.getString("date");
        String city = document.getString("city");
        try {
            Document findInDB = new Document("date", date).append("city", city);
            return collection.find(findInDB).first() != null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public void updateOne(Document document) {
        String date = document.getString("date");
        String city = document.getString("city");
        try {
            Document findInDB = new Document("date", date).append("city", city);
            collection.findOneAndReplace(findInDB, document);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void deleteOldDoc() {
        Dates date = new Dates();
        try {
            Document query = new Document("date", date.previousDay(5));
            collection.deleteMany(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
