module dmv {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.xerial.sqlitejdbc;

    opens dmv to javafx.fxml;
    exports dmv;
}