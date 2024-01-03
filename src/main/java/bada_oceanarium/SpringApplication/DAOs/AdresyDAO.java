package bada_oceanarium.SpringApplication.DAOs;

import bada_oceanarium.SpringApplication.DTOs.AdresyDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdresyDAO {


    public AdresyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<AdresyDTO> list(){
        String sql = "SELECT * FROM ADRESY";
        List<AdresyDTO> ListAdresy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(AdresyDTO.class));;
        return ListAdresy;
    }

    public void save(AdresyDTO sale) {
    }

    public AdresyDTO get(int id) {
        return null;
    }



    public void update(AdresyDTO sale) {
    }

    public void delete(int id) {
    }
}
