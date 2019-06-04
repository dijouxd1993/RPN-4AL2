package rpn;

public class DivideOperator implements Operator {

    @Override
    public long operate(Number token1, Number token2) {
        if (token2.getValue() == 0f){
           throw new ArithmeticException("Division par 0");
        }
        return  token1.getValue() / token2.getValue();
    }
}
