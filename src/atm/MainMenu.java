/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



public class MainMenu {
    
    
    public static void menu(BankAccount acc)
    {
        Stage window=new Stage();
        window.setTitle("ATM");
        
        //layout
        GridPane grid=new GridPane();
        grid.setPadding(new Insets(35, 10, 10, 40));
        grid.setHgap(20);
        grid.setVgap(20);
        
        
        //buttons
        Button btn1=new Button("Deposit");
        GridPane.setConstraints(btn1, 1, 0);
        btn1.setOnAction(e->ATMDisplay.depositDisplay("Deposit", acc));
        btn1.setAlignment(Pos.CENTER);
        btn1.setWrapText(false);
        btn1.setMinSize(80, 30);
        
        
        Button btn2=new Button("WithDraw");
        GridPane.setConstraints(btn2, 1, 1);
        btn2.setOnAction(e->ATMDisplay.withdrawdisplay("WithDraw", acc));
        btn2.setAlignment(Pos.CENTER);
        btn2.setWrapText(false);
        btn2.setMinSize(80, 30);
        
        
         Button btn4=new Button("Transaction");
        GridPane.setConstraints(btn4,1, 2);
        btn4.setOnAction(e->acc.printTransaction());
        btn4.setAlignment(Pos.CENTER);
        btn4.setWrapText(false);
        btn4.setMinSize(80, 30);
        
         
        Button btn3=new Button("Inquire");
        GridPane.setConstraints(btn3, 2, 0);
        btn3.setOnAction(e->acc.getBalance());
        btn3.setAlignment(Pos.CENTER);
        btn3.setWrapText(false);
        btn3.setMinSize(80, 30);
        
         
        Button btn5=new Button("Next");
        GridPane.setConstraints(btn5, 2, 1);
        btn5.setOnAction(e->acc.next());
        btn5.setAlignment(Pos.CENTER);
        btn5.setWrapText(false);
        btn5.setMinSize(80, 30);
         
         
        Button btn6=new Button("Previous");
        GridPane.setConstraints(btn6, 2, 2);
        btn6.setOnAction(e->acc.prev());
        btn6.setAlignment(Pos.CENTER);
        btn6.setWrapText(false);
        btn6.setMinSize(80, 30);
         
         
        
        grid.getChildren().addAll(btn1,btn2,btn3,btn4,btn5,btn6);
        Scene scene=new Scene(grid,300,200);
        window.setScene(scene);
        window.show();
        
        
        
        
        
                
        
        
    }
    
    
    
}
