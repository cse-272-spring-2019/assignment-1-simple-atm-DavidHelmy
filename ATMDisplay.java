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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class ATMDisplay extends Application {
    
     public static void depositDisplay(String title,BankAccount acc)
    {
        Stage window=new Stage();
        
        
        GridPane grid=new GridPane();
        grid.setPadding(new Insets (70,10,10,25));
        grid.setHgap(10);
        grid.setVgap(10);
        
        window.setTitle(title);
        
        Label name=new Label("Deposit Amount");
        GridPane.setConstraints(name, 1, 0);
        
        TextField nameInput=new TextField();
        nameInput.setPromptText("Amount");
        GridPane.setConstraints(nameInput, 2, 0);
        
        Button deposit=new Button("Deposit");
        deposit.setFont(Font.font(15));
        GridPane.setConstraints(deposit, 1, 2);
        deposit.minHeight(30);
        deposit.minWidth(30);
        
        
        grid.getChildren().addAll(name,nameInput,deposit);
        
        Scene scene=new Scene(grid,300,200);
        
        window.setScene(scene);
        window.show();
        
        deposit.setOnAction(e->{
            
        double x;
        if (nameInput.getText().matches("[0-9.]+")) {
        x=Double.valueOf(nameInput.getText());
        acc.deposit(x); 
        window.close();}
        
        else{
        Alertwindow.display("Error","Enter a valid number", "Back");
        nameInput.setText("");
        }
              
                });
        
        
    
    }
     
     
     
      public static void withdrawdisplay(String title,BankAccount acc)
    {
        Stage window=new Stage();
        
        GridPane grid=new GridPane();
        grid.setPadding(new Insets (30,10,10,70));
        grid.setHgap(10);
        grid.setVgap(10);
        
        window.setTitle(title);
        
        Label name=new Label("WithDraw Amount");
        GridPane.setConstraints(name, 1, 0);
        
        TextField nameInput=new TextField();
        nameInput.setPromptText("Amount");
        GridPane.setConstraints(nameInput, 1, 1);
        
        Button withdraw=new Button("WithDraw");
         withdraw.setFont(Font.font(15));
        GridPane.setConstraints(withdraw, 1, 2);
        withdraw.minHeight(30);
        withdraw.minWidth(30);
        
        
        grid.getChildren().addAll(name,nameInput,withdraw);
        
        Scene scene=new Scene(grid,300,200);
        
        window.setScene(scene);
        window.show();
        
        withdraw.setOnAction(e->{
            
            double x;
            boolean i;
             if (nameInput.getText().matches("[0-9.]+"))
             {
            x=Double.valueOf(nameInput.getText());
            i=acc.withdraw(x);
            if(i)
            window.close();
            else
                nameInput.setText("");
               }
        
             else 
             {
                 
                Alertwindow.display("Error", "Enter a valid number", "Back");
               nameInput.setText("");
             }
             
        });
         
    }
      
      public static void print(String title,String[] mem){
         Stage window=new Stage();
        
        GridPane grid=new GridPane();
        grid.setPadding(new Insets (30,10,10,30));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setMinSize(300, 200);
        
        
        window.setTitle(title);
        
      
               
        for(int i=0;i<5;i++){
            
        Label name=new Label(mem[i]);
        GridPane.setConstraints(name, 1, i);
        grid.getChildren().add(name);
        
        }
       

        Button back=new Button("Back");
        back.setFont(Font.font(15));
        GridPane.setConstraints(back, 1, 6);
        back.minHeight(30);
        back.minWidth(30);
        
        
        grid.getChildren().add(back);
        
        Scene scene=new Scene(grid);
        
        window.setScene(scene);
        window.show();
        
        back.setOnAction(e->window.close());
    
        
        
        
        
    }
    
    
    public static void inquire(String title,double x) {
     Stage window=new Stage();
        window.setTitle(title);
        window.setMinWidth(250);
        window.setMinHeight(250);
        
        Label label1=new Label();

        label1.setText("Your balance is: "+Double.toString(x));
        
        Button button1=new Button("Back");
        button1.setFont(Font.font(15));
        button1.setOnAction(e->window.close());
        
        VBox layout1=new VBox(10);
        layout1.getChildren().addAll(label1,button1);
        layout1.setAlignment(Pos.CENTER);
        
        Scene scene1=new Scene(layout1,300,200);
        window.setScene(scene1);
        window.show();
}
    
    
    public static void next(String title,int pr,String[] mem) {
     Stage window=new Stage();
        window.setTitle(title);
        
        Label label1=new Label();
        label1.setText(mem[pr+1]);
        Button button1=new Button("Back");
        
        button1.setOnAction(e->window.close());
        
        
        VBox layout1=new VBox(10);
        layout1.getChildren().addAll(label1,button1);
        layout1.setMinSize(300, 200);
        
        layout1.setAlignment(Pos.CENTER);
        
        Scene scene1=new Scene(layout1);
        window.setScene(scene1);
        window.show();
        
        
}
    
     public static void Prev(String title,int pr,String[] mem) {
     Stage window=new Stage();
        window.setTitle(title);
        
        
        Label label1=new Label();
        label1.setText(mem[pr-1]);

       
        
        Button button1=new Button("Back");
        
        button1.setOnAction(e->window.close());
        
        VBox layout1=new VBox(10);
        layout1.getChildren().addAll(label1,button1);
        layout1.setAlignment(Pos.CENTER);
        
        Scene scene1=new Scene(layout1,300,200);
        window.setScene(scene1);
        window.show();
        
        
}

    @Override
    public void start(Stage primaryStage) throws Exception {
         BankAccount acc=new BankAccount("123456");
        Login.logindisplay("ATM",acc);
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
     
     
     
     
    
    
    
}
