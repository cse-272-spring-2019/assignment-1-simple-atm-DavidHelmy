/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author david
 */
public class Login {
    
    public static void logindisplay(String title,BankAccount acc)
    {
       
        
        Stage window=new Stage();
        
        GridPane grid=new GridPane();
        grid.setPadding(new Insets (70,10,10,25));
        grid.setHgap(10);
        grid.setVgap(10);
        
        window.setTitle(title);
        
        Label name=new Label("Visa Number");
        GridPane.setConstraints(name, 1, 0);
        
        TextField nameInput=new TextField();
        nameInput.setPromptText("Visa Number");
        GridPane.setConstraints(nameInput, 2, 0);
        
        Button login=new Button("Login");
        GridPane.setConstraints(login, 1, 2);
        login.minHeight(30);
        login.minWidth(30);
        
        
        grid.getChildren().addAll(name,nameInput,login);
        
        Scene scene=new Scene(grid,300,200);
        
        
        window.setScene(scene);
        window.show();
        
       
        
        login.setOnAction(e->
        {
            if(acc.getCardNumber().equals(nameInput.getText())){
            MainMenu.menu(acc) ;
            window.close();}
            else{
                Alertwindow.display("Error", "Enter a Valid visa", "Back");
            nameInput.setText("");
            }
            
                });
            
    
        
        
        
        
    }
}
