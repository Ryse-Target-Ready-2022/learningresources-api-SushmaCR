Activity Goal
Learn about JPA, Interfaces and Abstract classes while getting familiar with Git.

Activity Details
Create a new branch called 4-JPA.
Create a new package called repository.
Create an interface named LearningResourceRepository.
Add the dependency for Spring Data JPA in build.gradle file.
Add the dependency for an H2 in-memory database.
Add the database connection details in the properties file.
Add the SQL queries to insert the data to the in-memory database in the data.sql file.
Map your entity class to match with the database table and its columns.
Modify your service class to load/save data to the in-memory database using the repository methods.
Delete the LearningResources.csv file.
Run the app and check if the records mentioned in data.sql are added successfully by navigating to http://localhost:8585/h2-console.
Call saveLearningResources method and check if the data is successfully stored in the database.
Raise a pull request and merge your changes to the master branch.
Delete the branch 4-JPA.


Activities to explore
Understand JPA concepts.
Understand resource files such as app.yml or app.properties.
Understand how to connect to dev database, stage database, prod database, etc
Understand good practise while checking in resource files.
Understand what is an interface. Observe how it is used in the repository layer.
Understand JDBC as an alternative to connect to db.