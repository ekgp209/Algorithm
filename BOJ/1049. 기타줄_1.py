# 1차원 리스트 사용
N, M = map(int, input().split())
price_six = []
price_one = []
tot = 0

for i in range(M):
    a, b = map(int, input().split())
    price_six.append(a)
    price_one.append(b)

min1 = min(price_six)
min2 = min(price_one)

if min2 * 6 <= min1:
    tot = N * min2
else:
    if min1 < (N % 6) * min2:
        tot = (N//6) * min1 + min1
    else:
        tot = (N//6) * min1 + (N % 6) * min2

print(tot)
