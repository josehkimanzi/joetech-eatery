# joetech-eatery
Create a database called 'interfaces_schema'
DB user: 'interfaceuser'
DB passw: 'password'
to run in a linux box, build the jar file, configure the application.properties as desired then include the path in the run command as illustrated below;
 nohup java -jar eatery-0.0.1-SNAPSHOT.jar -Dspring.config.name=application.properties -Dspring.config.location=/home/system/apps/java/EATERY &
