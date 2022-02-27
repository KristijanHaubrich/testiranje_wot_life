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

### [PlayerSearch](kristijan_haubrich_testiranje/src/test/java/PlayerSearch.java)
U prvom testnom slučaju ,naziva PlayerSearch, testira se pretraga korisnika pomoću search bar-a. Test se izvršava unutar metode **wot_life_player_search()**.
Prvo se stvorila instanca **WebElement** koja je nazvana *search* i koja predstavlja search bar. Pomoću metode *sendKeys()* upisano je u search bar ime korisnika (*Hauba*) te se pomoću metode *submit()* pokreće pretraživanje pojma. Za provjeru uspješnosti pretraživanja korišten je novi **WebElement** *username* koji predstavlja naziv korisnika koji piše kad se jednom pretraži profil. Provjera da li se podudara naziv korisnika s traženim se odrađuje pomoću već spomenute *assertEquals()* metode.

### [ClanSearch](kristijan_haubrich_testiranje/src/test/java/ClanSearch.java)
U drugom testnom slučaju ,naziva ClanSearch, testira se pretraga klana pomoću search bar-a. Test se izvršava unutar metode **wot_life_clan_search()**.
Prvo se stvori instanca **WebElement** naziva *clan* koja predstavlja tipku za prebacivanje na pretraživanje klanova. Potom se stvori instanca **WebElement** naziva *search* koja predstavlja search bar za klanove. Pomoću metode *sendKeys()* upisan je u search bar string (*fa*). Instanca **WebElement** naziva *clan_search* predstavlja određeni predloženi klan koji nastane u search baru nakon upisa stringa. Kad se klikne na *clan_search* odlazi se na profil klana.Za provjeru uspješnosti pretraživanja korišten je novi **WebElement** *moto* koji predstavlja moto klana koji se provjerava pomoću već spomenute *assertEquals()* metode.

### [Login](kristijan_haubrich_testiranje/src/test/java/Login.java)
U trećem testnom slučaju ,naziva Login, testira se logiranje korisnika preko *World of Tanks* računa. Test se izvršava unutar metode **wot_life_login()**.Prvo se stvori instanca **WebElement** naziva *login* od koje se dobije informacija o linku na koji vodi preko metode *getAttribute()*. Nakon toga se pristupa dobijenom linku preko metode *navigate()* tako zaobilazeći reklame koje bi se stvorile u slučaju da se samo kliknulo na element. Taj link nas vodi na odabir *World of Tanks* servera na kojeg se želimo prijaviti. Potom slijedi postupak prijave gdje se popunjavaju polja za unos email adrese i lozinke te se pritišće gumb za prijavu. Ako je prijava uspješna vratiti će se na wot-life web stranicu sa prijavljenim korisnikom. Za kraj tu se provjerava da li se radi o statistici korisnika koji se prijavio. 

### [DisplayPlayerTanksByTier](kristijan_haubrich_testiranje/src/test/java/DisplayPlayerTanksByTier.java)
U četvrtom testnom slučaju ,naziva DisplayPlayerTanksByTier, testira se prikaz tenkova određenog korisnika prema razini tenka (engl. *tier*). Test se izvršava unutar metode **wot_life_display_player_tanks_by_tier()**. Prvo se stvorila instanca **WebElement** koja je nazvana *search* i koja predstavlja search bar. Pomoću metode *sendKeys()* upisano je u search bar ime korisnika (*Hauba*) te se pomoću metode *submit()* pokreće pretraživanje pojma.  Nakon prikaza profila korisnika stvara se instanca **JavascriptExecutor** preko koje se izvršava scrollanje za 1000 piksela. Nakon toga klikće se na padajući izbornik *Tenks* preko **WebElement** *tanks*. Za kraj u tablici gdje su prikazani tenkovi pritisne se filter za *tier* tenkova preko **WebElement** *tier*.

### [FIlterSpecificPlayerTank](kristijan_haubrich_testiranje/src/test/java/FIlterSpecificPlayerTank.java)
U petom i posljednjem testnom slučaju ,naziva FIlterSpecificPlayerTank, testira se prikaz tenkova korisnika preko određenog naziva. Test se izvršava unutar metode **wot_life_display_player_tanks_by_tier()**. Prvo se stvorila instanca **WebElement** koja je nazvana *search* i koja predstavlja search bar. Pomoću metode *sendKeys()* upisano je u search bar ime korisnika (*Hauba*) te se pomoću metode *submit()* pokreće pretraživanje pojma.  Nakon prikaza profila korisnika stvara se instanca **JavascriptExecutor** preko koje se izvršava scrollanje za 1000 piksela. Nakon toga klikće se na padajući izbornik *Tenks* preko **WebElement** *tanks*. Potom se preko **WebElement** *search_tank* upise naziv tenka za prikaz u search bar te se pretraži tenk. Na kraju se preko id-a tenka provjerava isprevnost prikaza uz pomoć već spomenute *assertEquals()* metode.

### TestNG.xml
Osim ovakvog načina testiranja, moguće je web stranicu testirati pomoću ručno konfigurirane datoteke
**TestNG.xml**. Takav način testiranja je moguće pokrenuti pritiskom na opciju *Run* ili iz komadne
linije sa sljedećom naredbom:
```
$mvn test   (Ctrl + Enter)
```

Također izvješće o testovima moguće je pogledati u obliku html prikaza klikom na [izvješće]()
