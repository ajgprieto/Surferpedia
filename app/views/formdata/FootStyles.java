package views.formdata;

import java.util.HashMap;
import java.util.Map;

public class FootStyles {

  /**An array containing the different types of foot styles.*/
  private static String [] footStyles = {"Regular", "Goofy"};

  /**
   * Creates a Map of the footstyles and sets each of them to false.
   * 
   * @return styles, the Map containing the different styles.
   */
  public static Map<String, Boolean> getStyles() {
    Map<String, Boolean> styles = new HashMap<>();
    for (int x = 0; x < footStyles.length; x++) {
      styles.put(footStyles[x], false);
    }
    return styles;
  }
  
  /**
   * Checks to see that the given foot style is a valid style.
   * 
   * @param style the footstyle
   * @return true if it exists, false otherwise
   */
  public static boolean isStyle(String style) {
    return FootStyles.getStyles().keySet().contains(style);
  }
  
  /**
   * Returns the Map with the given footstyle set to true.
   * 
   * @param style the type of footstyle
   * @return styles, the Map with the given footstyle set to true.
   */
  public static Map<String, Boolean> getStyles(String style) {
    Map<String, Boolean> styles = FootStyles.getStyles();
    if (isStyle(style)) {
      styles.put(style, true);
    }
    return styles;
  }
}
