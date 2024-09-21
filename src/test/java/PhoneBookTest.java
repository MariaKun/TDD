import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneBookTest {

    @Test
    public void add_NewContact_success()
    {
        PhoneBook phoneBook = new PhoneBook();
        String name = RandomStringUtils.random(5);
        String number = RandomStringUtils.randomNumeric(8);
        int count = phoneBook.add(name, number);
        assertThat(count).isEqualTo(1);
    }

    @Test
    public void add_existingContact_fail()
    {
        PhoneBook phoneBook = new PhoneBook();
        String name = RandomStringUtils.random(5);
        String number1 = RandomStringUtils.randomNumeric(8);
        String number2 = RandomStringUtils.randomNumeric(8);
        int count1 = phoneBook.add(name, number1);
        int count2 = phoneBook.add(name, number2);
        assertThat(count1).isEqualTo(count2).isEqualTo(1);
    }

    @Test
    public void findByNumber_success()
    {
        PhoneBook phoneBook = new PhoneBook();
        String name = RandomStringUtils.random(5);
        String number = RandomStringUtils.randomNumeric(8);
        phoneBook.add(name, number);
        List<String> byNumber = phoneBook.findByNumber(number);
        assertThat(byNumber.size()).isEqualTo(1);
        assertThat(byNumber.getFirst()).isEqualTo(name);
    }

    @Test
    public void findBy_notExistingNumber_fail()
    {
        PhoneBook phoneBook = new PhoneBook();
        String name = RandomStringUtils.random(5);
        String number = RandomStringUtils.randomNumeric(8);
        phoneBook.add(name, number);
        List<String> byNumber = phoneBook.findByNumber(RandomStringUtils.randomNumeric(8));
        assertThat(byNumber.size()).isEqualTo(0);
    }

    @Test
    public void findByName_success()
    {
        PhoneBook phoneBook = new PhoneBook();
        String name = RandomStringUtils.random(5);
        String number = RandomStringUtils.randomNumeric(8);
        phoneBook.add(name, number);
        String byName = phoneBook.findByName(name);
        assertThat(byName).isEqualTo(number);
    }

    @Test
    public void findBy_NotExistingName_fail()
    {
        PhoneBook phoneBook = new PhoneBook();
        String name = RandomStringUtils.random(5);
        String number = RandomStringUtils.randomNumeric(8);
        phoneBook.add(name, number);
        String byName = phoneBook.findByName(RandomStringUtils.random(5));
        assertThat(byName).isNull();
    }
}
