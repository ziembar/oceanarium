package bada_oceanarium.SpringApplication.DTOs;

public class CertyfikatyDTO {
    private Long idCertyfikatu;
    private String kodCertyfikatu;
    private String nazwa;
    private String nazwaPodmiotuWydajacego;
    private java.sql.Date dataWydania;

    public Long getIdCertyfikatu() {
        return this.idCertyfikatu;
    }

    public void setIdCertyfikatu(Long idCertyfikatu) {
        this.idCertyfikatu = idCertyfikatu;
    }

    public String getKodCertyfikatu() {
        return this.kodCertyfikatu;
    }

    public void setKodCertyfikatu(String kodCertyfikatu) {
        this.kodCertyfikatu = kodCertyfikatu;
    }

    public String getNazwa() {
        return this.nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwaPodmiotuWydajacego() {
        return this.nazwaPodmiotuWydajacego;
    }

    public void setNazwaPodmiotuWydajacego(String nazwaPodmiotuWydajacego) {
        this.nazwaPodmiotuWydajacego = nazwaPodmiotuWydajacego;
    }

    public java.sql.Date getDataWydania() {
        return this.dataWydania;
    }

    public void setDataWydania(java.sql.Date dataWydania) {
        this.dataWydania = dataWydania;
    }
}
