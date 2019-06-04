package rpn;

public interface Operator extends Token {
    long operate(Number token1, Number token2);
}
