import java.util.Scanner;

public class Canvassing {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();//总人数
        int a = scanner.nextInt();//小明阵营

        int[] x = new int[n + 1];//每个阵营的人数
        int count = 0;//小明阵营的人数

        for (int i = 0 ; i < n ; i++) {
            int j = scanner.nextInt();
            x[j]++;
            if (j == a) {
                count ++;
            }
        }

        if(count == n){
            System.out.println(count);
            return;
        }

        int sum = 0;
        for (int i = 1 ; i <= n ; i++){
            if(i != a) {
                sum = Math.max(x[i], sum);
            }
        }
        count = count + sum;

        System.out.println(count);
    }
}
