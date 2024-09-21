import java.util.*;

public class PhoneBook {

    public TreeMap<String, String> phoneBook = new TreeMap<>();

    public int add(String name, String number) {
        phoneBook.put(name, number);
        return phoneBook.size();
    }

    public List<String> findByNumber(String number)
    {
        return null;
    }
}
