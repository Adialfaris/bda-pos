package com.bdajaya.app;

import com.bdajaya.controller.LoginController;
import com.bdajaya.service.UserService;
import com.bdajaya.view.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        LoginView loginView = new LoginView();
        UserService userService = new UserService();
        LoginController loginController = new LoginController(loginView, userService);

        Scene scene = new Scene(loginView, 400, 500);
        primaryStage.setTitle("BDA POS System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}