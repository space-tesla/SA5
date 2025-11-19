import java.util.*;

// Adapter: Converts Enumeration to Iterator
class EnumerationIteratorAdapter implements Iterator<Object> {

    private Enumeration<?> enumeration;

    public EnumerationIteratorAdapter(Enumeration<?> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}

public class AdapterDemo {
    public static void main(String[] args) {

        // Old legacy collection: Vector (gives Enumeration)
        Vector<String> vector = new Vector<>();
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Cherry");

        System.out.println("Using Enumeration:");
        Enumeration<String> e = vector.elements();
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }

        System.out.println("\nUsing Iterator via Adapter:");
        Iterator<Object> it = new EnumerationIteratorAdapter(vector.elements());
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
