package model;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Kategorie {

  @PrimaryKey

  private long kategorieId;
  private String nazwaKategorii;

  public Kategorie(String nazwaKategorii) {
    this.nazwaKategorii = nazwaKategorii;
  }

  public long getKategorieId() {
    return kategorieId;
  }

  public void setKategorieId(long kategorieId) {
    this.kategorieId = kategorieId;
  }


  public String getNazwaKategorii() {
    return nazwaKategorii;
  }

  public void setNazwaKategorii(String nazwaKategorii) {
    this.nazwaKategorii = nazwaKategorii;
  }

}
