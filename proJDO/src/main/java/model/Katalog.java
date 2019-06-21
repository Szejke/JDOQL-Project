package model;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.sql.Date;

@PersistenceCapable
public class Katalog {

  @PrimaryKey
  private long katalogId;
  private long idFilm;
  private long idKategoria;
  private long idStatus;
  private long idUzytkownicy;

  public Katalog(long idFilm, long idKategoria, long idStatus, long idUzytkownicy, Date dataZwrotu) {
    this.idFilm = idFilm;
    this.idKategoria = idKategoria;
    this.idStatus = idStatus;
    this.idUzytkownicy = idUzytkownicy;
    this.dataZwrotu = dataZwrotu;
  }

  private java.sql.Date dataZwrotu;


  public long getKatalogId() {
    return katalogId;
  }

  public void setKatalogId(long katalogId) {
    this.katalogId = katalogId;
  }


  public long getIdFilm() {
    return idFilm;
  }

  public void setIdFilm(long idFilm) {
    this.idFilm = idFilm;
  }


  public long getIdKategoria() {
    return idKategoria;
  }

  public void setIdKategoria(long idKategoria) {
    this.idKategoria = idKategoria;
  }


  public long getIdStatus() {
    return idStatus;
  }

  public void setIdStatus(long idStatus) {
    this.idStatus = idStatus;
  }


  public long getIdUzytkownicy() {
    return idUzytkownicy;
  }

  public void setIdUzytkownicy(long idUzytkownicy) {
    this.idUzytkownicy = idUzytkownicy;
  }


  public java.sql.Date getDataZwrotu() {
    return dataZwrotu;
  }

  public void setDataZwrotu(java.sql.Date dataZwrotu) {
    this.dataZwrotu = dataZwrotu;
  }

}
