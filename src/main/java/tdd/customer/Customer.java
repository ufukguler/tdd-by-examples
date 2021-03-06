package tdd.customer;

import tdd.lombok.Gift;

import java.util.ArrayList;
import java.util.List;

/**
 * created by: ufuk on 7.10.2020 18:14
 */
public class Customer {
    String name;
    int id;
    private List<Gift> gifts = new ArrayList<>();

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

    public void addGift(Gift gift) {
        gifts.add(gift);
    }

    public List<Gift> getGifts() {
        return gifts;
    }
}
