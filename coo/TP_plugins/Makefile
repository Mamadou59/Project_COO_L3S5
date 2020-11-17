all : comp doc

comp:
	@mvn package
	
doc:
	@mvn javadoc:javadoc
	
plugin:
	@java -jar target/TP_plugins-1.0-SNAPSHOT.jar target/classes/plugins/plugins 
	
clean:
	@mvn clean
	
