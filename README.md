# healthcare-api
web app apis to manage medicine

Release 1 notes:

Model Domain objects

User
UserProfile
Account
UserRoles
Medicine
Cart
Order

APIs are completed for each object and are considered v1 objects. Will need to be add or change APIs to accomodate functionality once front end gets added.

Error Handling

APIs need to be more robust handling data integrity issues better. Example: Many accounts can be added to a user which will not be allowed by this app.
Need to understand message resolver better and or spring advice.  Utlimately would like to pass error codes or ids in the back end so they can be interpeted easier 
and actions can take place.

WebSecurity 

Have the application set up for Role based, basic security but need to learn more.  My first pass at it resulted in the app being secure as it looks like Spring Security 
was working but it was failing to find the login page which I don't have implemented yet.  UserDetailsService is working as I see the execution of the with users and roles
apis.  As of now the healthcare app's security is disabled so apis can be run from Postman.

H2 Database  -  This has been fixed (I think leaving notes just in case)

The app is using h2 but noticed a very weird error when I first start up the project.   import.sql works but when the project is shut down the import.sql gets a new line
as some kind of reformatting goes on that causes errors on startup. Have not solved this issue yet but there is a work around:

The project will fail to create the h2 database on start up if the import script looks like this:

INSERT INTO USER_TBL(USER_ID, FIRST_NAME, LAST_NAME, ADDRESS, EMAIL_ADDRESS, DATE_OF_BIRTH, USER_NAME, PASSWORD,
                     ENABLED)
VALUES (1, 'David', 'Solomon', '12 City Street Nashua, NH 03063', 'dsol@gmail.com', '1984-05-24', 'dsol',
        '$2a$10$VqzDJ0XCIkcT3.K9YkYrt.yji1WeYyiFWpIJOjnu5U6clg39qKZ1G', true);
INSERT INTO USER_TBL(USER_ID, FIRST_NAME, LAST_NAME, ADDRESS, EMAIL_ADDRESS, DATE_OF_BIRTH, USER_NAME, PASSWORD,
                     ENABLED)
VALUES (2, 'Becky', 'Solomon', '12 City Street Nashua, NH 03063', 'bsol@gmail.com', '1984-05-24', 'bsol',
        '$2a$10$AVO0bJcV3TdX6d0A9b03YOTSmow.sZmmBueDQHjR7YXtqrPP8MJXK', true);
        
Work around is to go into the script and manually formated it so it looks like this:

//users
INSERT INTO USER_TBL(USER_ID, FIRST_NAME, LAST_NAME, ADDRESS, EMAIL_ADDRESS, DATE_OF_BIRTH, USER_NAME, PASSWORD, ENABLED) VALUES (1, 'David', 'Solomon', '12 City Street Nashua, NH 03063', 'dsol@gmail.com', '1984-05-24', 'dsol','$2a$10$VqzDJ0XCIkcT3.K9YkYrt.yji1WeYyiFWpIJOjnu5U6clg39qKZ1G', true);
INSERT INTO USER_TBL(USER_ID, FIRST_NAME, LAST_NAME, ADDRESS, EMAIL_ADDRESS, DATE_OF_BIRTH, USER_NAME, PASSWORD, ENABLED) VALUES (2, 'Becky', 'Solomon', '12 City Street Nashua, NH 03063', 'bsol@gmail.com', '1984-05-24', 'bsol','$2a$10$AVO0bJcV3TdX6d0A9b03YOTSmow.sZmmBueDQHjR7YXtqrPP8MJXK', true);

You need manually format all the insert statement so they look like this.


Junit tests

Junit tests are completed for services only 
Still need to complete Junit tests for Controller and Mappers
