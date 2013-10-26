import models.Surfer;
import models.SurferDB;
import play.Application;
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

    SurferDB
        .add(new SurferFormData(
            new Surfer(
                1,
                "Rabbit Kekai",
                "Honolulu, HI",
                "A winner of the Peruvian " + "and Makaha International titles during the '50s",
                "http://www.surfersvillage.com/img/news/1009-mr_albert-rabbit-kekai.jpg",
                "http://www.surfersvillage.com/img/news/1009-mr_albert-rabbit-kekai.jpg",
                "From Waikiki beach boys to groundbreaking surfer"
                    + "to North Shore Beach Marshall, Rabbit Kekai has crossed"
                    + "paths with Duke Kahanamoku, John Florence and everyone in between. Now in his ninth decade, his enthusiasm for"
                    + "talking story, telling jokes and surfing are as strong as ever. One of five children born to a Waikiki"
                    + "machinist, Albert Kekai was a part of the beach scene by age three. His uncle was a lifeguard at Publics, and he"
                    + "had young Kekai surfing by age five. Active in every sport under the sun, his remarkable speed on the field"
                    + "earned the boy the nickname \"Rabbit.\" Of his early days, he remembers, \"I would play football, come back surf,"
                    + "play basketball, come back surf, run track, always going.\" At 10, he was taken under the wing of Duke Kahanamoku"
                    + "who paid his entries into canoe races and had him teaching surf lessons. An excellent student at Kamehameha"
                    + "High, Rabbit sought an athletic scholarship but was hampered by his small stature. Despite academic scholarship"
                    + "offers, he decided to earn a living from the beach. To supplement his beachboy lifestyle, he earned wages as a"
                    + "caddy at Ala Wai Golf Course, a construction worker, a stevedore, a bit actor and a successful beachside"
                    + "gambler. A pioneer of North Shore surfing in the '30s with George Downing, Wally Froiseth, Woody Brown and Henry"
                    + "Lum, Rabbit became known as an innovator of drop-knee turns on short, finless boards. He practically invented"
                    + "hotdogging, inspiring the likes of Phil Edwards, Matt Kivlin, Joe Quigg, Miki Dora and Donald Takayama (who"
                    + "shapes Rabbit's boards today). He also had a direct part in the development of surfers such as Joey Cabell, Jeff"
                    + "Hakman and Randy Rarick. He made his own redwood and balsa boards prior to World War II, at which time he served"
                    + "as an army frogman in the South Pacific. He was one of four from his 12-man platoon to return from action."
                    + "A winner of the Peruvian and Makaha International titles during the '50s, Rabbit competed worldwide and"
                    + "remains an avid competitor to this day, routinely winning the over-50 division. As for remembering his"
                    + "accomplishments, he responds, \"When you pass 500 trophies, years and years ago, you lose count.\" Each winter"
                    + "season, he can be found at every Triple Crown event, doling out singlets, wisecracks and advice as Beach"
                    + "Marshall, a position he has held since the first Pipe Masters in 1971. Regardless of nationality, he calls all"
                    + "the surfers by name and has a pleasant word for all. Now a great-grandfather, Rabbit resides just down the road"
                    + "from his Waikiki stomping grounds. His wife Lynn is a schoolteacher in Palos Verdes, California, and he makes"
                    + "several trips to the mainland each year. He remains the most in-demand surf instructor at Baby Queens and"
                    + "contends that the ocean is the key to eternal youth. \"The water is so good,\" he says thoughtfully. \"It keeps me"
                    + "young while my friends are so old. I tell them to get in the water. It calms you -- no stress -- and brings you"
                    + "back to earth.\"-- Jason Borte", "rabbitkekai", "Male")));

    SurferDB
        .add(new SurferFormData(
            new Surfer(
                2,
                "Pauline Menczer",
                "Sydney, Australia",
                "2002 ASP World Qualifying Series",
                "http://www.surfersvillage.com/img/news/menczer_fiji_tostee_2.jpg",
                "http://www.surfline.com/surfaz/images/menczer_pauline/pf_pmenzer_port.jpg",
                "One of pro surfing's great individuals, Pauline Menzcer won the 1988 world amateur and 1993 professional"
                    + "crowns, took out events in every tour leg, gained the nickname \"Naughty Pauls\" and fought an incredible lifelong"
                    + "duel with crippling rheumatoid arthritis -- all without attracting the serious attention of a major sponsor."
                    + "This might make another surfer bitter, but it only draws a mocking grin to Menzcer's freckled noggin. It's been"
                    + "a long time since she fit any mold."
                    +

                    "Born in Sydney, Australia, Menzcer raised the ante in the women's pro scene of the late '80s and kept the"
                    + "hammer down on the likes of Lisa Andersen, Pam Burridge and Layne Beachley throughout the '90s. She learned to"
                    + "surf at Australia's great city break, Bondi, and worked up a strong high-energy approach that popped a few egos"
                    + "in Pro-World and even pulled a few hoots from the male pros -- a rare feat, then and now. Speed and snap were"
                    + "key to her early victories in French and Australian beachbreaks."
                    +

                    "Watching her perform, it was difficult to imagine its flip side -- hours of agony from the arthritis. She"
                    + "pushed through it during competition, but other times, it hurt just to move her fingers. Eventually, Menzcer"
                    + "gained some control over the affliction through a rigorous diet."
                    +

                    "She narrowly lost a world title race to Wendy Botha in 1991, but wrecked 1993 for everyone else by making"
                    + "half the finals and winning half of them. In that year, her only income -- slightly more than $30,000 -- came"
                    + "from prize money. Money has never come easy to Menzcer: her family was anything but rich. She knew how to live"
                    + "off the smell of a bar of wax."
                    +

                    "Even in the late '90s, she took a tent on tour and slept in friends' backyards. Small, fiery and immensely"
                    + "likable, she pulls this kind of thing with relative ease. Off tour, she lives at Byron Bay in northern New South"
                    + "Wales, Australia. -- Nick Carroll", "paulinemenczer", "Female")));

    SurferDB
        .add(new SurferFormData(
            new Surfer(
                3,
                "John Mel",
                "Santa Cruz, CA",
                "Three National Titles",
                "http://www.ocinsite.com/images/uploads/John.jpg",
                "http://www.norcalsurfers.com/word/wp-content/gallery/rider-john-mel/quiksilver-troyer-copy.jpg",
                "John Mel was born and raised in the coastal town of Santa Cruz, California into a surfing legacy under his"
                    + "namesake, his paternal grandfather, a surf shop owner, and his father, Peter Mel, Big Wave World Champion of"
                    + "2012."
                    + "At the tender age of six, John learned to surf on his own in the warm waters of Mexico, though he still"
                    + "resided in Santa Cruz. Under the guidance of his father, he continues to relish the surfer's lifestyle."
                    + "Though he is a young competitor, John holds three National titles in surfing and is an up and coming"
                    + "international competitor at the age of thirteen."
                    + "John is also an endorsed athlete who represents his sponsors with esteem in catalogs, e-commerce,"
                    + "ad-campaigns and in the pages of surf magazines and websites. Along with his surfing, John is very well spoken"
                    + "and loves to give a good interview. Many find his prolific YouTube clips to be entertaining and uplifting."
                    + "He is a well-traveled athlete who spends more time on the road than at home in his current town of Newport"
                    + "Beach, California."
                    + "When John is not surfing, he catches up on his studies online in a home school program fitting for his busy"
                    + "schedule. He also enjoys skateboarding and golfing to hone his repertoire. Another hobby of John's is movie"
                    + "making; with his mom and dad's help filming him around the world, he edits and composes his own surf movies."
                    + "John's true love is traveling the world in search of the perfect wave. From Europe to Fiji and Mexico to"
                    + "South America, there is no stopping this young athlete from chasing his dreams.", "johnmel",
                "Grom")));

  }
}
