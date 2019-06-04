package rpn;

public class MinusOperator implements Operator {

    @Override
    public long operate(Number token1, Number token2) {
        return token1.getValue() - token2.getValue();
    }
}
