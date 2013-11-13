/**
 * 
 */
package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * @author scotthonda
 *
 */
public class SurferTypes {
  private static String [] types = {"Male", "Female", "Grom"};
  
  /**
   * returns a initialized SurferType map with all values as false.
   * @return typeMap
   */
  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> typeMap = new HashMap<>();
    for (String type : types) {
      typeMap.put(type, false);
    }
    return typeMap;
  }
  
  /**
   * when a getTypes is passed a string it will set the associated type with a true value.
   * @param surferType type of surfer
   * @return typeMap
   */
  public static Map<String, Boolean> getTypes(String surferType) {
    Map<String, Boolean> typeMap = SurferTypes.getTypes();
    if (isType(surferType)) {
      typeMap.put(surferType, true);
    }
    return typeMap;
  }
  
  /**
   * Returns true if surferType is a valid telephone type.
   * @param surferType type of telephone
   * @return true if a valid surfer type, false if invalid surfer type
   */
  public static boolean isType(String surferType) {
    return SurferTypes.getTypes().keySet().contains(surferType);
  }
}
