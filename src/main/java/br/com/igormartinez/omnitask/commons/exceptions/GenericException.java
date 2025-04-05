package br.com.igormartinez.omnitask.commons.exceptions;

public class GenericException extends RuntimeException {

    private final String key;
    private final int statusCode;

    public GenericException(int statusCode, String key) {
        super(key);
        this.statusCode = statusCode;
        this.key = key;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getKey() {
        return key;
    }
}
