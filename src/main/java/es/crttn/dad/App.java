package es.crttn.dad;

import es.crttn.dad.controller.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    private MainController mc;

    @Override
    public void start(Stage primaryStage) throws Exception {

        mc = new MainController();



        Scene scene = new Scene(mc.getRoot());
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(mc.getRoot().getMinWidth());
        primaryStage.setMinHeight(mc.getRoot().getMinHeight());
        primaryStage.setTitle("SendMail");
        primaryStage.getIcons().add(new Image("/images/Incon.png"));
        primaryStage.show();

    }

    public MainController getMc() {
        return mc;
    }
}
