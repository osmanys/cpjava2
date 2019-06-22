package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class MrX {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        out.print("Case #" + testNumber + ": ");
        String s = in.readString();
        idx = 0;
        Expression e = matchExpression(s);
        out.printLine(e.eval(true) == e.eval(false) ? 0 : 1);
    }

    private int idx;

    private Expression matchExpression(String s) {
        if (s.charAt(idx) == '(') {
            idx++;
            Expression e1 = matchExpression(s);
            int opIdx = idx++;
            Expression e2 = matchExpression(s);
            idx++;
            if (s.charAt(opIdx) == '|') {
                return new OR(e1, e2);
            } else if (s.charAt(opIdx) == '&') {
                return new AND(e1, e2);
            } else if (s.charAt(opIdx) == '^') {
                return new XOR(e1, e2);
            }
        } else if (s.charAt(idx) == 'x') {
            idx++;
            return new Variable();
        } else if (s.charAt(idx) == 'X') {
            idx++;
            return new NOT();
        } else if (s.charAt(idx) == '0') {
            idx++;
            return new False();
        } else if (s.charAt(idx) == '1') {
            idx++;
            return new True();
        }
        return null;
    }
}

abstract class Expression {
    abstract boolean eval(boolean b);
}

class OR extends Expression {
    private Expression e1;
    private Expression e2;

    OR(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public boolean eval(boolean b) {
        return e1.eval(b) || e2.eval(b);
    }
}

class AND extends Expression {
    private Expression e1;
    private Expression e2;

    AND(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public boolean eval(boolean b) {
        return e1.eval(b) && e2.eval(b);
    }
}

class XOR extends Expression {
    private Expression e1;
    private Expression e2;

    XOR(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public boolean eval(boolean b) {
        return e1.eval(b) ^ e2.eval(b);
    }
}

class Variable extends Expression {
    public boolean eval(boolean b) {
        return b;
    }
}

class NOT extends Expression {
    public boolean eval(boolean b) {
        return !b;
    }
}

class False extends Expression {
    public boolean eval(boolean b) {
        return false;
    }
}

class True extends Expression {
    public boolean eval(boolean b) {
        return true;
    }
}
