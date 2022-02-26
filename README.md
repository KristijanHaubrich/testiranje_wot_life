# ProjektniZadatakMTTPP - Selenium testing wot-life site
Projektni zadatak iz kolegija "Metode i tehnike testiranja programske podrške"

Na osnovu metoda i tehnika upoznatih tijekom izvođenja laboratorijskih vježbi, 
izrađen je okvir za automatsko testiranje programke podrške u kojem se testirala web 
stranica wot-life-a (https://wot-life.com/) koja služi za analizu performansi u igrici **World of Tanks**.

Korišteni alati su JAVA JDK Development Kit, IntelliJ Community Edition IDE te ChromeDriver
za Google Chrome web preglednik (engl. *browser*). Unutar IntelliJ IDE-a je izrađen Maven projekt
koristeći Selenium i TestNG ovisnosti.

Napisano je 5 testnih slučajeva koristeći programski jezik JAVA, a za svaki slučaj je stvorena
testna klasa (ClanSearch, DisplayPlayerTanksByTier, FilterSpecificPlayerTank, Login, PlayerSearch). Elemente se najčešće
pronalazilo pomoću svojstva *xpath*,a web elementi pomoću sučelja **WebElement**. Prije početka testova (metoda **setupTest()**), 
pomoću *driver*-a se povećava (engl. *maximize*) prozor i pristupa navedenom URL-u te se prihvaćaju kolačići stranice. Svaki od testova
završava gašenjem *driver*-a unutar **teardownTest()** metode. Stringovi se uspoređuju 
pomoću klase **Assert** i metode **assertEquals()**. Pomicanja, odnosno *scrollanje* je realizirano pomoću 
**JavascriptExecutor** sučelja.

### PlayerSearch

U prvom testnom slučaju naziva PlayerSearch, testira se pretraga korisnika pomoću search bar-a. Test se izvršava unutar metode **wot_life_player_search()**.
