package lv.tele2.javaschool.phonebook;

import asg.cliche.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jevgkras on 07-Mar-17.
 */
public class PhoneBook {
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
}

