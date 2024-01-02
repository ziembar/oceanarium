package bada_oceanarium.SpringApplication.DTOs;

public class GatunkiDTO {
    private Long idGatunku;
    private String nazwaPolska;
    private String nazwaLacinska;
    private String rodzaj;
    private String rodzina;
    private String rząd;

    public Long getIdGatunku() {
        return this.idGatunku;
    }

    public void setIdGatunku(Long idGatunku) {
        this.idGatunku = idGatunku;
    }

    public String getNazwaPolska() {
        return this.nazwaPolska;
    }

    public void setNazwaPolska(String nazwaPolska) {
        this.nazwaPolska = nazwaPolska;
    }

    public String getNazwaLacinska() {
        return this.nazwaLacinska;
    }

    public void setNazwaLacinska(String nazwaLacinska) {
        this.nazwaLacinska = nazwaLacinska;
    }

    public String getRodzaj() {
        return this.rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public String getRodzina() {
        return this.rodzina;
    }

    public void setRodzina(String rodzina) {
        this.rodzina = rodzina;
    }

    public String getRząd() {
        return this.rząd;
    }

    public void setRząd(String rząd) {
        this.rząd = rząd;
    }
}
