package ca.georgiancollege.comp1011m2022ice5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Vector2DTableViewController implements Initializable
{
    @FXML
    private TableView<Vector2D> tableView;

    @FXML
    private TableColumn<Vector2D, Integer> VectorIDColumn;

    @FXML
    private TableColumn<Vector2D, Float> XColumn;

    @FXML
    private TableColumn<Vector2D, Float> YColumn;

    @FXML
    private TableColumn<Vector2D, Float> MagnitudeColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        VectorIDColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        XColumn.setCellValueFactory(new PropertyValueFactory<>("X"));
        YColumn.setCellValueFactory(new PropertyValueFactory<>("Y"));
        MagnitudeColumn.setCellValueFactory(new PropertyValueFactory<>("Magnitude"));

        tableView.getItems().addAll(DBManager.Instance().readVectorTable());

        // example with Mock Data
        /*
        ObservableList<Vector2D> data = FXCollections.observableArrayList(
                new Vector2D(0, 0.0f, 0.0f),
                new Vector2D(1, 10, 20),
                new Vector2D(2, 10, 20),
                new Vector2D(3, 30, 40),
                new Vector2D(4, 50, 60),
                new Vector2D(5, 70, 80)
        );

        tableView.getItems().addAll(data);

         */
    }
}
