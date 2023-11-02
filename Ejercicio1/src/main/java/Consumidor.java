import static java.lang.Thread.sleep;

public class Consumidor implements Runnable{
    private int consumidorID;
    private BufferCircular buffer;

    public Consumidor(int consumidorID, BufferCircular buffer) {
        this.consumidorID = consumidorID;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 30; i++) {
            try {
                int valor = buffer.consumir_dato(consumidorID);
                long tiempo_espera = (long) (Math.random() * 2000); // Espera aleatoria de 0 a 2 segundos
                Thread.sleep(tiempo_espera);
                System.out.println("Consumidor " + consumidorID + " consume: " + valor);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}