# Descrierea Proiectului: Magazin Online de Haine Second-Hand

## Scopul Proiectului
Scopul acestui proiect este de a dezvolta un magazin online de haine second-hand, care permite utilizatorilor să posteze anunțuri pentru hainele pe care doresc să le vândă și să cumpere hainele disponibile în magazin. Magazinul va oferi o platformă pentru utilizatori să navigheze, să căute și să cumpere haine second-hand de la diferiți vânzători.

## For Users
## Registration and Authentication

- **Register**: Create a new account.
- **Log In**: Access an existing account.

## Account Management

- **View/Update Personal Information**: Update details such as name, address, and contact information.
- **Change Password/Settings**: Modify password or other account settings.

## Browsing and Searching Products

- **Browse Categories**: Explore different product categories.
- **Search Products**: Use the search bar to find specific products.

## Viewing Product Details

- **View Product Information**: See descriptions, prices, images, and other product details.

## Adding Products to Cart

- **Add to Cart**: Add products to the shopping cart.
- **Modify Cart**: Change the quantity of products or remove items from the cart.

## Placing Orders

- **Place an Order**: Specify delivery details and choose a payment method.
- **Order History**: View past orders and the status of current orders.



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
##Tests
ServiceOrderTest Overview
1. Setup Method (setup()):

Initializes mocks and a ServiceOrder instance before each test.
2. Register Order Test (registerOrderTest()):

Verifies the registration and correct saving of an order using mock interactions.
3. Find Order Test (findOrderTest()):

Checks if the correct method is called on the mock to find an order by username.
4. Delete Order Test (deleteOrderTest()):

Ensures that the correct delete method is invoked on the mock for an order.
5. Update Order Test (updateOrderTest()):

Confirms that the update functionality correctly interacts with the mock to find and update an order.
6. Find User by Username Test (findUserByUsernameTest()):

Tests the retrieval of a user by username to verify the correct functioning of the findByUsername method on the mock.
These tests are designed to validate the behavior of the ServiceOrder class using Mockito to simulate database interactions and ensure methods are called as expected.

ServiceProductTest Overview
1. Setup Method (setup()):

Purpose: Prepares mocks and a ServiceProduct instance before each test run, ensuring a consistent testing environment.
2. Register Product Test (registerProductMethodTest()):

Purpose: Validates the registration process of a product, ensuring it is correctly saved using mocked DAO interactions.
3. Find Product by Name Test (findProductMethodTest()):

Purpose: Checks the functionality of retrieving a product by name, verifying correct method calls on the mocked DAO.
4. Delete Product Test (deleteProductTest()):

Purpose: Ensures that the deletion process of a product is handled correctly, with the appropriate DAO method being invoked.
5. Update Product Test (updateProductTest()):

Purpose: Tests the update functionality for a product's details, confirming correct interactions with the DAO and accurate data handling.
6. Find User by Product Name Test (findUserByNameTest()):

Purpose: Verifies the process of finding a product by its name, ensuring the DAO's findByName method is correctly utilized.
These tests rigorously check the product management functions, simulating database operations using Mockito to confirm that each method performs as expected within the ServiceProduct class.


ServiceUserTest Overview

1. Setup Method (setup()):

Purpose: This method prepares the test environment by initializing all necessary mocks and creating an instance of ServiceUser. It is critical for setting a clean slate before each test to ensure that test outcomes are not influenced by previous tests.
Details: MockitoAnnotations.initMocks(this); is used to automatically set up the mocked objects annotated with @Mock. serviceUser = new ServiceUser(userDAOmock); initializes the ServiceUser with a mock DAO object, allowing for controlled testing of database operations.
2. Register User Test (registerUserTest()):

Purpose: Ensures that the user registration functionality works as expected. The test confirms that a new user is saved correctly and the saved data matches the provided input.
Details:
Input: RegistrationBody containing user details like email, username, password, and role.
Operation: Simulates the registration process and intercepts the DAO's save operation to validate both input handling and persistence logic.
Verification: Checks that the returned user object is as expected and verifies that the save method on the mocked DAO was called with the correct parameters.
3. Find User Test (findUserTest()):

Purpose: Tests the ability of the service to retrieve a user by username from the database, ensuring that the correct database access method is invoked.
Details:
Operation: Triggers the find functionality within the service which should then call the DAO's find method.
Verification: Uses Mockito's verify method to ensure that findByUsername was called on the mock DAO, validating that the service delegates the database operations correctly.
4. Update User Test (updateUserTest()):

Purpose: Validates that the user's information can be updated correctly, with proper interaction with the DAO for both fetching and updating the user data.
Details:
Operation: First retrieves a user based on username and then attempts to update that user's details.
Verification: Verifies both the retrieval (findByUsername) and update (save) operations on the DAO, ensuring that the service handles the flow of operations correctly.
5. Delete User Test (deleteUserTest()):

Purpose: Confirms that the service can delete a user correctly, with the DAO's delete method being properly invoked.
Details:
Operation: Simulates the deletion of a user and checks that the correct user object is used in the DAO's delete method.
Verification: Ensures that the delete method is called on the mock DAO, confirming that the service correctly translates business operations into data layer operations.
6. Find User by Username Test (findUserByUsernameTest()):

Purpose: Tests the functionality to retrieve a user by their username, ensuring that the method on the DAO is appropriately called.
Details:
Operation: Specifically tests the findUserByUsername method of the service, focusing on DAO interaction.
Verification: Confirms that findByUsername is executed on the DAO mock, ensuring that the service accurately queries the data layer based on user input.
These detailed test descriptions provide a comprehensive overview of how ServiceUserTest ensures the correctness and efficiency of user management functionalities within the service layer, validating the integrity of operations like registration, update, deletion, and retrieval of user data.






