public class Customer {

    private static int id = 1;
    int customerId;

    public Customer() {
        customerId = id++;
    }

    public int getCustomerId() {
        return customerId;
    }
}
