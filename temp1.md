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

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

```
