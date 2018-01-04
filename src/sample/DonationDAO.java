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

public class DonationDAO {
    static final String DB_URL = "jdbc:mysql://vpnmalina.mooo.com:3306/bds";
    //  Database credentials
    static final String USER = "user";
    static final String PASS = "Nosacz!@$";
    private NamedParameterJdbcTemplate jdbc;

    public DonationDAO() {
        try {
            DataSource dataSource = DBUtil.getDataSource(DB_URL, USER, PASS);
            this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<Donation> getAll() {
        String sql = "SELECT * FROM donations";
        return jdbc.query(sql, new donationRowMapper());
    }

    public Donation findByDonationId(int id){
        String sql = "SELECT * FROM donations WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        Donation donation = (Donation) jdbc.queryForObject(sql, namedParameters, new donationRowMapper());
        return donation;
    }

    public void deleteDonationById(int id){
        String sql = "DELETE FROM donations WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        jdbc.update(sql, namedParameters);
    }

    public void updateDonationById(int id, int donorId, float amount, String date, int stationId, int bloodGroupId){
        String sql = "UPDATE donations SET donor_id = :donorId, amount = :amount, date = :date, station_id = :stationId, blood_group_id = :bloodGroupId WHERE id = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("donorId", donorId);
        namedParameters.addValue("amount", amount);
        namedParameters.addValue("date", date);
        namedParameters.addValue("stationId", stationId);
        namedParameters.addValue("bloodGroupId", bloodGroupId);
        namedParameters.addValue("id", id);
        jdbc.update(sql, namedParameters);

    }

    public void create(Donation donation){
        String sql = "INSERT INTO donations(donor_id, station_id, amount, date, blood_group_id)" +
                                    "VALUES (:donor_id, :station_id, :amount, :date, :bloodGroupId)";
        Map namedParameters = new HashMap();
        namedParameters.put("donor_id", donation.getDonorId());
        namedParameters.put("station_id", donation.getStationId());
        namedParameters.put("amount", donation.getBloodLitres());
        namedParameters.put("date", donation.getDate());
        namedParameters.put("bloodGroupId", donation.getBloodGroupId());
        jdbc.update(sql, namedParameters);
        System.out.println("Created record with: " + donation.toString());
    }
}

class donationRowMapper implements RowMapper<Donation>{
    @Override
    public Donation mapRow(ResultSet resultSet, int i) throws SQLException {

        Donation donation = new Donation();
        donation.setId(resultSet.getInt("id"));
        donation.setDonorId(resultSet.getInt("donor_id"));
        donation.setDate(resultSet.getString("date"));
        donation.setBloodLitres(resultSet.getFloat("amount"));
        donation.setStationId(resultSet.getInt("station_id"));
        donation.setBloodGroupId(resultSet.getInt("blood_group_id"));
        return donation;
    }

}