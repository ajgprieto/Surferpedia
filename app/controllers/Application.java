package controllers;

import models.SurferDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result; 
import views.html.Index;
import views.html.ManageSurfer;
import views.html.ShowSurfer;
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
    return ok(Index.render(SurferDB.getSurferList()));
  }
  
  /**
   * Allows the user to add in a new surfer.
   * 
   * @return a page to put in information about a new surfer.
   */
  public static Result newSurfer() {
    SurferFormData data = new SurferFormData();
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    System.out.println(data.name + " " + data.slug);
    return ok(ManageSurfer.render(formData, SurferTypes.getTypes(data.type), SurferDB.getSurferList(), "New"));
  }
  
  /**
   * Allows the user to edit the surfer's information.
   * 
   * @param slug the unique ID belonging to the surfer.
   * @return The page to edit the surfer's information.
   */
  public static Result manageSurfer(String slug) {
    SurferFormData data = new SurferFormData(SurferDB.getSurfer(slug));
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    return ok(ManageSurfer.render(formData, SurferTypes.getTypes(data.type), SurferDB.getSurferList(), "Edit"));
  }

  /**
   * Posts the surfer to a page.
   * 
   * @return the page containing the surfer and their information.
   */
  public static Result postSurfer() {
    Form<SurferFormData> formData = Form.form(SurferFormData.class).bindFromRequest();
    
    if (formData.hasErrors()) {
      return badRequest(ManageSurfer.render(formData, SurferTypes.getTypes(), SurferDB.getSurferList(), "Post"));
    }
    else {
      SurferFormData data = formData.get();
      SurferDB.add(data);
      return ok(ManageSurfer.render(formData, SurferTypes.getTypes(data.type), SurferDB.getSurferList(), "Post"));
    }
  }
  
  /**
   * Returns the surfer's page that corresponds to the unique slug.
   * 
   * @param slug the unique ID belonging to a surfer.
   * @return the surfer's page.
   */
  public static Result getSurfer(String slug) {
    return ok(ShowSurfer.render(SurferDB.getSurfer(slug), SurferDB.getSurferList()));
  }
  
  /**
   * Deletes a surfer from the page.
   * 
   * @param slug the unique ID belonging to the surfer to be deleted.
   * @return the new page without the surfer.
   */
  public static Result deleteSurfer(String slug) {
    SurferDB.deleteSurfer(slug);
    return ok(Index.render(SurferDB.getSurferList()));
  }
  
}

