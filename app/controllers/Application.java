package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.Index;
import views.html.Page1;
import views.html.Koloheandino;
import views.html.Keliamoniz;
import views.html.Noa;
import views.html.Laird;
import views.html.Kalanid;
import views.html.Malia;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  public static Result Index() {
    return ok(Index.render("Welcome to the home page."));
  }
  
  /**
   * Returns page1, a simple example of a second page to illustrate navigation.
   * @return The Page1.
   */
  public static Result Page1() {
    return ok(Page1.render("Welcome to Page1."));
    
  }
 
  /**
   * Returns page of Koloheandino.
   * @return The Koloheandino.
   */
  public static Result Koloheandino() {
    return ok(Koloheandino.render("Kolohe Andino."));
    
  }
  
  /**
   * Returns page of Kelia Moniz.
   * @return The Keliamoniz.
   */
  public static Result Keliamoniz() {
    return ok(Keliamoniz.render("Kelia Moniz"));
    
  }
  
  /**
   * Returns page of Noa Mizuno
   * @return The Noa.
   */
  public static Result Noa() {
    return ok(Noa.render("Noa Mizuno"));
    
  }
  
  /**
   * Returns page of Laird.
   * @return The Laird.
   */
  public static Result Laird() {
    return ok(Laird.render("Laird Hamilton"));
    
  }
  
  /**
   * Returns page of Kalanid
   * @return The Kalanid.
   */
  public static Result Kalanid() {
    return ok(Kalanid.render("Kalani David"));
    
  }
  
  /**
   * Returns page of Malia Manuel.
   * @return The Malia.
   */
  public static Result Malia() {
    return ok(Malia.render("Malia Manuel."));
    
  }
}
