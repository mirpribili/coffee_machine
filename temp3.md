```
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
стек 2
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
 1475. Final Prices With a Special Discount in a Shop
prices1 = {8, 4, 6, 2, 3};
expected1 = {4, 2, 4, 2, 3};
public int[] finalPrices(int[] prices) {
    int l = prices.length;
    Stack<Integer> stack = new Stack<>();
    int idx = 0;
    int[] res = Array.copyOf(prices);

    for(int i = 0; i < l; i++){
        while(!stack.isEmpty() && prices[i] <= prices[stack.peek()]){
            idx = stack.pop();
            res[idx] = prices[i] - prices[idx];
        }
        stack.push(i);
    }
    return res;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
151. Reverse Words in a String
Ввод" hello world "
Вывод:"world hello"
public static String reverseWords(String s) {
    Stack<String> stack = new Stack<>();
    for (String s : s.trim().split("\\s+")){ // ####
        stack.push(s);
    }
    StringBuilder res = new StringBuilder();
    while(!stack.isEmpty()){
        res.append(stack.pop());
        if(!stack.isEmpty()){
            res.append(' ');
        }
    }
    return res.toString(); // ####
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
907. Sum of Subarray Minimums
int[] arr1 = {3, 1, 2, 4};
int expected1 = 17; 
[3]      -> 3
[3,1]    -> 1
[3,1,2]  -> 1
[3,1,2,4]-> 1
[1]      -> 1
[1,2]    -> 1
[1,2,4]  -> 1
[2]      -> 2
[2,4]    -> 2
[4]      -> 4

int[] arr3 = {1, 1, 1, 1};
int expected3 = 10;

public int sumSubarrayMins(int[] arr) {
    int mod = (int)1e9 + 7;
    long sum = 0;
    long res = 0;
    Deque<int[]> stack = new ArrayDeque<>();
    for(int a : arr){
        int count = 1;
        while(!stack.isEmpty() && stack.peek()[0] => a){
            int[] top = stack.pop();
            sum -= top[0] * top[1];
            count += top[1];
        }
        stack.push(new int[]{a, count}); // #####
        sum += (long) a * count;
        sum %= mod;
        res += sum;
        res %= mod;
    }
    return (int) res;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
"10 + (7 - 2*3)*(12-4)/2", // 14
public static int calculate(String s) {
    return evaluate(s.replaceAll(" ", ""), 0)[0];    //####
}
private static int[] evaluate(String s, int i){
    Deque<Integer> stack = new ArrayDeque<>();
    int num = 0;
    char op = '+';
    while(i<s.length()){
        char c = s.charAt(i);
        if(Character.isDigit(c)){
            num = num * 10 + (c - '0');
            //Integer.patseInt();
        }
        if(c == '('){
            int[] temp = evaluate(s, i + 1);
            num = temp[0];
            i = temp[1];
        }
        if(!Character.isDigit(c) || i == s.length() - 1){
            switch(op){
                case '+': stack.push(num); break;
                case '-': stack.push(-num); break;
                case '*': stack.push(stack.pop() * num); break;
                case '/': stack.push(stack.pop() / num); break;
            }
            if(c == ')') return new int[]{stack.stream().mapToInt(x->x).sum(), i};
            op = c;
            num = 0;
        }
        i++;
    }
    return new int[]{stack.stream().mapToInt(x->x).sum(), i};
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
куча
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
heap
parrent = (i - 1) /2 
child   = i * 2 + 1
child   = i * 2 + 2

public class MinHeap {
    private List<Integer> heap;
    MinHeap(){
        this.heap = new ArrayList<>();
    }
    public void insert(int val){
        heap.add(val);
        heapifyUp(heap.size() - 1);
    }
    private void heapifyUp(int i){
        while(i > 0){
            int parentId = (i - 1) / 2;
            if(heap.get(i) => heap.get(parentId)) break;
            Collections.swap(heap, i, parentId);
        }
    }
    public int extractMin(){
        if(heap.isEmpty()) throw new IllegalStateException("Heap is empty");
        int min = heap.get(0);
        heap.set(0, heap.get( heap.size() - 1 ));
        heap.remove( heap.size() - 1 );
        if(!heap.isEmpty()) heapifyDown(0);
        return min;
    }
    public int getMin(){
        if(heap.isEmpty()) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }
    private void heapifyDown(int i){
        int size = heap.size();
        while(true){
            int left = (i * 2) + 1;
            int right = (i * 2) + 2;
            int small = i;
            if(left < size && heap.get(left) < heap.get(i)) small = left;
            if(right < size && heap.get(rigt) < heap.get(i)) small = right;
            if(small == i) break;
            Collections.swap(heap, i, small);
            i = small;
    }
    public void buildHeap(List<Integer> list){
        heap = new ArrayList<>(list);
        for(int i = heap.size()/2 - 1; i >= 0; i--){
            heapifyUp(i);
        }
    }
}
| Метод         | Время    | Память |
| ------------- | -------- | ------ |
| *Вставка**    | O(log n) | O(1)   |
| *Извлечение** | O(log n) | O(1)   |
| *Поиск min**  | O(1)     | O(1)   |
| *Построение** | O(n)     | O(n)   | потому что половина листьев не обрабат
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Kth Largest Element in an Array
int[] arr1 = {3, 2, 1, 5, 6, 4};
int k1 = 2;
int expected1 = 5;
public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> heapMin = new PriorityQueue<>(); // Collections.reverseOrder();
    for(int i : nums){
        heapMin.offer(i);
        if(heap.size() > k) heap.poll();
    }
    return heap.peek();
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Top K Frequent Heap
int[] nums1 = {1, 1, 1, 2, 2, 3};
int k1 = 2;
int[] expected1 = {1, 2};
public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : nums){
        map.put(i, map.getOrDefault(i, 0) +1 );
    }
    PriorityQueue<Map.Entry<Integer, Integer>> heapMin = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
    //new PriorityQueue<>(    (a, b) -> Integer.compare(a.getValue(), b.getValue())    );
    for(Map.Entry<Integer, Integer> ent : map.entrySet()){
        heapMin.offer(ent);
        if(heapMin.size() > k){
            heapMin.poll();
        }
    }
    int[] res = new int[k];
    for(int i = k - 1; i>=0; i--){ // если макс хип то не выйграем по вр O(N log k) по пам О(n)
        res[i] = heapMin.poll().getKey();
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


```
