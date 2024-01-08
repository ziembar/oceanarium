
package bada_oceanarium.SpringApplication.DAOs;

import bada_oceanarium.SpringApplication.DTOs.AdresyDTO;
import bada_oceanarium.SpringApplication.DTOs.AkwariaDTO;
import bada_oceanarium.SpringApplication.DTOs.ProducenciDTO;
import bada_oceanarium.SpringApplication.DTOs.ZwierzetaDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProducenciDAO {



    public ProducenciDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<ProducenciDTO> list() {
        String sql = "SELECT * FROM PRODUCENCI";
        List<ProducenciDTO> ListaProducentow = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(ProducenciDTO.class));
        return ListaProducentow;
    }
}
