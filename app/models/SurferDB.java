package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.SurferFormData;

/**
 * Provides a simple in-memory repo for Surfer data.
 * @author scotthonda
 */
public class SurferDB {
  private static Map<String, Surfer> surfers = new HashMap<>();
  
  /**
   * Creates and returns a new contact, storing in memory.
   * @param formData 
   * @return new contact
   */
  public static Surfer addSurfer(SurferFormData formData) {
    String slugVal = formData.slug;
    long idVal = (formData.id == 0) ? surfers.size() + 1 : formData.id;
    Surfer surfer = new Surfer(idVal, formData.name, formData.home, formData.awards,
        formData.carouselUrl, formData.bioUrl, formData.bio, formData.slug, formData.type);
    surfers.put(slugVal, surfer); 
    return surfer;
  }
  
  /**
   * Returns a list containing all defined surfers.
   * @return surfers
   */
  public static List<Surfer> getSurfer() {
    return new ArrayList<>(surfers.values());
  }
  
  /**
   * Returns a contact instance associated with the passed id, or throws a RuntimeException if the
   * Id is not found.
   * @param id long
   * @return Surfer
   * 
   */
  public static Surfer getSurfer(String slug) {
    Surfer surfer = surfers.get(slug);
    if (surfer == null) {
      throw new RuntimeException("Passed a bogus id: " + slug);
    }
    return surfer;
  }
  
  public static void deleteSurfer(String slug) {
    surfers.remove(slug);
  }
  
  /**
   * checks to see if a slug already exists.
   * @param slug
   * @return false if slug does not exist, true if slug exists
   */
  public static boolean exists(String slug) {
    Surfer surfer = surfers.get(slug);
    if (surfer == null) {
      return false;
    }
    return true;
  }
  
}
