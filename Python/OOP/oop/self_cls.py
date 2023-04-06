# [self의 이해]
# ** self는 인스턴스 객체이다!!
# ** 클래스 안에 있는 self의 주소와 만들어진 인스턴스의 주소는 같다! 즉, self는 인스턴스 그 자체이다!
class SelfTest:

    # 클래스 변수
    name = "shchoi"

    def __init__(self, x):
        self.x = x  # 인스턴스 변수

    # 클래스 메서드
    @classmethod
    def func1(cls):
        print(f"cls: {cls}")
        print("cls 주소 : ", id(cls))
        print("func1")

    # 인스턴스 메서드
    def func2(self):
        print(f"self : {self}")
        print("class안의 Self 주소 : ", id(self))
        print("func2")


test_obj = SelfTest(17)
print("인스턴스의 주소 : ", id(test_obj))
# 인스턴스의 주소 :  140479935999904

test_obj.func2()
# self : <__main__.SelfTest object at 0x7fc408aeefa0>
# class안의 Self 주소 :  140479935999904
# func2

print("SelfTest 주소 : ", id(SelfTest))
# SelfTest 주소 :  140480327630800

SelfTest.func1()
# cls: <class '__main__.SelfTest'>
# cls 주소 :  140480327630800
# func1

test_obj.func1()
# cls: <class '__main__.SelfTest'>
# cls 주소 :  140480327630800
# func1

# 에러 발생1
#SelfTest.func2()
# TypeError: func2() missing 1 required positional argument: 'self'

# 에러 발생2
#print(SelfTest.x)
# AttributeError: type object 'SelfTest' has no attribute 'x'
print(test_obj.name)
# shchoi
print(SelfTest.name)
# shchoi