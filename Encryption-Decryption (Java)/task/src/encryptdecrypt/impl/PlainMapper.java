package encryptdecrypt.impl;

import encryptdecrypt.Input;
import encryptdecrypt.Mapper;
import encryptdecrypt.Output;

public class PlainMapper implements Mapper {
    @Override
    public void map(Input in, Output out) {
        out.write(in.read());
    }
}
