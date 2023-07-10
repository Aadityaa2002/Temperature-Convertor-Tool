package com.example.javaapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public Label welcomeLabel;

    @FXML
    public ChoiceBox<String> TemperatureChoiceBox;

    @FXML
    public TextField TempTextField;

    @FXML
    public Button ConvertButton;

    private static final String C_TO_F_Text="Celsius to Fahrenheit";
    private static final String F_TO_C_Text="Fahrenheit to Celsius";

    //this is to set the boolean value
    private boolean isC_To_F=true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //this is to add elements on choice box
        TemperatureChoiceBox.getItems().add(C_TO_F_Text);
        TemperatureChoiceBox.getItems().add(F_TO_C_Text);

        //this is to set the default value in the choice box
        TemperatureChoiceBox.setValue(C_TO_F_Text);

        //this is to perform event handler on choice box
        TemperatureChoiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            //the observable value->Describes the properties of selected items
            //the old value->Describes which value was previously selected
            //the new value->Describes new value that is being now selected
            //this is to check the if condition selected value with the assigned boolean value at the top of the override
            if(newValue.equals(C_TO_F_Text)){
                isC_To_F=true;  //if user select celsius to Fahrenheit
            }
            else{
                isC_To_F=false; //if user select Fahrenheit to celsius
            }
        });

        //this is to perform event handler on button
        ConvertButton.setOnAction(event ->
                convert()); //call the method conversion
    }


    //this is to perform the conversion
    private void convert() {
        String input=TempTextField.getText();
        //this is to handle the exception(i.e) if the user enter any invalid value it shows some warning
        float temperature=0.0f;
        try{
            temperature=Float.parseFloat(input);
        }catch (Exception e){
            //this is to warn the user
            warnUser();
            return;//while we return anything the java code after the return statement will no executed in that method
        }

        float temp=0.0f;
        if(isC_To_F){
            temp=(temperature*9/5)+32;
        }else{
            temp=(temperature-32)*5/9;
        }
        display(temp);
    }

    private void warnUser() {
        Alert result=new Alert(Alert.AlertType.WARNING);
        result.setTitle("Temperature Convertor");
        result.setHeaderText("Result");
        result.setContentText("Enter valid Temperature");
        result.show();
    }

    //this is to display the ans
    private void display(float temp) {
        //Ternary Operator
        String unit=isC_To_F?"F":"C";
        System.out.println("The new Temperature is: " +temp+unit);

        //this is to display the result in the alert dialog box
        Alert result=new Alert(Alert.AlertType.INFORMATION);
        result.setTitle("Temperature Convertor");
        result.setHeaderText("Result");
        result.setContentText("The conversion temperature is: " +temp+unit);
        result.show();
    }
}
