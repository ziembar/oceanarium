package bada_oceanarium.SpringApplication.DTOs;

public class TypyBiletówDTO {
    private Long idTypuBiletu;
    private String nazwa;
    private Long cena;

    public Long getIdTypuBiletu() {
        return this.idTypuBiletu;
    }

    public void setIdTypuBiletu(Long idTypuBiletu) {
        this.idTypuBiletu = idTypuBiletu;
    }

    public String getNazwa() {
        return this.nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Long getCena() {
        return this.cena;
    }

    public void setCena(Long cena) {
        this.cena = cena;
    }
}
