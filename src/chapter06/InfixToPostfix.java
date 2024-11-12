package chapter06;

public class InfixToPostfix {
    public static void main(String[] args) {
        String exA = "(1+2*3)/4";
        String exB = "5+2/7";
        String exC = "1+2*3";
        String exD = "(1+2)*3)";
        String exE = "((1-2)+3)*(5-2)";

        System.out.println("[ "+exA + " ] ==> " + convToRPNExp(exA));
        System.out.println(convToRPNExp(exA) + " = " + evalRPNExp(exA));
        System.out.println();

        System.out.println("[ "+exB + " ] ==> " + convToRPNExp(exB));
        System.out.println(convToRPNExp(exB) + " = " + evalRPNExp(exB));
        System.out.println();

        System.out.println("[ "+exC + " ] ==> " + convToRPNExp(exC));
        System.out.println(convToRPNExp(exC) + " = " + evalRPNExp(exC));
        System.out.println();

        System.out.println("[ "+exD + " ] ==> " + convToRPNExp(exD));
        System.out.println(convToRPNExp(exD) + " = " + evalRPNExp(exD));
        System.out.println();

        System.out.println("[ "+exE + " ] ==> " + convToRPNExp(exE));
        System.out.println(convToRPNExp(exE) + " = " + evalRPNExp(exE));
    }

    public static String convToRPNExp(String str) {
        Stack<Character> stack = new ListBaseStack();   // 쟁반
        char[] strToChar = strToChar(str);              // 중위 표기법으로 들어온 string을 char[]로 변환 (중위 표기법을 블록으로 표현한 것)
        char[] array = new char[str.replaceAll("\\(", "").replaceAll("\\)", "").length()];
        // 변환된 수식이 위치할 자리 (스택)


        int i = 0;
        for(char ch : strToChar) {
            if(isDigit(ch)) {   // 블록의 데이터가 숫자라면
                array[i] = ch;  // 변환돈 수식이 위치할 자리로 이동
                i++;
            } else {            // 블록의 데이터가 연잔자라면
                if(stack.SisEmpty()) {  // 쟁반이 비어있을 때 push
                    stack.SPush(ch);
                } else {        // 쟁반이 비어있지 않을 때
                    int a = getOpPrec(stack.SPeek());   // 쟁반에 있는 연산자의 우선순위 확인
                    int b = getOpPrec(ch);              // 새 연샂나의 우선순위 확인
                    if(ch == '(') {     // 시작 소괄호일 경우 일단 쟁반에 push
                        stack.SPush(ch);
                    } else if(ch == ')') {  // 종료 소괄호일 경우 쟁반에 있는 블록이 ( 를 만날 때까지 데이터를 꺼내 변환된 수식이 위치할 자리로 이동
                        while (!stack.SisEmpty()) {
                            char set = stack.SPop();
                            if(set != '(') {
                                array[i] = set; i++;
                            }
                        }
                    } else {    // 소괄호가 아닌 일반 연산자일 경우
                        if(a > b) { // 비교한 우선 순위 즉, 쟁반에 있는 블록의 데이터가 우선순위가 높을경우
                            while(!stack.SisEmpty()) {
                                array[i] = stack.SPop(); i++;   // 쟁반에서 꺼내 변환된 수식이 위치할 자리로 옮긴다.
                            }
                            array[i] = ch; i++;
                        } else {    // 비교한 우선 순위 즉, 새 연산자의 데이터가 우선순위가 높을 경우
                            stack.SPush(ch);       // 쟁반으로 연산자를 옮긴다.
                        }
                    }
                }
            }
        }

        // 쟁반에 남아있는 블록이 비어질때 까지 꺼내서 변환된 수식이 위치할 자리로 옮긴다.
        while(!stack.SisEmpty()) {
            array[i] = stack.SPop(); i++;
        }
        String result = "";
        for(char a : array) {
            result += a +  " ";
        }
        return result;
    }

    public static char[] strToChar(String input) {
        String dec = input.trim().replaceAll(" ", "");
        char[] susik = new char[dec.length()];
        for(int i = 0 ; i < dec.length(); i++) {
            susik[i] = dec.charAt(i);
        }

        return susik;
    }

    // 연산자의 우선순위
    public static int getOpPrec(char op) {
        switch (op) {
            case '(' : return 0;
            case '+' : case '-' : return 1;
            case '*' : case '/' : return 2;
        }
        return -1;
    }

    public static boolean isDigit(char digit) {
        return Character.isDigit(digit);
    }

    // 매개변수로 후위 표기법 수식을 넘겨준다.
    public static int evalRPNExp(String str) {
        Stack<Integer> stack = new ListBaseStack<>();
        String convertExp = convToRPNExp(str);
        char[] array = strToChar(convertExp);

        int res = 0;
        for(char ch : array) {
            if(isDigit(ch)) { // 블록의 데이터가 숫자이면 스택에 쌓아준다.
                stack.SPush(Integer.parseInt(String.valueOf(ch)));
            } else {    // 블록의 데이터가 피연산자 이면 스택에서 피연산자 2개를 꺼내준다.
                int a = stack.SPop();
                int b = stack.SPop();

                res = calulate(a,b,ch); // 스택에서 꺼낸 피연산자와 해당 연산자를 가지고 계산을 진행한다.
                stack.SPush(res);   // 계산 결과는 다시 스택에 넣는다.
            }
        }
        return res;
    }

    private static Integer calulate(int a, int b, char ch) {
        switch (ch) {
            case '+' : return b+a;
            case '-' : return b-a;
            case '*' : return b*a;
            case '/' : return b/a;
        }
        throw new IllegalStateException();
    }
}
