# Spring Boot CRUD application used for training IWConnect Junior Developers

Sample CRUD project based on Spring Boot, Spring Data, Mysql

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

* Java JDK 8

### Installing

* Get the project from GIT "git clone <TODO>"
* Set datasource url of your MYSQL DB application.properties -> spring.datasource.url
* Set mysql user value into application.properties -> spring.datasource.username
* Set mysql user password value into application.properties -> spring.datasource.password

### Build and Start the project
* go to root directory of the project
* mvnw clean package
* java -jar .\target\iw-labs-crud-library-0.0.1-SNAPSHOT.jar

## Running the tests

.\mvnw test - command for running the junit tests

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot)
* [Maven](https://maven.apache.org/) - Dependency Management
* [MySql](https://www.mysql.com/) 

## Demo

After you start the application the server will listen on port 8090
* Get all books <br />
HTTP GET localhost:8090/api/books/
* Create new book <br />
HTTP POST localhost:8090/api/books/ <br />
Payload Json Body <br />
{
   "title": "NEW TITLE",
   "description": "NEW DESCRIPTION"
}
* Update existing book <br />
HTTP PUT localhost:8090/api/books/<UUID> - comment replace UUID with existing book UUID <br />
Payload Json Body <br />
{
   "title": "UPDATE TITLE",
   "description": "UPDATE DESCRIPTION"
}

* Delete Resource <br />
localhost:8090/api/books/<UUID> - comment replace UUID with existing book UUID <br />

## Authors

* **Nikola Popovski** - *Initial work* - [Repository](https://github.com/popovski)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
