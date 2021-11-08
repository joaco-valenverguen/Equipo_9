package game;

import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PFont;
import java.applet.AudioClip;

public class GameSketch extends PApplet {
    Random random = new Random();

    @Override
    public void settings() {
        size(1280, 720);

    }

    int x1 = 0;
    int y1 = -720;
    int x = 0;
    int y = 0;
    int sw = 1;
    int ytext = 28;
    int letras = 13;
    int life = 3;
    int timer;
    int backvel = 20;
    int vel = 10;
    int ancho = 70;
    int largo = 150;
    int anchoanimals = 60;
    int altoanimals = 87;
    int i;
    int z = 0;
    int n = 0;
    int h;
    int cont = 0;
    int yletter = -150;
    int y3 = -1440;
    int y4 = -720;
    int y5 = -720;
    int y6 = -1440;
    int y7 = -2160;
    int y8 = -2880;
    int timer2;
    int timer3 = 1;
    int escena = 1;
    int yletter2 = -260;
    int aux;

    float xcarplayer = random(275, 920);
    float ycarplayer = 520;
    Float xcolision;
    Float ycolision;
    float ybackground2 = -710;

    PImage Background;
    PImage Background1;
    PImage Background2;
    PImage Background3a;
    PImage Background3b;
    PImage Background3c;
    PImage Background3d;
    PImage gameOver;
    PImage boom;
    PImage lobby;
    PImage check;
    PImage retry;
    PImage exit;
    PImage letrero;
    PImage escenario2;
    PImage red;
    PImage letrero2;
    PImage corazon;
    PImage carplayer;

    PFont fuente;

    boolean key = true;
    boolean key2 = true;
    boolean mover = true;
    boolean sound3 = true;
    boolean sound4 = true;
    boolean sound5 = true;
    boolean sound6 = true;
    boolean sound7 = true;
    boolean lanzar;
    boolean contador = true;
    boolean juca = true;

    AudioClip file2;
    AudioClip file;
    AudioClip SoundLobby;
    AudioClip StartRace;
    AudioClip GameOver;
    AudioClip Level2;
    AudioClip Level3;

    String[] rutas = { "Images/cangrejo.png", "Images/caracol.png", "Images/chiguiro.png", "Images/nti.png",
            "Images/gallo.png", "Images/gato_1.png", "Images/gato_2.png", "Images/oveja.png", "Images/panda.png",
            "Images/pato.png", "Images/perro_2.png", "Images/perro.png", "Images/pinguino.png", "Images/zorro_1.png",
            "Images/zorro_2.png" };
    String[] rutasup = { "Images/car_up1.png", "Images/car_up2.png", "Images/car_up3.png", "Images/car_up4.png",
            "Images/car_up5.png", "Images/car_up6.png" };
    String[] rutasdown = { "Images/car_down1.png", "Images/car_down2.png", "Images/car_down3.png",
            "Images/car_down4.png", "Images/car_down5.png", "Images/car_down6.png" };

    PImage[] car_up = new PImage[6];
    PImage[] car_down = new PImage[6];
    PImage[] animals = new PImage[rutas.length];

    boolean[] boleeanarray = { false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, };

    float[] ordenadasderecha = { random(675, 920), random(675, 920), random(675, 920), random(675, 920),
            random(675, 920), random(675, 920) };
    float[] ordenadasizquierda = { random(275, 520), random(275, 520), random(275, 520), random(275, 520),
            random(275, 520), random(275, 520) };
    float[] ordenadasanimales = { random(275, 920), random(275, 920), random(275, 920), random(275, 920),
            random(275, 920), random(275, 920), random(275, 920), random(275, 920), random(275, 920), random(275, 920),
            random(275, 920), random(275, 920), random(275, 920), random(275, 920), random(275, 920) };
    float[] abcisa = { -160, -160, -160, -160, -160, -160 };
    float[] abcisa1 = { -160, -160, -160, -160, -160, -160 };
    float[] abcisa2 = { -87, -87, -87, -87, -87, -87, -87, -87, -87, -87, -87, -87, -87, -87, -87 };

    @Override
    public void setup() {
        this.UpImge();
        background(lobby);
        frameRate(30);

    }

