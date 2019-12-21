public class BarbershopSystem {
    private static final int MAX_PLACES = 5;
    private static final long WORKING_TIME = 10000L;
    private static final int CUSTOMERS_FREQUENCY = 2000;

    public BarbershopSystem() {
        start();
    }

    public void start() {
        Barbershop barbershop = new Barbershop(MAX_PLACES);
        Barber barber = new Barber(barbershop);
        CustomersGate gate = new CustomersGate(barbershop, CUSTOMERS_FREQUENCY);

        Thread barberThread = new Thread(barber);
        barberThread.start();

        Thread gateThread = new Thread(gate);
        gateThread.start();

        try {
            Thread.sleep(WORKING_TIME);
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }

        System.out.println("Парикмахерская закрывается");

        barbershop.close();
        System.exit(0);
    }
}
