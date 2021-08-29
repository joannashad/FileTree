
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joanna
 */
public class FileDir {
   protected String fileName = "";
   protected Boolean hasFiles = false;
   protected double fileSize = 0;
   protected int numFiles = 0;
   protected File dir ;
   private TreeView treeViewFile = new TreeView<>();
   private ArrayList<File> fileList =new ArrayList<File>();
   
   
    
   public FileDir(String fileDir){
       this.dir = new File(fileDir);    
   }
   public  TreeView  getFiles(){
       return treeViewFile;
   }
   public void setFiles(){
       this.treeViewFile = displayDirectoryContents(dir);
       
   }
  
      public static TreeView  displayDirectoryContents(File dir) {
         TreeView  fileListing =  new TreeView<>();
         double dirSize = 0.0;
         int fileNumber = 0;
         String displayText = "";
      try { 
         File[] files = dir.listFiles();
         //TreeItem rootItem = new TreeItem("directory:" + dir.getCanonicalPath());
               displayText = "directory: " + dir.getCanonicalPath();
         
         for (File file : files) {
            if (file.isDirectory()) {
                displayText = "directory:" + file.getCanonicalPath();
               //rootItem = new TreeItem("directory: " + file.getCanonicalPath());
               displayDirectoryContents(file);
            } else {
                dirSize+=file.length();
                fileNumber++;
                displayText ="     file: " + file.getCanonicalPath()+" length: " + dirSize;
            }
            if(file.isDirectory()){
                
                   displayText = "DIRECTORY Totals: length: " + dirSize + " # of files: " + fileNumber +
                       System.lineSeparator() +   displayText;
               dirSize=0.0;
               fileNumber=0;
            }
            System.out.println(displayText);
            //fileListing.setRoot(rootItem); 
            
         } 
      } catch (IOException e) {
         e.printStackTrace();
      } 
      
      return fileListing;
   } 
 
}
