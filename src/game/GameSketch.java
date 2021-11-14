package game;

import java.util.Random;

import javax.imageio.event.IIOWriteWarningListener;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PFont;
import java.applet.AudioClip;

public class GameSketch extends PApplet {
    Acciones acciones = new Acciones(this);
    Random random = new Random();

    @Override
    public void settings() {
        size(1280, 720);

    }

    int swFR;
    int xmarco4 = -300;
    int ymarco4 = -300;
    int ymarco3 = 503;
    int xmarco3 = 565;
    int ymarco2 = 281;
    int xmarco2 = 465;
    int timeacu = 0;
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
    int auxGarage = 0;
    int subescena = 1;

    float y2 = 0;
    float y = 0;
    float backvel = 20;
    float vel = 10;
    float dificultad = 5;
    float saveDificultad = 5;
    float y1 = -720;
    float y3 = -1440;
    float y4 = -720;
    float y4sw = -720;
    float ysw = 0;
    float y1sw = -720;
    float y5sw = 0;
    float y6sw = -720;
    float y7sw = -1440;
    float y8sw = -2160;
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
    PImage garage;
    PImage Background2b;
    PFont fuente;
    PImage letrero3;
    PImage line_meta;
    PImage youwin;
    PImage marco;
    PImage creditos1;
    PImage creditos2;
    PImage instrucciones1;
    PImage options;
    PImage marco2;
    PImage marco3;
    PImage marco4;
    PImage chooseMaps;
    PImage instrucciones2;
    PImage escenarioFR1;

    boolean key1 = true;
    boolean key2 = true;
    boolean key3 = true;
    boolean key4 = true;
    boolean key5 = true;
    boolean key6 = true;
    boolean key7 = true;
    boolean key8 = true;
    boolean key9 = true;
    boolean mover = true;
    boolean sound3 = true;
    boolean sound4 = true;
    boolean sound5 = true;
    boolean sound6 = true;
    boolean sound7 = true;
    boolean sound8 = true;
    boolean sound9 = false;
    boolean sound10 = true;
    boolean sound11 = true;
    boolean lanzar;
    boolean contador = true;
    boolean velocimetro = true;
    boolean confirmar = false;

    boolean jugar = false;
    boolean changeSubescena;
    boolean swOptions = false;
    boolean playSounds;
    boolean SaveSounds = true;
    boolean choqueder;
    boolean choqueizq;
    boolean Maps = false;
    boolean launchFR = false;
    boolean launchIns = false;

    AudioClip soundBomm;
    AudioClip soundExtraLife;
    AudioClip SoundLobby;
    AudioClip StartRace;
    AudioClip GameOver;
    AudioClip Level2;
    AudioClip Level3;
    AudioClip level1;
    AudioClip spray;
    AudioClip soundCredits;
    AudioClip SoundYouWin;

    String[] rutas_carplayers = { "Images/carplayer_orange.png", "Images/carplayer_blue.png",
            "Images/carplayer_yellow.png", "Images/carplayer_red.png", "Images/carplayer_purple.png",
            "Images/carplayer_white.png", "Images/carplayer_green.png", "Images/carplayer_vinotinte.png",
            "Images/carplayer_lightblue.png" };
    String[] rutas = { "Images/cangrejo.png", "Images/caracol.png", "Images/chiguiro.png", "Images/nti.png",
            "Images/gallo.png", "Images/gato_1.png", "Images/gato_2.png", "Images/oveja.png", "Images/panda.png",
            "Images/pato.png", "Images/perro_2.png", "Images/perro.png", "Images/pinguino.png", "Images/zorro_1.png",
            "Images/zorro_2.png" };
    String[] rutasup = { "Images/car_up1.png", "Images/car_up2.png", "Images/car_up3.png", "Images/car_up4.png",
            "Images/car_up5.png", "Images/car_up6.png", "Images/car_up7.png", "Images/car_up8.png",
            "Images/car_up9.png", "Images/car_up10.png", "Images/car_up11.png" };
    String[] rutasdown = { "Images/car_down1.png", "Images/car_down2.png", "Images/car_down3.png",
            "Images/car_down4.png", "Images/car_down5.png", "Images/car_down6.png", "Images/car_down7.png",
            "Images/car_down8.png", "Images/car_down9.png", "Images/car_down10.png", "Images/car_down11.png" };

