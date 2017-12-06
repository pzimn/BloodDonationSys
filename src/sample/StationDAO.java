package sample;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StationDAO {
    static final String DB_URL = "jdbc:mysql://localhost:3306/bds";
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    private NamedParameterJdbcTemplate jdbc;

    public StationDAO() {
        try {
            DataSource dataSource = DBUtil.getDataSource(DB_URL, USER, PASS);
            this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<Station> getAll() {
        String sql = "SELECT * FROM stations";
        return jdbc.query(sql, new stationRowMapper());
    }

    public Station findByStationId(int id){
        String sql = "SELECT * FROM stations WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        Station station = (Station) jdbc.queryForObject(sql, namedParameters, new stationRowMapper());
        return station;
    }

    public void deleteStationById(int id){
        String sql = "DELETE FROM stations WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        jdbc.update(sql, namedParameters);
    }

    public void updateStationById(int id, String name, String address, String phoneNumber){
        String sql = "UPDATE stations SET address = :address, name = :name, phone_number = :phoneNumber WHERE id = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("name", name);
        namedParameters.addValue("address", address);
        namedParameters.addValue("phone_number", phoneNumber);
        namedParameters.addValue("id", id);
        jdbc.update(sql, namedParameters);

    }

    public void create(Station station){
        String sql = "INSERT INTO stations(name,address,phone_number)" +
                "VALUES (:name, :address, :phone_number)";
        Map namedParameters = new HashMap();
        namedParameters.put("name", station.getName());
        namedParameters.put("address", station.getAddress());
        namedParameters.put("phone_number", station.getAddress());
        jdbc.update(sql, namedParameters);
        System.out.println("Created record with: " + station.toString());
    }
}

class stationRowMapper implements RowMapper<Station> {

    @Override
    public Station mapRow(ResultSet resultSet, int i) throws SQLException {
        Station station = new Station();
        station.setId(resultSet.getInt("id"));
        station.setName(resultSet.getString("name"));
        station.setAddress(resultSet.getString("address"));
        station.setPhoneNumber(resultSet.getString("phone_number"));
        return station;

    }
}