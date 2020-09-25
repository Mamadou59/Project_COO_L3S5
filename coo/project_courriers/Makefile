all : comp doc

comp:
	@mvn package
	
doc:
	@mvn javadoc:javadoc
	
sim1:
	@java -jar target/TP_courriers-1.0-SNAPSHOT.jar
	
sim2:
	@java -jar target/TP_courriers-1.0-SNAPSHOT.jar 2

cons2:
	@java -jar target/TP_courriers-1.0-SNAPSHOT.jar 2 > sim2.txt
	
head:
	@head -n 30 sim2.txt
tail:
	@tail -n 30 sim2.txt
	
clean:
	@mvn clean
	@rm sim2.txt
	