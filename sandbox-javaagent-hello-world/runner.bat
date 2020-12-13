rem compile and place agent jar here

javac Main.java
java -javaagent:sandbox-javaagent-1.0.jar -cp . Main
@PAUSE