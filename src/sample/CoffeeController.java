package sample;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Coffee;

import java.io.File;
import java.net.MalformedURLException;

public class CoffeeController {

    Coffee coffeeOrder = new Coffee();

    @FXML
    private ComboBox sizeBox;

    @FXML
    private CheckBox cream, milk, syrup, caramel, whippCream;

    @FXML
    private TextField subtotal;

    @FXML
    private ImageView images;

    @FXML
    private Label sizeLabel;

    private double total;
    private int number = 0;
    private Image image[];
    private int first = 0;


    @FXML
    public void displayImages(){
         image = new Image[4];
        File file1 = new File("C:\\Users\\Admin\\IdeaProjects\\RuCafe\\src\\sample\\short.jpg");
        File file2 = new File("C:\\Users\\Admin\\IdeaProjects\\RuCafe\\src\\sample\\tall.jpg");
        File file3 = new File("C:\\Users\\Admin\\IdeaProjects\\RuCafe\\src\\sample\\Comapre.jpg");
        try {
            String localUrl = file1.toURI().toURL().toString();
            image[1] = new Image(localUrl);

            localUrl = file2.toURI().toURL().toString();
            image[2] = new Image(localUrl);

            localUrl = file3.toURI().toURL().toString();
            image[3] = new Image(localUrl);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void nextImage(){

        if(first == 0){
            displayImages();
            first = 1;
        }

        if(number == 3){
            number = 1;
            images.setImage(image[number]);
            setLabel();
            return;
        }

        number += 1;
        images.setImage(image[number]);
        setLabel();
    }

    @FXML
    public void prevImage(){

        if(first == 0){
            displayImages();
            first = 1;
        }

        if(number == 1){
            number = 3;
            images.setImage(image[number]);
            setLabel();
            return;
        }
        number -= 1;
        images.setImage(image[number]);
        setLabel();
    }


    public void setLabel(){
        if(number == 1){
            sizeLabel.setText("Short size");
        }
        if(number == 2){
            sizeLabel.setText("Tall size");
        }
        if(number == 3){
            sizeLabel.setText("Compare all sizes");
        }
    }

    public void getTotal(){

        subtotal.clear();
        subtotal.setEditable(false);
        total = 0;
        coffeeOrder.setAddOn(0);
        coffeeOrder.setSize((String) sizeBox.getValue());

        if(cream.isSelected()){
            coffeeOrder.increaseAddOn(cream.getText());
        }
        if( milk.isSelected()){
            coffeeOrder.increaseAddOn(milk.getText());
        }
        if(syrup.isSelected()){
            coffeeOrder.increaseAddOn(syrup.getText());
        }
        if(caramel.isSelected()){
            coffeeOrder.increaseAddOn(caramel.getText());
        }
        if(whippCream.isSelected()){
            coffeeOrder.increaseAddOn(whippCream.getText());
        }

        subtotal.setText(coffeeOrder.toString());
    }

}
