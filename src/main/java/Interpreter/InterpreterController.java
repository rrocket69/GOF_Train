package Interpreter;

public class InterpreterController {
    public void startAction() {
        Context context = new Context();
        Expression expr = context.evaluate("54+4-5");
        System.out.println(expr.interpret());
    }

    interface Expression {
        int interpret();
    }

    class NumberExpression implements Expression {
        int number;

        public NumberExpression(int number) {
            this.number = number;
        }

        @Override
        public int interpret() {
            return number;
        }
    }

    class MinusExpression implements Expression {
        Expression left;
        Expression rigth;

        public MinusExpression(Expression left, Expression rigth) {
            this.left = left;
            this.rigth = rigth;
        }

        @Override
        public int interpret() {
            return left.interpret() - rigth.interpret();
        }
    }

    class PlusExpression implements Expression {
        Expression left;
        Expression rigth;

        public PlusExpression(Expression left, Expression rigth) {
            this.left = left;
            this.rigth = rigth;
        }

        @Override
        public int interpret() {
            return left.interpret() + rigth.interpret();
        }
    }

    class Context {
        Expression evaluate(String s) {
            int pos = s.length() - 1;
            while (pos > 0) {
                if (Character.isDigit(s.charAt(pos))) {
                    pos--;
                } else {
                    Expression left = evaluate(s.substring(0, pos));
                    Expression right = new NumberExpression(Integer.valueOf(s.substring(pos + 1, s.length())));
                    char operator = s.charAt(pos);
                    switch (operator) {
                        case '-':
                            return new MinusExpression(left, right);
                        case '+':
                            return new PlusExpression(left, right);
                    }
                }
            }
            int result = Integer.valueOf(s);
            return new NumberExpression(result);
        }
    }
}
