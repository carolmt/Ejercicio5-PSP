import java.util.concurrent.Semaphore;
import java.util.Random;
public class Concurrencia {
    public static void main(String[] args) {
        int clientesTotales = 200;
        int unidades_disp = 20;
        Semaphore puerta = new Semaphore(1);

        for (int i = 1; i <= clientesTotales ; i++) {
            Cliente c = new Cliente(i, puerta, unidades_disp);

        }
    }
}
