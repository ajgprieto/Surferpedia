package controllers;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import models.SurferDB;
import models.Updating;
import models.UpdateDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result; 
import play.mvc.Security;
import views.html.Index;
import views.html.ManageSurfer;
import views.html.ShowSurfer;
import views.html.Updates;
import views.html.Login;
import views.formdata.FootstyleTypes;
import views.formdata.LoginFormData;
import views.formdata.SurferFormData;
import views.formdata.SurferTypes;


/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {
  
  
  
  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  public static Result index() {
    return ok(Index.render("Home", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), SurferDB.getSurfer()));
  }
  
  /**
   * Returns the Manage Surfer page given that there are no existing surfers.
   * @return The ManageSurfer page.
   */
  @Security.Authenticated(Secured.class)
  public static Result newSurfer() {
    SurferFormData data = new SurferFormData();
    data.id = 0;
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    Map<String, Boolean> surferTypeMap = SurferTypes.getTypes(data.type);
    List<String> surferStyleList = FootstyleTypes.getStyle();
    return ok(ManageSurfer.render("Home", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), 
        formData, surferTypeMap, SurferDB.getSurfer(), "newSurfer", surferStyleList));
  }
  
  /**
   * manageSurfer(String) allows for the edit of an already existing surfer.
   * @param slug = unique String value of a surfer's slug
   * @return the ManageSurfer page with fields filled in 
   */
  @Security.Authenticated(Secured.class)
  public static Result manageSurfer(String slug) {
    SurferFormData data = new SurferFormData(SurferDB.getSurfer(slug));
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    Map<String, Boolean> surferTypeMap = SurferTypes.getTypes(data.type);
    List<String> surferStyleList =  FootstyleTypes.getStyle();
    return ok(ManageSurfer.render("Home", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
        formData, surferTypeMap, SurferDB.getSurfer(), "editSurfer", surferStyleList));
  }

  /**
   * handles posting of form data by the user.
   * @return The ManageSurfer page will clear upon valid input.
   */
  @Security.Authenticated(Secured.class)
  public static Result postSurfer() {
    Form<SurferFormData> formData = Form.form(SurferFormData.class).bindFromRequest();
    
    if (formData.hasErrors()) {
      Map<String, Boolean> surferTypeMap = SurferTypes.getTypes();
      List<String> surferStyleList = FootstyleTypes.getStyle();
      return badRequest(ManageSurfer.render("Home", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
          formData, surferTypeMap, SurferDB.getSurfer(), "other", surferStyleList));
    }
    else {
      SurferFormData data = formData.get();
      
      /** Clears the form when button is clicked */
      Form<SurferFormData> formData2 = Form.form(SurferFormData.class);
      SurferDB.addSurfer(data);
      Map<String, Boolean> surferTypeMap = SurferTypes.getTypes(data.type);
      List<String> surferStyleList = FootstyleTypes.getStyle();
      return ok(ManageSurfer.render("Home", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), 
          formData2, surferTypeMap, SurferDB.getSurfer(), "other", surferStyleList));
    }
  }
  
  /**
   * getSurfer(String) returns the ShowSurfer page showing the surfer's info.
   * @param slug = unique String value of a surfer
   * @return the ShowSurfer page with surfer's info
   */
  public static Result getSurfer(String slug) {
    return ok(ShowSurfer.render("Home", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
        SurferDB.getSurfer(slug), SurferDB.getSurfer()));
  }
  
  /**
   * deletes a surfer.
   * @param slug of surfer
   * @return Index page
   */
  @Security.Authenticated(Secured.class)
  public static Result deleteSurfer(String slug) {
    SurferDB.deleteSurfer(slug);
    return ok(Index.render("Home", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
        SurferDB.getSurfer()));
  }
  
  /**
   * 
   */
  @Security.Authenticated(Secured.class)
  public static Result getUpdates() {
    return ok(Updates.render("Home", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
        SurferDB.getSurfer(), UpdateDB.getUpdates()));
  }
  
  /**
   * Provides the Login page (only to unauthenticated users). 
   * @return The Login page. 
   */
  public static Result login() {
    Form<LoginFormData> formData = Form.form(LoginFormData.class);
    return ok(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData, 
        SurferDB.getSurfer()));
  }

  /**
   * Processes a login form submission from an unauthenticated user. 
   * First we bind the HTTP POST data to an instance of LoginFormData.
   * The binding process will invoke the LoginFormData.validate() method.
   * If errors are found, re-render the page, displaying the error data. 
   * If errors not found, render the page with the good data. 
   * @return The index page with the results of validation. 
   */
  
  public static Result postLogin() {

    // Get the submitted form data from the request object, and run validation.
    Form<LoginFormData> formData = Form.form(LoginFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      flash("error", "Login credentials not valid.");
      return badRequest(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData, 
          SurferDB.getSurfer()));
    }
    else {
      // email/password OK, so now we set the session variable and only go to authenticated pages.
      session().clear();
      session("email", formData.get().email);
      return redirect(routes.Application.index());
    }
  }
  
  /**
   * Logs out (only for authenticated users) and returns them to the Index page. 
   * @return A redirect to the Index page. 
   */
  @Security.Authenticated(Secured.class)
  public static Result logout() {
    session().clear();
    return redirect(routes.Application.index());
  }
}


