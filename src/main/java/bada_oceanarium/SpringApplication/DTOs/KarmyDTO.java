package bada_oceanarium.SpringApplication.DTOs;

public class KarmyDTO {
    public Long id_produktu;
    private String nazwa;
    private java.sql.Date dataWaznosci;
    private Float waga;
    private Long idOceanarium;
    private Long idProducenta;
    public int quantity;
    public String nazwaProducenta;

    public Long getIdProduktu() {
        return this.id_produktu;
    }

    public Long getId_produktu() {
        return id_produktu;
    }

    public void setId_produktu(Long id_produktu) {
        this.id_produktu = id_produktu;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getnazwaProducenta() {
        return nazwaProducenta;
    }

    public void setnazwaProducenta(String nazwaProducenta) {
        this.nazwaProducenta = nazwaProducenta;
    }

    public void setIdProduktu(Long id_produktu) {
        this.id_produktu = id_produktu;
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

    @Override
    public String toString() {
        return nazwa;
    }
}
