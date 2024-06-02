package chapter06;

import common.Stack;

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
        Stack<Character> stack = new ListBaseStack();
        char[] strToChar = strToChar(str);
        char[] array = new char[str.replaceAll("\\(", "").replaceAll("\\)", "").length()];

        int i = 0;
        for(char ch : strToChar) {
            if(isDigit(ch)) {
                array[i] = ch;
                i++;
            } else {
                if(stack.SisEmpty()) {
                    stack.SPush(ch);
                } else {
                    int a = getOpPrec(stack.SPeek());
                    int b = getOpPrec(ch);
                    if(ch == '(') {
                        stack.SPush(ch);
                    } else if(ch == ')') {
                        while (!stack.SisEmpty()) {
                            char set = stack.SPop();
                            if(set != '(') {
                                array[i] = set; i++;
                            }
                        }
                    } else {
                        if(a > b) {
                            while(!stack.SisEmpty()) {
                                array[i] = stack.SPop(); i++;
                            }
                            array[i] = ch; i++;
                        } else {
                            stack.SPush(ch);
                        }
                    }
                }
            }
        }

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

    public static int evalRPNExp(String str) {
        Stack<Integer> stack = new ListBaseStack<>();
        String convertExp = convToRPNExp(str);
        char[] array = strToChar(convertExp);

        int res = 0;
        for(char ch : array) {
            if(isDigit(ch)) {
                stack.SPush(Integer.parseInt(String.valueOf(ch)));
            } else {
                int a = stack.SPop();
                int b = stack.SPop();

                res = calulate(a,b,ch);
                stack.SPush(res);
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
