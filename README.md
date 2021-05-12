# Vaccination4YOU 
## Android projekat - Kotlin

Projekat za predmet Razvoj mobilnih aplikacija
Kreatori: Azra Hadžihajdarević i Riad Pap

## Ukratko o aplikaciji
Svrha aplikacije je registrovanje za vakcinu protiv COVID-19.
Aplikacije prikuplja osnovne informacije o korisniku i prikazuje ih, naravno koje korisnik moze da podijeli ili spasi na svoj uredaj.
Aplikacija je funkcionalna i obavlja sve trazene uslove.
Stilizirana je vrlo jednostavno bez puno sarenila i bespotrebnih dodataka.
Jednostavna je za korisiti.
Aplikacija je namijenjena za Android OS, napisana je u Kotlin programskom jeziku.

# Zadatak
Nas zadatak je imao dvije strane:
- korisnicku stranu
- programersku stranu

*Sa korisnicke strane* - Da napravimo aplikaciju u svrhu registracije za vakcinu protiv COVID-19, da bude jednostavna i da ispunjava trazene uslove.
*Sa programerske strane* - Da kreiramo funkcionalu aplikaciju u programskom jeziku **Kotlin** i da iskoristimo do sada steceno znanje o programiranju.

## Zadani uslovi za aplikaciju

- Uvodni dio
- Provjeru da li korisnik ima prepreku za primanje vakcine
- Prikupljanje podataka o korisniku
- Provjeru o pripadanju prioritetnoj grupi
- Izbor vakcine
- Sazetak prethodnih odgovora
- Prikaz termina i lokacije vakcinacije
- Prikaz simuliranog broja trenutno registrovanih korisnika

Uvodni dio - sama svrha da uvede korisnika u aplikaciju i da pristup fukcionalnosti te iste.
Provjera podataka - jednostavna provjera podataka, jesu li dati uslovi na formama zadovoljeni ili ne.
Prikupljanje podataka - jednostavno prikupljanje osnovnih informacija o korisniku kroz date forme.
Izbor - jednostavan izbor vakcina, koju korisnik vise preferira.
Prikazivanje podataka - prikazivanje vec prikupljenih podataka o korisniku na zadnjoj stranici.
Prikaz broja registrovanih - manji prikaz trenutno registrovanih korisnika na pocetnoj stranici.

## Tehnicki uslovi za aplikaciju

- Koristenje fragmenata
- Iskoristiti barem jedan constraint layout
- View and data binding
- Navigation komponentu
- Prosljedivanje podataka putem Safe Args plugina
- Prevod barem dva fragmenta na engleski jezik
- Uklanjanje fragmenata sa back-stacka
- App bar sa bar jednim item-om i up button-om
- Bocni meni
- Share button kojim se moze poslati predefinisana poruka
- Timer sa lifecycle observerom
- Barem jedan fragment sa razlicitim horizontalnim i vertikalnim layout-om
- Spasavanje podataka kako bi se sacuvali prilikom zatvaranja aplikacije od samog Android OS-a



# Dizajn
## Dizajn aplikacije

Dizajn aplikacije je vrlo jednostavan, aplikacija vodi korisnika kroz cetiri stranice ili formulara.
Stranice ili formulari nisu napadni, niti nagomilani i pokazuju najvaznije informacije potrebne korisniku.
Boje koje su izabrane su samo simulacija kako bi neka kompanija ili firma stilizirala aplikaciju koristenjem logo boja ili unikatnim bojama za tu kompaniju ili firmu.
Na sljedecim slikama mozemo vidjeti kako izgleda aplikacija:

### Pocetna stranica
Pocetna stranica prikazuje trenutni broj registrovanih, bocni meni, logo, ime aplikacije i dugme za pocetak registracije, koje naravno vodi na sljedecu stranicu ili formular.

