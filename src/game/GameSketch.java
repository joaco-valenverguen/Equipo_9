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

    int timeacu = 0;
    int xcarta = 400;
    int ycarta = 100;
    int x1 = 0;
    int x = 0;
    int sw = 1;
    int ytext = 28;
    int letras = 13;
    int life = 3;
    int timer;
    int ancho = 70;
    int largo = 150;
    int anchoanimals = 60;
    int altoanimals = 87;
    int i;
    int z = 0;
    int n = 0;
    int h;
    int cont1 = 0;
    int yletter = -200;
    int timer2;
    int timer3 = 1;
    int escena = 1;
    int yletter2 = -200;
    int aux;
    int cont;
    int m;
    int velsings = 7;
    int yletter3 = -200;
    int ylinemeta = -83;
    int xmarco = -400;
    int ymarco = -400;
    float y = 0;
    float backvel = 20;
    float vel = 10;
    float y1 = -720;
    float y3 = -1440;
    float y4 = -720;
    float y5 = -720;
    float y6 = -1440;
    float y7 = -2160;
    float y8 = -2880;
    float xcarplayer = 600;
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
    PImage welcome;
    PImage garage;
    PImage Background2b;
    PFont fuente;
    PImage letrero3;
    PImage line_meta;
    PImage youwin;
    PImage marco;
    boolean key = true;
    boolean key2 = true;
    boolean key3 = true;
    boolean key4 = true;
    boolean key5 = true;
    boolean key6 = true;
    boolean key7 = true;
    boolean mover = true;
    boolean sound3 = true;
    boolean sound4 = true;
    boolean sound5 = true;
    boolean sound6 = true;
    boolean sound7 = true;
    boolean lanzar;
    boolean contador = true;
    boolean velocimetro = true;
    boolean sound8 = true;
    boolean key8 = true;
    boolean confirmar = false;

    AudioClip soundBomm;
    AudioClip soundExtraLife;
    AudioClip SoundLobby;
    AudioClip StartRace;
    AudioClip GameOver;
    AudioClip Level2;
    AudioClip Level3;
    AudioClip level1;

    String[] rutas_carplayers = { "Images/carplayer_orange.png", "Images/carplayer_blue.png",
            "Images/carplayer_yellow.png", "Images/carplayer_red.png", "Images/carplayer_purple.png",
            "Images/carplayer_white.png", "Images/carplayer_green.png", "Images/carplayer_vinotinte.png",
            "Images/carplayer_lightblue.png" };
    String[] rutasShuffle = { "Images/cangrejo.png", "Images/caracol.png", "Images/chiguiro.png", "Images/nti.png",
            "Images/gallo.png", "Images/gato_1.png", "Images/gato_2.png", "Images/oveja.png", "Images/panda.png",
            "Images/pato.png", "Images/perro_2.png", "Images/perro.png", "Images/pinguino.png", "Images/zorro_1.png",
            "Images/zorro_2.png" };
    String[] rutas = new String[rutasShuffle.length];
    String[] rutasupShuffle = { "Images/car_up1.png", "Images/car_up2.png", "Images/car_up3.png", "Images/car_up4.png",
            "Images/car_up5.png", "Images/car_up6.png" };
    String[] rutasup = new String[rutasupShuffle.length];
    String[] rutasdownShuffle = { "Images/car_down1.png", "Images/car_down2.png", "Images/car_down3.png",
            "Images/car_down4.png", "Images/car_down5.png", "Images/car_down6.png" };
    String[] rutasdown = new String[rutasdownShuffle.length];

    PImage[] car_up = new PImage[6];
    PImage[] car_down = new PImage[6];
    PImage[] animals = new PImage[rutas.length];
    PImage[] carplayers = new PImage[9];

    boolean colision;
    boolean[] boleeanarray = { false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, };
    int[] contadores = new int[15];
    float[] ordenadasderecha = { random(600, 920), random(600, 920), random(600, 920), random(600, 920),
            random(600, 920), random(600, 920) };
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
        this.shuffle(rutasShuffle, rutas);
        this.shuffle(rutasupShuffle, rutasup);
        this.shuffle(rutasdownShuffle, rutasdown);
        this.upFiles();
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
            carplayers[m].resize(ancho, largo);
            SoundLobby.stop();
            if (sound3 == true) {
                StartRace.play();
                sound3 = false;
            }
            if (key4) {
                aux = timer;
                key4 = false;
            }
            timer2 = timer - aux - timeacu;
            if (contador) {
                image(Background, x, y);
                image(carplayers[m], xcarplayer, ycarplayer);
                filter(BLUR, 5);
                textFont(fuente);
                fill(255, 255, 255);
                textSize(120);
                text(3 - timer2, 600, 360);
            }
            if (timer2 > 3) {
                if (mover == true) {

                    timer3 = timer2 - 3;
                }
                contador = false;

                this.game();
            }
            break;
        case 3:
            this.garage();
            break;
        }
    }

    public void upFiles() {
        // carplayer = loadImage("Images/Carplayer.png");
        letrero = loadImage("Images/letreroSincelejo.png");
        letrero.resize(200, 200);
        boom = loadImage("Images/boom2.png");
        boom.resize(200, 200);
        red = loadImage("images/red.png");
        red.resize(200, 200);
        letrero2 = loadImage("Images/letreroCartagena.png");
        letrero2.resize(200, 200);
        letrero3 = loadImage("Images/quillasing.png");
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
        welcome = loadImage("Images/welcome2.png");
        lobby = loadImage("Images/lobby.png");
        garage = loadImage("Images/garage1.png");
        Background2b = loadImage("Images/cartacho.png");
        line_meta = loadImage("Images/Line_meta.png");
        youwin = loadImage("Images/Youwin.png");
        marco = loadImage("Images/marco.png");
        marco.resize(74, 73);
        soundBomm = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/export.wav"));
        soundExtraLife = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/export1.wav"));
        StartRace = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/StartRace.wav"));
        SoundLobby = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/SoundLobby.wav"));
        GameOver = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/SoundGameOver.wav"));
        Level2 = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/ulala.wav"));
        Level3 = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/songquilla.wav"));
        level1 = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/soundlevel1.wav"));
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
        for (int i = 0; i < rutas_carplayers.length; i++) {
            carplayers[i] = loadImage(rutas_carplayers[i]);

        }
    }

    public void lobby() {

        background(lobby);
        fill(196, 196, 196, 300);
        rect(500, 280, 250, 50, 0, 24, 0, 72);
        rect(500, 380, 250, 50, 0, 24, 0, 72);
        rect(500, 480, 250, 50, 0, 24, 0, 72);
        rect(500, 580, 250, 50, 0, 24, 0, 72);
        rect(940, 650, 200, 50, 0, 24, 0, 72);
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
        this.mouseClicked();
    }

    public void garage() {
        background(garage);

        {
            fill(255, 255, 255);
            rect(103, 73, 72, 29);
        }
        {
            fill(255, 255, 255);
            triangle(103, 63, 103, 112, 57, 88);
        }
        {
            fill(255, 255, 255);
            rect(800, 550, 260, 60, 8);
        }
        {
            fill(0, 0, 0);
            textFont(fuente);
            textSize(letras + 15);
            text("SAVE", 876, 595);
        }
        fill(204, 102, 0);
        square(800, 250, 60);

        fill(0, 12, 255);
        square(900, 250, 60);

        fill(251, 255, 0);
        square(1000, 250, 60);

        fill(255, 0, 0);
        square(800, 350, 60);

        fill(139, 0, 255);
        square(900, 350, 60);

        fill(255, 255, 255);
        square(1000, 350, 60);

        fill(37, 159, 1);
        square(800, 450, 60);

        fill(156, 0, 0);
        square(900, 450, 60);

        fill(0, 229, 159);
        square(1000, 450, 60);

        if (mousePressed == true) {
            if (mouseButton == LEFT) {
                if (mouseX > 800 && mouseX < 860) {
                    if (mouseY > 250 && mouseY < 310) {
                        m = 0;
                        xmarco = 793;
                        ymarco = 243;
                    }
                }
                if (mouseX > 900 && mouseX < 960) {
                    if (mouseY > 250 && mouseY < 310) {
                        m = 1;
                        xmarco = 893;
                        ymarco = 243;
                    }

                }
                if (mouseX > 1000 && mouseX < 1060) {
                    if (mouseY > 250 && mouseY < 310) {
                        m = 2;
                        xmarco = 993;
                        ymarco = 243;
                    }
                }
                if (mouseX > 800 && mouseX < 860) {
                    if (mouseY > 350 && mouseY < 410) {
                        m = 3;
                        xmarco = 793;
                        ymarco = 343;
                    }
                }
                if (mouseX > 900 && mouseX < 960) {
                    if (mouseY > 350 && mouseY < 410) {
                        m = 4;
                        xmarco = 893;
                        ymarco = 343;
                    }
                }
                if (mouseX > 1000 && mouseX < 1060) {
                    if (mouseY > 350 && mouseY < 410) {
                        m = 5;
                        xmarco = 993;
                        ymarco = 343;
                    }
                }
                if (mouseX > 800 && mouseX < 860) {
                    if (mouseY > 450 && mouseY < 510) {
                        m = 6;
                        xmarco = 793;
                        ymarco = 443;
                    }
                }
                if (mouseX > 900 && mouseX < 960) {
                    if (mouseY > 450 && mouseY < 510) {
                        m = 7;
                        xmarco = 893;
                        ymarco = 443;
                    }
                }
                if (mouseX > 1000 && mouseX < 1060) {
                    if (mouseY > 450 && mouseY < 510) {
                        m = 8;
                        xmarco = 993;
                        ymarco = 443;
                    }
                }
                if (mouseX > 57 && mouseX < 186) {
                    if (mouseY > 73 && mouseY < 102) {
                        escena = 1;
                    }
                }
                if (mouseX > 800 && mouseX < 1060) {
                    if (mouseY > 550 && mouseY < 610) {
                        confirmar = true;
                        escena = 1;

                    }
                }
            }
        }
        carplayers[m].resize(160, 281);
        image(carplayers[m], 202, 270);
        image(marco, xmarco, ymarco);
    }

    public void game() {

        if (!confirmar) {
            m = 0;
        }
        key3 = true;
        if (timer3 % 20 == 0) {
            if (velocimetro == true) {
                vel = vel + 5;
                backvel = backvel + 5;
                velocimetro = false;
            }
        } else {
            velocimetro = true;
        }

        if (timer3 == 33) {
            sw = 2;
        }
        if (timer3 == 66) {
            sw = 3;
        }
        if (sw == 1) {
            if (sound8 == true) {
                level1.play();
                sound8 = false;
            }
            image(Background, x, y);
            image(Background, x, y1);
            y = y + backvel;
            y1 = y1 + backvel;
            if (y > 720) {
                y = 0;
                y1 = -720;
            }
            // if (timer3 > 1 && timer3 < 4) {
            // fill(255, 255, 255);
            // textSize(50);
            // text(" WELCOME \n TO \n SINCELEJO", xcarta, ycarta);
            // // image(welcome, xcarta, ycarta);
            // }
            image(letrero, 150, yletter);
            yletter += velsings;
        } else if (sw == 2) {
            level1.stop();
            if (sound6 == true) {
                Level2.play();
                sound6 = false;
            }
            if (key) {
                y = 0;
                key = false;
            }
            y = y + backvel;
            image(Background, x, y);
            image(Background2, x, y3);
            image(Background2b, x, y4);
            y3 = y3 + backvel;
            y4 = y4 + backvel;
            if (y3 > 720) {
                y3 = -720;
            }
            if (y4 > 720) {
                y4 = -720;
            }
            image(letrero2, 150, yletter2);
            yletter2 += velsings;

        } else if (sw == 3) {
            Level2.stop();
            if (sound7 == true) {
                Level3.play();
                sound7 = false;
            }
            if (key2) {
                if (y3 > 0) {
                    y4 = y3 - 720;

                }
                if (y4 > 0) {
                    y3 = y4 - 720;

                }
                key2 = false;
            }
            if (y4 < 720) {
                y4 = y4 + backvel;
            }
            if (y3 < 720) {
                y3 = y3 + backvel;
            }
            image(Background2b, x, y4);
            image(Background3a, x, y5);
            image(Background3b, x, y6);
            image(Background3c, x, y7);
            image(Background3d, x, y8);
            y5 += backvel;
            y6 += backvel;
            y7 += backvel;
            y8 += backvel;
            if (y7 > 720) {
                y5 = -720;
                y6 = -1440;
                y7 = -2160;
            }
            if (y8 > 720) {
                y8 = -2160;
            }
            image(letrero3, 150, yletter3);
            yletter3 += velsings;
            if (timer3 > 99) {
                ylinemeta += backvel;
                image(line_meta, 275, ylinemeta);
            }

        }

        this.genereateAnimals();
        image(animals[n], ordenadasanimales[n], abcisa2[n]);

        image(carplayers[m], xcarplayer, ycarplayer);

        this.generateCars();
        this.texField();
        this.crash();
        // if (life == 0) {
        // if(key3 == true){

        // acu += timer3;
        // }
        // if (sound5 == true) {
        // GameOver.play();
        // sound5 = false;
        // }
        // backvel = 0;
        // vel = 0;
        // mover = false;
        // exit.resize(80, 90);
        // retry.resize(80, 90);
        // image(gameOver, 350, 0);
        // image(exit, 540, 330);
        // image(retry, 660, 330);

        // }

        // if (timer3 > 33 && timer3 < 36) {
        // fill(255, 255, 255);
        // textSize(50);
        // text(" WELCOME \n TO \n CARTAGENA", xcarta, ycarta);
        // // image(welcome, xcarta, ycarta);
        // }
        if (timer3 > 98) {
            ylinemeta += backvel;
            image(line_meta, 275, ylinemeta);

        }
        if (timer3 == 100) {
            backvel = 0;
            vel = 0;
        }

    }

    public void generateCars() {

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
            for (int i = 0; i < ordenadasderecha.length; i++) {
                ordenadasderecha[i] = random(600, 920);
                ordenadasizquierda[i] = random(275, 520);
            }
            for (int i = 0; i <= 5; i++) {
                abcisa1[i] = -160;
                abcisa[i] = -160;
            }
        }
    }

    public void genereateAnimals() {
        if (n > 0) {
            while (ordenadasanimales[n] > ordenadasanimales[n - 1] - 50
                    && ordenadasanimales[n] < ordenadasanimales[n - 1] + 50) {
                ordenadasanimales[n] = random(275, 920);
            }
        }
        this.validacion();
        if (contadores[n] == 12) {
            if (abcisa2[n] < 720) {
                abcisa2[n] = abcisa2[n] + vel;
            } else {
                n = n + 1;
            }
        }
        if (n > 14) {
            n = 0;
            for (int i = 0; i <= 14; i++) {
                abcisa2[i] = -87;
            }
        }

    }

    public void crash() {
        for (int h = 0; h <= 5; h++) {
            if (xcarplayer > ordenadasizquierda[h] + ancho) {

            } else if (xcarplayer + ancho < ordenadasizquierda[h]) {

            } else if (ycarplayer > abcisa[h] + largo) {

            } else if (ycarplayer + largo < abcisa[h]) {

            } else {
                soundBomm.play();
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
                soundBomm.play();
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

    public void texField() {
        Float distancia = (vel * (float) timer3) / 100;
        Float score = (distancia + timer3) * 2;
        corazon.resize(24, 23);
        check.resize(32, 32);
        image(corazon, 1092, ytext - 19);
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
        text("Distancia:", 1055, ytext * 4);
        text(distancia + " km", 1055, ytext * 5);
        text("Velocidad:", 1055, ytext * 8);
        text(vel + " km/h", 1055, ytext * 9);
        text("Tiempo:", 1055, ytext * 12);
        text(timer3 + " s", 1055, ytext * 13);
        text("Puntaje:", 1055, ytext * 16);
        text(score + " pts.", 1055, ytext * 17);
        text("Sincelejo    [ ]", 1055, ytext * 20);
        text("Cartagena    [ ]", 1055, ytext * 21);
        text("Barranquilla [ ]", 1055, ytext * 22);

    }

    public void endGame() {

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
                        xcarplayer = xcarplayer + 50;
                    }
                }
                if (keyCode == LEFT) {
                    if (xcarplayer > 275) {
                        xcarplayer = xcarplayer - 50;
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
                                soundExtraLife.play();
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

    public void validacion() {
        for (int h = 0; h < ordenadasanimales.length; h++) {
            cont1 = 0;
            for (int i = 0; i < ordenadasderecha.length; i++) {
                if (ordenadasanimales[h] + 30 > ordenadasizquierda[i] + ancho) {
                    cont1 += 1;
                } else if (ordenadasanimales[h] + anchoanimals + 30 < ordenadasizquierda[i]) {
                    cont1 += 1;
                } else if (abcisa2[h] + 30 > abcisa[i] + largo) {
                    cont1 += 1;
                } else if (abcisa2[h] + altoanimals + 30 < abcisa[i]) {
                    cont1 += 1;
                } else {

                }
                if (ordenadasanimales[h] + 30 > ordenadasderecha[i] + ancho) {
                    cont1 += 1;
                } else if (ordenadasanimales[h] + anchoanimals + 30 < ordenadasderecha[i]) {
                    cont1 += 1;
                } else if (abcisa2[h] + 30 > abcisa1[i] + largo) {
                    cont1 += 1;
                } else if (abcisa2[h] + altoanimals + 30 < abcisa1[i]) {
                    cont1 += 1;
                } else {

                }
            }
            contadores[h] = cont1;
        }

    }

    public void mouseClicked() {
        if (mousePressed == true) {
            if (mouseButton == LEFT) {
                if (sw == 1) {
                    if (mouseX > 500 && mouseX < 500 + 250) {
                        if (mouseY > 280 && mouseY < 280 + 50) {
                            escena = 2;

                        }
                    }
                    if (mouseX > 500 && mouseX < 500 + 250) {
                        if (mouseY > 480 && mouseY < 480 + 50) {
                            escena = 3;
                        }
                    }
                }
                if (sw == 2) {
                    if (mover == false) {
                        if ((mouseX > 540 && mouseX < 540 + 80) && (mouseY > 330 && mouseY < 330 + 90)) {
                            if (key6 == true) {
                                this.exiting();
                                key6 = false;
                            }
                        }
                        if ((mouseX > 660 && mouseX < 660 + 80) && (mouseY > 330 && mouseY < 330 + 90)) {
                            if (key7 == true) {
                                this.retrying();
                                key7 = false;
                            }

                        }
                    }
                }

            }

        }

    }

    public void exiting() {
        escena = 1;
        sw = 1;
    }

    public void retrying() {
        escena = 2;
        y = 0;
        backvel = 20;
        vel = 10;
        y1 = -720;
        y3 = -1440;
        y4 = -720;
        y5 = -720;
        y6 = -1440;
        y7 = -2160;
        y8 = -2880;
        xcarplayer = 600;
        ycarplayer = 520;
        ybackground2 = -710;
        key = true;
        key2 = true;
        key3 = true;
        mover = true;
        sound3 = true;
        sound4 = true;
        sound5 = true;
        sound6 = true;
        sound7 = true;
        if (key5 == true) {
            this.shuffle(rutasShuffle, rutas);
            this.shuffle(rutasupShuffle, rutasup);
            this.shuffle(rutasdownShuffle, rutasdown);
        }

    }

    public void shuffle(String[] array, String[] salida) {
        boolean hacer = false;
        int d = 0;
        Random random = new Random();
        String[] rutasx = new String[array.length];

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
    }

    public void run() {
        String[] processingArgs = { this.getClass().getName() };
        PApplet.runSketch(processingArgs, this);
    }
}
