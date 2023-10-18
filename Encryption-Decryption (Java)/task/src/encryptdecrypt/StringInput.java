package encryptdecrypt;

public class StringInput implements Input {
    private String string;
    public StringInput(String string){
        this.string = string;
    }

    @Override
    public String getInput() {
        return string;
    }
}
