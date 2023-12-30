import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    // 计算多项式的值
    public static double Polycal(int n, ArrayList<Double> a, double x) {
        double p = a.get(n);
        for (int i = n; i > 0; i--) {
            p = a.get(i - 1) + (x * p);
        }
    return p;
    }

    // 计算连续数组的最大子列和
    public static double MaxSubseqSum4( ArrayList<Double> a) {
        double ThisSum = 0;
        double MaxSum = 0;
        for (int i = 0; i < a.size(); i ++) {
            ThisSum += a.get(i);
            // 当前子列和小于0 抛弃
            if (ThisSum < 0) {
                ThisSum = 0;
            }
            if (ThisSum > MaxSum) {
                MaxSum = ThisSum;
            }
        }
        return MaxSum;
    }


    public static void main(String[] args) {
        //
        ArrayList<Double> coef = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        int n = 6;
        double x = 3.1;
        double result = Polycal(n, coef, x);
        System.out.println(result);
        //
        ArrayList<Double> l = new ArrayList<>(Arrays.asList(-1.0, 3.0, -2.0, 4.0, -6.0, 1.0, 6.0, -1.0));
        double MaxResult = MaxSubseqSum4(l);
        System.out.println(MaxResult);

    }
}