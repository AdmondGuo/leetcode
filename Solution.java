import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Solution {
    //获取input中的最小的k个数
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        int len = input.length;
        int temp = 0;
        ArrayList<Integer> list = new ArrayList<>();
        if(k>len){
            return list;
        }
        for(int i=0;i<k;i++){
            for(int j=len-1;j>0;j--){
                if(input[j]<input[j-1]){
                    // swag
                    temp = input[j-1];
                    input[j-1] = input[j];
                    input[j] = temp;
                }
                System.out.println(input[j]);
            }
            list.add(input[i]);
        }
        return list;
    }

    public static int[] twoSum (int[] numbers, int target) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = numbers.length;
        for(int i=0;i<len;i++){
            if(map.containsKey(target-numbers[i])){
                return new int[] {map.get(target-numbers[i]),i+1};
            }
            map.put(numbers[i],i+1);
        }
        return null;
    }

    public static int maxLength (int[] arr) {
        // write code here
        if(arr.length==0){
            return 0;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        // size记录上次的最大值
        int size = 0;
        for(int i=0,j=0;i<arr.length;i++){
            if(hashMap.containsKey(arr[i])){
                j = Math.max(j, hashMap.get(arr[i]) + 1);
            }
            hashMap.put(arr[i], i);
            size = Math.max(size, i - j + 1);
        }
        return size;
    }

    public static boolean isValid (String s) {
        // write code here
        Stack<Character> stack = new Stack<Character>();
        for (int i=0;i<s.length();i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
                continue;
            }
            if(s.charAt(i)==')'&& stack.peek()=='(') {stack.pop();}
            else if(s.charAt(i)==']'&&stack.peek()=='[') {
                stack.pop();
            }
            else if(s.charAt(i)=='}'&&stack.peek()=='{') {
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        return stack.empty();
    }

    public static int Fibonacci(int n) {
        int i=0,j=1;
        int temp = 0;
        if(n==0) return 0;
        if(n==1) return 1;
        while(n>1){
            temp = i+j;
            i=j;
            j=temp;
            n--;
        }
        return temp;
    }

    // 二分查找
    // 注意left,right,mid中间的转换以及边界条件
    public static int search (int[] nums, int target) {
        // write code here
        int left = 0, right = nums.length-1;
        int mid = 0;
        while(left<=right){      //边界条件
            mid = left+ (right-left) / 2;
            if(nums[mid]==target){
                //mid到最左边
                while(mid>0&&nums[mid]==nums[mid-1]){
                    mid--;
                }
                return mid;
            }
            else if(nums[mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }

    /**
     * @bank nowcoder
     * @num No.最长回文子串
     * @date aa
     * */

    // 中心扩散法
    public static int getLongestPalindrome(String A, int n) {
        // write code here
        int odd, even = 0;
        int max = 1;
        if(n<2){
            return n;
        }
        for(int i=0;i<n;i++){
            even = centerSpread(A, i, i+1);
            odd = centerSpread(A, i, i);
            max = Math.max(Math.max(even, odd), max);
        }
        return max;
    }

    public static int centerSpread(String s, int left, int right){
        int len = s.length();
        int l = left;
        int r = right;
        while(l >= 0 && r <= len-1 && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }

    /**
     * @bank nowcoder
     * @num No.
     * @title
     * @desc
     * @date a a
     */

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        // 上面的代码类似 hasCycle 函数
        if (fast == null || fast.next == null) {
            // fast 遇到空指针说明没有环
            return null;
        }
        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * @bank nowcoder
     * @num No.NC59
     * @tte 矩阵最短路径和
     * @desc 动态规划模板题
     * @date a a
     */
    public int minPathSum(int[][] matrix) {
        // write code here
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 1; i < row; i++) {
            dp[i][0] = matrix[i - 1][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = matrix[0][j - 1];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }
        return dp[row][col];
    }

    public static void main(String[] args) {
        int [] arr = {-2,1,2};
        int num=4;
        String str = "abc1234321ab";
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack.size());
        System.out.println(stack.empty());
//        System.out.println(getLongestPalindrome(str,str.length()));
    }
}