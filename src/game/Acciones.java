package game;

import processing.core.PApplet;
import processing.core.PImage;

public class Acciones {
    PApplet sketch;
    PImage[] car_down;
    PImage[]car_up;
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

    Acciones(PApplet sketch, PImage[] car_down, PImage[] car_up, float[] ordenadasizquierda, float[] ordenadasderecha,
            float[] abcisa, float[] abcisa1, int vel,String[] rutasup, String[] rutasdown, String[] rutas, PImage[] animals, int ancho, int largo) {
        this.sketch = sketch;
        this.car_down=car_down;
        this.car_up = car_up;
        this.ordenadasizquierda = ordenadasizquierda;
        this.ordenadasderecha = ordenadasderecha;
        this.abcisa = abcisa;
        this.abcisa1=abcisa1;
        this.vel = vel;
        this.rutasup = rutasup;
        this.rutasdown = rutasdown;
        this.rutas = rutas;
        this.animals = animals;
        this.ancho = ancho;
        this.largo = largo;
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