package bada_oceanarium.SpringApplication.DTOs;

public class OceanariaDTO {
    private Long idOceanarium;
    private String nazwa;
    private String nrTelefonu;
    private Long idAdresu;

    public Long getIdOceanarium() {
        return this.idOceanarium;
    }

    public void setIdOceanarium(Long idOceanarium) {
        this.idOceanarium = idOceanarium;
    }

    public String getNazwa() {
        return this.nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNrTelefonu() {
        return this.nrTelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    public Long getIdAdresu() {
        return this.idAdresu;
    }

    public void setIdAdresu(Long idAdresu) {
        this.idAdresu = idAdresu;
    }
}
