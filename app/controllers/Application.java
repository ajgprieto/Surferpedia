package controllers;

import models.SurferDB;
import models.Surfer;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.SurferFormData;
import views.formdata.SurferTypes;
import views.html.ShowSurfer;
import views.html.Index;
import views.html.ManageSurfer;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  public static Result index() {
    return ok(Index.render(SurferDB.getSurferList()));
  }
  
  
  /**
   * Returns ManageSurfer, a page that simulates an add surfer page.
   * 
   * @return The A new surfer.
   */
  public static Result newSurfer() {
    SurferFormData data = new SurferFormData();
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    return ok(ManageSurfer.render(formData, SurferTypes.getTypes(data.type), SurferDB.getSurferList()));
  }
  
  /**
   * Allows the user to edit the surfer's information.
   * 
   * @param slug the unique ID belonging to the surfer.
   * @return the data of the surfer to be edited.
   */
  public static Result manageSurfer(String slug) {
    SurferFormData data = new SurferFormData(SurferDB.getSurfer(slug));
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    return ok(ManageSurfer.render(formData, SurferTypes.getTypes(data.type), SurferDB.getSurferList()));
  }

  /**
   * Posts the surfer on the page.
   * 
   * @return the page containing the surfer.
   */
  public static Result postSurfer() {
    Form<SurferFormData> formData = Form.form(SurferFormData.class).bindFromRequest();
        
    if (formData.hasErrors()) {
      return badRequest(ManageSurfer.render(formData, SurferTypes.getTypes(), SurferDB.getSurferList()));
    }
    else {
      SurferFormData data = formData.get();
      Form<SurferFormData> formData2 = Form.form(SurferFormData.class);
      SurferDB.add(data);
      return ok(ManageSurfer.render(formData2, SurferTypes.getTypes(), SurferDB.getSurferList()));
    }
  }
  
  /**
   * Deletes the surfer from the Map.
   * 
   * @param slug the unique ID belonging to the surfer.
   * @return the SurferList with the surfer removed.
   */
  public static Result deleteSurfer(String slug) {
    SurferDB.deleteSurfer(slug);
    return ok(Index.render(SurferDB.getSurferList()));
  }
  
  /**
   * Returns the surfer that is being searched for.
   * 
   * @param slug the unique ID belonging to the surfer.
   * @return the surfer if found.
   */
  public static Result getSurfer(String slug) {
    return ok(ShowSurfer.render(SurferDB.getSurfer(slug), SurferDB.getSurferList()));
  }
}