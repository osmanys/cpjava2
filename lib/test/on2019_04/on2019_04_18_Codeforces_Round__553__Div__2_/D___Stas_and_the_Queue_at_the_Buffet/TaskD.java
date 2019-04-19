package on2019_04.on2019_04_18_Codeforces_Round__553__Div__2_.D___Stas_and_the_Queue_at_the_Buffet;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;

public class TaskD {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        Student d[] = new Student[n];
        for(int i = 0; i < n; i++){
            d[i] = new Student(in.readInt(), in.readInt());
        }
        Arrays.sort(d);
        long r = 0;
        for(int i = 0; i < n; i++){
            r += (long)d[i].a * i + (long)d[i].b * (n - i - 1);
        }
        out.printLine(r);
    }

    class Student implements Comparable<Student> {
        int a;
        int b;

        Student(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Student s) {
            if (b - a > s.b - s.a)
                return 1;
            else if (b - a < s.b - s.a)
                return -1;
            else
                return 0;
        }
    }
}
