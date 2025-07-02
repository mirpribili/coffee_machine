```
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
a⊕a=0 и a⊕0=a, повторяющиеся числа взаимно уничтожаются
int[] test2 = {4, 1, 2, 1, 2};
int expected2 = 4;
// Метод для поиска уникального числа с помощью XOR
    public int findSingleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR всех элементов
        }
        return result;
    }

private int[] toBits(int num) {  
    int[] bits = new int[33]; // 32 бита + 1 бит для знака  
    if(num <0){  
        bits[32] = 1;  
        num *= -1;  
    } else {  
        bits[32] = 0;  
    }  
  
    int temp = num;  
    for (int i = 0; i < 32; i++) {  
        bits[i] = temp % 2;  
        temp = temp / 2;  
    }  
    // последний бит — знак: 1 если отрицательное  
    return bits;  
}  
// num = 0*8 + 0*4 + 1*2 + 1*1 = 0 + 0 + 2 + 1 = 3  
// Восстанавливаем число из массива бит и знака  
private int fromBits(int[] bits) {  
    int num = 0;  
    for (int i = 0; i < 32; i++) {  
        num += bits[i] * (int) Math.pow(2, i);  
    }  
    if (bits[32] == 1) {  
        num = -num;  
    }  
    return num;  
}  
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
{1,1,2,2,2,1,0} res 0
public int singleNumber(int[] nums) {  
    int[] bitCount = new int[33]; // учитываем бит знака  
  
    // Подсчитываем сумму битов по каждой позиции для всех чисел   
    for (int num : nums) {  
        int[] bits = toBits(num);  
        for (int i = 0; i < 33; i++) {  
            bitCount[i] += bits[i];  
        }  
    }  
  
    // Берём остаток по модулю 3, чтобы отбросить трёхкратные повторы  
    for (int i = 0; i < 33; i++) {  
        bitCount[i] = bitCount[i] % 3;  
    }  
  
    // Восстанавливаем уникальное число из битов и знака  
    return fromBits(bitCount);  
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Input: [-10, -10, 2, 5]
Expected: 500
public static int maximumProduct(int[] nums) {
    // Инициализация максимумов и минимумов
    int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
    int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

    for (int num : nums) {
        // Обновляем максимумы
        if (num > max1) {
            max3 = max2; max2 = max1; max1 = num;
        } else if (num > max2) {
            max3 = max2; max2 = num;
        } else if (num > max3) {
            max3 = num;
        }

        // Обновляем минимумы
        if (num < min1) {
            min2 = min1; min1 = num;
        } else if (num < min2) {
            min2 = num;
        }
    }
    // Максимум из произведения трех максимумов и произведения двух минимумов и максимума
    return Math.max(max1 * max2 * max3, max1 * min1 * min2); // ######
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
2 простое число
public static boolean isThree(int n) {
    if(n < 2) return false;
    int root = (int) Math.pow(n, 0.5);
    return root * root == n && isSimple(root);
}
private static boolean isSimple(int n){ // isPrime
    if(n <2) return false;
    for(int i = 2; i*i <= n; i++){ // ####### <=
        int temp = n % i;
        if(temp == 0) return false;
    }
    return true;
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
