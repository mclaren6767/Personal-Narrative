import org.code.theater.*;
import org.code.media.*;


public class ImageFilter extends ImagePlus{


  public ImageFilter(String filename){
    super(filename);
  }

   public void makeNegative() {

    Pixel[][] pixels = getPixelsFromImage();

    for (int r = 0; r<pixels.length; r++){
      for (int c = 0; c<pixels[0].length; c++){
        Pixel currentPixel = pixels[r][c];

        int currentRed = (int) (255 - currentPixel.getRed());
        int currentGreen = (int) (255 - currentPixel.getGreen());
        int currentBlue = (int) (255 - currentPixel.getBlue());

        currentPixel.setRed(currentRed);
        currentPixel.setGreen(currentGreen);
        currentPixel.setBlue(currentBlue);
        
      }
    }
  }

    public void colorShift(int value) {
      
    Pixel[][] pixels = getPixelsFromImage();

    for (int r = 0; r<pixels.length; r++){
      for (int c = 0; c<pixels[0].length; c++){
        Pixel currentPixel = pixels[r][c];

        int currentRed = (int)(currentPixel.getRed() + value);
        int currentBlue = (int)(currentPixel.getBlue() + value);
        int currentGreen = (int)(currentPixel.getGreen() + value);

        currentPixel.setRed(currentRed);
        currentPixel.setBlue(currentBlue);
        currentPixel.setGreen(currentGreen);
      }
    }
  }

    public void applyBlur() {

    Pixel[][] pixels = getPixelsFromImage();

    for (int r = 1; r<pixels.length-1; r++){
      for (int c = 1; c<pixels[0].length-1; c++){
        Pixel currentPixel = pixels[r][c];

        currentPixel.setRed(calcWeightedRed(pixels,r,c));
        currentPixel.setGreen(calcWeightedGreen(pixels,r,c));
        currentPixel.setBlue(calcWeightedBlue(pixels,r,c));
      }
    }

  }

  /*
   * Returns a weighted red average of the pixels around the specified row and col
   */
  public int calcWeightedRed(Pixel[][] pixels, int row, int col) {
    int avgRed = (pixels[row-1][col-1].getRed() + pixels[row-1][col].getRed() + pixels[row-1][col+1].getRed() +
                  pixels[row][col-1].getRed() + pixels[row][col].getRed() + pixels[row][col+1].getRed() +
                  pixels[row+1][col-1].getRed() + pixels[row+1][col].getRed() + pixels[row+1][col+1].getRed()) / 9;
    return avgRed;
  }

  /*
   * Returns a weighted green average of the pixels around the specified row and col 
   */
  public int calcWeightedGreen(Pixel[][] pixels, int row, int col) {
    int avgGreen = (pixels[row-1][col-1].getGreen() + pixels[row-1][col].getGreen() + pixels[row-1][col+1].getGreen() +
                    pixels[row][col-1].getGreen() + pixels[row][col].getGreen() + pixels[row][col+1].getGreen() +
                    pixels[row+1][col-1].getGreen() + pixels[row+1][col].getGreen() + pixels[row+1][col+1].getGreen()) / 9;
    return avgGreen;
  }

  /*
   * Returns a weighted blue average of the pixels around the specified row and col
   */
  public int calcWeightedBlue(Pixel[][] pixels, int row, int col) {
    int avgBlue = (pixels[row-1][col-1].getBlue() + pixels[row-1][col].getBlue() + pixels[row-1][col+1].getBlue() +
                   pixels[row][col-1].getBlue() + pixels[row][col].getBlue() + pixels[row][col+1].getBlue() +
                   pixels[row+1][col-1].getBlue() + pixels[row+1][col].getBlue() + pixels[row+1][col+1].getBlue()) / 9;
    return avgBlue;
  }

    public void saturate(int factor) {

    Pixel[][] pixels = getPixelsFromImage();

    for (int r = 0; r<pixels.length; r++){
      for (int c = 0; c<pixels[0].length; c++){
        Pixel currentPixel = pixels[r][c];
        int average = (int)((currentPixel.getRed() + currentPixel.getBlue() + currentPixel.getGreen())/3);
        int adjustedGrayScale = average + (average - 255) * factor;


        int newRed = 2*adjustedGrayScale - currentPixel.getRed();
        if (newRed>255){
          currentPixel.setRed(255);
        } else {
          currentPixel.setRed(newRed);
        }

        int newBlue = 2*adjustedGrayScale - currentPixel.getBlue();
        if (newBlue>255){
          currentPixel.setBlue(255);
        } else {
          currentPixel.setBlue(newBlue);
        }

        int newGreen = 2*adjustedGrayScale - currentPixel.getGreen();
        if (newGreen>255){
          currentPixel.setGreen(255);
        } else {
          currentPixel.setGreen(newGreen);
        }

        
      }
    }


    
  }

  public void adjustContrast(int multiplier) {

    Pixel[][] pixels = getPixelsFromImage();

    for (int r = 0; r<pixels.length; r++){
      for (int c = 0; c<pixels[0].length; c++){
        Pixel currentPixel = pixels[r][c];

        currentPixel.setRed(currentPixel.getRed()*multiplier);
        currentPixel.setBlue(currentPixel.getBlue()*multiplier);
        currentPixel.setGreen(currentPixel.getGreen()*multiplier);

        
      }
    }

    
  }

  public void threshold(int value) {
    Pixel[][] pixels = getPixelsFromImage();

    for (int r = 0; r<pixels.length; r++){
      for (int c = 0; c<pixels[0].length; c++){
        Pixel currentPixel = pixels[r][c];

        int average = (int)(((currentPixel.getRed() + currentPixel.getGreen() + currentPixel.getBlue())/3));

        if (average<value){
          currentPixel.setColor(Color.BLACK);
        } else {
          currentPixel.setColor(Color.WHITE);
      }
      }
    }
  

  
}

  public void makeRio(){
    Pixel[][] pixels = getPixelsFromImage();

    for (int r = 0; r<pixel.length; r++){
      for (int c = 0; c<pixel[0].length; c++){
        Pixel currentPixel = pixels[r][c];

        int newRed = (int) (1.12*currentPixel.getRed() + .08*currentPixel.getGreen() + .04*currentPixel.getBlue());
        int newGreen = (int) (.04*currentPixel.getRed() + 1.08*currentPixel.getGreen() + .04*currentPixel.getBlue());
        int newBlue = (int) (.02*currentPixel.getRed() + .06*currentPixel.getGreen() + .85*currentPixel.getBlue());

        if (newRed>255){
          newRed = 255;
        }
        if (newRed<0){
          newRed = 0;
        }
       if (newGreen>255){
          newGreen = 255;
       }
        if (newGreen<0){
          newGreen = 0;
        }
        if (newBlue>255){
          newBlue = 255;
        }
        if (newBlue<0){
          newBlue = 0;
        }

        currentPixel.setRed(newRed);
        currentPixel.setGreen(newGreen);
        currentPixel.setBlue(newBlue);

        
    
    }


    }    
  }

  
}