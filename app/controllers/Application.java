package controllers;

import models.SurferDB;
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
    return ok(Index.render());
  }
  
  
  /**
   * Returns newcontact, a page that simulates an add contact page.
   * 
   * @param id the id of the Contact
   * 
   * @return The NewContact.
   */
  public static Result newSurfer() {
    Form<SurferFormData> formData = Form.form(SurferFormData.class);
    return ok(ManageSurfer.render(formData, SurferTypes.getTypes(), SurferDB.getSurfers()));
  }

  /**
   * Posts the surfer on the page.
   * 
   * @return the page containing the surfer.
   */
  public static Result postSurfer() {
    Form<SurferFormData> formData = Form.form(SurferFormData.class).bindFromRequest();
        
    if (formData.hasErrors()) {
      return badRequest(ManageSurfer.render(formData, SurferTypes.getTypes(), SurferDB.getSurfers()));
    }
    else {
      SurferFormData data = formData.get();
      SurferDB.add(data);
      return ok(ManageSurfer.render(formData, SurferTypes.getTypes(), SurferDB.getSurfers()));
    }
  }
  
}