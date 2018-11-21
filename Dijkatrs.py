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
