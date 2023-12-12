class Robot:

    """
    [Robot Class]
    Author : 윤상석
    Role : ????
    """

    # 클래스 변수 : 인스턴스들이 공유하는 변수
    population = 0

    # 생성자 함수
    def __init__(self, name):
        self.name = name  # 인스턴스 변수
        Robot.population += 1

    # 인스턴스 메서드
    def say_hi(self):
        # code
        print(f"Greetings, my masters call me {self.name}.")

    # 인스턴스 메서드
    def cal_add(self, a, b):
        return a + b

    # 인스턴스 메서드
    def die(self):
        print(f"{self.name} is being destroyed!")
        Robot.population -= 1
        if Robot.population == 0:
            print(f"{self.name} was the last one.")
        else:
            print(f"There are still {Robot.population} robots working.")

    # 클래스 메서드
    @classmethod
    def how_many(cls):
        print(f"We have {cls.population} robots.")


siri = Robot("siri")  # {'name': 'siri'}
jarvis = Robot("jarvis")
bixby = Robot("bixby")

# Robot class 의 네임스페이스
print(Robot.__dict__)
# siri instance 의 네임스페이스
print(siri.__dict__)

print(jarvis.__dict__)

global count
count = 1


print(globals())