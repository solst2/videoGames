When you run the application on the server, you can use the following link:
http://localhost:8080/TP12-WEB-EJB-PC-EPC-E-0.0.1-SNAPSHOT/faces/welcomeVideoGames.xhtml

Before you start the application and the database, make sure that you have a User created in group User
and one User created in group Admin and User. For example:
Name				password			group
User 				SolangeSascha 		User
AdminVideoGame 		SaschaSolange 		User, Admin
You can do this with the add-user in the JavaEE\rootJavaEE\tools\wildfly-17.0.1.Final\bin folder.

Starting stepps:
The application can be deployed on wildfly. Now some starting steps.
When your db is empty add the following:
	- add a user
	- add a category
	- add a developer
	- then add a game
After that you can go to home and chose the user from the list and rent the game.
Afterwoods you can add modify delete as much as you want.


