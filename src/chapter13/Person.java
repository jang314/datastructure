package chapter13;

public class Person {
    private int ssn;
    private String name;
    private String addr;

    public static Person makePersonData(int ssn, String name, String addr) {
        Person person = new Person();
        person.setSsn(ssn);
        person.setName(name);
        person.setAddr(addr);
        return person;
    }

    protected Person() {

    }

    public int getSsn() {
        return ssn;
    }

    private void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    private void setAddr(String addr) {
        this.addr = addr;
    }

    public void showPerInfo() {
        System.out.printf("주민등록번호 : %d \n", this.ssn);
        System.out.printf("이름 : %s \n", this.name);
        System.out.printf("주소 : %s \n", this.addr);
    }
}
