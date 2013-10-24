package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * A class containing the different surfer types.
 * 
 * @author AJ
 *
 */
public class SurferTypes {

  private static String[] surferTypes = {"Male", "Female", "Grom"};

  /**
   * Creates a Map of the different surfer types that are available.
   * 
   * @return types the Map containing the surfer types.
   */
  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> types = new HashMap<>();
    for (int x = 0; x < surferTypes.length; x++) {
      types.put(surferTypes[x], false);
    }
    return types;
  }

  /**
   * Checks the Map to see if the given surfer type is in the Map.
   * 
   * @param surferType the surfer type to be checked.
   * @return true if it exists, false otherwise
   */
  public static boolean isType(String surferType) {
    return SurferTypes.getTypes().keySet().contains(surferType);
  }

  /**
   * Returns the Map with the given surferType set to true.
   * 
   * @param surferType the surfer type.
   * @return types, the Map with the given surferType set to true.
   */
  public static Map<String, Boolean> getTypes(String surferType) {
    Map<String, Boolean> types = SurferTypes.getTypes();
    if (isType(surferType)) {
      types.put(surferType, true);
    }
    return types;
  }
}
