package model;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class UprawnieniaUz {

  @PrimaryKey
  private long uprawnieniaUzId;
  private long roleId;
  private long uzytkownikId;

  public UprawnieniaUz(long roleId, long uzytkownikId) {
    this.roleId = roleId;
    this.uzytkownikId = uzytkownikId;
  }

  public long getUprawnieniaUzId() {
    return uprawnieniaUzId;
  }

  public void setUprawnieniaUzId(long uprawnieniaUzId) {
    this.uprawnieniaUzId = uprawnieniaUzId;
  }


  public long getRoleId() {
    return roleId;
  }

  public void setRoleId(long roleId) {
    this.roleId = roleId;
  }


  public long getUzytkownikId() {
    return uzytkownikId;
  }

  public void setUzytkownikId(long uzytkownikId) {
    this.uzytkownikId = uzytkownikId;
  }

}
