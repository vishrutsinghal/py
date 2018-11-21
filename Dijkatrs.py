# import sys
# def shortestpath(graph,start,end,visited=[],distances= {},predecessors={}, path = []):
#     path = path + [start]
#     visited = visited + [start]
#     distances =graph[start][node]
#     if start == end:
#         # print("path ", path)
#         # print("visited nodes ", visited)
#         # print("distances ", distances[node])
#     if not graph[start]:
#         return None
#     for node in graph[start]:
#         if node not in visited:
#             distances = 


# if __name__ == "__main__":
#     graph = {'a': {'a':0,'c': 3, 'b': 7},
#             'b': {'a':7,'e': 6, 'c': 1, 'd':2},
#             'c': {'a': 3, 'b': 1, 'd': 2},
#             'd': {'c': 2, 'b': 12, 'e': 4},
#             'e': {'b': 6, 'd': 4}}
#     print (shortestpath(graph,'a','a'))




# visited= ["b"]
graph = {'a': {'a':0,'c': 3, 'b': 7},
        'b': {'a':7,'e': 6, 'c': 1, 'd':2},
        'c': {'a': 3, 'b': 1, 'd': 2},
        'd': {'c': 2, 'b': 12, 'e': 4},
        'e': {'b': 6, 'd': 4}}

for node in graph["a"]:
    print (node)
# distances = graph["a"][visited]
# print(distances)






    if start==end:
        path=[]
        while end != None:
            path.append(end)
            end=predecessors.get(end,None)
        return distances[start], path[::-1]
    # detect if it's the first time through, set current distance to zero
    if not visited: distances[start]=0
    # process neighbors as per algorithm, keep track of predecessors
    for neighbor in graph[start]:
        if neighbor not in visited:
            neighbordist = distances.get(neighbor,sys.maxsize)
            tentativedist = distances[start] + graph[start][neighbor]
            if tentativedist < neighbordist:
                distances[neighbor] = tentativedist
                predecessors[neighbor]=start
    # neighbors processed, now mark the current node as visited
    visited.append(start)
    # finds the closest unvisited node to the start
    unvisiteds = dict((k, distances.get(k,sys.maxsize)) for k in graph if k not in visited)
    closestnode = min(unvisiteds, key=unvisiteds.get)
    # now we can take the closest node and recurse, making it current
    return shortestpath(graph,closestnode,end,visited,distances,predecessors)

if __name__ == "__main__":
    graph = {'a': {'w': 14, 'x': 7, 'y': 9},
            'b': {'w': 9, 'z': 6},
            'w': {'a': 14, 'b': 9, 'y': 2},
            'x': {'a': 7, 'y': 10, 'z': 15},
            'y': {'a': 9, 'w': 2, 'x': 10, 'z': 11},
            'z': {'b': 6, 'x': 15, 'y': 11}}
    print (shortestpath(graph,'a','b'))
