
package bada_oceanarium.SpringApplication.DAOs;

import bada_oceanarium.SpringApplication.DTOs.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
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

    public void create(String imie, String nazwisko, String plec, String pesel, String nrTelefonu, String email, Date date, String prawoJazdy, Long idAdresu) {
        String sqlGetId =  "SELECT MAX(ID_PRACOWNIKA) AS NajwyzszeIDAdresu FROM PRACOWNICY";
        Long pracownikId = jdbcTemplate.queryForObject(sqlGetId, Long.class);
        pracownikId++;
        String sql = "INSERT INTO Pracownicy (Id_pracownika, Imie, Nazwisko, Plec, Pesel, Nr_telefonu, Email, Data_urodzenia, Prawo_jazdy,\n" +
                "Id_oceanarium, Id_adresu)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        System.out.println();
        jdbcTemplate.update(sql,pracownikId,imie, nazwisko, plec, pesel, nrTelefonu, email, date, prawoJazdy,1,idAdresu);
    }
}