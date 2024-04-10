package main.java.com.adam;

public enum File {
    A, B, C, D, E, F, G, H;

    public static File fromChar(char c) {
        try {
            File.valueOf(String.valueOf(c).toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
