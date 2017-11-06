/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.melvin.thetaubatepregnant;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author AccessTech
 */
public class BabyRegister extends Application {
    
    
    @Override
    public void start(Stage primaryStage) {
        
        
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(BabyRegister.class.getClassLoader().getResource("com/melvin/thetaubatepregnant/views/Application.fxml"));
            Parent root =  loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("The Taubaté Pregnant");
            //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            //System.out.println("babies---"+sdf.format(babies.get(0).getBirthday()) +"..."+ babies.get(0).getName() +"..."+ babies.get(0).getGender());
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(BabyRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //populateBabyTable();
        
        //populateGiftTable();
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
