package sample;



import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.control.TableColumn;

import javafx.scene.control.TableView;

import javafx.scene.control.TextArea;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;

import java.util.*;

public class DynamicTableView {



    public TextArea createResultQuery(int cols, ArrayList<String> nametable, TextArea textArea , ArrayList<String> dataDB) {

        for(String k : dataDB)
        textArea.setText(k + "\n");


        return textArea;
    }



}





