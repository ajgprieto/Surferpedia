package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import play.db.ebean.Model;

/**
 * @author scotthonda
 *
 */

@Entity
public class Updating extends Model {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  private long id;
  private String date;
  private String action;
  private String name;
  
  /**
   * there are many updates for one userInfo.
   * remember to encapsulate userInfo!!!
   */
  @ManyToOne
  private UserInfo userInfo;
  
  /**
   * Creates a new update.
   * @param date of update
   * @param action is type of action
   * @param name of surfer
   */
  public Updating(String date, String action, String name) {
    this.setDate(date);
    this.setAction(action);
    this.setName(name);
  }
  
  /**
   * finds a contact.
   * @return a contact
   */
  public static Finder<Long, Updating> find() {
    return new Finder<Long, Updating>(Long.class, Updating.class);
  }
  
  /**
   * @return the date
   */
  public String getDate() {
    return date;
  }
  /**
   * @param date the date to set
   */
  public void setDate(String date) {
    this.date = date;
  }
  /**
   * @return the action
   */
  public String getAction() {
    return action;
  }
  /**
   * @param action the action to set
   */
  public void setAction(String action) {
    this.action = action;
  }
  /**
   * @return the name
   */
  public String getName() {
    return name;
  }
  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the id
   */
  public long getId() {
    return id;
  }
  
  /**
   * @return the userInfo
   */
  public UserInfo getUserInfo() {
    return userInfo;
  }

  /**
   * @param userInfo the userInfo to set
   */
  public void setUserInfo(UserInfo userInfo) {
    this.userInfo = userInfo;
  }
}
