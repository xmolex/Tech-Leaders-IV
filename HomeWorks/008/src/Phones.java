import java.util.HashMap;

public class Phones {

    private HashMap<String,Long> phoneBook = new HashMap<>();

    public void add(String name, long phone) {
        phoneBook.put(name, phone);
    }

    public long get(String name) {
        return phoneBook.get(name);
    }

}
