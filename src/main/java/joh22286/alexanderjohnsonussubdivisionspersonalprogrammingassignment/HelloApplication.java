package joh22286.alexanderjohnsonussubdivisionspersonalprogrammingassignment;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private County county;

    MVPContract.Presenter myPresenter;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        stage.setTitle("State/County Info");

        myPresenter = new SubdivisionPresenter(this);

        resultLabel = new Label(); //cool idea for a label

        Label messageLabel = new Label("Enter The Name of a US State or County and Receive Checked Information:");

        //To get the State's name so we can get the information about the state
        tf_StateField = new TextField();
        tf_StateField.setPromptText("Enter State Name:");

        //Button so typed state name will connect with the state data, hopefully
        Button btnEnter = new Button("Enter");
        btnEnter.setOnAction(this::enterPressed);

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

        //State
        CheckBox capital = new CheckBox("Capital of State: ");
        capital.setOnAction(this::capitalChecked);

        CheckBox stateMotto = new CheckBox("State Motto: ");
        stateMotto.setOnAction(this::stateMottoChecked);

        CheckBox yearAdmitted = new CheckBox("Year Admitted to the Union: ");
        yearAdmitted.setOnAction(this::yearAdmittedChecked);

        //County
        CheckBox countySeat = new CheckBox("County Seat: ");
        countySeat.setOnAction(this::countySeatChecked);

        CheckBox isUrban = new CheckBox("Is County Urban (500,000+): ");
        isUrban.setOnAction(this::isUrbanChecked);

        CheckBox parentState = new CheckBox("State of County: ");
        parentState.setOnAction(this::parentStateChecked);



        VBox vboxPane = new VBox(10);
        vboxPane.setPadding(new Insets(20, 30, 20, 30));
        vboxPane.getChildren().addAll
                (messageLabel, tf_StateField, btnEnter, population, landArea, populationDensity, growthRate,
                futureProjectedPopulation, capital, stateMotto, yearAdmitted, countySeat,isUrban, parentState,
                resultLabel);

        // Set and show scene
        Scene scene = new Scene(vboxPane);
        stage.setScene(scene);
        stage.show();
    }

    private void populationChecked(ActionEvent actionEvent) {
        myPresenter.onPopulationChecked();
    }

    private void landAreaChecked(ActionEvent actionEvent) {
        myPresenter.onLandAreaChecked();
    }

    private void populationDensityChecked(ActionEvent actionEvent) {
        myPresenter.onPopulationDensityChecked();
    }

    private void growthRateChecked(ActionEvent actionEvent) {
        myPresenter.onGrowthRateChecked();
    }

    private void futureProjectedPopulationChecked(ActionEvent actionEvent) {
        myPresenter.onProjectedPopulationChecked();
    }

    //State
    private void capitalChecked(ActionEvent actionEvent){
        myPresenter.onCapitalChecked();
    }

    private void stateMottoChecked(ActionEvent actionEvent){
        myPresenter.onStateMottoChecked();
    }

    private void yearAdmittedChecked(ActionEvent actionEvent){
        myPresenter.onYearAdmittedChecked();
    }

    //County
    private void countySeatChecked(ActionEvent actionEvent){
        myPresenter.onCountySeatChecked();
    }

    private void isUrbanChecked(ActionEvent actionEvent){
        myPresenter.onIsUrbanChecked();
    }

    private void parentStateChecked(ActionEvent actionEvent){
        myPresenter.onParentStateChecked();

    }

    private void enterPressed(ActionEvent event){
        String subdivisionName = tf_StateField.getText();
        myPresenter.loadState(subdivisionName);
        myPresenter.loadCounty(subdivisionName);
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
        resultLabel.setText("Projected Population: " + (population +(growthRate * population)));

    }

    //State
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

    //County
    @Override
    public void showCountySeat(String countySeat) {
        resultLabel.setText("County Seat: " + countySeat);
    }

    @Override
    public void showIsUrban(boolean isUrban) {
        resultLabel.setText("Is County Urban" + isUrban);

    }

    @Override
    public void showParentState(String parentState) {
        resultLabel.setText("State County Resides: " + parentState);
    }

    public static void main(String[] args) {
        launch();
    }
}