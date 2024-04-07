import encryptdecrypt.Main;
import encryptdecrypt.impl.EncryptionApp;
import encryptdecrypt.io.impl.FileIO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    void SimpleTest1(){
              String args[] = {  "-alg", "unicode",
                "-mode", "enc",
                "-key", "5",
                "-in", "in.txt",
                "-out", "output.txt" };

              var in = new FileIO("in.txt");
              in.write("Welcome to hyperskill!");
              Main.main(args);
              var out = new FileIO("output.txt");
              assertEquals(out.read(),"\\jqhtrj%yt%m~ujwxpnqq&" );


    }

    @Test
    void SimpleTest2(){
        String args[] = {  "-key", "0",
                "-mode", "enc",
                "-alg", "unicode",
                "-in", "input.txt",
                "-out", "output2.txt" };

        var in = new FileIO("input.txt");
        in.write("hello");
        Main.main(args);

        var out = new FileIO("output2.txt");
        assertEquals(out.read(),"hello" );


    }

    @Test
    void SimpleTest3(){
        String args[] = {  "-key", "0",
                "-mode", "enc",
                "-alg", "shift",
                "-in", "input.txt",
                "-out", "output3.txt" };

        var in = new FileIO("input.txt");
        in.write("hello");
        Main.main(args);

        var out = new FileIO("output3.txt");
        assertEquals(out.read(),"hello" );


    }

    @Test
    void SimpleTest4(){
        String args[] = {  "-key", "0",
                "-mode", "dec",
                "-alg", "shift",
                "-in", "input.txt",
                "-out", "output3.txt" };

        var in = new FileIO("input.txt");
        in.write("hello");
        Main.main(args);

        var out = new FileIO("output3.txt");
        assertEquals(out.read(),"hello" );


    }
}
