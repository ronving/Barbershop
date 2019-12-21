import java.util.Random;

public class CustomersGate implements Runnable {
    private Barbershop barbershop;
    private Random rand;
    private int frequency;

    public CustomersGate(Barbershop bs, int freq) {
        barbershop = bs;
        frequency = freq;
        rand = new Random();
    }

    @Override
    public void run() {
        while (barbershop.isOpen()) {
            try {
                Thread.sleep(rand.nextInt(frequency));
            } catch (InterruptedException e) {
                System.out.println("Появился клиент");
            }
            Customer customer = new Customer();
            System.out.println("Приходит клиент " + customer.getCustomerId());
            if (barbershop.thereIsQueue()) {
                System.out.println("Клиент " + customer.getCustomerId() + " видит очередь");
                if (barbershop.havePlaceToWait()) {
                    System.out.println("Клиент " + customer.getCustomerId() + " видит место, садится ждать");
                    barbershop.addToQueue(customer);
                } else {
                    System.out.println("Клиент " + customer.getCustomerId() + " так как больше нет мест");
                    //customer = null;
                }
            } else {
                if (barbershop.readyToService()) {
                    System.out.println("Клиент " + customer.getCustomerId() + " садится в кресло");
                    barbershop.serveCustomer(customer);
                } else {
                    System.out.println("Клиент " + customer.getCustomerId() + " садится в очередь");
                    barbershop.addToQueue(customer);
                }
            }
        }
    }
}
