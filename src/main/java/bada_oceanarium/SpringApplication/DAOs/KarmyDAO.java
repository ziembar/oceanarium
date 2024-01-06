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

}
