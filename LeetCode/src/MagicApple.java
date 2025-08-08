import java.util.Scanner;

/*类型 1 直接累加苹果数量。
类型 2 判断当前数量是否足够，足够则减去对应数量，否则不操作。
类型 3 通过公式(appleCount + m - 1) / m实现向上取整计算，再从总数中减去取走的数量。*/

public class MagicApple {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//操作的数量
        int appleCount = 0;

        for(int i = 0 ; i < n ; i++){
            int type = scanner.nextInt();//操作类型
            int m = scanner.nextInt();//操作参数

            switch(type){
                case 1:
                    //类型1：增加m个苹果
                    appleCount += m;
                    break;
                case 2:
                    if(appleCount >= m){
                        appleCount -= m;
                    }
                    break;
                case 3:
                    if(m == 0){
                        break;
                    }
                    int take = (appleCount + m - 1)/m;
                    appleCount -= take;
                    break;
            }
        }

        System.out.println(appleCount);
        scanner.close();

    }
}
