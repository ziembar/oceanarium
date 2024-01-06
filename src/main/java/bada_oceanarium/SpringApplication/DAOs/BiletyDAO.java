package bada_oceanarium.SpringApplication.DAOs;

import bada_oceanarium.SpringApplication.DTOs.BiletyDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class BiletyDAO {


    public BiletyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<BiletyDTO> list() {
        String sql = "SELECT * FROM BILETY";
        List<BiletyDTO> ListBilety = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(BiletyDTO.class));;
        return ListBilety;
    }
    public void addTicket(long idBilet, java.sql.Date dataWaznosci, long idTypuBiletu) {
        String sql = "INSERT INTO Bilety (Id_biletu, Czy_skasowany, Data_zakupu, Data_waznosci, Id_oceanarium, Id_typu_biletu) " +
                "VALUES (?, 'N', CURRENT_DATE, ?, 1, ?)";

        jdbcTemplate.update(sql, idBilet, dataWaznosci, idTypuBiletu);
    }

}
