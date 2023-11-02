public class LanzadorHilos {

    public static void main(String[] args) {
        BufferCircular buffer = new BufferCircular(4);
        Productor prod1 = new Productor(1, buffer);
        Productor prod2 = new Productor(2, buffer);
        Productor prod3 = new Productor(3, buffer);
        Consumidor cons1 = new Consumidor(1, buffer);
        Consumidor cons2 = new Consumidor(2, buffer);

        Thread hiloProd1 = new Thread(prod1);
        Thread hiloProd2 = new Thread(prod2);
        Thread hiloProd3 = new Thread(prod3);
        Thread hiloCons1 = new Thread(cons1);
        Thread hiloCons2 = new Thread(cons2);

        hiloProd1.start();
        hiloProd2.start();
        hiloProd3.start();
        hiloCons1.start();
        hiloCons2.start();
    }
}
