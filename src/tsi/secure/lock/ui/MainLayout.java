package tsi.secure.lock.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import tsi.secure.lock.components.*;
import tsi.secure.lock.data.Caller;
import tsi.secure.lock.data.UserData;
import tsi.secure.lock.data.UserDataGen;

import java.util.List;

public class MainLayout {

    private BorderPane root;
    private CenterComponent centerComponent;
    private TopComponent topComponent;

    private TextFieldComponent screen;
    private ButtonComponent zeroButton;
    private ButtonComponent oneButton;
    private ButtonComponent twoButton;
    private ButtonComponent threeButton;
    private ButtonComponent fourButton;
    private ButtonComponent fiveButton;
    private ButtonComponent sixButton;
    private ButtonComponent sevenButton;
    private ButtonComponent eighthButton;
    private ButtonComponent nineButton;
    private ButtonComponent backButton;
    private ButtonComponent callButton;

    private TableComponent userDataTable;
    private ButtonComponent addUserDataButton;
    private ButtonComponent clearAllUserDataButton;
    private ButtonComponent deleteUserDataButton;
    private ButtonComponent openLock;

    private Caller caller;

    public BorderPane initRootLayout() {
        caller = new Caller();

        centerComponent = new CenterComponent();
        topComponent = new TopComponent();

        screen = new TextFieldComponent();
        screen.setTextFieldPosition(100, 120);
        screen.setTextFieldSize(160, 50);
        screen.setTextFieldReadonly(true);

        oneButton = new ButtonComponent();
        oneButton.setButtonText("1");
        oneButton.setButtonPosition(100, 200);
        oneButton.setButtonSize(40, 40);
        oneButton.addAction(setNumericButtonsListener("1"));

        twoButton = new ButtonComponent();
        twoButton.setButtonText("2");
        twoButton.setButtonPosition(160, 200);
        twoButton.setButtonSize(40, 40);
        twoButton.addAction(setNumericButtonsListener("2"));

        threeButton = new ButtonComponent();
        threeButton.setButtonText("3");
        threeButton.setButtonPosition(220, 200);
        threeButton.setButtonSize(40, 40);
        threeButton.addAction(setNumericButtonsListener("3"));

        fourButton = new ButtonComponent();
        fourButton.setButtonText("4");
        fourButton.setButtonPosition(100, 260);
        fourButton.setButtonSize(40, 40);
        fourButton.addAction(setNumericButtonsListener("4"));

        fiveButton = new ButtonComponent();
        fiveButton.setButtonText("5");
        fiveButton.setButtonPosition(160, 260);
        fiveButton.setButtonSize(40, 40);
        fiveButton.addAction(setNumericButtonsListener("5"));

        sixButton = new ButtonComponent();
        sixButton.setButtonText("6");
        sixButton.setButtonPosition(220, 260);
        sixButton.setButtonSize(40, 40);
        sixButton.addAction(setNumericButtonsListener("6"));

        sevenButton = new ButtonComponent();
        sevenButton.setButtonText("7");
        sevenButton.setButtonPosition(100, 320);
        sevenButton.setButtonSize(40, 40);
        sevenButton.addAction(setNumericButtonsListener("7"));

        eighthButton = new ButtonComponent();
        eighthButton.setButtonText("8");
        eighthButton.setButtonPosition(160, 320);
        eighthButton.setButtonSize(40, 40);
        eighthButton.addAction(setNumericButtonsListener("8"));

        nineButton = new ButtonComponent();
        nineButton.setButtonText("9");
        nineButton.setButtonPosition(220, 320);
        nineButton.setButtonSize(40, 40);
        nineButton.addAction(setNumericButtonsListener("9"));

        callButton = new ButtonComponent();
        callButton.setButtonText("C");
        callButton.setButtonPosition(100, 380);
        callButton.setButtonSize(40, 40);
        callButton.addAction(setCallButtonListener());

        zeroButton = new ButtonComponent();
        zeroButton.setButtonText("0");
        zeroButton.setButtonPosition(160, 380);
        zeroButton.setButtonSize(40, 40);
        zeroButton.addAction(setNumericButtonsListener("0"));

        backButton = new ButtonComponent();
        backButton.setButtonText("<-");
        backButton.setButtonPosition(220, 380);
        backButton.setButtonSize(40, 40);
        backButton.addAction(setBackButtonListener());

        userDataTable = new TableComponent();
        userDataTable.setTableViewPosition(400, 200);
        userDataTable.setTableViewSize(300, 220);

        addUserDataButton = new ButtonComponent();
        addUserDataButton.setButtonText("Add");
        addUserDataButton.setButtonSize(60, 40);
        addUserDataButton.setButtonPosition(400, 450);

        deleteUserDataButton = new ButtonComponent();
        deleteUserDataButton.setButtonText("Delete");
        deleteUserDataButton.setButtonSize(60, 40);
        deleteUserDataButton.setButtonPosition(495, 450);

        clearAllUserDataButton = new ButtonComponent();
        clearAllUserDataButton.setButtonText("Clear");
        clearAllUserDataButton.setButtonSize(60, 40);
        clearAllUserDataButton.setButtonPosition(590, 450);

        openLock = new ButtonComponent();
        openLock.setButtonText("Open");
        openLock.setButtonSize(60, 40);
        openLock.setButtonPosition(490, 130);
        openLock.setButtonStyleDisabled();
        openLock.addAction(setOpenLockButtonListener());

        centerComponent.addComponent(screen.init());
        centerComponent.addComponent(oneButton.init());
        centerComponent.addComponent(twoButton.init());
        centerComponent.addComponent(threeButton.init());
        centerComponent.addComponent(fourButton.init());
        centerComponent.addComponent(fiveButton.init());
        centerComponent.addComponent(sixButton.init());
        centerComponent.addComponent(sevenButton.init());
        centerComponent.addComponent(eighthButton.init());
        centerComponent.addComponent(nineButton.init());
        centerComponent.addComponent(callButton.init());
        centerComponent.addComponent(zeroButton.init());
        centerComponent.addComponent(backButton.init());

        centerComponent.addComponent(userDataTable.init());
        centerComponent.addComponent(addUserDataButton.init());
        centerComponent.addComponent(deleteUserDataButton.init());
        centerComponent.addComponent(clearAllUserDataButton.init());
        centerComponent.addComponent(openLock.init());

        root = new BorderPane();
        root.setCenter(centerComponent.init());
        root.setTop(topComponent.init());

        return root;
    }

    public void InitTableData() {
        final UserDataGen gen = new UserDataGen();
        final List<UserData> someData = gen.createSomeData();

        userDataTable.setData(someData);
    }

    private EventHandler setNumericButtonsListener(final String value) {
        EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(screen.getScreenCapacity() < 5) {
                    screen.appendTextFieldText(value);
                }
            }
        };

        return eventHandler;
    }

     private EventHandler setBackButtonListener() {
        EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(screen.getScreenCapacity() > 0) {
                    screen.deleteTextFieldText();
                }
            }
        };

        return eventHandler;
    }

    private EventHandler setCallButtonListener() {
        EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(screen.getScreenCapacity() > 0) {
                    final boolean isApartmentExists = caller.isApartmentExists(userDataTable.getData(), screen.getTextFieldText());

                    if (isApartmentExists) {
                        caller.call(openLock);
                    }
                }
            }
        };

        return eventHandler;
    }

    private EventHandler setOpenLockButtonListener() {
        EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                screen.setTextFieldText("OPEN");
                openLock.setButtonStyleDisabled();
            }
        };

        return eventHandler;
    }







}
