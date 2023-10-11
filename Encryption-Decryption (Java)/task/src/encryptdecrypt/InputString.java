package encryptdecrypt;

public class InputString implements Input {
    private String string;
    public InputString(String string){
        this.string = string;
    }

    @Override
    public String getInput() {
        return string;
    }
}
