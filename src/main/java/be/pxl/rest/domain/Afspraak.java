package be.pxl.rest.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;


@Entity
@Table(name = "Afspraaken")
public class Afspraak implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Naam")
    private String naam;

    @Column(name = "Familienaam")
    private String familienaam;

    @Column(name = "Telefoonnummer")
    private Double telefoonnummer;

    @Column(name = "Datum")
    private Date datum;

    @Column(name = "Doktor")
    private String doktor;

    @Column(name = "Status")
    private int status;


    public Afspraak() {

    }


    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public void setFamilienaam(String familienaam) {
        this.familienaam = familienaam;
    }

    public Double getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(Double telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getDoktor() {
        return doktor;
    }

    public void setDoktor(String doktor) {
        this.doktor = doktor;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Afspraak{" +
                "naam='" + naam + '\'' +
                ", familienaam='" + familienaam + '\'' +
                ", telefoonnummer=" + telefoonnummer +
                ", datum=" + datum +
                ", doktor='" + doktor + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, naam, familienaam, telefoonnummer, datum, datum, status);
    }

}
