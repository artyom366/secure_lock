package tsi.secure.lock.components;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonComponent {

    private Button button;

    public ButtonComponent() {
        this.button = new Button();
    }

    public Button init() {
        return this.button;
    }

    public void setButtonSize(final double width, final double height) {
        this.button.setMinSize(width, height);
    }

    public void setButtonText(final String text) {
        this.button.setText(text);
    }

    public void setButtonPosition(final double x, final double y) {
        this.button.setLayoutX(x);
        this.button.setLayoutY(y);
    }

    public void addAction(EventHandler<ActionEvent> event) {
        button.setOnAction(event);
    }
}
