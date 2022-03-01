package Generic;

interface writer<T> {
    void update(T obj);
    void delete(T obj);
    void write(T obj);

}
