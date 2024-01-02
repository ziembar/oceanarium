package bada_oceanarium.SpringApplication.DTOs;

public class BiletyDTO {
    private Long idBiletu;
    private String czySkasowany;
    private java.sql.Date dataZakupu;
    private java.sql.Date dataWaznosci;
    private Long idOceanarium;
    private Long idTypuBiletu;

    public Long getIdBiletu() {
        return this.idBiletu;
    }

    public void setIdBiletu(Long idBiletu) {
        this.idBiletu = idBiletu;
    }

    public String getCzySkasowany() {
        return this.czySkasowany;
    }

    public void setCzySkasowany(String czySkasowany) {
        this.czySkasowany = czySkasowany;
    }

    public java.sql.Date getDataZakupu() {
        return this.dataZakupu;
    }

    public void setDataZakupu(java.sql.Date dataZakupu) {
        this.dataZakupu = dataZakupu;
    }

    public java.sql.Date getDataWaznosci() {
        return this.dataWaznosci;
    }

    public void setDataWaznosci(java.sql.Date dataWaznosci) {
        this.dataWaznosci = dataWaznosci;
    }

    public Long getIdOceanarium() {
        return this.idOceanarium;
    }

    public void setIdOceanarium(Long idOceanarium) {
        this.idOceanarium = idOceanarium;
    }

    public Long getIdTypuBiletu() {
        return this.idTypuBiletu;
    }

    public void setIdTypuBiletu(Long idTypuBiletu) {
        this.idTypuBiletu = idTypuBiletu;
    }
}
