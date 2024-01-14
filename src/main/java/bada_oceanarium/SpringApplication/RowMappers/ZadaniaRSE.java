package bada_oceanarium.SpringApplication.RowMappers;

import bada_oceanarium.SpringApplication.DTOs.AkwariaDTO;
import bada_oceanarium.SpringApplication.DTOs.KarmyDTO;
import bada_oceanarium.SpringApplication.DTOs.PracownicyDTO;
import bada_oceanarium.SpringApplication.DTOs.ZadaniaPracowniczeDTO;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZadaniaRSE<U, T> implements ResultSetExtractor<Map<U, List<T>>> {

    @Override
    public Map<U, List<T>> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<U, List<T>> resultMap = new HashMap<>();

        while (rs.next()) {
            long key = rs.getLong("ID_ZADANIA");
            if (!resultMap.containsKey(key)){
                ZadaniaPracowniczeDTO value = mapRow(rs);
                ArrayList al = new ArrayList<T>();
                al.add((T)value);
                resultMap.put((U) value.getIdZadania(), al);
            }
            else {
                ZadaniaPracowniczeDTO zadanie = (ZadaniaPracowniczeDTO) resultMap.get(key).get(0);

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
                zadanie.pracownicy.add(pracownicyDTO);
            }

            // Add the value to the list associated with the key
        }

        return resultMap;
    }

    protected ZadaniaPracowniczeDTO mapRow(ResultSet rs) throws SQLException {
        ZadaniaPracowniczeDTO zadaniaDTO =  new ZadaniaPracowniczeDTO();

        zadaniaDTO.setIdZadania(rs.getLong("ID_ZADANIA"));
        zadaniaDTO.setCzestotliwosc(rs.getString("CZESTOTLIWOSC"));
        zadaniaDTO.setCzyWykonane(rs.getString("CZY_WYKONANE"));
        zadaniaDTO.setDataRozpoczecia(rs.getDate("DATA_ROZPOCZECIA"));
        zadaniaDTO.setDataZakonczenia(rs.getDate("DATA_ZAKONCZENIA"));
        zadaniaDTO.setRodzajZadania(rs.getString("RODZAJ_ZADANIA"));

        if (rs.getLong("ID_AKWARIUM") != 0) {
            AkwariaDTO akwariaDTO = new AkwariaDTO();
            akwariaDTO.setIdAkwarium(rs.getLong("ID_AKWARIUM"));
            akwariaDTO.setPojemnosc(rs.getLong("POJEMNOSC"));
            akwariaDTO.setZasolenie(rs.getDouble("ZASOLENIE"));
            akwariaDTO.setTemperatura(rs.getDouble("TEMPERATURA"));
            akwariaDTO.setCisnienie(rs.getDouble("CISNIENIE"));
            akwariaDTO.setIdOceanarium(rs.getLong("ID_OCEANARIUM"));
            zadaniaDTO.setAkwarium(akwariaDTO);
        }

        if (rs.getLong("ID_PRODUKTU") != 0) {
            KarmyDTO karmyDTO = new KarmyDTO();
            karmyDTO.setIdProduktu(rs.getLong("ID_PRODUKTU"));
            karmyDTO.setNazwa(rs.getString("NAZWA"));
            karmyDTO.setDataWaznosci(rs.getDate("DATA_WAZNOSCI"));
            karmyDTO.setWaga(rs.getFloat("WAGA"));
            karmyDTO.setIdOceanarium(rs.getLong("ID_OCEANARIUM"));
            karmyDTO.setIdProducenta(rs.getLong("ID_PRODUCENTA"));
            zadaniaDTO.setKarma(karmyDTO);
        }

            if (rs.getLong("ID_PRACOWNIKA") != 0) {
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
                zadaniaDTO.addPracownik(pracownicyDTO);
            }


        return zadaniaDTO;
    }
}
