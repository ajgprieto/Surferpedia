package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.Index;
import views.html.RabbitKekai;
import views.html.PaulineMenczer;
import views.html.FinnMcGill;
import views.html.KalaniDavid;
import views.html.Nikki;
import views.html.JohnMel;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  public static Result index() {
    return ok(Index.render());
  }
  
  
  /**
   * Returns rabbitkekai, a page relating to the biography of Rabbit Kekai.
   * @return rabbitkekai.
   */
  public static Result rabbitkekai() {
    return ok(RabbitKekai.render());
  }
  
  /**
   * Returns paulinemenczer, a page relating to the biography of Pauline Menczer.
   * @return paulinemenczer.
   */
  public static Result paulinemenczer() {
    return ok(PaulineMenczer.render()); 
  }
  
  /**
   * Returns finnmcgill, a page relating to the biography of Finn McGill.
   * @return finnmcgill.
   */
  public static Result finnmcgill() {
    return ok(FinnMcGill.render());
    
  }
  
  /**
   * Returns kalanidavid, a page relating to the biography of Kalani David.
   * @return kalanidavid.
   */
  public static Result kalanidavid() {
    return ok(KalaniDavid.render());
    
  }
  
  /**
   * Returns nikki, a page relating to the biography of Nikki Van Djik.
   * @return nikki.
   */
  public static Result nikki() {
    return ok(Nikki.render());
    
  }
  
  /**
   * Returns johnmel, a page relating to the biography of John Mel.
   * @return johnmel.
   */
  public static Result johnmel() {
    return ok(JohnMel.render());
    
  }
}