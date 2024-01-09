
package bada_oceanarium.SpringApplication.DAOs;

import bada_oceanarium.SpringApplication.DTOs.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PracownicyDAO {



    public PracownicyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<PracownicyDTO> list() {
        String sql = "SELECT * FROM PRACOWNICY";
        List<PracownicyDTO> ListaPracownikow = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(PracownicyDTO.class));
        return ListaPracownikow;
    }
}