package com.company.프로그래머스;

class Employee {
    String name;
    int empNo;
    int age;
    static String companyName = "S전자";
}

public class test {
    public static void main(String[] args) {
        //클래스 변수 companyName은 "S전자"로 초기화 되었으므로 "S전자"가 출력된다.
        Employee kim = new Employee();
        System.out.println("kim의 회사명 : " + kim.companyName);

        //클래스 변수를 변경하였으므로 이후 회사명은 "A전자"로 출력된다.
        Employee lee = new Employee();
        lee.companyName = "A전자";
        System.out.println("lee의 회사명 : " + lee.companyName);
        Employee park = new Employee();
        System.out.println("park의 회사명 : " + park.companyName);
    }
}
