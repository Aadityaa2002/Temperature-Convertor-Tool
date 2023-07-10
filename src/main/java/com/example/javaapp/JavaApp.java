package com.example.javaapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class JavaApp extends Application {

    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage PrimaryStage)throws Exception{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode=loader.load();
        Scene scene=new Scene(rootNode);
        PrimaryStage.setScene(scene);
        PrimaryStage.setTitle("Temperature Converter");
        PrimaryStage.show();

        //This is to call the menu bar
        MenuBar menuBar=CreateMenu();
        rootNode.getChildren().add(0,menuBar);
    }
    private MenuBar CreateMenu(){

        //This is to create menus at the menu bar
        Menu FileMenu=new Menu("File");
        //This is to create the menu items at the menu bar
        MenuItem newMenu=new MenuItem("New");
        //This is to perform click event on the newMenu
        newMenu.setOnAction(event -> System.out.println("New Menu Item Clicked"));
        //This is to separate a line between the menus
        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();

        //This is to create the menu items at the menu bar
        MenuItem QuitMenu=new MenuItem("Quit");
        //This is to perform click event on the Quit Menu
        QuitMenu.setOnAction(event -> {
            System.out.println("Quit button clicked");
            Platform.exit();
            System.exit(0);
        });

        //This is to add all the menus inside the menu bar
        FileMenu.getItems().addAll(newMenu,separatorMenuItem,QuitMenu);

        //This is to create menus at the menu bar
        Menu HelpMenu=new Menu("Help");
        //This is to create the menu items at the menu bar
        MenuItem Aboutapp=new MenuItem("About app");
        //This is to perform the event handler and call the about app method inside the event handler
        Aboutapp.setOnAction(event -> aboutApp());
        HelpMenu.getItems().addAll(Aboutapp);

        //This is to add the menus at the menu bar
        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(FileMenu,HelpMenu);
        return menuBar;
    }

    public static void aboutApp() {
        //This is to show the detailed description about the application
        Alert aboutApp=new Alert(Alert.AlertType.INFORMATION);
        aboutApp.setTitle("Temperature Converter");
        aboutApp.setHeaderText("Detailed description about the app");
        aboutApp.setContentText("This is the app");
        ButtonType yesButton=new ButtonType("Yes");
        ButtonType noButton=new ButtonType("No");
        aboutApp.getButtonTypes().setAll(yesButton,noButton);
        Optional<ButtonType>ClickedButton=aboutApp.showAndWait();
        if(ClickedButton.isPresent()&&ClickedButton.get()==yesButton){
            System.out.println("Yes Button Clicked");
        }else{
            System.out.println("No Button Clicked");
        }
    }
}
