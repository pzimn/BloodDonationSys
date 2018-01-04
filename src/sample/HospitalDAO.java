package sample;

import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HospitalDAO {

    private MongoDatabase database;
    private MongoCollection<Document> collection;
    public HospitalDAO(){
        MongoClient mongo = new MongoClient("localhost", 27017);
        //Dostęp do bazy danych
        this.database = mongo.getDatabase("BloodDonationSys");
        this.collection = database.getCollection("hospitalCollection");
    }

    public void addHospitalToCollection(Hospital hospital){
        Document document = new Document()
                .append("id",hospital.getId())
                .append("hospitalName",hospital.getHospitalName())
                .append("hospitalAddress", hospital.getHospitalAddress())
                .append("phoneNumber",hospital.getPhoneNumber());
        collection.insertOne(document);
        System.out.println("Hospital added successfully");
    }

    public List<Hospital> getWholeHospitalCollection(){
        List<Hospital> hospitalList = new ArrayList<>();
        FindIterable<Document> iterDoc = collection.find();
        int i = 1;
        Iterator documentIterator = iterDoc.iterator();

        while (documentIterator.hasNext()) {
            DBObject obj = (DBObject)documentIterator.next();
            Hospital hospital = new Hospital((int)obj.get("id"),String.valueOf(obj.get("hospitalName")),
                    String.valueOf(obj.get("hospitalAddress")),String.valueOf(obj.get("phoneNumber")));
            hospitalList.add(hospital);
            i++;
        }
        return hospitalList;
    }

    public void updateHospitalById(int id, String hospitalName, String hospitalAddress, String phoneNumber){
        collection.updateOne(Filters.eq("id", id), Updates.set("hospitalName",hospitalName));
        collection.updateOne(Filters.eq("id", id), Updates.set("hospitalAddress",hospitalAddress));
        collection.updateOne(Filters.eq("id", id), Updates.set("phoneNumber",phoneNumber));
    }

    public void deleteHospitalById(int id){
        collection.deleteOne(Filters.eq("id",id));
        System.out.println("Hospital deleted successfully");
    }

    public Hospital findHospitalById(int id){
        FindIterable<Document> iterDoc = collection.find(Filters.eq("id",id));
        Iterator documentIterator = iterDoc.iterator();
        DBObject obj = (DBObject)documentIterator.next();
        Hospital hospital = new Hospital((int)obj.get("id"),String.valueOf(obj.get("hospitalName")),
                String.valueOf(obj.get("hospitalAddress")),String.valueOf(obj.get("phoneNumber")));
        return hospital;
    }




}
