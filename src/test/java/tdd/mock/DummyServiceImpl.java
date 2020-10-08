package tdd.mock;

/**
 * created by: ufuk on 8.10.2020 20:52
 */

public class DummyServiceImpl implements DummyService {
    @Override
    public void add(String name) {
        System.out.println("add(): " + name);
    }

    @Override
    public void remove(String name) {
        System.out.println("remove(): " + name);
    }

    @Override
    public void update(String name) {
        System.out.println("update(): " + name);
    }

    @Override
    public String get(String name) {
        return "get(): " + name;
    }
}
