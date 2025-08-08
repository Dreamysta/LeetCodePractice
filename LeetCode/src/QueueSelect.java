import java.util.Scanner;

public class QueueSelect {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int[] x = new int[n];
        int[] y = new int[n];

        for(int i = 0 ; i < n ; i++) {
            x[i] = scanner.nextInt();
        }

        for (int i = 0 ; i < n ; i++){
            y[i] = scanner.nextInt();
        }

        int count = 0;

        for(int i = 0 ; i <= n-k ; i++){
            boolean valid = true;
            for(int j = i ; j <= i + k - 1 ; j++){
                if(x[j] < a || y[j] < b) {
                    valid = false;
                    break;
                }
            }
            if(valid){
                count++;
            }
        }
        System.out.println(count);
    }
}
