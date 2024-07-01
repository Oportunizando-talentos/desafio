module br.com.meganews.desafiojunior.desafiojunior {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.json;
    requires org.postgresql.jdbc;
    requires java.sql;
    requires java.net.http;
    requires org.apache.logging.log4j.core;
    requires jdk.compiler;



    opens br.com.meganews.desafiojunior.desafiojunior to javafx.fxml;
    exports br.com.meganews.desafiojunior.desafiojunior;
    exports br.com.meganews.desafiojunior.desafiojunior.controller;
    opens br.com.meganews.desafiojunior.desafiojunior.controller to javafx.fxml;
    exports br.com.meganews.desafiojunior.desafiojunior.model;
    exports br.com.meganews.desafiojunior.desafiojunior.service;
    exports br.com.meganews.desafiojunior.desafiojunior.repository;
    exports br.com.meganews.desafiojunior.desafiojunior.exceptions;
    opens br.com.meganews.desafiojunior.desafiojunior.model to javafx.fxml;
    exports br.com.meganews.desafiojunior.desafiojunior.infra;
    opens br.com.meganews.desafiojunior.desafiojunior.infra to javafx.fxml;
    opens br.com.meganews.desafiojunior.desafiojunior.service to javafx.fxml;
}