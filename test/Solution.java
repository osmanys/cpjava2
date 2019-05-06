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
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        PowerArrangers solver = new PowerArrangers();
        solver.solve(1, in, out);
        out.close();
    }

    static class PowerArrangers {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int t = in.readInt();
            in.readInt();
            int last = 0, idx, r;
            int q = 0;
            ArrayList<Integer> cur = new ArrayList<>();
            for (int i = 0; i < 119; i++) {
                cur.add(i);
            }
            ArrayList<Integer> tmp[];
            StringBuilder sb;
            for (int tn = 0; tn < t; tn++) {
                sb = new StringBuilder();
                for (int d = 1; d < 5; d++) {
                    tmp = new ArrayList[5];
                    for (int i = 0; i < 5; i++)
                        tmp[i] = new ArrayList<>();
                    for (int k : cur) {
                        out.printLine(5 * k + d);
                        out.flush();
                        q++;
                        r = in.readCharacter() - 'A';
                        tmp[r].add(k);
                    }
                    if (d < 4) {
                        for (idx = 0; idx < 5; idx++) {
                            if (tmp[idx].size() == val(d))
                                break;
                        }
                        sb.append((char) ('A' + idx));
                        cur = tmp[idx];
                    } else {
                        for (idx = 0; idx < 5; idx++) {
                            if (tmp[idx].size() == 1) {
                                last = idx;
                                break;
                            }
                        }
                    }
                }
                int cnt[] = new int[5];
                for (int i = 0; i < sb.length(); i++) {
                    cnt[sb.charAt(i) - 'A']++;
                }
                for (int i = 0; i < 5; i++) {
                    if (cnt[i] == 0 && i != last) {
                        sb.append((char) ('A' + i));
                        break;
                    }
                }
                sb.append((char) ('A' + last));
                out.printLine(sb.toString());
                out.flush();
                if (in.readCharacter() != 'Y') {
                    return;
                }
            }
        }

        private int val(int d) {
            if (d == 1)
                return 23;
            else if (d == 2)
                return 5;
            else
                return 1;
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

        public char readCharacter() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            return (char) c;
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

        public void flush() {
            writer.flush();
        }

        public void printLine(int i) {
            writer.println(i);
        }

    }
}

