# Configuring Flyway Database

configurazione datasource applicazione, in questo caso usiamo h2

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=databaseUser
spring.datasource.password=databasePassword

configurazione flyway

spring.flyway.user=databaseUser
spring.flyway.password=databasePassword
spring.flyway.schemas=app-db
spring.flyway.url=jdbc:h2:mem:testdb

dove si trovano gli script(src/main/resources)
spring.flyway.locations=db/migrations
