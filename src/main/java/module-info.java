module com.CS380.SpellingBee {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.base;


    opens com.CS380.SpellingBee to javafx.fxml;
    exports com.CS380.SpellingBee;
}
