package sample;


import javafx.scene.control.Button;

import java.util.ArrayList;

public class SelectQuery  {

  ArrayList<String> arrayListString;

Database database = new Database();

private  String tableName;
private  String columnName;


public SelectQuery(){
  arrayListString = new ArrayList<>();
}


  ArrayList<Button> createBtnSelcet(String table){


    tableName = table;
    ArrayList<String> listTextColumn = new ArrayList<>();
    ArrayList<Button> listButtonColumn = new ArrayList<>();

    listTextColumn  =  database.selectNameColumnt(table);
    for(String i:  listTextColumn)
    listButtonColumn.add(new Button(i));


    return listButtonColumn;
  }



   void createQueryColumnSelect(ArrayList<Button> listButtonColumn){

      for(Button i :listButtonColumn){
        i.setOnAction(event -> {
     columnName = i.getText();

        });
      }

  }












}