    @Override
    public void draw() {
        timer = millis() / 1000;
        switch (escena) {
        case 1:
            if (sound4 == true) {
                SoundLobby.play();
                sound4 = false;
            }
            this.lobby();
            break;
        case 2:
            SoundLobby.stop();
            if (sound3 == true) {
                StartRace.play();
                sound3 = false;
            }
            if (juca) {
                aux = timer;
                juca = false;
            }
            timer2 = timer - aux;
            if (contador) {
                image(Background, x, y);
                image(carplayer, xcarplayer, ycarplayer);
                filter(BLUR, 5);
                textFont(fuente);
                fill(255, 255, 255);
                textSize(120);
                text(3 - timer2, 600, 360);

            }
            if (timer2 > 3) {
                if (mover == true) {

                    timer3 = timer2 - 4;
                }
                contador = false;
                this.juego();

            }
            break;
        }
    }

    public void UpImge() {

        carplayer = loadImage("Images/Carplayer.png");
        letrero = loadImage("Images/letreroSincelejo.png");
        letrero.resize(200, 200);
        boom = loadImage("Images/boom2.png");
        boom.resize(200, 200);
        red = loadImage("Images/red.png");
        red.resize(200, 200);
        letrero2 = loadImage("Images/letreroCartagena.png");
        letrero2.resize(200, 200);
        corazon = loadImage("Images/heart.png");
        check = loadImage("Images/chulito.png");
        fuente = createFont("PressStart2P.ttf", letras);
        Background = loadImage("Images/Background1.png");
        Background2 = loadImage("Images/Cartagena.png");
        Background3a = loadImage("Images/Barranquilla.png");
        Background3b = loadImage("Images/Barranquilla2.png");
        Background3c = loadImage("Images/Barranquilla3.png");
        Background3d = loadImage("Images/Barranquilla4.png");
        gameOver = loadImage("Images/GameOver.png");
        retry = loadImage("Images/Retry_buttom.png");
        exit = loadImage("Images/Exit_buttom.png");

        file2 = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/export.wav"));
        file = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/export1.wav"));
        lobby = loadImage("Images/lobby.png");
        StartRace = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/StartRace.wav"));
        SoundLobby = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/SoundLobby.wav"));
        GameOver = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/SoundGameOver.wav"));
        Level2 = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/ulala.wav"));
        Level3 = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/songquilla.wav"));
        for (int i = 0; i < rutasup.length; i++) {
            car_up[i] = (loadImage(rutasup[i]));
            car_up[i].resize(ancho, largo);
        }
        for (int j = 0; j < rutasdown.length; j++) {
            car_down[j] = (loadImage(rutasdown[j]));
            car_down[j].resize(ancho, largo);
        }

        for (int i = 0; i < rutas.length; i++) {
            animals[i] = (loadImage(rutas[i]));
            animals[i].resize(60, 87);
        }
    }

    public void lobby() {

        textFont(fuente);
        fill(0, 0, 0);
        textSize(48);
        text("LA COSTA TOUR", 300, 120);
        textSize(24);
        noStroke();
        text("Race", 540, 320);
        text("Free Race", 515, 420);
        text("Garage", 515, 520);
        text("Options", 515, 620);
        text("Credits", 955, 690);
        fill(196, 196, 196, 25);
        rect(500, 280, 250, 50, 0, 24, 0, 72);
        rect(500, 380, 250, 50, 0, 24, 0, 72);
        rect(500, 480, 250, 50, 0, 24, 0, 72);
        rect(500, 580, 250, 50, 0, 24, 0, 72);
        rect(940, 650, 200, 50, 0, 24, 0, 72);
        this.mouseClicked();
    }

    public void juego() {
        timer2 = millis() / 1000;
        if (timer3 == 33) {
            sw = 2;
        }
        if (timer3 == 66) {
            sw = 3;
        }
        if (sw == 1) {
            image(Background, x, y);
            image(Background, x, y1);
            y = y + backvel;
            y1 = y1 + backvel;
            if (y > 720) {
                y = 0;
                y1 = -720;
            }
        } else if (sw == 2) {
            if (sound6 == true) {
                Level2.play();
                sound6 = false;
            }
            if (key) {
                y = 0;
                key = false;
            }
            yletter2 += backvel;
            y = y + backvel;

            image(Background, x, y);
            image(Background2, x, y3);
            image(Background2, x, y4);
            y3 = y3 + backvel;
            y4 = y4 + backvel;
            if (y4 > 720) {
                y4 = 0;
                y3 = -720;
            }

        } else if (sw == 3) {
            if (sound7 == true) {
                Level3.play();
                sound7 = false;
            }
            if (key2) {
                y3 = 0;
                key2 = false;
            }
            if (y3 < 720) {
                y3 = y3 + backvel;
            }
            image(Background2, x, y3);
            image(Background3a, x, y5);
            image(Background3b, x, y6);
            image(Background3c, x, y7);
            image(Background3d, x, y8);
            y5 += backvel;
            y6 += backvel;
            y7 += backvel;
            y8 += backvel;
            if (y8 == 0) {
                y5 = -720;
                y6 = -1440;
                y7 = -2160;
            }
            if (y8 > 720) {
                y8 = -2160;
            }

        }
        image(letrero2, 110, yletter2);
        image(letrero, 110, yletter);
        yletter = yletter + 10;
        this.GenereateAnimals();
        image(animals[n], ordenadasanimales[n], abcisa2[n]);
        image(carplayer, xcarplayer, ycarplayer);
        this.GenerateCars();
        this.texfield();
        this.colisiones();
        if (life == 0) {
            if (sound5 == true) {
                GameOver.play();
                sound5 = false;
            }
            backvel = 0;
            vel = 0;
            mover = false;
            exit.resize(80, 90);
            retry.resize(80, 90);
            image(gameOver, 350, 0);
            image(exit, 540, 330);
            image(retry, 660, 330);

        }
    }

