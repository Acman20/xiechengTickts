package model;

/*票的数量*/
public class Ticket {
    private final String name;
    private final double prince;
    private final int amount;

    public Ticket(String name, double prince, int amount) {
        this.name = name;
        this.prince = prince;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getPrince() {
        return prince;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "name='" + name + '\'' +
                ", prince=" + prince +
                ", amount=" + amount +
                '}';
    }
}
