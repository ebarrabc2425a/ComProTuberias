import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;

public class Lector extends Thread {
    private PipedInputStream entrada;

    public Lector(PipedInputStream entrada) {
        this.entrada = entrada;
    }

    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(entrada))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println("Lector ha recibido: " + linea); // Imprimir la línea recibida
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
