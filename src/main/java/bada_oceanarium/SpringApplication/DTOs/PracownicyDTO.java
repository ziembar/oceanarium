package bada_oceanarium.SpringApplication.DTOs;

public class PracownicyDTO {
    private Long idPracownika;
    private String imie;
    private String nazwisko;
    private String plec;
    private String pesel;
    private String nrTelefonu;
    private String email;
    private java.sql.Date dataUrodzenia;
    private String prawoJazdy;
    private Long idOceanarium;
    private Long idAdresu;
    private AdresyDTO adres;
    public AdresyDTO getAdres(){
        return this.adres;
    }
    public void setAdres(AdresyDTO x ){
        this.adres = x;
    }

    public Long getIdPracownika() {
        return this.idPracownika;
    }

    public void setIdPracownika(Long idPracownika) {
        this.idPracownika = idPracownika;
    }

    public String getImie() {
        return this.imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return this.nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPlec() {
        return this.plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getPesel() {
        return this.pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getNrTelefonu() {
        return this.nrTelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public java.sql.Date getDataUrodzenia() {
        return this.dataUrodzenia;
    }

    public void setDataUrodzenia(java.sql.Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getPrawoJazdy() {
        return this.prawoJazdy;
    }

    public void setPrawoJazdy(String prawoJazdy) {
        this.prawoJazdy = prawoJazdy;
    }

    public Long getIdOceanarium() {
        return this.idOceanarium;
    }

    public void setIdOceanarium(Long idOceanarium) {
        this.idOceanarium = idOceanarium;
    }

    public Long getIdAdresu() {
        return this.idAdresu;
    }

    public void setIdAdresu(Long idAdresu) {
        this.idAdresu = idAdresu;
    }
}
