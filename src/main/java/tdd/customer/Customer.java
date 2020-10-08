package tdd.customer;

/**
 * created by: ufuk on 7.10.2020 18:14
 */
public class Customer {
    String name;
    int id;

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + " Id: " + this.id;
    }
}
