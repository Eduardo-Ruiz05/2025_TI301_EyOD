
package PRUEBAS;
import java.applet.*;
import java.net.*;

public class Audios {

    
    public static void main(String[] args) {
        try {
            // Asegúrate de que 'mi_audio.wav' esté en tu proyecto
            URL url = Audios.class.getResource("Cooking");
            if (url != null) {
                AudioClip sonido = java.applet.Applet.newAudioClip(url);
                sonido.play(); // Para reproducir una vez
                // sonido.loop(); // Para reproducir en bucle
            } else {
                System.out.println("No se encontró el archivo de audio.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
