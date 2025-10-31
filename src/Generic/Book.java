package Generic;

class Book<T> implements writer<T> {

    @Override
    public void update(T obj) {
        // do something
    }

    @Override
    public void delete(T obj) {
        // do something
    }

    @Override
    public void write(T obj) {
        // do something
    }

}
