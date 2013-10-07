package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.Index;
import views.html.rabbitkekai;
import views.html.paulinemenczer;
import views.html.finnmcgill;
import views.html.kalanidavid;
import views.html.nikki;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  public static Result index() {
    return ok(Index.render("Welcome to the home page."));
  }
  
  
  /**
   * Returns rabbitkekai, a page relating to the biography of Rabbit Kekai.
   * @return rabbitkekai.
   */
  public static Result rabbitkekai() {
    return ok(rabbitkekai.render("Rabbit Kekai"));
  }
  
  /**
   * Returns paulinemenczer, a page relating to the biography of Pauline Menczer.
   * @return paulinemenczer.
   */
  public static Result paulinemenczer() {
    return ok(paulinemenczer.render("Pauline Menczer")); 
  }
  
  /**
   * Returns finnmcgill, a page relating to the biography of Finn McGill.
   * @return finnmcgill.
   */
  public static Result finnmcgill() {
    return ok(finnmcgill.render("Welcome to Page1."));
    
  }
  
  /**
   * Returns kalanidavid, a page relating to the biography of Kalani David.
   * @return kalanidavid.
   */
  public static Result kalanidavid() {
    return ok(kalanidavid.render("Welcome to Page1."));
    
  }
  
  /**
   * Returns nikki, a page relating to the biography of Nikki Van Djik.
   * @return nikki.
   */
  public static Result nikki() {
    return ok(nikki.render("Welcome to Page1."));
    
  }
}