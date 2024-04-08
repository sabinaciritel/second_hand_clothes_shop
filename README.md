# Descrierea Proiectului: Magazin Online de Haine Second-Hand

## Scopul Proiectului
Scopul acestui proiect este de a dezvolta un magazin online de haine second-hand, care permite utilizatorilor să posteze anunțuri pentru hainele pe care doresc să le vândă și să cumpere hainele disponibile în magazin. Magazinul va oferi o platformă pentru utilizatori să navigheze, să căute și să cumpere haine second-hand de la diferiți vânzători.

## Funcționalități Principale
1. **Înregistrare și Autentificare**: Utilizatorii pot crea conturi noi și se pot autentifica pentru a accesa funcționalitățile magazinului online.
   
2. **Postarea de Anunțuri**: Utilizatorii pot posta anunțuri pentru hainele pe care doresc să le vândă. Aceste anunțuri trebuie să includă detalii despre hainele disponibile, precum și fotografii relevante.

3. **Căutare și Filtrare**: Utilizatorii pot căuta haine după diferite criterii, cum ar fi genul, mărimea, categorie și altele. De asemenea, ei pot aplica filtre pentru a găsi rapid hainele dorite.

4. **Vizualizarea Detaliilor Produsului**: Utilizatorii pot vizualiza detaliile complete ale produselor, inclusiv imagini, descrieri și prețuri.

5. **Adăugarea în Favorite**: Utilizatorii pot adăuga produsele care îi interesează într-o listă de favorite pentru a le accesa mai târziu sau pentru a monitoriza disponibilitatea lor.

6. **Coș de Cumpărături**: Utilizatorii pot adăuga produse în coșul de cumpărături și pot finaliza cumpărăturile prin procesul de checkout.


7. **Notificări și Mesagerie**: Utilizatorii pot primi notificări în legătură cu starea produselor favorite și pot comunica cu vânzătorii prin intermediul unui sistem de mesagerie intern.



## Tehnologii Utilizate
1. Spring Data JPA: Pentru operațiile de bază de date, facilitând lucrul cu date relaționale.
2. Thymeleaf: Ca motor de șabloane pentru redarea vizualizărilor.
3. MySQL: Pentru baza de date destinată stocării informațiilor despre produsele și utilizatorii magazinului.
4. Spring Security: Pentru autentificare și autorizare.
5. Maven: Pentru gestionarea proiectului și instrument de construcție.


## Backend

POST /auth/register Descriere: Înregistrează un utilizator nou cu informațiile de înregistrare furnizate. Corpul Cererii: RegistrationBody Conține informațiile de înregistrare necesare pentru crearea unui cont de utilizator nou. Răspuns: Această rută nu returnează explicit un corp al răspunsului. În cazul unei înregistrări reușite, utilizatorul este înregistrat în sistem fără niciun mesaj de confirmare. 

GET /auth/find Descriere: Găsește un utilizator pe baza informațiilor de înregistrare furnizate. Corpul Cererii: RegistrationBody Conține informațiile utilizatorului folosite pentru găsirea unui cont de utilizator. Răspuns: Această rută nu returnează explicit un corp al răspunsului. Se presupune că efectuează o formă de căutare a utilizatorului și gestionează rezultatul intern sau prin excepții. Notă: Utilizarea @RequestBody într-o cerere de tip GET este neconvențională și s-ar putea să nu fie suportată de toți clienții sau proxy-urile.

DELETE /auth/delete Descriere: Șterge un utilizator pe baza informațiilor de înregistrare furnizate. Corpul Cererii: RegistrationBody Conține informațiile utilizatorului necesare pentru ștergerea unui cont de utilizator. Răspuns: Această rută nu returnează explicit un corp al răspunsului. 

PUT /auth/update Descriere: Actualizează informațiile unui utilizator pe baza informațiilor de înregistrare furnizate. Corpul Cererii: RegistrationBody Conține informațiile utilizatorului care urmează să fie actualizate. Răspuns: Această rută nu returnează explicit un corp al răspunsului. În cazul unei actualizări reușite, informațiile utilizatorului sunt actualizate în sistem fără niciun mesaj de confirmare. Modele RegistrationBody Modelul RegistrationBody conține informații despre utilizator, care sunt utilizate în diverse puncte terminale pentru înregistrarea, găsirea, ștergerea și actualizarea utilizatorilor. Câmpurile și constrângerile specifice de validare ale acestui model nu sunt detaliate în fragmentul de cod furnizat.

## Observer Pattern

Folosind Java, implementarea pattern-ului Observer implică câteva componente cheie care colaborează pentru a permite unui subiect să notifice observatorii săi despre schimbări, fără ca aceștia să fie strâns cuplați. Iată o descriere bazată pe fișierele încărcate:

Observer.java: Definește interfața pe care orice observator trebuie să o implementeze pentru a primi actualizări de la subiect. Observatorii vor avea o metodă update prin care sunt notificați.

Subject.java: Conturează interfața pentru subiect, detaliiind metode pentru atașarea, detașarea observatorilor și o metodă notifyObservers pentru a actualiza toți observatorii despre schimbări.

User.java: Reprezintă o implementare concretă a interfeței Observer, indicând cum un utilizator (ca observator) primește actualizări. Aceasta este o clasă care va răspunde la notificările subiectului.

ServiceProduct.java: Este o implementare a interfeței Subject, arătând cum un serviciu sau produs (ca subiect) gestionează observatorii săi și îi notifică despre schimbări. Aceasta menține o listă de observatori și îi notifică prin metoda notifyObservers.

Descriere Detaliată a Implementării Pattern-ului Observer:
Interfața Observer: Observatorii trebuie să implementeze această interfață pentru a putea primi notificări. Cheia aici este metoda update, prin care sunt anunțați de schimbări.

Interfața Subject: Aceasta include metode pentru înregistrarea (attach), scoaterea din înregistrare (detach) a observatorilor și o metodă notifyObservers pentru a actualiza toți observatorii înregistrați despre schimbare.

Observator Concret (User): Aceasta clasă implementează interfața Observer și, în metoda sa update, va reacționa la notificarea primită de la subiect.

Subiect Concret (ServiceProduct): Implementează interfața Subject, gestionând o listă de observatori și notificându-i despre schimbări prin metoda notifyObservers.

Pattern-ul Observer permite decuplarea slabă între obiecte, deoarece subiectul nu trebuie să cunoască detalii specifice despre observatori, ci doar că aceștia implementează interfața Observer. Este utilizat pe scară largă în implementarea sistemelor distribuite de gestionare a evenimentelor, în arhitecturi model-view-controller (MVC) și în scenarii în care un obiect trebuie să notifice alte obiecte fără să facă presupuneri despre cine sunt acele obiecte.






