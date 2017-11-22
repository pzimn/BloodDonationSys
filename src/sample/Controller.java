package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class Controller {
DonorDAO donorDAO = new DonorDAO();
    @FXML
    TableView DawcyTabela;

    @FXML
    TableColumn<Donor, Integer> donorId;
    @FXML
    TableColumn<Donor, String> name;
    @FXML
    TableColumn<Donor, String> lastName;
    @FXML
    TableColumn<Donor, Integer> bloodGroup;
    @FXML
    TableColumn<Donor, String> address;
    @FXML
    TableColumn<Donor, String> phoneNumber;

    @FXML
    public void initialize() throws SQLException, ClassNotFoundException {

        final ObservableList<Donor> data = FXCollections.observableArrayList();

        donorId.setCellValueFactory(new PropertyValueFactory<Donor, Integer>("donorId"));
        name.setCellValueFactory(new PropertyValueFactory<Donor, String>("name"));
        lastName.setCellValueFactory(new PropertyValueFactory<Donor, String>("lastName"));
        bloodGroup.setCellValueFactory(new PropertyValueFactory<Donor, Integer>("bloodGroup"));
        address.setCellValueFactory(new PropertyValueFactory<Donor, String>("address"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<Donor, String>("phoneNumber"));

        DawcyTabela.setItems(data);

    }

    @FXML
    public void OnConnectClick() throws SQLException {
        Donor d = new Donor();
        d.setName("ewa");
        d.setLastName("mewa");
        d.setBloodGroupId(4);
        d.setPhoneNumber("123341231");
        d.setAddress("jakisadresik");
        donorDAO.create(d);
       for(Donor di : donorDAO.getAll()){
           System.out.println(di.getName());
       }

    }


}
