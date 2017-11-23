package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    TextField nameField;
    @FXML
    TextField lastNameField;
    @FXML
    TextField adressField;
    @FXML
    TextField phoneNumberField;
    @FXML
    TextField donorIdField;



    private void clearFields(){
        nameField.clear();
        lastNameField.clear();
        adressField.clear();
        phoneNumberField.clear();
        donorIdField.clear();
    }


    @FXML
    public void initialize() throws SQLException, ClassNotFoundException {

        final ObservableList<Donor> data = FXCollections.observableArrayList();

        donorId.setCellValueFactory(new PropertyValueFactory<Donor, Integer>("donorId"));
        name.setCellValueFactory(new PropertyValueFactory<Donor, String>("name"));
        lastName.setCellValueFactory(new PropertyValueFactory<Donor, String>("lastName"));
        bloodGroup.setCellValueFactory(new PropertyValueFactory<Donor, Integer>("bloodGroupId"));
        address.setCellValueFactory(new PropertyValueFactory<Donor, String>("address"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<Donor, String>("phoneNumber"));

        DawcyTabela.setItems(data);

    }

    @FXML
    public void OnConnectClick() throws SQLException {
        ObservableList<Donor> data = FXCollections.observableArrayList();
        for (Donor temp : donorDAO.getAll()) {
            data.add(temp);
        }
        DawcyTabela.setItems(data);

    }

    @FXML
    public void OnAddClick() throws SQLException {
        Donor d = new Donor();
        d.setName(nameField.getText());
        d.setLastName(lastNameField.getText());
        d.setBloodGroupId(4);
        d.setPhoneNumber(phoneNumberField.getText());
        d.setAddress(adressField.getText());

        donorDAO.create(d);
        //aktualizacja z listy
        ObservableList<Donor> data = FXCollections.observableArrayList();
        for (Donor temp : donorDAO.getAll()) {
            data.add(temp);
        }
        DawcyTabela.setItems(data);
        clearFields();


    }

    @FXML
    public void OnTableClick() {

        if (DawcyTabela.getSelectionModel().getSelectedIndex() != -1) {
            Donor donor2update = (Donor) DawcyTabela.getSelectionModel().getSelectedItem();

            donorIdField.setText(Integer.toString(donor2update.getDonorId()));
            nameField.setText(donor2update.getName());
            lastNameField.setText(donor2update.getLastName());
            adressField.setText(donor2update.getAddress());
            phoneNumberField.setText(donor2update.getPhoneNumber());

        } else {
            System.out.println("Nie wybrano elementu!");
        }


    }

    @FXML
    public void OnDeleteClick() throws SQLException {
        //usuwanie z bazy
        Donor donor2delete = (Donor) DawcyTabela.getSelectionModel().getSelectedItem();
        int donorId = donor2delete.getDonorId();
        donorDAO.deleteDonorById(donorId);
        //aktualizacja z listy
        ObservableList<Donor> data = FXCollections.observableArrayList();
        for(Donor d : donorDAO.getAll()){
            data.add(d);
        }
        DawcyTabela.setItems(data);
        clearFields();
    }


    @FXML
    public void OnUpdateClick() throws SQLException {

        if(donorIdField.getText() != "") {
            donorDAO.updateDonorById(Integer.parseInt(donorIdField.getText()), nameField.getText(), lastNameField.getText(), adressField.getText(), phoneNumberField.getText());

            //aktualizacja z listy
            ObservableList<Donor> data = FXCollections.observableArrayList();
            for (Donor d : donorDAO.getAll()) {
                data.add(d);

            }
            DawcyTabela.setItems(data);
            clearFields();
        }else{
            System.out.println("Nie wybrano krotki!");
        }
    }



}
