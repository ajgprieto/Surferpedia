package views.formdata;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import models.Surfer;
import models.SurferDB;
import play.data.validation.ValidationError;

/**
 * @author scotthonda
 */
public class SurferFormData {
  
  /**
   * constructor for global data.
   * @param name of surfer
   * @param home of surfer
   * @param awards of surfer
   * @param carouselUrl of surfer
   * @param bioUrl of surfer
   * @param bio of surfer
   * @param slug of surfer
   * @param type of surfer
   * 
   */
  public SurferFormData(String name, String home, String awards, String carouselUrl, String bioUrl, String bio,
      String slug, String type, String style) {
    super();
    this.name = name;
    this.home = home;
    this.awards = awards;
    this.carouselUrl = carouselUrl;
    this.bioUrl = bioUrl;
    this.bio = bio;
    this.slug = slug;
    this.type = type; 
    this.style = style;
  }
  
  /** the id field. */
  public long id;
  /** the name field. */
  public String name = "";
  /** the home field. */
  public String home = "";
  /** the awards field. */
  public String awards = "";
  /** the carousel URL. */
  public String carouselUrl = "";
  /** the bio URL. */
  public String bioUrl = "";
  /** the bio field. */
  public String bio = "";
  /** the slug. */
  public String slug = "";
  /** the type. */
  public String type = "";
  /** the style. */
  public String style = "";
  
  /**
   * default constructor.
   */
  public SurferFormData() {
    //constructor
  }
  
  /**
   * creates a new SurferFormData object.
   * @param surfer surfer instance
   */
  public SurferFormData(Surfer surfer) {
    this.id = surfer.getId();
    this.name = surfer.getName();
    this.home = surfer.getHome();
    this.awards = surfer.getAwards();
    this.carouselUrl = surfer.getCarouselUrl();
    this.bioUrl = surfer.getBioUrl();
    this.bio = surfer.getBio();
    this.slug = surfer.getSlug();
    this.type = surfer.getType();
    this.style = surfer.getStyle();
  }
  
  

  /**
   * Validates form input by the user.
   * All fields cannot be empty
   * telephone field must have 12 chars.
   * @return null if no errors, error list if errors
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();
    
    if (name == null || name.length() == 0) {
      errors.add(new ValidationError("name", "Name is required"));
    }
    
    if (home == null || home.length() == 0) {
      errors.add(new ValidationError("home", "Home is required"));
    }
    
    if (carouselUrl == null || carouselUrl.length() == 0) {
      errors.add(new ValidationError("carouselUrl", "URL is required"));
    }
    
    if (bioUrl == null || bioUrl.length() == 0) {
      errors.add(new ValidationError("bioUrl", "URL is required"));
    }
    
    if (bio == null || bio.length() == 0) {
      errors.add(new ValidationError("bio", "Biography is required"));
    }
    
    if (slug == null || slug.length() == 0) {
      errors.add(new ValidationError("slug", "Slug is required"));
    }
    
    if (!Pattern.matches("[0-9a-zA-Z]+", slug)) {
      errors.add(new ValidationError("slug", "Slug must contain only digits or characters"));
    }
    
    if (SurferDB.exists(slug) && SurferDB.isEdit(slug, id)) { 
      errors.add(new ValidationError("slug", "Slug must be unique"));
    }
    
    if (!SurferTypes.isType(type)) {
      errors.add(new ValidationError("surferType", "Surfer type is invalid"));
    }
    
    return errors.isEmpty() ? null : errors;
  }
}
