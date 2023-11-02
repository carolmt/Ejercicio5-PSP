public class BufferCircular {
    private int[] buffer;
    private int capacidad;
    private int inicio;
    private int fin;
    private int elementos;

    public BufferCircular(int capacidad) {
        this.capacidad = capacidad;
        buffer = new int[capacidad];
        inicio = 0;
        fin = 0;
        elementos = 0;
    }

    public synchronized void producir_dato(int dato, int productorId) throws InterruptedException {
        while (elementos == capacidad) {
            System.out.println("Productor " + productorId + " esperando, buffer lleno.");
            wait();
        }
        buffer[fin] = dato;
        fin = (fin + 1) % capacidad;
        elementos++;
        notifyAll();
    }

    public synchronized int consumir_dato(int consumidorId) throws InterruptedException {
        while (elementos == 0) {
            System.out.println("Consumidor " + consumidorId + " esperando, buffer vacío.");
            wait();
        }
        int valor = buffer[inicio];
        inicio = (inicio + 1) % capacidad;
        elementos--;
        notifyAll();
        return valor;
    }

    public boolean estaVacio() {
        return elementos == 0;
    }

    public boolean estaLleno() {
        return elementos == capacidad;
    }
}
