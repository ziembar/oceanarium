package bada_oceanarium.SpringApplication.DTOs;

public class ZwierzetaDTO {
    private Long idZwierzecia;
    private Float waga;
    private Long zapotrzebowanieKaloryczne;
    private String kolor;
    private String plec;
    private Long idAkwarium;
    private Long wiek;
    private Long idGatunku;

    private String nazwaPolska;
    private String nazwaLacinska;
    private String rodzaj;
    private String rodzina;
    private String rzad;

    public String getNazwaPolska() {
        return nazwaPolska;
    }

    public void setNazwaPolska(String nazwaPolska) {
        this.nazwaPolska = nazwaPolska;
    }

    public String getNazwaLacinska() {
        return nazwaLacinska;
    }

    public void setNazwaLacinska(String nazwaLacinska) {
        this.nazwaLacinska = nazwaLacinska;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public String getRodzina() {
        return rodzina;
    }

    public void setRodzina(String rodzina) {
        this.rodzina = rodzina;
    }

    public String getRzad() {
        return rzad;
    }

    public void setRzad(String rzad) {
        this.rzad = rzad;
    }
    public Long getIdZwierzecia() {
        return this.idZwierzecia;
    }

    public void setIdZwierzecia(Long idZwierzecia) {
        this.idZwierzecia = idZwierzecia;
    }

    public Float getWaga() {
        return this.waga;
    }

    public void setWaga(Float waga) {
        this.waga = waga;
    }

    public Long getZapotrzebowanieKaloryczne() {
        return this.zapotrzebowanieKaloryczne;
    }

    public void setZapotrzebowanieKaloryczne(Long zapotrzebowanieKaloryczne) {
        this.zapotrzebowanieKaloryczne = zapotrzebowanieKaloryczne;
    }

    public String getKolor() {
        return this.kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public String getPlec() {
        return this.plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public Long getIdAkwarium() {
        return this.idAkwarium;
    }

    public void setIdAkwarium(Long idAkwarium) {
        this.idAkwarium = idAkwarium;
    }

    public Long getWiek() {
        return this.wiek;
    }

    public void setWiek(Long wiek) {
        this.wiek = wiek;
    }

    public Long getIdGatunku() {
        return this.idGatunku;
    }

    public void setIdGatunku(Long idGatunku) {
        this.idGatunku = idGatunku;
    }
}
