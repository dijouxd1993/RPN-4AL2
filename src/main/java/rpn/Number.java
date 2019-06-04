package rpn;

public class Number implements Token {
    private long value;

    public Number(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}
