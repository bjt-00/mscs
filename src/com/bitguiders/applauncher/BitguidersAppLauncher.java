package com.bitguiders.applauncher;

import com.bitguiders.gui.Splash;
import com.bitguiders.util.LauncherProps;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
 
 
public class BitguidersAppLauncher extends Application {
    private Scene scene;
    LauncherProps props = new LauncherProps();

    @Override public void start(Stage stage) {

        Splash splash = new Splash(props.getSplash());
        splash.showSplashWindow();

    	// create the scene
    	stage.setTitle(props.getTitle());
    	
    	String url = props.getURL();//"http://bitguiders.com";
    	Browser browser= new Browser(url);
    	
        scene = new Scene(browser,1024,650, Color.web("#666970"));
        stage.setScene(scene);
        //scene.getStylesheets().add("webviewsample/BrowserToolbar.css");        
        stage.show();
    }
 
    public static void main(String[] args){
        launch(args);
    }
}