    public void GenerateCars() {

        image(car_down[0], ordenadasizquierda[0], abcisa[0]);
        abcisa[0] = abcisa[0] + vel;

        if (abcisa[0] > 144) {
            image(car_up[0], ordenadasderecha[0], abcisa1[0]);
            abcisa1[0] = abcisa1[0] + vel;
        }

        if (abcisa1[0] > 144) {
            image(car_down[1], ordenadasizquierda[1], abcisa[1]);
            abcisa[1] = abcisa[1] + vel;
        }
        if (abcisa[1] > 144) {
            image(car_up[1], ordenadasderecha[1], abcisa1[1]);
            abcisa1[1] = abcisa1[1] + vel;
        }
        if (abcisa1[1] > 144) {
            image(car_down[2], ordenadasizquierda[2], abcisa[2]);
            abcisa[2] = abcisa[2] + vel;
        }
        if (abcisa[2] > 144) {
            image(car_up[2], ordenadasderecha[2], abcisa1[2]);
            abcisa1[2] = abcisa1[2] + vel;
        }
        if (abcisa1[2] > 144) {
            image(car_down[3], ordenadasizquierda[3], abcisa[3]);
            abcisa[3] = abcisa[3] + vel;
        }
        if (abcisa[3] > 144) {
            image(car_up[3], ordenadasderecha[3], abcisa1[3]);
            abcisa1[3] = abcisa1[3] + vel;
        }
        if (abcisa1[3] > 144) {
            image(car_down[4], ordenadasizquierda[4], abcisa[4]);
            abcisa[4] = abcisa[4] + vel;
        }
        if (abcisa[4] > 144) {
            image(car_up[4], ordenadasderecha[4], abcisa1[4]);
            abcisa1[4] = abcisa1[4] + vel;
        }
        if (abcisa1[4] > 144) {
            image(car_down[5], ordenadasizquierda[5], abcisa[5]);
            abcisa[5] = abcisa[5] + vel;
        }
        if (abcisa[5] > 144) {
            image(car_up[5], ordenadasderecha[5], abcisa1[5]);
            abcisa1[5] = abcisa1[5] + vel;
        }
        if (abcisa1[5] > 720) {
            for (int i = 0; i <= 5; i++) {
                abcisa1[i] = -160;
                abcisa[i] = -160;
            }
        }
    }

    public void GenereateAnimals() {
        boleeanarray[n] = true;
        if (boleeanarray[n]) {
            if (abcisa2[n] < 720) {
                this.validacion();
                abcisa2[n] = abcisa2[n] + vel;
            } else {
                n = n + 1;
            }
            if (n > 14) {
                n = 0;
                for (int i = 0; i <= 14; i++) {
                    abcisa2[i] = -87;
                }
            }
        }
    }

    public void colisiones() {
        for (int h = 0; h <= 5; h++) {
            if (xcarplayer > ordenadasizquierda[h] + ancho) {

            } else if (xcarplayer + ancho < ordenadasizquierda[h]) {

            } else if (ycarplayer > abcisa[h] + largo) {

            } else if (ycarplayer + largo < abcisa[h]) {

            } else {
                file2.play();
                life = life - 1;
                xcolision = ordenadasizquierda[h];
                ycolision = abcisa[h];
                if (ycolision <= 558) {
                    image(boom, xcolision, ycolision);
                } else if (ycolision > 558) {
                    image(boom, xcolision, ycolision - 100);
                }
                abcisa[h] = 720;
                xcarplayer = 600;
            }
            if (xcarplayer > ordenadasderecha[h] + ancho) {

            } else if (xcarplayer + ancho < ordenadasderecha[h]) {

            } else if (ycarplayer > abcisa1[h] + largo) {

            } else if (ycarplayer + largo < abcisa1[h]) {

            } else {
                file2.play();
                life = life - 1;
                xcolision = ordenadasderecha[h];
                ycolision = abcisa1[h];
                if (ycolision <= 558) {
                    image(boom, xcolision, ycolision);
                } else if (ycolision > 558) {
                    image(boom, xcolision, ycolision - 100);
                }
                abcisa1[h] = 720;
                xcarplayer = 600;
            }
        }
    }

