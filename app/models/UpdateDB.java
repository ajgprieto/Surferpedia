/**
 * 
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author scotthonda
 *
 */
public class UpdateDB {

  /**
   * @return the all the updates
   */
  public static List<Updating> getUpdates() {
    List<Updating> updatings = new ArrayList<>();
    updatings = Updating.find().all();
    return updatings;
  }

  /**
   * @param updating the update to be added
   */
  public static void addUpdates(Updating updating) {
    updating.save();
  } 
}
