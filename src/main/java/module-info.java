module br.com.meganews.desafiojunior.desafiojunior {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.com.meganews.desafiojunior.desafiojunior to javafx.fxml;
    exports br.com.meganews.desafiojunior.desafiojunior;
    exports br.com.meganews.desafiojunior.desafiojunior.ui;
    opens br.com.meganews.desafiojunior.desafiojunior.ui to javafx.fxml;
}