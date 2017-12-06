package sample;
import com.sun.org.glassfish.gmbal.ManagedObject;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DonorDAO {
    static final String DB_URL = "jdbc:mysql://localhost:3306/bds";
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    private NamedParameterJdbcTemplate jdbc;

    public DonorDAO(){
        try {

            DataSource dataSource = DBUtil.getDataSource(DB_URL, USER, PASS);
            this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<Donor> getAll() {
        String sql = "SELECT * FROM donors";
        return jdbc.query(sql, new DonorRowMapper());
    }

    public Donor findByDonorId(int id){
        String sql = "SELECT * FROM donors WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        Donor donor = (Donor) jdbc.queryForObject(sql, namedParameters, new DonorRowMapper());
        return donor;
    }

    public void deleteDonorById(int id){
        String sql = "DELETE FROM donors WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        jdbc.update(sql, namedParameters);
    }

    public void updateDonorById(int id, String name, String last_name, String address, String phoneNumber){
        String sql = "UPDATE donors SET address = :address, name = :name, last_name = :last_name, phone_number = :phoneNumber WHERE id = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("name", name);
        namedParameters.addValue("last_name", last_name);
        namedParameters.addValue("address", address);
        namedParameters.addValue("phoneNumber", phoneNumber);
        namedParameters.addValue("id", id);
        jdbc.update(sql, namedParameters);

    }

    public void create(Donor donor){
        String sql = "INSERT INTO donors(name,last_name,blood_group_id,address,phone_number)" +
                "VALUES (:name, :last_name, :blood_group_id, :address, :phone_number)";
        Map namedParameters = new HashMap();
        namedParameters.put("name", donor.getName());
        namedParameters.put("last_name", donor.getLastName());
        namedParameters.put("blood_group_id",donor.getBloodGroupId());
        namedParameters.put("address", donor.getAddress());
        namedParameters.put("phone_number", donor.getPhoneNumber());
        jdbc.update(sql, namedParameters);
        System.out.println("Created record with: " + donor.toString());
    }

}

class DonorRowMapper implements RowMapper<Donor> {

    @Override
    public Donor mapRow(ResultSet resultSet, int i) throws SQLException {

        Donor donor = new Donor();
        donor.setDonorId(resultSet.getInt("id"));
        donor.setBloodGroupId(resultSet.getInt("blood_group_id"));
        donor.setName(resultSet.getString("name"));
        donor.setLastName(resultSet.getString("last_name"));
        donor.setAddress(resultSet.getString("address"));
        donor.setPhoneNumber(resultSet.getString("phone_number"));

        return donor;


    }
}
