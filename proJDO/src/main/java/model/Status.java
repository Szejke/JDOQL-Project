package model;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Status {

  @PrimaryKey
  private long statusId;
  private String nazwaStatus;

  public Status(String nazwaStatus) {
    this.nazwaStatus = nazwaStatus;
  }

  public long getStatusId() {
    return statusId;
  }

  public void setStatusId(long statusId) {
    this.statusId = statusId;
  }


  public String getNazwaStatus() {
    return nazwaStatus;
  }

  public void setNazwaStatus(String nazwaStatus) {
    this.nazwaStatus = nazwaStatus;
  }

}
