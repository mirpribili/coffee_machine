```
11. Backtracking
Задачи
Backtracking
 17. Letter Combinations of a Phone Number #озон РЕШЕНИЕ РЕШЕНИЕ_ИТЕРАТИВНОЕ
 46. Permutations РЕШЕНИЕ
 51. N-Queens РЕШЕНИЕ
 22. Generate Parentheses РЕШЕНИЕ #vk (теория про ЧИСЛА КАТАЛАНА - это поможет оценить число таких последовательностей. Вряд ли пригодится, но если спросят эту задачу, то можно оценить сложность как n-ое число Каталана)
Самому прорешать для закрепления
Backtracking
 39. Combination Sum РЕШЕНИЕ

12. Плавающее окно
Задачи
Sliding window
 228. Summary Ranges РЕШЕНИЕ #яндекс
 485. Max Consecutive Ones РЕШЕНИЕ #яндекс
 3. Longest Substring Without Repeating Characters РЕШЕНИЕ #яндекс
 849. Maximize Distance to Closest Person РЕШЕНИЕ #яндекс
 443. String Compression РЕШЕНИЕ #яндекс
После курса
 567. Permutation in String #яндекс
 76. Minimum Window Substring #яндекс
 239. Sliding Window Maximum #яндекс


> 1. **ВАЖНО! пиши ПРИМЕРЫ и ДЕМОНСТРАЦИИ только в тройных кавычках.** Если нужно показать квадратные скобки, помещай их только внутри таких блоков, чтобы Markdown не воспринимал их как ссылки.
> 2. Повтори условие задачи      1091. Shortest Path in Binary Matrix
>3. Опиши задачу в виде таблицы с типами решений (их сложностью по времени и памяти и особенностями).
>4. Покажи лучший код на Java с придуманным названием класса.
>5. Добавь в класс метод main с тестами, в которых выводи в консоль ожидаемый и реальный результат для наглядности.
>6. добавь  Текстовое изображение процесса (пример)

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
String[] tests = {"23", "", "2"};
String[][] expected = {
    {"ad","ae","af","bd","be","bf","cd","ce","cf"},
    {},
    {"a","b","c"}
};
private static final String[] KEYS = {
    "", // 0
    "", // 1
    "abc", // 2
    "def", // 3
    "ghi", // 4
    "jkl", // 5
    "mno", // 6
    "pqrs",// 7
    "tuv", // 8
    "wxyz" // 9
};

public List<String> combinations(String digits){
    List<String> res = new ArrayList<>();
    if(digits == null || digits.length() == 0) return res;
    backtrack(digits, res, new StringBuilder(), 0);
    return res;
}
private void backtrack(String digits, List<String> res, StringBuilder cur, int index){
    if(index == digits.length()){ // #####
        res.add(cur.toString());
        return;
    }
    String letters = KEYS[digits.charAt(index) - '0'];// chat to int
    for (int i = 0; i<letters.length(); i++){
        cur.append(letters.charAt(i));
        backtrack(digits, res, cur, index + 1);
        cur.deleteCharAt(cur.length() - 1);
    }
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
