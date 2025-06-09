```
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
2 указателя
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
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
    //Arrays.sort(nums1);
    //Arrays.sort(nums2);

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
