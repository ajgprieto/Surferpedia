import models.Surfer;
import models.SurferDB;
import controllers.Application;
import play.GlobalSettings;
import views.formdata.SurferFormData;

/**
 * Global.
 * 
 * @author AJ
 * 
 */
public class Global extends GlobalSettings {

  /**
   * Automatically adds a surfer to the database.
   * 
   * @param app the Application
   */
  public void onStart(Application app) {
    SurferDB.add(new SurferFormData(new Surfer("Rabbit Kekai", "Honolulu, HI", "A winner of the Peruvian "
        + "and Makaha International titles during the '50s",
        "http://www.surfersvillage.com/img/news/1009-mr_albert-rabbit-kekai.jpg",
        "http://www.surfersvillage.com/img/news/1009-mr_albert-rabbit-kekai.jpg", "biO", "rabbitkekai", "Male")));
  }
}
