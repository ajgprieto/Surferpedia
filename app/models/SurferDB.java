package models;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    if (SurferDB.exists(formData.slug)) {
      Date now = new Date();
      String surferName = formData.name;
      UpdateDB.addUpdates(new Update(DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT).format(now) +"",
                          "Edit", surferName));
    } else {
      Date now = new Date();
      String surferName = formData.name;
      UpdateDB.addUpdates(new Update(DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT).format(now) +"",
                          "Create", surferName));
    }
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
   * @param slug gets instance of surfer
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
  
  /**
   * deletes a surfer.
   * @param slug gets instance of surfer
   */
  public static void deleteSurfer(String slug) {
    Date now = new Date();
    String surferName = SurferDB.getSurfer(slug).getName();
    UpdateDB.addUpdates(new Update(DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT).format(now) +"",
                        "Delete", surferName));
    surfers.remove(slug);
  }
  
  /**
   * checks to see if a slug already exists.
   * @param slug gets instance of surfer
   * @return false if slug is not used, true otherwise
   */
  public static boolean exists(String slug) {
    Surfer surfer = surfers.get(slug);
    if (surfer == null) {
      return false;
    } 
    return true;
  }
  
  /**
   * checks to see if slug is in edit mode.
   * @param slug of surfer
   * @param id of surfer
   * @return false if id passed matched id of surfer, true if not to execute error
   */
  public static boolean isEdit(String slug, long id) {
    Surfer surfer = surfers.get(slug);
    if (surfer.getId() == id) {
      return false;
    }
    return true;
  }
  
}
