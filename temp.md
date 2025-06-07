-------------------------------------------------------------------------------------------------------------------

///**/250606
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
///**///////////1627

-------------------------------------------------------------------------------------------------------------------
public void fastSort(int[] a, l, h){
    int middle = l + (h - l) / 2;
    int pivot = a[middle];
    int i = l;
    int j = h;
    while(i <= j){
        while(a[i] < pivot) i++;
        while(a[j] > pivot) j--;
        if(i <= j){ ########################################
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++; j--; ########################################
        }
    }
    if(l < j) fastSort(a, l, j);
    if(h > i) fastSort(a, i, h)
}

public static int[] mergeSortedArray(int[] a, int[] b){
    int i = 0, j = 0, k = 0;
    int[] c = new int[a.length + b.length];
    while(i<a.length && j<b.length){
        if(a[i] < b[j]){
            c[k++] = a[i];
            i++;
        } else {
            c[k++] = b[j];
            j++;
        }
    }
    while(i < a.length) c[k++] = a[i++];
    while(j < b.length) c[k++] = b[j++];
    return c;
}
public static int[] sumSameAsTarget(int[] a, int t){
    Map<int, int> map = new HasMap();
    for(int i = 0; i <a.length; i++){
        int compliment = t - a[i];
        if (map.containsKeys(compliment)){
            return new int[]{map.get(compliment), i}
        } else {
            map.put(a[i], i); ########################################
        }
    }
}
public static int[] sumSameAsTarget(int[] a, int t){
    Arrays.sort(a); ########################################
    int i = 0, j = a.length, res = -1;
    while(i<j){
        int sum = a[i] + a[j];
        if(sum < t){
            i++;
            if (sum > res) res = sum;
        } else {
            j--;
        }
    }
    return res;
}
public static int[] sortedSqrArr(int[] a){
    int i = 0, j = a.length - 1, k = a.length;
    int[] c = new int[a.length];
    while(i <= j){
        if (Math.abs(a[i]) > Math.abs(b[j])) c[k--] = a[i] * a[i++];
        else  c[k--] = a[j] * a[j--];
    }
    return c;
}
public static moveZeros(int[] a){
    int pos = 0; ########################################
    for (e : a){
        if(e != 0) a[pos++] = e;
    }
    while (pos < a.length){
        a[pos++] = 0;
    }
}
///**///////////1719
///**///////////1817
public static palindrome(String s){
    int i = 0, j = s.length() - 1;
    while(i < j){
        while(i < j && !isCharOrInt(s.charAt(i)))i++;
        while(i < j && !isCharOrInt(s.charAt(j)))j--;
        
        if (Charactor.toLowerCase(s.charAt(i)) != Charactor.toLowerCase(s.charAt(j)){
             return false;
        } else {
            i++;
            j--;
        }
    }
    return true;
}
inLowerCase(char c){
    if ( c >= 'A' && <= 'Z') return (char) ( c + ('a' - 'A'));
    return c;
}
isCharOrInt(char c){
    if (
        (c >= 'a' && c <= 'z') ||
        (c >= '0' && c <= '9') ||
        (c >= 'A' && c <= 'Z')

    ) return true;
    return false;
}
///**///////////1835
///**///////////2106
public static int[] intersectionOfSortedArray(int[] a, int[] b){
    int i =0, j = 0, k =0;
    int[] c = new int[Math.minOf(a.length, b.length)];
    while(i<a.length && j<b.length){
        if(a[i] == b[j]){
            c[k] = a[i];
            k++; i++; j++;
        }
        if( a[i] < b[j]) {
            i++;
        } else {
            j++;
        }
    }
    return Arrays.copyOf(c, k);
}

public static int maxArea(int[] a){
    int area = -1, i = 0, j = a.length - 1;
    while(i < j){
        int temp = (j - i) * Math.minOf(a[i], a[j]);
        if (temp > area) area = temp;
        if(a[i] < a[j]){
            i++;
        } else { ########################################
            j++;
        }
    }
    return area;
}

public static String oneEditDistance(Syting s1, String s2){
    if(s1.equals(s2)) return false;
    if(s1.length() < s2.length()) oneEditDistance(s2, s1);
    if((s1.length() - s2.length()) > 1) return false;

    int i = 0, j = 0;
    bool err = false;
    while(i < s1.length() && j < s2.length()){
        if(s1.charAt(i) != s2.charAt(j)){
            if (err) return false;
            err = true;
            if (s1.length() == s2.length()){
                i++; j++;
            } else {
                i++;
            }
        } else { ########################################
        i++;
        j++;
        }
    }
    return true;

}
public static String replaceSpaces(String str, int trueL){
    char[] s = str.toCharArray();
    int space = 0;
    for (int i = trueL - 1; i >=0; i--){ ########################################
        if(s[i] == ' ') space++;
    }

    int iTrueL = trueL - 1;
    int j = (trueL + space * 2);
    while(iTrueL >= 0 && j>= 0){
        if(s[iTrueL] == ' '){
            s[j - 3] = '%'; 
            s[j - 2] = '2'; 
            s[j - 1] = '0';
            j -= 3; 
        }else{
            s[j - 1] = s[iTrueL];
            j--;
        }
        iTrueL--; ########################################
    }
    return new String(s);
}
///**///////////2207
