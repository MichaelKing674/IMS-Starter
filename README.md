Coverage: 64.3%
# IMS Project

This product is a basic information management system that will allow the user to interact with a provided database; they will be able to use CRUD functions ( create, read, update, delete ) to manipulate the data.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
You will need JRE 8 or above installed - https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html
```

### Installing

On the repository, click on the ( <> Code ) tab in the top left

```
<> Code
```

Then click on the ( Code ) buttom next to the green "Use template" button

```
Code
```
Then download this as a zip file to a location of your choosing

```
Download ZIP
```

Extract the .zip file. 

Install Maven dependencies in your POM file - https://mvnrepository.com/artifact/junit/junit/4.12

Then type the following command in your command prompt window whilst in the root directory of the project:

```
mvn clean package
```
This will package the project and create a runnable .jar file in the target folder that has just been created.

To run the application, use the command prompt and type the following:

```
cd target
```
```
java -jar ims-0.0.1-jar-with-dependencies.jar
```
You can press TAB at any time to auto complete the command.

## Running the tests

To run your own tests, you would need to open the project inside an IDE, such as eclipse, and run the src/test/java package as a JUNIT Test

### Integration Tests 

The integration tests are any with "DAO" in the name, these test the methods used to integrate with the database.

```
e.g CustomerDAOTest, ItemDAOTest etc
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Michael King** - *Added extra functionality*- [MichaelKing](https://github.com/MichaelKing674)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 


## Acknowledgments

Appreciation to Chris Perrins for an easy-to-follow starter to this IMS.
