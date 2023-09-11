package com.example.interfasmuseoui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneoneController {
    @FXML
    private Button buttonRegistro;
    @FXML
    private Button buttonConsulta;


    @FXML
    private void CambioDePantallaRegistrto() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scenetwo.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage stage = (Stage) buttonRegistro.getScene().getWindow();
        stage.setScene(scene);
    }
    @FXML
    private void CambioDePantallaConsultar() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scenetres.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage stage = (Stage) buttonConsulta.getScene().getWindow();
        stage.setScene(scene);

    }

}
