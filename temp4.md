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
Графы
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
// реш через ДП
int m2 = 3, n2 = 2;
int expected2 = 3;
нач
0 0 0
0 0 0
реш
1 1 1 == 1 0 0 == 1 1 0
0 0 1 == 1 1 1 == 0 1 1

public int uniquePathsForRobot(int m, int n) {
    int[][] board = new int[m][n];
    for(int i = 0; i < m; i++){
        board[i][0] = 1; // по первого СТОЛБЦА  можно только 1 путем пройти
    }
    for(int i = 0; i < n; i++){
        board[0][i] = 1; // по можно первой строке только 1 путем пройти
    }
    for(int i = 1; i < m; i++){
        for(int j = 1; j<n; j++){
            board[i][j] = board[i][j-1] + board[i-1][j];
        }
    }
    return board[m-1][n-1];
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
int[][] grid1 = {
{0, 0, 0},
{0, 1, 0},
{0, 0, 0}
};
int expected1 = 2;
public static int uniquePathsWithObstaclesForRobot(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        
        if(obstacleGrid[0][0] == 1 || obstacleGrid[rows-1][cols-1] == 1) return 0;

        int[][] memo = new int[rows][cols];
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                memo[i][j] = -1;
            }
        }
        return dfs(0, 0, rows, cols, obstacleGrid, memo);
}
private static int dfs(int i, int j, int rows, int cols, int[][] obstacleGrid, int[][] memo){
    if(i >= rows || j >= cols || obstacleGrid[i][j] == 1) return 0;
    if(i == rows -1 && j==cols-1) return 1;
    if(memo[i][j] != -1) return memo[i][j]; // уже считали
    memo[i][j] = dfs(i+1, j, rows, cols, obstacleGrid, memo) + 
                dfs(i, j+1, rows, cols, obstacleGrid, memo);
    return memo[i][j];
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
int[][] grid = {
{1, 3, 1},
{1, 5, 1},
{4, 2, 1}
};
int expected = 7;

public static int minPathSum(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    int[][] memo = new int[rows][cols];
    for(int i = 0; i<rows; i++){
        for(int j = 0; j<cols; j++){
            memo[i][j] = -1; // не вычисл
        }
    }
    return dfs(0, 0, rows, cols, grid, memo);
}
private static int dfs(int i, int j, int rows, int cols, int[][] grid, int[][] memo){
    if(i>=rows || j>=cols) return Integer.MAX_VALUE;
    if(i==rows - 1 && j == cols -1 ) return grid[i][j];
    if(memo[i][j] != -1) return memo[i][j];
    int down = dfs(i+1, j, rows, cols, grid, memo);
    int right = dfs(i, j+1, rows, cols, grid, memo);
    memo[i][j] = grid[i][j] + Math.min(down, right); /// #####
    return memo[i][j];
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -


```
