# 클래스 
- 어떤 문제를 해결하기 위한 데이터를 만들기 위해 OOP 원칙에 따라 집단(현실 세계)에 속하는 속성과 행위(methods)를 변수와 메소드로 정의한 것
- 하단 부의 User 클래스 예시와 같이 User 라는 실제 존재를 id, name, age 등의 속성 등으로  모델링하여 purchase, refund 등의 어떠한 행위를 하는 것으로 나타낼 수 있음

## 클래스를 사용하기 전

코드 생성/조회/수정/삭제에 코드를 구현하기 힘들다

* 가정
  * 쇼핑몰을 운영하고 있으며 쇼핑몰을 이용하기 위해서는 아이디, 패스워드, 고객이름, 고객나이, 쇼핑 리스트가 필요하며 
  * 쇼핑몰을 이용하는 고객이 10,000 명이라고 하자

* 절차지향적 프로그래밍 →  코드 반복으로 생성/조회/수정/삭제 모두 너무 힘들다
  ``` python
  # User 01
  user_01_id = 'id_01'
  user_01_name = 'name_01'
  user_01_passwd = 'passwd_01'
  user_01_age = 10
  user_01_shopping_list = ['mac', 'magic_mouse']
  
  # User 02
  user_02_id = 'id_02'
  user_02_name = 'name_02'
  user_02_passwd = 'passwd_02'
  user_02_age = 20
  user_02_shopping_list = ['imac']
  
  # User 03
  user_03_id = 'id_03'
  user_03_name = 'name_03'
  user_03_passwd = 'passwd_03'
  user_03_age = 30
  user_03_shopping_list = ['ipad', 'apple_pencil']
  
  .
  .
  .
  
  # User 10,000
  user_10000_id = 'id_10000'
  user_10000_name = 'name_10000'
  user_10000_passwd = 'passwd_10000'
  user_10000_age = 30
  user_10000_shopping_list = ['iphone']
  ```

* 그렇다면 List 자료구조? → 수정, 삭제 여전히 어려움

  ``` python
  user_id_list = ['id_01', 'id_02', 'id_03']
  user_name_list = ['name_01', 'name_02', 'name_03']
  user_passwd_list = ['passwd_01', 'passwd_02', 'passwd_03']
  user_age_list = [10, 20, 30]
  user_shopping_list = [
      ['mac', 'magic_mouse'],
      ['imac'],
      ['ipad', 'apple_pencil']
  ]
  ```

  ``` python
  # user_02 수정이 필요할 경우, list의 index를 정확하게 매핑해야함
  user_id_list[1] = 'id_04'
  user_name_list[1] = 'name_04'
  user_passwd_list[1] = 'passwd_04'
  user_age_list[1] = 40
  user_shopping_list[1] = ['로지텍 마우스']
  
  print(user_id_list)         # ['id_01', 'id_04', 'id_03']
  print(user_name_list)       # ['name_01', 'name_04', 'name_03']
  print(user_passwd_list)     # ['passwd_01', 'passwd_04', 'passwd_03']
  print(user_age_list)        # [10, 40, 30]
  print(user_shopping_list)   # [['mac', 'magic_mouse'], ['로지텍 마우스'], ['ipad', 'apple_pencil']]
  ```

  ``` python
  # user_02 삭제가 있을 경우, list의 index를 정확하게 매핑해야함
  del user_id_list[1]
  del user_name_list[1]
  del user_passwd_list[1]
  del user_age_list[1]
  del user_shopping_list[1]
  
  print(user_id_list)         # ['id_01', 'id_03']
  print(user_name_list)       # ['name_01', 'name_03']
  print(user_passwd_list)     # ['passwd_01', 'passwd_03']
  print(user_age_list)        # [10, 30]
  print(user_shopping_list)   # [['mac', 'magic_mouse'], ['ipad', 'apple_pencil']]
  ```

* List + Dictionary 자료구조? → 코드 반복으로 중첩 문제 발생 

  ``` python
  user_dict = [
      {'user_id': 'user01', 'user_name': 'name_01'},
      {'user_id': 'user02', 'user_name': 'name_02'},
      {'user_id': 'user03', 'user_name': 'name_03'}
  ]
  print(user_dict)
  # [{'user_id': 'user01', 'user_name': 'name_01'}, {'user_id': 'user02', 'user_name': 'name_02'}, {'user_id': 'user03', 'user_name': 'name_03'}]
  del user_dict[1]
  print(user_dict)
  # [{'user_id': 'user01', 'user_name': 'name_01'}, {'user_id': 'user03', 'user_name': 'name_03'}]
  
  ```

## 클래스를 사용 시

* 코드의 재사용성이 좋아짐
  * 같은 클래스를 여러번 사용하여 객체를 생성할 수 있음 -> 코드 생산성 높임
* 코드의 가독성이 좋아짐
  * 클래스 내부에 포함된 데이터(멤버 변수)와 행동(메소드)을 클래스 이름을 통해 더 쉽게 이해할 수 있음, 즉 코드를 보다 직관적으로 표현
* 유지보수를 쉽게할 수 있음
  * 코드를 생성/조회/수정/삭제 하기가 쉬워짐 -> 코드 생산성 높임
* 모듈화
  * 클래스를 사용하면 데이터와 메소드를 하나의 객체로 묶어서 사용할 수 있음

``` python
class User:
    def __init__(self, id: str, name: str, passwd: str, age: int, shopping_list:List[str]):
        self.__id = id
        self.__name = name
        self.__passwd = passwd
        self.__age = age
        self.__shopping_list = shopping_list

    def __str__(self):
        return f'str : {self.__id} - {self.__name}'

    def __repr__(self):
        return f'repr : {self.__id} - {self.__name}'
      
    def purchase(self, __id):
        # assume some codes implemented
        pass
    
    def refund(self, __id):
        # assume some codes implemented
        pass


user_01 = User('id_01', 'name_01', 'passwd_01', 10, ['mac', 'magic_mouse'])
user_02 = User('id_02', 'name_02', 'passwd_02', 20, ['imac'])
user_03 = User('id_03', 'name_03', 'passwd_03', 30, ['ipad', 'apple_pencil'])

print(user_01)   # str : id_01 - name_01
print(user_02)   # str : id_02 - name_02
print(user_03)   # str : id_03 - name_03

print(user_01.__dict__)
# {'_User__id': 'id_01', '_User__name': 'name_01', '_User__passwd': 'passwd_01', '_User__age': 10, '_User__shopping_list': ['mac', 'magic_mouse']}
print(user_02.__dict__)
# {'_User__id': 'id_02', '_User__name': 'name_02', '_User__passwd': 'passwd_02', '_User__age': 20, '_User__shopping_list': ['imac']}
print(user_03.__dict__)
# {'_User__id': 'id_03', '_User__name': 'name_03', '_User__passwd': 'passwd_03', '_User__age': 30, '_User__shopping_list': ['ipad', 'apple_pencil']}
```

``` python
user_list = []
user_list.append(user_01)
user_list.append(user_02)
user_list.append(user_03)

print()
print()
print(user_list) # [repr : id_01 - name_01, repr : id_02 - name_02, repr : id_03 - name_03]

for user in user_list:
    print(repr(user))
    print(user)

# repr : id_01 - name_01
# str : id_01 - name_01
# repr : id_02 - name_02
# str : id_02 - name_02
# repr : id_03 - name_03
# str : id_03 - name_03
```