    PImage[] car_up = new PImage[rutasup.length];
    PImage[] car_up_shuffle = new PImage[rutasup.length];
    PImage[] car_down = new PImage[rutasdown.length];
    PImage[] car_down_shuffle = new PImage[rutasdown.length];
    PImage[] animals = new PImage[rutas.length];
    PImage[] animals_shuffle = new PImage[rutas.length];
    PImage[] carplayers = new PImage[9];
    boolean[] choque = new boolean[rutas.length];
    boolean[] boleeanarray = { false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, };
    int[] contadores = new int[15];
    float[] ordenadasderecha = { random(600, 920), random(600, 920), random(600, 920), random(600, 920),
            random(600, 920), random(600, 920), random(600, 920), random(600, 920), random(600, 920), random(600, 920),
            random(600, 920) };
    float[] ordenadasizquierda = { random(275, 520), random(275, 520), random(275, 520), random(275, 520),
            random(275, 520), random(275, 520), random(275, 520), random(275, 520), random(275, 520), random(275, 520),
            random(275, 520) };
    float[] ordenadasanimales = { random(275, 920), random(275, 920), random(275, 920), random(275, 920),
            random(275, 920), random(275, 920), random(275, 920), random(275, 920), random(275, 920), random(275, 920),
            random(275, 920), random(275, 920), random(275, 920), random(275, 920), random(275, 920) };
    float[] abcisa = { -160, -160, -160, -160, -160, -160, -160, -160, -160, -160, -160 };
    float[] abcisa1 = { -160, -160, -160, -160, -160, -160, -160, -160, -160, -160, -160 };
    float[] abcisa2 = { -90, -90, -90, -90, -90, -90, -90, -90, -90, -90, -90, -90, -90, -90, -90 };

    @Override

    public void setup() {
        this.upFiles();
        frameRate(30);
    }

