```
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
linked list
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
1->2->3->4 t=3
1->2->4
O(L) O(1)

poblic static class Node{
    int var;
    Node next;
    Node(int v){
        this.var = v;
        this.next = null;
    }
}

public static Node removeNthFromEnd(Node head, int n){
    Node dummy = new Node(0);
    dummy.next = head;
    Node slow = dummy;
    Node fast = dummy;
    for (int i = 0; i < n; i++){
        fast = fast.next;
    }
    while(fast.next != null){
        fast = fast.next;
        slow = slow.next;
    }
    slow.next = slow.next.next;
    return dummy.next;
}

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
static class Node{
    int v;
    Node next;
    Node(int v){
        this.v = v;
        this.next = null;
    }
}
public static Node reverseList(Node head){
    Node cur = head;
    Node prev = null;
    while(cur != null){
        Node temp = cur.next;
        cur.next = prev;
        prev = cur;
        cur = temp;
    }
    return prev;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
1->2
res  2 !

static class Node{
    int v;
    Node next;
    Node(int v){
        this.v = v;
        this.next = null;
    }
}
public static Node middleOfList(Node head){
    Node fast = head;
    Node slow = head;
    while(fast != null && fast.next != null){
        fast = fast.next.next;
        slow = slow.next;
    }
    return slow;
}

// Вспомогательный метод для создания списка из массива
{1, 2, 2, 1}
private static Node createList(int[] arr) {
    if (arr.length == 0) return null;
    Node head = new Node(arr[0]);
    Node current = head;
    for (int i = 1; i < arr.length; i++) {
        current.next = new Node(arr[i]);
        current = current.next;
    }
    return head;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
{1, 2, 2, 1},    true
{1, 2, 3, 2, 1}, true

public static boolean isListPalindrome(Node head){
    boolean res = true;
    if(head == null || head.next == null) return true; // #####

    Node fast = head;
    Node slow = head;
    Node beforeSlow = null;

    while(fast != null && fast.next != null){
        fast = fast.next.next;
        beforeSlow = slow;
        slow = slow.next;
    }

    Node reversHalf = reverseList(slow);
    Node firstHalf = head;
    Node copy = reversHalf;

    while(reversHalf != null){ // или  firstHalf != null
        if(reversHalf.val != firstHalf.val){
            res = false;
            break;
        }
        reversHalf = reversHalf.next;
        firstHalf  = firstHalf.next;
    }
    // #####
    if(beforeSlow != null) beforeSlow.next = reverseList(copy); // repair
    return res;
}
public static Node reverseList(Node head){
    Node cur = head;
    Node prev = null;
    while(cur != null){
        Node temp = cur.next;
        cur.next = prev;
        prev = cur;
        cur = temp;
    }
    return prev;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
createList(new int[]{1, 2, 3, 4, 5});
Ожидаемый: 1->5->2->4->3

public static void reorderList(Node head){
    if(head == null || head.next == null) return;

    Node fast = head;
    Node slow = head;
    while(fast.next != null && fast.next.next != null){
        fast = fast.next.next;
        slow = slow.next;
    }

    Node first/*Half*/ = head;
    Node second = reverseList(slow.next);
    slow.next = null;

    while(second != null){
        Node temp1 = first.next;
        Node temp2 = second.next;

        first.next = second;
        second.next = temp1;
        second = temp2;
        first = temp1;
    }
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
 1 -> 2 -> 4
 1 -> 3 -> 4 
 1 -> 1 -> 2 -> 3 -> 4 -> 4

public static Node mergeLists(Node l1, Node l2){
    Node head = new Node(0); // #####
    Node cur = head;
    while(l1 != null && l2 != null){
        if(l1.val < l2.val){
            cur.next = l1;
            l1 = l1.next;
        } else {
            cur.next = l2;
            l2 = l2.next;
        }
        cur = cur.next;
    }
    cur.next = (l1 != null) ? l1 : l2;
    return head.next;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
public static Node mergeKLists(Node[] list){
    if(list == null || list.length == 0) return null;
    while(list.length > 1){
        List<Node> temp = new ArrayList<>();
        for( int i = 0; i<list.length; i +=2){
            Node l1 = list[i];
            Node l2 = (i + 1) < list.length ? list[i+1] : null;
            temp.add(mergeLists(l1, l2));
        }
        list = temp.toArray(new Node[0]); // *
    }
    return list[0];
}

List<Node> temp = new ArrayList<>();
temp.add(nodeA);
temp.add(nodeB);
Node[] array = temp.toArray(new Node[0]);
// array теперь содержит {nodeA, nodeB}

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Список A: 1 → 2 → 9
Список B: 3 → 9
res 9

Список A: 1 → 3 
Список B: 2 → 4
res null

public static Node intersection(Node a, Node b){
    Node p1 = a;
    Node p2 = b;
    while (p1 != p2){
        p1 = (p1 == null) ? b : p1.next;
        p2 = (p2 == null) ? a : p2.next;
    }
    return p2;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
public static boolean hasCycle(Node head){
    if (head == null) return false;
    Node fast = head;
    Node slow = head;
    while (fast != null && fast.next != null){
        fast = fast.next.next;
        slow = slow.next;
        if(fast == slow) return true;
    }
    return false;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
public static Node finderCycle(Node head){
    if(head == null) return null;
    Node fast = head;
    Node slow = head;
    while(fast != null && fast.next != null){
        fast = fast.next.next;
        slow = slow.next;
        if(fast == slow){
            fast = head;
            while(fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
    }
    return null;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Input: head = [2,1,5]
Output: [5,5,0]

inp {1, 7, 5, 1, 9, 2, 5, 1}
res {7, 9, 9, 9, 0, 5, 0, 0}

public static int[] greatNode(Node head){
    List<Integer> val = new ArrayList<>();
    while(head != null){
        val.add(head.val);
        head = head.next;
    }
    int max = val.size();
    int[] res = new int[max];
    Deque<Integer> stack = new ArrayDeque<>();
    for(int i = 0; i < max; i++){
        while(!stack.isEmpty() && val.get(i) > val.get(stack.peek())){
            res[stack.pop()] = val.get(i);
        }
        stack.push(i);
    }
    return res;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Двоичный поиск

Цикл завершается, когда интервал сжат до одного элемента (left == right). Нет смысла выполнять лишнюю итерацию, чтобы проверить один и тот же индекс.

Нужно проверить все возможные кандидаты, включая ситуацию, когда left == right — последний элемент интервала.
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
int[] array = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
int target1 = 23;
int expected1 = 5;
public static int binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length -1;
    while(left<=right){
        int mid = left + (right - left) /2;
        if(arr[mid] == target) return mid;
        if(arr[mid] > target) right = mid - 1;
        else left = mid + 1;
    }
    return -1;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
int[] test1 = {0, 2, 4, 6, 5, 3, 1};  
int expected1 = 3;
public static int peakIndexInMountainArray(int[] arr) {  
    int left = 0;  
    int right = arr.length - 1;
    while(left<right){
        int mid = (right + left) >>> 1;
        if(arr[mid] > arr[mid + 1]) right = mid;
        else left = mid + 1;
    }
    return left;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Search in Rotated Sorted Array
{6, 7, 8, 1,  2, 3, 4, 5}, size 8
targets 3
res 5
public static int search(int[] arr, int target) { 
    int left = 0, right = arr.size - 1;
    while(left <= right){
        int mid = (right + left) >>> 1;
        if(arr[mid] == target) return mid;
        if(arr[left] <= arr[mid]){
            if(arr[left] <= target && target < arr[mid]) right = mid - 1;
            else left = mid + 1;
        } else {
            if(arr[mid] < target && target <= arr[right]) left = mid + 1;
            else right = mid - 1;
        }
    }
    return -1;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Search a 2D Matrix
{1, 3, 5, 7},
{10, 11, 16, 20},
{23, 30, 34, 50}
int target1 = 11;
public boolean searchMatrix(int[][] matrix, int target) {  
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0 ) return false;

    int col = matrix[0].length;
    int row = matrix.length;
    int left = 0;
    int right = col * row -1;

    while(left<=right){
        int mid = (right + left) >>> 1;
        int res = matrix[mid / col][mid % col]; // ####
        if (res == target) return true;
        if(target > res) left = mid + 1;
        else right = mid - 1;
    }
    return false;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Sqrt(x)
x = 4 ->2 (2² = 4 ≤ 4)
x = 8 ->2 (2² = 4 ≤ 8, 3² = 9 > 8)

public int mySqrt(int x) {
    if(x == 0 || x == 1) return x;
    long left = 0;
    long right = x / 2;
    while(left <= right){
        long mid = (right - left)/2 + left;
        long sqr = mid * mid;
        if(sqr == x) retirn mid;

        if(sqr > x) right = mid - 1;
        else left = mid + 1;
    }
    return (int) right; ///####### l = 1e привышающее а r послед не превыш квадр х
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Find First and Last Position of Element in Sorted Array
test(new int[]{5, 7, 7,  8, 8, 10}, >>>8<<<, res{3, 4}); size 6

public static int[] findFirstAndLastPosition(int[] nums, int target) {
    int first = findFirstOrLastPosition(nums, target, true);
    if(first == -1) return new int[]{-1, -1};
    int second = findFirstOrLastPosition(nums, target, false);
    return new int[]{first, second};
}
private static findFirstOrLastPosition(int[] ar, int t, boolean leftElseRight){
    int left = 0;
    int right = ar.length -1;
    int res = -1;
    while(left <= right){
        int mid = left + (right-left) >>> 1;
        if(ar[mid] == t){
            res = mid;
            if(leftElseRight){
                right = mid -1;
            } else {
                left = mid + 1;
            }
        } else if(ar[mid] < t){ // else if ######
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return res;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Find K Closest Elements
{1, 3, 5, 7, 9}
k = 3
x = 6
res (3, 5, 7)
public static List<Integer> findKClosestElements(int[] arr, int k, int x) {
    int left = 0;
    int right = arr.length - k;
    while(left < right){ //#######
        int mid = left + (- left + right) /2;
        if (x - arr[mid] > arr[mid + k] - x ) left = mid + 1;
        else right = mid; //######
    }
    List<Integer> res = new ArrayList<>();
    for (int i = left; i<left+k; i++){
        res.add(arr[i]);
    }
    return res;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Valid Perfect Square
num = 16 → true (4 * 4 = 16), num = 14 → false
public boolean isPerfectSquare(int num) {
    if(num < 0) return false;
    int left = 0;
    int right = num;
    while(left <= right){
        long mid = left + (right - left) >>> 1;
        long sqr = mid * mid;
        if(sqr == num) return true;
        if(sqr > num) right = mid - 1;
        elsr left = mid + 1;
    }
    return false;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Find Minimum in Rotated Sorted Array
Массив: {4,5,6,7,0,1,2} 
res = 4

public static int findMin(int[] nums) {
    int left = 0; right = nums.length - 1;
    while(left < right){
        int mid = left + (right - left)/2;
        if(nums[mid] > nums[right]) left = num + 1;
        else right = mid;
    }
    return nums[left];
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Search in Rotated Sorted Array II
public static boolean search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while(left <= right){
        int mid = left + (right - left) /2;
        if(nums[mid] == target) return true;

        // если не понять какая половина где
        if(nums[left] == nums[mid] && nums[mid] == nums[right]){
            left++;
            right--;
        } else

         if(nums[left] <= nums[mid]){
            if(nums[left] < target && target <= nums[mid]){
                left = mid + 1;
            } else {
                right = mid;
            }
        } else if(nums[mid] <= nums[right]){
            if(nums[mid] < target && target <= nums[right]){
                left = mid + 1;
            } else{
                right = mid;
            }
        }
    }
    return false;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
stack
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Valid Parentheses
"()[]{}{}",// true
"(]",      // false
public boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for(char c : s.toCharArray()){
        if(c == '(') stack.push(')');
        else if(c == '[') stack.push(']');
        else if(c == '{') stack.push('}');
        else if(stack.isEmpty() || stack.pop() != c) return false;
    }
    return stack.isEmpty();
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Balanced Parantheses!
 "(()(()()))" — сбалансирована
- ")(“ — не сбалансирована
public static boolean isBalanced(String s) {
    Stack<Character> stack = new Stack<>();
    for(char c : s.toCharArray()){
        if (c == '(' || c == '[' || c == '{') stack.push(c);
        else if (stack.isEmpty() || !isMirrorBrackets(stack.pop(), c)) return false;
    }
    return stack.isEmpty(); // ##########
}
private static boolean isMirrorBrackets(char a, char b){
    if( (a == '(' && b == ')') ||
        (a == '[' && b == ']') ||
        (a == '{' && b == '}') ) return true;
    rerurn false;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
1249. Minimum Remove to Make Valid Parentheses
"lee(t(c)o)de)",
"lee(t(c)o)de",
public static String minRemoveToMakeValid(String s) {
    StringBuilder sb = new StringBuilder(s);
    Stack<Integer> stack = new Stack<>();
    for(int i = 0; i<sb.length(); i++){
        char c = sb.charAt(i);
        if(c == '(') stack.push(i);
        else if(c == ')'){
            if( !stack.isEmpty() ) stack.pop();
            else sb.setCharAt(i, '*');
        }
    }
    while(!stack.isEmpty()) sb.setCharAt(staсk.pop(), '*');

    StringBuilder res = new StringBuilder();
    for(int i = 0; i<sb.length(); i++){
        char c = sb.charAt(i);
        if(c != '*')res.append(c);
    }
    return res.toString();
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
739. Daily Temperatures
temperatures = {73, 74, 75, 71, 69, 72, 76, 73}  
Результат: {1, 1, 4, 2, 1, 1, 0, 0}
public int[] dailyTemperatures(int[] temperatures) {
    int[] res = new int[temperatures.length];
    Stack<Integer> stack = new Stack<>();
    for(int i = 0; i<temperatures.length; i++){
        while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
            int prev = stack.pop();
            res[prev] = i - prev;
        }
        stack.push(i);
    }
    return res;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
public static void quickSort(int[] array, int low, int high) {  
    if (array == null || low >= high || array.length == 0) {  
        return;  
    }  
    int middle = low + (high - low) / 2;  
    int pivot = array[middle];  
    int i = low;  
    int j = high;  
    while (i <= j) {  
        while (array[i] < pivot) {i++;}  
        while (array[j] > pivot) {j--;}  
        if (i <= j) {  
            int temp = array[i];  
            array[i] = array[j];  
            array[j] = temp;  
            i++;  
            j--;  
        }  
    }  
    if (low < j) {  
        quickSort(array, low, j);  
    }  
    if (i < high) {  
        quickSort(array, i, high);  
    }  
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
public static void bubbleSort(int[] arr) {
    int n = arr.length - 1;
    for (int i = 0; i < n; i++){
        boolean swap = false;
        for(int j = 0; j < n - i - 1; j++){
            if(arr[j] > arr[j+1]){
                swap = true;
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1 ] = temp;
            }
        }
        if (!swap) break;
    }
 }
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

```
