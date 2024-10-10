import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Comunicación entre un proceso escritor y un proceso lector utilizando tuberías en Java, asegurando que los mensajes
 * se envían y se reciben correctamente.
 * Una vez que ambos procesos han terminado su ejecución, se imprime un mensaje final.
 */
public class ComProTuberias {
    public static void main(String[] args) {
        try {
            System.out.println("Directorio de trabajo del método main: " + System.getProperty("user.dir"));

            // Crear tuberías
            PipedOutputStream salidaEscritor = new PipedOutputStream();
            PipedInputStream entradaLector = new PipedInputStream(salidaEscritor);

            // Crear el proceso Escritor
            Escritor escritor = new Escritor(salidaEscritor);
            // Crear el proceso Lector
            Lector lector = new Lector(entradaLector);

            // Iniciar los procesos
            escritor.start();
            lector.start();

            // Esperar a que ambos procesos terminen
            escritor.join();
            lector.join();

            System.out.println("Ambos procesos han finalizado.");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
