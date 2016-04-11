public class Employee {
    private Address[] addresses;
    private int hours;
    private double rate;
    private String name;

    public Employee(String name, int hours, double rate, Address[] adresse) {
        this.name = name;
        this.hours = hours;
        this.addresses = adresse;
        this.rate = rate;
    }
}

