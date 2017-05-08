
package tablasahvariabila;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author sulitas
 */
public class Tablasahvariabila extends Application {
    
    int n=0;//n intre 0 si 20 pentru a a ne incadra in dimensiunile initiale ale scenei
       
    @Override
    public void start(Stage primaryStage) {
        
        Canvas canvas = new Canvas(560, 560);
        canvas.setLayoutX(20);
        canvas.setLayoutY(10);
        GraphicsContext gc = canvas.getGraphicsContext2D();
             
        Label eticheta = new Label(" Numar de patratele pe linie/ coloana: 0 ");
        eticheta.setLayoutX(330);
        eticheta.setLayoutY(590);
        eticheta.setPrefHeight(25);
        eticheta.setPrefWidth(250);
        eticheta.setStyle("-fx-background-color: yellow;");

        Button deseneaza = new Button();
        deseneaza.setText("DESENEAZA TABLA");
        deseneaza.setLayoutX(60);
        deseneaza.setLayoutY(590);
        deseneaza.setPrefHeight(25);
        deseneaza.setPrefWidth(150);
        deseneaza.setOnAction((ActionEvent event) -> {
             
            if (n==20) gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            n=++n%21;
            eticheta.setText(" Numar de patratele pe linie/ coloana: " + n);

            if (n!=0){
                int x=50, y=50, w, h, i, j, k, l, m;
                w=n*25; //pentru a avea simetrie la patratele
                h=n*25; //pentru a avea simetrie la patratele
                gc.setFill(Color.BLUE); //setarea culorii patratelelor
                
                //desenararea conturului exterior al tablei si patratelelor
                for(i=0;i<=n;i++){
                    gc.strokeLine(x+i*w/n,y,x+i*w/n,h+50);
                    gc.strokeLine(x,y+i*h/n,w+50,y+i*h/n);  
                }

                //umplerea patratelelor de pe liniile si coloanele impare
                for(j=0;j<n;j+=2){
                    for(k=0;k<n;k+=2){
                            gc.fillRect(x+j*w/n,y+k*h/n,w/n,h/n);
                    }
                }

                //umplerea patratelelor de pe liniile si coloanele pare
                for(l=1;l<n;l+=2){
                    for(m=1;m<n;m+=2){
                        gc.fillRect(x+m*w/n,y+l*h/n,w/n,h/n);
                    }
                }
            }  
        });  
           
        Pane root = new Pane(); // pentru a putea da coordonate absolute controalelor
        root.getChildren().add(canvas);
        root.getChildren().add(eticheta);
        root.getChildren().add(deseneaza);
        
        Scene scene = new Scene(root, 650, 650);
        
        primaryStage.setTitle("Silviu Sulita - JavaFX - Tabla sah variabila");
        primaryStage.setResizable(false);
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
