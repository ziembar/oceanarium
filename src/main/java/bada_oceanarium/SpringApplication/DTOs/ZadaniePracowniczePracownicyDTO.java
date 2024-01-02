package bada_oceanarium.SpringApplication.DTOs;

public class ZadaniePracowniczePracownicyDTO {
    private Long idZadania;
    private Long idPracownika;
    private Long idProduktu;
    private Long idAkwarium;

    public Long getIdZadania() {
        return this.idZadania;
    }

    public void setIdZadania(Long idZadania) {
        this.idZadania = idZadania;
    }

    public Long getIdPracownika() {
        return this.idPracownika;
    }

    public void setIdPracownika(Long idPracownika) {
        this.idPracownika = idPracownika;
    }

    public Long getIdProduktu() {
        return this.idProduktu;
    }

    public void setIdProduktu(Long idProduktu) {
        this.idProduktu = idProduktu;
    }

    public Long getIdAkwarium() {
        return this.idAkwarium;
    }

    public void setIdAkwarium(Long idAkwarium) {
        this.idAkwarium = idAkwarium;
    }
}
