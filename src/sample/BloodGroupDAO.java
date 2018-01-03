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


public class BloodGroupDAO {
    static final String DB_URL = "jdbc:mysql://vpnmalina.mooo.com:3306/bds";
    //  Database credentials
    static final String USER = "user";
    static final String PASS = "Nosacz!@$";
    private NamedParameterJdbcTemplate jdbc;

    public BloodGroupDAO(){
        try {

            DataSource dataSource = DBUtil.getDataSource(DB_URL, USER, PASS);
            this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<Blood_group> getAll() {
        String sql = "SELECT * FROM blood_group";
        return jdbc.query(sql, new BloodGroupRowMapper());
    }

    public Blood_group findByBloodGroupId(int id){
        String sql = "SELECT * FROM blood_group WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        Blood_group blood_group = (Blood_group)jdbc.queryForObject(sql, namedParameters, new BloodGroupRowMapper());
        return blood_group;
    }

    public void deleteBloodGroupById(int id){
        String sql = "DELETE FROM blood_group WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        jdbc.update(sql, namedParameters);
    }

    public void updateBloodGroupById(int id, String group){
        String sql = "UPDATE blood_group SET group = :group WHERE id = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("group", group);
        namedParameters.addValue("id", id);
        jdbc.update(sql, namedParameters);

    }

    public void create(Blood_group blood_group){
        String sql = "INSERT INTO blood_group(group)" +
                "VALUES (:group)";
        Map namedParameters = new HashMap();
        namedParameters.put("group", blood_group.getGroup());
        jdbc.update(sql, namedParameters);
        System.out.println("Created record with: " + blood_group.toString());
    }

}

class BloodGroupRowMapper implements RowMapper<Blood_group> {

    @Override
    public Blood_group mapRow(ResultSet resultSet, int i) throws SQLException {

        Blood_group blood_group = new Blood_group();
        blood_group.setId(resultSet.getInt("id"));
        blood_group.setGroup(resultSet.getString("group"));

        return blood_group;
    }
}
