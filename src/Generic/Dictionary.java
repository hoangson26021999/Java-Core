package Generic;

public class Dictionary <K,V> {
    private K key;
    private V value;

    public Dictionary(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
 class DemoGeneric {
    public static void main(String[] args) {
        Dictionary<String, String> d = new Dictionary<>("Study", "hoc");
        String english = d.getKey();
        String vietnamese = d.getValue();
        System.out.println(english + ": " + vietnamese); //Ouput: Study: hoc
    }
}
