public class Barber implements Runnable {

    private static final int SERVICE_TIME = 1500;
    private Barbershop barbershop;
    public Barber(Barbershop barbershop) {
        this.barbershop = barbershop;
    }

    @Override
    public void run() {
        while (barbershop.isOpen()) {
            Customer customer = barbershop.getCustomer();
            System.out.println("Парикмахер работает...");
            System.out.println("Клиент " + customer.getCustomerId() + " закончил стичься");
            try {
                Thread.sleep(SERVICE_TIME);
            }
            catch (InterruptedException e) {
                System.out.println("Не достригли!");
            }


            if (barbershop.thereIsQueue()) {
                System.out.println("Парикмахер зовёт следующего клиента");
                barbershop.serveCustomer(barbershop.getNextCustomer());
            }
            else {
                System.out.println("Зал ожидания пуст, парикмахер чистит место и спит");
                barbershop.cleanWorkplace();
            }
        }
    }
}
