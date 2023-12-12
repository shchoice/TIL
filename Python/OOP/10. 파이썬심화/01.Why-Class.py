from typing import List

# 절차지향 프로그래밍(Procedural Programming)
# F-35 01
F_35_id = 'F-32_01'
F_35_name = 'F-35'
F_35_nickname = 'Lightning II'
F_35_manufacturer = 'Lockheed Martin'
F_35_num = 890
F_35_role = ['스텔스기', '다목적 전투기']

# F-22 01
F_22_id = 'F-22_01'
F_22_name = 'F-22'
F_22_nickname = 'Raptor'
F_35_manufacturer = 'Lockheed Martin'
F_22_num = 195
F_22_role = ['스텔스 전투기', '다용도 전술 전투기']

# F-15 01
F_15_id = 'F-15_01'
F_15_name = 'F-15'
F_15_nickname = 'Eagle'
F_15_manufacturer = 'McDonnell Douglas'
F_15_num = 1198
F_15_role = ['제공 전투기', '다목적 전폭기']


# 리스트 구조료 정리
# 관리하기 어려움 -> list의 index를 정확하게 매핑해서 사용해야함
plane_id_list = ['F-32_01', 'F-22_01', 'F-15_01']
plane_name_list = ['F-35', 'F-22', 'F-15']
plane_nickname_list = ['Lightning II', 'Raptor', 'Eagle']
plane_manufacturer_list = ['Lockheed Martin', 'Lockheed Martin', 'McDonnell Douglas']
plane_num_list = [890, 195, 1198]
plane_role_list = [
    ['스텔스기', '다목적 전투기'],
    ['스텔스 전투기', '다용도 전술 전투기'],
    ['제공 전투기', '다목적 전폭기']
]

plane_id_list[1] = 'F-4_01'
plane_name_list[1] = 'F-4'
plane_nickname_list[1] = 'Phantom'
plane_manufacturer_list[1] = 'McDonnell Douglas'
plane_num_list[1] = 5195
plane_role_list[1] = ['전폭기']

print(plane_id_list)         # ['F-32_01', 'F-4_01', 'F-15_01']
print(plane_name_list)       # ['F-35', 'F-4', 'F-15']
print(plane_nickname_list)      # ['Lightning II', 'Phantom', 'Eagle']
print(plane_manufacturer_list)     # ['Lockheed Martin', 'McDonnell Douglas', 'McDonnell Douglas']
print(plane_num_list)        # [890, 5195, 1198]
print(plane_role_list)   # [['스텔스기', '다목적 전투기'], ['전폭기'], ['제공 전투기', '다목적 전폭기']]

# F_22 삭제가 있을 경우, list의 index를 정확하게 매핑해야함
del plane_id_list[1]
del plane_name_list[1]
del plane_nickname_list[1]
del plane_manufacturer_list[1]
del plane_num_list[1]
del plane_role_list[1]

print(plane_id_list)         # ['F-32_01', 'F-15_01']
print(plane_name_list)       # ['F-35', 'F-15']
print(plane_nickname_list)     # ['Lightning II', 'Eagle']
print(plane_manufacturer_list)        # ['Lockheed Martin', 'McDonnell Douglas']
print(plane_num_list)   # [890, 1198]
print(plane_role_list) # [['스텔스기', '다목적 전투기'], ['제공 전투기', '다목적 전폭기']]


plane_dict = [
    {'plane_id': 'F-35_01', 'plane_name': 'F-35'},
    {'plane_id': 'F-22_02', 'plane_name': 'F-22'},
    {'plane_id': 'F-15_03', 'plane_name': 'F-15'}
]
print(plane_dict)
[{'plane_id': 'F-35_01', 'plane_name': 'F-35'}, {'plane_id': 'F-22_02', 'plane_name': 'F-22'}, {'plane_id': 'F-15_03', 'plane_name': 'F-15'}]

del plane_dict[1]
print(plane_dict)
# [{'plane_id': 'F-35_01', 'plane_name': 'F-35'}, {'plane_id': 'F-15_03', 'plane_name': 'F-15'}]


class Plane:
    def __init__(self, id: str, name: str, nickname: str, num: int, manufacturer: str, role:List[str]):
        self.__id = id
        self.__id = id
        self.__name = name
        self.__nickname = nickname
        self.__manufacturer = manufacturer
        self.__num = num
        self.__role = role

    def __str__(self):
        return f'str : {self.__name} {self.__nickname} - {self.__id}'

    def __repr__(self):
        return f'repr : {self.__name} {self.__nickname} - {self.__id}'

    def fly(self):
        # assume some codes implemented
        pass

    def landing(self):
        # assume some codes implemented
        pass


F_35 = Plane('F-35_01', 'F-35', 'Lightning II', 890, 'Lockheed Martin', ['스텔스기', '다목적 전투기'])
F_22 = Plane('F-22_01', 'F-22', 'Raptor', 195, 'Lockheed Martin', ['스텔스 전투기', '다용도 전술 전투기'])
F_15 = Plane('F-15_01', 'F-15', 'Eagle', 1198, 'McDonnell Douglas', ['제공 전투기', '다목적 전폭기'])

print(F_35)   # str : F-35 Lightning II - F-35_01
print(F_22)   # str : F-22 Raptor - F-22_01
print(F_15)   # str : str : F-15 Eagle - F-15_01

print(F_35.__dict__)
# {'_Plane__id': 'F-35_01', '_Plane__name': 'F-35', '_Plane__nickname': 'Lightning II', '_Plane__manufacturer': 'Lockheed Martin', '_Plane__num': 890, '_Plane__role': ['스텔스기', '다목적 전투기']}
print(F_22.__dict__)
# {'_Plane__id': 'F-22_01', '_Plane__name': 'F-22', '_Plane__nickname': 'Raptor', '_Plane__manufacturer': 'Lockheed Martin', '_Plane__num': 195, '_Plane__role': ['스텔스 전투기', '다용도 전술 전투기']}
print(F_15.__dict__)
# {'_Plane__id': 'F-15_01', '_Plane__name': 'F-15', '_Plane__nickname': 'Eagle', '_Plane__manufacturer': 'McDonnell Douglas', '_Plane__num': 1198, '_Plane__role': ['제공 전투기', '다목적 전폭기']}

user_list = []
user_list.append(F_35)
user_list.append(F_22)
user_list.append(F_15)

print()
print()
print(user_list)    # [repr : F-35 Lightning II - F-35_01, repr : F-22 Raptor - F-22_01, repr : F-15 Eagle - F-15_01]

for user in user_list:
    print(repr(user))
    print(user)

# repr : F-35 Lightning II - F-35_01
# str : F-35 Lightning II - F-35_01
# repr : F-22 Raptor - F-22_01
# str : F-22 Raptor - F-22_01
# repr : F-15 Eagle - F-15_01
# str : F-15 Eagle - F-15_01