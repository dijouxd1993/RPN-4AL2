package rpn;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {

    private final String REGEX = "[+-]?([0-9]*[.])?[0-9]+";

    public List<Token> Tokenize(String exp){
        List<Token> tokens =  new ArrayList<Token>();
        String[] tab =  exp.split(" ");

        for (int i = 0; i < tab.length; i++) {

            switch (tab[i]){
                case "+":

                    tokens.add(new PlusOperator());
                    break;
                case "-":
                    tokens.add(new MinusOperator());
                    break;
                case "*":
                    tokens.add(new MultiplyOperator());
                    break;
                case "/":
                    tokens.add(new DivideOperator());
                    break;
                default:
                    if(tab[i].matches(REGEX)){
                        tokens.add(new Number(Long.parseLong(tab[i])));
                    }
            }
        }
     return tokens;
    }
}
