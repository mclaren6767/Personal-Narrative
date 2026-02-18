import org.code.theater.*;
import org.code.media.*;

public class friends extends Scene{

  private ImageFilter[][] friendPictures;
  private String[][] friendsCaptions = {{"A picture after volleyball", "Homecoming 2025", "football game", "halloween"},
                                             {"dinner with my aunt", "skydiving with my dad", "piano recital", "15th birthday"}};




    //parameterized constructor
    public friends(ImageFilter[][] friendPictures){
      this.friendPictures = friendPictures;

    }

    /*
     * draws the scene by collecting all helper methods
     * setting text fonts
     */
    public void drawScene(){
      //bold, font Serif, and white text color
      setTextStyle(Font.SERIF, FontStyle.BOLD);
      setTextColor("white");
      drawIntro();
      drawFriends();
      drawFamily();     
    }

      /*
       * this method draws all of my friends pictures
       * with its captions and goes through the for loop
       */
    
      public void drawFriends(){
      clear("black");
      drawImage("beach-bg.jpg",0,0,800);
      drawText("These are some pictures of my friends", 25, 200);
      pause(2);
      clear("black");
      for (int i = 0; i<friendPictures[0].length; i++){
        drawImage("beach-bg.jpg",0,0,800);

         //draws captions and pictures
        drawText(friendsCaptions[0][i], 30, 100);
        drawImage(friendPictures[0][i], 30, 150,350);


        //apply filter
       friendPictures[0][i].colorShift(10);
        drawImage(friendPictures[0][i], 30, 150,350);
        
        pause(1.5);
        clear("black");
      }
    }

    
       /*
       * this method draws all of my family pictures
       * with its captions and goes through the for loop
       */
  
      public void drawFamily(){
      clear("black");
      drawImage("skybg.jpg",0,0,800);
      drawText("These are some pictures of my family", 25, 200);
      pause(2);
      clear("black");
      for (int i = 0; i<friendPictures[1].length; i++){
  

        //draws captions and pictures
        drawText(friendsCaptions[1][i], 30, 100);
        drawImage(friendPictures[1][i], 30, 150,350);

        //apply filter
       friendPictures[1][i].colorShift(10);
        drawImage(friendPictures[1][i], 30, 150,350);
        
        pause(1.5);
        clear("black");
      }
    }

    /*
    * Draw introduction slide using images and text
    */
    public void drawIntro(){
      drawImage("beach-bg.jpg",0,0,800);
      drawText("A big part of me is my friends and family", 65, 100);
      pause(2);
    }
}