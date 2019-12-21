import java.util.LinkedList;
import java.util.Queue;

public class Barbershop {

    private boolean open;
    private int numberOfSeats;
    private Queue<Customer> queue;
    private Customer currentCustomer;

    public Barbershop(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
        queue = new LinkedList<>();
        currentCustomer = null;
        open = true;
    }

    public synchronized boolean isOpen() {
        return open;
    }

    public synchronized void close() {
        open = false;
        notifyAll();
    }

    public synchronized boolean thereIsQueue() {
        return ! queue.isEmpty();
    }

    public synchronized boolean havePlaceToWait() {
        return queue.size() < numberOfSeats;
    }

    public synchronized boolean readyToService() {
        return currentCustomer == null;
    }


    public synchronized void serveCustomer(Customer customer) {
        currentCustomer = customer;
        notifyAll();
    }

    public synchronized void cleanWorkplace() {
        currentCustomer = null;
    }

    public synchronized void addToQueue(Customer customer) {
        queue.add(customer);
    }

    public synchronized Customer getNextCustomer() {
        return queue.remove();
    }

    public synchronized Customer getCustomer() {
        while (readyToService()) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                System.out.println("Не дождались клиентов...");
            }
        }
        return currentCustomer;
    }
}
