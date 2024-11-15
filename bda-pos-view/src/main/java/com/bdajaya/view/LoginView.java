package com.bdajaya.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class LoginView extends VBox {
    private TextField usernameField;
    private PasswordField passwordField;
    private TextField dbUrlField;
    private TextField dbUserField;
    private PasswordField dbPasswordField;
    private Button loginButton;
    private Button updateDbButton;

    public LoginView() {
        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        usernameField = new TextField();
        passwordField = new PasswordField();
        dbUrlField = new TextField();
        dbUserField = new TextField();
        dbPasswordField = new PasswordField();
        loginButton = new Button("Login");
        updateDbButton = new Button("Update Database Connection");
    }

    private void setupLayout() {
        setSpacing(10);
        setPadding(new Insets(20));
        setAlignment(Pos.CENTER);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        grid.add(new Label("Username:"), 0, 0);
        grid.add(usernameField, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(passwordField, 1, 1);
        
        grid.add(new Label("Database URL:"), 0, 3);
        grid.add(dbUrlField, 1, 3);
        grid.add(new Label("Database User:"), 0, 4);
        grid.add(dbUserField, 1, 4);
        grid.add(new Label("Database Password:"), 0, 5);
        grid.add(dbPasswordField, 1, 5);

        getChildren().addAll(
            new Label("BDA POS System Login"),
            grid,
            loginButton,
            updateDbButton
        );
    }

    // Getters for the components
    public TextField getUsernameField() { return usernameField; }
    public PasswordField getPasswordField() { return passwordField; }
    public TextField getDbUrlField() { return dbUrlField; }
    public TextField getDbUserField() { return dbUserField; }
    public PasswordField getDbPasswordField() { return dbPasswordField; }
    public Button getLoginButton() { return loginButton; }
    public Button getUpdateDbButton() { return updateDbButton; }
}