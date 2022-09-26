# GreenRent --- Java-Backend

Definition: The Car Rental application is a web application which is able to be rent a car directly by using a web browser in your computer, phone, tablet, or mobile device. There will be different types of user in the CarRental application. While unregistered users are able to see available cars’ information, these users are able to register and login into application. The users who have Customer Role are able to make a reservation for a car and manage their own user information. In addition to these. administrator of the CarRental application can manage the users, cars, reservations and create some reports.

GREENRENT WEB APPLICATION CUSTOMER REQUIREMENTS

CarRental Application must be a web application.
The application must have user friendly UI. (Non functional requirement)
The application must be secure. (Non functional requirement)
Language of the application must be English. (Non functional requirement)
The application must display response of user request nearby for 5 seconds. (Non functional requirement)
Anonymous users who will make a process should be able to register this application with their own information
There should be able two types of roles for authorized user: Customer, Admin
Registered user is able to have at least one role or all roles
Anonymous user should be able to register to the application
Registered user should be able to login to the application after registration
Authenticated user should be able to get its own user information
Authenticated user should be able to update its own user information
Authenticated user should be able to update its own password
User who has the admin role should be able to get all users’ information
User who has the admin role should be able to get a user information
User who has the admin role should be able to update a user information
User who has the admin role should be able to delete a user
Anonymous users should be able to get all cars’ information
Anonymus users should be able to get a car’s information
User who has the admin role should be able to add a car
User who has the admin role should be able to upload a car image
User who has the admin role should be able to get all cars’ image
Anonymous user should be able to get a car’s image
Anonymous user should be able to display a car’s image
User who has the admin role should be able to update a car with an car image
User who has the admin role should be able to delete a car
User who has the admin role should be able to delete a car
Authenticated user should be able to make a reservation for a car
Authenticated user should be able to check availability of a car between selected datetime
User who has the admin role should be able to add a reservation for a car and a user
User who has the admin role should be able to get all reservations’ information
User who has the admin role should be able to get a reservation information
User who has the admin role should be able to get a user’s reservations’ information
Authenticated user should be able to get its own reservation information
Authenticated user should be able to get its own reservations’ information
User who has the admin role should be able to update a reservation
User who has the admin role should be able to delete a reservation
User who has the admin role should be able to get all users’ information in an excel report
User who has the admin role should be able to get all cars’ information in an excel report
User who has the admin role should be able to get all reservations’ information in an excel report

In the Unified Modeling Language (UML), a use case diagram can summarize the details of your system's users (also known as actors) and their interactions with the system. A UML use case diagram is the primary form of system/software requirements for a new software program underdeveloped. Use cases specify the expected behavior (what), and not the exact method of making it happen (how). Use cases once specified can be denoted both textual and visual representation (i.e. use case diagram). A key concept of use case modeling is that it helps us design a system from the end user's perspective. It is an effective technique for communicating system behavior in the user's terms by specifying all externally visible system behavior.

Entities and Relations Between Entity in the Application Relations

•One User can have many roles and One Role can belongs to Many User (Many To Many relation) •One Reservation has a User (One To One relation) •One Reservation has a Car (One To One relation) •One Car can have many ImageFile and ImageFile can belongs to Many Car (Many To Many relation) •Role has a RoleType (Enumeration) •Reservation has a ReservationStatus (Enumeration)

THE TOPICS THAT YOU SHOULD REVIEW BEFORE STARTING PROJECT

Core Java: OOPS, classes, enums, interfaces, exception handling, collections, stream (foreach, filter, map), lambda,optional key word and other fundamentals.
Logging (SLF4J, Logback)
Regular expressions
What is Spring Framework.
What is Spring Boot Framework
What is Spring Security Framework. (JWT Based Security)
What is inversion of control , dependency injection and Spring IOC Container
What is JPA, Hibernate and Spring Data JPA
What is entity class and how to create it
What are OneToOne, OneToMany, ManyToOne, ManyToMany relations on hibernate.
How to use @JoinTable, @JoinColum annotations.
JPQL (Java Persistence Query Language), Basic SQL knowledge
What is REST API
How , why to use @Bean, @Autowired, @RestController, @Service, @Repository annotations.
Jackson annotations (@JsonIgnore, @JsonFormat etc.)
Controller-Service-Repository layered structure in spring boot app
What is @Transactional annotation in org.springframework.transaction.annotation
What is the Data Transfer Object and how to use it.
Usage of @ResponseEntity, @ResponseBody, @Request Body, @RequestMapping, @PostMapping, @GetMapping, @DeleteMapping, @PutMapping. @Valid annotations.
HTTP Response Status Codes. (200, 201, 400, 404, etc.)
Why and How to use @PathVariable and @QueryParam annotations
Project Lombok
