package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskD {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
    }

    static void maxSubArraySum(int a[], int size, int mult) {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0, start = 0, end = 0, s = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here += a[i];

            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }
            if (max_ending_here < 0) {
                max_ending_here = 0;
                s = i + 1;
            }
        }
        System.out.println("Maximum contiguous sum is " + max_so_far);
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);

        if(mult > 0)
            return;// max_so_far * mult;
        else{

        }
    }
}
