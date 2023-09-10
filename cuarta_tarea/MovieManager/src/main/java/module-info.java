module com.methaporce.methaporce {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.methaporce to javafx.fxml;
    exports com.methaporce.view;
//    exports com.methaporce.view;
    opens com.methaporce.view to javafx.fxml;
}