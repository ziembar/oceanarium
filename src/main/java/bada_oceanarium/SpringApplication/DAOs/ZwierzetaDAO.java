
package bada_oceanarium.SpringApplication.DAOs;

        import bada_oceanarium.SpringApplication.DTOs.AdresyDTO;
        import bada_oceanarium.SpringApplication.DTOs.AkwariaDTO;
        import bada_oceanarium.SpringApplication.DTOs.ZwierzetaDTO;
        import org.springframework.beans.factory.annotation.Autowired;

        import org.springframework.jdbc.core.BeanPropertyRowMapper;
        import org.springframework.jdbc.core.JdbcTemplate;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
public class ZwierzetaDAO {



    public ZwierzetaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<ZwierzetaDTO> list() {
        String sql = "SELECT a .ID_AKWARIUM, a.POJEMNOSC, a.ZASOLENIE, a.TEMPERATURA, a.CISNIENIE, a.ID_OCEANARIUM, COUNT(z.id_akwarium) AS ileRyb FROM akwaria a LEFT JOIN zwierzeta z ON a.ID_AKWARIUM = z.id_akwarium GROUP BY a.ID_AKWARIUM, a.POJEMNOSC, a.ZASOLENIE, a.TEMPERATURA, a.CISNIENIE, a.ID_OCEANARIUM";
        List<ZwierzetaDTO> ListZwierzeta = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(ZwierzetaDTO.class));
        return ListZwierzeta;
    }

    public List<ZwierzetaDTO> getInAquarium(int aquariumId){
        String sql = "SELECT * FROM ZWIERZETA WHERE ID_AKWARIUM="+aquariumId;
        List<ZwierzetaDTO> ListZwierzeta = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(ZwierzetaDTO.class));
        return ListZwierzeta;
    }

    public void save(AdresyDTO sale) {
    }

    public ZwierzetaDTO get(int id) {
        return null;
    }



    public void update(ZwierzetaDTO sale) {
    }

    public void delete(int id) {
    }
}
