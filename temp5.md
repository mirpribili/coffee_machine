```
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
