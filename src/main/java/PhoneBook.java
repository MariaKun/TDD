import java.util.*;
import java.util.stream.Collectors;

public class PhoneBook {

    public TreeMap<String, String> phoneBook = new TreeMap<>();

    public int add(String name, String number) {
        phoneBook.put(name, number);
        return phoneBook.size();
    }

    public List<String> findByNumber(String number)
    {
        return phoneBook
                .entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), number))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public String findByName(String name)
    {
        return null;
    }
}