    @Override
    public void draw() {

        timer = millis() / 1000;
        switch (escena) {
        case 1:
            this.lobby();
            break;
        case 2:
            if (!jugar) {
                image(instrucciones1, 0, 0);
            }
            this.mouseClicked();
            if (jugar) {
                carplayers[auxGarage].resize(ancho, largo);
                SoundLobby.stop();
                if (sound3 == true) {
                    StartRace.play();
                    sound3 = false;
                }
                if (key4) {
                    aux = timer;
                    key4 = false;
                }
                timer2 = timer - aux;
                if (contador) {
                    image(Background, x, y);
                    image(carplayers[auxGarage], xcarplayer, ycarplayer);
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
            }
            break;
        case 3:
            this.freeRace();
            break;
        case 4:
            this.garage();
            break;
        case 5:
            this.options();
            break;
        case 6:
            this.credits();
        }
    }

    public void upFiles() {

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
        lobby = loadImage("Images/lobby.png");
        garage = loadImage("Images/garage1.png");
        Background2b = loadImage("Images/cartacho.png");
        line_meta = loadImage("Images/Line_meta.png");
        youwin = loadImage("Images/Youwin.png");
        marco = loadImage("Images/marco.png");
        creditos1 = loadImage("Images/creditos1.png");
        creditos2 = loadImage("Images/credito2.png");
        instrucciones1 = loadImage("Images/instrucciones1.png");
        options = loadImage("Images/options.png");
        marco2 = loadImage("Images/marco2.png");
        marco3 = loadImage("Images/marco2.png");
        chooseMaps = loadImage("Images/chooseMaps.png");
        marco4 = loadImage("Images/marco4.png");
        instrucciones2 = loadImage("Images/instrucciones2.png");
        marco.resize(74, 73);
        soundBomm = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/export.wav"));
        soundExtraLife = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/export1.wav"));
        StartRace = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/StartRace.wav"));
        SoundLobby = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/SoundLobby.wav"));
        GameOver = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/SoundGameOver.wav"));
        Level2 = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/ulala.wav"));
        Level3 = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/songquilla.wav"));
        level1 = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/soundlevel1.wav"));
        spray = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/Spray.wav"));
        soundCredits = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/oninonino.wav"));
        SoundYouWin = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/SongYouWin.wav"));

        for (int i = 0; i < rutasup.length; i++) {
            car_up_shuffle[i] = (loadImage(rutasup[i]));
            car_up_shuffle[i].resize(ancho, largo);
        }

        for (int j = 0; j < rutasdown.length; j++) {
            car_down_shuffle[j] = (loadImage(rutasdown[j]));
            car_down_shuffle[j].resize(ancho, largo);
        }

        for (int i = 0; i < rutas.length; i++) {
            animals_shuffle[i] = (loadImage(rutas[i]));
            animals_shuffle[i].resize(60, 87);
        }
        for (int i = 0; i < rutas_carplayers.length; i++) {
            carplayers[i] = loadImage(rutas_carplayers[i]);

        }
        acciones.shuffle(car_down_shuffle, car_down);
        acciones.shuffle(car_up_shuffle, car_up);
        acciones.shuffle(animals_shuffle, animals);
        System.out.println("Primer Shuffle realizado");
    }

    public void lobby() {
        if (SaveSounds) {
            if (sound4 == true) {
                SoundLobby.play();
                sound4 = false;
            }
        } else {
            SoundLobby.stop();
        }

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
        text("CARRERA", 540, 320);
        text("FREE RACE", 515, 420);
        text("GARAGE", 550, 520);
        text("OPCIONES", 530, 620);
        text("CREDITOS", 945, 690);
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
            textSize(letras + 12);
            text("GUARDAR", 839, 595);
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

        if (sound9) {
            spray.play();
            sound9 = false;
        }

        this.mouseClicked();
        carplayers[m].resize(160, 281);
        image(carplayers[m], 202, 270);
        image(marco, xmarco, ymarco);
    }

    public void options() {
        background(options);
        {
            fill(255, 255, 255);
            rect(103, 73, 72, 29);
        }
        {
            fill(255, 255, 255);
            triangle(103, 63, 103, 112, 57, 88);
        }
        image(marco2, xmarco2, ymarco2);
        image(marco3, xmarco3, ymarco3);
        this.mouseClicked();
    }

    public void game() {

        if (!confirmar) {
            m = 0;
        }
        key3 = true;
        if (timer3 % 20 == 0) {
            if (velocimetro == true) {
                vel = vel + saveDificultad;
                backvel = backvel + saveDificultad;
                velocimetro = false;
                ;
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
            if (SaveSounds) {
                if (sound8 == true) {
                    level1.play();
                    sound8 = false;
                }
            }
            image(Background, x, y);
            image(Background, x, y1);
            y = y + backvel;
            y1 = y1 + backvel;
            if (y > 720) {
                y = 0;
                y1 = -720;
            }
            image(letrero, 150, yletter);
            yletter += velsings;
        } else if (sw == 2) {
            level1.stop();
            if (SaveSounds) {
                if (sound6 == true) {
                    Level2.play();
                    sound6 = false;
                }
            }

            if (key1) {
                y = 0;
                key1 = false;
            }
            y = y + backvel;
            image(Background, x, y);
            image(Background2, x, y3);
            image(Background2b, x, y4);
            y3 = y3 + backvel;
            y4 = y4 + backvel;
            if (y3 > 720) {
                y3 = y4 - 720;
            }
            if (y4 > 720) {
                y4 = y3 - 720;
            }
            image(letrero2, 150, yletter2);
            yletter2 += velsings;

        } else if (sw == 3) {
            Level2.stop();
            if (SaveSounds) {
                if (sound7 == true) {
                    Level3.play();
                    sound7 = false;
                }
            }

            if (y4 < 720) {
                y4 = y4 + backvel;
                image(Background2b, x, y4);
            }
            if (y3 < 720) {
                y3 = y3 + backvel;
                image(Background2, x, y3);
            }
            image(Background3a, x, y5);
            image(Background3b, x, y6);
            image(Background3c, x, y7);
            image(Background3d, x, y8);
            y5 += backvel;
            y6 += backvel;
            y7 += backvel;
            y8 += backvel;
            if (y8 >= 0) {
                y5 = y8 - 720;
                y6 = y5 - 720;
                y7 = y6 - 720;
            }
            if (y8 > 720) {
                y8 = y7 - 720;
            }
            image(letrero3, 150, yletter3);
            yletter3 += velsings;
        }

        this.texField();
        this.crash();
        if (life == 0) {
            if (key3 == true) {
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
                level1.stop();
                Level2.stop();
                Level3.stop();
                key7 = true;
                key6 = true;
                this.mouseClicked();
            }
        }

        if (timer3 > 98) {
            if (ylinemeta < ycarplayer) {
                ylinemeta += backvel;
            } else {
                backvel = 0;
                vel = 0;
            }
            image(line_meta, 270, ylinemeta);
        }
        if (timer3 == 100) {
            mover = false;
            exit.resize(80, 90);
            retry.resize(80, 90);
            image(youwin, 494, 17);
            image(exit, 540, 300);
            image(retry, 660, 300);
            if (sound11) {
                SoundYouWin.loop();
                sound11 = false;
            }
        }
        this.generateAnimals();
        this.generateCars();
        image(animals[n], ordenadasanimales[n], abcisa2[n]);
        image(carplayers[auxGarage], xcarplayer, ycarplayer);
    }

    public void freeRace() {

        image(chooseMaps, 0, 0);
        image(marco4, xmarco4, ymarco4);

        {
            fill(255, 255, 255);
            rect(51, 42, 40, 20);
        }
        {
            fill(255, 255, 255);
            triangle(51, 35, 51, 69, 26, 52);
        }
        this.mouseClicked();
        if (launchIns) {
            image(instrucciones2, 0, 0);
        }
        if (launchFR) {
            launchIns = false;
            if (timer3 % 20 == 0) {
                if (velocimetro == true) {
                    vel = vel + 5;
                    backvel = backvel + 5;
                    velocimetro = false;
                    ;
                }
            } else {
                velocimetro = true;
            }
            carplayers[auxGarage].resize(ancho, largo);
            SoundLobby.stop();
            if (sound3 == true) {
                StartRace.play();
                sound3 = false;
            }
            if (key4) {
                aux = timer;
                key4 = false;
            }
            timer2 = timer - aux;
            if (contador) {
                image(escenarioFR1, x, y);
                image(carplayers[auxGarage], xcarplayer, ycarplayer);
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
                switch (swFR) {
                case 1:
                    if (SaveSounds) {
                        if (sound8 == true) {
                            level1.loop();
                            sound8 = false;
                        }
                    }
                    image(Background, x, ysw);
                    image(Background, x, y1sw);
                    ysw = ysw + backvel;
                    y1sw = y1sw + backvel;
                    if (ysw >= 720) {
                        ysw = 0;
                        y1sw = -720;
                    }
                    image(letrero, 150, yletter);
                    yletter += velsings;
                    image(carplayers[auxGarage], xcarplayer, ycarplayer);
                    break;
                case 2:
                    if (SaveSounds) {
                        if (sound6 == true) {
                            Level2.loop();
                            sound6 = false;
                        }
                    }
                    image(Background2, x, y2);
                    image(Background2b, x, y4sw);
                    y2 = y2 + backvel;
                    y4sw = y4sw + backvel;
                    if (y2 >= 720) {
                        y2 = y4sw - 720;
                    }
                    if (y4sw >= 720) {
                        y4sw = y2 - 720;
                    }
                    image(letrero2, 150, yletter2);
                    yletter2 += velsings;
                    image(carplayers[auxGarage], xcarplayer, ycarplayer);
                    break;
                case 3:
                    Level2.stop();
                    if (SaveSounds) {
                        if (sound7 == true) {
                            Level3.loop();
                            sound7 = false;
                        }
                    }

                    image(Background2b, x, y4sw);
                    image(Background3a, x, y5sw);
                    image(Background3b, x, y6sw);
                    image(Background3c, x, y7sw);
                    image(Background3d, x, y8sw);
                    y5sw += backvel;
                    y6sw += backvel;
                    y7sw += backvel;
                    y8sw += backvel;
                    if (y8sw >= 0) {
                        y5sw = y8sw - 720;
                        y6sw = y5sw - 720;
                        y7sw = y6sw - 720;

                    }
                    if (y8sw >= 720) {
                        y8sw = y7sw - 720;
                    }
                    image(letrero3, 150, yletter3);
                    yletter3 += velsings;
                    if (timer3 > 99) {
                        ylinemeta += backvel;
                        image(line_meta, 275, ylinemeta);
                    }
                    break;
                }
                image(carplayers[auxGarage], xcarplayer, ycarplayer);
                image(animals[n], ordenadasanimales[n], abcisa2[n]);
                this.generateAnimals();
                this.generateCars();
                this.crash();
                this.textFieldFR();
            }
        }
        if (life == 0) {
            if (key3 == true) {
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
                level1.stop();
                Level2.stop();
                Level3.stop();
                key7 = true;
                key6 = true;
                this.mouseClicked();
            }
        }

    }

    public void generateCars() {

        acciones.shuffle(car_down_shuffle, car_down);
        acciones.shuffle(car_up_shuffle, car_up);
        acciones.shuffle(animals_shuffle, animals);
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
        if (abcisa1[5] > 144) {
            image(car_down[6], ordenadasizquierda[6], abcisa[6]);
            abcisa[6] = abcisa[6] + vel;
        }
        if (abcisa[6] > 144) {
            image(car_up[6], ordenadasderecha[6], abcisa1[6]);
            abcisa1[6] = abcisa1[6] + vel;
        }
        if (abcisa1[6] > 144) {
            image(car_down[7], ordenadasizquierda[7], abcisa[7]);
            abcisa[7] = abcisa[7] + vel;
        }
        if (abcisa[7] > 144) {
            image(car_up[7], ordenadasderecha[7], abcisa1[7]);
            abcisa1[7] = abcisa1[7] + vel;
        }
        if (abcisa1[7] > 144) {
            image(car_down[8], ordenadasizquierda[8], abcisa[8]);
            abcisa[8] = abcisa[8] + vel;
        }
        if (abcisa[8] > 144) {
            image(car_up[8], ordenadasderecha[8], abcisa1[8]);
            abcisa1[8] = abcisa1[8] + vel;
        }
        if (abcisa1[8] > 144) {
            image(car_down[9], ordenadasizquierda[9], abcisa[9]);
            abcisa[9] = abcisa[9] + vel;
        }
        if (abcisa[9] > 144) {
            image(car_up[9], ordenadasderecha[9], abcisa1[9]);
            abcisa1[9] = abcisa1[9] + vel;
        }
        if (abcisa1[9] > 144) {
            image(car_down[10], ordenadasizquierda[10], abcisa[10]);
            abcisa[10] = abcisa[10] + vel;
        }
        if (abcisa[10] > 144) {
            image(car_up[10], ordenadasderecha[10], abcisa1[10]);
            abcisa1[10] = abcisa1[10] + vel;
        }
        if (abcisa1[10] > 720) {
            acciones.shuffle(car_down_shuffle, car_down);
            acciones.shuffle(car_up_shuffle, car_up);
            for (int i = 0; i < ordenadasderecha.length; i++) {
                ordenadasderecha[i] = random(600, 920);
                ordenadasizquierda[i] = random(275, 520);
            }
            for (int i = 0; i < abcisa.length; i++) {
                abcisa1[i] = -160;
                abcisa[i] = -160;
            }
        }

    }

    public void generateAnimals() {
        if (n > 0) {
            while (ordenadasanimales[n] > ordenadasanimales[n - 1] - 50
                    && ordenadasanimales[n] < ordenadasanimales[n - 1] + 50) {
                ordenadasanimales[n] = random(275, 920);
            }
        }
        this.validacion();
        if (contadores[n] == 22) {
            if (abcisa2[n] < 720) {
                abcisa2[n] = abcisa2[n] + vel;
            } else {
                n = n + 1;
            }
        }
        if (n > 14) {
            n = 0;
            for (int i = 0; i <= 14; i++) {
                abcisa2[i] = -90;
            }
        }

    }

    public void crash() {
        for (int h = 0; h < car_up.length; h++) {
            if (xcarplayer > ordenadasizquierda[h] + ancho - 10) {

            } else if (xcarplayer + ancho < ordenadasizquierda[h] + 10) {

            } else if (ycarplayer > abcisa[h] + largo - 10) {

            } else if (ycarplayer + largo < abcisa[h] + 10) {

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
            if (xcarplayer > ordenadasderecha[h] + ancho - 10) {

            } else if (xcarplayer + ancho < ordenadasderecha[h] + 10) {

            } else if (ycarplayer > abcisa1[h] + largo - 10) {

            } else if (ycarplayer + largo < abcisa1[h] + 10) {

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

    public void textFieldFR() {
        Float distancia = (vel * (float) timer3) / 100;
        Float score = (distancia + timer3) * 2;
        corazon.resize(24, 23);
        image(corazon, 1092, ytext - 19);
        textFont(fuente);
        fill(255, 255, 255);
        text(life + "P", 1055, ytext);
        text("Distancia:", 1055, ytext * 5);
        text(distancia + " km", 1055, ytext * 6);
        text("Velocidad:", 1055, ytext * 10);
        text(vel + " km/h", 1055, ytext * 11);
        text("Tiempo:", 1055, ytext * 15);
        text(timer3 + " s", 1055, ytext * 16);
        text("Puntaje:", 1055, ytext * 20);
        text(score + " pts.", 1055, ytext * 21);
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
                if (escena == 1) {
                    if (mouseX > 500 && mouseX < 500 + 250) {
                        if (mouseY > 280 && mouseY < 280 + 50) {
                            escena = 2;
                        }
                    }
                    if (mouseX > 500 && mouseX < 500 + 250) {
                        if (mouseY > 380 && mouseY < 380 + 50) {
                            escena = 3;
                        }
                    }
                    if (mouseX > 500 && mouseX < 500 + 250) {
                        if (mouseY > 480 && mouseY < 480 + 50) {
                            escena = 4;
                        }
                    }
                    if (mouseX > 500 && mouseX < 500 + 250) {
                        if (mouseY > 580 && mouseY < 580 + 50) {
                            escena = 5;
                        }
                    }
                    if (mouseX > 940 && mouseX < 940 + 250) {
                        if (mouseY > 650 && mouseY < 650 + 50) {
                            escena = 6;

                        }
                    }

                }
                if (escena == 2) {
                    if (mouseX > 1098 && mouseX < 1223) {
                        if (mouseY > 639 && mouseY < 690) {
                            jugar = true;
                        }
                    }
                    if (mover == false) {
                        if ((mouseX > 540 && mouseX < 540 + 80) && (mouseY > 330 && mouseY < 330 + 90)) {
                            if (key6 == true) {
                                this.exiting();
                                key6 = false;
                            }

                        }
                        if ((mouseX > 660 && mouseX < 660 + 80) && (mouseY > 330 && mouseY < 330 + 90)) {
                            this.retrying();
                        }
                    }
                    if (timer3 == 100) {
                        if (mouseX > 660 && mouseX < 740) {
                            if (mouseY > 300 && mouseY < 390) {
                                this.retrying();

                            }
                        }
                        if (mouseX > 540 && mouseX < 620) {
                            if (mouseY > 300 && mouseY < 390) {
                                this.exiting();

                            }
                        }
                    }

                }
                if (escena == 3) {
                    if (mouseX > 51 && mouseX < 403) {
                        if (mouseY > 233 && mouseY < 491) {
                            xmarco4 = 41;
                            ymarco4 = 223;
                            Maps = true;
                            swFR = 1;
                            escenarioFR1 = Background;
                        }
                    }
                    if (mouseX > 464 && mouseX < 816) {
                        if (mouseY > 233 && mouseY < 491) {
                            xmarco4 = 454;
                            ymarco4 = 223;
                            escenarioFR1 = Background2;
                            swFR = 2;
                            Maps = true;
                        }
                    }
                    if (mouseX > 877 && mouseX < 1229) {
                        if (mouseY > 233 && mouseY < 491) {
                            xmarco4 = 867;
                            ymarco4 = 223;
                            escenarioFR1 = Background3a;
                            Maps = true;
                            swFR = 3;
                        }
                    }
                    if (Maps) {
                        if (mouseX > 527 && mouseX < 752) {
                            if (mouseY > 634 && mouseY < 693) {
                                launchIns = true;
                            }
                        }
                    }
                    if (launchIns) {
                        if (mouseX > 1098 && mouseX < 1223) {
                            if (mouseY > 639 && mouseY < 690) {
                                launchFR = true;
                            }
                        }
                    }
                    if (mouseX > 26 && mouseX < 91) {
                        if (mouseY > 35 && mouseY < 69) {
                            escena = 1;
                        }
                    }
                    if (mover == false) {
                        if ((mouseX > 540 && mouseX < 540 + 80) && (mouseY > 330 && mouseY < 330 + 90)) {
                            if (key6 == true) {
                                this.exitingFR();
                                key6 = false;
                            }

                        }
                        if ((mouseX > 660 && mouseX < 660 + 80) && (mouseY > 330 && mouseY < 330 + 90)) {
                            this.retryingFR();
                        }
                    }
                }
                if (escena == 4) {
                    if (mouseX > 800 && mouseX < 860) {
                        if (mouseY > 250 && mouseY < 310) {
                            m = 0;
                            xmarco = 793;
                            ymarco = 243;
                            sound9 = true;

                        }
                    }
                    if (mouseX > 900 && mouseX < 960) {
                        if (mouseY > 250 && mouseY < 310) {
                            m = 1;
                            xmarco = 893;
                            ymarco = 243;
                            sound9 = true;

                        }

                    }
                    if (mouseX > 1000 && mouseX < 1060) {
                        if (mouseY > 250 && mouseY < 310) {
                            m = 2;
                            xmarco = 993;
                            ymarco = 243;
                            sound9 = true;

                        }
                    }
                    if (mouseX > 800 && mouseX < 860) {
                        if (mouseY > 350 && mouseY < 410) {
                            m = 3;
                            xmarco = 793;
                            ymarco = 343;
                            sound9 = true;

                        }
                    }
                    if (mouseX > 900 && mouseX < 960) {
                        if (mouseY > 350 && mouseY < 410) {
                            m = 4;
                            xmarco = 893;
                            ymarco = 343;
                            sound9 = true;

                        }
                    }
                    if (mouseX > 1000 && mouseX < 1060) {
                        if (mouseY > 350 && mouseY < 410) {
                            m = 5;
                            xmarco = 993;
                            ymarco = 343;
                            sound9 = true;

                        }
                    }
                    if (mouseX > 800 && mouseX < 860) {
                        if (mouseY > 450 && mouseY < 510) {
                            m = 6;
                            xmarco = 793;
                            ymarco = 443;
                            sound9 = true;

                        }
                    }
                    if (mouseX > 900 && mouseX < 960) {
                        if (mouseY > 450 && mouseY < 510) {
                            m = 7;
                            xmarco = 893;
                            ymarco = 443;
                            sound9 = true;

                        }
                    }
                    if (mouseX > 1000 && mouseX < 1060) {
                        if (mouseY > 450 && mouseY < 510) {
                            m = 8;
                            xmarco = 993;
                            ymarco = 443;
                            sound9 = true;

                        }
                    }
                    if (mouseX > 57 && mouseX < 186) {
                        if (mouseY > 73 && mouseY < 102) {
                            escena = 1;
                        }
                    }
                    if (mouseX > 800 && mouseX < 1060) {
                        if (mouseY > 550 && mouseY < 610) {
                            auxGarage = m;
                            escena = 1;
                            spray.stop();

                        }
                    }
                }
                if (escena == 5) {
                    if (mouseX > 57 && mouseX < 186) {
                        if (mouseY > 73 && mouseY < 102) {
                            escena = 1;
                        }
                    }
                    if (mouseX > 467 && mouseX < 612) {
                        if (mouseY > 286 && mouseY < 341) {
                            xmarco2 = 465;
                            ymarco2 = 281;
                            playSounds = true;

                        }
                    }
                    if (mouseX > 657 && mouseX < 802) {
                        if (mouseY > 286 && mouseY < 341) {
                            xmarco2 = 655;
                            ymarco2 = 281;
                            playSounds = false;
                        }
                    }
                    if (mouseX > 360 && mouseX < 505) {
                        if (mouseY > 508 && mouseY < 563) {
                            xmarco3 = 357;
                            ymarco3 = 503;
                            dificultad = 2;
                            vel = 5;
                            backvel = 10;
                        }
                    }
                    if (mouseX > 568 && mouseX < 713) {
                        if (mouseY > 508 && mouseY < 563) {
                            xmarco3 = 565;
                            ymarco3 = 503;
                            dificultad = 5;
                            vel = 10;
                            backvel = 20;
                        }
                    }
                    if (mouseX > 776 && mouseX < 921) {
                        if (mouseY > 508 && mouseY < 563) {
                            xmarco3 = 773;
                            ymarco3 = 503;
                            vel = 15;
                            backvel = 25;
                            dificultad = 8;
                        }
                    }
                    if (mouseX > 1107 && mouseX < 1252) {
                        if (mouseY > 639 && mouseY < 694) {
                            escena = 1;
                            saveDificultad = dificultad;
                            SaveSounds = playSounds;
                            delay(300);
                        }
                    }
                }
                if (escena == 6) {
                    if (subescena == 1) {
                        if (mouseX > 1136 && mouseX < 1189) {
                            if (mouseY > 600 && mouseY < 663) {
                                subescena = 2;
                                changeSubescena = false;
                            }
                        }
                    }
                    if (subescena == 2) {
                        if (mouseX > 91 && mouseX < 144) {
                            if (mouseY > 602 && mouseY < 666) {
                                subescena = 1;
                            }
                        }
                        if (mouseX > 1092 && mouseX < 1237) {
                            if (mouseY > 34 && mouseY < 89) {
                                escena = 1;
                                soundCredits.stop();
                                sound4 = true;
                            }
                        }
                    }
                }
            }
        }

    }

    public void credits() {
        SoundLobby.stop();
        if (sound10) {
            soundCredits.loop();
            sound10 = false;
        }
        switch (subescena) {
        case 1:
            image(creditos1, 0, 0);
            fill(255, 255, 255);
            triangle(1136, 600, 1136, 663, 1189, 634);

            fill(5, 5, 5);
            rect(1078, 539, 66, 153);

            break;
        case 2:
            image(creditos2, 0, 0);
            fill(255, 255, 255);
            triangle(91, 634, 144, 602, 144, 666);

            break;
        }
        this.mouseClicked();
    }

    public void exiting() {
        escena = 1;
        this.retrying();
    }

    public void exitingFR() {
        escena = 1;
        this.retryingFR();
    }

    public void retrying() {
        backvel = 20;
        vel = 10;
        y = 0;
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
        life = 3;
        mover = true;
        sound3 = true;
        sound4 = true;
        sound5 = true;
        sound6 = true;
        sound7 = true;
        sound8 = true;
        sound11 = false;
        acciones.shuffle(car_down_shuffle, car_down);
        acciones.shuffle(car_up_shuffle, car_up);
        acciones.shuffle(animals_shuffle, animals);
        contador = true;
        key4 = true;
        key1 = true;
        key2 = true;
        jugar = false;
        SoundYouWin.stop();
        sw = 1;
        for (int i = 0; i < ordenadasderecha.length; i++) {
            ordenadasderecha[i] = random(600, 920);
            ordenadasizquierda[i] = random(275, 520);
        }
        for (int i = 0; i < abcisa.length; i++) {
            abcisa1[i] = -160;
            abcisa[i] = -160;
        }
        for (int i = 0; i < abcisa2.length; i++) {
            abcisa2[i] = -395;
            ordenadasanimales[i] = random(275, 920);
        }
    }

    public void retryingFR() {
        backvel = 20;
        vel = 10;
        ysw = 0;
        y1sw = -720;
        y2 = 0;
        y4sw = -720;
        y5sw = 0;
        y6sw = -720;
        y7sw = -1440;
        y8sw = -2160;
        xcarplayer = 600;
        ycarplayer = 520;
        life = 3;
        mover = true;
        sound3 = true;
        sound4 = true;
        sound5 = true;
        sound6 = true;
        sound7 = true;
        sound8 = true;
        acciones.shuffle(car_down_shuffle, car_down);
        acciones.shuffle(car_up_shuffle, car_up);
        acciones.shuffle(animals_shuffle, animals);
        contador = true;
        key4 = true;
        key1 = true;
        key2 = true;
        launchFR = false;
        launchIns = false;
        for (int i = 0; i < ordenadasderecha.length; i++) {
            ordenadasderecha[i] = random(600, 920);
            ordenadasizquierda[i] = random(275, 520);
        }
        for (int i = 0; i < abcisa.length; i++) {
            abcisa1[i] = -160;
            abcisa[i] = -160;
        }
        for (int i = 0; i < abcisa2.length; i++) {
            abcisa2[i] = -395;
            ordenadasanimales[i] = random(275, 920);
        }
    }

    public void run() {
        String[] processingArgs = { this.getClass().getName() };
        PApplet.runSketch(processingArgs, this);
    }
}
