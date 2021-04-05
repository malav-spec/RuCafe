package sample;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Coffee;
import static sample.Main.currentOrder;
import java.io.File;
import java.net.MalformedURLException;

/**
 * Used to represent Controller for Coffee GUI
 * @author Malav Doshi and Herik Patel
 */
public class CoffeeController {

    Coffee coffeeOrder = new Coffee();

    /**
     * A Combo box for selecting sizes
     */
    @FXML
    private ComboBox sizeBox;

    /**
     * Multiple checkbox for selecting add ins
     */
    @FXML
    private CheckBox cream, milk, syrup, caramel, whippCream;

    /**
     * Textfield to show sub total for coffee
     */
    @FXML
    private TextField subtotal;

    /**
     * Imageview to display images
     */
    @FXML
    private ImageView images;

    /**
     * Label to describe the image above it
     */
    @FXML
    private Label sizeLabel;

    /**
     * Add button to add coffee order  to the main order
     */
    @FXML
    private Button add;

    /**
     * counter for image number
     */
    private int number = 0;

    /**
     * Array of image object
     */
    private Image image[];

    /**
     * Counter that checks if it is the first time the image view is displayed
     */
    private int first = 0;


    /**
     * Display images as a slide show
     */
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

    /**
     * Go to next image
     */
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

    /**
     * Go to previous image
     */
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


    /**
     * Set label for every image change
     */
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

    /**
     * Used to get the total for the coffee order
     */
    @FXML
    public void getTotal(){

        subtotal.clear();
        subtotal.setEditable(false);
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

    /**
     * Adds the current coffee order to the main order
     */
    @FXML
    public void addOrder(){
        if(sizeBox.getValue() == null){
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Select a size first");
            a.show();
            return;
        }
        currentOrder.add(coffeeOrder);
        currentOrder.setTotal(Double.parseDouble(coffeeOrder.toString().substring(1))+ currentOrder.getTotal());
        Stage stage=(Stage) add.getScene().getWindow();
        stage.close();
    }


}
//Double.parseDouble(coffeeOrder.toString().substring(1))+ currentOrder.getTotal()