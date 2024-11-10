import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Store {
    private ArrayList<CISItem> cisItems = new ArrayList<>();

    public ArrayList<CISItem> getCisItems() {
        return cisItems;
    }
    public void addBook(Book book) {
        cisItems.add(book);
    }

    public void addPhone(Phone phone) {
        cisItems.add(phone);
    }

    public void addMagazine(Magazine magazine) {
        cisItems.add(magazine);
    }

    public void addArduino(Arduino arduino) {
        cisItems.add(arduino);
    }

    public void updatePhonesLocation(String location) {
        for (int i = 0; i < cisItems.size(); i++) {
            CISItem obj = cisItems.get(i);
            if (obj instanceof Phone) {
                obj.setLocation(location);
            }
        }
    }

    public ArrayList<Phone> getAllphones() {
        ArrayList<Phone> out = new ArrayList<>();
        for (int i = 0; i < cisItems.size(); i++) {
            CISItem obj = cisItems.get(i);
            if (obj instanceof Phone) {
                out.add((Phone) obj); //downcast for a "CISItem" to go into a Phone arrayList
            }
        }
        return out;
    }

    public ArrayList<CISItem> getItems(String itemType) {
        ArrayList<CISItem> out = new ArrayList<>();
        for (int i = 0; i < cisItems.size(); i++) {
            if (cisItems.get(i).getClass().getSimpleName().toLowerCase().equals(itemType.toLowerCase())) {
                out.add(cisItems.get(i));
            }
        }
        return out;
    }


    public void updateItems(String itemType, String property, String value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for (int i = 0; i < cisItems.size(); i++) {
            if (itemType.toLowerCase().equals(cisItems.get(i).getClass().getSimpleName().toLowerCase())) {
                property = property.substring(0,1).toUpperCase() + property.substring(1);
                Method method = cisItems.get(i).getClass().getMethod("set"+property, value.getClass());
                method.invoke(cisItems.get(i), value);
            }
        }
    }

    public void showAllInfo() {
        for (int i = 0; i < cisItems.size(); i++) {
            CISItem currentItem = cisItems.get(i);
            System.out.println(currentItem.getName());
            System.out.println("Item type: " + currentItem.getClass().getSimpleName());
            System.out.println("Available at: " + currentItem.getLocation());
            System.out.println("Price: " + currentItem.getPrice() + "HKD");
            System.out.println("Description: " + currentItem.getDescription());
            System.out.println();
        }
    }
}
