## Flowchart för interaktion mellan klasser

### Version 1.1 Save data
Two different approaches
note* City could use the Factory pattern
```mermaid
flowchart TD

    menu[Menu]
    city[City]
    api[SmhiApi]
    MongoDBFasad[MongoDBFasad]
    MongoDB[MongoDB]
    weather[Weather]
    
menu -->|String city name|city -->|lon, lat| api -->|JSON| weather --> |object|Menu --> MongoDBFasad --> MongoDB

```
### Version 1.1 Display data
note* printing of data with separate class
```mermaid
flowchart TD
    menu[Menu]
    MongoDBFasad[MongoDBFasad]
    MongoDB[MongoDB]
    weather[Weather]
    present[Print data]
    
    menu --> MongoDBFasad --> MongoDB --> weather --> menu --> present
```

### Legacy not how we will solve it 
```mermaid
flowchart TD
    menu[Menu]
    city[City]
    api[SmhiApi]
    doc[JsonToDoc]
    MongoDBFasad[MongoDBFasad]
    MongoDB[MongoDB]
    weather[Weather]
    present[????]
menu --> city -->|lon, lat| api -->|JSON| doc -->|Doc| MongoDBFasad -->|Doc| MongoDB --> weather -->|Object| present
```