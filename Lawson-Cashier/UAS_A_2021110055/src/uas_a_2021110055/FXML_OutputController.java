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
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author LIKMI
 */
public class FXML_OutputController implements Initializable {

    @FXML
    private Button btnkeluar;
    @FXML
    private Label lblkembalian;
    @FXML
    private Label lbltunai;
    @FXML
    private Label lblhrtotal;
    @FXML
    private Label lblhrtambahan;
    @FXML
    private Label lbltambahan;
    @FXML
    private Label lblharga;
    @FXML
    private Label lbljumlah;
    @FXML
    private Label lblnama;
    @FXML
    private Label lblpembeli;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void keluarklik(ActionEvent event) {
        System.exit(0);
    }
    
     public void getdata(UAS_A_2021110055_Model d){
        int hitem = 0;
        int jumlah = 0;
        int harga = 0;
        int tambahan = 0;
        String item = "";
        String ntambahan = "";
       
        
       switch(d.getPilihItem()){
            case 0 : item = "Pop Mie Baso"; hitem = FXMLDocumentController.dtharga.getBaso(); jumlah = d.getJmlhItem();break;
            case 1 : item = "Pop Mie Dower"; hitem = FXMLDocumentController.dtharga.getDower(); jumlah = d.getJmlhItem();break;
            case 2 : item = "Odeng"; hitem = FXMLDocumentController.dtharga.getOdeng();jumlah = d.getJmlhItem(); break;
            case 3 : item = "Tteobokki"; hitem = FXMLDocumentController.dtharga.getTteobokki(); jumlah = d.getJmlhItem();break;
            case 4 : item = "Rabokki"; hitem = FXMLDocumentController.dtharga.getRabokki();jumlah = d.getJmlhItem();break;
            case 5 : item = "Cheesebokki"; hitem = FXMLDocumentController.dtharga.getCheese();jumlah = d.getJmlhItem();break;
            case 6 : item = "Chicken Karaage"; hitem = FXMLDocumentController.dtharga.getChicken(); jumlah = d.getJmlhItem(); 
             
          default: item="Belum dipilih";hitem = 0;jumlah = 0;                      
        }
       
         
            if(d.getPilihTambahan() == 3){
               ntambahan = "Air Putih"; tambahan = 3000;
            } else if (d.getPilihTambahan() == 2) {
                ntambahan = "Ice Coffee";tambahan = 10000;
            } else if (d.getPilihTambahan() == 1) {
                ntambahan = "Es Pandan";tambahan = 15000;
            }
        
        
//        int total= hitem + htambahan;
        int hargaitem = hitem * jumlah;
        lblharga.setText(String.valueOf(hargaitem));  
        int total = hargaitem + tambahan;
        lblhrtotal.setText(String.valueOf(total));  
        int kembalian = d.getTunai() - total;
        
           if (kembalian < 0) { lblkembalian.setText("Uang Kurang");}
           else { lblkembalian.setText(String.valueOf(kembalian));}
                 
        lblpembeli.setText(String.valueOf(d.getPembeli()));
        lblnama.setText(item);
        lbljumlah.setText(String.valueOf(jumlah));
        lblharga.setText(String.valueOf(hitem));
        lbltambahan.setText(String.valueOf(ntambahan));
        lblhrtambahan.setText(String.valueOf(tambahan));
        lblhrtotal.setText(String.valueOf(total));
        lbltunai.setText(String.valueOf(d.getTunai()));
        lblkembalian.setText(String.valueOf(kembalian));
    
    }
          
    
}

    
