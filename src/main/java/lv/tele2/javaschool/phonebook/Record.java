package lv.tele2.javaschool.phonebook;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Record implements Serializable {
    private static final long serialVersionUID = 1L;

    private static int nextId = 1;
    private int id;
    private String name;
    private List<String> phoneList = new ArrayList<>();
    private String email;

    public Record() {
        this.id = nextId;
        nextId++;
    }

    public Record(String name, String phone, String email) {
        this();
        this.name = name;
        this.phoneList.add(phone);
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPhoneList() {
        return phoneList;
    }

    public void addPhone(String phone) {
        this.phoneList.add(phone);
    }

    public void delPhone(String phone) {
        this.phoneList.remove(phone);
    }

    private void readObject(java.io.ObjectInputStream in)
        throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        nextId = Math.max(id + 1, nextId);
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phoneList + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
