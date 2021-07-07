package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();

            ObservableList<PetrolEngine> petrolEngines = FXCollections.observableArrayList(); // Diese Liste ist der
                                                                                              // Inhalt der Tabelle, der
                                                                                              // in der TableView
                                                                                              // angezeigt wird.
            petrolEngines.add(new PetrolEngine("1.0", "161 km/h"));
            petrolEngines.add(new PetrolEngine("1.1", "181 km/h"));
            petrolEngines.add(new PetrolEngine("2.0", "261 km/h"));

            TableView<PetrolEngine> tableView = new TableView<>(petrolEngines);
            TableColumn<PetrolEngine, String> modelColumn = new TableColumn<>("Model"); // Erstellen von Spalten für die
                                                                                        // Tabelle. Ohne diese Spalten
                                                                                        // hätte die Tabelle keinen
                                                                                        // Inhalt.
            modelColumn.setCellValueFactory(new PropertyValueFactory<>("model")); // Verknüpfen die Spalte mit einem
                                                                                  // Attribut der dargestellten Objekte.
                                                                                  // ACHTUNG: Der String, den wir als
                                                                                  // Argument an die Factory übergeben,
                                                                                  // muss zu einem entsprechenden Getter
                                                                                  // in der darzustellenden Klasse
                                                                                  // passen. D.h. der Name des Getters
                                                                                  // muss der Konvention entsprechen und
                                                                                  // den passenden Namen des Attributs
                                                                                  // haben.

            TableColumn<PetrolEngine, String> speedColumn = new TableColumn<>("Top Speed");
            speedColumn.setCellValueFactory(new PropertyValueFactory<>("topSpeed"));

            tableView.getColumns().addAll(modelColumn, speedColumn);

            root.setCenter(tableView);

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
