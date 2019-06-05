from functools import reduce
import random


# a = int(input('a = '))
# b = int(input('b = '))
# print('%d + %d = %d' % (a, b, a + b))


# a = 100
# b = 12.345
# c = 1 + 5j
# d = 'hello world'
# e = True
# print(type(a))
# print(type(b))
# print(type(c))
# print(type(d))
# print(type(e))

# 华氏温度转摄氏温度
def f1():
    a = float(input('请输入华氏温度:'))
    b = (a - 32) / 1.8
    print("华氏温度%.1f转为摄氏温度为:%.1f" % (a, b))


def f2():
    a = int(input('请输入年份：'))
    if a % 4 == 0 and a % 100 != 0 or a % 400 == 0:
        print(True)
    print(False)


def f3():
    n = random.randint(1, 100)
    counter = 0
    while True:
        num = int(input("请输入一个1-100之内的整数："))
        counter += 1
        if num < n:
            print("猜的太小了")
        elif num > n:
            print("猜的太大了")
        else:
            print("恭喜你猜对了")
            break
    print("你一共猜了%d次" % counter)
    if counter > 7:
        print("你太弱了")


if __name__ == '__main__':
    f3()
