package model;

import java.util.HashMap;

public class CloudStorage {

    private HashMap<Integer, String> dataStorage;

    public CloudStorage(){
        dataStorage = new HashMap<>();
    }

    // MODIFIES: this
    // EFFECTS: Stores the given data in the cloud under this customer's account
    public void putData(Customer c, String data) {
        dataStorage.put(c.getUniqueId(), data);
    }

    // Returns the given customer's data from the cloud
    public String getData(Customer c) {
        return dataStorage.get(c.getUniqueId());
    }

    // MODIFIES: this
    // EFFECTS: Deletes this customer's data from the cloud
    public String deleteData(Customer c) {
        return dataStorage.remove(c.getUniqueId());
    }
}
