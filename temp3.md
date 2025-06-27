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
