import java.util.Scanner;

/** STUDENT FILE: Complete evaluate. Leave all other project files unchanged. */
public class PostfixEvaluator {
    /**
     * Evaluates a space-separated postfix expression using integer arithmetic.
     * Supported operators: +, -, *, / (integer division).
     *
     * @throws PostFixException for blank, malformed, or invalid expressions
     * @throws ArithmeticException for division by zero
     */
    public static int evaluate(String expression) {
        BoundedStackInterface<Integer> stack = new ArrayStack<>(100);
        Scanner tokens = new Scanner(expression);
        ArrayStack<String> operators = new ArrayStack<String>();

        // TODO 1: Process tokens one at a time.
        // TODO 2: If a token is an integer, push it onto the stack.
        // TODO 3: If it is +, -, *, or /, pop two operands.
        //         IMPORTANT: the first popped number is the RIGHT operand.
        // TODO 4: Calculate and push the result.
        // TODO 5: Reject unknown tokens and expressions with too few operands.
        // TODO 6: After processing, require EXACTLY one result on the stack.
        //         Catch stack underflow/overflow or check before operations.
        // Close the Scanner when you are finished.
        
        String inputed = tokens.next();
        String[] items = inputed.split(" ");
        for(int i = 0; i<items.length; i++)
        {
            if(items[i].equals("+")||items[i].equals("-")||items[i].equals("/")||items[i].equals("*"))
            {
                operators.push(items[i]);
            }
            else{
                stack.push(Integer.parseInt(items[i]));
            }
        }
        while(!operators.isEmpty()&&!stack.isEmpty())
        {
            Integer B = stack.top();
            stack.pop();
            Integer A = stack.top();
            stack.pop();
            String operator = operators.top();
            operators.pop();
            if(operator.equals("+"))
            {
                stack.push(A+B);
            }
            else if(operator.equals("-"))
            {
                stack.push(A-B);
            }
            else if(operator.equals("*"))
            {
                stack.push(A*B);
            }
            else
            {
                if(B==0)
                {
                    throw new UnsupportedOperationException("cannot divide by 0)");
                }
                stack.push(A/B);
            }
        }
        tokens.close();
        int top = stack.top();
        stack.pop();
        if(!stack.isEmpty())
        {
            throw new UnsupportedOperationException("ill-formed expression");
        }
        else 
        {
            return top;
        }
    }
}
