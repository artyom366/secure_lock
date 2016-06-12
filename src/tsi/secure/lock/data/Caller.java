package tsi.secure.lock.data;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import tsi.secure.lock.components.ButtonComponent;

public class Caller {

    public boolean isApartmentExists(final ObservableList<UserData> userData, final String userInput) {

        for (final UserData data : userData) {

            if (data.getApartment() == Integer.parseInt(userInput)) {
                return true;
            }
        }

    return false;

    }

    public int validateCode(final ObservableList<UserData> userData, final String userInput) {

        for (final UserData data : userData) {

            if (data.getCode() == Integer.parseInt(userInput)) {
                return data.getApartment();
            }
        }

        return 0;

    }

    public void call(final ButtonComponent openLock) {

        openLock.setButtonStyleActive();

        final Timeline buttonActive = new Timeline(
                new KeyFrame(Duration.seconds(5),
                        new EventHandler<ActionEvent>() {
                            @Override public void handle(ActionEvent actionEvent) {
                                openLock.setButtonStyleDisabled();
                            }
                        }));

        buttonActive.setCycleCount(1);
        buttonActive.play();
    }
}
