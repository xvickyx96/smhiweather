## Entity-Relationship Diagram för databas <br>
Samtlig data ligger i samma collection. <br>
Dokumenten har följande data

``` mermaid
classDiagram
class MongoWeather {
+ _id: ObjectId
+date: String
+time: String
+city: String
+temprature: double
+windDirection: double
+windSpeed: double
+weatherDescription: String
}
```
