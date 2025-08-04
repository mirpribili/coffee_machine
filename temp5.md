```
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
интервалы
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
int[][] test1 = {{1,3},{2,6},{8,10},{15,18}};  
int[][] expected1 = {{1,6},{8,10},{15,18}};

private static boolean isOverLapping(int[] a, int[] b){
    return Math.max(a[0], b[0]) <= Math.min(a[1], b[1]);
}
private static int[] mergeTwoIntervals(int[] a, int[] b){
    return new int[]{a[0], Math.max(a[1], b[1])};
}

public static int[][] merge(int[][] intervals) {
    if(intervals.length == 0) retutn new int[0][];
    List<int[]> res = new ArrayList<>();
    
    Arrays.sort(intervals, Comarator.compareInt(a->a[0]));

    res.add(intervals[0]);
    for(int i = 1; i<intervals.length; i++){
        int[] cur = intervals[i];
        int[] last = res.get(res.size() - 1);
        if(isOverLapping(cur, last)){
            res.set(res.size()-1, mergeTwoIntervals(last, cur));
        } else {
            res.add(cur);
        }
    }
    return res.toArray(new int[res.size()][]);
}

TreeMap<Integer, List<int[]> map = new TreeMap<>();
// ключ нач интервала а значение список интерв с так началом
for(int[] inter : intervals){
    map.computeIfAbsent(interval[0], k->new ArrayList<>()).add(inter);
}
List<int[]> sortedIntervals = new ArrayList<>();
for(List<int[]> list: map.getValues()){
    sortedIntervals.addAll(list);
}
List<int[]> result = new ArrayList<>();  
result.add(sortedIntervals.get(0)); 
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
int[][] test1 = {{0, 30}, {5, 10}, {15, 20}};
int expected1 = 2;


public static int minMeetingRoomsTwoPointer(int[][] intervals) {
    if (intervals == null || intervals.length == 0 ) return 0;
    int l = intervals.length;

    int[] start = new int[l];
    int[] end = new int[l];

    for(int i = 0; i< l; i++){
        start[i] = intervals[i][0];
        end[i] = intervals[i][1];
    }
    Arrays.sort(start);
    Arrays.sort(end);

    int endMeet = 0;
    int room = 0;
    for(int i=0; i<l; i++){
        if(start[i] < end[endMeet]){
            room++;
        } else {
            endMeet++;
        }
    }
    return room;
}

321435 == PriorityQueue
     1
    / \
   3   2
  / \   \
 4   3   5

public static int minMeetingRoomsTwoPointer(int[][] intervals) {
    if (intervals == null || intervals.length == 0) return 0;
    PriorityQueue<Integer> queueEnds = new PriorityQueue<>();
    Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
    queueEnds.add(intervals[0][1]);
    for(int i =1; i<intervals.length; i++){
        if(intervals[i][0] >= queueEnds.peek()){
            queueEnds.pool();
        }
        queueEnds.add(intervals[i][1]);
    }
    return queueEnds.size();
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Car Pooling 
int[][] trips2 = {{2, 1, 5}, {3, 5, 7}}; 2-pas 1-start 5-end
> int capacity2 = 5; res=true
> int capacity1 = 4; res=false
public boolean canCarPool(int[][] trips, int capacity) {
        if(trips == null) return false;
        int[] passengerChanges = new int[1001];
        for(int[][] t: trips){
            int pass = t[0];
            int start = t[1];
            int end = t[2];
            passengerChanges[start] += pass;
            passengerChanges[end] -= pass;
        }
        int curPass = 0;
        for(int[] change : passengerChanges){
            curPass += change; // #####
            if (curPass > capacity) return false;
        }
        return true;
}
Время: O(N + M), где N — число поездок, M — максимальная точка маршрута (1000)
Память: O(M) (фиксированный массив на 1001 элемент)
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
int[][] test1 = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};  
int expected1 = 2;

Minimum Number of Arrows to Burst Balloons
public int findMinArrowShots(int[][] balloons) {
    if(balloons==null || balloons.length == 0)) return 0; //#####
    Arrays.sort(balloons, Comparator.comparingInt(a->a[1]));
    int end = balloons[0][1];
    int arrow = 1;
    for (int i = 1; i<balloons.length; i++){
        if(balloons[i][0] > end){
            arrow++;
            end = balloons[i][1];
        }
    }
    return arrow;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
int[][] segments1 = {{0, 5}, {-3, 2}, {7, 10}}; 
int[] points1 = {1, 6};
int[] expected1 = {2, 0};

public static int[] countSegments(int[][] segments, int[] points) {
    if(segments == null || segments.length == 0) return new int[0];
    int l = segments.length;

    int[] start = new int[l];
    int[] end = new int[l];
    int[] res = new int[points.length];
    for(int i = 0; i<l; i++){
        start[i] = Math.min(segments[i][0], segments[i][1]);
        end[i]   = Math.max(segments[i][0], segments[i][1]);
    }
    Arrays.sort(start);// #######
    Arrays.sort(end);// #######

    for(int i = 0; i<points.length; i++){
        int countS = lowerGreedyBand(start, points[i]);
        int counte = apperBand(end, points[i]);
        res[i] = countS - counte;
    }
    return res;
}
private int lowerGreedyBand(int[] ar, int key){
    int left = 0;
    int right = ar.length;
    while(left<right){
        int mid = (left+right) >>> 1; // (a+b)/2 == a+(b-a)/2
        if(key >= ar[mid]) left = mid +1;
        else right = mid;
    }
    return left;
}

private int apperBand(int[] ar, int key){
    int left = 0;
    int right = ar.length;
    while(left<right){
        int mid = (left+right) >>> 1; // (a+b)/2 == a+(b-a)/2
        if(key > ar[mid]) left = mid +1;
        else right = mid;
    }
    return left;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Add Two Numbers
2->4->3 // число 342
5->6->4 // число 465
7->0->8 // res

static class Node {  
    int val;  
    Node next;  
    Node(int x) { val = x; }  
}  
  
public Node addTwoNumbers(Node l1, Node l2) {
    Node dummy = new Node(-100);
    Node p1 = l1;
    Node p2 = l2;
    Node cur = dummy;
    int carry = 0;

    while(p1 != null || p2 != null){ //######
        int x = (p1 != null) ? p1.val : 0;
        int y = (p2 != null) ? p2.val : 0;
        int sum = x + y + carry;
        cur.next = new Node(sum%10); /// #####
        cur = cur.next;
        carry = sum / 10; // ####
        if(p1 != null) p1 = p1.next;
        if(p2 != null) p2 = p2.next;
    }
    if(carry > 0) cur.next = new Node(carry);
    return dummy.next;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
public static int[] addNumbers(int[] arr1, int[] arr2) { 
    int l1 = arr1.length;
    int l2 = arr2.length;
    int k = Math.max(l1, l2);
    int[] res = new int[k+1]; // + 1 тк доп разряд

    l1--; // ####
    l2--; // ####

    int carry = 0;
    while(l1>=0 || l2 >=0){
        int x = (l1>=0) ? arr1[l1] : 0;
        int y = (l2>=0) ? arr2[l2] : 0;
        int sum = x + y + carry;
        carry = sum / 10;
        res[k] = sum % 10;
        l1--;
        l2--;
        k--;
    }
    if(carry == 0 ) return Arrays.copyOfRange(res, 1, res.length);
    else res[k] = carry;

    return res;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Backtracking
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
String[] tests = {"23", "", "2"};
String[][] expected = {
    {"ad","ae","af","bd","be","bf","cd","ce","cf"},
    {},
    {"a","b","c"}
};
private static final String[] KEYS = {
    "", // 0
    "", // 1
    "abc", // 2
    "def", // 3
    "ghi", // 4
    "jkl", // 5
    "mno", // 6
    "pqrs",// 7
    "tuv", // 8
    "wxyz" // 9
};

public List<String> combinations(String digits){
    List<String> res = new ArrayList<>();
    if(digits == null || digits.length() == 0) return res;
    backtrack(digits, res, new StringBuilder(), 0);
    return res;
}
private void backtrack(String digits, List<String> res, StringBuilder cur, int index){
    if(index == digits.length()){ // #####
        res.add(cur.toString());
        return;
    }
    String letters = KEYS[digits.charAt(index) - '0'];// chat to int
    for (int i = 0; i<letters.length(); i++){
        cur.append(letters.charAt(i));
        backtrack(digits, res, cur, index + 1);
        cur.deleteCharAt(cur.length() - 1);
    }
}

VAR 2

public List<String> letterCombinations(String digits) {
    List<String> res = new ArrayList<>();
    if( digits == null || digits.length() == 0) return res;
    res.add(""); // for start
    for(int i = 0; i<digits.length(); i++){
        String letters = KEYS[digits.charAt(i) - '0'];
        List<String> temp = new ArrayList<>();
        for(String re : res){
            for(char letter : letters.toCharArray()){
                temp.add(re + letter);
            }
        }
        res = temp;
    }
    return res;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
{1, 2, 3}, ожидается 6 перестановок
Реальный результат (6 перестановок):
[1, 2, 3]
[1, 3, 2]
[2, 1, 3]
[2, 3, 1]
[3, 2, 1]
[3, 1, 2]

public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    backtrack(res, nums, 0);
    return res;
}
private static void backtrack(List<List<Integer>> res, int[] nums, int start){
    if(start == nums.length){
        List<Integer> temp = new ArrayList<>();
        for(int n : nums){
            temp.add(n);
        }
        res.add(temp);
        return;
    }
    for(int i = start; i<nums.length; i++){
        swap(nums, i, start);
        backtrack(res, nums, start + 1);
        swap(nums, i, start);
    }
}
private static void swap(int[] nums, int i, int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
.Q..
...Q
Q...
..Q.

private int n;
private boolean[] d1;
private boolean[] d2;
private boolean[] cols;
private List<List<String>> res;

public NQueenSolution(int n){
    this.n = n;
    d1 = new boolean[2 * n - 1];
    d2 = new boolean[2 * n - 1];
    cols = new boolean[n];
    res = new ArrayList<>();
}
public List<String> solution(){
    backtrack(0, new int[n]);
    return res;
}
private void backtrack(int row, int[] queen){
    if(row == n){
        res.add(drawBoard(queen));
    }
    for(int col = 0; i < n; col++){
        if(cols[col] || d1[row + col] || d2[row - col + n - 1]) continue; // #####
        queen[row] = col;
        d1[row + col] = true;
        d2[row - col + n - 1] = true;
        cols[col] = true;
        backtrack(row + 1, queen);
        d1[row + col] = false;
        d2[row - col + n - 1] = false;
        cols[col] = false;
    }
}
private List<String> drawBoard(int[] queen){
    List<String> temp = new ArrayList<>();
    for(int i = 0; i<n; i++){
        char[] row = new char[n];
        Arrays.fill(row, '.');
        row[queen[i]] = 'Q';
        //temp.add(row.toString()); BAD
        temp.add(new String(row));
    }
    return temp;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Input: 3
Output: [((())), (()()), (())(), ()(()), ()()()]
брут: O(2^2n ) по времени, т.к. перебираем все строки из 2n символов '(' и ')'.
реку: Сn ное число Каталана тк выбир только валидные

public List<String> generateParentheses(int n) {
    List<String> res = new ArrayList<>();
    backtrack(res, new StringBuilder(), n, 0, 0);
    return res;
}
private void backtrack(List<String> res, StringBuilder cur, int max, int open, int close){
    if(cur.length() == max * 2){
        res.add(cur.toString());
        return;
    }
    if(open < max){
        cur.append('(');
        backtrack(res, cur, max, open + 1, close);
        cur.deleteCharAt(cur.length() - 1);
    }
    if(close < open){
        cur.append(')');
        backtrack(res, cur, max, open, close + 1);
        cur.deleteCharAt(cur.length() - 1);
    }
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
candidates = {2, 4, 6, 8};
target = 8;
Output: [[2, 2, 2, 2], [2, 2, 4], [2, 6], [4, 4], [8]]

public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    backtrack(0, res, candidates, target, new ArrayList<>());
    return res;
}
private void backtrack(int start, List<List<Integer>> res, 
                        int[] candidates, int target, List<Integer> cur){
    if(target == 0){
        res.add(new ArrayList<>(cur)); // ### for stop change loc cur
        return;
    } else if(target < 0){
        return;
    }
    for(int i = start; i<candidates.length; i++){
        cur.add(candidates[i]);
        backtrack(i, res, candidates, target - candidates[i], cur);
        // ### Если i + 1, то каждый элемент можно использовать только один раз
        cur.remove(cur.size() - 1); // .length() BAD for list
    }
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Slide Window
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
INP {0, 1, 2, 4, 5, 7};
OUT {"0->2", "4->5", "7"}
public List<String> summaryRanges(int[] nums) {
    int i = 0;
    List<String> res = new ArrayList<>();
    while(i < nums.length){
        int j = i;
        while(j + 1 < nums.length && nums[j + 1] == nums[j] + 1){
            j++;
        }

        if(i == j){
            res.add(String.valueOf(nums[i]));
        }else{
            res.add(nums[i] + "->" + nums[j]);
        }
        i = j + 1;
    }
    return res;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
int[] test1 = {1,1,1,0,0,};
int k1 = 2;
int expected1 = 5;

int[] test1 = {1,1,1,0,0,  0,1,1,1,1,0};
int k1 = 2;
int expected1 = 6;

public int findMaxConsecutiveOnes(int[] nums, int k) {
    int res = 0;
    int zero = 0;
    int left = 0;
    for(int right = 0; right < nums.length; right++){
        if(nums[right] == 0){
            zero++;
        }
        while(zero > k){
            if(nums[left] == 0) zero--;
            left++;
        }
        res = Math.max(res, right - left + 1);
    }
    return res;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
String[] tests = {"abcabcbb", "bbbbb", "pwwkew", "dvdf"};
int[] expected = {3, 1, 3, 3};


public static int lengthOfLongestSubstring(String s) {
    int res = 0;
    int[] ansi = new int[128];
    for(int i =0, j = 0; j<s.length(); j++){
        i = Math.max(ansi[ s.charAt(j) ], i);
        res = Math.max(res,  j - i + 1 );
        ansi[ s.charAt(j) ] = j + 1;
    }
    return res;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Input: seats = [1,0,0,0,1,0,1]
Output: 2

Input: seats = [1,0,0,0]
Output: 3

public static int maxDistToClosest(int[] seats) {
    int res = 0;
    int left = -1;
    for(int right = 0; right<seats.length; right++){
        if(seats[right] == 1){
            if(left == -1){
                res = right;
            } else {
                res = Math.max(res, (right - left)/2 );
            }
            left = right;
        }
    }
    if(seats[seats.length - 1] == 0){
        res = Math.max(res, seats.length - 1 - left);
    }
    return res;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
S1 "ab", S2 "eidbaooo", "true"
S1 "ab", S2 "eidboaoo", "false"
public static boolean checkInclusion(String s1, String s2) { 
    if(s1.length() > s2.length()) return false;
    int[] abc = new int[26];
    for (int i = 0; i < s1.length()){
        abc[s1.charAt(i) - 'a'] --;
        abc[s2.charAt(i) - 'a'] ++; // #####
    }
    if(allZero(abc)) return true;

    for(int i = s1.length(); i<s2.length(); i++){
        abc[s2.charAt(i) - 'a'] ++;
        abc[s2.charAt(i - s1.length()) - 'a'] --;
        if(allZero(abc)) return true;
    }
    return false;
}
private static boolean allZero(int[] abc){
    for(int i = 0; i<abc.length; i++){
        if(abc[i] != 0) return false;
    }
    return true;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
s1 = "ADOBECODEBANC", t1 = "ABC";
Ожидаемый: BANC
        
public static String minWindow(String s, String t) {
    if(s == null || t == null || s.length() < t.length() ) return "";
    int need[] = new int[128];
    for(int i = 0; i<t.length(); i++){
        need[t.charAt(i)]++;
    }

    int minLen = Integer.MAX_VALUE;
    int start = 0;
    int left = 0;
    int right = 0;
    int window[] = new int[128];
    int count = 0;

    while(right<s.length()){
        window[ s.charAt(right) ] ++;
        if( window[ s.charAt(right) ] <= need[ s.charAt(right) ] ) count++;

        while(count == t.length()){
            if(right - left + 1 < minLen){
                minLen = right - left + 1;
                start = left;
            }
            window[ s.charAt(left) ]--;
            if(window[ s.charAt(left) ] < need[ s.charAt(left) ]) count--;
            left++;
        }
        right++;
    }
    return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
k1 = 3;
expected1 = {3, 3, 5, 5, 6, 7};

public int[] maxSlidingWindow(int[] nums, int k) {
    if(nums == null || k <= 0 || nums.length == 0 ) return new int[];

    Deque<Integer> deq = new ArrayDeque<>();
    int[] res = new int[nums.length - k + 1];
    for(int i = 0; i<nums.length; i++){
        while(!deq.isEmpty() && deq.peekFirst() < i - k + 1 ) deq.pollFirst();
        
        while(!deq.isEmpty() && nums[deq.peekLast()] < nums[i] ) deq.pollLast();

        deq.offerLast(i);

        if(i >= k - 1){
            res[i - k + 1] = nums[deq.peekFirst()]; // in=[12]3 k=2 res=[2]3
        }
    }
    return res;
}
В начале очереди — индекс максимума.
В конце — индексы меньших элементов, которые ещё не "вышли" из окна.
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
```
