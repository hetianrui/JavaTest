import java.util.Arrays;

public class SanRound {

    public int C(int[] a) {
        Arrays.sort(a);
        for (int i = a.length - 1; i >= 2; i--) {
            int u = a[i];
            int p = a[i - 1];
            int l = a[i - 2];
            if (u < p + l) {
                return u + p + l;

            }
        }



        return 0;}
}
