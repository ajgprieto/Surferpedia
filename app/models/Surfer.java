package models;

/**
 * A class containing information about a surfer.
 * @author AJ
 *
 */
public class Surfer {

  private long id;
  private String name;
  private String home;
  private String awards;
  private String carouselURL;
  private String bioURL;
  private String bio;
  private String slug;
  private String type;

  /**
   * Creates a new surfer from the given information.
   * 
   * @param id the id of the surfer
   * @param name surfer's name
   * @param home surfer's home
   * @param awards surfer's awards
   * @param carouselURL surfer's carousel picture
   * @param bioURL surfer's bio picture
   * @param bio surfer's bio
   * @param slug surfer's slug
   * @param type surfer's type
   */
  public Surfer(long id, String name, String home, String awards, String carouselURL, String bioURL, String bio, String slug,
      String type) {
    this.id = id;
    this.name = name;
    this.home = home;
    this.awards = awards;
    this.carouselURL = carouselURL;
    this.bioURL = bioURL;
    this.bio = bio;
    this.slug = slug;
    this.type = type;
  }
  
  /**
   * Returns the ID for a surfer.
   * 
   * @return the unique ID belonging to a surfer.
   */
  public long getID() {
    return id;
  }

  /**
   * Returns surfer's name.
   * @return the surfer's name
   */
  public String getName() {
    return name;
  }
  
  /**
   * Sets the surfer's name.
   * @param name the surfer's name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Returns the surfer's home.
   * @return the surfer's home
   */
  public String getHome() {
    return home;
  }
  
  /**
   * Sets the surfer's home.
   * @param home the surfer's home
   */
  public void setHome(String home) {
    this.home = home;
  }

  /**
   * Returns the surfer's awards.
   * @return the surfer's awards
   */
  public String getAwards() {
    return awards;
  }

  /**
   * Sets the surfer's awards.
   * @param awards the surfer's awards.
   */
  public void setAwards(String awards) {
    this.awards = awards;
  }
  
  /**
   * Returns the surfers's carousel picture URL.
   * @return the picture URL
   */
  public String getCarouselURL() {
    return carouselURL;
  }
  
  /**
   * Sets the surfer's carousel picture URL.
   * @param carouselURL the url to the picture.
   */
  public void setCarouselURL(String carouselURL) {
    this.carouselURL = carouselURL;
  }

  /**
   * Returns the surfer's bio picture URL.
   * @return the picture URL
   */
  public String getBioURL() {
    return bioURL;
  }
  
  /**
   * Setst the surfer's bio picture URL.
   * @param bioURL the url to the picture.
   */
  public void setBioURL(String bioURL) {
    this.bioURL = bioURL;
  }

  /**
   * Returns the surfer's bio.
   * @return the surfer's bio
   */
  public String getBio() {
    return bio;
  }
  
  /**
   * Sets the surfer's bio.
   * @param bio the surfer's bio
   */
  public void setBio(String bio) {
    this.bio = bio;
  }

  /**
   * Returns the surfer's slug.
   * @return the slug
   */
  public String getSlug() {
    return slug;
  }
  
  /**
   * Sets the surfer's slug.
   * @param slug the surfer's slug.
   */
  public void setSlug(String slug) {
    this.slug = slug;
  }

  /**
   * Returns the surfer's type.
   * @return the surfer's type
   */
  public String getType() {
    return type;
  }
  
  /**
   * Sets the surfer's type.
   * @param type the surfer's type.
   */
  public void setType(String type) {
    this.type = type;
  }
}
