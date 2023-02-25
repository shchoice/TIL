package my.study.jpabasic.valuetype;

import my.study.jpabasic.valuetype.domain.Address;

public class equalMain {

  public static void main(String[] args) {
    int a = 10;
    int b = 20;
    System.out.println("a == b : " + (a == b));

    Address address1 = new Address("city", "street", "zipcode");
    Address address2 = new Address("city", "street", "zipcode");
    System.out.println("address1 == address2 : " + (address1 == address2));
    System.out.println("address1 equals address2 : " + address1.equals(address2));
  }
}
