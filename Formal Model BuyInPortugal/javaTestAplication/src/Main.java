
import MFES_Proj.BuyInPortugal;
import janelas.CenaPrincipal_Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    private BuyInPortugal buyInPortugal;



    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("BuyInPortugal");

        buyInPortugal = new BuyInPortugal();


        FXMLLoader loader = new FXMLLoader(getClass().getResource("janelas/cenaPrincipal.fxml"));
        Parent root = loader.load();
        CenaPrincipal_Controller cenaPrincipal_controller = loader.getController();
        cenaPrincipal_controller.init(buyInPortugal);



        Scene scene = new Scene(root);


        primaryStage.setScene(scene);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
