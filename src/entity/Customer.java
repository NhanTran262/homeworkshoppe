package entity;

public class Customer extends User {
    private long wallet;

    public Customer(int id, String userName, String password) {
        super(id, userName, password);
    }

    public Customer(int id, String userName, String password, long wallet) {
        super(id, userName, password);
        this.wallet = wallet;
    }

    public long getWallet() {
        return wallet;
    }

    public void setWallet(long wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "Customer{" +

                ", id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", wallet=" + wallet +
                '}';
    }
}
