import java.io.IOException;
import java.util.concurrent.Semaphore;
import java.util.Random;
public class Cliente implements Runnable{
    private int ID;
    private Semaphore puerta;
    private int unidades_disp;

    public Cliente(int ID, Semaphore puerta, int unidades_disp) {
        this.ID = ID;
        this.puerta = puerta;
        this.unidades_disp = unidades_disp;    }
    @Override
    public void run() {
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {  //las veces q va a intentar entrar un cliente por la puerta
            try {
                puerta.acquire(); // Intenta adquirir un permiso
                if (unidades_disp > 0) {
                    System.out.println("Cliente " + ID + " entró en la tienda.");
                    unidades_disp--;
                    System.out.println("Cliente " + ID + " compró una PlayStation 5.");
                } else {
                    System.out.println("Cliente " + ID + " entró en la tienda, pero no quedan PlayStation 5 disponibles.");
                }

            }catch(InterruptedException e) {
                e.printStackTrace();
            } finally {
                puerta.release(); // liberar el semáforo cuando hayas terminado
            }
            try {
                // Wait for a random amount of time between attempts
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
