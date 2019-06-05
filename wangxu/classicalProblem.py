def f(n):
    if n == 1:
        return 1
    return n * f(n - 1)


li = []


def g(n, s):
    if n == 0:
        li.append(s)
        return
    g(n - 1, s + '0')
    g(n - 1, s + '1')


w = [35, 30, 6, 50, 40, 10, 25]
v = [10, 40, 30, 50, 35, 40, 30]
M = 150

def h(n, sw, sv, s):
    if n < 0:
        if sw < 150:
            print(s + ':' + str(sv))
        return
    h(n - 1, sw, sv, s + '0')
    h(n - 1, sw + w[n], sv + v[n], s + '1')


if __name__ == '__main__':
    # print(f(5))
    # g(7, '')
    # print(li)
    h(6, 0, 0, '')
