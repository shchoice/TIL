# Object Oriented Programming(OOP)
- 데이터를 추상화시켜 상태(속성)와 행위(methods)를 가진 객체(object)로 만들고 그 객체들 간의 유기적인 상호작용을 통해 로직(흐름)을 구성하는 프로그래밍 방법
- 프로그램을 실제 세상에 가깝게 모델링하는 기법

## Class
- 어떤 문제를 해결하기 위한 데이터를 만들기 위해 OOP 원칙에 따라 집단(현실 세계)에 속하는 속성과 행위(methods)를 변수와 메소드로 정의한 것
- 로봇 설계도

## Instacne(Object)
- class에서 정의한 것(설계도)를 토대로 실제 메모리상에 할당된 것(실제 사물, object)으로 실제 프로그램에서 사용되는 데이터
- 하나의 class로 만들어진 여러 instance(object)는 각각 독립적이다.
- 실제 로봇

## OOP 의 4가지 특징
- **`캡슐화(Encapsulation)`**
  - 객체(Obejct)의 데이터와 해당 데이터를 조작하는 메소드(**속성과 행위**)를 하나로 묶고, 구현된 일부를 외부에 감추어 은닉
    - 클래스 내부에서 데이터의 상태를 보호하기 위해, 데이터에 직접 접근하지 못하도록 제한하는 기능을 제공
      - 코드의 안정성과 보안성을 높임
    - Java 에서는 다음과 같은 방법들로 캡슐화를 구현
      1. 접근 제한자(access modifier)를 제공
         - public : 어디에서든 접근 가능
         - protected : 같은 패키지 또는 상속받은 클래스에서만 접근 가능
         - default : 같은 페키지에서만 접근 가능
         - private : 같은 클래스 내에서만 접근 가능 
      2. Getter와 Setter 메소드를 사용
         - 클래스의 멤버 변수(속성)를 private으로 지정하고, Getter/Setter 를 통해 접근
      3. final 키워드 사용
         - final 키워드를 사용하여 클래스, 변수, 메소드를 final로 선언하면, 해당 요소들은 더 이상 변경할 수 없음
      4. interface 사용
         - interface를 사용하여 해당 interface를 구현한 클래스에서만 접근할 수 있는 메소드를 선언할 수 있음
      5. 내부 클래스(Inner Class) 사용
         - 내부 클래스를 사용하여 클래스 내부에서 다른 클래스를 선언하고, 해당 클래스의 변수와 메서드를 private으로 지정하여 캡슐화를 구현
          ``` java
          public class Outer {
              private int data;
            
              public void printData() {
                  Inner inner = new Inner();
                  System.out.println(inner.getData());
              }
            
              private class Inner {
                  public int getData() {
                      return data;
                  }
              }
          }
          // Inner 클래스는 private으로 선언되어 외부에서 직접 접근할 수 없음
          // Inner 클래스에서는 Outer 클래스의 data 멤버 변수에 접근할 수 있음
          // printData() 메서드에서 Inner 클래스를 생성하여 Inner 클래스의 getData() 메서드를 호출
          // 이를 통해 data 멤버 변수에 대한 접근을 Outer 클래스 내부에서만 가능하도록 캡슐화를 구현
          ```
    - Python 에서는 다음과 같은 방법으로 캡슐화를 구현
      - Python 에소는 캡슐화를 언어적으로 강제할 수 있는 방법은 제공하지 않지만
      - 언더스코어(_)를 활용하여 데이터를 보호하고 클래스 외부에서 접근하지 못하도록 함으로써 캡슐화를 구현할 수 있음
        - 언더스코어 하나(_) : Protected 멤버
          - 해당 클래스 내부 또는 하위 클래스에서만 접근 가능
        - 언더스코어 두개(__) : Private 멤버
          - 클래스 내부에서만 접근 가능
        ``` pyhon
        class Example:
            def __init__(self):
                self._protected_data = 10
                self.__private_data = 20
            
            def get_protected_data(self):
                return self._protected_data
            
            def set_protected_data(self, data):
                self._protected_data = data
            
            def __get_private_data(self):
                return self.__private_data
            
            def __set_private_data(self, data):
                self.__private_data = data
            
            def access_private_data(self):
                return self.__get_private_data()
        ```
