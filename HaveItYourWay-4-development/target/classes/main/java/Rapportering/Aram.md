# MongoDB med SMHI API - Projekt Rapport

## Projektbeskrivning

Detta projekt innefattar utveckling av en Java-baserad väderapplikation. Applikationen använder SMHI:s öppna API för att hämta väderprognoser för olika städer i Sverige och lagrar dessa i en MongoDB-databas för snabb och effektiv åtkomst.

## Planering

Vi använde Trello för att planera och hantera våra uppgifter. Du kan hitta vår Trello-planering [här](https://trello.com/b/8jvFPl0x/api-databaer).

## Utveckling

Under utvecklingen av projektet har vi ansvarat för olika delar:

- Aram: Trello, Weather-klass, README, presentation, UML-diagram.
- Samer: Database, JsontoDoco, uppdatering av dokument.
- Vikram: City-klass, meny.
- Kristian: API, GitHub, inloggning för databas, ER-diagram, skapa databas, metod för utskrift.

Alla har också samarbetat och hjälpt varandra för att få deras respektive klasser att fungera tillsammans och lösa problem som uppstod under utvecklingsprocessen.

## Datatyper

I projektet har vi använt följande datatyper:

- String: Används för att lagra textinformation såsom stadens namn, datum, tid och väderbeskrivning.
- double: Används för att lagra numerisk information såsom temperatur, vindhastighet och vindriktning.
- List: Används för att lagra en samling av objekt av typen Parameter, som representerar olika parametrar för väderprognoser.
- Document: En datatyp som tillhandahålls av MongoDB Java Driver för att representera dokument i MongoDB-databasen. Används för att lagra och hämta väderinformation i databasen.
- URL: En datatyp som används för att representera en URL-adress, vilket är relevant vid hämtning av data från SMHI:s API.

## Vad kunde ha gjorts bättre

Under projektets gång har vi generellt sett hanterat och löst uppgifterna på ett bra sätt. Dock kan vi identifiera ett område där vi skulle kunna ha förbättrat vår arbetsmetod.

En förbättringsmöjlighet är att vara mer proaktiva när det gäller att söka hjälp när vi fastnar eller stöter på problem. Ibland spenderade vi mer tid än nödvändigt genom att försöka lösa problemen på egen hand. Detta resulterade i en förlorad tid på ungefär 5 dagar. Genom att snabbt söka hjälp från lärare eller andra resurser hade vi kunnat övervinna dessa hinder mer effektivt och hålla en mer kontinuerlig framstegstakt i projektet.

Att vara öppen för att be om hjälp och att dra nytta av tillgängliga resurser är en viktig lärdom för framtida projekt. Det skulle hjälpa oss att övervinna svårigheter snabbare och upprätthålla en högre produktivitet.

## Slutsatser

Projektet har varit en givande och lärorik upplevelse där vi har fått tillämpa våra kunskaper inom Java-programmering, databashantering och API-integration. Genom att arbeta med SMHI API och MongoDB har vi fått praktisk erfarenhet av att hämta och hantera väderdata samt lagra den i en databas.

En viktig slutsats är att det är viktigt att ha en välstrukturerad kod med tydliga klasser och metoder. Det underlättar både förståelsen av koden och möjliggör enklare underhåll och vidareutveckling av programmet. Vi har också insett vikten av att använda lämpliga designmönster och principer för att skapa en robust och skalbar applikation.

Projektet har också betonat vikten av att använda externa bibliotek och verktyg för att underlätta utvecklingen. Genom att använda Maven har vi kunnat hantera projektets beroenden och inkludera nödvändiga bibliotek. Vi har även använt olika bibliotek som Jackson och MongoDB JDBC för att hantera JSON-data och kommunicera med databasen.

Vi har även lärt oss vikten av att vara välorganiserade och ha tydliga processer för projektledning och kommunikation. Genom att använda Trello som ett verktyg för projektstyrning har vi kunnat hålla koll på uppgifter, fördela arbetsbördan och ha en tydlig överblick över projektets framsteg.

Sammanfattningsvis har detta projekt gett oss möjlighet att tillämpa våra kunskaper och utveckla nya färdigheter inom Java-programmering, databashantering och API-integration. Vi har också fått erfarenhet av att arbeta i en teammiljö och använda olika verktyg för projektstyrning. Genom att reflektera över våra framgångar och utmaningar kan vi använda dessa slutsatser för att förbättra och växa som utvecklare i framtida projekt.


## Backlog
### Övergripande:

- Skapa grundläggande klasser för projektet:
    - Skapa Weather-, City-, Menu- och Database-klasser.
    - Definiera och enas om variabler och deras placering.
    - Förenkla och förtydliga klassernas struktur.

- Implementera SMHI API-integration:
    - Ansluta till SMHI:s öppna API för att hämta väderprognoser för olika städer i Sverige.
    - Implementera funktioner för att hämta och behandla data från API:et.
    - Koppla API-integrationen till Weather- och City-klasserna för att lagra och hantera väderprognoser.

- Implementera MongoDB-databasen:
    - Skapa och konfigurera en MongoDB-databas för att lagra väderprognoser.
    - Utveckla funktioner för att lägga till, uppdatera och hämta väderdata från databasen.
    - Testa databasens funktionalitet och koppla den till de andra klasserna i projektet.

- Skapa användargränssnittet:
    - Designa och implementera användargränssnittet för applikationen.
    - Koppla användargränssnittet till de andra klasserna i projektet.
    - Testa och justera användargränssnittet för att säkerställa användarvänlighet och funktionalitet.

### Utförligare backlog:

**Aram:**
- Ansvarade för att skapa Trello-planeringen och se till att uppgifterna fördelades och utfördes enligt plan.
- Utvecklade Weather-klassen, som hanterar väderdata och prognoser för olika städer.
- Skapade README.md-filen och presenterade projektet.
- Ansvarade för att skapa UML-diagram för att visualisera projektets struktur.

**Samer:**
- Utvecklade Database-klassen, som är ansvarig för att hantera kommunikationen med MongoDB-databasen.
- Implementerade JsontoDoco-funktionen för att omvandla JSON-data till dokument i databasen.
- Arbetade med att uppdatera dokumenten i databasen vid behov.

**Vikram:**
- Skapade City-klassen, som representerar olika städer och hanterar dess attribut och funktioner.
- Utvecklade Menu-klassen, som ansvarar för användarnavigering och interaktion i applikationens meny.

**Kristian:**
- Implementerade API-klassen, som hanterar kommunikationen med SMHI:s öppna API.
- Hanterade GitHub-repot och versionshantering för projektet.
- Utvecklade metoder för att skriva ut väderprognoser och annan data.

Alla projektmedlemmar har samarbetat och hjälpt varandra för att få deras respektive klasser att fungera tillsammans och lösa eventuella problem som uppstod under utvecklingsprocessen. Genom att följa backloggen och genomföra de åtgärder som beskrivs ovan, siktar vi på att skapa en stabil och funktionell väderapplikation med API-integration och en effektiv databashantering.
