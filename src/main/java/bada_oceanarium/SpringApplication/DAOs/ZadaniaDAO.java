package bada_oceanarium.SpringApplication.DAOs;

import bada_oceanarium.SpringApplication.DTOs.BiletyDTO;
import bada_oceanarium.SpringApplication.DTOs.ZadaniaPracowniczeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ZadaniaDAO {


    public ZadaniaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<ZadaniaPracowniczeDTO> list() {
        String sql = "SELECT ZP.*, K.*, P.*, A.* FROM ZADANIA_PRACOWNICZE ZP LEFT OUTER JOIN ZADANIE_PRACOWNICZE_PRACOWNICY ZPP on ZP.ID_ZADANIA = ZPP.ID_ZADANIA LEFT JOIN KARMY K on K.ID_PRODUKTU = ZPP.ID_PRODUKTU LEFT JOIN PRACOWNICY P on ZPP.ID_PRACOWNIKA = P.ID_PRACOWNIKA LEFT JOIN AKWARIA A on ZPP.ID_AKWARIUM = A.ID_AKWARIUM";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(ZadaniaPracowniczeDTO.class));
    }
    public Long createNew(String czestotliwosc, String czyWykon, java.sql.Date dataRozp, java.sql.Date dataZakon,String rodzaj){
        String sqlGetId =  "SELECT MAX(ID_ZADANIA) AS NajwyzszeIDAdresu FROM ZADANIA_PRACOWNICZE";
        Long zadanieId = jdbcTemplate.queryForObject(sqlGetId, Long.class);
        zadanieId++;

        String sql = "INSERT INTO Zadania_pracownicze (Id_zadania, Czestotliwosc, Czy_wykonane, Data_rozpoczecia, Data_zakonczenia, Rodzaj_zadania)\n" +
                "VALUES (?, ?, ?, ?,?,?)";
        jdbcTemplate.update(sql, zadanieId, czestotliwosc, czyWykon,dataRozp,dataZakon,rodzaj);

        return zadanieId;
    }

    public void createNewZPP(Long idZadania,Long idPracownika,Long idProduktu){
        //Totalnie spierdolona jest ta tablica xD
        System.out.println(idProduktu);
        String sql = "INSERT INTO Zadanie_pracownicze_Pracownicy (Id_zadania, Id_pracownika, Id_Produktu, Id_akwarium)\n" +
                "VALUES (?, ?, ?, 1)";

        jdbcTemplate.update(sql, idZadania, idPracownika, idProduktu);
    }

}