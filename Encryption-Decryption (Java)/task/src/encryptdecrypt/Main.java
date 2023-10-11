package encryptdecrypt;


//abcdefghijklmnopqrstuvwxyz

class DomeEncrypter implements Encryptor {

    private int key;
    DomeEncrypter(int key){
        this.key = key;
    }

    @Override
    public  String encrypt(String msg) {
        String emsg = "";
        for(char c : msg.toCharArray()){
            emsg = emsg + encryptChar(c);
        }
        return emsg;
    }

    @Override
    public String decrypt(String code){
        String msg = "";
        for(char c : code.toCharArray()){
            msg = msg + decryptChar(c);
        }
        return msg;
    }

    private char encryptChar(char c){
        int a = 'a';
        int from_a = c - 'a';
        int new_from_a = (from_a + key) ;
        return (char)(a + new_from_a);
    }

    private char decryptChar(char c){
        int a = 'a';
        int from_a = c - 'a';
        int new_from_a = (from_a - key) ;
        return (char)(a + new_from_a);
    }

}

public class Main {





    public static void main(String[] args) {

        //Prompt.display();
        String todo = Reader.readString();
        String msg = Reader.readString();
        //Prompt.display();
        int key = Reader.readInt();
        Encryptor encryptor = new DomeEncrypter(key);
        String encryptedMsg = todo.equals("enc") ?
                encryptor.encrypt(msg) : encryptor.decrypt(msg);
        Writer.write(encryptedMsg);


    }


}