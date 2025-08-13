```
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
stream
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
int[] arr = {4, 1, 7, 3, 9, 2};

int max = IntStream.of(arr).max().orElseThrow(
      () -> new NoSuchElementException("Пустой массив"));
int min = IntStream.of(arr).min().orElseThrow(
      () -> new NoSuchElementException("Пустой массив"));

int diff = max - min;
System.out.println("Разность максимум-минимум: " + diff);

- -  -   -    -

IntSummaryStatistics stats = IntStream.of(arr).summaryStatistics();
int diff = stats.getMax() - stats.getMin();
System.out.println("Разность максимум-минимум: " + diff);

- -  -   -    -

R collect(
    Supplier<R> supplier, — создаёт новый контейнер/результат, куда будут собираться данные.
    ObjIntConsumer<R> accumulator, — добавляет один элемент из потока в контейнер.
    BiConsumer<R,R> combiner — объединяет два контейнера (нужно при параллельной обработке).
)

int[] result = IntStream.of(arr).collect(
    () -> new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE}, // контейнер: [min, max]
    (a, val) -> { a[0] = Math.min(a[0], val); a[1] = Math.max(a[1], val); },
    (a, b) -> { a[0] = Math.min(a[0], b[0]); a[1] = Math.max(a[1], b[1]); }
);

int diff = result[1] - result[0];


- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
tree
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
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -

