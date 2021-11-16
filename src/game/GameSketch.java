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

    int newVelBack = 20, newVel = 10, swFR, xPositionmarco4 = -300, yPositionmarco4 = -300, yPositionmarco3 = 503,
            xPositionmarco3 = 565, yPositionmarco2 = 281, xPositionmarco2 = 465, x = 0, sw = 1, yPositionText = 28,
            sizeLetras = 13, life = 3, timer, width = 70, height = 150, widthAnimals = 60, heightAnimals = 87, i, n = 0,
            h, cont1 = 0, YpositionSing = -200, timer2, timer3 = 1, scene = 1, yPositionSing2 = -200, aux, cont, m,
            velSings = 7, yPositionSing3 = -200, yPositionLineMeta = -83, xPositionmarco = -400, yPositionmarco = -400,
            auxGarage = 0, subscene = 1, pause = 0, timer4, posx_i = -150, posx_f = 1430, posy_i = -150, posy_f = 870,
            aux_time = 0;

    float velResume, backVelResume, yBackground2FR = 0, y = 0, backvel = 20, vel = 10, difficulty = 5,
            savedifficulty = 5, yBackground = -720, yPositionBackground2 = -1440, yPositionBackground2b = -720,
            yPositionBackground2bFR = -720, yFR = 0, yBackgroundFR = -720, yPositionBackground3aFR = 0,
            yPositionBackground3bFR = -720, yPositionBackground3cFR = -1440, yPositionBackground3dFR = -2160,
            yPositionBackground3a = -720, yPositionBackground3b = -1440, yPositionBackground3c = -2160,
            yPositionBackground3d = -2880, xPostionCarplayer = 600, yPositionCarplayer = 520, xPositionColision,
            yPositionColision, yPositionSincelejoKid = -246, yCartagenaKids = -250, time3Captured, time4Captured,
            pos_act_x = posx_f, pos_act_y = posy_i, paso = (float) 0.01, pct = (float) 0.0;

    Clip soundLobby, Level1, Level2, Level3, SoundYouWin, SoundCredits;
    AudioClip soundBomm, soundExtraLife, StartRace, GameOver, spray;

    PImage Background, Background1, Background2, Background3a, Background3b, Background3c, Background3d, gameOver, boom,
            lobby, check, retry, exit, sign, red, sign2, heart, garage, Background2b, sign3, line_meta, youwin, marco,
            credits1, credits2, instructions1, options, marco2, marco3, marco4, chooseMaps, instructions2, stageFR1,
            menuPause, SincelejoKid, CartagenaKids, plus, less, meteorite;
    PFont fuente;

    boolean key1 = true, swLife = true, captureTime = true, swButtonExiting = true, swButtonRetrying = true,
            CaptureVelSave = true, move = true, swSoundStartRace = true, swSoundLobby = true, swSoundGameOver = true,
            swSoundLevel2 = true, swSoundLevel3 = true, swSoundLevel1 = true, swSoundSpray = false,
            swSoundCredits = true, swSoundYouWin = true, contador = true, velocimetro = true, confirmar = false,
            jugar = false, changeSubscene, swOptions = false, playSounds = true, SaveSounds = true, Maps = false,
            launchFR = false, launchIns = false, capturedTime3 = false, imageLife = false, capturedTime4 = false,
            imageNoLife = false, keyTime = true, keyRenaudar = true;

    String p = "p";
    String w = "w";
    String a = "a";
    String s = "s";
    String d = "d";

    char pausa = p.charAt(0);
    char Wasd = w.charAt(0);
    char wAsd = a.charAt(0);
    char wasD = d.charAt(0);

    String SoundLobby = "/sounds/SoundLobby.wav", level2 = "/sounds/ulala.wav", level3 = "/sounds/songquilla.wav",
            level1 = "/sounds/soundlevel1.wav", soundCredits = "/sounds/oninonino.wav",
            soundYouWin = "/sounds/songYouWin.wav";

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
        switch (scene) {
        case 1:
            this.lobby();
            break;
        case 2:
            if (!jugar) {
                image(instructions1, 0, 0);
            }
            this.mouseClicked();
            if (jugar) {
                carplayers[auxGarage].resize(width, height);
                soundLobby.stop();
                if (swSoundStartRace == true) {
                    StartRace.play();
                    swSoundStartRace = false;
                }
                if (captureTime) {
                    aux = timer;
                    captureTime = false;
                }
                timer2 = timer - aux;
                if (contador) {
                    image(Background, x, y);
                    image(carplayers[auxGarage], xPostionCarplayer, yPositionCarplayer);
                    filter(BLUR, 5);
                    textFont(fuente);
                    fill(255, 255, 255);
                    textSize(120);
                    text(3 - timer2, 600, 360);
                }
                if (timer2 > 3) {
                    if (move == true) {
                        timer3 = timer2 - 3 - aux_time;
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

    // Método para subir los archivos que se necesitan
    public void upFiles() {

        lobby = loadImage("Images/lobby.png");
        sign = loadImage("Images/letreroSincelejo.png");
        sign.resize(200, 200);
        boom = loadImage("Images/boom2.png");
        boom.resize(200, 200);
        red = loadImage("Images/red.png");
        red.resize(200, 200);
        sign2 = loadImage("Images/letreroCartagena.png");
        sign2.resize(200, 200);
        sign3 = loadImage("Images/quillasing.png");
        heart = loadImage("Images/heart.png");
        check = loadImage("Images/chulito.png");
        fuente = createFont("PressStart2P.ttf", sizeLetras);
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
        credits1 = loadImage("Images/creditos1.png");
        credits2 = loadImage("Images/credito2.png");
        instructions1 = loadImage("Images/instrucciones1.png");
        options = loadImage("Images/options.png");
        marco2 = loadImage("Images/marco2.png");
        marco3 = loadImage("Images/marco2.png");
        chooseMaps = loadImage("Images/chooseMaps.png");
        marco4 = loadImage("Images/marco4.png");
        instructions2 = loadImage("Images/instrucciones2.png");
        menuPause = loadImage("Images/menuPause_1.png");
        SincelejoKid = loadImage("Images/boysincelejano.png");
        CartagenaKids = loadImage("Images/boyscartageneros.png");
        meteorite = loadImage("Images/meteorito.png");
        meteorite.resize(190, 180);
        plus = loadImage("Images/+1.png");
        less = loadImage("Images/-1.png");
        plus.resize(27, 14);
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
            car_up_shuffle[i].resize(width, height);
        }

        for (int j = 0; j < rutasdown.length; j++) {
            car_down_shuffle[j] = (loadImage(rutasdown[j]));
            car_down_shuffle[j].resize(width, height);
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

    // Método que lanza la pantalla principal del juego

    public void lobby() {
        swSoundLobby = true;
        if (SaveSounds) {
            soundLobby.loop(100);
            swSoundLobby = false;
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

    // Método que despliega un meteorito
    public void meteorite() {
        if (pct < 1.0) {
            pos_act_x = posx_i + ((posx_f - posx_i) * pct);
            pos_act_y = posy_i + ((posy_f - posy_i) * pct);
            pct += paso;
        }
        image(meteorite, pos_act_x, pos_act_y);
    }

    // Método que lanza el garage del juego

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
            textSize(sizeLetras + 12);
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

        if (swSoundSpray) {
            spray.play();
            swSoundSpray = false;
        }

        this.mouseClicked();
        carplayers[m].resize(160, 281);
        image(carplayers[m], 202, 270);
        image(marco, xPositionmarco, yPositionmarco);
    }

    // Método que lanza el menú de opciones

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
        image(marco2, xPositionmarco2, yPositionmarco2);
        image(marco3, xPositionmarco3, yPositionmarco3);
        this.mouseClicked();
    }

    // Método que lanza el modo carrera.

    public void game() {

        if (!confirmar) {
            m = 0;
        }
        swLife = true;
        // Control de la velocidad, aumenta cada 20 seg.
        if (timer3 % 20 == 0) {
            if (velocimetro == true) {
                vel = vel + savedifficulty;
                backvel = backvel + savedifficulty;
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
                if (swSoundLevel1 == true) {
                    Level1.setFramePosition(0);
                    Level1.start();
                    swSoundLevel1 = false;
                }
            }
            image(Background, x, y);
            image(Background, x, yBackground);
            y = y + backvel;
            yBackground = yBackground + backvel;
            if (y > 720) {
                y = 0;
                yBackground = -720;
            }
            image(sign, 150, YpositionSing);
            YpositionSing += velSings;
            image(SincelejoKid, 74, yPositionSincelejoKid);
            if (timer3 >= 25) {
                yPositionSincelejoKid += velSings;
            }
        } else if (sw == 2) {
            Level1.stop();
            if (SaveSounds) {
                if (swSoundLevel2 == true) {
                    Level2.setFramePosition(0);
                    Level2.start();
                    swSoundLevel2 = false;
                }
            }
            if (key1) {
                y = 0;
                key1 = false;
            }
            y = y + backvel;
            image(Background, x, y);
            image(Background2, x, yPositionBackground2);
            image(Background2b, x, yPositionBackground2b);
            yPositionBackground2 = yPositionBackground2 + backvel;
            yPositionBackground2b = yPositionBackground2b + backvel;
            if (yPositionBackground2 > 720) {
                yPositionBackground2 = yPositionBackground2b - 720;
            }
            if (yPositionBackground2b > 720) {
                yPositionBackground2b = yPositionBackground2 - 720;
            }
            image(sign2, 150, yPositionSing2);
            yPositionSing2 += velSings;

            if (timer3 >= 58) {
                yCartagenaKids += velSings;
                image(CartagenaKids, 66, yCartagenaKids);
            }

        } else if (sw == 3) {
            Level2.stop();
            if (SaveSounds) {
                if (swSoundLevel3 == true) {
                    Level3.setFramePosition(0);
                    Level3.start();
                    swSoundLevel3 = false;
                }
            }

            if (yPositionBackground2b < 720) {
                yPositionBackground2b = yPositionBackground2b + backvel;
                image(Background2b, x, yPositionBackground2b);
            }
            if (yPositionBackground2 < 720) {
                yPositionBackground2 = yPositionBackground2 + backvel;
                image(Background2, x, yPositionBackground2);
            }
            image(Background3a, x, yPositionBackground3a);
            image(Background3b, x, yPositionBackground3b);
            image(Background3c, x, yPositionBackground3c);
            image(Background3d, x, yPositionBackground3d);
            yPositionBackground3a += backvel;
            yPositionBackground3b += backvel;
            yPositionBackground3c += backvel;
            yPositionBackground3d += backvel;
            if (yPositionBackground3d >= 0) {
                yPositionBackground3a = yPositionBackground3d - 720;
                yPositionBackground3b = yPositionBackground3a - 720;
                yPositionBackground3c = yPositionBackground3b - 720;
            }
            if (yPositionBackground3d > 720) {
                yPositionBackground3d = yPositionBackground3c - 720;
            }
            image(sign3, 150, yPositionSing3);
            yPositionSing3 += velSings;
        }

        if (timer3 > 98) {
            if (yPositionLineMeta < yPositionCarplayer) {
                yPositionLineMeta += backvel;
            } else {
                backvel = 0;
                vel = 0;
            }
            image(line_meta, 270, yPositionLineMeta);
        }
        this.texField();
        this.crash();
        this.generateCars();
        this.generateAnimals();
        image(carplayers[auxGarage], xPostionCarplayer, yPositionCarplayer);

        if (life == 0) {
            if (swLife == true) {
                if (swSoundGameOver == true) {
                    GameOver.play();
                    swSoundGameOver = false;
                }
                velSings = 0;
                backvel = 0;
                vel = 0;
                move = false;
                exit.resize(80, 90);
                retry.resize(80, 90);
                image(gameOver, 350, 0);
                image(exit, 540, 330);
                image(retry, 660, 330);
                Level1.stop();
                Level2.stop();
                Level3.stop();
                swButtonRetrying = true;
                swButtonExiting = true;
                this.mouseClicked();
            }
        }
        // Menú desplegable de pausa
        if (pause == 0) {
            velResume = vel;
            backVelResume = backvel;
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
            move = false;
            backvel = 0;
            vel = 0;
            velSings = 0;
            swButtonExiting = true;
            swButtonRetrying = true;
            keyTime = true;

        }
        // Se reanuda el juego despues de una pausa
        if (pause == 3) {
            switch (sw) {
            case 1:
                Level1.loop(100);
                break;
            case 2:
                Level2.loop(100);
                break;
            case 3:
                Level3.loop(100);
                break;
            }
            if (keyTime) {
                aux_time = timer2 - timer3 - 3;
                keyTime = false;
            }
            move = true;
            vel = velResume;
            backvel = backVelResume;
            velSings = 7;
            pause = 0;

        }
        // Evento de haber ganado el juego
        if (timer3 == 100) {
            move = false;
            exit.resize(80, 90);
            retry.resize(80, 90);
            image(youwin, 494, 17);
            image(exit, 540, 300);
            image(retry, 660, 300);
            if (swSoundYouWin) {
                SoundYouWin.setFramePosition(0);
                SoundYouWin.loop(100);
                swSoundYouWin = false;
            }
            swButtonExiting = true;
            swButtonRetrying = true;
        }
        if (timer3 > 80) {
            this.meteorite();
        }

    }

    // Método que lanza el modo de juego libre.

    public void freeRace() {

        image(chooseMaps, 0, 0);
        image(marco4, xPositionmarco4, yPositionmarco4);

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
            image(instructions2, 0, 0);
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
            carplayers[auxGarage].resize(width, height);
            soundLobby.stop();
            if (SaveSounds) {
                if (swSoundStartRace == true) {
                    StartRace.play();
                    swSoundStartRace = false;
                }
            }
            if (captureTime) {
                aux = timer;
                captureTime = false;
            }
            timer2 = timer - aux;
            if (contador) {
                image(stageFR1, x, y);
                image(carplayers[auxGarage], xPostionCarplayer, yPositionCarplayer);
                filter(BLUR, 5);
                textFont(fuente);
                fill(255, 255, 255);
                textSize(120);
                text(3 - timer2, 600, 360);
            }
            if (timer2 > 3) {
                if (move == true) {
                    timer3 = timer2 - 3 - aux_time;
                }
                contador = false;
                switch (swFR) {
                case 1:
                    if (SaveSounds) {
                        if (swSoundLevel1 == true) {
                            Level1.setFramePosition(0);
                            Level1.loop(100);
                            swSoundLevel1 = false;
                        }
                    }
                    image(Background, x, yFR);
                    image(Background, x, yBackgroundFR);
                    yFR = yFR + backvel;
                    yBackgroundFR = yBackgroundFR + backvel;
                    if (yFR >= 720) {
                        yFR = 0;
                        yBackgroundFR = -720;
                    }
                    image(sign, 150, YpositionSing);
                    YpositionSing += velSings;
                    image(carplayers[auxGarage], xPostionCarplayer, yPositionCarplayer);
                    break;
                case 2:
                    if (SaveSounds) {
                        if (swSoundLevel2 == true) {
                            Level2.setFramePosition(0);
                            Level2.loop(100);
                            swSoundLevel2 = false;
                        }
                    }
                    image(Background2, x, yBackground2FR);
                    image(Background2b, x, yPositionBackground2bFR);
                    yBackground2FR = yBackground2FR + backvel;
                    yPositionBackground2bFR = yPositionBackground2bFR + backvel;
                    if (yBackground2FR >= 720) {
                        yBackground2FR = yPositionBackground2bFR - 720;
                    }
                    if (yPositionBackground2bFR >= 720) {
                        yPositionBackground2bFR = yBackground2FR - 720;
                    }
                    image(sign2, 150, yPositionSing2);
                    yPositionSing2 += velSings;
                    image(carplayers[auxGarage], xPostionCarplayer, yPositionCarplayer);
                    break;
                case 3:
                    Level2.stop();
                    if (SaveSounds) {
                        if (swSoundLevel3 == true) {
                            Level3.setFramePosition(0);
                            Level3.loop(100);
                            swSoundLevel3 = false;
                        }
                    }
                    image(Background3a, x, yPositionBackground3aFR);
                    image(Background3b, x, yPositionBackground3bFR);
                    image(Background3c, x, yPositionBackground3cFR);
                    image(Background3d, x, yPositionBackground3dFR);
                    yPositionBackground3aFR += backvel;
                    yPositionBackground3bFR += backvel;
                    yPositionBackground3cFR += backvel;
                    yPositionBackground3dFR += backvel;
                    if (yPositionBackground3dFR >= 0) {
                        yPositionBackground3aFR = yPositionBackground3dFR - 720;
                        yPositionBackground3bFR = yPositionBackground3aFR - 720;
                        yPositionBackground3cFR = yPositionBackground3bFR - 720;
                    }
                    if (yPositionBackground3dFR >= 720) {
                        yPositionBackground3dFR = yPositionBackground3cFR - 720;
                    }
                    image(sign3, 150, yPositionSing3);
                    yPositionSing3 += velSings;
                    if (timer3 > 99) {
                        yPositionLineMeta += backvel;
                        image(line_meta, 275, yPositionLineMeta);
                    }
                    break;
                }
                this.crash();
                this.textFieldFR();
                this.generateCars();
                this.generateAnimals();
                image(carplayers[auxGarage], xPostionCarplayer, yPositionCarplayer);
            }
        }
        // Perdida de las 3 vidas.
        if (life == 0) {
            if (swLife == true) {
                if (swSoundGameOver == true) {
                    GameOver.play();
                    swSoundGameOver = false;
                }
                backvel = 0;
                vel = 0;
                move = false;
                exit.resize(80, 90);
                retry.resize(80, 90);
                image(gameOver, 350, 0);
                image(exit, 540, 330);
                image(retry, 660, 330);
                Level1.stop();
                Level2.stop();
                Level3.stop();
                swButtonRetrying = true;
                swButtonExiting = true;
                this.mouseClicked();
            }
        }
        if (pause == 0) {
            velResume = vel;
            backVelResume = backvel;
        }
        if (pause == 1) {
            image(menuPause, 380, 84);
            move = false;
            backvel = 0;
            vel = 0;
            velSings = 0;
            swButtonExiting = true;
            swButtonRetrying = true;
            keyTime = true;
            keyRenaudar = true;
            switch (swFR) {
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

        }
        if (pause == 3) {
            switch (swFR) {
            case 1:
                Level1.loop(100);
                break;
            case 2:
                Level2.loop(100);
                break;
            case 3:
                Level3.loop(100);
                break;
            }
            if (keyTime) {
                aux_time = timer2 - timer3 - 3;
                keyTime = false;
            }
            move = true;
            vel = velResume;
            backvel = backVelResume;
            velSings = 7;
            pause = 0;

        }
    }

    // Método que genera los carros rivales.

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

    // Método de generación de animales

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

    // Método de colisión de autos

    public void crash() {

        for (int h = 0; h < car_up.length; h++) {
            if (xPostionCarplayer > ordenadasizquierda[h] + width - 10) {

            } else if (xPostionCarplayer + width < ordenadasizquierda[h] + 10) {

            } else if (yPositionCarplayer > abcisa[h] + height - 10) {

            } else if (yPositionCarplayer + height < abcisa[h] + 10) {

            } else {
                soundBomm.play();
                if(life>0){
                    life = life - 1;
                }
                image(less, 1123, 14);
                xPositionColision = ordenadasizquierda[h];
                yPositionColision = abcisa[h];
                if (yPositionColision <= 558) {
                    image(boom, xPositionColision, yPositionColision);
                } else if (yPositionColision > 558) {
                    image(boom, xPositionColision, yPositionColision - 100);
                }
                abcisa[h] = 720;
                xPostionCarplayer = 600;
            }
            if (xPostionCarplayer > ordenadasderecha[h] + width - 10) {

            } else if (xPostionCarplayer + width < ordenadasderecha[h] + 10) {

            } else if (yPositionCarplayer > abcisa1[h] + height - 10) {

            } else if (yPositionCarplayer + height < abcisa1[h] + 10) {

            } else {
                soundBomm.play();
                life = life - 1;
                xPositionColision = ordenadasderecha[h];
                yPositionColision = abcisa1[h];
                if (yPositionColision <= 558) {
                    image(boom, xPositionColision, yPositionColision);
                } else if (yPositionColision > 558) {
                    image(boom, xPositionColision, yPositionColision - 100);
                }
                abcisa1[h] = 720;
                xPostionCarplayer = 600;
            }
        }
    }

    // Método que despliega el textfield del modo carrera

    public void texField() {
        Float distancia = (velResume * timer3) / 100;
        Float score = (distancia + timer3) * 2;
        heart.resize(24, 23);
        check.resize(32, 32);
        image(heart, 1092, yPositionText - 19);
        if (timer3 >= 33) {
            image(check, 1233, yPositionText * 19);
        }
        if (timer3 >= 66) {
            image(check, 1233, yPositionText * 20);
        }
        if (timer3 >= 99) {
            image(check, 1233, yPositionText * 21);
        }
        textFont(fuente);
        fill(255, 255, 255);
        text(life + "P", 1055, yPositionText);
        text("Distancia:", 1055, yPositionText * 4);
        text(distancia + " km", 1055, yPositionText * 5);
        text("Velocidad:", 1055, yPositionText * 8);
        text(velResume + " km/h", 1055, yPositionText * 9);
        text("Tiempo:", 1055, yPositionText * 12);
        text(timer3 + " s", 1055, yPositionText * 13);
        text("Puntaje:", 1055, yPositionText * 16);
        text(score + " pts.", 1055, yPositionText * 17);
        text("Sincelejo    [ ]", 1055, yPositionText * 20);
        text("Cartagena    [ ]", 1055, yPositionText * 21);
        text("Barranquilla [ ]", 1055, yPositionText * 22);

    }

    // Método que despliega el textfield del modo libre

    public void textFieldFR() {
        Float distancia = (velResume * timer3) / 100;
        Float score = (distancia + timer3) * 2;
        heart.resize(24, 23);
        image(heart, 1098, yPositionText - 19);
        textFont(fuente);
        fill(255, 255, 255);
        text(life + "P", 1055, yPositionText);
        text("Distancia:", 1055, yPositionText * 5);
        text(distancia + " km", 1055, yPositionText * 6);
        text("Velocidad:", 1055, yPositionText * 10);
        text(velResume + " km/h", 1055, yPositionText * 11);
        text("Tiempo:", 1055, yPositionText * 15);
        text(timer3 + " s", 1055, yPositionText * 16);
        text("Puntaje:", 1055, yPositionText * 20);
        text(score + " pts.", 1055, yPositionText * 21);
    }

    // Método que recibe los datos del teclado.

    @Override
    public void keyPressed() {
        if (move == true) {
            if (keyPressed == true) {
                if (keyCode == RIGHT||key == wasD) {
                    if (xPostionCarplayer < 920) {
                        xPostionCarplayer = xPostionCarplayer + 50;
                    }
                }
                if (keyCode == LEFT||key == wAsd) {
                    if (xPostionCarplayer > 275) {
                        xPostionCarplayer = xPostionCarplayer - 50;
                    }
                }
                if (keyCode == UP||key == Wasd) {

                    for (int h = 0; h <= 14; h++) {

                        if (xPostionCarplayer > ordenadasanimales[h] + widthAnimals) {

                        } else if (xPostionCarplayer + width < ordenadasanimales[h]) {

                        } else if (yPositionCarplayer > abcisa2[h] + heightAnimals) {

                        } else if (yPositionCarplayer + height < abcisa2[h]) {

                        } else {
                            cont = cont + 1;
                            if (cont % 2 == 0) {
                                life++;
                                soundExtraLife.play();
                                image(plus, 1123, 14);
                            }
                            xPositionColision = ordenadasanimales[h] - 100;
                            yPositionColision = abcisa2[h];

                            if (yPositionColision <= 564) {
                                image(red, xPositionColision, yPositionColision);
                            } else if (yPositionColision > 564) {
                                image(red, xPositionColision, yPositionColision - 100);
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

    // Método que asegura que no exista colisión entre los animales y los carros
    // rivales.

    public void validacion() {
        for (int h = 0; h < ordenadasanimales.length; h++) {
            cont1 = 0;
            for (int i = 0; i < ordenadasderecha.length; i++) {
                if (ordenadasanimales[h] + 30 > ordenadasizquierda[i] + width) {
                    cont1 += 1;
                } else if (ordenadasanimales[h] + widthAnimals + 30 < ordenadasizquierda[i]) {
                    cont1 += 1;
                } else if (abcisa2[h] + 30 > abcisa[i] + height) {
                    cont1 += 1;
                } else if (abcisa2[h] + heightAnimals + 30 < abcisa[i]) {
                    cont1 += 1;
                } else {

                }

                if (ordenadasanimales[h] + 30 > ordenadasderecha[i] + width) {
                    cont1 += 1;
                } else if (ordenadasanimales[h] + widthAnimals + 30 < ordenadasderecha[i]) {
                    cont1 += 1;
                } else if (abcisa2[h] + 30 > abcisa1[i] + height) {
                    cont1 += 1;
                } else if (abcisa2[h] + heightAnimals + 30 < abcisa1[i]) {
                    cont1 += 1;
                } else {

                }
            }
            contadores[h] = cont1;
        }
    }

    // Método que raliza los eventos del mouse

    public void mouseClicked() {
        if (mousePressed == true) {
            if (mouseButton == LEFT) {
                if (scene == 1) {
                    // Lanza el modo de juego normal
                    if (mouseX > 500 && mouseX < 500 + 250) {
                        if (mouseY > 280 && mouseY < 280 + 50) {
                            scene = 2;
                            vel = newVel;
                            backvel = newVelBack;
                            pause = 0;
                        }
                    }
                    // Laza el modo de juego libre
                    if (mouseX > 500 && mouseX < 500 + 250) {
                        if (mouseY > 380 && mouseY < 380 + 50) {
                            scene = 3;
                            if (CaptureVelSave) {
                                vel = newVel;
                                backvel = newVelBack;
                                CaptureVelSave = false;
                                pause = 0;
                            }
                        }
                    }
                    // Laza el garage;
                    if (mouseX > 500 && mouseX < 500 + 250) {
                        if (mouseY > 480 && mouseY < 480 + 50) {
                            scene = 4;
                        }
                    }
                    // Laza el menu de opciones
                    if (mouseX > 500 && mouseX < 500 + 250) {
                        if (mouseY > 580 && mouseY < 580 + 50) {
                            scene = 5;
                        }
                    }
                    // lanza los creditos
                    if (mouseX > 940 && mouseX < 940 + 250) {
                        if (mouseY > 650 && mouseY < 650 + 50) {
                            scene = 6;
                        }
                    }

                }
                if (scene == 2) {
                    if (mouseX > 1098 && mouseX < 1223) {
                        if (mouseY > 639 && mouseY < 690) {
                            jugar = true;
                        }
                    }
                    if (life == 0 || timer3 == 100) {
                        if (move == false) {
                            if (mouseX > 540 && mouseX < 620) {
                                if (mouseY > 330 && mouseY < 420) {
                                    if (swButtonExiting) {
                                        this.exiting();
                                        swButtonExiting = false;
                                    }
                                }
                            }
                        }
                        if (mouseX > 660 && mouseX < 740) {
                            if (mouseY > 330 && mouseY < 420) {
                                if (swButtonRetrying) {
                                    this.retrying();
                                    swButtonRetrying = false;
                                }
                            }
                        }
                    }
                    if (pause == 1) {
                        if (mouseX > 481 && mouseX < 572) {
                            if (mouseY > 214 && mouseY < 306) {
                                if (swButtonRetrying) {
                                    this.retrying();
                                    pause = 0;
                                    swButtonRetrying = false;
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
                if (scene == 3) {
                    if (!launchFR) {
                        if (mouseX > 51 && mouseX < 403) {
                            if (mouseY > 233 && mouseY < 491) {
                                xPositionmarco4 = 41;
                                yPositionmarco4 = 223;
                                Maps = true;
                                stageFR1 = Background;
                                swFR = 1;
                            }
                        }
                        if (mouseX > 464 && mouseX < 816) {
                            if (mouseY > 233 && mouseY < 491) {
                                xPositionmarco4 = 454;
                                yPositionmarco4 = 223;
                                stageFR1 = Background2;
                                Maps = true;
                                swFR = 2;
                            }
                        }
                        if (mouseX > 877 && mouseX < 1229) {
                            if (mouseY > 233 && mouseY < 491) {
                                xPositionmarco4 = 867;
                                yPositionmarco4 = 223;
                                stageFR1 = Background3a;
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
                            scene = 1;
                            swSoundLobby = true;
                        }
                    }
                    if (life == 0) {
                        if (move == false) {
                            if (mouseX > 540 && mouseX < 620) {
                                if (mouseY > 330 && mouseY < 420) {
                                    if (swButtonExiting) {
                                        this.exitingFR();
                                        swButtonExiting = false;
                                    }
                                }
                            }
                        }
                        if (mouseX > 660 && mouseX < 740) {
                            if (mouseY > 330 && mouseY < 420) {
                                if (swButtonRetrying) {
                                    this.retryingFR();
                                    swButtonRetrying = false;
                                }
                            }
                        }
                    }
                    if (pause == 1) {
                        if (mouseX > 481 && mouseX < 572) {
                            if (mouseY > 214 && mouseY < 306) {
                                if (swButtonRetrying) {
                                    this.retryingFR();
                                    pause = 0;
                                    swButtonRetrying = false;
                                }
                            }
                        }
                        if (mouseX > 708 && mouseX < 799) {
                            if (mouseY > 214 && mouseY < 306) {
                                if (swButtonExiting) {
                                    this.exitingFR();
                                    pause = 0;
                                    swButtonExiting = false;
                                }
                            }
                        }
                        if (mouseX > 491 && mouseX < 789) {
                            if (mouseY > 323 && mouseY < 384) {
                                if (keyRenaudar) {
                                    pause = 3;
                                    keyRenaudar = false;
                                }
                            }
                        }
                    }
                }
                if (scene == 4) {
                    if (mouseX > 800 && mouseX < 860) {
                        if (mouseY > 250 && mouseY < 310) {
                            m = 0;
                            xPositionmarco = 793;
                            yPositionmarco = 243;
                            swSoundSpray = true;

                        }
                    }
                    if (mouseX > 900 && mouseX < 960) {
                        if (mouseY > 250 && mouseY < 310) {
                            m = 1;
                            xPositionmarco = 893;
                            yPositionmarco = 243;
                            swSoundSpray = true;

                        }
                    }
                    if (mouseX > 1000 && mouseX < 1060) {
                        if (mouseY > 250 && mouseY < 310) {
                            m = 2;
                            xPositionmarco = 993;
                            yPositionmarco = 243;
                            swSoundSpray = true;

                        }
                    }
                    if (mouseX > 800 && mouseX < 860) {
                        if (mouseY > 350 && mouseY < 410) {
                            m = 3;
                            xPositionmarco = 793;
                            yPositionmarco = 343;
                            swSoundSpray = true;

                        }
                    }
                    if (mouseX > 900 && mouseX < 960) {
                        if (mouseY > 350 && mouseY < 410) {
                            m = 4;
                            xPositionmarco = 893;
                            yPositionmarco = 343;
                            swSoundSpray = true;

                        }
                    }
                    if (mouseX > 1000 && mouseX < 1060) {
                        if (mouseY > 350 && mouseY < 410) {
                            m = 5;
                            xPositionmarco = 993;
                            yPositionmarco = 343;
                            swSoundSpray = true;

                        }
                    }
                    if (mouseX > 800 && mouseX < 860) {
                        if (mouseY > 450 && mouseY < 510) {
                            m = 6;
                            xPositionmarco = 793;
                            yPositionmarco = 443;
                            swSoundSpray = true;

                        }
                    }
                    if (mouseX > 900 && mouseX < 960) {
                        if (mouseY > 450 && mouseY < 510) {
                            m = 7;
                            xPositionmarco = 893;
                            yPositionmarco = 443;
                            swSoundSpray = true;

                        }
                    }
                    if (mouseX > 1000 && mouseX < 1060) {
                        if (mouseY > 450 && mouseY < 510) {
                            m = 8;
                            xPositionmarco = 993;
                            yPositionmarco = 443;
                            swSoundSpray = true;

                        }
                    }
                    if (mouseX > 57 && mouseX < 186) {
                        if (mouseY > 73 && mouseY < 102) {
                            scene = 1;
                        }
                    }
                    if (mouseX > 800 && mouseX < 1060) {
                        if (mouseY > 550 && mouseY < 610) {
                            auxGarage = m;
                            scene = 1;

                        }
                    }
                }
                if (scene == 5) {
                    if (mouseX > 57 && mouseX < 186) {
                        if (mouseY > 73 && mouseY < 102) {
                            scene = 1;
                        }
                    }
                    if (mouseX > 467 && mouseX < 612) {
                        if (mouseY > 286 && mouseY < 341) {
                            xPositionmarco2 = 465;
                            yPositionmarco2 = 281;
                            playSounds = true;

                        }
                    }
                    if (mouseX > 657 && mouseX < 802) {
                        if (mouseY > 286 && mouseY < 341) {
                            xPositionmarco2 = 655;
                            yPositionmarco2 = 281;
                            playSounds = false;
                        }
                    }
                    if (mouseX > 360 && mouseX < 505) {
                        if (mouseY > 508 && mouseY < 563) {
                            xPositionmarco3 = 357;
                            yPositionmarco3 = 503;
                            difficulty = 2;
                            vel = 5;
                            backvel = 10;
                            newVel = 5;
                            newVelBack = 10;
                        }
                    }
                    if (mouseX > 568 && mouseX < 713) {
                        if (mouseY > 508 && mouseY < 563) {
                            xPositionmarco3 = 565;
                            yPositionmarco3 = 503;
                            difficulty = 5;
                            newVel = 10;
                            vel = 10;
                            backvel = 20;
                            newVel = 10;
                            newVelBack = 20;
                        }
                    }
                    if (mouseX > 776 && mouseX < 921) {
                        if (mouseY > 508 && mouseY < 563) {
                            xPositionmarco3 = 773;
                            yPositionmarco3 = 503;
                            difficulty = 8;
                            vel = 15;
                            backvel = 25;
                            newVel = 15;
                            newVelBack = 25;
                        }
                    }
                    if (mouseX > 1107 && mouseX < 1252) {
                        if (mouseY > 639 && mouseY < 694) {
                            scene = 1;
                            savedifficulty = difficulty;
                            SaveSounds = playSounds;
                            delay(300);
                        }
                    }
                }
                if (scene == 6) {
                    swSoundCredits = true;
                    if (subscene == 1) {
                        if (mouseX > 1136 && mouseX < 1189) {
                            if (mouseY > 600 && mouseY < 663) {
                                subscene = 2;
                                changeSubscene = false;
                            }
                        }
                    }
                    if (subscene == 2) {
                        if (mouseX > 91 && mouseX < 144) {
                            if (mouseY > 602 && mouseY < 666) {
                                subscene = 1;
                            }
                        }
                        if (mouseX > 1092 && mouseX < 1237) {
                            if (mouseY > 34 && mouseY < 89) {
                                scene = 1;
                                SoundCredits.stop();
                                swSoundLobby = true;
                            }
                        }
                    }
                }
            }

        }
    }

    // Método que despliega los créditos

    public void credits() {
        soundLobby.stop();
        if (SaveSounds) {
            if (swSoundCredits) {
                SoundCredits.loop(100);
                swSoundCredits = false;
            }
        }

        switch (subscene) {
        case 1:
            image(credits1, 0, 0);
            fill(255, 255, 255);
            triangle(1136, 600, 1136, 663, 1189, 634);

            fill(5, 5, 5);
            rect(1078, 539, 66, 153);

            break;
        case 2:
            image(credits2, 0, 0);
            fill(255, 255, 255);
            triangle(91, 634, 144, 602, 144, 666);

            break;
        }
        this.mouseClicked();
    }

    // Método que ejecuta la salida del modo de juego carrera

    public void exiting() {
        scene = 1;
        this.retrying();
        jugar = false;
        swSoundLobby = true;
    }

    // Método que ejecuta la salida del modo de juego carrera libre

    public void exitingFR() {
        scene = 1;
        this.retryingFR();
        launchIns = false;
        CaptureVelSave = true;
        launchFR = false;
        swSoundLobby = true;
    }

    // Método para reiniciar una carrera en el modo carrera

    public void retrying() {

        backvel = newVelBack;
        vel = newVel;
        YpositionSing = -200;
        yPositionSing2 = -200;
        yPositionSing3 = -200;
        velSings = 7;
        y = 0;
        yBackground = -720;
        yPositionBackground2 = -1440;
        yPositionBackground2b = -720;
        yPositionBackground3a = -720;
        yPositionBackground3b = -1440;
        yPositionBackground3c = -2160;
        yPositionBackground3d = -2880;
        xPostionCarplayer = 600;
        yPositionCarplayer = 520;
        yPositionSincelejoKid = -246;
        yCartagenaKids = -250;
        yPositionLineMeta = -83;
        life = 3;
        posx_i = -150;
        posx_f = 1430;
        posy_i = -150;
        posy_f = 870;
        pos_act_x = posx_f;
        pos_act_y = posy_i;
        paso = (float) 0.01;
        pct = (float) 0.0;
        move = true;
        swSoundStartRace = true;
        swSoundLobby = true;
        swSoundGameOver = true;
        swSoundLevel2 = true;
        swSoundLevel3 = true;
        swSoundLevel1 = true;
        contador = true;
        swSoundYouWin = true;
        captureTime = true;
        key1 = true;
        aux_time = 0;
        yPositionSincelejoKid = -246;
        yCartagenaKids = -250;
        Level1.stop();
        Level2.stop();
        Level3.stop();

        acciones.shuffle(car_down_shuffle, car_down);
        acciones.shuffle(car_up_shuffle, car_up);
        acciones.shuffle(animals_shuffle, animals);

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

    // Método para reiniciar una carrera en el modo libre

    public void retryingFR() {
        backvel = 20;
        vel = 10;
        YpositionSing = -200;
        yPositionSing2 = -200;
        yPositionSing3 = -200;
        velSings = 7;
        yFR = 0;
        aux_time = 0;

        yBackgroundFR = -720;
        yBackground2FR = 0;
        yPositionBackground2bFR = -720;
        yPositionBackground3aFR = 0;
        yPositionBackground3bFR = -720;
        yPositionBackground3cFR = -1440;
        yPositionBackground3dFR = -2160;
        xPostionCarplayer = 600;
        yPositionCarplayer = 520;
        life = 3;

        move = true;
        swSoundStartRace = true;
        swSoundLobby = true;
        swSoundGameOver = true;
        swSoundLevel2 = true;
        swSoundLevel3 = true;
        swSoundLevel1 = true;
        contador = true;
        captureTime = true;
        key1 = true;
        keyTime = true;
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