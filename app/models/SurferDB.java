package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.SurferFormData;

/**
 * Creates a simple database of surfers.
 * 
 * @author AJ
 * 
 */
public class SurferDB {

  /** Map contain the surfers and their slugs. */
  public static Map<String, Surfer> surfers = new HashMap<>();
  public static List<String> slugs = new ArrayList<>();

  /**
   * Adds a surfer to the Map with the given data and theirs slug value.
   * 
   * @param data a SurferFormData containing all of the data.
   */
  public static void add(SurferFormData data) {
    Surfer surfer = null;
    if (!slugs.contains(data.slug)) {
      surfer =
          new Surfer(data.name, data.home, data.awards, data.carouselURL, data.bioURL, data.bio, data.slug, data.type);
      surfers.put(data.slug, surfer);
      slugs.add(data.slug);
    }
    else {
    surfer =
        new Surfer(data.name, data.home, data.awards, data.carouselURL, data.bioURL, data.bio, data.slug, data.type);
    surfers.put(data.slug, surfer);
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
   * 
   * @return an ArrayList containing all of the surfers.
   */
  public static List<Surfer> getSurferList() {
    return new ArrayList<>(surfers.values());
  }

  /**
   * Checks to see if the slug is contained in the Map.
   * 
   * @param slug the slug to be checked.
   * @return true if it contains the slug.
   */
  public static boolean checkSlug(String slug) {
    return slugs.contains(slug);
  }

  /**
   * Deletes the surfer from the Map.
   * 
   * @param slug the slug of the surfer to be deleted.
   */
  public static void deleteSurfer(String slug) {
    surfers.remove(slug);
    slugs.remove(slug);
  }

}
