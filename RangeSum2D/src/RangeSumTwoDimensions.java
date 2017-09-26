/**
 * Created by mia on 9/18/17.
 */
public class RangeSumTwoDimensions {
    public static void main(String[] args) {
        for(int i = 0 ; i  < 10; i++){
            System.out.println(i & (-i));
        }
//        int m = 11, n = 8;
//        for (int i = 5 + 1; i <= m; i += i & -i)
//            for (int j = 4 + 1; j <= n; j += j & -j)
//               System.out.println(i+" : "+j);
    }
}
