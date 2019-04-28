import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
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
        TaskC2 solver = new TaskC2();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC2 {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.readInt();
            int d[] = new int[n];
            for (int i = 0; i < n; i++) {
                d[i] = in.readInt();
            }
            StringBuilder sb = new StringBuilder();
            int l = 0, r = n - 1;
            int last = 0;
            while (l <= r) {
                if (last < d[l] && last < d[r]) {
                    if (d[l] < d[r]) {
                        sb.append("L");
                        last = d[l];
                        l++;
                    } else if (d[l] > d[r]) {
                        sb.append("R");
                        last = d[r];
                        r--;
                    } else {
                        int cl = 0, cr = 0, clast = 0;
                        StringBuilder sbl = new StringBuilder();
                        for (int i = l; i <= r; i++) {
                            if (clast < d[i]) {
                                cl++;
                                clast = d[i];
                                sbl.append("L");
                            } else
                                break;
                        }
                        clast = 0;
                        StringBuilder sbr = new StringBuilder();
                        for (int i = r; i >= l; i--) {
                            if (clast < d[i]) {
                                cr++;
                                clast = d[i];
                                sbr.append("R");
                            } else
                                break;
                        }
                        if (cl >= cr) {
                            sb.append(sbl);
                            l = r + 1;
                        } else {
                            sb.append(sbr);
                            r = l - 1;
                        }
                    }
                } else if (last < d[l]) {
                    sb.append("L");
                    last = d[l];
                    l++;
                } else if (last < d[r]) {
                    sb.append("R");
                    last = d[r];
                    r--;
                } else
                    break;
            }
            out.printLine(sb.length());
            out.printLine(sb.toString());
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
}

