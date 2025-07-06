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
1: 2, 3
2: 1, 4
3: 1
4: 2

можно представить как

Map<Integer, List<Integer>> graph = new HashMap<>();
graph.put(1, Arrays.asList(2, 3));
graph.put(2, Arrays.asList(1, 4));
graph.put(3, Arrays.asList(1));
graph.put(4, Arrays.asList(2));

или 

(1,2), (1,3), (2,4)

List<int[]> edges = Arrays.asList(
  new int[]{1, 2},
  new int[]{1, 3},
  new int[]{2, 4}
);
------ ------ ------
int[][] matrix = {
  {0, 1, 1, 0}, // из вершины 1 в 2 и 3
  {1, 0, 0, 1},
  {1, 0, 0, 0},
  {0, 1, 0, 0}
};
    1  2  3  4  <- вершины (столбцы)
1 [ 0, 1, 1, 0 ]  // из вершины 1 есть ребра в 2 и 3
2 [ 1, 0, 0, 1 ]  // из вершины 2 есть ребра в 1 и 4
3 [ 1, 0, 0, 0 ]  // из вершины 3 есть ребро в 1
4 [ 0, 1, 0, 0 ]  // из вершины 4 есть ребро в 2
1 --- 2
|     |
3     4


------ ------ ------
или  как у робота было
0 0 0
0 0 0
0 0 0

что можно представить так

(0,0) — (0,1) — (0,2)
  |       |        |
(1,0) — (1,1) — (1,2)
  |       |        |
(2,0) — (2,1) — (2,2)


- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Компонента связности — максимальный подграф, в котором любые две вершины связаны путём.
В нашем примере граф разбивается на две компоненты: 
(1,2), (1,3), (2,4), (5,6)
 
 1      5
/ \      \
2  3      6
|
4
{1,2,3,4} и {5,6}.
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
Чем отличается DFS от BFS?

Особенность DFS (поиск в глубину)== стек (явно или рекурсия)
Не гарантирует кратчайший путь
Пример использования === Поиск компонент связности, топологическая сортировка, поиск циклов

BFS (поиск в ширину) ==  очередь
Гарантирует нахождение кратчайшего пути в невзвешенном графе
Пример использования === Поиск кратчайшего пути в невзвешенном графе, поиск в социальных сетях, маршрутизация
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
значит топологическая сортировка здесь?
Для компонента {1,2,3,4} порядок должен быть таким, чтобы вершина 1 была раньше 2 и 3, а 2 — раньше 4. Например:
1 → 2 → 4 → 3 или 1 → 3 → 2 → 4 
Порядок выполнения с учётом зависимостей

Если в графе есть цикл, то топологическую сортировку сделать нельзя.
потому что в цикле невозможно упорядочить вершины так, чтобы все рёбра шли «вперёд» по порядку
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
 кратчайшего пути в невзвешенных графах используют BFS, а DFS — нет. Для взвешенных графов применяют алгоритмы Дейкстры, Беллмана-Форда
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
int[][] prereq1 = {{1,0}, {2,1}, {3,2}};
Курсы: 0, 1, 2, 3 (4)
Зависимости:
  1 <- 0
  2 <- 1
  3 <- 2

Граф:
0 → 1 → 2 → 3

Проверяем цикл:
- Начинаем с 0: идем к 1
- 1: идем к 2
- 2: идем к 3
- 3: нет соседей, возвращаемся назад
Циклов нет → можно пройти все курсы

int[][] prereq1 = {{1,0}, {2,1}, {3,0}, {2,3}};
0 → 1 → 2
 \      ↑
  → 3 --- 

private List<Integer> orde = new ArrayList<>(); // если хочется увидить рез топ сорт 

public boolean canFinish(int numCourses, int[][] prerequisites) {
    /// orde.clean();
    List<List<Integer>> graph = new ArrayList<>();
    for(int i =0; i<numCourses; i++) graph.add(new ArrayList<>());
    for(int[] i : prerequisites){
        graph.get(i[1]).add(i[0]); // 1й тот кого 1м надо проходить
        // 0 {1, 3}
        // 1 {2}
        // 3 {2}
    }

    boolean[] onPath = new boolean[numCourses];
    boolean[] visited = new boolean[numCourses];
    for(int i =0; i<numCourses; i++){
        if(hasCycle(i, onPath, visited, graph)) return false;
    }
/// Collections.resort(order);
/// System.out.println(order);
    return true;
}
private static boolean hasCycle(int i, boolean[] onPath, boolean[] visited, List<List<Integer>> graph){
    if(onPath[i]) return true;  // Bingo! Cycle
    if(visited[i]) return false; // was seen

    onPath[i] = true;
    for(int ii : graph.get(i)){
        if(hasCycle(ii, onPath, visited, graph)) return true;
    }
    onPath[i] = false;
    visited[i] = true;
/// orde.add(i);
    return false;
} O(V + E), где V — курсы, E — зависимости ВРЕМЯ И ПАМЯТЬ
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
  ->1->3
 /     /^
0 -> 2
int[][] prereq2 = {{1,0},{2,0},{3,1},{3,2}}; 
0{1,2}, 1{3}, 2{3}
int[] res2 = solver.findCourseOrder(4, prereq2); 
Expected: [0, 1, 2, 3] or [0, 2, 1, 3] (dfs reverse)


public int[] findCourseOrder(int numCourses, int[][] prerequisites) {
    List<List<Integer>> graph = new ArrayList<>();
    for(int i = 0; i<numCourses;i++)grap.add(new ArrayList<>());

    int[] indegree = new int[numCourses];

    for(int[] i : prerequisites){
        grap.get(i[1]).add(i[0]);
        indegree[i[0]]++;
        //  0  1  2  3 -- number curse
        // [0, 1, 1, 2]
        // или даже так
        // [0, 1, 0, 2]
    }

    Queue<Integer> que = new LinkedList<>();
    for (int i = 0; i < numCourses; i++){ ///##### BAD-> for(int i: indegree)
        if(indegree[i] == 0) que.offer(i);
    }
    int idx = 0;
    int[] res = new int[numCourses]; // так нет рекурсии можно не бояться

    while(!que.isEmpty()){
        int course = que.poll();
        res[idx++] = course;
        for (int i : grap.get(course)){ // grap    0{1,2}, 1{3}, 2{3}
            indegree[i]--;             // indegree [0, 1, 1, 2]
            if(indegree[i] == 0) que.offer(i); // если 0 значит нет цикла
        }
    }
    return numCourses == idx ? res : new int[0];
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
grid1 = {
    {'1','1','0','0','0'},
    {'1','1','0','0','0'},
    {'0','0','1','0','0'},
    {'0','0','0','1','1'}
};
res = 3;

private int rows;
private int cols;
private char[][] copy;
public int numIslands(char[][] grid) {
    rows = grid.length;
    cols = grid[0].length;
    copy = new char[rows][cols];

    for(int i = 0; i<rows; i++){
        for(int j = 0; j<grid[0].length; j++){
            copy[i][j] = grid[i][j];
        }
    }
    int res = 0;
    for(int i = 0; i<rows; i++){
        for(int j = 0; j<cols; j++){
            if(copy[i][j] == '1'){
                res++;
                dfs(i, j);
            }
        }
    }
    return res;
}
private void dfs(int i, int j){
    if(
        i < 0 || j < 0 ||
        i >= rows || j >= cols || /// ##### i >= rows
        copy[i][j] == '0'
    ) return;

    copy[i][j] = '0'; // топим остров
    dfs(i -1, j);
    dfs(i +1, j);
    dfs(i, j -1);
    dfs(i, j +1);
}
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -


```
