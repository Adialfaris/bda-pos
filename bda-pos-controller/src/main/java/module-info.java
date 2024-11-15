module com.bdajaya.controller {
    requires com.bdajaya.service;
    requires com.bdajaya.view;
    requires com.bdajaya.model;
    requires javafx.controls;
    requires com.bdajaya.database;

    exports com.bdajaya.controller;
}