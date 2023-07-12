from collections import deque

N, K = map(int, input().split())
q = deque()

for i in range(1, N+1):
    q.append(i)

li = []
while q:
    for i in range(K-1):
        q.append(q.popleft())
    li.append(q.popleft())


print("<", end="")
for i in range(len(li)-1):
    print("%d" % li[i], end=", ")
print(li[-1], end='')
print(">")
