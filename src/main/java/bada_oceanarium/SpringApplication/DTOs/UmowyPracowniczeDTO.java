package bada_oceanarium.SpringApplication.DTOs;

public class UmowyPracowniczeDTO {
    private Long idUmowy;
    private java.sql.Date dataRozpoczecia;
    private java.sql.Date dataZakonczenia;
    private Long wynagrodzenie;
    private String rachunek;
    private Long idPracownika;
    private Long idStanowiska;
    private Long wymiarGodzin;
    private String typUmowy;

    public Long getIdUmowy() {
        return this.idUmowy;
    }

    public void setIdUmowy(Long idUmowy) {
        this.idUmowy = idUmowy;
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

    public Long getWynagrodzenie() {
        return this.wynagrodzenie;
    }

    public void setWynagrodzenie(Long wynagrodzenie) {
        this.wynagrodzenie = wynagrodzenie;
    }

    public String getRachunek() {
        return this.rachunek;
    }

    public void setRachunek(String rachunek) {
        this.rachunek = rachunek;
    }

    public Long getIdPracownika() {
        return this.idPracownika;
    }

    public void setIdPracownika(Long idPracownika) {
        this.idPracownika = idPracownika;
    }

    public Long getIdStanowiska() {
        return this.idStanowiska;
    }

    public void setIdStanowiska(Long idStanowiska) {
        this.idStanowiska = idStanowiska;
    }

    public Long getWymiarGodzin() {
        return this.wymiarGodzin;
    }

    public void setWymiarGodzin(Long wymiarGodzin) {
        this.wymiarGodzin = wymiarGodzin;
    }

    public String getTypUmowy() {
        return this.typUmowy;
    }

    public void setTypUmowy(String typUmowy) {
        this.typUmowy = typUmowy;
    }
}
