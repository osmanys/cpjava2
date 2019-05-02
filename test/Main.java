import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Random;
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
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = 200000;//in.readInt();
            int z = 10000;//in.readInt();
            int d[] = new int[n];
            Random rand = new Random(574);
            for (int i = 0; i < n; i++) {
                d[i] = rand.nextInt(10000);//in.readInt();
            }
            Arrays.sort(d);
            int l = 0;
            int mid, r = n / 2 + 1;
            boolean valid;
            while (l + 1 < r) {
                mid = (l + r) / 2;
                valid = true;
                for (int i = 0; i < mid; i++) {
                    if (d[n - mid + i] - d[i] < z) {
                        valid = false;
                        break;
                    }
                }
                if (valid)
                    l = mid;
                else
                    r = mid;
            }
            out.printLine(l);
        }

    }

    static class InputReader {
        private InputStream stream;

        public InputReader(InputStream stream) {
            this.stream = stream;
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

        public void printLine(int i) {
            writer.println(i);
        }

    }
}

