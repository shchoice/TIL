# Namespace

## 파이썬의 네임스페이스?

* 파이썬 내부의 모든 것은 객체로 구성되며 이들 각각은 특정 이름과 매핑 관계를 갖게 되는데, 이 매핑을 포함하고 있는 공간을 네임스페이스라고 한다.

* 프로그래밍 언어에서 특정한 객체(Object)를 이름(Name)에 따라 구분할 수 있는 범위를 의미

* 개체를 구분할 수 있는 범위

  * dir() : 파이썬 네임스페이스의 key 값을 list로 확인가능
  * \__dict__ : 클래스의 네임스페이스를 확인가능

* 필요한 이유
  * 프로그래밍을 할 때 모든 변수 이름과 함수 이름을 정하게 되는데, 이름들을 모두 겹치지 않게 정하기란 사실상 불가능
    * 따라서 네임스페이스라는 개념을 도입하여, 이름 추돌을 방지
    * 즉, 소속된 네임스페이스가 다르다면 같은 이름이 다른 객체를 가리키도록 하는 것이 가능해짐

  

파이썬의 네임스페이스는 크게 3가지로 분류

1. 내장 네임스페이스(Built-in Namespace)

   * `기본 내장 함수 및 기본 예외`들의 이름들이 소속됨

     ``` python
     print("Hello Python!")
     abs(-10)
     len([1,2,3])
     ```

   * 파이썬으로 작성된 모든 코드 범위가 포함 

2. 전역 네임스페이스(Global Namespace)

   * 각각의 `모듈`마다  존재하며, 모듈이 로딩될 때 생성됨

   * 파이썬은 모듈이 로딩될 때, 해당 모듈의 소스코드를 컴파일하고, 전역 네임스페이스를 생성하여 모듈 수준의 이름들(변수, 함수, 클래스 등)을 정의

     ``` python
     # 모듈 수준의 전역 네임스페이스
     
     # 변수의 전역 네임스페이스
     x = 10
     y = 20
     
     # 함수의 전역 네임스페이스
     def add(a, b):
         return a + b
       
     # 클래스의 전역 네임스페이스
     class Person:
         def __init__(self, name, age):
             self.name = name
             self.age = age
     
     ```

     

