capacity = []
adj = []
inf = 2**31-1



def bfs(src, sink, parent):
    for i in range(len(parent)):
        parent[i] = -1
    parent[src] = -2

    queue = []
    queue.append([src, inf])
    while queue:
        cur = queue.pop()

        for nxt in adj[cur[0]]:
            if parent[nxt] == -1 and capacity[cur[0]][nxt]:
                parent[nxt] = cur[0]
                new_flow = min(cur[1], capacity[cur[0]][nxt])

                if nxt == sink:
                    return new_flow
                
                queue.append([nxt, new_flow])

    return 0



def max_flow(src, sink):
    parent = [-1 for node in range(N)]
    flow = 0

    new_flow = bfs(src, sink, parent)
    while new_flow:
        flow += new_flow
        
        cur = sink
        while cur != src:
            nxt = parent[cur]
            capacity[nxt][cur] -= new_flow
            capacity[cur][nxt] += new_flow
            cur = nxt

        new_flow = bfs(src, sink, parent)

    return flow



N = 18

capacity = [[0 for col in range(N)] for row in range(N)]
adj = [[] for node in range(N)]


units = list(map(int, input().split()))
patients = list(map(int, input().split()))


adj[0].append(1)
adj[0].append(2)
adj[0].append(3)
adj[0].append(4)
adj[0].append(5)
adj[0].append(6)
adj[0].append(7)
adj[0].append(8)
capacity[0][1] = units[0]
capacity[0][2] = units[1]
capacity[0][3] = units[2]
capacity[0][4] = units[3]
capacity[0][5] = units[4]
capacity[0][6] = units[5]
capacity[0][7] = units[6]
capacity[0][8] = units[7]


#O- recieving
adj[1].append(9)

#O+ recieving
adj[1].append(10)
adj[2].append(10)

#A- recieving
adj[1].append(11)
adj[3].append(11)

#A+ recieving
adj[1].append(12)
adj[2].append(12)
adj[3].append(12)
adj[4].append(12)

#B- recieving
adj[1].append(13)
adj[5].append(13)

#B+ recieving
adj[1].append(14)
adj[2].append(14)
adj[5].append(14)
adj[6].append(14)

#AB- recieving
adj[1].append(15)
adj[3].append(15)
adj[5].append(15)
adj[7].append(15)

#AB+ recieving
adj[1].append(16)
adj[2].append(16)
adj[3].append(16)
adj[4].append(16)
adj[5].append(16)
adj[6].append(16)
adj[7].append(16)
adj[8].append(16)


#O- recieving
capacity[1][9] = inf

#O+ recieving
capacity[1][10] = inf
capacity[2][10] = inf

#A- recieving
capacity[1][11] = inf
capacity[3][11] = inf

#A+ recieving
capacity[1][12] = inf
capacity[2][12] = inf
capacity[3][12] = inf
capacity[4][12] = inf

#B- recieving
capacity[1][13] = inf
capacity[5][13] = inf

#B+ recieving
capacity[1][14] = inf
capacity[2][14] = inf
capacity[5][14] = inf
capacity[6][14] = inf

#AB- recieving
capacity[1][15] = inf
capacity[3][15] = inf
capacity[5][15] = inf
capacity[7][15] = inf

#AB+ recieving
capacity[1][16] = inf
capacity[2][16] = inf
capacity[3][16] = inf
capacity[4][16] = inf
capacity[5][16] = inf
capacity[6][16] = inf
capacity[7][16] = inf
capacity[8][16] = inf



adj[9].append(17)
adj[10].append(17)
adj[11].append(17)
adj[12].append(17)
adj[13].append(17)
adj[14].append(17)
adj[15].append(17)
adj[16].append(17)
capacity[9][17] = patients[0]
capacity[10][17] = patients[1]
capacity[11][17] = patients[2]
capacity[12][17] = patients[3]
capacity[13][17] = patients[4]
capacity[14][17] = patients[5]
capacity[15][17] = patients[6]
capacity[16][17] = patients[7]


for cur in range(N):
    for nxt in adj[cur]:
        if cur not in adj[nxt]:
            adj[nxt].append(cur)



src, sink = 0, 17
print(max_flow(src, sink))