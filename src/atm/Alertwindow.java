
package atm;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;



/**
 *
 * @author david
 */
public class Alertwindow {
    
    public static void display(String title,String message,String button){
        
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        
        
        Label label1=new Label();
        label1.setText(message);
        label1.setFont(Font.font(20));
        
        Button button1=new Button(button);
        button1.setOnAction(e->window.close());
        button1.setFont(Font.font(15));
        
        
        VBox layout1=new VBox(40);
        layout1.getChildren().addAll(label1,button1);
        layout1.setAlignment(Pos.CENTER);
        
        
        Scene scene1=new Scene(layout1,300,200);
        window.setScene(scene1);
        window.showAndWait();
        
        
        
    }
    
}
