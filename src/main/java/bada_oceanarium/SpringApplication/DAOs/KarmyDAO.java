package bada_oceanarium.SpringApplication.DAOs;

import bada_oceanarium.SpringApplication.DTOs.BiletyDTO;
import bada_oceanarium.SpringApplication.DTOs.KarmyDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class KarmyDAO {


    public KarmyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<KarmyDTO> list() {
        String sql = "SELECT * FROM KARMY";
        List<KarmyDTO> ListKarmy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(KarmyDTO.class));
        return ListKarmy;
    }

    public void update_add(int value,Long id){
        String sql = "UPDATE KARMY SET WAGA = WAGA + ? WHERE ID_PRODUKTU = ?";
        jdbcTemplate.update(sql, value, id);
    }

    public void update_use(int value,Long id){
        String sql = "UPDATE KARMY SET WAGA = WAGA - ? WHERE ID_PRODUKTU = ?";
        jdbcTemplate.update(sql, value, id);
    }
    public void create(String nazwa,java.sql.Date dataWaznosc,Float waga,Long idProducenta){
        String sqlgetID =  "SELECT MAX(ID_PRODUKTU) AS NajwyzszeIDProduktu FROM KARMY";
        Long maxId = jdbcTemplate.queryForObject(sqlgetID, Long.class);
        String sql = "INSERT INTO Karmy (ID_PRODUKTU, Nazwa, Data_waznosci, Waga, Id_oceanarium, Id_producenta)"+
        "VALUES (?, ?, ? ,?, 1, ?)";
        maxId = maxId +1;
        jdbcTemplate.update(sql, maxId,nazwa,dataWaznosc,waga, idProducenta);
    }

    //TO_DATE('2024-01-01', 'YYYY-MM-DD'),

}
