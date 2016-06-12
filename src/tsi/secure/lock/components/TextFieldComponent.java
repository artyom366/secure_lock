package tsi.secure.lock.components;

import javafx.scene.control.TextField;

public class TextFieldComponent {

    private TextField textField;

    public TextFieldComponent() {
        this.textField = new TextField();
    }

    public TextField init() {
        return this.textField;
    }

    public void setTextFieldSize(final double width, final double height) {
        this.textField.setMinSize(width, height);
    }

    public void setTextFieldPosition(final double x, final double y) {
        this.textField.setLayoutX(x);
        this.textField.setLayoutY(y);
    }

    public void setTextFieldReadonly(final boolean isReadonly) {
        this.textField.setDisable(isReadonly);
    }
}
