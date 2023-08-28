# Слой DAO (Data Access Object) c Hibernate
##  Spring Boot приложение c Hibernate для работы с БД 

1. Создано [Entity](https://github.com/VioK0709/Data_Access_Object_Hibernate/blob/main/src/main/java/com/example/data_access_object_hibernate/entity/Persons.java).

2. Метод-обработчик getCity() с маппингом на endpoint /persons/by-city класса [контроллера](https://github.com/VioK0709/Data_Access_Object_Hibernate/blob/main/src/main/java/com/example/data_access_object_hibernate/controller/ControllerApp.java) умеет обрабатывать запрос вида: localhost:8080/persons/by-city?city=Moscow.

3. Контроллер возвращает данные человека по названию города, которые он получил от [репозитория](https://github.com/VioK0709/Data_Access_Object_Hibernate/blob/main/src/main/java/com/example/data_access_object_hibernate/repository/RepositoryApp.java).
