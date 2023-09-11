package com.example.interfasmuseoui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.collections.ObservableList;
import java.util.List;

public class ScenetresController {

    @FXML
    private TableView<Usuario> tableViewUsuarios;
    @FXML
    private TableColumn<Usuario, String> columnNombre;
    @FXML
    private TableColumn<Usuario, String> columnApellido;
    @FXML
    private TableColumn<Usuario, String> columnCategoria;
    @FXML
    private TableColumn<Usuario, Integer> columnEdad;
    @FXML
    private TableColumn<Usuario, String> columnTipoDocumento;
    @FXML
    private TableColumn<Usuario, String> columDocumento;
    @FXML
    private TableColumn<Usuario, Double> columnCosto;
    @FXML
    private Button buttonImprimir;

    public void costoPorPersona(Usuario usuario) {
        double costo = CostoUtil.calcularCostoPorPersona(usuario);
        usuario.setCostoPorPersona(costo);
    }

        public void initialize () {

            // Calcula y establece el costo por persona para cada usuario
            for (Usuario usuario : ScenetwoController.listaUsuarios) {
                costoPorPersona(usuario);}

            // Vincula las columnas con los atributos de la clase Usuario
            columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            columnApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
            columnCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
            columnEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
            columnTipoDocumento.setCellValueFactory(new PropertyValueFactory<>("tipoDocumento"));
            columDocumento.setCellValueFactory(new PropertyValueFactory<>("numeroDocumento"));
            columnCosto.setCellValueFactory(new PropertyValueFactory<>("costoPorPersona"));

            // Agrega los datos de listaUsuarios a la tabla
            tableViewUsuarios.setItems(ScenetwoController.listaUsuarios);
        }

    public void obtenerArchivoDeTexto() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos de Texto", "*.txt"));
        File archivoSeleccionado = fileChooser.showSaveDialog(new Stage());

        if (archivoSeleccionado != null) {
            guardarDatosEnArchivo(archivoSeleccionado, ScenetwoController.listaUsuarios); // Accedemos a la lista de usuarios desde ScenetwoController
        }
    }

    // Método para guardar los datos en el archivo
    public void guardarDatosEnArchivo(File archivo, ObservableList<Usuario> usuarios) {
        try (FileWriter fileWriter = new FileWriter(archivo)) {
            for (Usuario usuario : usuarios) {
                String linea = String.format(
                        "Nombre: %s, Apellido: %s, Edad: %d, Categoría: %s, Costo Por Persona: %.2f",
                        usuario.getNombre(), usuario.getApellido(), usuario.getEdad(), usuario.getCategoria(), usuario.getCostoPorPersona()
                );
                fileWriter.write(linea + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }



