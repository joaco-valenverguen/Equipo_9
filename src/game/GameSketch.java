package game;

import java.util.Random;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PFont;
import java.applet.AudioClip;
import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;

public class GameSketch extends PApplet {

    App music = new App();
    Acciones acciones = new Acciones(this);
    Random random = new Random();

    @Override
    public void settings() {
        size(1280, 720);
    }

    int newvelback = 20, newvel = 10, swFR, xmarco4 = -300, ymarco4 = -300, ymarco3 = 503, xmarco3 = 565, ymarco2 = 281,
    xmarco2 = 465, timeacu = 0, x = 0, sw = 1, ytext = 28, letras = 13, life = 3, timer, ancho = 70, largo = 150,
    anchoanimals = 60, altoanimals = 87, i, n = 0, h, cont1 = 0, yletter = -200, timer2, timer3 = 1, escena = 1,
    yletter2 = -200, aux, cont, m, velsings = 7, yletter3 = -200, ylinemeta = -83, xmarco = -400, ymarco = -400,
    auxGarage = 0, subescena = 1, pause = 0, timer4;

    float velresume = 3, backvelresume = 3, ybackground2 = -710, y2 = 0, y = 0, backvel = 20, vel = 10, dificultad = 5,
    saveDificultad = 5, y1 = -720, y3 = -1440, y4 = -720, y4sw = -720, ysw = 0, y1sw = -720, y5sw = 0, y6sw = -720,
    y7sw = -1440, y8sw = -2160, y5 = -720, y6 = -1440, y7 = -2160, y8 = -2880, xcarplayer = 600, ycarplayer = 520,
    xcolision, ycolision;

    Clip soundLobby, Level1, Level2, Level3, SoundYouWin, SoundCredits;
    AudioClip soundBomm, soundExtraLife, StartRace, GameOver, spray;

    PImage Background, Background1, Background2 ,Background3a, Background3b, Background3c, Background3d, gameOver,
    boom, lobby, check, retry, exit, letrero, escenario2, red, letrero2, corazon, garage, Background2b, letrero3,
    line_meta ,youwin,marco,creditos1, creditos2, instrucciones1, options, marco2, marco3, marco4 ,chooseMaps, 
    instrucciones2, escenarioFR1, menuPause;
    PFont fuente;

    boolean key1 = true, key3 = true, key4 = true, key5 = true, key6 = true, key7 = true, key8 = true, key9 = true,
    key10 = false, key11 = false, key12 = true, mover = true, sound3 = true, sound4 = true, sound5 = true, sound6 = true,
    sound7 = true, sound8 = true, sound9 = false, sound10 = true, sound11 = true, lanzar, contador = true,
    velocimetro = true, confirmar = false, jugar = false, changeSubescena, swOptions = false, playSounds = true,
    SaveSounds = true, choqueder, choqueizq, Maps = false, launchFR = false, launchIns = false;

    String p = "p";
    char pausa = p.charAt(0);

    String  SoundLobby = "/sounds/SoundLobby.wav",  level2 = "/sounds/ulala.wav",  level3 = "/sounds/songquilla.wav", level1 = "/sounds/soundlevel1.wav",  soundCredits = "/sounds/oninonino.wav", soundYouWin = "/sounds/SongYouWin.wav";

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
        timer4 = millis();
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
                soundLobby.stop();
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

    //Método para subir los archivos que se necesitan
    public void upFiles() {

        lobby = loadImage("Images/lobby.png");
        letrero = loadImage("Images/letreroSincelejo.png");
        letrero.resize(200, 200);
        boom = loadImage("Images/boom2.png");
        boom.resize(200, 200);
        red = loadImage("Images/red.png");
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
        garage = loadImage("Images/garage1.png");
        Background2b = loadImage("Images/cartacho.png");
        line_meta = loadImage("Images/Line_meta.png");
        youwin = loadImage("Images/youwin.png");
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
        menuPause = loadImage("Images/menuPause_1.png");
        marco.resize(74, 73);
        soundBomm = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/export.wav"));
        soundExtraLife = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/export1.wav"));
        StartRace = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/StartRace.wav"));
        GameOver = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/SoundGameOver.wav"));
        soundBomm = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/export.wav"));
        soundExtraLife = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/export1.wav"));
        StartRace = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/StartRace.wav"));
        GameOver = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/SoundGameOver.wav"));
        spray = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/Spray.wav"));
        
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
        
        // audio lobby

        try {
            InputStream audioSrc = getClass().getResourceAsStream(SoundLobby);
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
            soundLobby = AudioSystem.getClip();
            soundLobby.open(audioStream);
        } catch (Exception exception) {
            System.out.println("error");
        }

        // audiolevel1

        try {
            InputStream audioSrc = getClass().getResourceAsStream(level1);
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
            Level1 = AudioSystem.getClip();
            Level1.open(audioStream);
        } catch (Exception exception) {
            System.out.println("error");
        }

        // audiolevel2

        try {
            InputStream audioSrc = getClass().getResourceAsStream(level2);
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
            Level2 = AudioSystem.getClip();
            Level2.open(audioStream);
        } catch (Exception exception) {
            System.out.println("error");
        }

        // audiolevel3

        try {
            InputStream audioSrc = getClass().getResourceAsStream(level3);
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
            Level3 = AudioSystem.getClip();
            Level3.open(audioStream);
        } catch (Exception exception) {
            System.out.println("error");
        }

        // audioSoundyouwin

        try {
            InputStream audioSrc = getClass().getResourceAsStream(soundYouWin);
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
            SoundYouWin = AudioSystem.getClip();
            SoundYouWin.open(audioStream);
        } catch (Exception exception) {
            System.out.println("Error");
        }

        // audioSoundcredits

        try {
            InputStream audioSrc = getClass().getResourceAsStream(soundCredits);
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
            SoundCredits = AudioSystem.getClip();
            SoundCredits.open(audioStream);
        } catch (Exception exception) {
            System.out.println("Error");
        }
    }

    //Método que lanza la pantalla principal del juego

    public void lobby() {
        if (SaveSounds) {
            if (sound4 == true) {

                soundLobby.start();
                sound4 = false;
            }
        } else {
            soundLobby.stop();
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

    //Método que lanza el garage del juego

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

    //Método que lanza el menú de opciones

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

    //Método que lanza el modo carrera.

    public void game() {

        if (!confirmar) {
            m = 0;
        }
        key3 = true;
        //Control de la velocidad, aumenta cada 20 seg.
        if (timer3 % 20 == 0) {
            if (velocimetro == true) {
                vel = vel + saveDificultad;
                backvel = backvel + saveDificultad;
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
            if (SaveSounds) {
                if (sound8 == true) {
                    Level1.setFramePosition(0);
                    System.out.println(Level1.getFrameLength());
                    Level1.start();
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
            Level1.stop();
            if (SaveSounds) {
                if (sound6 == true) {
                    Level2.setFramePosition(0);
                    Level2.start();
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
                    Level3.setFramePosition(0);
                    Level3.start();
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

        if (timer3 > 98) {
            if (ylinemeta < ycarplayer) {
                ylinemeta += backvel;
            } else {
                backvel = 0;
                vel = 0;
            }
            image(line_meta, 270, ylinemeta);
        }
        this.texField();
        this.crash();
        this.generateCars();
        this.generateAnimals();
        image(carplayers[auxGarage], xcarplayer, ycarplayer);
        
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
                Level1.stop();
                Level2.stop();
                Level3.stop();
                key7 = true;
                key6 = true;
                this.mouseClicked();
            }
        }
        //Menú desplegable de pausa
        if (pause == 0) {
            velresume = vel;
            backvelresume = backvel;
        }
        this.mouseClicked();

        if (pause == 1) {
            image(menuPause, 380, 84);
            switch (sw) {
                case 1:
                    Level1.stop();
                    break;
                case 2:
                    Level2.stop();
                    break;
                case 3:
                    Level3.stop();
                    break;
                }
            mover = false;
            backvel = 0;
            vel = 0;
            velsings = 0;
            key6 = true;
            key7 = true;
        }
        //Se reanuda el juego despues de una pausa
        if (pause == 3) {
            switch (sw) {
            case 1:
                Level1.start();
                break;
            case 2:
                Level2.start();
                break;
            case 3:
                Level3.start();
                break;
            }
            mover = true;
            vel = velresume;
            backvel = backvelresume;
            velsings = 7;
            pause = 0;
        }
        //Evento de haber ganado el juego
        if (timer3 == 100) {
            mover = false;
            exit.resize(80, 90);
            retry.resize(80, 90);
            image(youwin, 494, 17);
            image(exit, 540, 300);
            image(retry, 660, 300);
            if (sound11) {
                SoundYouWin.start();
                sound11 = false;
            }
            key6 = true;
            key7 = true;
        }
    }

    //Método que lanza el modo de juego libre.

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
                }
            } else {
                velocimetro = true;
            }
            carplayers[auxGarage].resize(ancho, largo);
            soundLobby.stop();
            if (SaveSounds) {
                if (sound3 == true) {
                    StartRace.play();
                    sound3 = false;
                }
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
                            Level1.setFramePosition(0);
                            Level1.loop(100);
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
                            Level2.setFramePosition(0);
                            Level2.loop(100);
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
                            Level3.setFramePosition(0);
                            Level3.loop(100);
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
                this.crash();
                this.textFieldFR();
                this.generateCars();
                this.generateAnimals();
                image(carplayers[auxGarage], xcarplayer, ycarplayer); 
            }
        }
        //Perdida de las 3 vidas.
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
                Level1.stop();
                Level2.stop();
                Level3.stop();
                key7 = true;
                key6 = true;
                this.mouseClicked();
            }
        }
        if (pause == 0) {
            velresume = vel;
            backvelresume = backvel;
        }
        if (pause == 1) {
            image(menuPause, 380, 84);
            mover = false;
            backvel = 0;
            vel = 0;
            velsings = 0;
            key6 = true;
            key7 = true;
        }
        if (pause == 3) {
            mover = true;
            vel = velresume;
            backvel = backvelresume;
            velsings = 7;
            pause = 0;
        }
    }

    //Método que genera los carros rivales.
    
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

    //Método de generación de animales

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
        image(animals[n], ordenadasanimales[n], abcisa2[n]);
    }

    //Método de colisión de autos

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

    //Método que despliega el textfield del modo carrera

    public void texField() {
        Float distancia = (velresume * timer3) / 100;
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
        text(velresume + " km/h", 1055, ytext * 9);
        text("Tiempo:", 1055, ytext * 12);
        text(timer3 + " s", 1055, ytext * 13);
        text("Puntaje:", 1055, ytext * 16);
        text(score + " pts.", 1055, ytext * 17);
        text("Sincelejo    [ ]", 1055, ytext * 20);
        text("Cartagena    [ ]", 1055, ytext * 21);
        text("Barranquilla [ ]", 1055, ytext * 22);

    }
    
    //Método que despliega el textfield del modo libre

    public void textFieldFR() {
        Float distancia = (velresume * timer3) / 100;
        Float score = (distancia + timer3) * 2;
        corazon.resize(24, 23);
        image(corazon, 1092, ytext - 19);
        textFont(fuente);
        fill(255, 255, 255);
        text(life + "P", 1055, ytext);
        text("Distancia:", 1055, ytext * 5);
        text(distancia + " km", 1055, ytext * 6);
        text("Velocidad:", 1055, ytext * 10);
        text(velresume + " km/h", 1055, ytext * 11);
        text("Tiempo:", 1055, ytext * 15);
        text(timer3 + " s", 1055, ytext * 16);
        text("Puntaje:", 1055, ytext * 20);
        text(score + " pts.", 1055, ytext * 21);
    }

    //Método que recibe los datos del teclado.

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
                if (key == pausa) {

                    pause = 1;
                }
            }
        }
    }

    //Método que asegura que no exista colisión entre los animales y los carros rivales.

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

    //Método que raliza los eventos del mouse

    public void mouseClicked() {
        if (mousePressed == true) {
            if (mouseButton == LEFT) {
                if (escena == 1) {
                    //Lanza el modo de juego normal
                    if (mouseX > 500 && mouseX < 500 + 250) {
                        if (mouseY > 280 && mouseY < 280 + 50) {
                            escena = 2;
                            vel = newvel;
                            backvel = newvelback;
                            pause = 0;
                        }
                    }
                    //Laza el modo de juego libre
                    if (mouseX > 500 && mouseX < 500 + 250) {
                        if (mouseY > 380 && mouseY < 380 + 50) {
                            escena = 3;
                            if (key12) {
                                vel = newvel;
                                backvel = newvelback;
                                key12 = false;
                                pause = 0;
                            }
                        }
                    }
                    //Laza el garage;
                    if (mouseX > 500 && mouseX < 500 + 250) {
                        if (mouseY > 480 && mouseY < 480 + 50) {
                            escena = 4;
                        }
                    }
                    //Laza el menu de opciones
                    if (mouseX > 500 && mouseX < 500 + 250) {
                        if (mouseY > 580 && mouseY < 580 + 50) {
                            escena = 5;
                        }
                    }
                    //lanza los creditos
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
                    if (life == 0 || timer3 == 100) {
                        if (mover == false) {
                            if (mouseX > 540 && mouseX < 620) {
                                if (mouseY > 330 && mouseY < 420) {
                                    if (key6) {
                                        this.exiting();
                                        key6 = false;
                                    }
                                }
                            }
                        }
                        if (mouseX > 660 && mouseX < 740) {
                            if (mouseY > 330 && mouseY < 420) {
                                if (key7) {
                                    this.retrying();
                                    key7 = false;
                                }
                            }
                        }
                    }
                    if (pause == 1) {
                        if (mouseX > 481 && mouseX < 572) {
                            if (mouseY > 214 && mouseY < 306) {
                                if (key7) {
                                    this.retrying();
                                    pause = 0;
                                    key7 = false;
                                }

                            }
                        }
                        if (mouseX > 708 && mouseX < 799) {
                            if (mouseY > 214 && mouseY < 306) {
                                this.exiting();
                                pause = 0;
                            }
                        }
                        if (mouseX > 491 && mouseX < 789) {
                            if (mouseY > 323 && mouseY < 384) {
                                pause = 3;
                            }
                        }
                    }
                }
                if (escena == 3) {
                    if (!launchFR) {
                        if (mouseX > 51 && mouseX < 403) {
                            if (mouseY > 233 && mouseY < 491) {
                                xmarco4 = 41;
                                ymarco4 = 223;
                                Maps = true;
                                escenarioFR1 = Background;
                                swFR = 1;
                            }
                        }
                        if (mouseX > 464 && mouseX < 816) {
                            if (mouseY > 233 && mouseY < 491) {
                                xmarco4 = 454;
                                ymarco4 = 223;
                                escenarioFR1 = Background2;
                                Maps = true;
                                swFR = 2;
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
                            sound4 = true;
                        }
                    }
                    if (life == 0) {
                        if (mover == false) {
                            if (mouseX > 540 && mouseX < 620) {
                                if (mouseY > 330 && mouseY < 420) {
                                    if (key6) {
                                        this.exitingFR();
                                        key6 = false;
                                    }
                                }
                            }
                        }
                        if (mouseX > 660 && mouseX < 740) {
                            if (mouseY > 330 && mouseY < 420) {
                                if (key7) {
                                    this.retryingFR();
                                    key7 = false;
                                }
                            }
                        }
                    }
                    if (pause == 1) {
                        if (mouseX > 481 && mouseX < 572) {
                            if (mouseY > 214 && mouseY < 306) {
                                if (key7) {
                                    this.retryingFR();
                                    pause = 0;
                                    key7 = false;
                                }
                            }
                        }
                        if (mouseX > 708 && mouseX < 799) {
                            if (mouseY > 214 && mouseY < 306) {
                                if (key6) {
                                    this.exitingFR();
                                    pause = 0;
                                    key6 = false;
                                }
    
                            }
                        }
                        if (mouseX > 491 && mouseX < 789) {
                            if (mouseY > 323 && mouseY < 384) {
                                pause = 3;
                            }
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
                            newvel = 5;
                            newvelback = 10;
                        }
                    }
                    if (mouseX > 568 && mouseX < 713) {
                        if (mouseY > 508 && mouseY < 563) {
                            xmarco3 = 565;
                            ymarco3 = 503;
                            dificultad = 5;
                            newvel = 10;
                            vel = 10;
                            backvel = 20;
                            newvel = 10;
                            newvelback = 20;
                        }
                    }
                    if (mouseX > 776 && mouseX < 921) {
                        if (mouseY > 508 && mouseY < 563) {
                            xmarco3 = 773;
                            ymarco3 = 503;
                            dificultad = 8;
                            vel = 15;
                            backvel = 25;
                            newvel = 15;
                            newvelback = 25;
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
                    sound10 = true;
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
                                SoundCredits.stop();
                                sound4 = true;
                            }
                        }
                    }
                }
            }
            
        }
    }

    //Método que despliega los créditos

    public void credits() {
        soundLobby.stop();
        if (SaveSounds) {
            if (sound10) {
                SoundCredits.loop(100);
                sound10 = false;
            }
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

    //Método  que ejecuta la salida del modo de juego carrera

    public void exiting() {
        escena = 1;
        this.retrying();
        jugar = false;
        sound4 = true;
    }

    //Método que ejecuta  la salida del modo de juego carrera libre

    public void exitingFR() {
        escena = 1;
        this.retryingFR();
        launchIns = false;
        key12 = true;
        launchFR = false;
        sound4 = true;
    }
    
    //Método para reiniciar una carrera en el modo carrera

    public void retrying() {
        backvel = newvelback; 
        vel = newvel; 
        yletter = -200; 
        yletter2 = -200; 
        yletter3 = -200; 
        velsings = 7; 
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
        contador = true; 
        sound11 = false; 
        key4 = true;
        key1 = true;

        Level1.stop(); 
        Level2.stop(); 
        Level3.stop();   

        acciones.shuffle(car_down_shuffle, car_down); 
        acciones.shuffle(car_up_shuffle, car_up); 
        acciones.shuffle(animals_shuffle, animals); 
        
        SoundYouWin.stop();sw = 1;
        for (int i = 0; i < ordenadasderecha.length; i++) {    ordenadasderecha[i] = random(600, 920);
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
    
    //Método para reiniciar una carrera en el modo libre

    public void retryingFR() {
        backvel = 20;
        vel = 10;
        yletter = -200;
        yletter2 = -200;
        yletter3 = -200;
        velsings = 7;
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
        contador = true;
        key4 = true;
        key1 = true;
        launchFR = true;
        Level1.stop();
        Level2.stop();
        Level3.stop();
       
        acciones.shuffle(car_down_shuffle, car_down);
        acciones.shuffle(car_up_shuffle, car_up);
        acciones.shuffle(animals_shuffle, animals);
        
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