package bada_oceanarium.SpringApplication.DTOs;

public class ProducenciDTO {
    private Long idProducenta;
    private String nazwaProducenta;
    private String nip;
    private String regon;
    private String email;
    private Long idAdresu;

    public Long getIdProducenta() {
        return this.idProducenta;
    }

    public void setIdProducenta(Long idProducenta) {
        this.idProducenta = idProducenta;
    }

    public String getNazwaProducenta() {
        return this.nazwaProducenta;
    }

    public void setNazwaProducenta(String nazwaProducenta) {
        this.nazwaProducenta = nazwaProducenta;
    }

    public String getNip() {
        return this.nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getRegon() {
        return this.regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getIdAdresu() {
        return this.idAdresu;
    }

    public void setIdAdresu(Long idAdresu) {
        this.idAdresu = idAdresu;
    }
}
