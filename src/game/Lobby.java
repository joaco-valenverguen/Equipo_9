package game;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PFont;
import java.applet.AudioClip;

public class Lobby {
    PApplet sketch;
    boolean SaveSounds = true;
    boolean sound4 = true;
    AudioClip SoundLobby;
    PImage lobby;
    PFont fuente;
    int letras = 13;

    Lobby(PApplet sketch) {
        SoundLobby = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/SoundLobby.wav"));
        this.sketch = sketch;

    }

    public void upFiles(PFont fuente) {
        this.fuente = sketch.createFont("PressStart2P.ttf", letras);
        // this.fuente = fuente;
        this.lobby = sketch.loadImage("Images/lobby.png");

    }

    public void run() {
        if (SaveSounds) {
            if (sound4 == true) {
                SoundLobby.play();
                sound4 = false;
            }
        } else {
            SoundLobby.stop();
        }

        sketch.background(lobby);
        sketch.fill(196, 196, 196, 300);
        sketch.rect(500, 280, 250, 50, 0, 24, 0, 72);
        sketch.rect(500, 380, 250, 50, 0, 24, 0, 72);
        sketch.rect(500, 480, 250, 50, 0, 24, 0, 72);
        sketch.rect(500, 580, 250, 50, 0, 24, 0, 72);
        sketch.rect(940, 650, 200, 50, 0, 24, 0, 72);
        sketch.textFont(fuente);
        sketch.fill(0, 0, 0);
        sketch.textSize(48);
        sketch.text("LA COSTA TOUR", 300, 120);
        sketch.textSize(24);
        sketch.noStroke();
        sketch.text("CARRERA", 540, 320);
        sketch.text("FREE RACE", 515, 420);
        sketch.text("GARAGE", 550, 520);
        sketch.text("OPCIONES", 530, 620);
        sketch.text("CREDITOS", 945, 690);
        sketch.mouseClicked();
    }
}