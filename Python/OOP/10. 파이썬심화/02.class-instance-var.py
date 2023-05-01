from typing import List
class User:
    """
    User Class
    Author : shchoi
    """

    # 클래스 변수
    user_count = 0

    def __init__(self, id: str, name: str, passwd: str, age: int, shopping_list:List[str]):
        # 인스턴스 변수
        self.__id = id
        self.__name = name
        self.__passwd = passwd
        self.__age = age
        self.__shopping_list = shopping_list
        # 클래스 변수
        User.user_count += 1

    def __str__(self):
        return f'str : {self.__id} - {self.__name}'

    def __repr__(self):
        return f'repr : {self.__id} - {self.__name}'

    def __del__(self):
        # 클래스 변수
        User.user_count -= 1

    @property
    def name(self):
        return self.__name

    @name.setter
    def name(self, new_name):
        self.__name = new_name

    def user_info(self):
        print('Current Id : {}'.format(id(self)))
        print('User Detail Info : {} {} {}'.format(self.__name, self.__age, self.__shopping_list))


# self의 의미 : 인스턴스
user_01 = User('id_01', 'name_01', 'passwd_01', 10, ['mac', 'magic_mouse'])
user_02 = User('id_02', 'name_02', 'passwd_02', 20, ['imac'])

# ID 확인
print(id(user_01))  # 140266798329760
print(id(user_02))  # 140266798329712

print(user_01.name == user_02.name)     #False
print(user_01 is user_02)               # False

print(dir(user_01))
# ['_User__age', '_User__id', '_User__name', '_User__passwd', '_User__shopping_list', '__class__', '__del__', '__delattr__', '__dict__', '__dir__', '__doc__', '__eq__', '__format__', '__ge__', '__getattribute__', '__gt__', '__hash__', '__init__', '__init_subclass__', '__le__', '__lt__', '__module__', '__ne__', '__new__', '__reduce__', '__reduce_ex__', '__repr__', '__setattr__', '__sizeof__', '__str__', '__subclasshook__', '__weakref__', 'name', 'user_count', 'user_info']
print(dir(user_02))
# ['_User__age', '_User__id', '_User__name', '_User__passwd', '_User__shopping_list', '__class__', '__del__', '__delattr__', '__dict__', '__dir__', '__doc__', '__eq__', '__format__', '__ge__', '__getattribute__', '__gt__', '__hash__', '__init__', '__init_subclass__', '__le__', '__lt__', '__module__', '__ne__', '__new__', '__reduce__', '__reduce_ex__', '__repr__', '__setattr__', '__sizeof__', '__str__', '__subclasshook__', '__weakref__', 'name', 'user_count', 'user_info']

print(user_01.__dict__)
# {'_User__id': 'id_01', '_User__name': 'name_01', '_User__passwd': 'passwd_01', '_User__age': 10, '_User__shopping_list': ['mac', 'magic_mouse']}
print(user_02.__dict__)
# {'_User__id': 'id_02', '_User__name': 'name_02', '_User__passwd': 'passwd_02', '_User__age': 20, '_User__shopping_list': ['imac']}

# Doctring
print(User.__doc__)
#     User Class
#     Author : shchoi

user_01.user_info()
# Current Id : 140266798329760
# User Detail Info : name_01 10 ['mac', 'magic_mouse']
user_02.user_info()
# Current Id : 140266798329712
# User Detail Info : name_02 20 ['imac']