package com.zlfjw.main;


import java.util.*;

class ListNode {
    /**
     * 值
     */
      int val;
    /**
     * 指针域
     */
    ListNode next;

    /**
     *
     * @param x
     */
      ListNode(int x) { val = x; }
}

public class Solution {
    /**
     * 滑动窗口
     * @param s
     * @return
     */
    //最长无重复子串
    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap();
        int ans = 0;
        for(int i = 0,j = 0;j < s.length();j++){
            if (map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)) + 1,i); //如果存在相同元素，则直接跳到该元素所在的索引位置
            }
            ans = Math.max(ans,j-i+1);
            map.put(s.charAt(j),j);//map会覆盖相同的键值对
        }
        return ans;
    }
    //串联所有单词的子串
    public static List<Integer> findSubstring(String s, String[] words) {
        long start = System.currentTimeMillis();
        List<Integer> list = new LinkedList();
        if (s.length() == 0 || words.length == 0){
            return list;
        }
        Map<String,Integer> map1 = new HashMap();
        Map<String,Integer> map2 = new HashMap();
        //初始化单词数组统计次数，放到map1中
        for(int i = 0;i < words.length;i++){
            if(map1.containsKey(words[i])){
                map1.put(words[i],map1.get(words[i])+1);
            }else{
                map1.put(words[i],1);
            }
        }
        int onewordlen = words[0].length();
        int totallen = onewordlen * words.length;
        int len = s.length();
        for(int j = 0;j <= len - totallen;j++){
            String str = s.substring(j,j + totallen);
//            //第二次优化：如果本次截取的子串中的第一个单词匹配失败，则跳到下一次循环,第二次优化失败
//            String substring1 = str.substring(0,onewordlen);
//            if(!map1.containsKey(substring1)){
//                j += onewordlen -1;
//                continue;
//            }
            for(int k = 0;k <= totallen - onewordlen;k += onewordlen){
                String substring = str.substring(k, k + onewordlen);
                //第一次优化：如果第一次匹配失败就直接跳过本次截取的子串中其他单词的匹配
                if(!map1.containsKey(substring)){
                    break;
                }
                if(map2.containsKey(substring)){
                    map2.put(substring,map2.get(substring)+1);
                }else{
                    map2.put(substring,1);
                }
            }
            if(map2.equals(map1)){
                list.add(j);
            }
            map2.clear();
        }
       long end = System.currentTimeMillis();
        System.out.println(end - start);
        return list;
    }

    //寻找两个有序数组的中位数：归并排序的思路，二分查找，分治算法
    //优化思路：不需要遍历m+n次，其实只需要便利(m+n)/2次即可找到中位数
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0,j = 0,k = 0;
        double[] nums = new double[m+n];
        while(i < m && j < n){
            nums[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        while(i < m){
            nums[k++] = nums1[i++];
        }
        while(j < n){
            nums[k++] = nums2[j++];
        }
        double median = (nums.length % 2 == 0) ? (nums[(m+n)/2 - 1] + nums[(m+n)/2])/2
                : nums[(m+n)/2];
        return median;
    }

    //最长回文子串：动态规划
    public static String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] P = new boolean[length][length];
        int maxLen = 0;
        String maxPal = "";
        for (int len = 1; len <= length; len++) { //遍历所有的长度
            for (int start = 0; start < length; start++) {
                int end = start + len - 1;
                if (end >= length){ //下标已经越界，结束本次循环
                    break;
                }
                P[start][end] = (len == 1 || len == 2 || P[start + 1][end - 1]) && s.charAt(start) == s.charAt(end); //长度为 1 和 2 的单独判断下
                if (P[start][end]) {
                    maxPal = s.substring(start, end + 1);
                }
            }
        }
        return maxPal;
    }

    //合并区间：直接比较/先排序后比较
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }
        int row = intervals.length;
        int col = intervals[0].length;
        List<int[]> list = new ArrayList();
        for(int i = 0;i < row;i++){
            for(int j = i+1;j < row;j++){
                //分类讨论
                if(intervals[i][1] >= intervals[j][0] && intervals[i][0] <= intervals[j][1]){
                    if(intervals[i][0] < intervals[j][0]){
                        intervals[j][0] = intervals[i][0];
                    }
                    if(intervals[i][1] > intervals[j][1]){
                        intervals[j][1] = intervals[i][1];
                    }
                    intervals[i] = null;
                    break; //合并区间后需要退出循环，否则会报空指针
                }
            }
        }
        //将合并后的区间返回
        for(int k = 0;k < intervals.length;k++){
            if(intervals[k] != null){
                list.add(new int[]{intervals[k][0],intervals[k][1]});
            }
        }
        return list.toArray(new int[0][]);
    }

    //字符串转化整数
    public static int myAtoi(String str) {
        int rev = 0;
        char[] charList = str.toCharArray();
        int length = str.length();
        int zf = 1;
        int i = 0;
        int pop = 0;
        for(;  i < length; i++){
            if(charList[i] == ' '){
                continue;
            }else{
                if(charList[i] == '-'){
                    i++;
                    zf = -1;
                    break;
                }
                if(charList[i] == '+'){
                    i++;
                    break;
                }
                if(charList[i] <'0' || charList[i] >'9'){
                    return 0;
                }else{
                    break;
                }
            }
        }
        if(i == length){
            return 0;
        }
        for(;i < length; i++){
            if(charList[i] <'0' || charList[i] >'9'){
                return rev;
            }
            pop = (charList[i] -48) * zf;
            if(rev>Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)){
                return Integer.MAX_VALUE;
            }
            if(rev<Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)){
                return Integer.MIN_VALUE;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    //leetcode第10题，正则表达式匹配
    //解法一：回溯法
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) {
            return s.isEmpty();
        }
        boolean fist_match = (!s.isEmpty()
                && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));

        if(p.length() >= 2 && p.charAt(1) == '*'){

            return (isMatch(s,p.substring(2)) || fist_match && isMatch(s.substring(1),p));
        }else{
            return fist_match && isMatch(s.substring(1),p.substring(1));
        }
    }
    //解法二：动态规划
    //1.设计状态：用d[i][j]来表示前面s的前i个能否被p的前j个字符匹配
    // 2.状态转移方程：d[i][j] = d[i-1][j-1]
    public static boolean isMatchplus(String s,String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;//dp[i][j] 表示 s 的前 i 个是否能被 p 的前 j 个匹配
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                            /*
                            dp[i][j] = dp[i-1][j] // 多个字符匹配的情况
                            or dp[i][j] = dp[i][j-1] // 单个字符匹配的情况
                            or dp[i][j] = dp[i][j-2] // 没有匹配的情况
                             */

                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    //盛最多水的容器，爆破法
    public int maxArea(int[] height) {
        int maxArea = 0;
        for(int i = 0;i < height.length;i++){
            for(int j = i+1;j < height.length;j++){
                int h = height[i] < height[j] ? height[i] : height[j];
                int w = j - i;
                maxArea = maxArea < h*w ? h*w : maxArea;
            }
        }
        return maxArea;
    }
    //盛最多水的容器，双指针法

    //四数之和
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList();
        if(nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length - 1;
        for(int i = 0;i < nums.length-2;i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int max = nums[i] + nums[length] + nums[length-1] + nums[length-2];
            if(max < target){
                continue;
            }
            int min = nums[i] + nums[i+1] + nums[i+2] + nums[i+3];
            if(min > target){
                break;
            }
            for(int j = i + 1;j < length-1;j++){
                if(j > i + 1 && nums[j] == nums[j-1]){
                    continue;
                }
                int k = j + 1;
                int l = length;
                int min1 = nums[i] + nums[j] + nums[j+1] + nums[j+2];
                if(min1 > target) {
                    continue;
                }
                int max1 = nums[j] + nums[i] + nums[l] + nums[l-1];
                if(max1 < target) {
                    continue;
                }
                while(k < l){
                    if(nums[i] + nums[j] + nums[k] + nums[l] < target){
                        k++;
                    }
                    if(nums[i] + nums[j] + nums[k] + nums[l] > target){
                        l--;
                    }
                    if(nums[i] + nums[j] + nums[k] + nums[l] == target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        k++;
                        while(k < l && nums[k] == nums[k+1]){
                            k++;
                        }
                        l--;
                        while(k < l && j < l && nums[l] == nums[l-1]){
                            l--;
                        }
                    }
                }
            }
        }
        return result;
    }

    //删除链表的倒数第n个节点，两次遍历法 || 双指针法
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode consistNode = new ListNode(0);
        consistNode.next = head;
        ListNode first = head;
        int length = 0;
        while(first != null){
            length++;
            first = first.next;
        }
        ListNode second = consistNode;
        for(int i = 0;i < length - n;i++){
            second = second.next;
        }
        second.next = second.next.next;
        return consistNode.next;
    }

    //合并两个有序链表：迭代法 || 递归法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        ListNode preHead = new ListNode(0);
        ListNode ptail = preHead;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                ptail.next = l1;
                l1 = l1.next;
            }else{
                ptail.next = l2;
                l2 = l2.next;
            }
            ptail = ptail.next;
        }
        ptail.next = l1 != null ? l1 : l2;
        return preHead.next;
    }

    //合并k条有序链表：
    /**
     * 方法一：维护一个小顶堆，遍历所有节点
     * 时间复杂度分析：O(n*log(k)),n为所有节点的个数，log(k)为空小顶堆每次维护需要的时间复杂度
     * 空间复杂度分析：O(k)
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        int len = lists != null ? lists.length : 0;
        if(lists == null || len == 0){
            return null;
        }
        if(len == 1){
            return lists[0];
        }
        ListNode phead = new ListNode(0);
        ListNode ptail = phead;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(len, Comparator.comparingInt(q -> q.val));
        for(int i = 0;i < len;i++){
            if(lists[i] != null) {
                minHeap.offer(lists[i]);
            }
        }
        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            ptail.next = node;
            if(node.next != null){
                minHeap.offer(node.next);
            }
            ptail = ptail.next;
        }
        return phead.next;
    }

    /**
     * 方法二：两两合并，第一个节点和最后一个节点合并，以此类推
     * 时间复杂度：O(n*log(k)),n为两条链表的节点数
     * 空间复杂度：O(1)
     */
    public static ListNode mergeKListPlus(ListNode[] lists) {
        int len = lists != null ? lists.length : 0;
        if(lists == null || len == 0){
            return null;
        }
        if(len == 1){
            return lists[0];
        }
        while(len > 1){
            for(int i = 0;i < len/2;i++){
                lists[i] = mergeTwoList(lists[i],lists[len-i-1]);
            }
            len = (len+1)/2;
        }
        return lists[0];
    }
    public static ListNode mergeTwoList(ListNode l1,ListNode l2){
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        ListNode phead = new ListNode(0);
        ListNode ptail = phead;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                ptail.next = l1;
                l1 = l1.next;
            }else{
                ptail.next = l2;
                l2 = l2.next;
            }
            ptail = ptail.next;
        }
        if(l1 != null){
            ptail.next = l1;
        }
        if(l2 != null){
            ptail.next = l2;
        }
        return phead.next;
    }

    //括号生成

    /**
     * 深度优先遍历(递归回溯)
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        if(n == 0){
            return res;
        }
        dfs("",n,n,res);
        return res;
    }

    public static void dfs(String combination,int left,int right,List<String> result){
        if(left == 0 && right == 0){
            result.add(combination);
        }
        //剪枝
        if(left > right){
            return;
        }
        if(left > 0){
            dfs(combination + "(",left-1,right,result);
        }
        if(right > 0){
            dfs(combination + ")",left,right-1,result);
        }
    }

    /**
     * 动态规划法
     * dp[i]:使用i对括号能够生成的组合
     * dp[i] = "(" + dp[可能的括号对数] + ")" + 剩下的括号对数
     * @param n
     * @return
     */
    public static List<String> generateParenthesisPlus(int n) {
        if(n == 0){
            return new ArrayList();
        }
        List<List<String>> dp = new ArrayList(n);
        List<String> dp0 = new ArrayList();
        dp0.add("");
        dp.add(dp0);
        for(int i = 1;i <= n;i++){
            List<String> cur = new ArrayList();
            for(int j = 0;j < i;j++){
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i-j-1);
                for(String s1 : str1){
                    for(String s2 : str2){
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }

    //两两交换链表中的节点
    /**
     * 递归法
     */
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;

        first.next = swapPairs(second.next);
        second.next = first;
        return second;
    }
    /**
     * 迭代法
     * preNode:记录两个节点中第一个节点的前驱节点
     */
    public static ListNode swapPairsPlus(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preNode = dummy;
        while (head != null && head.next != null){
            ListNode first = head;
            ListNode second = head.next;

            preNode.next = second;
            first.next = second.next;
            second.next = first;

            preNode = first;
            head = first.next;
        }
        return dummy.next;
    }

    //旋转数组
    /**
     * 旋转k次
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    /**
     * 反转数组法
     * @param nums
     * @param k
     */
    public static void rotatePlus(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        reverse(nums,0,len-1);
        reverse(nums,0,k-1);
        reverse(nums,k,len-1);
    }
    public static void reverse(int[] nums,int start,int end){
        int temp = 0;
        while(start < end){
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    //实现strStr
    public static int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if(len2 == 0 || haystack.equals(needle)){
            return 0;
        }
        for(int i = 0;i <= len1 - len2;i++){
            String str = haystack.substring(i,i+len2);
            if(str.equals(needle)){
                return i;
            }
        }
        return -1;
    }

    //两数相除
    public static int divide(int dividend, int divisor) {
        if(divisor == 1){
            return dividend;
        }
        if(dividend == 0){
            return 0;
        }
        if(divisor == -1){
            if(dividend > Integer.MIN_VALUE){
                return -dividend;
            }
            return Integer.MAX_VALUE;
        }
        boolean sign = (dividend>0)^(divisor>0);
        long divid = dividend > 0 ? dividend : -(long)dividend;
        long divis = divisor > 0 ? divisor : -(long)divisor;
        int res = div(divid,divis);
        if(sign) {
            return -res;
        }
        return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : res;
    }
    public static int div(long a,long b){
        if(a<b){
            return 0;
        }
        long temp = 1;
        long count = b;
        while((count + count) < a){
            temp += temp;
            count += count;
        }
        return (int)(temp + div(a-count,b));
    }

    //搜索旋转数组,两次二分查找，时间复杂度为O(lgn);
    public static int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0){
            return -1;
        }
        if(len == 1){
            return nums[0] == target ? 0 : -1;
        }
        int index = findIndex(nums,0,len-1);
        if(nums[index] == target){
            return index;
        }
        if(index == 0){
            return binarySearch(nums,0,len-1,target);
        }
        if(target < nums[0]){
            return binarySearch(nums,index,len-1,target);
        }
        return binarySearch(nums,0,index,target);
    }
    public static int findIndex(int[] nums,int left,int right){
        if(nums[left] < nums[right]) {
            return 0;
        }
        while(left <= right){
            int temp = (left+right)/2;
            if(nums[temp] > nums[temp+1]){
                return temp+1;
            }else{
                if(nums[temp] < nums[right]){
                    right -= 1;
                }else{
                    left += 1;
                }
            }
        }
        return 0;
    }

    /**
     * 二分查找框架
     * @param nums
     * @param start
     * @param end
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums,int start,int end,int target){
        while(start <= end){ //若end为有效下标，则需要start <= end，搜索区间为：[start,end]；否则start < end，搜索区间为：[start,end)
            int mod = (start + end)/2;
            if(nums[mod] == target){
                return mod;
            }else{
                if(nums[mod] > target){
                    end = mod - 1;
                }
                if(nums[mod] < target){
                    start = mod +1;
                }
            }
        }
        return -1;
    }

    //在排序数组中查找元素的第一个和最后一个位置，时间要求为O(lgn)
    public static int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        if(nums.length == 1){
            return nums[0] == target ? new int[]{0,0} : new int[]{-1,-1};
        }
        int start = leftSearch(nums,target);
        int end = rightSearch(nums,target);
        return new int[]{start,end};
    }
    public static int leftSearch(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mod = (left + right)/2;
            if(nums[mod] == target){
                right = mod-1;
            }
            if(nums[mod] < target){
                left = mod + 1;
            }
            if(nums[mod] > target){
                right = mod - 1;
            }
        }
        if(left == nums.length){ //注意处理下标越界的情况
            return -1;
        }
        return nums[left] == target ? left : -1;
    }
    public static int rightSearch(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mod = (left + right)/2;
            if(nums[mod] < target){
                left = mod + 1;
            }
            if(nums[mod] > target){
                right = mod - 1;
            }
            if(nums[mod] == target){
                left = mod+1;
            }
        }
        if(right < 0){ //注意处理下标越界的情况
            return right;
        }
        return nums[right] == target ? right : -1;
    }

    public static String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        StringBuffer buffer = new StringBuffer();
        String str = countAndSay(n-1);
        char num = str.charAt(0);
        int count = 1;
        for(int j = 1;j < str.length();j++){
            if(num == str.charAt(j)){
                count++;
            }else {

                buffer.append(count);
                buffer.append(num);
                count = 1;
                num = str.charAt(j);
            }
        }
        buffer.append(count);
        buffer.append(num);
        return buffer.toString();
    }

    //接雨水，基本解题思路就是，遍历所有列，找出当前列左边最高的列和右边最高的列，然后分三种情况讨论

    /**
     * 解法一：按列求
     * 时间复杂度：O(n2)
     * 空间复杂度：O(1)
     * @param height 入参
     * @return 回参
     */
    public static int trap(int[] height) {
        int sum = 0;
        for(int i = 0;i < height.length;i++){
            int max_left = height[0];
            for(int j = i-1;j >= 0;j--){
                max_left = Math.max(max_left,height[j]);
            }

            int max_right = height[height.length-1];
            for(int k = height.length-2;k > i;k--){
                max_right = Math.max(max_right,height[k]);
            }

            int min = Math.min(max_right,max_left);
            if(min > height[i]){
                sum += min-height[i];
            }
        }
        return sum;
    }

    /**
     * 解法二：动态规划法
     * 设计状态：maxLeft[i]表示当前列左边最高的列，maxRigth[i]表示当前列右边最高的列
     * 状态转移方程：maxLeft[i] = Math.min(maxLeft[i-1] , height[i-1]),maxRight = Math.max(maxRight[i+1],height[i+1])
     * 该状态基于这样的假设：即第i列左边最高的列只可能出现在第i-1列左边最高的列和第i-1列之间
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * 用空间换时间
     * @param height 入参
     * @return 回参
     */
    public static int trapDp(int[] height){
        int sum = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        for(int i = 1;i < height.length - 1;i++){
            maxLeft[i] = Math.max(maxLeft[i-1],height[i-1]);
        }

        for(int j = height.length - 2;j >= 0;j--){
            maxRight[j] = Math.max(maxRight[j+1],height[j+1]);
        }

        for(int k = 1;k < height.length - 1;k++){
            int min = Math.min(maxLeft[k],maxRight[k]);
            if(min > height[k]){
                sum += min - height[k];
            }
        }
        return sum;
    }

    /**
     * 解法三：双指针法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static int trapTwoPoint(int[] height){
        int left = 1; //左指针
        int right = height.length-2; //右指针
        int sum = 0;
        int maxLeft = 0;
        int maxRight = 0;
        for(int i = 0;i < height.length-1;i++){
            if(height[left-1] < height[right+1]){
                maxLeft = Math.max(height[left-1],maxLeft);
                int min = maxLeft;
                if(min > height[left]){
                    sum += min-height[left];
                }
                left++;
            }else {
                maxRight = Math.max(maxRight,height[right+1]);
                int min = maxRight;
                if(min > height[right]){
                    sum += min - height[right];
                }
                right--;
            }
        }
        return sum;
    }

    /**
     * 解法四：利用栈
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param height
     * @return
     */
    public static int trapStack(int[] height){
        Stack<Integer> Stack = new Stack();
        int current = 0;
        int sum = 0;
        while(current < height.length){
            while(!Stack.isEmpty() && height[current] > height[Stack.peek()]){
                int h = height[Stack.peek()];
                Stack.pop();
                if(Stack.isEmpty()){
                    break;
                }
                int dis = current - Stack.peek()-1;
                int min = Math.min(height[current],height[Stack.peek()]);
                sum += dis*(min-h);
            }
            Stack.push(current);
            current++;
        }
        return sum;
    }

    //字符串相乘

    /**
     * 解题思路：模拟竖式乘法
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {
        if(num1 == "0" || num2 == "0"){
            return "0";
        }
        int tmp = 0;
        String res = "";
        for(int i = num1.length()-1;i >= 0;i--){
            StringBuffer buffer = new StringBuffer();
            //此处需要补0，相当于进位，很重要
            for(int k = 0;k < num1.length()-i-1;k++){
                buffer.append(0);
            }

            for(int j = num2.length()-1;j >= 0;j--){
                int a = num1.charAt(i) - 48;
                int b = num2.charAt(j) - 48;
                int sum = a * b + tmp;
                tmp = sum/10;
                buffer.append(sum%10);
            }
            if(tmp > 0){
                buffer.append(tmp);
            }
            tmp = 0;
            res = addStrings(res,buffer.reverse().toString());
        }
        return res;
    }

    /**
     * 模拟竖式加法，将俩个数字字符串相加
     * @param res
     * @param buffer
     * @return
     */
    public static String addStrings(String res,String buffer){
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = res.length() - 1, j = buffer.length() - 1;
             i >= 0 || j >= 0 || carry != 0;
             i--, j--) {
            int x = i < 0 ? 0 : res.charAt(i) - '0';
            int y = j < 0 ? 0 : buffer.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            builder.append(sum);
            carry = (x + y + carry) / 10;
        }
        return builder.reverse().toString();
    }

    /**
     * 字符串相乘优化版
     */
    public String multiplyPlus(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int tmp = 0;
        int[] res = new int[num2.length()+num1.length()];
        for(int i = num1.length()-1;i >= 0;i--){
            int n1 = num1.charAt(i) - 48;
            for(int j = num2.length()-1;j >= 0;j--){
                int n2 = num2.charAt(j) - 48;
                int sum = res[i+j+1] + n1*n2; //这里的res[i+j+1]是前几次相乘在该位置上的数
                res[i+j+1] = sum%10;  //res[i+j+1]保存乘积的个位数
                res[i+j] += sum/10;
            }
        }
        StringBuffer buffer = new StringBuffer();
        for(int i = 0;i < res.length;i++){
            if(i == 0 && res[i] == 0){
                continue;
            }
            buffer.append(res[i]);
        }
        return buffer.toString();
    }

    //全排列

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> temp = new ArrayList();
        backTack(res,nums,temp);
        return res;
    }
    public void backTack(List<List<Integer>> res,int[] nums,List<Integer> temp){
        if(temp.size() == nums.length){
            res.add(new LinkedList(temp));
        }
        for(int i = 0;i < nums.length;i++){
            if(temp.contains(nums[i])){
                continue;
            }
            temp.add(nums[i]);
            backTack(res,nums,temp);
            temp.remove(temp.size()-1);
        }
    }

    //旋转图像

    /**
     * 解法一：先转置矩阵，然后翻转每一行
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0;i < n;i++){
            for(int j = i;j < n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int k = 0;k < n;k++){
            for(int l = 0;l < n/2;l++){
                int temp = matrix[k][l];
                matrix[k][l] = matrix[k][n-l-1];
                matrix[k][n-l-1] = temp;
            }
        }
    }

    //字母异位词分组
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List> map = new HashMap();
        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }

    //pow
    public double myPow(double x, int n) {
        long N = n;
        if(N < 0){
            x = 1/x;
            N = -N;
        }
        double res = pow(x,N);
        return res;
    }
    public double pow(double x,long n){
        if(n == 0){
            return 1.0;
        }
        double half = pow(x,n/2);
        if(n % 2 == 0){
            return half*half;
        }else{
            return half * half * x;
        }
    }

    //最大子序和

    /**
     * 解法一：贪心算法
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int cur = nums[0];
        int max = nums[0];
        for(int i = 1;i < nums.length;i++){
            //保存当前位置的最大和
            cur = Math.max(nums[i],cur+nums[i]);
            //更新目前为止的最大和
            max = Math.max(cur,max);
        }
        return max;
    }

    /**
     * 解法二：动态规划
     * 设计状态：dp[i]用来保存当前为止的最大子序和，即在下标[0,i]之间的最大子序和
     * 状态转移方程：dp[i] = Math.max(dp[i-1] + nums[i],nums[i]),即dp[i] = Math.max(当前位置的元素加上前面的最大子序和 || 当前位置的元素)
     */
    public int maxSubArrayDp(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i = 1;i < nums.length;i++){
            dp[i] = Math.max(nums[i] + dp[i-1],nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    //跳跃游戏
    public boolean canJump(int[] nums) {
        int k = 0;
        for(int i = 0;i < nums.length;i++){
            if(i > k){
                return false;
            }
            k = Math.max(k,i+nums[i]);
        }
        return true;
    }

    //不同路径

    /**
     * 动态规划：
     * 设计状态：dp[i][j]表示到达该位置共有多少种走法
     * 状态转移方程：dp[i][j] = dp[i-1] + dp[j-1];dp[i][0] = 1,dp[0][j] = 1
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;//这个地方需要注意一下，第一行和第一列的所有位置需要全部初始化为1
        for (int i = 0; i < m; i++) dp[i][0] = 1;

        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    //视野争夺
    public static int  visionCompetition (int[][] area){
        int row = area.length;
        //排序
        for(int i = 1;i < row;i++){
            for(int j = i+1;j < row;j++){
                if(area[i][0] > area[j][0]){
                    int[] tmp = area[i];
                    area[i] = area[j];
                    area[j] = tmp;
                }
            }
        }
        int i = 1;
        int count = 0;
        while(i < row-1){
            if(area[i][1] >= area[i+1][0] && area[i+1][1] >= area[1][1]){
                area[1][1] = area[i+1][1];
                i++;
            }
            if(area[1][1] >= area[0][1]){
                return count+1;//这里需要注意+1
            }
            count++;
        }
        return -1;
    }

    //66.加一
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        int flag = 1;
        for(int i = n-1;i >= 0;i--){
            int tmp = digits[i] + flag;
            if(tmp > 9){
                digits[i] = tmp % 10;
                flag = tmp /10;
            }else{
                digits[i] = tmp;
                flag = 0;
                break;
            }
        }
        if(flag > 0){
            int[] res = new int[n+1];
            res[0] = flag;
            System.arraycopy(digits,0,res,1,n);
            return res;
        }
        return digits;
    }

    //x的平方根

    /**
     * 解法一
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        if(x < 4){
            return 1;
        }
        long res = 0;
        for(long i = 1;i <= (x/2)+1;i++){
            long mul = i*i;
            if(mul == x){
                res = i;
                break;
            }
            if(mul > x || mul >= Integer.MAX_VALUE){
                res = i - 1;
                break;
            }
        }
        return (int)res;
    }

    /**
     * 解法二：二分查找
     */
    public static int mySqrtPlus(int x) {
        if(x == 0){
            return 0;
        }
        if(x < 4){
            return 1;
        }
        long res = binatrySerach(1,(long)x,x);
        return (int)res;
    }
    public static long binatrySerach(long left,long right,int n){
        while(left <= right){
            long mid = (left+right)/2;
            if(mid*mid == n){
                return mid;
            }else if(mid*mid > n && (mid-1)*(mid-1) < n){
                return mid-1;
            }else if(mid*mid > n){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return 0;
    }

    //70.青蛙跳台阶

    /**
     * 斐波那契数列，动态规划，排列组合，都可
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2;i < n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }

    //75.颜色分类
    /**
     * 解法一：利用排序库（快排）
     * @param nums
     */
    public static void sortColors(int[] nums) {
        Arrays.sort(nums);
    }

    /**
     * 解法二：利用计数排序
     */
    public static void sortColorsPlus(int[] nums) {
        int[] array = new int[3];
        List<Integer> res = new ArrayList();
        for(int i = 0;i < nums.length;i++){
            array[nums[i]]++;
        }
        for(int j = 0,i = 0;j < array.length;j++){
            while(array[j] > 0){
                nums[i++] = j;
                array[j]--;
            }
        }
    }
}
