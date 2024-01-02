package bada_oceanarium.SpringApplication.DTOs;

public class AkwariaDTO {
    private Long idAkwarium;
    private Long pojemnosc;
    private Long zasolenie;
    private Long temperatura;
    private Long cisnienie;
    private Long idOceanarium;

    public Long getIdAkwarium() {
        return this.idAkwarium;
    }

    public void setIdAkwarium(Long idAkwarium) {
        this.idAkwarium = idAkwarium;
    }

    public Long getPojemnosc() {
        return this.pojemnosc;
    }

    public void setPojemnosc(Long pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public Long getZasolenie() {
        return this.zasolenie;
    }

    public void setZasolenie(Long zasolenie) {
        this.zasolenie = zasolenie;
    }

    public Long getTemperatura() {
        return this.temperatura;
    }

    public void setTemperatura(Long temperatura) {
        this.temperatura = temperatura;
    }

    public Long getCisnienie() {
        return this.cisnienie;
    }

    public void setCisnienie(Long cisnienie) {
        this.cisnienie = cisnienie;
    }

    public Long getIdOceanarium() {
        return this.idOceanarium;
    }

    public void setIdOceanarium(Long idOceanarium) {
        this.idOceanarium = idOceanarium;
    }
}
