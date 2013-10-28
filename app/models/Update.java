package models;

import java.text.DateFormat;

/**
 * @author scotthonda
 *
 */
public class Update {
  private String date;
  private String action;
  private String name;
  
  public Update(String date, String action, String name) {
    this.setDate(date);
    this.setAction(action);
    this.setName(name);
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
}
