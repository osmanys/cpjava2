
public class RulerMaker {
    public int[] placeStickers(int n) {
        int res[] = new int[n];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i < n; i++) {
            res[i] = res[i - 1] + i - 1;
        }
        return res;
    }

}
