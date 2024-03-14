import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author JC
 * @description 区间[l,r] 内的数都加上 c
 * @Date 2023-10-17 00:35
 * @Version 1.0
 */
public class Main {

    public static final int N = 1050;

    public static void main(String[] args) {
        // 一维差分
        getOne();
        // 二维差分
        getTwo();
    }

    private static void getTwo() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        int[][] arr = new int[N][N];
        for (int i = 0; i < n; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            for (int j = x1; j <= x2; j++) {
                arr[j][y1] += c;
                arr[j][y2+1] -= c;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] += arr[i][j-1];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void getOne() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < n; i++) {
            int l,r;
            l = scanner.nextInt();
            r = scanner.nextInt();
            arr[l] += c;
            arr[r+1] -= c;
        }
        for (int i = 1; i < N; i++) {
            arr[i] += arr[i-1];
        }
        System.out.println(Arrays.toString(arr));
    }

}
