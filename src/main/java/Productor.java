public class Productor implements Runnable{
    private int productorID;
    private BufferCircular buffer;

    public Productor(int productorID, BufferCircular buffer) {
        this.productorID = productorID;
        this.buffer = buffer;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 30; i++) {
            try {
                int dato = i;
                long tiempo_espera = (long) (Math.random() * 2000); // Espera aleatoria de 0 a 2 segundos
                Thread.sleep(tiempo_espera);
                buffer.producir_dato(dato, productorID);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}