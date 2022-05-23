X = int(input())
stick = 64
cnt = 0

while 0 < X:
    if X < stick:
        stick = stick/2
    else:
        cnt += 1
        X -= stick

print(cnt)
