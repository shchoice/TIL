class Robot:

    """
    [Robot Class]
    Date : ??:??:??
    Author : Amaco
    """
    population = 0

    def __init__(self, name):
        self.name = name
        Robot.population += 1

    def die(self):
        print(f"{self.name} is being destroyed!")
        Robot.population -= 1
        if Robot.population == 0:
            print(f"{self.name} was the last one.")
        else:
            print(f"There are still {Robot.population} robots working.")

    def say_hi(self):
        print(f"Greetings, my masters call me {self.name}.")

    def cal_add(self, a, b):
        return a + b

    @classmethod
    def how_many(cls):
        return f"We have {cls.population} robots."

    @staticmethod
    def are_you_robot():
        print("yes!!")

    def __str__(self):
        return f"{self.name} robot!!"

    def __call__(self):
        print("call!")
        return f"{self.name} call!!"


droid1 = Robot("R2-D2")
droid1.say_hi()
# Greetings, my masters call me R2-D2.

print(dir(droid1))
# ['__call__', '__class__', '__delattr__', '__dict__', '__dir__', '__doc__', '__eq__', '__format__', '__ge__',
# '__getattribute__', '__gt__', '__hash__', '__init__', '__init_subclass__', '__le__', '__lt__', '__module__', '__ne__',
# '__new__', '__reduce__', '__reduce_ex__', '__repr__', '__setattr__', '__sizeof__', '__str__', '__subclasshook__',
# '__weakref__', 'are_you_robot', 'cal_add', 'die', 'how_many', 'name', 'population', 'say_hi']

print(droid1.__str__)
# <bound method Robot.__str__ of <__main__.Robot object at 0x7f899030ef10>>
print(droid1.__str__())
# R2-D2 robot!!
print(droid1)
# R2-D2 robot!!

droid1() # __call__ 이 없으면 TypeError가 발생 <- 함수에서 fcun() 가 된다는 것은 __call__이 있다는 것
# call!
