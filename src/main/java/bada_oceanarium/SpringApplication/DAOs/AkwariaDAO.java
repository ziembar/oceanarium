package bada_oceanarium.SpringApplication.DAOs;

import bada_oceanarium.SpringApplication.DTOs.AdresyDTO;
import bada_oceanarium.SpringApplication.DTOs.AkwariaDTO;
import bada_oceanarium.SpringApplication.DAOs.ZwierzetaDAO;
import bada_oceanarium.SpringApplication.DTOs.ZwierzetaDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ListIterator;

@Repository
public class AkwariaDAO {


    public AkwariaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<AkwariaDTO> list() {
        String sql = "SELECT a .ID_AKWARIUM, a.POJEMNOSC, a.ZASOLENIE, a.TEMPERATURA, a.CISNIENIE, a.ID_OCEANARIUM, COUNT(z.id_akwarium) AS ileRyb FROM akwaria a LEFT JOIN zwierzeta z ON a.ID_AKWARIUM = z.id_akwarium GROUP BY a.ID_AKWARIUM, a.POJEMNOSC, a.ZASOLENIE, a.TEMPERATURA, a.CISNIENIE, a.ID_OCEANARIUM";
        List<AkwariaDTO> ListAkwaria = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(AkwariaDTO.class));

        String sql2 = "SELECT * FROM ZWIERZETA JOIN GATUNKI ON ZWIERZETA.ID_GATUNKU = GATUNKI.ID_GATUNKU WHERE ID_AKWARIUM=";

        for (AkwariaDTO akwarium: ListAkwaria) {
            List<ZwierzetaDTO> ListZwierzeta = jdbcTemplate.query(sql2+akwarium.getIdAkwarium(), BeanPropertyRowMapper.newInstance(ZwierzetaDTO.class));
            akwarium.setZwierzeta(ListZwierzeta);
        }
        return ListAkwaria;
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
