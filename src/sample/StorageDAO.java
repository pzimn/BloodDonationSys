package sample;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StorageDAO {
    static final String DB_URL = "jdbc:mysql://vpnmalina.mooo.com:3306/bds";
    //  Database credentials
    static final String USER = "user";
    static final String PASS = "Nosacz!@$";
    private NamedParameterJdbcTemplate jdbc;

    public StorageDAO(){
        try {

            DataSource dataSource = DBUtil.getDataSource(DB_URL, USER, PASS);
            this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<Storage> getAll() {
        String sql = "SELECT * FROM storages";
        return jdbc.query(sql, new StorageMapper());
    }

    public Storage findByStorageId(int id){
        String sql = "SELECT * FROM storages WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        Storage storage = (Storage) jdbc.queryForObject(sql, namedParameters, new StorageMapper());
        return storage;
    }

    public void deleteStorageById(int id){
        String sql = "DELETE FROM storages WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        jdbc.update(sql, namedParameters);
    }

    public void updateStorageById(int id, int stationId, float bloodValue, int bloodGroupId, String phoneNumber, String address ){
        String sql = "UPDATE storages SET stationId = :stationId, blood_value = :bloodValue, bloodGroupId = :bloodGroupId, phoneNumber = :phoneNumber, address = :address  WHERE id = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("stationId", stationId);
        namedParameters.addValue("bloodValue", bloodValue);
        namedParameters.addValue("bloodGroupId", bloodGroupId);
        namedParameters.addValue("phoneNumber", phoneNumber);
        namedParameters.addValue("address", address);
        namedParameters.addValue("id", id);
        jdbc.update(sql, namedParameters);

    }

    public void create(Storage storage){
        String sql = "INSERT INTO storages(stationId, bloodValue, bloodGroupId, phoneNumber, address)" +
                "VALUES (:stationId, :bloodValue, :bloodGroupId, :phoneNumber, :address)";
        Map namedParameters = new HashMap();
        namedParameters.put("stationId", storage.getStationId());
        namedParameters.put("bloodValue", storage.getBloodValue());
        namedParameters.put("bloodGroupId", storage.getBloodGroupId());
        namedParameters.put("phoneNumber", storage.getPhoneNumber());
        namedParameters.put("address", storage.getAddress());

        jdbc.update(sql, namedParameters);
        System.out.println("Created record with: " + storage.toString());
    }

}

class StorageMapper implements RowMapper<Storage> {

    @Override
    public Storage mapRow(ResultSet resultSet, int i) throws SQLException {

        Storage storage = new Storage();
        storage.setId(resultSet.getInt("id"));
        storage.setStationId(resultSet.getInt("stationId"));
        storage.setBloodValue(resultSet.getFloat("bloodValue"));
        storage.setBloodGroupId(resultSet.getInt("bloodGroupId"));
        storage.setPhoneNumber(resultSet.getString("phoneNumber"));
        storage.setAddress(resultSet.getString("address"));

        return storage;
    }
}
