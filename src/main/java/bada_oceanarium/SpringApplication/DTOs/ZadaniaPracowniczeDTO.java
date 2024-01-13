package bada_oceanarium.SpringApplication.DTOs;

import java.util.List;

public class ZadaniaPracowniczeDTO {
    private Long idZadania;
    private String czestotliwosc;
    private String czyWykonane;
    private java.sql.Date dataRozpoczecia;
    private java.sql.Date dataZakonczenia;
    private String rodzajZadania;
    public List<PracownicyDTO> pracownicy;

    public AkwariaDTO akwarium;
    public KarmyDTO karma;

    public List<PracownicyDTO> getPracownicy() {
        return pracownicy;
    }

    public void setPracownicy(List<PracownicyDTO> pracownicy) {
        this.pracownicy = pracownicy;
    }

    public AkwariaDTO getAkwarium() {
        return akwarium;
    }

    public void setAkwarium(AkwariaDTO akwarium) {
        this.akwarium = akwarium;
    }

    public KarmyDTO getKarma() {
        return karma;
    }

    public void setKarma(KarmyDTO karma) {
        this.karma = karma;
    }

    public Long getIdZadania() {
        return this.idZadania;
    }

    public void setIdZadania(Long idZadania) {
        this.idZadania = idZadania;
    }

    public String getCzestotliwosc() {
        return this.czestotliwosc;
    }

    public void setCzestotliwosc(String czestotliwosc) {
        this.czestotliwosc = czestotliwosc;
    }

    public String getCzyWykonane() {
        return this.czyWykonane;
    }

    public void setCzyWykonane(String czyWykonane) {
        this.czyWykonane = czyWykonane;
    }

    public java.sql.Date getDataRozpoczecia() {
        return this.dataRozpoczecia;
    }

    public void setDataRozpoczecia(java.sql.Date dataRozpoczecia) {
        this.dataRozpoczecia = dataRozpoczecia;
    }

    public java.sql.Date getDataZakonczenia() {
        return this.dataZakonczenia;
    }

    public void setDataZakonczenia(java.sql.Date dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public String getRodzajZadania() {
        return this.rodzajZadania;
    }

    public void setRodzajZadania(String rodzajZadania) {
        this.rodzajZadania = rodzajZadania;
    }
}