![Slika uvod](https://ibb.co/fNz0q2N "Slika uvod")

### Prikupljanje osnovnih informacija o korisniku
Druga stranica koja prikazuje formu za prikupljanje osnovnih podataka o korisniku. Korisnik ne moze nastaviti na sljedecu stranicu ili formular ako nije popunio zadnu formu.

![Slika druga ime,prezime,dob](https://ibb.co/897ZWBB "Slika druga ime,prezime,dob")

### Provjera COVID-19 dijagnoze
Treca stranica koja prikazuje pitanje koje moze imati samo jedan odgovor.

![Slika covid dijagnoza](https://ibb.co/gtJXZCG "Slika covid dijagnoza")

### Provjera rizicnih kategorija
Cetvrta stranica koja nudi korisniku izbor da li oni pripadaju nekoj od rizicnih kategorija. Korisnik ne moze nastaviti dalje ako nije oznacio barem jedna izbor. Zadnji izbor ponistava sve od predhodno oznacenog.

![Slika kategorije](https://ibb.co/KwWYYx8 "Slika kategorije")

### Izbor vakcine
Peta stranica koja nudi korisniku trenutne vakcine na trzistu. Samo jedna vakcina se moze odabrati.

![Slika vakcina](https://ibb.co/1zqp2t7 "Slika vakcina")

### Zadnja stranica
Zadnja stranica koja prikazuje prikupljene korisnicke informacije, koje korisnik moze da podijeli sa predefinisanom porukom ili spasi na svoj uredaj.

![Slika zadnja](https://ibb.co/hM66KDY "Slika zadnja")

# Sadrzaj
## Sadrzaj aplikacije - korisnicka strana

Aplikacija posjeduje sve ispunjene uslove. 
- Stranicu koja nudi vise informacija o COVID-19
- Stranicu o kreatorima, kompaniji ili firmi
- Cetiri stranice ili formulara, cija je svrha da se prikupe podaci o korisniku
- Zavrsna stranica koja pokazuje sve prikupljenje podatke o korisniku i njihovoj vakcinaciji
- Opciju za dijeljenje i cuvanje vec pomenutih prikupljenji podataka
- Prevedena na dva jezika engleski i bosanski

## Detaljni opis sadrzaja - korisnicka strana

### Stranicu koja nudi vise informacija o COVID-19
Stranica sadrzi dosad poznate informacije o COVID-19.

![Slika info](https://ibb.co/NY4h3XY "Slika info")

### Stranicu o kreatorima, kompaniji ili firmi
Stranica sadrzi najosnovnije infromacije o kreatorima, kompaniji ili firmi.

![Slika about](https://ibb.co/NyzKJPz "Slika about")

### Cetiri stranice ili formulara i zavrsna stranica
Vec su navedni iznad u Dizajnu aplikacije i sta svaka stranica ili formular sadrzi, zajedno sa slikama.

### Opcija za dijeljenja i cuvanje
Opcija se nalazi na zavrsnoj stranici, s lijeva na desno prikazano, dijeljnje i spasavanje.

![Slika share](https://ibb.co/sQwnw5Z "Slika share")

### Prevod
Citava aplikacija je prevedna na dva jezika engleski i bosanski, koja se automatski prilagodava korisnickoj postavci na samom uredaju.

## Sadrzaj aplikacije - programerska strana

Aplikacija posjeduje sve ispunjene uslove
- Fragmente
- Razlicite layoute
- View and data binding
- Navigaciju
- Prosljedivanje podataka putem Safe Args plugina
- Preveden na dva jezika engleski i bosanski
- Uklanjanje fragmenata sa back-stacka
- App bar
- Bocni meni
- Share logiku
- Timer 
- Fragment sa vertikalnim i horizontalnim layoutom
- Spasavanje korisnickih podataka

## Detaljni opis sadrzaja - programerska strana

### Fragment

Fragment predstavlja ponasnje ili porciju korisnickog inteface-a u zadanoj Aktivnosti (Activity).
Moguce je kombinirati vise fragmenata u jednu Aktivnost da bi se postigla vise prozorni korisnicki interface, a i takoder se moze jedan Fragment koristiti u vise aktivnosti.

Fragment mozemo zamisliti kao modularni dio neke aktivnosti, nesto kao pod-aktivnost (sub-activity) koji se naravno moze iskorisiti i u drugim aktivnostima.

Fragment posjeduje sljedece:
- Sopstveni lifecycle
- Prima svoje event-ove
- Mogucnost dodavanja i oduzimanja, dok je aktivnost aktivna

Fragment je definisan u Kotlin klasi, a korisnicki inteface u XML layout file-u.

### Layout

Layout definise strukturu za korisnicki interface u samoj aplikaciji, kao npr. aktivnost.
Svi elementi u layoutu su napravljeni hijararhijom objekata View-a i ViewGroup.

### View

View predstavlja obicnu bazu ili podlogu za pravljenje komponenti korisnickog interface-a.
View zauzima pravougaono podrucje na zaslonu i odgovoran je za crtanje i procesiranje event-ova(event handling).

### Data binding

Data binding biblioteka je Android Jetpack biblioteka koja omogucava da se poveze ili bind-a komponenta korisnickog interface-a u nekom XML layout-u sa izvorima podataka u aplikaciji, koristeci deklerativni format nego programaticni, koji u ruku smanjuje ponavljacki kod (boilerplate code).

### Navigation

Navigacija se desava izmedu destinacija aplikacije, tj. bilo gdje gdje korisnik moze da pristupi.
Ove destinacije su povezane putem akcija.
Navigacija posjeduje resursni file koji se zove navigation graph i on sadrzi sve destinacije i akcije, i predstavlja navigacione puteve aplikacije.

### Safe Args plugin

Safe Args plugin je Gradle plugin koji je dio navigacione komponente i koji se koristi za proslijedivanje podataka u svrhu ocuvanja tipa (type-safety).

### Prevod

Citava aplikacija je prevedena na dva jezika engleski i bosanski. Aplikacija se automatski prilagodi pomocu korisnickih postavka za jezik na njihovom uredaju.

### Back-stack

Task je kolekcija aktivnosti s kojima je korisnik imao iterakciju. Te aktivnosti su poredane u stack-u (back- stack) u redoslijedu kojem su bile otvorene.
Kada se nova aktivnost aktivira, stara aktivnost gubi fokus i zaustavlja se, dok nova dolazi na vrh stacka i ulazi u fokus.
Radi na principu Zadnji -> Prvi ,LIFO ( Last one In, First one Out).

### App bar

App bar, takode poznat kao action bar, je jedan od najvazniji dizajn komponenti u aktivnosti aplikacije, jer pruza i vizuelnu strukturu i interaktivne elemente koji su vec poznati korisnicima.

### Side menu

Side menu, takoder poznat kao navigation drawer, je panel korisnickog interface-a koji pokazuje glavni navigacioni meni.

![Slika side menu](https://ibb.co/pwDbxrG "Slika side menu")

### Shareing

Share je jednostvna komponenta koja pruza korisniku da podijeli neke informacije, podatke, sa drugim korisnicima putem razlicitih nacina.

### Timer

Timer jer objekat koji je zaduzen za upravljanje thread-ovima koji namjestaju buduce task-ove za buduce izvrsavanje. Task-ovi mogu biti namjesteni za jedno izvrsavanje ili vise njih kroz regularne intervale.

### Files

File je objekat koji sluzi za pisanje i citanje file-ova raznih ekstenzija. Primarno se koristi za spasavnje podataka prikupljenih kroz aplikaciju ili iskoristavanja postojecih spasenih podataka.
