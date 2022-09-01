package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RedesController {

    public RedesController() {
        super();
    }

    public String os() {
        String os = System.getProperty("os.name");
        return os;
    }

    public void ip() throws IOException {
        Process processo = null;
        if (os().contains("Mac OS X")) {
            processo = Runtime.getRuntime().exec("ifconfig");
        } else {
            processo = Runtime.getRuntime().exec("ipconfig");
        }

        BufferedReader input = new BufferedReader(new InputStreamReader(processo.getInputStream()));

        String line = null;

        while ((line = input.readLine()) != null) {
            if (line.contains("anpi0")) {
                System.out.println(line);
            }
        }
    }

    public void ping() throws IOException {

        Process processo = null;Runtime.getRuntime().exec("ping www.google.com.br");
        if (os().contains("Mac OS X")) {
            processo = Runtime.getRuntime().exec("ping -c 10 www.google.com.br");
        } else {
            processo = Runtime.getRuntime().exec("ping -n 10 www.google.com.br");
        }

        BufferedReader input = new BufferedReader(new InputStreamReader(processo.getInputStream()));

        String line = null;
        String splitSeparator = "time=";

        while ((line = input.readLine()) != null) {
            if (line.contains(splitSeparator)) {
                String[] time = line.split(splitSeparator);
                System.out.println(time[1]);
            }
        }
    }

}
