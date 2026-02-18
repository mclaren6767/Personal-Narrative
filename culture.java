import org.code.theater.*;
import org.code.media.*;

public class culture extends Scene{

  private ImageFilter[][] IranBandA;
  private String[][] iranCaptions = {{"Irans old flag", "Iran's new flag", "Irans old ruler/king"},
                                             {"Irans new ruler/dictator","Iran before the regime", "Iran now during the regime"}};
 



    //parameterized constructor
    public culture(ImageFilter[][] IranBandA){
      this.IranBandA = IranBandA;
  
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
      oldIran();
      drawNewIran();     
    }



    /*
     * puts together an intro that shows old Iran and
     * loops through 2D array to show images before and after with blur filter
     */
 
  public void oldIran(){
      clear("black");
      drawImage("background.jpg",0,0,800);
      drawText("This is Iran before the regime", 25, 200);
      drawText("While under the Shah or King of Iran.", 25, 250);
      pause(2);
      clear("black");
      for (int i = 0; i<IranBandA[0].length; i++){

        drawText(iranCaptions[0][i], 30, 100);
        drawImage(IranBandA[0][i], 30, 150,350);

       //apply filter
         IranBandA[0][i].applyBlur();
        drawImage(IranBandA[0][i], 30, 150,350);
        
        pause(1.5);
        clear("black");
      }
    }



    /*
     * puts together an intro that shows new Iran and
     * loops through 2D array to show images before and after filter
     */
    public void drawNewIran(){
      clear("black");
      drawImage("iranToday.jpg",0,0,800);
      drawText("Here is what Iran looks like today", 25, 200);
      drawText("This is under the Islamic Regime.", 25, 250);
      pause(2);
      clear("black");
      for (int i = 0; i<IranBandA[1].length; i++){
    

        
        drawText(iranCaptions[1][i], 30, 100);
        drawImage(IranBandA[1][i], 30, 150,350);


        //apply filter
       IranBandA[1][i].applyBlur();
        drawImage(IranBandA[1][i], 30, 150,350);
        
        pause(1.5);
        clear("black");
      }
    }


     /*
    * Draw introduction slide using images and text
    */
    public void drawIntro(){
      drawImage("iran-flag.jpg",0,0,800);
      drawText("I am Persian and this is my culture", 65, 100);
      pause(2);
    }
}