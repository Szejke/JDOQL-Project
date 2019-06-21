package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Filmy;

import javax.swing.text.View;
import java.util.ArrayList;

public class Gui {




    Database database = new Database();

    VBox container = new VBox();
    HBox raw1 = new HBox();
    HBox raw2 = new HBox();
    HBox raw3 = new HBox();

    HBox raw4 = new HBox();

  void  startGui(Stage primaryStage){

      container.getChildren().add(raw1);
      container.getChildren().add(raw2);
      container.getChildren().add(raw3);
      container.getChildren().add(raw4);

  primaryStage.setTitle("Hello World");
     primaryStage.setScene(new Scene(container, 1200, 900));

      database.testSelect();

      for(Button k:firstButtonArray())
          raw1.getChildren().add(k);


  }


    ArrayList<Button> firstButtonArray(){
       Button btn_add = new Button();
       Button btn_update = new Button();
       Button btn_delete = new Button();
       Button btn_select= new Button();

       btn_add.setText("Dodaj");
       btn_update.setText("Modyfikuj");
       btn_delete.setText("Usuń");
       btn_select.setText("SELECT");
       actionBtn_addRaw1(btn_add);

        acctionBtnSelect(btn_select);

       ArrayList<Button> buttonFirst = new ArrayList();
      buttonFirst.add(btn_add);
      buttonFirst.add(btn_update);
      buttonFirst.add(btn_delete);
      buttonFirst.add(btn_select);

      return buttonFirst;
  }

  void actionBtn_addRaw1(Button btn_add){

      ArrayList<Button> buttonsNameTable = new ArrayList();

      btn_add.setOnAction((event) -> {

          generateNameTableButton(database.getTableNameList(), buttonsNameTable);
          for(Button i:buttonsNameTable){
              i.setOnAction((event1 -> {


                  String nameButton = i.getText();



                 generateViewaAreaAdd(nameButton);
                 buttonsNameTable.clear();


              }));

              raw2.getChildren().add(i);
          }

      });

  }




  void acctionBtnSelect(Button btn_select ){

      VBox raw3Panel = new VBox();

      VBox panelButton = new VBox();
      VBox PanelSign = new VBox();
      HBox result = new HBox();
      TextArea textArea = new TextArea();
      DynamicTableView dynamicTableView = new DynamicTableView();

      ObservableList<ObservableList<String>> dataDB = null;

      raw3Panel.getChildren().add(panelButton);
      raw3Panel.getChildren().add(PanelSign);
      raw3Panel.getChildren().add(result);


            btn_select.setOnAction( event -> {
                raw2.getChildren().clear();
                raw3.getChildren().clear();

                SelectQuery selectQuery = new SelectQuery();

                ArrayList<Button> buttonsNameTable = new ArrayList();

                generateNameTableButton(database.getTableNameList(), buttonsNameTable);
                for (Button i : buttonsNameTable) {
                    i.setOnAction(event1 -> {
                        int col = database.selectNameColumnt(i.getText()).size();
                          ArrayList<String> list = database.selectNameColumnt(i.getText());

                        result.getChildren().add(dynamicTableView.createResultQuery(col, list, textArea, database.selectAll(i.getText()) ));

                        String nameButton = i.getText();

                        for (Button k : selectQuery.createBtnSelcet(nameButton))
                            panelButton.getChildren().add(k);


                        buttonsNameTable.clear();


                    });

                    raw3.getChildren().add(i);
                }
                raw4.getChildren().add(raw3Panel);

            });

  }










  void generateViewaAreaAdd(String nameButton){
      ArrayList<String> listColumnName = new  ArrayList<>();
      ArrayList<Control> listElement = new ArrayList<>();
      listColumnName =  database.selectNameColumnt(nameButton);


      VBox raw3Panel = new VBox();


          for (String k:listColumnName) {
              listElement.add(new Label("Wypelnij: " + k));
              listElement.add(new TextField());
          }

      raw3.getChildren().add(raw3Panel);
          listElement.remove(0);
          listElement.remove(0);

      for (Control k:listElement)
      raw3Panel.getChildren().add(k);

      if (nameButton.equals("filmy"))
    raw3Panel.getChildren().add(createObjectFilmy(listElement , raw3Panel));

      else if (nameButton.equals("katalog"))
      raw3Panel.getChildren().add(createObjectStatus(listElement , raw3Panel));
      else if (nameButton.equals("kategorie"))
          raw3Panel.getChildren().add(createObjectStatus(listElement , raw3Panel));
      else if (nameButton.equals("role"))
          raw3Panel.getChildren().add(createObjectStatus(listElement , raw3Panel));
      else if (nameButton.equals("uprwnieniauz"))
          raw3Panel.getChildren().add(createObjectStatus(listElement , raw3Panel));
      else if (nameButton.equals("uzytkownicy"))
          raw3Panel.getChildren().add(createObjectStatus(listElement , raw3Panel));

  }

    Button createObjectStatus(ArrayList<Control> listElement ,VBox raw3Panel) {

        Button button = new Button();
        ArrayList<TextField> arrayTextField = new ArrayList();
        arrayTextField.add((TextField) listElement.get(1));

        button.setOnAction(event -> {
            database.addStatus(arrayTextField.get(0).getText());
            raw3.getChildren().clear();
            raw2.getChildren().clear();
            raw3Panel.getChildren().clear();

        });
        button.setText("Accept");


        return button;
    }

    Button createObjectKatalog(ArrayList<Control> listElement ,VBox raw3Panel){

        Button button = new Button();
        ArrayList<TextField> arrayTextField = new ArrayList();
        arrayTextField.add((TextField) listElement.get(1));
        arrayTextField.add((TextField) listElement.get(3));

        DatePicker date = new DatePicker();

        Long.parseLong(arrayTextField.get(0).getText());


        button.setOnAction(event -> {
          //  database.addKatalog( Long.parseLong(arrayTextField.get(0).getText()), Long.parseLong(arrayTextField.get(0).getText()), Long.parseLong(arrayTextField.get(0).getText()),  );
            raw3.getChildren().clear();
            raw2.getChildren().clear();
            raw3Panel.getChildren().clear();

        });
        button.setText("Accept");
        return button;
    }




    Button createObjectFilmy(ArrayList<Control> listElement ,VBox raw3Panel){

      Button button = new Button();

      ArrayList<TextField> arrayTextField = new ArrayList();
      arrayTextField.add((TextField) listElement.get(1));
      arrayTextField.add((TextField) listElement.get(3));
      arrayTextField.add((TextField) listElement.get(5));
      arrayTextField.add((TextField) listElement.get(7));
      arrayTextField.add((TextField) listElement.get(9));
      arrayTextField.add((TextField) listElement.get(11));

            button.setOnAction(event -> {

                database.addFilmy(arrayTextField.get(0).getText(),arrayTextField.get(1).getText(),arrayTextField.get(2).getText(),arrayTextField.get(3).getText(),arrayTextField.get(4).getText(),arrayTextField.get(5).getText());

                raw3.getChildren().clear();
                raw2.getChildren().clear();
                raw3Panel.getChildren().clear();

            });
    button.setText("Accept");


    return button;
  }


    ArrayList<Button> generateNameTableButton(ArrayList<String> tableNameList, ArrayList<Button> buttonsNameTable){


        for(String i:tableNameList)
            buttonsNameTable.add(new Button(i));


        return buttonsNameTable;
    }








}
