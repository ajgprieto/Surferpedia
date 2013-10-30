package views.formdata;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import models.Surfer;
import models.SurferDB;
import play.data.validation.ValidationError;

/**
 * Simple surfer form data.
 * 
 * @author AJ
 * 
 */
public class SurferFormData {
  
  /**The surfer's ID number.*/
  public long id;

  /** Surfer's name. */
  public String name = "";

  /** Sufer's hometown. */
  public String home = "";

  /** Surfer's awards. */
  public String awards = "";
  
  /** Surfer's foot style. */
  public String footStyle = "";

  /** Surfer's carousel picture. */
  public String carouselURL = "";

  /** Surfer's bio picture. */
  public String bioURL = "";

  /** Surfer's bio. */
  public String bio = "";

  /** Surfer's slug. */
  public String slug = "";

  /** Surfer's type. */
  public String type = "";
 
  /**
   * Empty, no argument constructor.
   */
  public SurferFormData() {
  }

  /**
   * Creates a SurferFormData from the information given by surfer.
   * 
   * @param surfer the surfer
   */
  public SurferFormData(Surfer surfer) {
    this.id = surfer.getID();
    this.name = surfer.getName();
    this.home = surfer.getHome();
    this.awards = surfer.getAwards();
    this.footStyle = surfer.getFootStyle();
    this.carouselURL = surfer.getCarouselURL();
    this.bioURL = surfer.getBioURL();
    this.bio = surfer.getBio();
    this.slug = surfer.getSlug();
    this.type = surfer.getType();
  }

  
  /**
   * Validates that all the entered fields are correct.
   * 
   * @return error the List of errors if any.
   */
  public List<ValidationError> validate() {

    List<ValidationError> error = new ArrayList<>();
    
    if (name == null || name.length() == 0) {
      error.add(new ValidationError("name", "Name is required."));
    }
    if (home == null || home.length() == 0) {
      error.add(new ValidationError("home", "Home is required"));
    }
    if (carouselURL == null || carouselURL.length() == 0) {
      error.add(new ValidationError("carouselURL", "Carousel URL is required."));
    }
    if (bioURL == null || bioURL.length() == 0) {
      error.add(new ValidationError("bioURL", "Bio URL is required."));
    }
    if (bio == null || bio.length() == 0) {
      error.add(new ValidationError("bio", "Surfer bio is required."));
    }
    if (slug == null || slug.length() == 0) {
      error.add(new ValidationError("slug", "Slug is required for URL."));
    }
    if (!Pattern.matches("[A-Za-z0-9]+$", slug)) {
      error.add(new ValidationError("slug", "Slug must contain only digits or characters"));
    }
    if (SurferDB.checkSlug(slug) && SurferDB.isEdit(slug, id)) {
      error.add(new ValidationError("slug", "Slug must be unique."));
    }
    if (!SurferTypes.isType(type)) {
      error.add(new ValidationError("type", "The surfer type is invalid."));
    }
    return error.isEmpty() ? null : error;
  }
}
