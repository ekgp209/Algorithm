N, M = map(int, input().split())
P = list(map(int, input().split()))
q = [i for i in range(1, N+1)]
cnt = 0

for i in range(M):
    q_index = q.index(P[i])
    if q_index < len(q)-q_index:
        while True:
            if q[0] == P[i]:
                del q[0]
                break
            else:
                q.append(q[0])
                del q[0]
            cnt += 1
    else:
        while True:
            if q[0] == P[i]:
                del q[0]
                break
            else:
                q.insert(0, q[-1])
                del q[-1]
                cnt += 1
print(cnt)
