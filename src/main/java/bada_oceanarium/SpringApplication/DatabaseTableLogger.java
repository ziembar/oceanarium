package bada_oceanarium.SpringApplication;
import bada_oceanarium.SpringApplication.DTOs.AdresyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DatabaseTableLogger {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseTableLogger(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // This method can be called after the application has started

    public void logAdresyIds(){
        String sql = "SELECT * FROM ADRESY";
        List<AdresyDTO> ListAdresy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(AdresyDTO.class));
        System.out.println(ListAdresy);
        //return ListAdresy;
    }
}
