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

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
```
