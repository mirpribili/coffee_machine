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
912. Sort an Array (Сортировка массива):
через Counting Sort 
public static void countingSort(int[] arr) {
    if(arr.length == 0) return;

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for(int i: arr){
        min = Math.min(min, i);
        max = Math.max(max, i);
    }
    int[] count = new int[max - min + 1];
    int[] res = new int[arr.length];

    for(int i : arr){
        count[i - min]++;
    }
    for(int i =1; i<count.length; i++){ 
    // накоп подсчет теперь в count[i] кол во эл <= i
    // напр для 1224 частоты == 1201 и накоп == 1334
        сount[i] += count[i-1];
    }
    // стабильная сортировка
    for(int i = arr.length -1; i>=0; i--){
        res[ count[ arr[i] - min ] - 1 ] = arr[i];
        count[ arr[i] - min ] --;
    }
    System.arraycopy(output, 0, arr, 0, arr.length);
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
912. Sort an Array (Сортировка массива):
через Counting Sort 
public static void countingSort(int[] arr) {
    if(arr.length == 0) return;

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for(int i: arr){
        min = Math.min(min, i);
        max = Math.max(max, i);
    }
    int[] count = new int[max - min + 1];
    int[] res = new int[arr.length];

    for(int i : arr){
        count[i - min]++;
    }
    for(int i =1; i<count.length; i++){ 
    // накоп подсчет теперь в count[i] кол во эл <= i
    // напр для 1224 частоты == 1201 и накоп == 1334
        сount[i] += count[i-1];
    }
    // стабильная сортировка
    for(int i = arr.length -1; i>=0; i--){
        res[ count[ arr[i] - min ] - 1 ] = arr[i];
        count[ arr[i] - min ] --;
    }
    System.arraycopy(res, 0, arr, 0, arr.length);
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
> int[] nums1 = {1, 1, 1, 2, 2, 3}; 
> int k1 = 2; 
> int[] expected1 = {1, 2};

public static int[] topKFrequent(int[] nums, int k) {
    if (nums == null) return new int[0];
    Map<Integer, Integer> map = new HashMap<>();
    for(int n : nums){
        map.put(n, map.getOrDefault(n, 0)+1);
    }
    List<Integer>[] bukets = new List[nums.length+1]; // из-за freq>1 всегда
    for (int i = 0; i<bukets.length; i++){
        bukets[i] = new ArrayList<>();
    }
    for(int num : map.keySet()){
        int freq = map.get(num);
        bukets[freq].add(num); // ####
    }
    List<Integer> preRes = new ArrayList<>();
    for (int i = bukets.length-1; i>=0; i--){
        if(preRes.size() == k) break;
        preRes.addAll(bukets[i]);
    }

    int[] res = new int[k];
    for(int i = 0; i<k; i++){
        res[i] = preRes.get(i);
    }
    return res;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
test("Aabb", "bbAa");
public static String frequencySort(String s) {  
    // Считаем частоты символов  
    Map<Character, Integer> freqMap = new HashMap<>();  
    for (char c : s.toCharArray()) {  
        freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);  
    }  
    // Максимальная частота для создания buckets  
    int maxFreq = Collections.max(freqMap.values());  
    // buckets: индекс - частота, значение - список символов с такой частотой  
    List<List<Character>> buckets = new ArrayList<>(maxFreq + 1);  
    for (int i = 0; i <= maxFreq; i++) {  
        buckets.add(new ArrayList<>());  
    }  
  
    // Заполняем buckets  
    for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {  
        buckets.get(entry.getValue()).add(entry.getKey());  
    }  
  
    // Формируем результат  
    StringBuilder sb = new StringBuilder();  
    for (int freq = maxFreq; freq > 0; freq--) {  
        for (char c : buckets.get(freq)) {  
            for (int i = 0; i < freq; i++) {  
                sb.append(c);  
            }  
        }  
    }  
    return sb.toString();  
}

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
citations1{3,  0,  6,  1,  5}; size=5
Индексы:   0   1   2   3   4   5
Значения: [1,  1,  0,  1,  0,  2]
res 3
public int hIndex(int[] citations) {
    int h = citations.length;
    int[] count = new int[h + 1];
    for(int i : citations){
        if(i >= h){
            count[h]++;
        } else {
            count[i]++;
        }
    }
    int total = 0;
    for(int i = h; i>=0; i--){
        total += count[i];
        if (total >= h) return i;
    }
    return 0;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Array Partition
nums = [1][1][1][4][3][2]
оптимальное разбиение (1,1), (1,2), (3,4), 
где сумма минимумов равна 1+ 1 + 3 = 5
public int arrayPairSum(int[] nums) {
    int[] count = new int[20_001]; // -10^4, 10^4
    for(int i : nums){
        count[i + 10_000] ++;
    }
    int res = 0;
    boolean notOdd = true; // even
    for(int i = 0; i<count.length; i++){
        while(count[i] > 0){
            if(notOdd){
                res += i - 10_000; // ######!!!!
                notOdd = false;
            }else{
                notOdd = true;
            }
            count[i]--; // ######
        }
    }
    return res;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Input nums1: [4, 9, 5]
Input nums2: [9, 4, 9, 8, 4]
Expected: [4, 9] или [9, 4]
public static int[] intersect(int[] nums1, int[] nums2) {  
    int[] count = new int[1001]; // диапазон элементов от 0 до 1000
    for(int i : nums1){
        count[i]++;
    }
    int idx = 0;
    int[] preRes = new int[Math.min(nums1.length, nums2.length)];
    for(int i : nums2){
        if(count[i] > 0){
            preRes[idx] = i;
            idx++;
            count[i] --;
        }
    }
    int[] res = new int[idx];
    System.arraycopy(preRes, 0, res, 0, idx);
    return res;

    первый аргумент должен быть источником, 
    второй — началом копирования, 
    третий — приемником, 
    четвертый — с какого индекса приемника, 
    пятый — количество элементов
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
анаграммы и , Простые числа и Матеша
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
{"anagram", "nagaram"}, // true
public static boolean isAnagram(String s, String t) {  
    if(s.length() != t.length())return false;
    int[] count = new int[26]; // 26 engl simbols in alphabet
    for(char c : s.toCharArray()){
        count[c-'a']++;
    }
    for(char c : t.toCharArray()){
        if(count[c-'a'] <= 0) return false;
        else count[c-'a']--;
    }
    return true;
}
public static boolean isAnagram(String s, String t) {
    Map<Character, Integer> map = new HashMap<>();
    if(s.length() != t.length())return false;
    for(char c : s.toCharArray()){
        map.put(c, map.getOrDefault(c, 0) + 1);
    }
    for(char c : t.toCharArray()){
        if(!map.containsKey(c) || map.get(c) == 0) return false;
        else map.put(c, map.get(c) - 1);
    }
    return true;
}

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
49. Group Anagrams
Input: ["eat","tea","tan","ate","nat","bat"] 
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>(); // ####
    for(String s : strs){
        //char[] c = s.toCharArray();
        //Arrays.sort(c);
        //String key = new String(c); /// ####

        /// var 2_
        int[] count = new int[26]; // eng alphabet
        for(char c : s.toCharArray()){
            count[ c - 'a' ]++;
        }
        StringBuilder preKey = new StringBuilder();
        for(int i = 0; i<26; i++){
            preKey.append(count[i]).append('_');
        }
        String key = preKey.toString();
        /// var 2^

        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(s);
    }
    return new ArrayList<>(map.values());
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Изначально:  2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
Шаг 1 (кратные 2): 2 3 x 5 x 7 x 9 x 11 x 13 x 15 x 17 x 19 x
Шаг 2 (кратные 3): 2 3 x 5 x 7 x x x 11 x 13 x x x 17 x 19 x
Шаг 3 (кратные 5): 2 3 x 5 x 7 x x x 11 x 13 x x x 17 x 19 x
Шаг 4 (кратные 7): 2 3 x 5 x 7 x x x 11 x 13 x x x 17 x 19 x
Простые: 2 3 5 7 11 13 17 19

public int countOrGetPrimes(int n) {
    if(n <= 2) return 0;
    boolean[] res = new boolean[n];
    for(int i = 2; i<n; i++){
        res[i] = true;
    }
    for(int i = 2; i * i<n; i++){
        for(int j = i * i; j < n; j += i ){ // при i = 0 бес цикл
            res[j] = false;
        }
    }
    int count = 0;
    for(int i = 2; i<n; i++){
        if(res[i]) count++;
    }
    return count;

    int[] resalt = new int[count];
    int idx = 0;
    for(int i = 0; i<n; i++){
        if(res[i]){
            result[idx++] = i;
        }
    }
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
//__int Max _2_147_483_647
//__int Min -2_147_483_648
testReverse(1_563_847_412, 0);
testReverse(120, 21); 
testReverse(0, 0); 
public static int reverse(int x) {
    int res = 0;
    while(x != 0){
        int digit = x % 10;
        x = x / 10;
        if(res > Integer.MAX_VALUE /10 || 
            (res == Integer.MAX_VALUE/10 && digit > 7)
            ) return 0;
        if(res < Integer.MIN_VALUE /10 || 
            (res == Integer.MIN_VALUE/10 && digit < -8)
            ) return 0;
        res = res * 10 + digit;
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


```
