```
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
2 указателя
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
public static int[] mergeTwoSorted(int[] a, int[] b) {
    int[] c = new int[a.length + b.length];
    int l = 0, r = 0, resI = 0;
    // Пока любой массив не закончился
    while (l < a.length && r < b.length) {
        if (a[l] < b[r]) {
            c[resI++] = a[l++];
        } else {
            c[resI++] = b[r++];
        }
    }
    // Копируем оставшиеся элементы из a (если есть)
    while (l < a.length) {
        c[resI++] = a[l++];
    }
    // Копируем оставшиеся элементы из b (если есть)
    while (r < b.length) {
        c[resI++] = b[r++];
    }
    return c;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
O(n)  O(n)
Вставка и поиск в hashMap — амортизированное O(1)

public static int[] twoSumMap(int[] nums, int target) {  
        Map<Integer, Integer> map = new HashMap<>();  
  
        for (int i = 0; i < nums.length; i++) {  
            int complement = target - nums[i];  
            if (map.containsKey(complement)) {  
                return new int[] { map.get(complement), i };  
            }  
            map.put(nums[i], i);  
        }  
        throw new IllegalArgumentException("No two sum solution");  
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
O(n log n) (из-за сортировки)	O(n)

public static int[] twoSum(int[] nums, int target) {  
    // Создаем массив пар: [значение, исходный индекс]  
    int[][] numsWithIndex = new int[nums.length][2];  
    for (int i = 0; i < nums.length; i++) {  
        numsWithIndex[i][0] = nums[i];  
        numsWithIndex[i][1] = i;  
    }  
  
    // Сортируем по значению  
    Arrays.sort(numsWithIndex, Comparator.comparingInt(a -> a[0]));  
  
    int left = 0;  
    int right = nums.length - 1;  
  
    while (left < right) {  
        int sum = numsWithIndex[left][0] + numsWithIndex[right][0];  
        if (sum == target) {  
            // Возвращаем исходные индексы  
            return new int[]{numsWithIndex[left][1], numsWithIndex[right][1]};  
        } else if (sum < target) {  
            left++;  
        } else {  
            right--;  
        }  
    }  
  
    // Если решения нет (по условию задачи не должно быть)  
    return new int[]{-1, -1};  
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
public static int closestSum(int[] nums, int target) { 
	Arrays.sort(nums); 
	int left = 0; 
	int right = nums.length - 1; 
	int result = -1; 
	while (left < right) { 
		int sum = nums[left] + nums[right]; 
		if (sum < target) { 
			if (sum > result) { 
				result = sum; 
			} left++; 
		} else {
		 right--; 
		} 
	} return result;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
public class SortedSquares {

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int pos = n - 1; // Заполняем результат с конца

        while (left <= right) { // <= чтобы попасть в 0
            int leftVal = nums[left];
            int rightVal = nums[right];

            if (Math.abs(leftVal) > Math.abs(rightVal)) {
                result[pos] = leftVal * leftVal;
                left++;
            } else {
                result[pos] = rightVal * rightVal;
                right--;
            }
            pos--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-7, -3, 2, 3, 11};
        int[] squares = sortedSquares(nums);
        System.out.println(java.util.Arrays.toString(squares)); // [4, 9, 9, 49, 121]
    }
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
public void moveZerosToEnd(int[] nums) {
    int insertPos = 0; // позиция для вставки ненулевого элемента
    for (int num : nums) {
        if (num != 0) {
            nums[insertPos++] = num;
        }
    }
    // Заполняем оставшиеся позиции нулями
    while (insertPos < nums.length) {
        nums[insertPos++] = 0;
    }
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
public boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;

    while (left < right) {
        // Пропускаем неалфавитно-цифровые символы слева
        while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
            left++;
        }
        // Пропускаем неалфавитно-цифровые символы справа
        while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
            right--;
        }
        // Сравниваем символы без учёта регистра
        if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}
//Такой подход эффективен, не требует дополнительной памяти под новую строку и работает за время O(n), где n — длина строки.

// Проверка, является ли символ буквой или цифрой
private boolean isAlphaNumeric(char c) {
    return (c >= '0' && c <= '9') ||
           (c >= 'A' && c <= 'Z') ||
           (c >= 'a' && c <= 'z');
}

// Приведение символа к нижнему регистру (только для латинских букв)
private char toLowerCase(char c) {
    if (c >= 'A' && c <= 'Z') {
        return (char)(c + ('a' - 'A'));
    }
    return c;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
public int[] intersect(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);

    int[] temp = new int[Math.min(nums1.length, nums2.length)];
    int i = 0, j = 0, idx = 0;

    while (i < nums1.length && j < nums2.length) {
        if (nums1[i] == nums2[j]) {
            temp[idx++] = nums1[i];
            i++;
            j++;
        } else if (nums1[i] < nums2[j]) {
            i++;
        } else {
            j++;
        }
    }
    return Arrays.copyOf(temp, idx);
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
public int maxArea(int[] height) {
    int left = 0, right = height.length - 1;
    int maxArea = 0;

    while (left < right) {
        int width = right - left;
        int minHeight = Math.min(height[left], height[right]);
        int area = width * minHeight;
        if (area > maxArea) {
            maxArea = area;
        }

        if (height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }
    return maxArea;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
public boolean isOneEditDistance(String s1, String s2) {
    int s1l = s1.length();
    int s2l = s2.length();
    if (s1l < s2l) {
        return isOneEditDistance(s2, s1);
    }
    if ((s1l - s2l) > 1) {
        return false;
    }
    if (s1.equals(s2)) {
        return false;
    }
    int i = 0, j = 0;
    boolean foundDifference = false;
    while (i < s1l && j < s2l) {
        if (s1.charAt(i) != s2.charAt(j)) {
            if (foundDifference) {
                return false;
            }
            foundDifference = true;
            if (s1l == s2l) {
                i++;
                j++;
            } else {
                i++;
            }
        } else {
            i++;
            j++;
        }
    }
    return true;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
public static String replaceSpaces(String str, int trueL){
    char[] s = str.toCharArray();
    int space = 0;
    for (int i = 0; i < trueL; i++){
        if(s[i] == ' ') space++;
    }

    int iTrueL = trueL - 1;
    int j = trueL + space * 2; // новая длина

    while(iTrueL >= 0){
        if(s[iTrueL] == ' '){
            s[j - 1] = '0';
            s[j - 2] = '2';
            s[j - 3] = '%';
            j -= 3;
        } else {
            s[j - 1] = s[iTrueL];
            j--;
        }
        iTrueL--;
    }
    return new String(s);
}
public static void main(String[] args) {
    String input = "Mr John Smith    "; // 4 пробела в конце для расширения
    int trueLength = 13; // длина "Mr John Smith" без дополнительных пробелов

    String result = replaceSpaces(input, trueLength);
    System.out.println(result); // Выведет: "Mr%20John%20Smith"
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
hash
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
O(1) (фиксированное поле 9x9) O(1) (фиксированное поле)

public static boolean isValidSudoku(char[][] board){
    Set<String> seen = new HashSet<>();
    for (int i = 0; i<board.length; i++){
        for (j = 0; j < board[0].length; j++){
            char val = board[i][j];
            if (val == '.') continue;
            int blockId = (i / 3) * 3 + ( j / 3);
            String rowKey = "r" + i + "-" + val;
            String colKey = "l" + j + "-" + val;
            String blockKey = "b" + blockId + "-" + val;

            if(!seen.add(rowKey) || !seen.add(colKey) || !seen.add(blockKey) ) return false;
        }
    }
    return true;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
public boolean isIsomorphic(String s, String t){
    if(s.length() != t.length()) return false;
    Map<Character, Character> mapST = new HashMap<>();
    Map<Character, Character> mapTS = new HashMap<>();

    for (int i = 0; i < s.length(); i++){
        char cS = s.charAt(i);
        char cT = t.charAt(i);

        if(mapST.containKey(cS)){
            if(mapST.get(cS) != cT) return false;
        } else {
            mapST.put(cS, cT);
        }

        if(mapTS.containKey(cT)){
            if(mapTS.get(cT) != cS) return false;
        } else {
            mapTS.put(cT, cS);
        }
    }
    return true;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
public static boolean isReflected(int[][] points){
    if (points.length == 0) return true;
    int minX = Integer.MAX_VALUE;
    int maxX = Integer.MIN_VALUE;
    Map<String, Integer> map = new HashMap();

    for( int[] p : poins){
        int x = p[0];
        int y = p[1];
        minX = Math.min(minX, x);
        maxX = Math.max(maxX, x);
        String key = x + " " + y;
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    int l = minX + maxX;

    for(int[]p : points){
        int x = p[0];
        int y = p[1];
        int reflectedX = l - x;
        String reflectedKey = reflectedX + " " + y;
        String originalKey  = x + " " + y;
        if(!map.containsKey(reflectedKey)) return false;
        if(!map.get(reflectedKey).equals(
                        map.get(originalKey))) return false;
    }
    return true;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - - 30m
public class LRUcache {
    private final int capacity;
    private final LinkedHashMap<Integer, Integer> cache;

    public LRUcache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > LRUcache.this.capacity;
            }
        };
    }
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }
    public void put(int key, int value) {
        cache.put(key, value);
    }
}


---- HAND MADE ---- ---- HAND MADE ---- ---- HAND MADE ---- ---- HAND MADE ----

public class LRUCache {
    private class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0); // фиктивный head
        tail = new Node(0, 0); // фиктивный tail
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insertAtHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertAtHead(node);
        } else {
            if (map.size() == capacity) {
                Node toRemove = tail.prev;
                remove(toRemove);
                map.remove(toRemove.key);
            }
            Node newNode = new Node(key, value);
            insertAtHead(newNode);
            map.put(key, newNode);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -2114 - 2130
public int[] findThePrefixCommonArray(int[] A, int[] B) {
    Set<Integer> seen = new HasSet<>();
    int[] result = new int[A.length];
    int common = 0;

    for (int i = 0; i < A.lrength; i++){
        if(seen.contains(A[i])) common++;
        else seen.add(A[i]);

        if(seen.contains(B[i])) common++;
        else seen.add(B[i]);

        result[i] = common;
    }
    return result;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
public static List<List<Integer>> sum3(int[] ar) {
    Arrays.sort(ar);
    List<List<Integer>> res = new ArrayList<>(); // Исправлено
    for (int i = 0; i < ar.length - 2; i++) {
        if (i > 0 && ar[i] == ar[i - 1]) continue;
        int left = i + 1;
        int right = ar.length - 1;
        while (left < right) {
            int sum = ar[i] + ar[left] + ar[right];
            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                res.add(Arrays.asList(ar[i], ar[left], ar[right])); // Исправлено
                // Пропуск дубликатов для left и right
                while (left < right && ar[left] == ar[left + 1]) left++;
                while (left < right && ar[right] == ar[right - 1]) right--;
                left++;
                right--;
            }
        }
    }
    return res;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
public static List<List<Integer>> sum4(int[] num, int t){
    List<List<Integer>> res = new ArrayList<>();
    if(num == null || num.length < 4) return res; #####
    Arrays.sort(num); #####
    int len = num.length;
    for(int i = 0; i < len - 3; i++){
        if(i>0 && num[i] == num[i-1]) continue;
        for(int j = i + 1; j  < len - 2; j++){
            if(j>i + 1 && num[j] == num[j-1]) continue;
            int l = j + 1;
            int r = len - 1;
            while(l < r){
                long sum = (long) num[i] + num[j] +  num[l] + num[r];
                if (sum == t){
                    res.add(Arrays.asList(num[i], num[j],  num[l], num[r]));
                    while(l < r && num[l] == num[l + 1]) l++;
                    while(l < r && num[r] == num[r - 1]) r--;
                    l++;
                    r--;
                } else if (sum < t){
                    l++;
                } else {
                    r--;
                }
            }
        }
    }
    return res;
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
public static int[] intersection(int[] a1, int[] a2){
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    for(int a: a1){
        map.put(a, map.getOrDefault(a, 0) + 1 );
    }
    for(int a: a2){
        if(map.containsKey(a) && map.get(a)>0){
            res.add(a);
            map.put(a, map.get(a) - 1);
        }
    }
    int[] inters = new int[res.size()];
    for (int i = 0; i < res.size(); i++){
        inters[i] = res.get(i);
    }
    return inters;
}
```
