```
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
интервалы 2
- -  -   -    -     -      -       -        -         -         -       -      -     -    -   -  - -
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
Video Stitching

// Решение 1: Жадный алгоритм с сортировкой  O(n log n) O(1)  
int[][] clips3 = {{0,3}, {0,4}, {2,8}};  
int time3 = 5;  
int expected3 = 2;
public int videoStitchingGreedy(int[][] clips, int time) {
    Arrays.sort(clips. Comparator.comparingInt(a->a[0]));
    int res = 0, farthest = 0, end = 0, i = 0;
    while(farthest < time){
        while(i< clips.length && clips[i][0] <= end){
            farthest = Math.max(farthest, clips[i][1]);
            i++;
        }
        if(farthest == end) return -1;
        end = farthest;
        res++;
    }
    return res;
}
// Решение 2: Массив максимального достижения O(n + time)   O(time)
public int videoStitchingMaxReach(int[][] clips, int time) {
    int[] buckets = new int[time +1 ]; // time =2 > 0,1,2 далее <=
    for(int i : clips){
        if(i[0] <= time){ //####
            buckets[i[0]] = Math.max(buckets[i[0]], i[1]);
        }
    }
    int res =0, farther = 0, end =0;
    for(int i =0; i<=time; i++){
        if( i > farther) return -1;
        farther = Math.max(farther, buckets[i]);
        if(i == end){
            res++;
            end = farther;
        }
    }
    return res >= time ? res : -1;
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
