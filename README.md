# cinema-app
This application is a cinema service, where users can register and use the shopping cart to add tickets.
There are also different cinema halls, films and movie sessions with different times and dates.

In terms of roles and permissions, the application would support two main roles: admin and user. As the admin, 
you would have full access to the application and its features, including the ability to create cinemahalls, 
movie sessions, and add movies to the database. Users, on the other hand, would be able to add tickets to their
shopping cart and create orders, but would not have access to the administrative features of the application.

# Features:
- registration

- log in:
   - authentication
   - authorization
  
- add/ get by id / get all:
   - a movie / movies
   - a cinema hall / cinema halls

- add / get by id / find available:
  - a movie session

- add a session / find by user / register & delete:
  - a shopping cart

- complete / get a history:
  - an order

All guest users have access to /register and /login endpoints.

Users with role ADMIN are able to add new movies, movie sessions and cinema halls to DB, 
as well as update or delete movie session by id and find users by their email addresses.

As for the authenticated users with role USER they are able to add tickets to a shopping cart, 
check details, orders history and complete orders.

# Structure:

Project uses an N-tier architecture with following layers of functionality:

    - Controller: processes users requests and responds to them;
    - DAO: operates with data in DB;
    - Service: contains all business logic of the application.

# Application technologies:

    - JDK 13
    - Apache Maven
    - Apache Tomcat 9.0.67
    - MySQL 8.0.30
    - Hibernate 
    - HQL
    - Spring Framework(Core, MVC, Security)

# Instructions for launching the project:
    - Fork my repository
    - git clone <your link>
    - Edit resources/db.properties - set the necessary parameters
    - Install Tomcat
    - Add Tomcat server to configuration
    - Run project
