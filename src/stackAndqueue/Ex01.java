package stackAndqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex01 {
    public static void main(String[] args) {
        boolean result = solution(")()(");
        System.out.println(result);

    }

    static boolean solution(String s) {
        boolean answer = true;

        String[] ch = new String[s.length()];
        int idx = 0;

        for(int i = 0; i < s.length(); i++) {
            String k = String.valueOf(s.charAt(i));
            if(k.equals("(")) {
                ch[idx] = k;
                idx++;
            } else if(k.equals(")")) {
                ch[idx-1] = "";
                idx--;
            }
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return Arrays.asList(ch).stream().filter(f -> "(".equals(f)).collect(Collectors.toList()).size() == 0;
    }
}
