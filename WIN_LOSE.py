# import sys
# import itertools

# def Battle():
#     flag = False
#     params = iter(sys.argv)
#     params.__next__()
#     total_testcases = int(params.__next__())
#     for _ in range(total_testcases):
#         players_count = int(params.__next__())
#         villan_list = list(map(int, itertools.islice(params,players_count)))
#         heros_list  = list(map(int, itertools.islice(params,players_count)))

#         villan_list.sort()
#         heros_list.sort()

#         for (v, h) in zip(villan_list, heros_list):
#             if v>h:
#                 flag = False
#                 print("LOSE")
#                 break
#             else:
#                 flag = True

#         if flag:
#             print("WIN")

# Battle()


