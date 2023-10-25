package encryptdecrypt;

import encryptdecrypt.impl.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration conf = new Configuration(args);
        new App(conf).run();
    }

}