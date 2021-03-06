package net.oz;

public class EllysAndXor {
    public int getMax(int[] numbers) {
        return getMax(numbers, 1, numbers[0]);
    }
    private int getMax(int[] numbers, int i, int partial){
        if(i == numbers.length)
            return partial;
        return Math.max(getMax(numbers, i + 1, partial & numbers[i]), getMax(numbers, i + 1, partial ^ numbers[i]));
    }
}
