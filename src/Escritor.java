import java.io.IOException;
import java.io.PipedOutputStream;

public class Escritor extends Thread {
    private PipedOutputStream salida;

    public Escritor(PipedOutputStream salida) {
        this.salida = salida;
    }

    public void run() {
        try {
            String[] mensajes = {"Hola desde el proceso Escritor.", "Esto es un mensaje.", "Fin de la comunicación."};
            for (String mensaje : mensajes) {
                salida.write(mensaje.getBytes()); // Escribir el mensaje en la salida
                salida.write(System.lineSeparator().getBytes()); // Añadir una nueva línea
                salida.flush(); // Asegurarse de que se envían los datos
                Thread.sleep(1000); // Espera 1 segundo entre mensajes
            }
            salida.close(); // Cerrar la salida al finalizar
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
