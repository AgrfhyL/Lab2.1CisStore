
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

public class StoreTester {
    private Store store;
    @org.junit.jupiter.api.BeforeEach

    void setup() {
        store = new Store();
    }
    @Test
    public void addBookTester() {
        Book newBook = new Book();
        store.addBook(newBook);
        assertTrue(store.getCisItems().contains(newBook), "addBook test failed.");
    }

    @Test
    public void addPhoneTester() {
        Phone newPhone = new Phone();
        store.addPhone(newPhone);
        assertTrue(store.getCisItems().contains(newPhone), "addPhone test failed.");
    }

    @Test
    public void addMagazineTester() {
        Magazine newMag = new Magazine();
        store.addMagazine(newMag);
        assertTrue(store.getCisItems().contains(newMag), "addPhone test failed.");
    }

    @Test
    public void addArduinoTester() {
        Arduino newArd = new Arduino();
        store.addArduino(newArd);
        assertTrue(store.getCisItems().contains(newArd), "addPhone test failed.");
    }

    @Test
    public void testPhoneLocation() {
        Phone phone1 = new Phone();
        store.addPhone(phone1);
        Phone phone2 = new Phone();
        store.addPhone(phone2);
        Phone phone3 = new Phone();
        store.addPhone(phone3);
        store.updatePhonesLocation("Room 512");
        for (int i = 0; i < store.getAllphones().size(); i++) {
            assertEquals(store.getAllphones().get(i).getLocation(), "Room 512");
        }
    }

    @Test
    public void getItemTest() {
        for (int i = 0; i < 3; i++) {
            store.addPhone(new Phone());
            store.addArduino(new Arduino());
            store.addMagazine(new Magazine());
            store.addBook(new Book());
        }
        assertEquals(3, store.getItems("Phone").size(), "Not all phones gotten");
        assertEquals(3, store.getItems("Arduino").size(), "Not all arduinos gotten");
        assertEquals(3, store.getItems("mAGazINE").size(), "Not all magazines gotten");
        assertEquals(3, store.getItems("BOOK").size(), "Not all books gotten");
    }

    @Test
    public void updateItemsTest() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        for (int i = 0; i < 3; i++) {
            store.addPhone(new Phone());
            store.addArduino(new Arduino());
            store.addMagazine(new Magazine());
            store.addBook(new Book());
        }
        store.updateItems("Phone", "location", "AgrfhyL");
        for (int i = 0; i < 3; i++) {
            assertEquals("AgrfhyL", store.getItems("Phone").get(i).getLocation());
        }
        store.updateItems("Phone", "description", "2045");
        for (int i = 0; i < 3; i++) {
            assertEquals("2045", store.getItems("Phone").get(i).getDescription());
        }
        store.updateItems("Arduino", "name", "myArd");
        for (int i = 0; i < 3; i++) {
            assertEquals("myArd", store.getItems("Arduino").get(i).getName());
        }
        store.updateItems("magazine", "name", "NY Times");
        for (int i = 0; i < 3; i++) {
            assertEquals("NY Times", store.getItems("Magazine").get(i).getName());
        }
        store.updateItems("Book", "description", "3");
        for (int i = 0; i < 3; i++) {
            assertEquals("3", store.getItems("Book").get(i).getDescription());
        }
    }
@Test
    public void showAllInfoManualTest() {
        Phone myPhone = new Phone();
        store.addPhone(myPhone);
        myPhone.setLocation("Room 512");
        myPhone.setName("iPhone 5");
        myPhone.setDescription("Ms. Nahar's handmedown phone");
        myPhone.setPrice(300);
        Magazine myMag = new Magazine();
        store.addMagazine(myMag);
        myMag.setLocation("Room 511");
        myMag.setName("oldy magy");
        myMag.setDescription("My grandpa's magazine. Found in his treasure chest.");
        myMag.setPrice(1500);
        store.showAllInfo();
    }
}

