---
Team planner case

## To run this application, you have to change the following application.properties.
---
- spring.datasource.username= *Your database username*
- spring.datasource.password= *Password for that user*
- if port change is needed change server.port=

---
- Then you'll have to create a mySQL database called teamplanner
- Have TomCat and Hibernate installed. XAMPP can help with that.
- Have Java 1.8 installed
- Make sure that the application.properties is in the same folder as jarfile.
---

## To run after installment and such type 
- java -jar jarfilename.jar in CMD from the directory.


## Mock data
- To create Skills/Technologies call - http://localhost:PORT_NUM/api/technology/MockData 
- To create persons call - http://localhost:PORT_NUM/api/person/MockData
