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
  private static List<Update> updates = new ArrayList<>();

  /**
   * @return the all the updates
   */
  public static List<Update> getUpdates() {
    return updates;
  }

  /**
   * @param update the update to be added
   */
  public static void addUpdates(Update update) {
    updates.add(update);
  } 
}
