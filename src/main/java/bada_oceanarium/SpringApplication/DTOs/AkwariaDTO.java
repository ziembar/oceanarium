package bada_oceanarium.SpringApplication.DTOs;

import java.util.List;

public class AkwariaDTO {
    private Long idAkwarium;
    private Long pojemnosc;
    private Double zasolenie;
    private Double temperatura;
    private Double cisnienie;
    private Long idOceanarium;
    private int ileRyb;

    public List<ZwierzetaDTO> getZwierzeta() {
        return zwierzeta;
    }

    public void setZwierzeta(List<ZwierzetaDTO> zwierzeta) {
        this.zwierzeta = zwierzeta;
    }

    private List<ZwierzetaDTO> zwierzeta;


    public int getIleRyb() {
        return this.ileRyb;
    }

    public void setIleRyb(int ileRyb) {
        this.ileRyb = ileRyb;
    }


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

    public Double getZasolenie() {
        return this.zasolenie;
    }

    public void setZasolenie(Double zasolenie) {
        this.zasolenie = zasolenie;
    }

    public Double getTemperatura() {
        return this.temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getCisnienie() {
        return this.cisnienie;
    }

    public void setCisnienie(Double cisnienie) {
        this.cisnienie = cisnienie;
    }

    public Long getIdOceanarium() {
        return this.idOceanarium;
    }

    public void setIdOceanarium(Long idOceanarium) {
        this.idOceanarium = idOceanarium;
    }
}
