package chapter13;

public class TableHashFunction {
    public static void main(String[] args) {
        EmpInfo[] empInfoArr = new EmpInfo[100];

        EmpInfo emp1 = new EmpInfo(20120003, 42);
        EmpInfo emp2 = new EmpInfo(20130012, 33);
        EmpInfo emp3 = new EmpInfo(20170049, 27);

        EmpInfo r1, r2, r3;

        empInfoArr[getHashValue(emp1.getEmpNum())] = emp1;
        empInfoArr[getHashValue(emp2.getEmpNum())] = emp2;
        empInfoArr[getHashValue(emp3.getEmpNum())] = emp3;

        // 키를 인덱스 값으로 이용해서 탐색
        r1 = empInfoArr[getHashValue(20120003)];
        r2 = empInfoArr[getHashValue(20130012)];
        r3 = empInfoArr[getHashValue(20170049)];

        // 탐색 결과 확인
        System.out.printf("사번 : %d, 나이 : %d \n", r1.getEmpNum(), r1.getAge());
        System.out.printf("사번 : %d, 나이 : %d \n", r2.getEmpNum(), r2.getAge());
        System.out.printf("사번 : %d, 나이 : %d \n", r3.getEmpNum(), r3.getAge());
    }

    private static int getHashValue(int empNum) {
        return empNum % 100;
    }
}
