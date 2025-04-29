package joh22286.alexanderjohnsonussubdivisionspersonalprogrammingassignment;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application implements MVPContract.View {

    private TextField tf_StateField;


    private Label resultLabel;
    private State state;

    MVPContract.Presenter myPresenter;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        stage.setTitle("State Info");

        myPresenter = new SubdivisionPresenter(this);


        Label messageLabel = new Label("Enter The Name of a US State and Receive Checked Information:");

        //To get the State's name so we can get the information about the state
        tf_StateField = new TextField();
        tf_StateField.setPromptText("Enter State Name:");

        // Check boxes so the suer can choose what they want to know
        CheckBox population = new CheckBox("Population:");
        population.setOnAction(this::populationChecked);


        CheckBox landArea = new CheckBox("Land Area:");
        landArea.setOnAction(this::landAreaChecked);

        CheckBox populationDensity = new CheckBox("Population Density:");
        populationDensity.setOnAction(this::populationDensityChecked);

        CheckBox growthRate = new CheckBox("Growth Rate");
        growthRate.setOnAction(this::growthRateChecked);

        CheckBox futureProjectedPopulation = new CheckBox("Future Projected Population (50 years)");
        futureProjectedPopulation.setOnAction(this::futureProjectedPopulationChecked);

        VBox vboxPane = new VBox(10);
        vboxPane.setPadding(new Insets(20, 30, 20, 30));
        vboxPane.getChildren().addAll(messageLabel, tf_StateField, population,landArea, populationDensity, growthRate, futureProjectedPopulation);


        // Set and show scene
        Scene scene = new Scene(vboxPane);
        stage.setScene(scene);
        stage.show();
    }

    private void futureProjectedPopulationChecked(ActionEvent actionEvent) {
    }

    private void growthRateChecked(ActionEvent actionEvent) {
    }

    private void populationDensityChecked(ActionEvent actionEvent) {
    }

    private void landAreaChecked(ActionEvent actionEvent) {

    }

    private void populationChecked(ActionEvent actionEvent) {
        resultLabel.setText("Population: " + state.getPopulation());
    }



    public static void main(String[] args) {
        launch();
    }

    @Override
    public void showPopulation(Float population) {
        resultLabel.setText("Population: " + population);
    }

    @Override
    public void showLandArea(Float landArea) {
        resultLabel.setText("Area: " + landArea);
    }

    @Override
    public void showPopulationDensity(Float population, Float landArea) {
        resultLabel.setText("Population Density: " + population/landArea + "/km2");
    }

    @Override
    public void showGrowthRate(Float growthRate) {
        resultLabel.setText("Growths Rate (Decimal): " + growthRate);
    }

    @Override
    public void showProjectedPopulation(Float population, Float growthRate) {
        resultLabel.setText("Projected Population: " + 50 * growthRate * population);

    }

    @Override
    public void showCapital(String capital) {
        resultLabel.setText("Capital: " + capital);
    }

    @Override
    public void showStateMotto(String stateMotto) {
        resultLabel.setText("State Motto: " + stateMotto);

    }

    @Override
    public void showYearAdmitted(Integer yearAdmitted) {
        resultLabel.setText("Year Admitted to the Union: " + yearAdmitted);

    }
}