package rpn;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;
// BASSET François , DIJOUX Damien
public class CLI {
    public static final void main(String[] args) {
        String expression = Stream.of(args).collect(Collectors.joining(" "));

        System.out.println("About to evaluate '" + expression + "'");
        long result = evaluate(expression);
        System.out.println("> " + result);
    }

    static long evaluate(String expression) {
        Tokenizer tokenizer = new Tokenizer();
        List<Token> tokens = tokenizer.Tokenize(expression);
        Stack<Number> numbers = new Stack<Number>();
        for (Token token : tokens) {
            if (token instanceof Number){
                numbers.push((Number)token);
            }else{
                numbers.push( new Number(((Operator)token).operate(numbers.pop(),numbers.pop())));
            }
        }

        return numbers.pop().getValue();

    }
}
