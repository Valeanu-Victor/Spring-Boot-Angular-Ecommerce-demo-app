# Spring-Boot-Angular-Ecommerce-demo-app
  This demo e-commerce web app is a work-in-progress personal project. Frontend is Angular 7, Backend is Spring Boot with JWT security and for the database I have implemented h2 for now.

***Open cmd in UI folder and type command "npm install" and than "ng serve" , after that open browser and go to "http://localhost:4200"***<br>
***Open secured-app folder with your IDE and run main class (SecuredAppApplication)***

If you want to check out the database go to "http://localhost:8080/h2-console" with username "sa" and empty password
You can only sell an item if you create a "seller" user !!!

***To be fixed:***
  The project still needs approved/unapproved messages/warnings to be added when the user registers/sells/buys an item.
  QuantityOrder being added in the ngFor in the products html component makes it that the input in a specific field is propagated in all the fields.
