package models;

/**
 * A class containing information about a surfer.
 * @author AJ
 *
 */
public class Surfer {

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
   * @param name surfer's name
   * @param home surfer's home
   * @param awards surfer's awards
   * @param carouselURL surfer's carousel picture
   * @param bioURL surfer's bio picture
   * @param bio surfer's bio
   * @param slug surfer's slug
   * @param type surfer's type
   */
  public Surfer(String name, String home, String awards, String carouselURL, String bioURL, String bio, String slug,
      String type) {
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
   * Returns surfer's name.
   * @return the surfer's name
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the surfer's home.
   * @return the surfer's home
   */
  public String getHome() {
    return home;
  }

  /**
   * Returns the surfer's awards.
   * @return the surfer's awards
   */
  public String getAwards() {
    return awards;
  }

  /**
   * Returns the surfers's carousel picture URL.
   * @return the picture URL
   */
  public String getCarouselURL() {
    return carouselURL;
  }

  /**
   * Returns the surfer's bio picture URL.
   * @return the picture URL
   */
  public String getBioURL() {
    return bioURL;
  }

  /**
   * Returns the surfer's bio.
   * @return the surfer's bio
   */
  public String getBio() {
    return bio;
  }

  /**
   * Returns the surfer's slug.
   * @return the slug
   */
  public String getSlug() {
    return slug;
  }

  /**
   * Returns the surfer's type.
   * @return the surfer's type
   */
  public String getType() {
    return type;
  }
}
