package models;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import views.formdata.SurferFormData;

/**
 * Provides a simple in-memory repo for Surfer data.
 * 
 * @author scotthonda
 */
public class SurferDB {

  /**
   * Creates and returns a new contact, storing in memory.
   * 
   * @param formData the formData
   */
  public static void addSurfer(SurferFormData formData) {
    String slugVal = formData.slug;
    Surfer surfers;

    Date now = new Date();
    if (!exists(slugVal)) {
      surfers =
          new Surfer(formData.name, formData.home, formData.awards, formData.carouselUrl, formData.bioUrl,
              formData.bio, formData.slug, formData.type, formData.style, formData.country);
      surfers.save();

      UpdateDB.addUpdates(new Updating(DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT).format(now)
          + "", "Create", formData.name));
    }
    else {
      // Edit not working
      surfers = getSurfer(slugVal);
      surfers.setName(formData.name);
      surfers.setHome(formData.home);
      surfers.setAwards(formData.awards);
      surfers.setCarouselUrl(formData.carouselUrl);
      surfers.setBioUrl(formData.bioUrl);
      surfers.setBio(formData.bio);
      surfers.setType(formData.type);
      surfers.setStyle(formData.style);
      surfers.setCountry(formData.country);
      surfers.save();

      UpdateDB.addUpdates(new Updating(DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT).format(now)
          + "", "Edit", formData.name));
    }
  }

  /**
   * Returns a list containing all defined surfers.
   * 
   * @return a List containing all of the surfers
   */
  public static List<Surfer> getSurfers() {
    return Surfer.find().all();
  }

  /**
   * Returns a contact instance associated with the passed id, or throws a RuntimeException if the Id is not found.
   * 
   * @param slug gets instance of surfer
   * @return Surfer
   * 
   */
  public static Surfer getSurfer(String slug) {
    return Surfer.find().where().eq("slug", slug).findUnique();
  }

  /**
   * deletes a surfer.
   * 
   * @param slug gets instance of surfer
   */
  public static void deleteSurfer(String slug) {
    Date now = new Date();
    String surferName = SurferDB.getSurfer(slug).getName();
    Surfer surfer = Surfer.find().where().eq("slug", slug).findUnique();
    if (surfer != null) {
      surfer.delete();

      UpdateDB.addUpdates(new Updating(DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT).format(now)
          + "", "Delete", surferName));
    }
    else {
      throw new RuntimeException("Passed a non slug: " + slug);
    }
  }

  /**
   * checks to see if a slug already exists.
   * 
   * @param slug gets instance of surfer
   * @return false if slug is not used, true otherwise
   */
  public static boolean exists(String slug) {
    return getSurfer(slug) != null;
  }

  /**
   * Checks to see if the slug exists, if exists, slug is in edit mode.
   * @param slug the slug
   * @return true if slug exists
   */
  public static boolean isEdit(String slug) {
    return !(getSurfer(slug) == null);
  }
}
