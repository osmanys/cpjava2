package on2019_05.on2019_05_06_May_Challenge_2019_Division_1.Ada_Rooks_2;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class AdaRooks2 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        boolean mark[][] = new boolean[n][n];
        int cnt[] = new int[n];
        char res[][] = new char[n][n];
        List<Integer> ids;
        boolean valid;
        int total = 0;
        for (int i = 0; i < n; i++) {
            ids = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (cnt[j] == 9 || ids.size() == 9) {
                    res[i][j] = '.';
                    continue;
                }
                valid = true;
                for (int id : ids) {
                    if (mark[j][id]) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    for (int id : ids) {
                        mark[j][id] = true;
                        mark[id][j] = true;
                    }
                    res[i][j] = 'O';
                    ids.add(j);
                    cnt[j]++;
                    total++;
                } else {
                    res[i][j] = '.';
                }
            }
        }
        out.printTable(res);
    }
}
