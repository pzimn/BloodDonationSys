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
    TableColumn<Station, String> idColStations;
    @FXML
    TableColumn<Station, String> nameColStations;
    @FXML
    TableColumn<Station, String> addressColStations;
    @FXML
    TableColumn<Station, String> phoneNumberColStations;

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
    TableColumn<Blood_group, String> idColBloodGroups;
    @FXML
    TableColumn<Blood_group, String> groupColBloodGroups;

    @FXML
    TextField idFieldBloodGroups;
    @FXML
    TextField groupFieldBloodGroups;

    //oddania
    @FXML
    TableView bloodDonationsTable;

    @FXML
    TableColumn<Donation, String> idColDonations;
    @FXML
    TableColumn<Donation, String> donorIdColDonations;
    @FXML
    TableColumn<Donation, String> bloodLitresColDonations;
    @FXML
    TableColumn<Donation, String> bloodGroupIdColDonations;
    @FXML
    TableColumn<Donation, String> dateColDonations;
    @FXML
    TableColumn<Donation, String> stationIdColDonations;

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
    TableColumn<Demand, String> idColDemand;
    @FXML
    TableColumn<Demand, String> storageIdColDemand;
    @FXML
    TableColumn<Demand, String> bloodGroupIdColDemand;
    @FXML
    TableColumn<Demand, String> quantityColDemand;

    @FXML
    TextField idFieldDemand;
    @FXML
    TextField storageIdFieldDemand;
    @FXML
    TextField bloodGroupIdFieldDemand;
    @FXML
    TextField quantityFieldDemand;

    //magazyn
    @FXML
    TableView bloodStorageTable;

    @FXML
    TableColumn<Storage, String> idColStorage;
    @FXML
    TableColumn<Storage, String> stationIdColStorage;
    @FXML
    TableColumn<Storage, String> valueColStorage;
    @FXML
    TableColumn<Storage, String> bloodGroupIdColStorage;
    @FXML
    TableColumn<Storage, String> phoneNumberColStorage;
    @FXML
    TableColumn<Storage, String> addressColStorage;

    @FXML
    TextField idFieldStorage;
    @FXML
    TextField stationIdFieldStorage;
    @FXML
    TextField valueFieldStorage;
    @FXML
    TextField bloodGroupIdFieldStorage;
    @FXML
    TextField phoneNumberFieldStorage;
    @FXML
    TextField addressFieldStorage;

    //szpital
    @FXML
    TableView hospitalTable;

    @FXML
    TableColumn<Storage, String> idColHospital;
    @FXML
    TableColumn<Storage, String> nameColHospital;
    @FXML
    TableColumn<Storage, String> addressColHospital;
    @FXML
    TableColumn<Storage, String> phoneNumberColHospital;

    @FXML
    TextField idFieldHospital;
    @FXML
    TextField nameFieldHospital;
    @FXML
    TextField addressFieldHospital;
    @FXML
    TextField phoneNumberFieldHospital;

    private void clearFields(){
        System.out.println("Ta metoda musi być zmieniona! (void clearFields())");
        //trzeba dorobić metody do każdej tableki albo wykorzystać metody np OnClearDonorFields, bo to też kasuje
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

        //donors
        donorIdColDonors.setCellValueFactory(new PropertyValueFactory<Donor, Integer>("donorId"));
        nameColDonors.setCellValueFactory(new PropertyValueFactory<Donor, String>("name"));
        lastNameColDonors.setCellValueFactory(new PropertyValueFactory<Donor, String>("lastName"));
        bloodGroupColDonors.setCellValueFactory(new PropertyValueFactory<Donor, Integer>("bloodGroupId"));
        addressColDonors.setCellValueFactory(new PropertyValueFactory<Donor, String>("address"));
        phoneNumberColDonors.setCellValueFactory(new PropertyValueFactory<Donor, String>("phoneNumber"));

        //stations
        idColStations.setCellValueFactory(new PropertyValueFactory<Station, String>("id"));
        nameColStations.setCellValueFactory(new PropertyValueFactory<Station, String>("name"));
        addressColStations.setCellValueFactory(new PropertyValueFactory<Station, String>("address"));
        phoneNumberColStations.setCellValueFactory(new PropertyValueFactory<Station, String>("phoneNumber"));


        //storage
        idColStorage.setCellValueFactory(new PropertyValueFactory<Storage, String>("id"));
        stationIdColStorage.setCellValueFactory(new PropertyValueFactory<Storage, String>("stationId"));
        valueColStorage.setCellValueFactory(new PropertyValueFactory<Storage, String>("bloodValue"));
        bloodGroupIdColStorage.setCellValueFactory(new PropertyValueFactory<Storage, String>("bloodGroupId"));
        phoneNumberColStorage.setCellValueFactory(new PropertyValueFactory<Storage, String>("phoneNumber"));
        addressColStorage.setCellValueFactory(new PropertyValueFactory<Storage, String>("address"));


        //demand
        idColDemand.setCellValueFactory(new PropertyValueFactory<Demand, String>("id"));
        storageIdColDemand.setCellValueFactory(new PropertyValueFactory<Demand, String>("storageId"));
        bloodGroupIdColDemand.setCellValueFactory(new PropertyValueFactory<Demand, String>("bloodGroupId"));
        quantityColDemand.setCellValueFactory(new PropertyValueFactory<Demand, String>("quantity"));

        //blood group
        idColBloodGroups.setCellValueFactory(new PropertyValueFactory<Blood_group, String>("id"));
        groupColBloodGroups.setCellValueFactory(new PropertyValueFactory<Blood_group, String>("group"));

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

    //donors
    @FXML
    public void OnDonorAddClick() {
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
        OnClearDonorFields();
    }

    @FXML
    public void OnDonorTableClick() {

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
    public void OnDonorDeleteClick() {
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
        OnClearDonorFields();
    }

    @FXML
    public void OnDonorUpdateClick() {

        if(donorIdFieldDonors.getText() != "") {
            //todo dodawanie id grupy krwi (trzeba zmiodyfikować metode updateDonorById)
            donorDAO.updateDonorById(Integer.parseInt(donorIdFieldDonors.getText()), donorNameFieldDonors.getText(), donorLastNameFieldDonors.getText(), donorAddressFieldDonors.getText(), donorPhoneNumberFieldDonors.getText());

            //aktualizacja z listy
            ObservableList<Donor> data = FXCollections.observableArrayList();
            for (Donor d : donorDAO.getAll()) {
                data.add(d);

            }
            donorsTable.setItems(data);
            OnClearDonorFields();
        }else{
            System.out.println("Nie wybrano krotki!");
        }
    }

    @FXML
    public void OnClearDonorFields(){
        donorIdFieldDonors.clear();
        donorNameFieldDonors.clear();
        donorLastNameFieldDonors.clear();
        donorAddressFieldDonors.clear();
        donorPhoneNumberFieldDonors.clear();
        donorPeselFieldDonors.clear();
    }

    //todo stations
    @FXML
    public void OnStationAddClick() {
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
    public void OnStationTableClick() {

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
    public void OnStationDeleteClick() {
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
    public void OnStationUpdateClick() {

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
    public void OnClearStationFields(){

        donorIdFieldDonors.clear();
        donorNameFieldDonors.clear();
        donorLastNameFieldDonors.clear();
        donorAddressFieldDonors.clear();
        donorPhoneNumberFieldDonors.clear();
        donorPeselFieldDonors.clear();
    }

    //todo groups
    @FXML
    public void OnBloodGroupAddClick() {
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
    public void OnBloodGroupTableClick() {

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
    public void OnBloodGroupDeleteClick() {
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
    public void OnBloodGroupUpdateClick() {

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
    public void OnClearBloodGroupFields(){

        donorIdFieldDonors.clear();
        donorNameFieldDonors.clear();
        donorLastNameFieldDonors.clear();
        donorAddressFieldDonors.clear();
        donorPhoneNumberFieldDonors.clear();
        donorPeselFieldDonors.clear();
    }

    //todo donations
    @FXML
    public void OnDonationAddClick() {
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
    public void OnDonationTableClick() {

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
    public void OnDonationDeleteClick() {
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
    public void OnDonationUpdateClick() {

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
    public void OnClearDonationFields(){

        donorIdFieldDonors.clear();
        donorNameFieldDonors.clear();
        donorLastNameFieldDonors.clear();
        donorAddressFieldDonors.clear();
        donorPhoneNumberFieldDonors.clear();
        donorPeselFieldDonors.clear();
    }

    //todo demand
    @FXML
    public void OnDemandAddClick() {
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
    public void OnDemandTableClick() {

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
    public void OnDemandDeleteClick() {
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
    public void OnDemandUpdateClick() {

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
    public void OnClearDemandFields(){

        donorIdFieldDonors.clear();
        donorNameFieldDonors.clear();
        donorLastNameFieldDonors.clear();
        donorAddressFieldDonors.clear();
        donorPhoneNumberFieldDonors.clear();
        donorPeselFieldDonors.clear();
    }
    //todo storage
    @FXML
    public void OnStorageAddClick() {
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
    public void OnStorageTableClick() {

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
    public void OnStorageDeleteClick() {
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
    public void OnStorageUpdateClick() {

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
    public void OnClearStorageFields(){

        donorIdFieldDonors.clear();
        donorNameFieldDonors.clear();
        donorLastNameFieldDonors.clear();
        donorAddressFieldDonors.clear();
        donorPhoneNumberFieldDonors.clear();
        donorPeselFieldDonors.clear();
    }

    //todo hospital
    @FXML
    public void OnHospitalAddClick() {
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
    public void OnHospitalTableClick() {

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
    public void OnHospitalDeleteClick() {
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
    public void OnHospitalUpdateClick() {

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
    public void OnClearHospitalFields(){

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
