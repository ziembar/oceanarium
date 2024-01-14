package bada_oceanarium.SpringApplication.RowMappers;

import bada_oceanarium.SpringApplication.DTOs.AkwariaDTO;
import bada_oceanarium.SpringApplication.DTOs.KarmyDTO;
import bada_oceanarium.SpringApplication.DTOs.PracownicyDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import bada_oceanarium.SpringApplication.DTOs.ZadaniaPracowniczeDTO;
import java.util.List;

public class ZadaniaRowMapper implements RowMapper<ZadaniaPracowniczeDTO> {

    @Override
    public ZadaniaPracowniczeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        ZadaniaPracowniczeDTO zadaniaDTO = new ZadaniaPracowniczeDTO();

        zadaniaDTO.setIdZadania(rs.getLong("ID_ZADANIA"));
        zadaniaDTO.setCzestotliwosc(rs.getString("CZESTOTLIWOSC"));
        zadaniaDTO.setCzyWykonane(rs.getString("CZY_WYKONANE"));
        zadaniaDTO.setDataRozpoczecia(rs.getDate("DATA_ROZPOCZECIA"));
        zadaniaDTO.setDataZakonczenia(rs.getDate("DATA_ZAKONCZENIA"));
        zadaniaDTO.setRodzajZadania(rs.getString("RODZAJ_ZADANIA"));

        AkwariaDTO akwariaDTO = new AkwariaDTO();
        akwariaDTO.setIdAkwarium(rs.getLong("ID_AKWARIUM"));
        akwariaDTO.setPojemnosc(rs.getLong("POJEMNOSC"));
        akwariaDTO.setZasolenie(rs.getDouble("ZASOLENIE"));
        akwariaDTO.setTemperatura(rs.getDouble("TEMPERATURA"));
        akwariaDTO.setCisnienie(rs.getDouble("CISNIENIE"));
        akwariaDTO.setIdOceanarium(rs.getLong("ID_OCEANARIUM"));
        zadaniaDTO.setAkwarium(akwariaDTO);

        KarmyDTO karmyDTO = new KarmyDTO();
        karmyDTO.setIdProduktu(rs.getLong("ID_PRODUKTU"));
        karmyDTO.setNazwa(rs.getString("NAZWA"));
        karmyDTO.setDataWaznosci(rs.getDate("DATA_WAZNOSCI"));
        karmyDTO.setWaga(rs.getFloat("WAGA"));
        karmyDTO.setIdOceanarium(rs.getLong("ID_OCEANARIUM"));
        karmyDTO.setIdProducenta(rs.getLong("ID_PRODUCENTA"));
        zadaniaDTO.setKarma(karmyDTO);

        // Assuming there could be multiple PracownicyDTO objects, create a list
        List<PracownicyDTO> pracownicyList = new ArrayList<>();
        do {
            PracownicyDTO pracownicyDTO = new PracownicyDTO();
            pracownicyDTO.setIdPracownika(rs.getLong("ID_PRACOWNIKA"));
            pracownicyDTO.setImie(rs.getString("IMIE"));
            pracownicyDTO.setNazwisko(rs.getString("NAZWISKO"));
            pracownicyDTO.setPlec(rs.getString("PLEC"));
            pracownicyDTO.setPesel(rs.getString("PESEL"));
            pracownicyDTO.setNrTelefonu(rs.getString("NR_TELEFONU"));
            pracownicyDTO.setEmail(rs.getString("EMAIL"));
            pracownicyDTO.setDataUrodzenia(rs.getDate("DATA_URODZENIA"));
            pracownicyDTO.setPrawoJazdy(rs.getString("PRAWO_JAZDY"));
            pracownicyDTO.setIdOceanarium(rs.getLong("ID_OCEANARIUM"));

            pracownicyList.add(pracownicyDTO);
        } while (rs.next());
        zadaniaDTO.setPracownicy(pracownicyList);

        return zadaniaDTO;
    }
}
