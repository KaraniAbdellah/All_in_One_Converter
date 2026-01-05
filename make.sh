# Compile
javac --module-path /home/abdellah/javafx-sdk-21.0.2/lib \
      --add-modules javafx.controls,javafx.fxml \
      -cp "all-in-one/lib/*" \
      all-in-one/src/App.java \
      all-in-one/src/UI/*.java \
      all-in-one/src/utils/*.java \
      all-in-one/src/services/*.java \
      all-in-one/src/Logic/x2j_j2x/*.java

# Run
java --module-path /home/abdellah/javafx-sdk-21.0.2/lib \
     --add-modules javafx.controls,javafx.fxml \
     -cp "all-in-one/src:all-in-one/lib/*" \
     App

