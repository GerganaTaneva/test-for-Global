### Description
In this repository can be found the test to Global Media and Entertainment Limited company with the following steps:
* Open site https://magento.softwaretestingboard.com/
* Add to cart 4 - Gwyn Endurance Tee Medium Green
* Address should United Kingdom
* Check cart total is $92.00 (discount applied)
* Update the Quantity of  Gwyn Endurance Tee Medium Green to 3
* Add to cart 1 - Gwyn Endurance Tee Small Yellow
* Add to cart 1 Quest Lumaflex™ Band
* Check cart total is $116.00

This test scenario is writen on Carina testing framework(check bellow how can be set up the local environment).
Moreover after research in the functionality the last step(Check cart total is $116.00) cannot be satisfied. If we want to deliver the products to United Kingdom, we have fixed shipping of $25.00. The price of all products is $115.00 and the final price of the cart is $140.00. 
On the other hand if the shipping country is United States, the shipping fee is either $0, or $25.00. Either way the price is not the same as the one in the requirements - $116.00. I have checked the rest of the countries and the situation was similar with them. So the test case will be negative in every situation.

-------------------------
### Getting started
* Install and configure JDK 11
* Install and configure [Apache Maven 3.6.0+](http://maven.apache.org/)
* Download and start the latest [Selenium standalone server] on port 4545 (http://www.seleniumhq.org/download/)
* Download the latest version of [Eclipse](http://www.eclipse.org/downloads/) and install [TestNG plugin](http://testng.org/doc/download.html)
* [Read Carina documentation](https://zebrunner.github.io/carina/)

### Import to Eclipse
If generation is successfully complete, you would see a new project folder with a name equal to the artifactId attribute specified during generation, so navigate to that folder (where pom.xml is located) and execute the following Maven task:
```
mvn clean eclipse:eclipse
```
By executing this command, Maven should resolve all dependencies, downloading required libraries to your local repository and generating Eclipse classpath. Before importing new project to Eclipse, you should link your IDE to your Maven repository by executing the following task:
```
mvn -Dworkspace=<path_to_workspace> eclipse:configure-workspace
```
Here you have to specify the absolute path to the Eclipse workspace. After that, restart Eclipse IDE. Now you can import generated projects such as "Existing Java Project" into Eclipse IDE.
Generate Eclipse workspace using command:
```
mvn clean eclipse:eclipse
```

### Run tests
```
mvn clean test -Dsuite=api
```

