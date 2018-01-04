package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingDeque;

public class Controller {
    DonorDAO donorDAO = new DonorDAO();
    StationDAO stationDAO = new StationDAO();
    DonationDAO donationDAO = new DonationDAO();
    BloodGroupDAO bloodDAO = new BloodGroupDAO();
    DemandDAO demandDAO = new DemandDAO();
    StorageDAO storageDAO = new StorageDAO();
    HospitalDAO hospitalDAO = new HospitalDAO();

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
    ComboBox bloodGroupComboDonors;
    List<Integer> bloodComboIdsDonors = new ArrayList<>();

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

    @FXML
    ComboBox bloodGroupComboDonation;
    List<Integer> bloodComboIdsDonation = new ArrayList<>();

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

    @FXML
    ComboBox bloodGroupComboDemand;
    List<Integer> bloodComboIdsDemand = new ArrayList<>();

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

    @FXML
    ComboBox bloodGroupComboStorage;
    List<Integer> bloodComboIdsStorage = new ArrayList<>();

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
    //private HospitalDAO hospitalDAO;

    private void clearFields(){
        System.out.println("Ta metoda musi być zmieniona! (void clearFields())");
        //trzeba dorobić metody do każdej tableki albo wykorzystać metody np OnClearDonorFields, bo to też kasuje
    }

    @FXML
    public void initialize() {

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

        //donations
        idColDonations.setCellValueFactory(new PropertyValueFactory<Donation, String>("id"));
        donorIdColDonations.setCellValueFactory(new PropertyValueFactory<Donation, String>("donorId"));
        bloodLitresColDonations.setCellValueFactory(new PropertyValueFactory<Donation, String>("bloodLitres"));
        dateColDonations.setCellValueFactory(new PropertyValueFactory<Donation, String>("date"));
        stationIdColDonations.setCellValueFactory(new PropertyValueFactory<Donation, String>("stationId"));
        bloodGroupIdColDonations.setCellValueFactory(new PropertyValueFactory<Donation, String>("bloodGroupId"));

        //todo hospital

    }

    @FXML
    public void OnConnectClick(){
        //update tabeli donors
        ObservableList<Donor> data = FXCollections.observableArrayList();
        for (Donor temp : donorDAO.getAll()) {
            data.add(temp);
        }
        infoBox.appendText("Połączono z bazą danych. " + getCurrentTime() + "\r\n");
        donorsTable.setItems(data);

        //update tabeli stations
        ObservableList<Station> datas = FXCollections.observableArrayList();
        for (Station temp : stationDAO.getAll()) {
            datas.add(temp);
        }
        stationsTable.setItems(datas);

        //update tabeli donation
        ObservableList<Donation> datad = FXCollections.observableArrayList();
        for (Donation temp : donationDAO.getAll()) {
            datad.add(temp);
        }
        bloodDonationsTable.setItems(datad);

        //update tabeli blood gourp
        ObservableList<Blood_group> datan = FXCollections.observableArrayList();
        for (Blood_group d : bloodDAO.getAll()) {
            datan.add(d);

        }
        bloodGroupsTable.setItems(datan);

        //update tabeli demand
        ObservableList<Demand> datag = FXCollections.observableArrayList();
        for (Demand d : demandDAO.getAll()) {
            datag.add(d);

        }
        bloodDemandTable.setItems(datag);
        //update tabeli storage
        ObservableList<Storage> datagg = FXCollections.observableArrayList();
        for (Storage d : storageDAO.getAll()) {
            datagg.add(d);

        }
        bloodStorageTable.setItems(datagg);

        //update tabeli hospital
       /* ObservableList<Hospital> datah = FXCollections.observableArrayList();
        for (Hospital d : hospitalDAO.getAll()) {
            datah.add(d);
        }
        hospitalTable.setItems(datah);
*/

        //init combo boxów
        //init comboboxa donors

        ObservableList<String> combo1 = FXCollections.observableArrayList();
        //kasowanie list jeżeli kliknięto jeszcze raz connect
        combo1.removeAll();
        bloodComboIdsDonors.clear();
        for(Blood_group b : bloodDAO.getAll()){
            combo1.add(b.getGroup());
            bloodComboIdsDonors.add(b.getId());
        }

        bloodGroupComboDonors.setItems(combo1);


        //init comboboxa demand

        ObservableList<String> combo2 = FXCollections.observableArrayList();
        //kasowanie list jeżeli kliknięto jeszcze raz connect
        combo2.removeAll();
        bloodComboIdsDemand.clear();
        for(Blood_group b : bloodDAO.getAll()){
            combo2.add(b.getGroup());
            bloodComboIdsDemand.add(b.getId());
        }

        bloodGroupComboDemand.setItems(combo2);

        //init comboboxa Strorage

        ObservableList<String> combo3 = FXCollections.observableArrayList();
        //kasowanie list jeżeli kliknięto jeszcze raz connect
        combo3.removeAll();
        bloodComboIdsStorage.clear();
        for(Blood_group b : bloodDAO.getAll()){
            combo3.add(b.getGroup());
            bloodComboIdsStorage.add(b.getId());
        }

        bloodGroupComboStorage.setItems(combo3);

        //init comboboxa donations

        ObservableList<String> combo4 = FXCollections.observableArrayList();
        //kasowanie list jeżeli kliknięto jeszcze raz connect
        combo4.removeAll();
        bloodComboIdsDonation.clear();
        for(Blood_group b : bloodDAO.getAll()){
            combo4.add(b.getGroup());
            bloodComboIdsDonation.add(b.getId());
        }

        bloodGroupComboDonation.setItems(combo4);
    } //todo

