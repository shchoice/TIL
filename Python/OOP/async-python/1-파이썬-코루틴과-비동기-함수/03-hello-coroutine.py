# 코루틴 hello world!
# https://docs.python.org/ko/3/library/asyncio-task.html

import asyncio

def hello_main_routine():
    print('Hello main routine!')


async def hello_coroutine():
    print("hello world")
    return 123


if __name__ == "__main__":
    print(hello_main_routine())
    # Hello main routine!
    # None
    print(hello_coroutine())
    asyncio.run(hello_coroutine())
