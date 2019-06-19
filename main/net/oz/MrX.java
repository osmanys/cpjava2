package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class MrX {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        out.print("Case #" + testNumber + ": ");
        String s = in.readString();
        idx = 0;
        Expression e = matchExpression(s);
        e.eval();
        if (e.val != -1)
            out.printLine(0);
        else
            out.printLine(Math.min(e.calc(true), e.calc(false)));
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
    int val;
    Boolean t;
    Boolean f;
    abstract int eval();
    abstract boolean eval(boolean b);
    abstract int calc(boolean b);
}

class OR extends Expression {
    Expression e1;
    Expression e2;

    public OR(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public int eval() {
        e1.eval();
        e2.eval();
        if (eval(true) != eval(false))
            val = -1;
        else if (eval(true))
            val = 1;
        else
            val = 0;
        return val;
    }

    public boolean eval(boolean b) {
        if (b && t == null)
            t = e1.eval(true) || e2.eval(true);
        if (!b && f == null)
            f = e1.eval(false) || e2.eval(false);
        return b ? t : f;
    }

    public int calc(boolean b) {
        if (val != -1)
            return 0;
        else {
            int b1 = e1.val;
            int b2 = e2.val;
            if (b1 == -1 && b2 == -1) {
                if (b)
                    return Math.min(e1.calc(true), e2.calc(true));
                else
                    return e1.calc(false) + e2.calc(false);
            } else if (b1 == 1) {
                return 0;
            } else if (b1 == 0) {
                if (b)
                    return e2.calc(true);
                else
                    return e2.calc(false);
            } else if (b2 == 1) {
                return 0;
            } else {
                if (b)
                    return e1.calc(true);
                else
                    return e1.calc(false);
            }
        }
    }
}

class AND extends Expression {
    Expression e1;
    Expression e2;

    public AND(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public int eval() {
        e1.eval();
        e2.eval();
        if (eval(true) != eval(false))
            val = -1;
        else if (eval(true))
            val = 1;
        else
            val = 0;
        return val;
    }

    public boolean eval(boolean b) {
        if (b && t == null)
            t = e1.eval(true) && e2.eval(true);
        if (!b && f == null)
            f = e1.eval(false) && e2.eval(false);
        return b ? t : f;
    }

    public int calc(boolean b) {
        if (val != -1)
            return 0;
        else {
            int b1 = e1.val;
            int b2 = e2.val;
            if (b1 == -1 && b2 == -1) {
                if (b)
                    return e1.calc(true) + e2.calc(true);
                else
                    return Math.min(e1.calc(false), e2.calc(false));
            } else if (b1 == 1) {
                if (b)
                    return e2.calc(true);
                else
                    return e2.calc(false);
            } else if (b1 == 0) {
                return 0;
            } else if (b2 == 1) {
                if (b)
                    return e1.calc(true);
                else
                    return e1.calc(false);
            } else {
                return 0;
            }
        }
    }
}

class XOR extends Expression {
    private Expression e1;
    private Expression e2;

    public XOR(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public int eval() {
        e1.eval();
        e2.eval();
        if (eval(true) != eval(false))
            val = -1;
        else if (eval(true))
            val = 1;
        else
            val = 0;
        return val;
    }

    public boolean eval(boolean b) {
        if (b && t == null)
            t = e1.eval(true) ^ e2.eval(true);
        if (!b && f == null)
            f = e1.eval(false) ^ e2.eval(false);
        return b ? t : f;
    }

    public int calc(boolean b) {
        if (val != -1)
            return 0;
        else {
            int b1 = e1.val;
            int b2 = e2.val;
            if (b1 == -1 && b2 == -1) {
                if (b)
                    return Math.min(e1.calc(true) + e2.calc(false), e1.calc(false) + e2.calc(true));
                else
                    return Math.min(e1.calc(true) + e2.calc(true), e1.calc(false) + e2.calc(false));
            } else if(b1 == 1){
                if (b)
                    return e2.calc(false);
                else
                    return e2.calc(true);
            } else if(b1 == 0){
                if (b)
                    return e2.calc(true);
                else
                    return e2.calc(false);
            } else if(b2 == 1){
                if (b)
                    return e1.calc(false);
                else
                    return e1.calc(true);
            } else {
                if (b)
                    return e1.calc(true);
                else
                    return e1.calc(false);
            }
        }
    }
}

class Variable extends Expression {
    public int eval() {
        val = -1;
        return -1;
    }

    public boolean eval(boolean b) {
        return b;
    }

    public int calc(boolean b) {
        return 1;
    }
}

class NOT extends Expression {
    public int eval() {
        val = -1;
        return -1;
    }

    public boolean eval(boolean b) {
        return !b;
    }

    public int calc(boolean b) {
        return 1;
    }
}

class False extends Expression {
    public int eval() {
        val = 0;
        return 0;
    }

    public boolean eval(boolean b) {
        return false;
    }

    public int calc(boolean b) {
        if (b)
            return 1;
        return 0;
    }
}

class True extends Expression {
    public int eval() {
        val = 1;
        return 1;
    }

    public boolean eval(boolean b) {
        return true;
    }

    public int calc(boolean b) {
        if (!b)
            return 1;
        return 0;
    }
}
