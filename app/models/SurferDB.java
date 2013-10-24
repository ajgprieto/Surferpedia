package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.SurferFormData;

/**
 * Creates a simple database of surfers.
 * @author AJ
 *
 */
public class SurferDB {

  /**Map contain the surfers and their slugs.*/
  public static Map<String, Surfer> surfers = new HashMap<>();
  /**Map containing the male surfers.*/
  public static Map<String, Surfer> maleSurfers = new HashMap<>();
  /**Map containing the female surfers.*/
  public static Map<String, Surfer> femaleSurfers = new HashMap<>();
  /**Map containing the groms.*/
  public static Map<String, Surfer> gromSurfers = new HashMap<>();

  /**
   * Adds a surfer to the Map with the given data and theirs slug value.
   * 
   * @param data a SurferFormData containing all of the data.
   */
  public static void add(SurferFormData data) {
    Surfer surfer =
        new Surfer(data.name, data.home, data.awards, data.carouselURL, data.bioURL, data.bio, data.slug, data.type);
    
    surfers.put(data.slug, surfer);
    
    if (data.type.equalsIgnoreCase("male")) {
      maleSurfers.put(data.slug, surfer);
    }
    else if (data.type.equalsIgnoreCase("female")) {
      femaleSurfers.put(data.slug, surfer);
    }
    else {
      gromSurfers.put(data.slug, surfer);
    }
  }
  
  /**
   * Returns the surfer who belongs to the slug.
   * 
   * @param slug the slug that belongs to a surfer.
   * @return the surfer who belongs to the slug.
   */
  public static Surfer getSurfer(String slug) {
    Surfer surfer = surfers.get(slug);
    if (surfer == null) {
      throw new RuntimeException("Invalid Surfer slug.");
    }
    return surfer;
  }
  
  /**
   * Returns a ArrayList containing all of the surfers.
   * @return an ArrayList containing all of the surfers.
   */
  public static List<Surfer> getSurfers() {
    return new ArrayList<>(surfers.values());
  }

  /**
   * Returns a List of the surfers corresponding to the given type.
   * 
   * @param type the type of surfer
   * @return the list containing the surfers
   */
  public static List<Surfer> getSurfers(String type) {
    if (type.equalsIgnoreCase("male")) {
      return new ArrayList<>(maleSurfers.values());
    }
    else if (type.equalsIgnoreCase("female")) {
      return new ArrayList<>(femaleSurfers.values());
    }
    else {
      return new ArrayList<>(gromSurfers.values());
    }
  }
  
}
