package game;

import processing.core.PApplet;
import processing.core.PImage;
import java.util.Random;

import javax.sound.sampled.SourceDataLine;

public class Acciones {
    PApplet sketch;
    Acciones(PApplet sketch) {
        this.sketch = sketch;
    }

    Random random = new Random();
    int XD = 1;

    public void shuffle(PImage[] array, PImage[] salida) {
        boolean hacer = false;
        int d = 0;

        while (salida[array.length - 1] == null) {
            int s = random.nextInt(array.length);
            for (int j = 0; j < d; j++) {
                if (array[s].equals(salida[j])) {
                    hacer = true;
                }
            }
            if (hacer == false) {
                salida[d] = array[s];
                d++;
            }
            hacer = false;
        }
        XD++;
    }

    

   

}