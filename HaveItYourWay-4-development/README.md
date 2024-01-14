# HaveItYourWay-4
# Vår väderapplikation

Detta projekt innefattar utveckling av en Java-baserad väderapplikation. Applikationen använder SMHI:s öppna API för att hämta väderprognoser för olika städer i Sverige och lagrar dessa i en MongoDB-databas för snabb och effektiv åtkomst.

## Bibliotek och verktyg

Följande bibliotek och verktyg används i detta projekt:

- [Fasterxml.jackson.core.databind](https://github.com/FasterXML/jackson-databind): Används för att underlätta konverteringen mellan Java-objekt och JSON.
- [MongoDB Java Driver](https://mongodb.github.io/mongo-java-driver/): Används för att kommunicera med MongoDB-databasen.
- [org.json:json:20230227](https://mvnrepository.com/artifact/org.json/json): Används för att hantera JSON-data inom projektet.
- [org.mongodb:mongodb-jdbc:2.0.2](https://mvnrepository.com/artifact/org.mongodb/mongodb-jdbc/2.0.2): Används för att koppla upp Java-applikationen till MongoDB.
- [Github.lbovolini.ObjectMapper](https://github.com/lbovolini/object-mapper): Används för att kartlägga fälten mellan objekt.

## Förutsättningar

För att vår applikation ska fungera korrekt behöver följande vara uppfyllt:

- Java OpenJDK 20 måste vara installerat
- Tillgång till internet är nödvändig för att kunna hämta data från SMHI:s API
- En fungerande MongoDB-instans behövs för att lagra och hämta väderinformation

## Datakällor och nycklar

Applikationen använder sig av SMHI:s öppna API. Ingen API-nyckel behövs för att använda denna tjänst.

För databaslagring används MongoDB. Du behöver en MongoDB-anslutningssträng för att koppla upp mot din databasinstans. För mer information om hur du skapar en anslutningssträng, se [MongoDB:s dokumentation](https://docs.mongodb.com/manual/reference/connection-string/).

## Ytterligare resurser

- [Trello board for project](https://trello.com/b/8jvFPl0x/api-databaer)
- [Parameter table Meteorological Forecasts](https://opendata.smhi.se/apidocs/metfcst/parameters.html)


Applikationen lagrar och bearbetar information om väderprognoser för olika platser, vilket ger användarna möjlighet att se den aktuella väderprognosen, samt tidigare väderdata.

Programmet använder MongoDB som databas för lagring av data om väderprognoser. Detta möjliggör effektiv lagring, återhämtning och bearbetning av väderdata.
