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
            boolean straight[] = new boolean[n + 1];
            int max = -1;
            boolean closed = false;
            for (int i = 0; i < n; i++) {
                if (!closed && d[i] > max) {
                    straight[d[i]] = true;
                    max = d[i];
                } else {
                    closed = true;
                }
            }
            boolean reverse[] = new boolean[n + 1];
            max = -1;
            closed = false;
            for (int i = n - 1; i >= 0; i--) {
                if (!closed && d[i] > max) {
                    reverse[d[i]] = true;
                    max = d[i];
                } else {
                    closed = true;
                }
            }
            int cleft = 0, cright = 0;
            for (int i = n; i > 0; i--) {
                if (straight[i] && reverse[i]) {
                    if (cleft == cright) {
                        cright++;
                        cleft++;
                    } else if (cleft > cright) {
                        cright = 0;
                        cleft++;
                        reverse[i] = false;
                    } else {
                        cleft = 0;
                        cright++;
                        straight[i] = false;
                    }
                } else if (straight[i]) {
                    cleft++;
                } else if (reverse[i]) {
                    cright++;
                }
            }
            max = -1;
            closed = false;
            for (int i = 0; i < n; i++) {
                if (!straight[d[i]] || closed || d[i] < max) {
                    closed = true;
                    straight[d[i]] = false;
                } else {
                    max = d[i];
                }
            }
            max = -1;
            closed = false;
            for (int i = n - 1; i >= 0; i--) {
                if (!reverse[d[i]] || closed || d[i] < max) {
                    closed = true;
                    reverse[d[i]] = false;
                } else {
                    max = d[i];
                }
            }
            StringBuilder sb = new StringBuilder();
            boolean last = true;
            for (int i = 1; i <= n; i++) {
                if (straight[i] && reverse[i]) {
                    if (last)
                        sb.append("L");
                    else
                        sb.append("R");
                } else if (straight[i]) {
                    sb.append("L");
                    last = true;
                } else if (reverse[i]) {
                    sb.append("R");
                    last = false;
                }
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

