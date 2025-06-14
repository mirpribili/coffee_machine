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

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

```
