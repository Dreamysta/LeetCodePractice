public class LeetCode647 {
    public int countSubstrings(String s){
        int n = s.length();
        int ans = n;
        char[] letters = s.toCharArray();
        for(int k = 0 ; k < n ; k++){
            int i = k-1,j = k+1;
            while (i >= 0 && j < n && letters[i--] == letters[j++]){
                ans++;
            }

            i = k;
            j = k+1;
            while (i >= 0 && j < n && letters[i--] == letters[j++]){
                ans ++;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        LeetCode647 solution = new LeetCode647();
        String s = "aaa";

        int result = solution.countSubstrings(s);
        System.out.println("回文子串的数量是：\n" + result);
    }
}
