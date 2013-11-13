import models.SurferDB;
import models.UserInfoDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.SurferFormData;


/**
 * Initialization for the application.
 * will have three surfer's bios.
 * @author scotthonda
 *
 */
public class Global extends GlobalSettings {
   
  /**
   * Initialize the app with surfers.
   * @param app 
   */
  public void onStart(Application app) {
    UserInfoDB.addUserInfo("John Smith", "smith@exam.com", "pass");
    
    SurferDB.addSurfer(new SurferFormData("Kolohe Andino", "San Clemente, California", "", 
        "http://www.redbullcaribbean.com/cs/RedBull/RBImages/000/000/508/672/photo610x343a/KoloheAndino_02.jpg",
        "http://koloheandino.com/files/2013/02/kolohe_avatar-460x460.jpg",
        "Kolohe Andino (born March 22, 1994 in San Clemente, California) is an American surfer. He began to surf "
        + "at age 10 and holds the record for the most National Scholastic Surfing Association championships won by a"
        + "male competitor (9) . He won both the ASP 6-Star Quicksilver Brazil Open of Surfing[1] and the Vans Pier"
        + "Classic world tour events, 2011. Andino's sponsors include Oakley eyewear and Hurley wetsuits and clothing.",
        "koloheandino", "Male", "Regular"));
    
    SurferDB.addSurfer(new SurferFormData("Kelia Moniz", "Waikiki, Hawaii", "", 
        "http://b.vimeocdn.com/ts/301/108/301108760_640.jpg",
        "http://b.vimeocdn.com/ts/301/108/301108760_640.jpg",
        "At eighteen, Kelia is one of the most graceful, carefree, and above all, versatile surfers out there. "
        + "She's equally fluid off the lip or cross-stepping to the nose, whether she's longboarding or shortboarding."
        + " Kelia makes surfing look fun to surfers and non-surfers alike with her flow, and her mother compares "
        + "her surfing style to that of a sassy ballerina.",
        "keliamoniz", "Female", "Regular"));
    
    SurferDB.addSurfer(new SurferFormData("Noa Mizuno", "Honolulu, Hawaii", "", 
        "http://www.cisurfboards.com/wp-content/uploads/2011/10/noa-mizuno-1-586x389.jpg",
        "http://www.cisurfboards.com/wp-content/uploads/2011/10/noa-mizuno-4-586x784.jpg",
        "Noa Patrick Kaiuluokealaula Mizuno was born on December 6th 1998. At 5'5, 120 lbs he attends Punahou on"
        + " Oahu, Hawai'i. His favourite surf spot is Pipelines. He loves good surfing & good times and hates losing.",
        "noamizuno", "Grom", "Regular"));
  }
  
}