    public void texfield() {
        Float distancia = (vel * (float) timer3) / 100;
        Float score = (distancia + timer3) * 2;
        corazon.resize(24, 23);
        check.resize(32, 32);
        image(corazon, 1089, ytext - 19);
        if (timer3 >= 33) {
            image(check, 1233, ytext * 19);
        }
        if (timer3 >= 66) {
            image(check, 1233, ytext * 20);
        }
        if (timer3 >= 99) {
            image(check, 1233, ytext * 21);
        }
        textFont(fuente);
        fill(255, 255, 255);
        text(life + "P", 1055, ytext);
        text("Distancia:", 1055, ytext * 5);
        text(distancia + "km", 1055, ytext * 6);
        text("Tiempo:", 1055, ytext * 10);
        text(timer3 + "s", 1055, ytext * 11);
        text("Puntaje:", 1055, ytext * 15);
        text(score + " pts.", 1055, ytext * 16);
        text("Sincelejo    [ ]", 1055, ytext * 20);
        text("Cartagena    [ ]", 1055, ytext * 21);
        text("Barranquilla [ ]", 1055, ytext * 22);

    }

    public void fingame() {
        if (timer == 100 || life == 0) {
            xcarplayer = random(275, 920);
            ycarplayer = 520;
            life = 3;
            cont = 0;
        }
    }

    @Override
    public void keyPressed() {
        if (mover == true) {

            if (keyPressed == true) {
                if (keyCode == RIGHT) {
                    if (xcarplayer < 920) {
                        xcarplayer = xcarplayer + 30;
                    }
                }
                if (keyCode == LEFT) {
                    if (xcarplayer > 275) {
                        xcarplayer = xcarplayer - 30;
                    }
                }
                if (keyCode == UP) {

                    for (int h = 0; h <= 14; h++) {

                        if (xcarplayer > ordenadasanimales[h] + anchoanimals) {

                        } else if (xcarplayer + ancho < ordenadasanimales[h]) {

                        } else if (ycarplayer > abcisa2[h] + altoanimals) {

                        } else if (ycarplayer + largo < abcisa2[h]) {

                        } else {
                            cont = cont + 1;
                            if (cont % 2 == 0) {
                                life++;
                                file.play();
                            }
                            xcolision = ordenadasanimales[h] - 100;
                            ycolision = abcisa2[h];

                            if (ycolision <= 564) {
                                image(red, xcolision, ycolision);
                            } else if (ycolision > 564) {
                                image(red, xcolision, ycolision - 100);
                            }
                            abcisa2[h] = 720;
                        }
                    }

                }
            }
        }
    }

    int xd;

    public void validacion() {
        for (int i = 0; i < rutasdown.length; i++) {
            for (int h = 0; h < ordenadasanimales.length; h++) {
                if (ordenadasanimales[h] + 30 > ordenadasizquierda[i] + ancho) {

                } else if (ordenadasanimales[h] + anchoanimals + 30 < ordenadasizquierda[i]) {

                } else if (abcisa2[h] + 30 > abcisa[i] + largo) {

                } else if (abcisa2[h] + altoanimals + 30 < abcisa[i]) {

                } else {

                    abcisa2[h] = 0;

                }
                if (ordenadasanimales[h] + 30 > ordenadasderecha[i] + ancho) {

                } else if (ordenadasanimales[h] + anchoanimals + 30 < ordenadasderecha[i]) {

                } else if (abcisa2[h] + 30 > abcisa1[i] + largo) {

                } else if (abcisa2[h] + altoanimals + 30 < abcisa1[i]) {

                } else {
                    abcisa2[h] = 0;
                }

            }
        }
    }

    public void mouseClicked() {
        if (mousePressed == true) {
            if (mouseButton == LEFT) {
                if (mouseX > 500 && mouseX < 500 + 250) {
                    if (mouseY > 280 && mouseY < 280 + 50) {
                        escena = 2;
                    }

                }
            }

        }
    }

    public void run() {
        String[] processingArgs = { this.getClass().getName() };
        PApplet.runSketch(processingArgs, this);
    }
}
