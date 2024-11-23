package chapter13;

import java.util.Scanner;

public class UnderstandTable {
    public static void main(String[] args) {
        EmpInfo[] empInfo = new EmpInfo[1000];
        EmpInfo ei;

        Scanner sc = new Scanner(System.in);
        System.out.println("사번과 나이 입력 :");

        int empNum = sc.nextInt();
        int age = sc.nextInt();
        empInfo[empNum] = new EmpInfo(empNum, age);

        System.out.print("확인하고싶은 직원의 사번 입력 : ");
        int findEmpNum = sc.nextInt();

        ei = empInfo[findEmpNum];
        System.out.printf("사번 %d, 나이 %d ", ei.getEmpNum(), ei.getAge());
    }
}
