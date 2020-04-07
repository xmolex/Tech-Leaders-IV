import java.util.HashMap;
import java.util.Set;

public class PhoneBook {

    private HashMap<String, Long> phoneBook = new HashMap<>();

    public void add(String name, long phone) {
        phoneBook.put(name, phone);
    }

    public long get(String name) {
        return phoneBook.get(name);
    }

    // выводим список ключей
    public String[] list() {
        Set<String> keys = phoneBook.keySet();
        return keys.toArray(new String[keys.size()]);
    }

}
