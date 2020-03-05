import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;
import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;

import javafx.scene.layout.GridPane;
import javafx.scene.Group;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
/**
 * Write a description of JavaFX class window here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class window extends Application
{
    // We keep track of the count, and label displaying the count:
    private int count = 0;
    private Label label;
    private ComboBox<String>comboBox;
    private ComboBox<String>comboBox1;
    private String warningText;
    
    /**
     * The start method is the main entry point for every JavaFX application. 
     * It is called after the init() method has returned and after 
     * the system is ready for the application to begin running.
     *
     * @param  stage the primary stage for this application.
     */
    @Override
    public void start(Stage stage)
    {
        // Create a new grid pane
        BorderPane pane = new BorderPane();
        
        // Create a Button or any control item
        HBox hbox = new HBox();
        Text text = new Text();
        text.setText("From: ");
        Text text1 = new Text();
        text1.setText("to: ");
        //设置控件与 HBox 边缘之间的距离
        hbox.setPadding(new Insets(10, 10, 10, 400));
        hbox.setSpacing(10);
        //xia la kuang 
        //ObservableList<String> options = 
        //FXCollections.observableArrayList(
        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
            "0",
            "100",
            "200",
            "300"
            );
        comboBox.setEditable(false); 
        comboBox.setVisibleRowCount(3);
        
        comboBox1 = new ComboBox<>();
        comboBox1.getItems().addAll(
        
        "100",
        "200",
        "300",
        "400"
        );
        //comboBox1.setEditable(false); // 设置下拉框能否编辑。默认不允许编辑
        comboBox1.setVisibleRowCount(3);
        
        Button button = new Button("submit");
        comboBox.setOnAction(e-> displayWindow());
        
        hbox.getChildren().addAll(text, comboBox, text1, comboBox1,button);
        pane.setTop(hbox);
        
        HBox hbox1 = new HBox();
        pane.setBottom(hbox1);
        Button button1 = new Button("continue");
        hbox1.setPadding(new Insets(10, 10, 10, 500));
        hbox1.getChildren().addAll(button1);
        pane.setBottom(hbox1);
        button1.setOnAction(this::buttonClick);
        
        /*
        HBox hbox1 = new HBox();
        pane.setBottom(hbox1);
        Button button = new Button("back");
        hbox1.setSpacing(680);
        //maybe use margin
        Button button1 = new Button("forward");
        hbox1.getChildren().addAll(button, button1);
        */
        //set an action on the button using method reference
        
        //button1.setOnAction(this::buttonClick);
        
        Label centerLabel = new Label("Welcome");
        pane.setCenter(centerLabel);
        
        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(pane,800,500);
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();
    }
    
    public void displayWindow()
    {
        int a = Integer.parseInt(comboBox.getValue());
        int b = Integer.parseInt(comboBox1.getValue());
        if(a < b){
            GridPane pane1 = new GridPane();
            Scene scene1 = new Scene(pane1,200,200);
            Stage stage1 = new Stage();
            stage1.setScene(scene1);
            // Show the Stage (window)
            stage1.setTitle("The price is invalid.");
            stage1.show();
        }
        else{
            
        }
    }
 
 /**
    public void welcome(Stage stage) {
        Text text = new Text(10, 40, "Welcome!");
        text.setFont(new Font(40));
        Scene scene = new Scene(new Group(text));

        //stage.setTitle("Welcome to Airbinb!"); 
        stage.setScene(scene); 
        stage.sizeToScene(); 
        stage.show(); 
  }
 */
   
    private void buttonClick(ActionEvent event)
    {
        // Counts number of button clicks and shows the result on a label
        count = count + 1;
        
        //myLabel.setText(Integer.toString(count));
    }
}