- **`추상화(Abstaction)`**
  - 복잡한 시스템에서 핵심적인 개념이나 기능을 간추려 내는 과정
    - 핵심적인 개념과 기능에 집중하여 코드를 구현하고, 코드의 가독성과 유지보수성을 높임
  - 대개 `인터페이스(interface)`나 `추상 클래스(abstact class)`를 정의하는 것으로 이루어짐
    - 구현 세부 사항이나 로직을 제외하고 **해당 기능의 목적과 기능**에 대한 설명만 포함됨
  - 불필요한 정보는 숨기고 중요한(필요한) 정보만을 표현함으로써 공통의 속성이나 행위(methods)를 하나로 묶어 이름을 붙임
    - 추상 자료형 = class
    - class를 실제로 구현한 것 = instance
    - class 내의 data = member variable
    - class 내의 operation (function) = method
  - Java 에서는 다음과 같은 방법으로 추상화를 구현
    1. 인터페이스를 사용  
       ``` java
       public interface Animal {
            public void move();
       }
       
        public class Cat implements Animal {
            @Override
            public void move() {
                System.out.println("고양이가 걷습니다.");
            }
        }
       
        public class Fish implements Animal {
            @Override
            public void move() {
                System.out.println("물고기가 헤엄칩니다.");
            }
        }
       
        public class Example {
            public static void main(String[] args) {
                Animal cat = new Cat();
                Animal fish = new Fish();
            
                cat.move(); // 고양이가 걷습니다.
                fish.move(); // 물고기가 헤엄칩니다.
            }
        }
       ```

       > **인터페이스(interface)란**  
         인터페이스는 메서드 시그니처(메서드 이름, 매개변수, 반환 타입)만 정의하고, 구현하지 않은 추상 메서드(abstract method)를 가지는 클래스  
         인터페이스를 구현하는 클래스에서는 인터페이스에 정의된 추상 메서드를 반드시 구현해야함  

    2. 추상 클래스(abstract class)를 사용
        > ** 추상 클래스(abstact class)란  
          추상 클래스는 인스턴스를 생성할 수 없는 클래스로, 추상 메소드를 포함할 수 있음  
          추상 클래스를 상속받은 클래스에서는 추상 메소드를 반드시 구현해야 함

        ``` java
        public abstract class Animal {
            public abstract void move();
        }
        
        public class Cat extends Animal {
            @Override
            public void move() {
                System.out.println("고양이가 걷습니다.");
            }
        }
        
        public class Fish extends Animal {
            @Override
            public void move() {
                System.out.println("물고기가 헤엄칩니다.");
            }
        }
        
        public class Example {
            public static void main(String[] args) {
                Animal cat = new Cat();
                Animal fish = new Fish();
            
                cat.move(); // 고양이가 걷습니다.
                fish.move(); // 물고기가 헤엄칩니다.
            }
        }
        ```
    - Python 에서는 다음과 같은 방법으로 캡슐화를 구현
      1. 추상 클래스
          ``` python
          from abc import ABC, abstractmethod
         
          class Animal(ABC):
              @abstractmethod
              def move(self):
                  pass
         
          class Cat(Animal):
              def move(self):
                  print("고양이가 걷습니다.")
         
          class Fish(Animal):
              def move(self):
                  print("물고기가 헤엄칩니다.")
         
          cat = Cat()
          fish = Fish()
         
          cat.move() # 고양이가 걷습니다.
          fish.move() # 물고기가 헤엄칩니다.
          ```
         
      2. 인터페이스
          ``` python
          from abc import ABCMeta, abstractmethod
          
          class Animal(metaclass=ABCMeta):
              @abstractmethod
              def move(self):
                  pass
          
          class Cat(Animal):
              def move(self):
                  print("고양이가 걷습니다.")
          
          class Fish(Animal):
              def move(self):
                  print("물고기가 헤엄칩니다.")
          
          cat = Cat()
          fish = Fish()
          
          cat.move() # 고양이가 걷습니다.
          fish.move() # 물고기가 헤엄칩니다.
          ```


- **`상속(Inheritance)`**
  - 부모 class의 속성과 행위(methods)을 그대로 상속 받고 
  - 행위(methods)의 일부분을 수정해야 할 경우, 상속받은 자식 class에서 해당 행위(methods)만 다시 수정하여 사용할 수 있음
  - class 에서 추가적으로 속성이나 행위(methods)를 정의할 수 있음
  - Java 에서 상속을 구현하는 방법
    ``` java 
    // 부모 클래스
    public class Animal {
        protected String name;
    
        public Animal(String name) {
            this.name = name;
        }
    
        public void eat() {
            System.out.println(name + " is eating.");
        }
    }
    
    // 자식 클래스
    public class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }
    
        public void bark() {
            System.out.println(name + " is barking.");
        }
    
        // 오버라이딩
        @Override
        public void eat() {
            System.out.println(name + " is eating dog food.");
        }
    }
    
    // 사용 예시
    public class Main {
        public static void main(String[] args) {
            Dog dog = new Dog("Max");
            dog.bark(); // "Max is barking."
            dog.eat(); // "Max is eating dog food."
        }
    }
    ```
  - Python 에서 상속을 구현하는 방법
    ``` python
    # 부모 클래스
    class Animal:
        def __init__(self, name):
            self.name = name
        
        def eat(self):
            print(f"{self.name} is eating.")
    
    # 자식 클래스
    class Dog(Animal):
        def __init__(self, name):
            super().__init__(name)
        
        def bark(self):
            print(f"{self.name} is barking.")
        
        # 오버라이딩
        def eat(self):
            print(f"{self.name} is eating dog food.")
    
    # 사용 예시
    if __name__ == "__main__":
        dog = Dog("Max")
        dog.bark() # "Max is barking."
        dog.eat() # "Max is eating dog food."
    ```
