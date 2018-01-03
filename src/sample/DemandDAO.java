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

public class DemandDAO {
    static final String DB_URL = "jdbc:mysql://localhost:3306/bds";
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    private NamedParameterJdbcTemplate jdbc;

    public DemandDAO() {
        try {
            DataSource dataSource = DBUtil.getDataSource(DB_URL, USER, PASS);
            this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<Station> getAll() {
        String sql = "SELECT * FROM demand";
        return jdbc.query(sql, new stationRowMapper());
    }

    public Demand findByDemandId(int id){
        String sql = "SELECT * FROM demand WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        Demand demand = (Demand) jdbc.queryForObject(sql, namedParameters, new demandRowMapper());
        return demand;
    }

    public void deletedemandById(int id){
        String sql = "DELETE FROM demand WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        jdbc.update(sql, namedParameters);
    }

    public void updateDemandById(int id, int storageId, int bloodGroupId, float quantity){
        String sql = "UPDATE demand SET storage_id = :storageId, blood_group_id = :bloodGroupId, quantity = :quantity WHERE id = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("storageId", storageId);
        namedParameters.addValue("bloodGroupId", bloodGroupId);
        namedParameters.addValue("quantity", quantity);
        namedParameters.addValue("id", id);
        jdbc.update(sql, namedParameters);

    }

    public void create(Demand demand){
        String sql = "INSERT INTO demand(storage_id,blood_group_id,quantity)" +
                "VALUES (:storageId, :bloodGroupId, :quantity)";
        Map namedParameters = new HashMap();
        namedParameters.put("storageId", demand.getStorageId());
        namedParameters.put("bloodGroupId", demand.getBloodGroupId());
        namedParameters.put("quantity", demand.getQuantity());
        jdbc.update(sql, namedParameters);
        System.out.println("Created record with: " + demand.toString());
    }
}


class demandRowMapper implements RowMapper<Demand> {

    @Override
    public Demand mapRow(ResultSet resultSet, int i) throws SQLException {
        Demand demand = new Demand();
        demand.setStorageId(resultSet.getInt("storage_id"));
        demand.setBloodGroupId(resultSet.getInt("blood_group_id"));
        demand.setQuantity(resultSet.getFloat("quantity"));
        return demand;
    }
}


