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

    public String appendTextFieldText(final String text) {
        this.textField.appendText(text);
        return this.textField.getText();
    }

    public int getScreenCapacity() {
        return this.textField.getText().length();
    }

    public String deleteTextFieldText() {
        this.textField.deleteText(textField.getText().length() - 1, textField.getText().length());
        return this.textField.getText();
    }

    public String getTextFieldText() {
        return this.textField.getText();
    }

    public void  setTextFieldText(final String text) {
        this.textField.setText(text);
    }
}
