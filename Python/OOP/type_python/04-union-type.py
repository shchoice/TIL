from typing import Union

xxx: Union[int, str] = 3

xxx = "17"


def foo(x: Union[int, str]) -> Union[int, str]:
    return x


foo(xxx)
