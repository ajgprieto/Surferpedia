package controllers;

import models.SurferDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.Index;
import views.html.Login;
import views.html.ManageSurfer;
import views.html.ShowSurfer;
import views.formdata.FootStyles;
import views.formdata.LoginFormData;
import views.formdata.SurferFormData;
import views.formdata.SurferTypes;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page.
   * 
   * @return The resulting home page.
   */
  public static Result index() {
    return ok(Index.render(SurferDB.getSurferList(), Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
  }

  /**
   * Allows the user to add in a new surfer.
   * 
   * @return a page to put in information about a new surfer.
   */
  public static Result newSurfer() {
    SurferFormData data = new SurferFormData();
    data.id = 0;
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    System.out.println(data.slug);
    return ok(ManageSurfer.render(formData, FootStyles.getFootStyles(), SurferTypes.getTypes(data.type),
        SurferDB.getSurferList(), "New", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
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
    return ok(ManageSurfer.render(formData, FootStyles.getFootStyles(), SurferTypes.getTypes(data.type),
        SurferDB.getSurferList(), "Edit", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
  }

  /**
   * Posts the surfer to a page.
   * 
   * @return the page containing the surfer and their information.
   */
  public static Result postSurfer() {
    Form<SurferFormData> formData = Form.form(SurferFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      return badRequest(ManageSurfer.render(formData, FootStyles.getFootStyles(), SurferTypes.getTypes(),
          SurferDB.getSurferList(), "Post", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }
    else {
      SurferFormData data = formData.get();
      SurferDB.add(data);
      if (SurferDB.checkSlug(data.slug)) {
        return ok(ManageSurfer.render(formData, FootStyles.getFootStyles(), SurferTypes.getTypes(data.type),
            SurferDB.getSurferList(), "Edit", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
      }
      else {
        return ok(ManageSurfer.render(formData, FootStyles.getFootStyles(), SurferTypes.getTypes(data.type),
            SurferDB.getSurferList(), "Post", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
      }
    }
  }

  /**
   * Returns the surfer's page that corresponds to the unique slug.
   * 
   * @param slug the unique ID belonging to a surfer.
   * @return the surfer's page.
   */
  public static Result getSurfer(String slug) {
    return ok(ShowSurfer.render(SurferDB.getSurfer(slug), SurferDB.getSurferList(), Secured.isLoggedIn(ctx()),
        Secured.getUserInfo(ctx())));
  }

  /**
   * Deletes a surfer from the page.
   * 
   * @param slug the unique ID belonging to the surfer to be deleted.
   * @return the new page without the surfer.
   */
  public static Result deleteSurfer(String slug) {
    SurferDB.deleteSurfer(slug);
    return ok(Index.render(SurferDB.getSurferList(), Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
  }

  /**
   * Provides the Login page (only to unauthenticated users).
   * 
   * @return The Login page.
   */
  public static Result login() {
    Form<LoginFormData> formData = Form.form(LoginFormData.class);
    return ok(Login.render(SurferDB.getSurferList(), Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
  }

  /**
   * Processes a login form submission from an unauthenticated user. First we bind the HTTP POST data to an instance of
   * LoginFormData. The binding process will invoke the LoginFormData.validate() method. If errors are found, re-render
   * the page, displaying the error data. If errors not found, render the page with the good data.
   * 
   * @return The index page with the results of validation.
   */
  public static Result postLogin() {

    // Get the submitted form data from the request object, and run validation.
    Form<LoginFormData> formData = Form.form(LoginFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      flash("error", "Login credentials not valid.");
      return badRequest(Login.render(SurferDB.getSurferList(), Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
          formData));
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
   * 
   * @return A redirect to the Index page.
   */
  @Security.Authenticated(Secured.class)
  public static Result logout() {
    session().clear();
    return redirect(routes.Application.index());
  }

}
