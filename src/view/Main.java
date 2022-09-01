package view;

import controller.RedesController;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        RedesController redes = new RedesController();
        redes.ping();
    }

}
