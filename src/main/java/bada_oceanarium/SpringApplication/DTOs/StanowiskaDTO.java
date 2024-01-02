package bada_oceanarium.SpringApplication.DTOs;

public class StanowiskaDTO {
    private Long idStanowiska;
    private String nazwa;
    private Long przewidywaneWynagrodzenie;

    public Long getIdStanowiska() {
        return this.idStanowiska;
    }

    public void setIdStanowiska(Long idStanowiska) {
        this.idStanowiska = idStanowiska;
    }

    public String getNazwa() {
        return this.nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Long getPrzewidywaneWynagrodzenie() {
        return this.przewidywaneWynagrodzenie;
    }

    public void setPrzewidywaneWynagrodzenie(Long przewidywaneWynagrodzenie) {
        this.przewidywaneWynagrodzenie = przewidywaneWynagrodzenie;
    }
}
