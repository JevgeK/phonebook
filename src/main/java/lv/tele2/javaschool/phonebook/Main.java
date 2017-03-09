package lv.tele2.javaschool.phonebook;

import asg.cliche.ShellFactory;
import asg.cliche.example.HelloWorld;

import java.io.IOException;

/**
 * Created by jevgkras on 07-Mar-17.
 */
public class Main {
    public static void main(String[] args) {
        try {
            ShellFactory.createConsoleShell("hello", null, new PhoneBook())
                    .commandLoop();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