    //donors
    @FXML
    public void OnDonorAddClick() {
        Donor d = new Donor();
        d.setName(donorNameFieldDonors.getText());
        d.setLastName(donorLastNameFieldDonors.getText());
        d.setBloodGroupId(bloodComboIdsDonors.get(bloodGroupComboDonors.getSelectionModel().getSelectedIndex()));
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
            donorDAO.updateDonorById(Integer.parseInt(donorIdFieldDonors.getText()), donorNameFieldDonors.getText(), donorLastNameFieldDonors.getText(), donorAddressFieldDonors.getText(), donorPhoneNumberFieldDonors.getText(), bloodComboIdsDonors.get(bloodGroupComboDonors.getSelectionModel().getSelectedIndex()));

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

    //station
    @FXML
    public void OnStationAddClick() {
        Station s = new Station();
        s.setName(nameFieldStations.getText());
        s.setAddress(addressFieldStations.getText());
        s.setPhoneNumber(phoneNumberFieldStations.getText());

        stationDAO.create(s);

        //update tabeli
        ObservableList<Station> data = FXCollections.observableArrayList();
        for (Station temp : stationDAO.getAll()) {
            data.add(temp);
        }
        stationsTable.setItems(data);

        OnClearStationFields();

    }

    @FXML
    public void OnStationTableClick() {

        if (stationsTable.getSelectionModel().getSelectedIndex() != -1) {
            Station station2update = (Station) stationsTable.getSelectionModel().getSelectedItem();

            idFieldStations.setText(Integer.toString(station2update.getId()));
            nameFieldStations.setText(station2update.getName());
            addressFieldStations.setText(station2update.getAddress());
            phoneNumberFieldStations.setText(station2update.getPhoneNumber());

            //todo id jednostki wpisywac do pozostałch fieldow

        } else {
            System.out.println("Nie wybrano elementu!");
        }


    }

    @FXML
    public void OnStationDeleteClick() {
        Station station2delete = (Station) stationsTable.getSelectionModel().getSelectedItem();
        int stationId = station2delete.getId();
        stationDAO.deleteStationById(stationId);

        //update tabeli
        ObservableList<Station> data = FXCollections.observableArrayList();
        for (Station temp : stationDAO.getAll()) {
            data.add(temp);
        }
        stationsTable.setItems(data);

        OnClearStationFields();
    }

    @FXML
    public void OnStationUpdateClick() {

        if(idFieldStations.getText() != "") {
            stationDAO.updateStationById(Integer.parseInt(idFieldStations.getText()), nameFieldStations.getText(), addressFieldStations.getText(), phoneNumberFieldStations.getText());

            //update tabeli
            ObservableList<Station> data = FXCollections.observableArrayList();
            for (Station temp : stationDAO.getAll()) {
                data.add(temp);
            }
            stationsTable.setItems(data);

            OnClearStationFields();
        }else{
            System.out.println("Nie wybrano krotki!");
        }
    }

    @FXML
    public void OnClearStationFields() {

        idFieldStations.clear();
        nameFieldStations.clear();
        addressFieldStations.clear();
        phoneNumberFieldStations.clear();
    }

    //groups
    @FXML
    public void OnBloodGroupAddClick() {
        Blood_group d = new Blood_group();
        d.setGroup(groupFieldBloodGroups.getText());

        bloodDAO.create(d);
        //aktualizacja z listy
        ObservableList<Blood_group> data = FXCollections.observableArrayList();
        for (Blood_group temp : bloodDAO.getAll()) {
            data.add(temp);
        }
        bloodGroupsTable.setItems(data);

        OnClearBloodGroupFields();

    }

    @FXML
    public void OnBloodGroupTableClick() {

        if (bloodGroupsTable.getSelectionModel().getSelectedIndex() != -1){
            Blood_group blood2update = (Blood_group) bloodGroupsTable.getSelectionModel().getSelectedItem();

            idFieldBloodGroups.setText(Integer.toString(blood2update.getId()));
            groupFieldBloodGroups.setText(blood2update.getGroup());

        } else {
            System.out.println("Nie wybrano elementu!");
        }


    }

    @FXML
    public void OnBloodGroupDeleteClick() {
        //usuwanie z bazy
        Blood_group blood2delete = (Blood_group) bloodGroupsTable.getSelectionModel().getSelectedItem();
        int bloodId = blood2delete.getId();
        bloodDAO.deleteBloodGroupById(bloodId);

        //aktualizacja z listy
        ObservableList<Blood_group> data = FXCollections.observableArrayList();
        for(Blood_group d : bloodDAO.getAll()){
            data.add(d);
        }
        bloodGroupsTable.setItems(data);

        OnClearBloodGroupFields();

    }

    @FXML
    public void OnBloodGroupUpdateClick() {

        if(idFieldBloodGroups.getText() != "") {

            //donorDAO.updateDonorById(Integer.parseInt(donorIdFieldDonors.getText()), donorNameFieldDonors.getText(), donorLastNameFieldDonors.getText(), donorAddressFieldDonors.getText(), donorPhoneNumberFieldDonors.getText());
            bloodDAO.updateBloodGroupById(Integer.parseInt(idFieldBloodGroups.getText()), groupFieldBloodGroups.getText());

            //aktualizacja z listy
            ObservableList<Blood_group> data = FXCollections.observableArrayList();
            for (Blood_group d : bloodDAO.getAll()) {
                data.add(d);

            }
            bloodGroupsTable.setItems(data);
            OnClearBloodGroupFields();
        }else{
            System.out.println("Nie wybrano krotki!");
        }
    }

    @FXML
    public void OnClearBloodGroupFields(){

        groupFieldBloodGroups.clear();
        idFieldBloodGroups.clear();
    }

    //donations
    @FXML
    public void OnDonationAddClick() {
        Donation d = new Donation();
        d.setDonorId(Integer.parseInt(donorIdFieldDonations.getText()));
        d.setBloodLitres(Float.parseFloat(bloodLitresFieldDonations.getText()));
        d.setDate(dateFieldDonations.getText());
        d.setStationId(Integer.parseInt(stationIdFieldDonations.getText()));
        d.setBloodGroupId(bloodComboIdsDonation.get(bloodGroupComboDonation.getSelectionModel().getSelectedIndex()));

        donationDAO.create(d);

        //update tabeli donation
        ObservableList<Donation> datad = FXCollections.observableArrayList();
        for (Donation temp : donationDAO.getAll()) {
            datad.add(temp);
        }
        bloodDonationsTable.setItems(datad);
        OnClearDonationFields();

    }

    @FXML
    public void OnDonationTableClick() {

        if (bloodDonationsTable.getSelectionModel().getSelectedIndex() != -1) {
            Donation donation2update = (Donation) bloodDonationsTable.getSelectionModel().getSelectedItem();

            idFieldDonations.setText(Integer.toString(donation2update.getId()));
            donorIdFieldDonations.setText(Integer.toString(donation2update.getDonorId()));
            bloodLitresFieldDonations.setText(Float.toString(donation2update.getBloodLitres()));
            dateFieldDonations.setText(donation2update.getDate());
            stationIdFieldDonations.setText(Integer.toString(donation2update.getStationId()));
            bloodGroupIdFieldDonations.setText(Integer.toString(donation2update.getBloodGroupId()));

        } else {
            System.out.println("Nie wybrano elementu!");
        }
    }

    @FXML
    public void OnDonationDeleteClick() {
        Donation donation2delete = (Donation) bloodDonationsTable.getSelectionModel().getSelectedItem();
        donationDAO.deleteDonationById(donation2delete.getId());

        //update tabeli donation
        ObservableList<Donation> datad = FXCollections.observableArrayList();
        for (Donation temp : donationDAO.getAll()) {
            datad.add(temp);
        }
        bloodDonationsTable.setItems(datad);
        OnClearDonationFields();
    }

    @FXML
    public void OnDonationUpdateClick() {

        if(idFieldDonations.getText() != "") {
            donationDAO.updateDonationById(Integer.parseInt(idFieldDonations.getText()), Integer.parseInt(donorIdFieldDonations.getText()), Float.parseFloat(bloodLitresFieldDonations.getText()), dateFieldDonations.getText(), Integer.parseInt(stationIdFieldDonations.getText()), bloodComboIdsDonation.get(bloodGroupComboDonation.getSelectionModel().getSelectedIndex()));

            //update tabeli donation
            ObservableList<Donation> datad = FXCollections.observableArrayList();
            for (Donation temp : donationDAO.getAll()) {
                datad.add(temp);
            }
            bloodDonationsTable.setItems(datad);
            OnClearDonationFields();
        }else{
            System.out.println("Nie wybrano krotki!");
        }
    }

    @FXML
    public void OnClearDonationFields(){
        idFieldDonations.clear();
        stationIdFieldDonations.clear();
        dateFieldDonations.clear();
        bloodLitresFieldDonations.clear();
        donorIdFieldDonations.clear();
        bloodGroupIdFieldDonations.clear();
    }

    //demand
    @FXML
    public void OnDemandAddClick() {
        Demand d = new Demand();
        d.setBloodGroupId(bloodComboIdsDemand.get(bloodGroupComboDemand.getSelectionModel().getSelectedIndex()));
        d.setQuantity(Float.parseFloat(quantityFieldDemand.getText()));

        demandDAO.create(d);
        //aktualizacja z listy
        ObservableList<Demand> data = FXCollections.observableArrayList();
        for (Demand temp : demandDAO.getAll()) {
            data.add(temp);
        }
        bloodDemandTable.setItems(data);

        OnClearDemandFields();

    }

    @FXML
    public void OnDemandTableClick() {

        if (bloodDemandTable.getSelectionModel().getSelectedIndex() != -1) {
            Demand demand2update = (Demand) bloodDemandTable.getSelectionModel().getSelectedItem();

            idFieldDemand.setText(Integer.toString(demand2update.getId()));
            storageIdFieldDemand.setText(Integer.toString(demand2update.getStorageId()));
            bloodGroupIdFieldDemand.setText(Integer.toString(demand2update.getBloodGroupId()));
            quantityFieldDemand.setText(Float.toString(demand2update.getQuantity()));

        } else {
            System.out.println("Nie wybrano elementu!");
        }


    }

    @FXML
    public void OnDemandDeleteClick() {
        //usuwanie z bazy
        Demand demand2delete = (Demand) bloodDemandTable.getSelectionModel().getSelectedItem();
        int demandId = demand2delete.getId();
        demandDAO.deletedemandById(demandId);
        //aktualizacja z listy
        ObservableList<Demand> data = FXCollections.observableArrayList();
        for(Demand d : demandDAO.getAll()){
            data.add(d);
        }
        bloodDemandTable.setItems(data);
        OnClearDemandFields();
    }

    @FXML
    public void OnDemandUpdateClick() {

        if(idFieldDemand.getText() != "") {
            demandDAO.updateDemandById(Integer.parseInt(idFieldDemand.getText()), Integer.parseInt(storageIdFieldDemand.getText()), bloodComboIdsDemand.get(bloodGroupComboDemand.getSelectionModel().getSelectedIndex()), Float.parseFloat(quantityFieldDemand.getText()));

            //aktualizacja z listy
            ObservableList<Demand> data = FXCollections.observableArrayList();
            for (Demand d : demandDAO.getAll()) {
                data.add(d);

            }
            bloodDemandTable.setItems(data);
            OnClearDemandFields();
        }else{
            System.out.println("Nie wybrano krotki!");
        }
    }

    @FXML
    public void OnClearDemandFields(){
        idFieldDemand.clear();
        storageIdFieldDemand.clear();
        bloodGroupIdFieldDemand.clear();
        quantityFieldDemand.clear();
    }

    //storage
    @FXML
    public void OnStorageAddClick() {
        Storage d = new Storage();

        d.setStationId(Integer.parseInt(stationIdFieldStorage.getText()));
        d.setBloodValue(Float.parseFloat(valueFieldStorage.getText()));
        d.setBloodGroupId(bloodComboIdsStorage.get(bloodGroupComboStorage.getSelectionModel().getSelectedIndex()));
        d.setPhoneNumber(phoneNumberFieldStorage.getText());
        d.setAddress(addressFieldStorage.getText());

        storageDAO.create(d);
        //aktualizacja z listy
        ObservableList<Storage> data = FXCollections.observableArrayList();
        for (Storage temp : storageDAO.getAll()) {
            data.add(temp);
        }
        bloodStorageTable.setItems(data);
        OnClearStorageFields();

    }

    @FXML
    public void OnStorageTableClick() {

        if (bloodStorageTable.getSelectionModel().getSelectedIndex() != -1) {
            Storage storage2update = (Storage) bloodStorageTable.getSelectionModel().getSelectedItem();

            idFieldStorage.setText(Integer.toString(storage2update.getId()));
            stationIdFieldStorage.setText(Integer.toString(storage2update.getStationId()));
            valueFieldStorage.setText(Float.toString(storage2update.getBloodValue()));
            bloodGroupIdFieldStorage.setText(Integer.toString(storage2update.getBloodGroupId()));
            phoneNumberFieldStorage.setText(storage2update.getPhoneNumber());
            addressFieldStorage.setText(storage2update.getAddress());

        } else {
            System.out.println("Nie wybrano elementu!");
        }


    }

    @FXML
    public void OnStorageDeleteClick() {
        //usuwanie z bazy
        Storage storage2delete = (Storage) bloodStorageTable.getSelectionModel().getSelectedItem();
        int storageId = storage2delete.getId();
        storageDAO.deleteStorageById(storageId);
        //aktualizacja z listy
        ObservableList<Storage> data = FXCollections.observableArrayList();
        for(Storage d : storageDAO.getAll()){
            data.add(d);
        }
        bloodStorageTable.setItems(data);
        OnClearStorageFields();
    }

    @FXML
    public void OnStorageUpdateClick() {

        if(idFieldStorage.getText() != "") {
            //storageDAO.updateStorageById(Integer.parseInt(idFieldStorage.getText()), ); todo
            //kombo z krwią: bloodComboIdsStorage.get(bloodGroupComboStorage.getSelectionModel().getSelectedIndex()) todo

            //aktualizacja z listy
            ObservableList<Storage> data = FXCollections.observableArrayList();
            for (Storage d : storageDAO.getAll()) {
                data.add(d);

            }
            donorsTable.setItems(data);
            OnClearStorageFields();
        }else{
            System.out.println("Nie wybrano krotki!");
        }
    }//todo wgl nie update'uje

    @FXML
    public void OnClearStorageFields(){

        idFieldStorage.clear();
        stationIdFieldStorage.clear();
        valueFieldStorage.clear();
        bloodGroupIdFieldStorage.clear();
        phoneNumberFieldStorage.clear();
        addressFieldStorage.clear();
    }

    //hospital
    @FXML
    public void OnHospitalAddClick() {
        Donor d = new Donor();
        d.setName(donorNameFieldDonors.getText());
        d.setLastName(donorLastNameFieldDonors.getText());
        d.setBloodGroupId(bloodGroupComboDonors.getSelectionModel().getSelectedIndex());
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

    }//todo w całosci

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


    }//todo w całosci

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
    }//todo w całosci

    @FXML
    public void OnHospitalUpdateClick() {

        if(donorIdFieldDonors.getText() != "") {

            //donorDAO.updateDonorById(Integer.parseInt(donorIdFieldDonors.getText()), donorNameFieldDonors.getText(), donorLastNameFieldDonors.getText(), donorAddressFieldDonors.getText(), donorPhoneNumberFieldDonors.getText());

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
    }//todo w całosci

    @FXML
    public void OnClearHospitalFields(){
        idFieldHospital.clear();
        nameFieldHospital.clear();
        addressFieldHospital.clear();
        phoneNumberFieldHospital.clear();
    }

    private String getCurrentTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
        //System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
    }


}
