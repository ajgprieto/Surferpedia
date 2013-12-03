package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import play.db.ebean.Model;

/**
 * @author scotthonda
 *
 */
@Entity
public class Surfer extends Model {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  private long id;
  private String name;
  private String home;
  private String awards;
  private String carouselUrl;
  private String bioUrl;
  private String bio;
  private String slug;
  private String type;
  private String style;
  
  /**
   * finds a surfer.
   * @return a surfer
   */
  public static Finder<Long, Surfer> find() {
    return new Finder<Long, Surfer>(Long.class, Surfer.class);
  }
  
  /**
   * Creates a new surfer.
   * @param id = id
   * @param name = name of surfer
   * @param home = home of surfer
   * @param awards = awards of surfer
   * @param carouselUrl = image source URL for surfer in carousel
   * @param bioUrl = image source URL for surfer in bio page
   * @param bio = biography of surfer
   * @param slug = slug of surfer's page
   * @param type = type of surfer (Male, Female, or Grom)
   * @param style = footstyle
   */
  public Surfer(long id, String name, String home, String awards, String carouselUrl, String bioUrl,
                String bio, String slug, String type, String style) {
    this.id = id;
    this.name = name;
    this.home = home;
    this.awards = awards;
    this.carouselUrl = carouselUrl;
    this.bioUrl = bioUrl;
    this.bio = bio;
    this.slug = slug;
    this.type = type;
    this.setStyle(style);
  }
  
  /**
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the home
   */
  public String getHome() {
    return home;
  }

  /**
   * @param home the home to set
   */
  public void setHome(String home) {
    this.home = home;
  }

  /**
   * @return the awards
   */
  public String getAwards() {
    return awards;
  }

  /**
   * @param awards the awards to set
   */
  public void setAwards(String awards) {
    this.awards = awards;
  }

  /**
   * @return the carouselUrl
   */
  public String getCarouselUrl() {
    return carouselUrl;
  }

  /**
   * @param carouselUrl the carouselUrl to set
   */
  public void setCarouselUrl(String carouselUrl) {
    this.carouselUrl = carouselUrl;
  }

  /**
   * @return the bioUrl
   */
  public String getBioUrl() {
    return bioUrl;
  }

  /**
   * @param bioUrl the bioUrl to set
   */
  public void setBioUrl(String bioUrl) {
    this.bioUrl = bioUrl;
  }

  /**
   * @return the bio
   */
  public String getBio() {
    return bio;
  }

  /**
   * @param bio the bio to set
   */
  public void setBio(String bio) {
    this.bio = bio;
  }

  /**
   * @return the slug
   */
  public String getSlug() {
    return slug;
  }

  /**
   * @param slug the slug to set
   */
  public void setSlug(String slug) {
    this.slug = slug;
  }

  /**
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * @return the style
   */
  public String getStyle() {
    return style;
  }

  /**
   * @param style the style to set
   */
  public void setStyle(String style) {
    this.style = style;
  }

}
