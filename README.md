# spring-demo
Demo project using spring boot

## Server
In order to run the project you have to run the maven command:
`mvn spring-boot:run`
The server is configured to start on port 8090. The port number can be 
configured in the application.properties file under the Server section.

## Middlewares
This project was created to be used with a Keycloak server as an 
external authentication server. It contains a set of middlewares to check if 
the requests contain the authentication token. For simplicity it is off, so 
the endpoints are open.

In order to turn on this feature you have to set to true the 'oidc.on' parameter 
in the application.properties file under the OAuth2 Keycloak section. You can 
fid the rest of the configurations for Keycloak in the same section.

## BD
This application uses a postgresql db. It can be easily changed for any other 
db server. The configuration parameters are in the application.properties file 
under DB section.

## Migrations
The migrations are located in resources/db/migrations. The project uses Flyway 
for this propose. You can find the configuration parameters in the 
application.properties file under the Flyway section.

To create a new migration, create a new .sql file and follow the migration file 
format: v#__name_of_the_migration.sql, where the '#' after the 'v' indicates 
the consecutive number of the migration, for example, to create the second 
migration to add a new table to store all the tags information the migration 
file will look like follows: v2__crate_tag_table.sql 

