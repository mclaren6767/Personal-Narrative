import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    ImageFilter[][] cultureImages = {
      {new ImageFilter("iran-flag.jpg"), new ImageFilter("iran-current-flag.jpg"), new ImageFilter("azadi.jpg")},
      {new ImageFilter("Khameni.jpg"), new ImageFilter("iran-before.jpg"), new ImageFilter("iran-now.jpg")}
    };

    ImageFilter[][] friendImages = {
      {new ImageFilter("IMG_1865.jpeg"), new ImageFilter("IMG_1866.jpeg"), new ImageFilter("IMG_1867.jpeg"), new ImageFilter("DSC02399.jpg")},
      {new ImageFilter("IMG_0688.JPG"), new ImageFilter("DSC_0033.JPEG"), new ImageFilter("IMG_7487.jpg"),  new ImageFilter("IMG_6622.JPG")}
    };

    culture scene1 = new culture(cultureImages);
    friends scene2 = new friends(friendImages);

    scene1.drawScene();
    scene2.drawScene();

    Theater.playScenes(scene1, scene2);
  }
}