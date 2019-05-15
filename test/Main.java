import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.io.BufferedWriter;
import java.util.Set;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Osmanys Alonso (osmanys@gmail.com)
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskD solver = new TaskD();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.readInt();
            int d[] = in.readIntArray(n);
            List<LongIntPair> fct;
            HashMap<Long, Integer> mp = new HashMap<>();
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (max < d[i])
                    max = d[i];
                fct = IntegerUtils.factorize(d[i]);
                for (LongIntPair p : fct) {
                    if (!mp.containsKey(p.first)) {
                        mp.put(p.first, p.second);
                    } else if (mp.get(p.first) < p.second) {
                        mp.replace(p.first, p.second);
                    }
                }
            }
            long res = 1;
            Iterator it = mp.entrySet().iterator();
            Map.Entry pair = null;
            long pow, cnt = 1;
            while (it.hasNext()) {
                pair = (Map.Entry) it.next();
                pow = IntegerUtils.power((long) pair.getKey(), (int) pair.getValue());
                res *= pow;
                cnt *= (int) pair.getValue() + 1;
            }
            if (mp.size() == 1) {
                pow = (long) pair.getKey();
                res *= pow;
                cnt++;
            }
            if (max == res || n != cnt - 2)
                out.printLine(-1);
            else
                out.printLine(res);
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void close() {
            writer.close();
        }

        public void printLine(long i) {
            writer.println(i);
        }

        public void printLine(int i) {
            writer.println(i);
        }

    }

    static class LongIntPair implements Comparable<LongIntPair> {
        public final long first;
        public final int second;

        public static LongIntPair makePair(long first, int second) {
            return new LongIntPair(first, second);
        }

        public LongIntPair(long first, int second) {
            this.first = first;
            this.second = second;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            LongIntPair pair = (LongIntPair) o;

            return first == pair.first && second == pair.second;
        }

        public int hashCode() {
            int result = Long.hashCode(first);
            result = 31 * result + Integer.hashCode(second);
            return result;
        }

        public String toString() {
            return "(" + first + "," + second + ")";
        }

        public int compareTo(LongIntPair o) {
            int value = Long.compare(first, o.first);
            if (value != 0) {
                return value;
            }
            return Integer.compare(second, o.second);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int[] readIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = readInt();
            }
            return array;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }

    static class IntegerUtils {
        public static List<LongIntPair> factorize(long number) {
            List<LongIntPair> result = new ArrayList<>();
            for (long i = 2; i * i <= number; i++) {
                if (number % i == 0) {
                    int power = 0;
                    do {
                        power++;
                        number /= i;
                    } while (number % i == 0);
                    result.add(LongIntPair.makePair(i, power));
                }
            }
            if (number != 1) {
                result.add(LongIntPair.makePair(number, 1));
            }
            return result;
        }

        public static long power(long base, long exponent) {
            if (exponent == 0) {
                return 1;
            }
            long result = power(base, exponent >> 1);
            result = result * result;
            if ((exponent & 1) != 0) {
                result = result * base;
            }
            return result;
        }

    }
}

