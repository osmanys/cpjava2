import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
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
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        private void change(int x, int y, int idx[], int p[], ArrayList<Pair<Integer, Integer>> m) {
            int px = p[x];
            int py = p[y];
            idx[px] = y;
            idx[py] = x;

            p[x] = py;
            p[y] = px;

            m.add(Pair.makePair(x, y));
        }

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.readInt();
            int p[] = new int[n];
            int idx[] = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = in.readInt() - 1;
                idx[p[i]] = i;
            }
            int tmp;
            ArrayList<Pair<Integer, Integer>> m = new ArrayList<>();
            for (int i = 0; i < n - 1; i++) {
                if (i == idx[i])
                    continue;
                if (2 * Math.abs(i - idx[i]) >= n) {
                    change(i, idx[i], idx, p, m);
                } else {
                    if (idx[i] < n / 2) {
                        change(idx[i], idx[i] + n / 2, idx, p, m);
                        change(idx[i], i, idx, p, m);
                    } else {
                        if (i >= n / 2) {
                            tmp = idx[i];
                            change(idx[i], i - n / 2, idx, p, m);
                            change(i - n / 2, i, idx, p, m);
                            change(i - n / 2, tmp, idx, p, m);
                        } else {
                            tmp = idx[i];
                            change(idx[i], idx[i] - n / 2, idx, p, m);
                            change(idx[i], i + n / 2, idx, p, m);
                            change(i, i + n / 2, idx, p, m);
                            change(tmp - n / 2, tmp, idx, p, m);
                        }
                    }
                }
            }
            out.printLine(m.size());
            for (Pair<Integer, Integer> pair : m) {
                out.printLine(pair.first + 1, pair.second + 1);
            }
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

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

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

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void printLine(int i) {
            writer.println(i);
        }

    }

    static class Pair<U, V> implements Comparable<Pair<U, V>> {
        public final U first;
        public final V second;

        public static <U, V> Pair<U, V> makePair(U first, V second) {
            return new Pair<U, V>(first, second);
        }

        private Pair(U first, V second) {
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

            Pair pair = (Pair) o;

            return !(first != null ? !first.equals(pair.first) : pair.first != null) &&
                    !(second != null ? !second.equals(pair.second) : pair.second != null);
        }

        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        public String toString() {
            return "(" + first + "," + second + ")";
        }

        public int compareTo(Pair<U, V> o) {
            int value = ((Comparable<U>) first).compareTo(o.first);
            if (value != 0) {
                return value;
            }
            return ((Comparable<V>) second).compareTo(o.second);
        }

    }
}

