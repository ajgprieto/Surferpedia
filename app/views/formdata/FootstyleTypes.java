/**
 * 
 */
package views.formdata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author scotthonda
 *
 */
public class FootstyleTypes {
    private static String [] types = {"Regular", "Goofy"};
    
    public static List<String> getStyle() {
      return Arrays.asList(types);
    }
    
    /**
     * when a getTypes is passed a string it will set the associated type with a true value.
     * @param surferType type of surfer
     * @return typeMap
     */
    public static List<String> getStyle(String surferType) {
      
      return Arrays.asList(types);
    }
    
}
