package encryptdecrypt.io.impl;

public class JustException extends RuntimeException {

    public JustException() {
        super();
    }

    public JustException(String message) {
        super(message);
    }

    public JustException(String message, Throwable cause) {
        super(message, cause);
    }

    public JustException(Throwable cause) {
        super(cause);
    }

    protected JustException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
