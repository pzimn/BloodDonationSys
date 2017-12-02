package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {
    DonorDAO donorDAO = new DonorDAO();

    @FXML
    TextArea infoBox;

    //dawca
    @FXML
    TableView donorsTable;

    @FXML
    TableColumn<Donor, Integer> donorIdColDonors;
    @FXML
    TableColumn<Donor, String> nameColDonors;
    @FXML
    TableColumn<Donor, String> lastNameColDonors;
    @FXML
    TableColumn<Donor, Integer> bloodGroupColDonors;
    @FXML
    TableColumn<Donor, String> addressColDonors;
    @FXML
    TableColumn<Donor, String> phoneNumberColDonors;
    @FXML
    TableColumn<Donor, String> peselColDonors;

    @FXML
    TextField donorIdFieldDonors;
    @FXML
    TextField donorNameFieldDonors;
    @FXML
    TextField donorLastNameFieldDonors;
    @FXML
    TextField donorAddressFieldDonors;
    @FXML
    TextField donorPhoneNumberFieldDonors;
    @FXML
    TextField donorPeselFieldDonors;

    @FXML
    ComboBox bloodGroupCombo;

    //jednostki krwiodawstwa
    @FXML
    TableView stationsTable;

    @FXML
    TableColumn<Donor, String> idColStations;
    @FXML
    TableColumn<Donor, String> nameColStations;
    @FXML
    TableColumn<Donor, String> addressColStations;
    @FXML
    TableColumn<Donor, String> phoneNumberColStations;

    @FXML
    TextField idFieldStations;
    @FXML
    TextField nameFieldStations;
    @FXML
    TextField addressFieldStations;
    @FXML
    TextField phoneNumberFieldStations;

    //grupy krwi
    @FXML
    TableView bloodGroupsTable;

    @FXML
    TableColumn<Donor, String> idColBloodGroups;
    @FXML
    TableColumn<Donor, String> groupColBloodGroups;

    @FXML
    TextField idFieldBloodGroups;
    @FXML
    TextField groupFieldBloodGroups;

    //oddania
    @FXML
    TableView bloodDonationsTable;

    @FXML
    TableColumn<Donor, String> idColDonations;
    @FXML
    TableColumn<Donor, String> donorIdColDonations;
    @FXML
    TableColumn<Donor, String> bloodLitresColDonations;
    @FXML
    TableColumn<Donor, String> bloodGroupIdColDonations;
    @FXML
    TableColumn<Donor, String> dateColDonations;
    @FXML
    TableColumn<Donor, String> stationIdColDonations;

    @FXML
    TextField idFieldDonations;
    @FXML
    TextField donorIdFieldDonations;
    @FXML
    TextField bloodLitresFieldDonations;
    @FXML
    TextField bloodGroupIdFieldDonations;
    @FXML
    TextField dateFieldDonations;
    @FXML
    TextField stationIdFieldDonations;

    //zapotrzebowanie
    @FXML
    TableView bloodDemandTable;

    @FXML
    TableColumn<Donor, String> idColDemand;
    @FXML
    TableColumn<Donor, String> warehouseIdColDemand;
    @FXML
    TableColumn<Donor, String> bloodGroupIdColDemand;
    @FXML
    TableColumn<Donor, String> quantityColDemand;

    @FXML
    TextField idFieldDemand;
    @FXML
    TextField warehouseIdFieldDemand;
    @FXML
    TextField bloodGroupIdFieldDemand;
    @FXML
    TextField quantityFieldDemand;

    //magazyn
    @FXML
    TableView bloodWarehouseTable;

    @FXML
    TableColumn<Donor, String> idColWarehouse;
    @FXML
    TableColumn<Donor, String> stationIdColWarehouse;
    @FXML
    TableColumn<Donor, String> sizeColWarehouse;
    @FXML
    TableColumn<Donor, String> bloodGroupIdColWarehouse;
    @FXML
    TableColumn<Donor, String> phoneNumberColWarehouse;
    @FXML
    TableColumn<Donor, String> addressColWarehouse;

    @FXML
    TextField idFieldWarehouse;
    @FXML
    TextField stationIdFieldWarehouse;
    @FXML
    TextField sizeFieldWarehouse;
    @FXML
    TextField bloodGroupIdFieldWarehouse;
    @FXML
    TextField phoneNumberFieldWarehouse;
    @FXML
    TextField addressFieldWarehouse;

    private void clearFields(){
        donorNameFieldDonors.clear();
        donorLastNameFieldDonors.clear();
        donorAddressFieldDonors.clear();
        donorPhoneNumberFieldDonors.clear();
        donorIdFieldDonors.clear();
    }


    @FXML
    public void initialize() {

        //init comboboxa grupa krwi
        //todo pobieranie grup krwi z bazy
        ObservableList<String> combo = FXCollections.observableArrayList();
        combo.add("grupa1");
        combo.add("grupa2");
        combo.add("grupa3");

        bloodGroupCombo.setItems(combo);

        final ObservableList<Donor> data = FXCollections.observableArrayList();

        donorIdColDonors.setCellValueFactory(new PropertyValueFactory<Donor, Integer>("donorId"));
        nameColDonors.setCellValueFactory(new PropertyValueFactory<Donor, String>("name"));
        lastNameColDonors.setCellValueFactory(new PropertyValueFactory<Donor, String>("lastName"));
        bloodGroupColDonors.setCellValueFactory(new PropertyValueFactory<Donor, Integer>("bloodGroupId"));
        addressColDonors.setCellValueFactory(new PropertyValueFactory<Donor, String>("address"));
        phoneNumberColDonors.setCellValueFactory(new PropertyValueFactory<Donor, String>("phoneNumber"));

        donorsTable.setItems(data);

    }

    @FXML
    public void OnConnectClick(){
        ObservableList<Donor> data = FXCollections.observableArrayList();
        for (Donor temp : donorDAO.getAll()) {
            data.add(temp);
        }
        infoBox.appendText("Połączono z bazą danych. " + getCurrentTime() + "\r\n");
        donorsTable.setItems(data);
    }

    @FXML
    public void OnAddClick() {
        Donor d = new Donor();
        d.setName(donorNameFieldDonors.getText());
        d.setLastName(donorLastNameFieldDonors.getText());
        d.setBloodGroupId(bloodGroupCombo.getSelectionModel().getSelectedIndex()); //todo to ma dodawać id krwi a nie index z comboboxa
        d.setPhoneNumber(donorPhoneNumberFieldDonors.getText());
        d.setAddress(donorAddressFieldDonors.getText());

        donorDAO.create(d);
        //aktualizacja z listy
        ObservableList<Donor> data = FXCollections.observableArrayList();
        for (Donor temp : donorDAO.getAll()) {
            data.add(temp);
        }
        donorsTable.setItems(data);
        clearFields();


    }

    @FXML
    public void OnTableClick() {

        if (donorsTable.getSelectionModel().getSelectedIndex() != -1) {
            Donor donor2update = (Donor) donorsTable.getSelectionModel().getSelectedItem();

            donorIdFieldDonors.setText(Integer.toString(donor2update.getDonorId()));
            donorNameFieldDonors.setText(donor2update.getName());
            donorLastNameFieldDonors.setText(donor2update.getLastName());
            donorAddressFieldDonors.setText(donor2update.getAddress());
            donorPhoneNumberFieldDonors.setText(donor2update.getPhoneNumber());

            donorIdFieldDonations.setText(Integer.toString(donor2update.getDonorId()));

        } else {
            System.out.println("Nie wybrano elementu!");
        }


    }

    @FXML
    public void OnDeleteClick() throws SQLException {
        //usuwanie z bazy
        Donor donor2delete = (Donor) donorsTable.getSelectionModel().getSelectedItem();
        int donorId = donor2delete.getDonorId();
        donorDAO.deleteDonorById(donorId);
        //aktualizacja z listy
        ObservableList<Donor> data = FXCollections.observableArrayList();
        for(Donor d : donorDAO.getAll()){
            data.add(d);
        }
        donorsTable.setItems(data);
        clearFields();
    }


    @FXML
    public void OnUpdateClick() {

        if(donorIdFieldDonors.getText() != "") {
            //todo dodawanie id grupy krwi (trzeba zmiodyfikować metode updateDonorById)
            donorDAO.updateDonorById(Integer.parseInt(donorIdFieldDonors.getText()), donorNameFieldDonors.getText(), donorLastNameFieldDonors.getText(), donorAddressFieldDonors.getText(), donorPhoneNumberFieldDonors.getText());

            //aktualizacja z listy
            ObservableList<Donor> data = FXCollections.observableArrayList();
            for (Donor d : donorDAO.getAll()) {
                data.add(d);

            }
            donorsTable.setItems(data);
            clearFields();
        }else{
            System.out.println("Nie wybrano krotki!");
        }
    }

    @FXML
    public void OnClearDonorsFields(){

        donorIdFieldDonors.clear();
        donorNameFieldDonors.clear();
        donorLastNameFieldDonors.clear();
        donorAddressFieldDonors.clear();
        donorPhoneNumberFieldDonors.clear();
        donorPeselFieldDonors.clear();
    }

    private String getCurrentTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
        //System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
    }


}
