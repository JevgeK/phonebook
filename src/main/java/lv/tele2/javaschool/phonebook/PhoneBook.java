package lv.tele2.javaschool.phonebook;

import asg.cliche.Command;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Record> recordList = new ArrayList<>();

    @Command
    public void create(String name, String phone, String email) {
        Record r = new Record(name, phone, email);
        recordList.add(r);
    }

    @Command
    public List<Record> List() {
        return recordList;
    }

    @Command
    public void addPhone(int id, String phone) {
        for (Record r : recordList) {
            if (r.getId() == id) {
                r.addPhone(phone);
                System.out.println("Phone list for name : " + r.getName() + " now contains: " + r.getPhoneList());
            }
        }
    }

    @Command
    public void delPhone(int id, String phone) {
        for (Record r : recordList) {
            if (r.getId() == id) {
                r.delPhone(phone);
                System.out.println("Phone list for name : " + r.getName() + " now contains: " + r.getPhoneList());
            }
        }
    }

    @Command
    public void remove(int id, String name) {
        for (Record r : recordList) {
            if (r.getId() == id && r.getName().equals(name)) {
                recordList.remove(r);
                break;
            }
        }
    }

    @Command
    public void generate() {
        JSONObject obj = callNameFake();
        try {
            System.out.println("Name: " + obj.getString("name") + ", phone: " + obj.getString("phone_h") + ", email: " + obj.getString("email_u"));
            create(obj.getString("name"), obj.getString("phone_h"), obj.getString("email_u"));
        } catch (NullPointerException e) {
            System.out.println("No fake customer has been retrieved!");
        }
    }

    @Command
    public void generate(int i) {
        for (int a = 0; a < i; a++) {
            generate();
        }
    }

    private JSONObject callNameFake() {
        try {
            URL url = new URL("http://api.namefake.com/english-uk/random");
            try (InputStream is = url.openStream()) {
                JSONTokener t = new JSONTokener(is);
                return new JSONObject(t);
            }
        } catch (IOException e) {
            return null;
        }
    }
}
