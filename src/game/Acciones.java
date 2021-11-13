package game;

import processing.core.PApplet;
import processing.core.PImage;
import java.util.Random;

import javax.sound.sampled.SourceDataLine;

public class Acciones {
    PApplet sketch;
    PImage[] car_down;
    PImage[] car_up;
    float[] ordenadasizquierda;
    float[] ordenadasderecha;
    float[] abcisa;
    float[] abcisa1;
    int vel;
    PImage carplayer;
    PImage letrero;
    PImage boom;
    String[] rutasup;
    String[] rutasdown;
    String[] rutas;
    PImage[] animals;
    int ancho;
    int largo;

    Acciones(PApplet sketch) {
        this.sketch = sketch;
    }

    public void GenerateCars() {

        this.sketch.image(this.car_down[0], this.ordenadasizquierda[0], this.abcisa[0]);
        this.abcisa[0] = this.abcisa[0] + this.vel;

        if (this.abcisa[0] > 144) {
            this.sketch.image(this.car_up[0], this.ordenadasderecha[0], this.abcisa1[0]);
            this.abcisa1[0] = this.abcisa1[0] + this.vel;
        }

        if (this.abcisa1[0] > 144) {
            this.sketch.image(this.car_down[1], this.ordenadasizquierda[1], this.abcisa[1]);
            this.abcisa[1] = this.abcisa[1] + this.vel;
        }
        if (this.abcisa[1] > 144) {
            this.sketch.image(this.car_up[1], this.ordenadasderecha[1], this.abcisa1[1]);
            this.abcisa1[1] = this.abcisa1[1] + this.vel;
        }
        if (this.abcisa1[1] > 144) {
            this.sketch.image(this.car_down[2], this.ordenadasizquierda[2], this.abcisa[2]);
            this.abcisa[2] = this.abcisa[2] + this.vel;
        }
        if (this.abcisa[2] > 144) {
            this.sketch.image(this.car_up[2], this.ordenadasderecha[2], this.abcisa1[2]);
            this.abcisa1[2] = this.abcisa1[2] + this.vel;
        }
        if (this.abcisa1[2] > 144) {
            this.sketch.image(this.car_down[3], this.ordenadasizquierda[3], this.abcisa[3]);
            this.abcisa[3] = this.abcisa[3] + this.vel;
        }
        if (this.abcisa[3] > 144) {
            this.sketch.image(this.car_up[3], this.ordenadasderecha[3], this.abcisa1[3]);
            this.abcisa1[3] = this.abcisa1[3] + this.vel;
        }
        if (this.abcisa1[3] > 144) {
            this.sketch.image(this.car_down[4], this.ordenadasizquierda[4], this.abcisa[4]);
            this.abcisa[4] = this.abcisa[4] + this.vel;
        }
        if (this.abcisa[4] > 144) {
            this.sketch.image(this.car_up[4], this.ordenadasderecha[4], this.abcisa1[4]);
            this.abcisa1[4] = this.abcisa1[4] + this.vel;
        }
        if (this.abcisa1[4] > 144) {
            this.sketch.image(this.car_down[5], this.ordenadasizquierda[5], this.abcisa[5]);
            this.abcisa[5] = this.abcisa[5] + this.vel;
        }
        if (this.abcisa[5] > 144) {
            this.sketch.image(this.car_up[5], this.ordenadasderecha[5], this.abcisa1[5]);
            this.abcisa1[5] = this.abcisa1[5] + this.vel;
        }
        if (this.abcisa1[5] > 720) {
            for (int i = 0; i <= 5; i++) {
                this.abcisa1[i] = -160;
                this.abcisa[i] = -160;
            }
        }

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

    // public void lobby() {

    // sketch.background(sketch.lobby);
    // sketch.fill(196, 196, 196, 300);
    // sketch.rect(500, 280, 250, 50, 0, 24, 0, 72);
    // sketch.rect(500, 380, 250, 50, 0, 24, 0, 72);
    // sketch.rect(500, 480, 250, 50, 0, 24, 0, 72);
    // sketch.rect(500, 580, 250, 50, 0, 24, 0, 72);
    // sketch.rect(940, 650, 200, 50, 0, 24, 0, 72);
    // sketch.textFont(sketch.fuente);
    // sketch.fill(0, 0, 0);
    // sketch.textSize(48);
    // sketch.text("LA COSTA TOUR", 300, 120);
    // sketch.textSize(24);
    // sketch.noStroke();
    // sketch.text("CARRERA", 540, 320);
    // sketch.text("FREE RACE", 515, 420);
    // sketch.text("GARAGE", 550, 520);
    // sketch.text("OPCIONES", 530, 620);
    // sketch.text("CREDITOS", 945, 690);
    // sketch.mouseClicked();
    // }

    public void UpImge() {
        this.carplayer = this.sketch.loadImage("images/Carplayer.png");
        this.letrero = this.sketch.loadImage("images/Group1.png");
        this.letrero.resize(200, 150);
        this.boom = this.sketch.loadImage("images/boom2.png");
        this.boom.resize(200, 200);
        this.boom = this.sketch.loadImage("images/red.png");
        this.boom.resize(200, 200);

        for (int i = 0; i < this.rutasup.length; i++) {
            this.car_up[i] = (this.sketch.loadImage(this.rutasup[i]));
            this.car_up[i].resize(this.ancho, this.largo);
        }
        for (int j = 0; j < rutasdown.length; j++) {
            this.car_down[j] = (this.sketch.loadImage(this.rutasdown[j]));
            this.car_down[j].resize(this.ancho, this.largo);
        }

        for (int i = 0; i < rutas.length; i++) {
            this.animals[i] = (this.sketch.loadImage(this.rutas[i]));
            this.animals[i].resize(60, 87);
        }
    }

}