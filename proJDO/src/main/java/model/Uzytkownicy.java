package model;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Uzytkownicy {

  @PrimaryKey
  private long id;
  private String imie;
  private String nazwisko;
  private String email;
  private String haslo;
  private String kodAktywacyjny;
  private String usuniecie;

  public Uzytkownicy(String imie, String nazwisko, String email, String haslo, String kodAktywacyjny, String usuniecie) {
    this.imie = imie;
    this.nazwisko = nazwisko;
    this.email = email;
    this.haslo = haslo;
    this.kodAktywacyjny = kodAktywacyjny;
    this.usuniecie = usuniecie;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getHaslo() {
    return haslo;
  }

  public void setHaslo(String haslo) {
    this.haslo = haslo;
  }


  public String getKodAktywacyjny() {
    return kodAktywacyjny;
  }

  public void setKodAktywacyjny(String kodAktywacyjny) {
    this.kodAktywacyjny = kodAktywacyjny;
  }


  public String getUsuniecie() {
    return usuniecie;
  }

  public void setUsuniecie(String usuniecie) {
    this.usuniecie = usuniecie;
  }

}
