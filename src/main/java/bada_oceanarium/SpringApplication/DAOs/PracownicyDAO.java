
package bada_oceanarium.SpringApplication.DAOs;

import bada_oceanarium.SpringApplication.DTOs.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.security.SecureRandom;
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
        String sql = "SELECT * FROM PRACOWNICY ORDER BY ID_PRACOWNIKA";
        List<PracownicyDTO> ListaPracownikow = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(PracownicyDTO.class));
        return ListaPracownikow;
    }

    public String[] create(String imie, String nazwisko, String plec, String pesel, String nrTelefonu, String email, Date date, String prawoJazdy, Long idAdresu, String rola) {
        String sqlGetId =  "SELECT MAX(ID_PRACOWNIKA) AS NajwyzszeIDAdresu FROM PRACOWNICY";
        Long pracownikId = jdbcTemplate.queryForObject(sqlGetId, Long.class);
        pracownikId++;

        String username = this.createUsername(imie, nazwisko);
        String password = generatePassword();

        String passHash = new BCryptPasswordEncoder().encode(password);

        String sql = "INSERT INTO Pracownicy (Id_pracownika, Imie, Nazwisko, Plec, Pesel, Nr_telefonu, Email, Data_urodzenia, Prawo_jazdy,\n" +
                "Id_oceanarium, Id_adresu, username, role, password)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,pracownikId,imie, nazwisko, plec, pesel, nrTelefonu, email, date, prawoJazdy,1,idAdresu, username, rola, passHash);

        String[] IdUserPass = new String[3];
        IdUserPass[0] = pracownikId.toString();
        IdUserPass[1] = username;
        IdUserPass[2] = password;

        return IdUserPass;
    }

    private String createUsername(String imie, String nazwisko) {
        String potencialUsername = imie.substring(0, 1).concat(nazwisko).toLowerCase();
        String queryForUsernames = "SELECT username from PRACOWNICY where USERNAME like '".concat(potencialUsername.concat("%'"));

        List<String> usernames = jdbcTemplate.queryForList(queryForUsernames, String.class);

        if (usernames.isEmpty()) {
            return potencialUsername;
        }

        int maxNumber = 0;
        for (String s : usernames) {
            if (s.matches(".*[a-zA-Z]+\\d+")) {
                String liczby = s.replaceAll("[^0-9]", "");

                int currentNumber = Integer.parseInt(liczby);

                if (currentNumber > maxNumber) {
                    maxNumber = currentNumber;
                }
            }
        }
        if (maxNumber == 0) {
            return potencialUsername.concat("2");
        }
        return potencialUsername.concat(String.valueOf(maxNumber + 1));
    }

    public static String generatePassword() {
        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_-+=<>?";
        SecureRandom random = new SecureRandom();
        StringBuilder randomString = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            randomString.append(CHARACTERS.charAt(randomIndex));
        }

        return randomString.toString();
    }


}