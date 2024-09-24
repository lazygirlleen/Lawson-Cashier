/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package uas_a_2021110055;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author LIKMI
 */
public class FXMLDocumentController implements Initializable {
    UAS_A_2021110055_Model dt = new UAS_A_2021110055_Model();
    public static UbahHargaModel dtharga = new UbahHargaModel();
    
    
    private Label label;
    @FXML
    private RadioButton rdbespandan;
    @FXML
    private RadioButton rdbicecoffee;
    @FXML
    private RadioButton rdbairputih;
    @FXML
    private ChoiceBox<String> chbitem;
    @FXML
    private Button btnubah;
    @FXML
    private TextField txtjmlhitem;
    private TextField txttotalharga;
    @FXML
    private Button btnkeluar;
    @FXML
    private Button btnhitung;
    @FXML
    private TextField txtpembeli;
    private ComboBox<String> chbmembership;
    private TextField txttharga;
    @FXML
    private TextField txttunai;
    private TextField txtkembalian;
    @FXML
    private Button btnhapus;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        chbitem.setItems(FXCollections.observableArrayList(
        "Pop Mie Baso",
        "Pop Mie Dower",
        "Odeng", 
        "Tteobokki",
        "Rabokki",
        "Cheesebokki",
        "Chicken Karaage"));
        chbitem.getSelectionModel().select(0);
        
//        chbmembership.setItems(FXCollections.observableArrayList(
//        "Membership",
//        "Non-Membership"));
//        chbmembership.getSelectionModel().select(0);
        
        dtharga.setBaso(5200);
        dtharga.setDower(4700);
        dtharga.setOdeng(14000);
        dtharga.setTteobokki(30000);
        dtharga.setRabokki(22000);
        dtharga.setCheese(35000);
        dtharga.setChicken(15000);
    }    

  
    @FXML
    private void ubahhargaklik(ActionEvent event) {
        try{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("FXML_UbahHarga.fxml"));      
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        Stage stg=new Stage();
        stg.initModality(Modality.APPLICATION_MODAL);
        stg.setResizable(false);
        stg.setIconified(false);
        stg.setScene(scene);
        stg.show();        
        } catch (IOException e){   e.printStackTrace();   
    }
    }



    @FXML
    private void keluarklik(ActionEvent event) {
         System.exit(0);
    }



    @FXML
    private void modelessklik(ActionEvent event) {
          dt.setPembeli(txtpembeli.getText());
          dt.setPilihItem(chbitem.getSelectionModel().getSelectedIndex());
          dt.setJmlhItem(Integer.parseInt(txtjmlhitem.getText()));
         if(txttunai.getText().isEmpty()){
            do{
                TextInputDialog tx=new TextInputDialog();                
                tx.setContentText("Masukkan uang untuk membayar: ");
                tx.setTitle("Masukan uang!");
                tx.showAndWait();
                txttunai.setText(tx.getResult());
            }while(txttunai.getText().isEmpty());
	} 
         dt.setTunai(Integer.parseInt(txttunai.getText()));
         
        int tambahan = 0;
        if (rdbairputih.isSelected()) tambahan = 3;
        else if (rdbicecoffee.isSelected()) tambahan = 2;
        else if (rdbespandan.isSelected()) tambahan = 1;
        dt.setPilihTambahan(tambahan);
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Output.fxml"));
            Parent root = (Parent) loader.load();
        //koding untuk mengirim data ke tampilan output
            FXML_OutputController isidt
                    = (FXML_OutputController) loader.getController();
            isidt.getdata(dt);
            
            Scene scene = new Scene(root);
            Stage stg=new Stage();
            
            stg.setScene(scene);
            stg.show(); 
        } catch (IOException e){   e.printStackTrace();   }
    }

    @FXML
    private void hapusklik(ActionEvent event) {
        txtpembeli.setText("");
        chbitem.valueProperty().set(null);
        txtjmlhitem.setText("");
        txttunai.setText("");
       
        
    }
    }
    

