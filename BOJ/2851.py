score = []
sum = 0
sum_under = 0

for i in range(10):
    score.append(int(input()))

for i in range(len(score)):
    sum += score[i]
    if sum > 100:
        sum_under = sum - score[i]
        break

if abs(100-sum) == abs(100-sum_under):
    print(sum)
else:
    if abs(100-sum) < abs(100-sum_under):
        print(sum)
    else:
        print(sum_under)
