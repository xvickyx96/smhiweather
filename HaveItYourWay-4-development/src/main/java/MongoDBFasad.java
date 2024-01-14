import org.bson.Document;

import java.util.ArrayList;
public class MongoDBFasad {

    private MongoDB mongoDB;

    public MongoDBFasad() {
        this.mongoDB = new MongoDB();
    }

    public MongoDBFasad (String DBName, String collectionName) {
        this.mongoDB = new MongoDB(DBName, collectionName);
    }

    public void close() {
        mongoDB.close();
    }

    public void insertOne (Document doc) {
        mongoDB.insertOne(doc);
    }

    public void insertOne(Weather weather) {
        mongoDB.insertOne(weather);
    }

    public ArrayList<Weather> findByCity(String city) {
        return mongoDB.findByCity(city);
    }

    public Weather findByCityAndDate(String city, String date) {
        return mongoDB.findByCityAndDate(city, date);
    }

    public ArrayList<Weather> findByDate(String date) {
        return mongoDB.findByDate(date);
    }
    // Bara för test
    public void deleteAll() {
        mongoDB.deleteAll();
    }
    public boolean documentExists(Document document) {
        return mongoDB.documentExists(document);
    }
    public void updateOne(Document document) {
        mongoDB.updateOne(document);
    }
    public void deleteOldDoc() {
        mongoDB.deleteOldDoc();
    }
}
