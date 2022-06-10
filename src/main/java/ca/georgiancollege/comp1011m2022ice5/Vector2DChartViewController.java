package ca.georgiancollege.comp1011m2022ice5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ResourceBundle;

public class Vector2DChartViewController implements Initializable
{

    @FXML
    private BarChart<String, Float> barChart;

    @FXML
    private CategoryAxis categoryAxis;

    @FXML
    private NumberAxis numberAxis;

    @FXML
    private void LoadTableView(ActionEvent event) throws IOException
    {
        SceneManager.Instance().changeScene(event, "vector2d-tableview.fxml");
    }

    /**
     * This is just an example
     */
    @FXML
    private void AddSeries()
    {
        // create mock data with random numbers
        SecureRandom rng =  new SecureRandom();
        XYChart.Series<String, Float> magnitudes = new XYChart.Series<>();
        magnitudes.setName("2021");

        var mock1 = new Vector2D(rng.nextFloat(-50.0f, 50.0f), rng.nextFloat(-50.0f, 50.0f));
        var mock2 = new Vector2D(rng.nextFloat(-50.0f, 50.0f), rng.nextFloat(-50.0f, 50.0f));
        var mock3 = new Vector2D(rng.nextFloat(-50.0f, 50.0f), rng.nextFloat(-50.0f, 50.0f));

        magnitudes.getData().addAll(new XYChart.Data<>(mock1.toOneDecimalString(), mock1.getMagnitude()));
        magnitudes.getData().addAll(new XYChart.Data<>(mock2.toOneDecimalString(), mock2.getMagnitude()));
        magnitudes.getData().addAll(new XYChart.Data<>(mock3.toOneDecimalString(), mock3.getMagnitude()));

        barChart.getData().add(magnitudes);
    }

    //private XYChart.Series<String, Float> magnitude;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        barChart.getData().addAll(DBManager.Instance().getMagnitude());
        numberAxis.setLabel("Magnitude");
        categoryAxis.setLabel("Vector2D");
        barChart.setLegendVisible(false);
    }
}
