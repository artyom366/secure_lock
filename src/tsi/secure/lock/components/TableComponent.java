package tsi.secure.lock.components;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class TableComponent<UserData> {

    private TableView<UserData> tableView;

    public TableComponent() {
        this.tableView = new TableView<>();
    }

    public TableView<UserData> init() {

        TableColumn<UserData, Integer> positionColumn = new TableColumn<>("#");
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        positionColumn.setPrefWidth(30);
        positionColumn.setResizable(false);

        TableColumn<UserData, Integer> apartmentColumn = new TableColumn<>("Apartment");
        apartmentColumn.setCellValueFactory(new PropertyValueFactory<>("apartment"));
        apartmentColumn.setPrefWidth(100);
        apartmentColumn.setResizable(false);

        TableColumn<UserData, Integer> codeColumn = new TableColumn<>("Code");
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        codeColumn.setPrefWidth(100);
        codeColumn.setResizable(false);

        tableView.getColumns().addAll(positionColumn, apartmentColumn, codeColumn);

        return this.tableView;
    }

    public void setTableViewSize(final double width, final double height) {
        this.tableView.setMaxSize(width, height);
    }

    public void setTableViewPosition(final double x, final double y) {
        this.tableView.setLayoutX(x);
        this.tableView.setLayoutY(y);
    }

    public void setData(List<UserData> userData) {
        ObservableList<UserData> data = FXCollections.observableList(userData);
        tableView.setItems(data);
    }

    public void clearTableData() {
        tableView.getItems().clear();
    }

    public ObservableList<UserData> getData() {
        return tableView.getItems();
    }

}
