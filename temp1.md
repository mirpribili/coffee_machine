```
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
tree
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
**Input:** root = [1,2,3,4,5,null,8,null,null,6,7,9]
          1
        /   \
       2     3
      / \     \
     4   5     8
        / \     \
       6   7     9
-------> Preorder ALR  [1,2,4, 5,6,7, 3,8,9] N, L, R
-------> inorder LAR   [4,2,6, 5,7,1, 3,8,9] L, N, R
-------> postOrder LRA [4,6,7, 5,2,9, 8,3,1] L, R, N

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
-------> Preorder ALR <------
**Binary Tree Preorder Traversal**
**Input:** root = [1,null,2,3]
**Output:** [1,2,3]
**Input:** root = [1,2,3,4,5,null,8,null,null,6,7,9]
          1
        /   \
       2     3
      / \     \
     4   5     8
        / \     \
       6   7     9
**Output:** [1,2,4,5,6,7,3,8,9]

public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public List<Integer> travelRecuciaTree(TreeNode root){
    List<Integer> res = new ArrayList<>();
    recurciaTree(root, res);
    return res;
}
private void recurciaTree(TreeNode root, List<Integer> res){
    if (root == null) return;
    res.add(root.val);
    recurciaTree(root.left, res);
    recurciaTree(root.right, res);
}

public List<Integer> iterateTravelTree(TreeNode root){
    List<Integer> res = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);
    while(!stack.isEmpty()){
        TreeNode temp = stack.pop();
        res.add(temp.val);
        if(temp.right != null) stack.push(temp.right);
        if(temp.left != null) stack.push(temp.left);
    }
    return res;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
-------> inorder LAR <------
          1
        /   \
       2     3
      / \     \
     4   5     8
        / \     \
       6   7     9
// (4, 2, 6, 5, 7, 1, 3, 8, 9);

public List<Integer> inorderTravelTree(TreeNode root){
    List<Integer> res = new ArrayList<>();
    recurciveInorder(root, res);
    return res;
}
private void recurciveInorder(TreeNode root, List<Integer> res){
    if(root == null) return;
    recurciveInorder(root.left, res);
    res.add(root.val);
    recurciveInorder(root.right, res);
}
public List<Integer> iterationTravelInorderTree(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode cur = root;

    while (cur != null || !stack.isEmpty()) {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left; //###
        }
        cur = stack.pop();
        res.add(cur.val);
        cur = cur.right;
    }
    return res;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
------->postOrder LRA <------
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Binary Tree Level Order Traversal
**Input:** root = [3,9,20,null,null,15,7]
**Output:** [3],[9,20],[15,7]

public static List<List<Integer> levelOrderTraversal(TreeNode root){
    List<List<Integer> res = new ArrayList<>();
    dfs(root, 0, res);
    return res;
}
private static void dfs(TreeNode root, int level, List<List<Integer> res){
    if (root == null) return;
    if(res.size() == level) res.add(new ArrayList<>());
    res.get(level).add(root.val);
    dfs(root.left, level + 1, res);
    dfs(root.right, level + 1, res);
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Binary Tree Right Side View
**Input:** root = [1,2,3,null,5,null,4]
**Output:** [1,3,4]
public static List<Integer> recueciveRightSideView(TreeNode root){
    List<Integer> res = new ArrayList<>();
    dfs(root, 0, res);
    return res;
}
private static void dfs(TreeNode root, int level, List<Integer> res){
    if(root == null) return;
    if(res.size() == level) res.add(root.val);
    dfs(root.right, level + 1, res); // !!!!! left first for leftView !!!!
    dfs(root.left, level + 1, res); 
}

public static List<Integer> iterativeRightSideView(TreeNode root){
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    Queue<TreeNode> que = new LinkedList<>();
    TreeNode temp = root;
    que.offer(temp);
    while (!que.isEmpty()){
        int sizeQue = que.size();
        for(int i = 0; i < sizeQue; i++){
            temp = que.poll();
            if(i == sizeQue - 1) res.add(temp.val);
            if(temp.left != null) que.offer(temp.left);
            if(temp.right != null) que.offer(temp.right);
        }
    }
    return res;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Input: root = [1,2,2,3,4,4,3]
Output: true
    1
   / \
  2   2
 / \ / \
3  4 4  3

public static boolean isSymmetric(TreeNode root){
    if(root == null) return true;
    return isMirror(root.left, root.right);
}
private static boolean isMirror(TreeNode left, TreeNode right){
    if (left == null && right == null) return true;
    if (left == null || right == null) return false;
    return (left.val == right.val)
        && isMirror(left.left, right.right)
        && isMirror(left.right, right.left);
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
**Input:** p = [1,2], q = [1,null,2]
**Output:** false
public static boolean isSame(TreeNode a, TreeNode b){
    if(a == null && b == null) return true;
    if(a == null || b == null) return false;
    return (a.val == b.val)
        && isSame(a.left, b.left)
        && isSame(a.right, b.right);
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
**Input:** root = [1,2,3], targetSum = 5
**Output:** false
public static boolean hasPathSum(TreeNode root, int target){
    if(root == null) return false;
    if(root.left == null && root.right == null) return target == root.val;
    return hasPathSum(root.left, target - root.val) || hasPathSum(root.right, target - root.val); 
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Minimum Depth of Binary Tree
**Input:** root = [3,9,20,null,null,15,7]
**Output:** 2
public static int minDepthIter(TreeNode root){
    if(root == null) return 0;
    Queue<TreeNode> que = new LinkedList<>();
    que.offer(root);
    int res = 1;
    while(!que.isEmpty()){
        int sizeLevel = que.size();
        for(int i = 0; i<sizeLevel; i++){
            TreeNode temp = que.poll();
            if(temp.left == null && temp.right == null) return res;
            if(temp.left != null) que.offer(temp.left);
            if(temp.right != null) que.offer(temp.right);
        }
        res++;
    }
    return res;
}
public static int minDepthRec(TreeNode root){
    if(root == null) return 0;
    if(root.left == null) return minDepthRec(root.right) + 1;
    if(root.right == null) return minDepthRec(root.left) + 1;
    int l = minDepthRec(root.left);
    int r = minDepthRec(root.right);
    return Math.min(l, r) +1;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Path Sum III
**Input:** 10->5->3->0->0->0 targ = 8
**Output:** 4
public static pathSum(TreeNode root, int target){
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0,1); // if val == tar
    return dfs(root, target, map, 0);
}
private static int dfs(TreeNode root, int target, HashMap<Integer, Integer> map, int sum){
    if(root == null) return 0;
    sum += root.val;
    int res = map.getOrDefault(sum - target, 0);
    map.put(sum, map.getOrDefault(sum, 0) +1 );
    res += dfs(root.left, target, map, sum);
    res += dfs(root.right, target, map, sum);
    map.put(sum, map.getOrDefault(sum, 0) -1 );
    return res;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Binary Tree Level Order Traversal II
Input: root = [3,9,20,null,null,15,7]
Output: [[15,7],[9,20],[3]]

public static List<List<Integer> levelOrderTrav(TreeNode root){
    List<List<Integer> list = new ArrayList<>();
    dfs(root, list, 0);
    Collections.reverse(list);
    return list;
}
private string void dfs(TreeNode root, List<List<Integer> list, int level){
    if(root == null) return;
    if (list.size() == level) list.add(new ArrayList<>());
    list.get(level).add(root.val);
    dfs(root.left, list, level +1);
    dfs(root.right, list, level +1);
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
массивы
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
**Input**
["NumArray", "sumRange", "sumRange", "sumRange"]
{ { {      -2, 0, 3, -5, 2, -1}}, [0, 2], [2, 5], [0, 5] }
>      0.  1.  2.  3. 4.  5.
**Output**
[null, 1, -1, -3] 1й нал это глюк вызова конструктора в литкоде

public class PrefixSumRangeQuery {
    int[] sumP;
    PrefixSumRangeQuery(int[] ar){
        this.sumP = new int[ar.length +1];
        for (int i = 0; i< ar.length; i++ ){
            sumP[i+1] = sumP[i] + ar[i];
        }
    }
    public int getSum(int left, int right){
        return sumP[right + 1 ] - sumP[left];
    }
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
[2, 3, 4, 6, 8, -5] == -1
 [1,0,1] == 1
public static int findPivotIndex(int[] nums) {
    int max = 0;
    for(int n : nums){
        max += n;
    }
    int left = 0;
    for(int i=0; i<nums.length; i++){
        if(left == max - left - num[i]) return i;
        left += num[i];
    }
    return -1;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Subarray Sum Equals K
> {3, 2, 1}. k = 3.   res = 2	Подмассивы: {3}, {2, 1}

public static int countSubarrays(int[] nums, int k) {
    int res = 0;
    int sum = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    for(int n : nums){
        sum += n;
        res += map.getOrDefault(sum - k, 0);
        map.put(sum, map.getOrDefault(sum, 0));
    }
    return res;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
1  2  3
4  5  6
7  8  9
==
0  0   0   0
0  1   3   6
0  5  12  21
0 12  27  45
==
45 = 27 + 21 + 9 - 12
sum = 45 - 12 - 6 + 1 = 28
==
public class Immutable2DRangeSum {
    int[][] psum;
    Immutable2DRangeSum(int[][] matx){
        int r = matx.length;
        int c = matx[0].length;
        this.psum = new int[r+1][c+1];
        for(int i = 1; i<=r; i++){
            for(int j = 1; j<=c; j++){
                psum[i][j] = matx[i-1][j-1] + psum[i-1][j] + psum[i][j-1] - psum[i-1][j-1];
            }
        }
    }
    public int sumRegion(int x1, int y1, int x2, int y2){
        return psum[x2+1][y2+1] + psum[x1][y1] - psum[x2+1][y1] - psum[x1][y2+1];
    }
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
public int missingNumber(int[] nums) {
    int max = nums.length;
    int res = 0;
    for (int i = 0; i<max; i++){
        res ^=nums[i];
    }
    for(int i =0; i<=max; i++){
        res ^=i;
    }
    return res;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
3 в двоичном виде: 011  
2 в двоичном виде: 010
011 XOR 010 = 001 (в двоичной) = 1 (в десятичной)

public int missingNumber(int[] nums) {
    int max = nums.length;
    int res = 0;
    for (int i = 0; i<max; i++){
        res ^=nums[i];
    }
    for(int i =0; i<=max; i++){
        res ^=i;
    }
    return res;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Input:[3 1 2 5 3] 
Output:[3, 4] 

public static int[] findRepeatAndMissing(int[] nums) {
    int rep = -1;
    int mis = -1;
    int ix = 0;
    for(int i = 0; i<nums.length; i++){
        ix = num[i] - 1; // по усл от 1 до n
        if(num[ix] > 0) num[ix] = num[ix] * -1;
        else rep = num[ix] * -1; 
    }
    for(int i = 0; i<nums.length; i++){
        if(nums[i] > 0) mis = i - 1; // index i > 0 только если егр нет в ix
    }
    return new int[]{rep, mix};
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Исходный массив: 1, 2, 3, 4, 5, 6, 7  
k = 3  
Результат: 5, 6, 7, 1, 2, 3, 4

public static void rotate(int[] nums, int k) {
    int l = nums.length;
    k = k % l; // if k>l 11%5=1
    reverse(nums, 0, l-1);
    reverse(nums, 0, k-1); //####
    reverse(nums, k, l-1);
}
private static void reverse(int[] ar, int left, int right){
    while(left<right){
        int temp = ar[right];
        ar[right] = ar[left];
        ar[left] = temp;
        left++;
        right--;
    }
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
0 0 0 0 0 1 == true
0 0 0 1 2 0 == false
public static boolean isMonotonic(int[] nums) { 
    boolean inc = true;
    boolean dec = true;

    for(int i = 1; i<nums.length; i++){
        if(num[i] > num[i-1]) inc = false;
        if(num[i] < num[i-1]) dec = false;
        if(!inc && !dec) return false;
    }
    return true;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
public int findLengthOfLCIS(int[] nums) {
    if (nums == null) return 0;
    int l = nums.length;
    if(l == 0) return 0;
    int max = 0;
    int cur = 1;
    for(int i = 1; i<l; i++){
        if(nums[i]>nums[i-1]) cur++;
        else cur = 1;
        max=Math.max(cur, max);
    }
    return max;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
aaabbv == a3b2v
public int compress(char[] chars) { 
    int write = 0;
    int read = 0;
    while(read < chars.length){
        int res = 0; // ####
        char cur = chars[read];
        while(read < chars.length && chars[read] == cur){
            res++;
            read++;
        }
        chars[write++] = cur;
        if(res>1){
            String resAr = Integer.toString(res);
            for(char c : resAr.toCharArray()){
                chars[write] = c;
                write++;
            }
        }
    }
    return write;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
1, 1, 2, 3, 5, 8, 13, 21
public static int fibonacci(int n) { 
    if(n==0 || n==1) return 1;
    int cur = 1;
    int prev = 1;
    for(int i = 2; i<=n; i++){
        int temp = cur + prev;
        prev = cur;
        cur = temp;
    }
    return cur;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Contains Duplicate
public static boolean hasDublicate(int[] ar){
    if(ar == null || ar.length < 2) return false;
    HashSet<Integer> set = new HashSet<>();
    for(int a : ar){
        if(set.contains(a)) return true;
        set.add(a);
    }
    return false;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Consecutive Characters
`"aaabbcc"` ответ будет 3
public static int maxPower(String s) {  
    if(s == null || s.isEmpty()) return 0;
    int max = 0;
    int l = 1; // #####
    for(int i = 1; i<s.length(); i++){
        if(s.charAt(i) == s.charAt(i-1)) l++;
        else l = 1;
        max = Math.max(max, l);
    }
    return max;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Maximum Product of Two Elements in an Array
5, 4, 3 == (5-1)*(4-1)
public static int maxProduct(int[] nums) {  
    int max1 = Integer.MIN_VALUE;  
    int max2 = Integer.MIN_VALUE;
    for(int n : nums){
        if(n > max1){
            max2 = max1;
            max1 = n;
        }
        if(n > max1) max1 = n;
    }

    return (max1-1)*(max2-1);
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Find the Highest Altitude
Если изменения высоты:[-5, 1, 5, 0, -7], то высоты по шагам будут:  
0 (начальная), 0-5 = -5, -5+1 = -4, -4+5 = 1, 1+0 = 1, 1-7 = -6.  

public static int findHighestAltitude(int[] gain) {
    int res = 0;
    int max = 0;
    for(int g : gain){
        res += g;
        if(res > max) max = res;
    }
    return max;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Matrix Block Sum
public int[][] matrixBlockSum(int[][] mat, int k) {
    int r = mat.length;
    int c = mat[0].length;

    int[][] psum = new int[r+1][c+1];
    for(int i = 1; i <=r; i++){
        for(int j = 1; j <=c; j++){
            psum[i][j] = mat[i-1][j-1] + psum[i][j-1] + psum[i-1][j] - psum[i-1][j-1];
        }   
    }
    int[][] res = new int[r][c];
    for(int i = 0; i <r; i++){
        for(int j = 0; j <c; j++){
            int r1 = Math.max(i, i -k);
            int c1 = Math.max(j, j -k);
            int r2 = Math.min(r - 1, i +k);
            int c2 = Math.min(c - 1, j +k);

            res[i][j] = psum[r2 +1][c2 +1] + psum[r1][c1] 
                - psum[r1][c2+1] - psum[r2+1][c1];
        }   
    }
    return res;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Number of Submatrices That Sum to Target
[1, 1]
[1, 1]
t=1 res =4

public static int numSubmatrixSumTarget(int[][] ar, int target) {
    if(ar == null) return 0;
    int row = ar.length;
    int col = ar[0].length;
    int res = 0;

    for(int i = 0; i<row; i++){
        int[] resAr = new int[col];
        for(int j=i; j<row; j++){
            for(int k = 0; k<col; k++){
                resAr[k] += ar[j][k];
            }//только 1 строку сформирует
            res += sumSubArr(resAr, target); // ####
        }
    }
    return res;
}
private static int sumSubArr(int[] ar, int t){
    if(ar == null) return 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    int sum = 0;
    int res = 0;
    map.put(0, 1);
    for(int i=0; i<ar.length; i++){
        sum += ar[i];
        res += map.getOrDefault(sum-t, 0);
        map.put(sum,map.getOrDefault(sum, 0)+1);
    }
    return res;
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

```