- **`다형성(Polymorphism)`**
  - 같은 이름의 메소드나 연산자가 다양한 형태의 객체에서 다른 방식으로 작동할 수 있는 능력
  - 상속 계층 구조에서 부모 클래스의 메서드를 오버라이딩하거나, 자식 클래스에서 오버로딩하여 다양한 객체에 대해 같은 인터페이스를 제공
    - 오버로딩 
      - 같은 이름의 메서드나 연산자를 매개변수의 개수나 타입에 따라 다른 형태로 구현하는 것을 말함
      - 메서드 이름의 재사용성을 높일 수 있음
      - java 에서 오버라이딩을 사용할 경우
      ``` java
        public class Calculator {
            public int add(int x, int y) {
                return x + y;
            }
      
            public double add(double x, double y) {
                return x + y;
            }
        
            public int add(int x, int y, int z) {
                return x + y + z;
            }
        }
      
        // 사용 예시
        public class Main {
            public static void main(String[] args) {
                Calculator calculator = new Calculator();
                System.out.println(calculator.add(1, 2)); // 3
                System.out.println(calculator.add(2.5, 3.5)); // 6.0
                System.out.println(calculator.add(1, 2, 3)); // 6
            }
        }
      ```
      - Python 에서는 오버로딩을 정식적으로 지원하지 않음
        - 동적 타이핑(Dynamic Typing) 언어이기 때문에, 매개변수의 타입을 체크하는 과정이 불필요, 즉 파이썬에서는 매개변수의 타입을 미리 지정하지 않음
          - 함수 호출 시 객체 타입을 런타임에 체크하므로, 매개변수의 타입을 미리 지정하는 것이 필요하지 않음
        - 다만, 오버로딩 대신 매개변수의 타입 체크를 직접 수행하는 방식으로 오버로딩을 구현할 수 있음
        ```python
        def add(x, y):
            if isinstance(x, int) and isinstance(y, int):
                return x + y
            elif isinstance(x, str) and isinstance(y, str):
                return x + " " + y
            else:
                return None
        
        # 사용 예시
        print(add(1, 2))           # 3
        print(add("hello", "world")) # "hello world"
        print(add(1, "hello"))      # None
        ```
      
    - 오버라이딩
      - 부모 클래스의 메서드를 자식 클래스에서 재정의하여 자식 클래스에서 특화된 구현을 제공
      - 즉, 같은 이름의 메서드를 자식 클래스에서 재정의하여 자식 클래스에서 부모 클래스의 메서드를 덮어쓰는 것
      - Java 에서 오버라이딩을 사용할 경우
        ``` java
        public class Animal {
            public void makeSound() {
                System.out.println("Animal is making a sound.");
            }
        }
        
        public class Dog extends Animal {
            @Override
            public void makeSound() {
                System.out.println("Dog is barking.");
            }
        }
        
        // 사용 예시
        public class Main {
            public static void main(String[] args) {
                Animal animal = new Animal();
                animal.makeSound(); // "Animal is making a sound."
                
                Dog dog = new Dog();
                dog.makeSound(); // "Dog is barking."
            }
        }
        ```
        
      - Python 에서 오버라이딩을 사용할 경우
        ```python
        class Animal:
            def make_sound(self):
                print("Animal is making a sound.")
        
        class Dog(Animal):
            def make_sound(self):
                print("Dog is barking.")
        
        # 사용 예시
        if __name__ == "__main__":
            animal = Animal()
            animal.make_sound() # "Animal is making a sound."
            
            dog = Dog()
            dog.make_sound() # "Dog is barking."
        ```
  - 여러 형태를 가질 수 있도록 한다. 즉, 객체를 부품화할 수 있도록 한다.

## OOP 의 5가지 원칙
*