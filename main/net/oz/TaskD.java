package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskD {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int m = in.readInt();
        boolean[][] visited = new boolean[n][m];
        int dx, dy, v = 0;
        long vct = 0;
        int x = 0, y = 0;
        while(v < n * m){
            dx = (int)(vct / n);
            dy = (int)(vct % n);
            if(x + dx < n && y + dy < m && !visited[x + dx][y + dy]) {
                visited[x + dx][y + dy] = true;
                x += dx;
                y += dy;
                out.printLine(x + 1, y + 1);
                v++;
            } else if(x - dx >= 0 && y - dy >= 0 && !visited[x - dx][y - dy]) {
                visited[x - dx][y - dy] = true;
                x -= dx;
                y -= dy;
                out.printLine(x + 1, y + 1);
                v++;
            } else if(x - dx >= 0 && y + dy < m && !visited[x - dx][y + dy]) {
                visited[x - dx][y + dy] = true;
                x -= dx;
                y += dy;
                out.printLine(x + 1, y + 1);
                v++;
            } else if(x + dx < n && y - dy >= 0 && !visited[x + dx][y - dy]) {
                visited[x + dx][y + dy] = true;
                x += dx;
                y -= dy;
                out.printLine(x + 1, y + 1);
                v++;
            }
            vct++;
            if(vct > n * m){

            }
        }
    }
}
