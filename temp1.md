```
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
tree
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
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

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

```
