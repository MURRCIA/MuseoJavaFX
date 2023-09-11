package com.example.interfasmuseoui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;


public class ScenetwoController {
    @FXML
    public ChoiceBox<String> CategoriaBox;
    @FXML
    public ChoiceBox<String> identificacionBox;
    @FXML
    public DatePicker Dateselect;

    //TxtFile
    @FXML
    public TextField txtNombre;
    @FXML
    public TextField txtApellido;
    @FXML
    public TextField txtIdentificacion;
    //Bonotomes
    @FXML
    private Button buttonconsultarRegistro;
    @FXML
    private Button buttonConsultar;



    @FXML
    public void initialize() {

        // Configuracion de los box de categoria, identificacion, fecha//*

        //Categoria list
        ObservableList<String> CategoriaList = FXCollections.observableArrayList("A", "B", "C");
        //Identificacion list
        ObservableList<String> identificacionList = FXCollections.observableArrayList("Cedula de ciudadania", "Targeta de identidad", "Cedula de extrangeria");

        //Selector de Categoria
        CategoriaBox.setItems(CategoriaList);
        CategoriaBox.setValue("Selecciona la categoria");

        //Selector de identrificacion
        identificacionBox.setItems(identificacionList);
        identificacionBox.setValue("Selecciona el tipo de documento");
    }

    private void SelectTheDay() {
        LocalDate selectedDate = Dateselect.getValue();
        System.out.println("Fecha seleccionada" + selectedDate);
    }

    // Creación de la lista de usuarios
    public static ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();



    private int calcularEdad(LocalDate fechaNacimiento){
        LocalDate fechaActual = LocalDate.now();
        int edad = fechaActual.getYear() - fechaNacimiento.getYear();

        // Ajusta la edad si aún no ha cumplido años en este año
        if (fechaNacimiento.getMonthValue() > fechaActual.getMonthValue()
                || (fechaNacimiento.getMonthValue() == fechaActual.getMonthValue()
                && fechaNacimiento.getDayOfMonth() > fechaActual.getDayOfMonth())) edad--;

        return edad;
    }

    public void costoPorPersona(Usuario usuario) {
        double costo = CostoUtil.calcularCostoPorPersona(usuario);
        usuario.setCostoPorPersona(costo);
    }

    @FXML
    public void confirmarRegistro() {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(txtNombre.getText());
        nuevoUsuario.setApellido(txtApellido.getText());
        nuevoUsuario.setTipoDocumento(identificacionBox.getValue());
        nuevoUsuario.setNumeroDocumento(txtIdentificacion.getText());
        nuevoUsuario.setFechaCumpleanos(Dateselect.getValue());
        nuevoUsuario.setEdad(calcularEdad(nuevoUsuario.getFechaCumpleanos()));
        nuevoUsuario.setCategoria(CategoriaBox.getValue());
        costoPorPersona(nuevoUsuario);

        listaUsuarios.add(nuevoUsuario);
        //


        // Imprimir la lista de usuarios en la consola
        for (Usuario usuario : listaUsuarios) {
            System.out.println("Nombre: " + usuario.getNombre() +
                    ", Apellido: " + usuario.getApellido() +
                    ", Edad: " + usuario.getEdad() +
                    ", Categoría: " + usuario.getCategoria() +
                    ", Costo Por Persona: " + usuario.getCostoPorPersona());
        }

        txtNombre.clear();
        txtApellido.clear();
        txtIdentificacion.clear();
        Dateselect.setValue(null);
        CategoriaBox.setValue("Selecciona la categoria");

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Registro exitoso");
        alert.setHeaderText(null);
        alert.setContentText("Usted se ha registrado exitosamente");
        alert.showAndWait();
    }




    // Cambio de pantalla para el botón
    @FXML
    private void CambioDePantallaConsultar() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scenetres.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage stage = (Stage) buttonConsultar.getScene().getWindow();
        stage.setScene(scene);
    }
}