3. 지역 네임스페이스(Local Namespace)

   * `함수 및 메소드`의 로컬 네임스페이스로 함수나 메소드가 호출될 때마다 생성됨 

   * 호출이 끝나면 사라지므로 함수나 메소드의 지역 변수는 호출자에게 보이지 않음

     ``` python
     # 함수의 지역 네임스페이스
     ## my_function() 함수가 호출될 때마다, 함수의 지역 네임스페이스가 생성됨
     ## a와 b 매개변수와 c 지역 변수는 모두 해당 함수의 지역 네임스페이스에 정의됨
     ## 함수 내에서 정의된 변수들은 지역 변수로 취급되며, 함수 외부에서는 접근할 수 없음
     ## 함수가 실행을 마치면 해당 지역 네임스페이스는 사라지게 됨
     def my_function(a, b):
         # 지역 네임스페이스
         c = a + b
         print(c)
     
     my_function(10, 20)
     ```

     ``` python
     # 메소드의 지역 네임스페이스
     class Person:
         def __init__(self, name, age):
             self.name = name
             self.age = age

         def get_name(self):
             # 지역 네임스페이스
             name_length = len(self.name)
             return name_length

     # 객체 생성
     person1 = Person("Alice", 25)

     # 메서드 호출
     name_length = person1.get_name()
     print(name_length)
     ```
   ![Python Namespaces ](https://www.programiz.com/sites/tutorial2program/files/python-namespace.png)

## Varable Scope

* x 라는 이름이 여러 namespace에 존재한다면 어떠한 우선순위를 가지고 x에 접근할까? Scope!

* Scope란 레퍼런스하고자 하는 해당 이름이 존재하는 지를 다음과 같은 순서로 찾고 결정함
  1. Local namespace
  1. Enclosing namespace
  1. GLobal namespace
  1. Built-in namespace



---

해당 부분은 아직 지식이 정리가 완전히 정리가 되지 않았지만 위의 3가지 네임 스페이스 외에 아래 두가지의 네임 스페이스가 더 있는 것으로 확인된다. 조사해본 바에 따르면 Class Namespace 및 Instance Namespace 는 위 3가지에 포함되지 않고 독립적으로 있는 것 같은데, 아무리 서치를 해보아도 python 의 5가지 namespace라는 내용은 못찾았다.
개인 생각으로는 명백히 다른 개념이라 판단되어 5가지의 namespace 같아 보여 4. 5. 으로 추가해두었다.
(이에 대해 지식을 알려주실 수 있다면 진심으로 감사를 드리겠습니다.)


4. 클래스 네임스페이스(Class Namespace)

   * 클래스의 속성(attribute)들이 저장되는 네임스페이스

     ```python
     class MyClass:
         # 클래스 네임스페이스
         class_var = 10
     
         def class_method(self):
             # 클래스 네임스페이스
             print(MyClass.class_var)
     
     # 클래스 네임스페이스
     print(MyClass.class_var)
     
     # 객체 생성
     obj = MyClass()
     
     # 클래스 메서드 호출
     obj.class_method()
     ```

5. 인스턴스 네임스페이스(Instance Namespace)

   * 클래스의 인스턴스에서 사용되는 인스턴스 변수들이 저장되는 네임스페이스

     ``` python
     class MyClass:
         def __init__(self, inst_var):
             # 인스턴스 네임스페이스
             self.inst_var = inst_var
     
         def inst_method(self):
             # 인스턴스 네임스페이스
             print(self.inst_var)
     
     # 객체 생성
     obj = MyClass(20)
     
     # 인스턴스 변수 출력
     print(obj.inst_var)
     
     # 인스턴스 메서드 호출
     obj.inst_method()
     ```

     ``` python
     class Person:
         # 클래스 네임스페이스
         count = 0
     
         def __init__(self, name, age):
             # 인스턴스 네임스페이스
             self.name = name
             self.age = age
             Person.count += 1
     
         def say_hello(self):
             # 인스턴스 네임스페이스
             print("Hello, my name is {} and I am {} years old.".format(self.name, self.age))
     
     # 클래스 네임스페이스
     print(Person.count)
     
     # 객체 생성
     person1 = Person("Alice", 25)
     
     # 인스턴스 네임스페이스
     print(person1.name)
     print(person1.age)
     
     # 클래스 네임스페이스
     print(Person.count)
     
     # 메서드 호출
     person1.say_hello()
     ```

---




## 파이썬의 네임스페이스 확인

* `globals()`, `locals()`, `dir()` 함수를 사용하여 네임스페이스를 확인할 수 있음

  * `globals()`

    * 전역 네임스페이스를 반환하는 함수
    * 딕셔너리 형태로 반환되며, 키는 이름(name)을 값은 객체(object)를 나타냅니다.

    ```  python
    global count
    count = 1
    
    name = "shchoi"
    
    # 전역 네임스페이스 확인
    print(globals())
    # {'__name__': '__main__', '__doc__': None, '__package__': None, '__loader__': <_frozen_importlib_external.SourceFileLoader object at 0x7fc79008ccd0>,
    # '__spec__': None, '__annotations__': {}, '__builtins__': <module 'builtins' (built-in)>,
    # '__file__': '/Users/shchoice/TIL/Python/OOP/test.py', '__cached__': None,
    # 'count': 1, 'name': 'shchoi'}
    ```

    

  * `locals()`

    * 현재 지역 네임스페이스를 반환하는 함수

    * 함수나 메서드 내에서 호출할 경우 해당 함수나 메서드의 지역 네임스페이스를 반환

      ```python
      # 현재 지역 네임스페이스 확인
      def my_func():
          x = 10
          print(locals()) # {'x': 10}
      my_func()
      ```

    * 전역에서 호출할 경우 전역 네임스페이스를 반환. 

      ``` python
      global count
      count = 1
      
      name = "shchoi"
      
      print(globals())
      # {'__name__': '__main__', '__doc__': None, '__package__': None, '__loader__': <_frozen_importlib_external.SourceFileLoader object at 0x7fc79008ccd0>,
      # '__spec__': None, '__annotations__': {}, '__builtins__': <module 'builtins' (built-in)>,
      # '__file__': '/Users/shchoice/TIL/Python/OOP/test.py', '__cached__': None,
      # 'count': 1, 'name': 'shchoi'}
      
      print(locals())
      # print(globals()) 와 동일하게 출력됨 (생략)
      ```

    * 딕셔너리 형태로 반환되며, 키는 이름(name)을 값은 객체(object)를 나타냅니다.

  * `dir()`

    * 객체의 이름(name)들을 리스트 형태로 반환하는 함수

    * 객체의 네임스페이스(namespace)에 있는 모든 이름(name)들을 반환

    * 전역 네임스페이스에서 호출할 경우 내장(Built-in) 네임스페이스의 이름(name)도 반환

      ``` python
      # 객체의 네임스페이스 확인
      class MyClass:
          def __init__(self):
              self.x = 10
              self.y = 20
      obj = MyClass()
      print(dir(obj))
      # ['__class__', '__delattr__', '__dict__', '__dir__', '__doc__', '__eq__', '__format__', '__ge__', '__getattribute__',
      # '__gt__', '__hash__', '__init__', '__init_subclass__', '__le__', '__lt__', '__module__', '__ne__', '__new__',
      # '__reduce__', '__reduce_ex__', '__repr__', '__setattr__', '__sizeof__', '__str__', '__subclasshook__', '__weakref__',
      # 'x', 'y']
      ```

      

## 클래스 네임스페이스 확인

* \__dict__ 속성을 확인

  * 클래스 내에 모든 정의된 모든 멤버들을 딕셔너리 형태로 반환

  ``` python
  class MyClass:
      class_var = 10
  
      def __init__(self, inst_var):
          self.inst_var = inst_var
  
      def inst_method(self):
          print(self.inst_var)
  
  # 클래스 네임스페이스 출력
  print(MyClass.__dict__)
  # {'__module__': '__main__', 'class_var': 10, '__init__': <function MyClass.__init__ at 0x7fe268087820>,
  # 'inst_method': <function MyClass.inst_method at 0x7fe280773af0>, '__dict__': <attribute '__dict__' of 'MyClass' objects>,
  # '__weakref__': <attribute '__weakref__' of 'MyClass' objects>, '__doc__': None}
  
  clazz = MyClass(10); # {'inst_var': 10}
  # 인스턴스 네임스페이스 출력
  print(clazz.__dict__) # {'inst_var': 10}
  ```

  
