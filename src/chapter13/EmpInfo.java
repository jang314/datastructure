package chapter13;

public class EmpInfo {
    private int empNum; // 직원의 고유번호
    private int age;    // 직원의 나이

    public EmpInfo(int empNum, int age) {
        this.empNum = empNum;
        this.age = age;
    }

    public int getEmpNum() {
        return empNum;
    }

    public int getAge() {
        return age;
    }
}
