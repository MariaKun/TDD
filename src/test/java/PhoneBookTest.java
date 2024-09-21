import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneBookTest {

    @Test
    public void addNewContact_success()
    {
        PhoneBook phoneBook = new PhoneBook();
        String name = RandomStringUtils.random(5);
        String number = RandomStringUtils.randomNumeric(8);
        int count = phoneBook.add(name, number);
        assertThat(count).isEqualTo(1);
    }

    @Test
    public void addExistingContact_fail()
    {
        PhoneBook phoneBook = new PhoneBook();
        String name = RandomStringUtils.random(5);
        String number1 = RandomStringUtils.randomNumeric(8);
        String number2 = RandomStringUtils.randomNumeric(8);
        int count1 = phoneBook.add(name, number1);
        int count2 = phoneBook.add(name, number2);
        assertThat(count1).isEqualTo(count2).isEqualTo(1);
    }
}
