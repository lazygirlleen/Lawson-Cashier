/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uas_a_2021110055;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author LIKMI
 */
public class FXML_UbahHargaController implements Initializable {
    
    
    @FXML
    private Button btnkembali;
    @FXML
    private Button btnreset;
    @FXML
    private Button btnsimpan;
    @FXML
    private TextField hgcheese;
    @FXML
    private TextField hgrabokki;
    @FXML
    private TextField hgtteobokki;
    @FXML
    private TextField hgodeng;
    @FXML
    private TextField hgdower;
    @FXML
    private TextField hgbaso;
    @FXML
    private TextField hgchicken;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hgbaso.setText(String.valueOf(
                FXMLDocumentController.dtharga.getBaso()));
        hgdower.setText(String.valueOf(
                FXMLDocumentController.dtharga.getDower()));
        hgodeng.setText(String.valueOf(
                FXMLDocumentController.dtharga.getOdeng()));
        hgtteobokki.setText(String.valueOf(
                FXMLDocumentController.dtharga.getTteobokki()));
        hgrabokki.setText(String.valueOf(
                FXMLDocumentController.dtharga.getRabokki()));
        hgcheese.setText(String.valueOf(
                FXMLDocumentController.dtharga.getCheese()));
        hgchicken.setText(String.valueOf(
                FXMLDocumentController.dtharga.getChicken()));
    }    

    @FXML
    private void kembaliklik(ActionEvent event) {
        btnkembali.getScene().getWindow().hide();
    }

    @FXML
    private void resetklik(ActionEvent event) {
        hgbaso.setText("12000");
        hgdower.setText("17000");
        hgodeng.setText("17000");
        hgtteobokki.setText("20000");
        hgrabokki.setText("17000");
        hgcheese.setText("25000");
        hgchicken.setText("25000");
    }

    @FXML
    private void simpanklik(ActionEvent event) {
         FXMLDocumentController.dtharga.setBaso(Integer.parseInt(hgbaso.getText()));
         FXMLDocumentController.dtharga.setDower(Integer.parseInt(hgdower.getText()));  
         FXMLDocumentController.dtharga.setOdeng(Integer.parseInt(hgodeng.getText()));  
         FXMLDocumentController.dtharga.setTteobokki(Integer.parseInt(hgtteobokki.getText()));  
         FXMLDocumentController.dtharga.setRabokki(Integer.parseInt(hgrabokki.getText()));  
         FXMLDocumentController.dtharga.setCheese(Integer.parseInt(hgcheese.getText()));  
         FXMLDocumentController.dtharga.setChicken(Integer.parseInt(hgchicken.getText()));  
         btnsimpan.getScene().getWindow().hide();  
    }
    
}
