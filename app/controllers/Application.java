package controllers;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import models.SurferDB;
import models.Update;
import models.UpdateDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result; 
import views.html.Index;
import views.html.ManageSurfer;
import views.html.ShowSurfer;
import views.html.Updates;
import views.formdata.FootstyleTypes;
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
    return ok(Index.render(SurferDB.getSurfer()));
  }
  
  /**
   * Returns the Manage Surfer page given that there are no existing surfers.
   * @return The ManageSurfer page.
   */
  public static Result newSurfer() {
    SurferFormData data = new SurferFormData();
    data.id = 0;
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    Map<String, Boolean> surferTypeMap = SurferTypes.getTypes(data.type);
    List<String> surferStyleList = FootstyleTypes.getStyle();
    return ok(ManageSurfer.render(formData, surferTypeMap, SurferDB.getSurfer(), "newSurfer", surferStyleList));
  }
  
  /**
   * manageSurfer(String) allows for the edit of an already existing surfer.
   * @param slug = unique String value of a surfer's slug
   * @return the ManageSurfer page with fields filled in 
   */
  public static Result manageSurfer(String slug) {
    SurferFormData data = new SurferFormData(SurferDB.getSurfer(slug));
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    Map<String, Boolean> surferTypeMap = SurferTypes.getTypes(data.type);
    List<String> surferStyleList =  FootstyleTypes.getStyle();
    return ok(ManageSurfer.render(formData, surferTypeMap, SurferDB.getSurfer(), "editSurfer", surferStyleList));
  }

  /**
   * handles posting of form data by the user.
   * @return The ManageSurfer page will clear upon valid input.
   */
  public static Result postSurfer() {
    Form<SurferFormData> formData = Form.form(SurferFormData.class).bindFromRequest();
    
    if (formData.hasErrors()) {
      Map<String, Boolean> surferTypeMap = SurferTypes.getTypes();
      List<String> surferStyleList = FootstyleTypes.getStyle();
      return badRequest(ManageSurfer.render(formData, surferTypeMap, SurferDB.getSurfer(), "other", surferStyleList));
    }
    else {
      SurferFormData data = formData.get();
      
      /** Clears the form when button is clicked */
      Form<SurferFormData> formData2 = Form.form(SurferFormData.class);
      SurferDB.addSurfer(data);
      Map<String, Boolean> surferTypeMap = SurferTypes.getTypes(data.type);
      List<String> surferStyleList = FootstyleTypes.getStyle();
      return ok(ManageSurfer.render(formData2, surferTypeMap, SurferDB.getSurfer(), "other", surferStyleList));
    }
  }
  
  /**
   * getSurfer(String) returns the ShowSurfer page showing the surfer's info.
   * @param slug = unique String value of a surfer
   * @return the ShowSurfer page with surfer's info
   */
  public static Result getSurfer(String slug) {
    return ok(ShowSurfer.render(SurferDB.getSurfer(slug), SurferDB.getSurfer()));
  }
  
  /**
   * deletes a surfer.
   * @param slug of surfer
   * @return Index page
   */
  public static Result deleteSurfer(String slug) {
    SurferDB.deleteSurfer(slug);
    return ok(Index.render(SurferDB.getSurfer()));
  }
  
  /**
   * 
   */
  public static Result getUpdates() {
    return ok(Updates.render(SurferDB.getSurfer(), UpdateDB.getUpdates()));
  }
}


