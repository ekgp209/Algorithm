from collections import deque

N, M = map(int, input().split())
P = list(map(int, input().split()))
q = deque([i for i in range(1, N+1)])
cnt = 0

for i in range(M):
    q_index = q.index(P[i])
    if q_index < len(q)-q_index:
        while True:
            if q[0] == P[i]:
                q.popleft()
                break
            else:
                q.append(q.popleft())
            cnt += 1
    else:
        while True:
            if q[0] == P[i]:
                q.popleft()
                break
            else:
                q.appendleft(q.pop())
                cnt += 1
print(cnt)
