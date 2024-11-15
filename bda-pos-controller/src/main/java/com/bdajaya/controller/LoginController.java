package com.bdajaya.controller;

import com.bdajaya.database.DatabaseConfig;
import com.bdajaya.model.User;
import com.bdajaya.service.UserService;
import com.bdajaya.view.LoginView;
import javafx.scene.control.Alert;

public class LoginController {
    private final LoginView loginView;
    private final UserService userService;

    public LoginController(LoginView loginView, UserService userService) {
        this.loginView = loginView;
        this.userService = userService;
        initializeListeners();
    }

    private void initializeListeners() {
        loginView.getLoginButton().setOnAction(e -> handleLogin());
        loginView.getUpdateDbButton().setOnAction(e -> handleUpdateDatabase());
    }

    private void handleLogin() {
        String username = loginView.getUsernameField().getText();
        String password = loginView.getPasswordField().getText();

        try {
            User user = userService.authenticate(username, password);
            if (user != null) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Login successful!");
                // TODO: Navigate to main application view
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Invalid credentials!");
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Database error: " + e.getMessage());
        }
    }

    private void handleUpdateDatabase() {
        String url = loginView.getDbUrlField().getText();
        String username = loginView.getDbUserField().getText();
        String password = loginView.getDbPasswordField().getText();

        try {
            DatabaseConfig.updateConnection(url, username, password);
            showAlert(Alert.AlertType.INFORMATION, "Success", "Database connection updated successfully!");
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to update database connection: " + e.getMessage());
        }
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}