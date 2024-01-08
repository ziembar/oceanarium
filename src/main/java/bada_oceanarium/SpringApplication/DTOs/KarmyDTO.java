package bada_oceanarium.SpringApplication.DTOs;

public class KarmyDTO {
    private Long idProduktu;
    private String nazwa;
    private java.sql.Date dataWaznosci;
    private Float waga;
    private Long idOceanarium;
    private Long idProducenta;
    public int quantity;

    public Long getIdProduktu() {
        return this.idProduktu;
    }

    public void setIdProduktu(Long idProduktu) {
        this.idProduktu = idProduktu;
    }

    public String getNazwa() {
        return this.nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public java.sql.Date getDataWaznosci() {
        return this.dataWaznosci;
    }

    public void setDataWaznosci(java.sql.Date dataWaznosci) {
        this.dataWaznosci = dataWaznosci;
    }

    public Float getWaga() {
        return this.waga;
    }

    public void setWaga(Float waga) {
        this.waga = waga;
    }

    public Long getIdOceanarium() {
        return this.idOceanarium;
    }

    public void setIdOceanarium(Long idOceanarium) {
        this.idOceanarium = idOceanarium;
    }

    public Long getIdProducenta() {
        return this.idProducenta;
    }

    public void setIdProducenta(Long idProducenta) {
        this.idProducenta = idProducenta;
    }
}
