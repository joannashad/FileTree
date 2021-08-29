/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

/**
 *
 * @author joann
 */
public class FXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        VBox vbox = new VBox();
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label lbl = new Label("Select a Folder");
        lbl.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        grid.add(lbl, 0, 0); 
        
       
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File("src"));
        //String selectedDirectory = "";
        Button btn = new Button("Select Directory");
        btn.setOnAction(e -> {
            File selectedDirectory = directoryChooser.showDialog(primaryStage);
        
            //selectedDirectory = directoryChooser.showDialog(primaryStage).getAbsolutePath();
            FileDir files = new FileDir(selectedDirectory.getAbsolutePath());
            files.setFiles();
             TreeView treeView =files.getFiles();
            
            //FolderTreeView ftv = new FolderTreeView();
            //TreeItem<File> root = ftv.createNode(selectedDirectory);
            //TreeView treeView = new TreeView<File>(root);

        vbox.getChildren().add(treeView);
            
        });
  
           
          
        grid.add(btn, 0, 1);
       // grid.add(vbox,3,2);
        
        Scene scene = new Scene(grid, 400,600);
        
        primaryStage.setTitle("Choose a directory");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
