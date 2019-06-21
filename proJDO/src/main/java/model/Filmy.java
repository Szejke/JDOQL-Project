package model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Filmy {

  @PrimaryKey
  private long filmyId;
  private String tytulFilmu;
  private String rok;
  private String obrazek;
  private String opis;
  private String usuniecie;
  private String rezyser;

  public Filmy(String tytulFilmu, String rok, String obrazek, String opis, String usuniecie, String rezyser) {
    this.tytulFilmu = tytulFilmu;
    this.rok = rok;
    this.obrazek = obrazek;
    this.opis = opis;
    this.usuniecie = usuniecie;
    this.rezyser = rezyser;
  }




  public long getFilmyId() {
    return filmyId;
  }

  public void setFilmyId(long filmyId) {
    this.filmyId = filmyId;
  }


  public String getTytulFilmu() {
    return tytulFilmu;
  }

  public void setTytulFilmu(String tytulFilmu) {
    this.tytulFilmu = tytulFilmu;
  }


  public String getRok() {
    return rok;
  }

  public void setRok(String rok) {
    this.rok = rok;
  }


  public String getObrazek() {
    return obrazek;
  }

  public void setObrazek(String obrazek) {
    this.obrazek = obrazek;
  }


  public String getOpis() {
    return opis;
  }

  public void setOpis(String opis) {
    this.opis = opis;
  }


  public String getUsuniecie() {
    return usuniecie;
  }

  public void setUsuniecie(String usuniecie) {
    this.usuniecie = usuniecie;
  }


  public String getRezyser() {
    return rezyser;
  }

  public void setRezyser(String rezyser) {
    this.rezyser = rezyser;
  }

}
