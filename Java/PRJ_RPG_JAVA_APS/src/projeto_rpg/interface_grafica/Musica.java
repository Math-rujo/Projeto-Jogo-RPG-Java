package projeto_rpg.interface_grafica;

import javax.sound.sampled.*;
import java.io.File;
import java.util.Random;

public class Musica {

    private Clip clip;

    private String[] musicas = {
            "src/resources/audio/musica_RPG_1.wav",
            "src/resources/audio/musica_RPG_2.wav"
    };

    private int musicaAtual;

    public void iniciarPlaylist() {

        // Escolhe aleatoriamente
        Random random = new Random();

        musicaAtual = random.nextInt(musicas.length);

        tocarMusica();
    }

    private void tocarMusica() {

        try {

            File arquivo = new File(musicas[musicaAtual]);

            AudioInputStream audio =
                    AudioSystem.getAudioInputStream(arquivo);

            clip = AudioSystem.getClip();

            clip.open(audio);

            clip.start();

            // Quando a música terminar
            clip.addLineListener(event -> {

                if(event.getType() == LineEvent.Type.STOP) {

                    clip.close();

                    // Espera 5 segundos
                    new Thread(() -> {

                        try {

                            Thread.sleep(5000);

                        } catch (InterruptedException e) {

                            e.printStackTrace();
                        }

                        // Alterna música
                        musicaAtual++;

                        if(musicaAtual >= musicas.length) {

                            musicaAtual = 0;
                        }

                        tocarMusica();

                    }).start();
                }
            });

        } catch (Exception e) {

            System.out.println("Erro ao tocar música!");

            e.printStackTrace();
        }
    }

    public void parar() {

        if(clip != null) {

            clip.stop();

            clip.close();
        }
    }
}