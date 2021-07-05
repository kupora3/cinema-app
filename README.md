# cinema-app
## Description
This project provides a simple app, that was written with the help of two frameworks - Spring & Hibernate. It's a RESTfull app, with N-tier architecture in use. The project has three layers: 1.Controller
2.Dao 3.Service
Also has user role and authenticate.
### About Roles
By default has two roles: ADMIN/USER;
Depending on the role, the user can do some functionality, which is provided for a specific role.

```
GET: /cinema-halls - user/admin
POST: /cinema-halls - admin
GET: /movies - user/admin
POST: /movies - admin
GET: /movie-sessions/available - user/admin
GET: /movie-sessions/{id} - user/admin
POST: /movie-sessions - admin
PUT: /movie-sessions/{id} - admin
DELETE: /movie-sessions/{id} - admin
GET: /orders - user
POST: /orders/complete - user
POST: /shopping-carts/movie-sessions - user
GET: /shopping-carts/by-user - user
GET: /users/by-email - admin
```

## What you can do
### Unregistered user can

1. register
2. view all available movie sessions
3. view all movies
4. view all cinema halls

### Registered person with role User can

1. add the ticket for movie to the shopping cart
2. view all the tickets in the shopping cart
3. complete the order
4. view a history of all the orders

### Registered person with role Admin can

1. view a list of all films
2. find user by email
3. create new film
4. create new cinema hall
5. create/delete/update new movie session.

## How to install a project
### Follow next steps:

1. Clone project from Github to your local repository.
2. Run IDE and use this example.
<img src="http://joxi.ru/xAeoEKdIXzoWVm.jpg" width="500">

After that, you must copy the link from Git and paste it to your IDE

3. Configure DB properties

```
db.driver=YOUR DRIVER
db.url=YOUR DB
db.user=YOUR USERNAME
db.password=YOUR PASSWORD

#Hibernate properties
hibernate.show_sql=true
hibernate.hbm2ddl.auto=create-drop
hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```
4. Configure Tomcat using ``` Deployment - war_exploded, context address - "/" ```
5. Run the application
6. When you running this, go to link localhost:8080, and use ``` /inject ``` 
After that, you are injected with two default users to the app and you can log in with the next params: ``` bob@gmail.com ``` password ``` 1234 ``` this user has a role ADMIN.
And ``` alice@gmail.com ``` password ``` 1234 ``` this user has a role USER

## Used technologies

1. Spring - Core / MVC / Web / Security
2. Hibernate
3. MySQL
4. Maven
5. Tomcat 9.0.46 or earlier
