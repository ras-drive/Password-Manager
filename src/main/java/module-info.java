module com.rasdrive.passwordmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires jbcrypt;


    opens com.rasdrive.passwordmanager to javafx.fxml;
    exports com.rasdrive.passwordmanager;
    exports com.rasdrive.passwordmanager.database;
    opens com.rasdrive.passwordmanager.database to javafx.fxml;
}