package com.jeeweb.entity;

public class User {

    private String imie;
    private String nazwisko;
    private String email1;
    private String email2;
    private String firma;
    private String from;
    private String other;
    private String pozycja;

    public User(String imie, String nazwisko, String email1, String email2, String firma, String from, String other, String pozycja) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email1 = email1;
        this.email2 = email2;
        this.firma = firma;
        this.from = from;
        this.other = other;
        this.pozycja = pozycja;
    }
    
    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
    
    public String toString() {
        return "imie:" + imie + ",nazwisko:" + nazwisko + ",e-mail:" + email1 + ",firma:" + firma + ",from:" + from + ",other:" + other + ",pozycja:" + pozycja;

    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getPozycja() {
        return pozycja;
    }

    public void setPozycja(String pozycja) {
        this.pozycja = pozycja;
    }
}
