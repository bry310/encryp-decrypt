package encryptdecrypt;

import encryptdecrypt.impl.CLArgs;
import encryptdecrypt.impl.Configuration;

public class Main {
    public static void main(String[] args) {

        try {

            CLArgs clArgs = new CLArgs(args);
            Configuration conf = new Configuration(clArgs);

            Input input = conf.getInput();
            Output output = conf.getOutput();
            Mapper mapper = conf.getMapper();

            mapper.map(input, output);

        } catch (Exception e) {
            System.out.print("Error");
        }

    }

}