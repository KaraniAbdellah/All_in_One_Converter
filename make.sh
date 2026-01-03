# Compile
javac --module-path /home/abdellah/javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.fxml all-in-one/src/App.java all-in-one/src/UI/*.java

# Run
java --module-path /home/abdellah/javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.fxml -cp all-in-one/src App

