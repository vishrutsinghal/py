# def find_sum_pair_unsorted(sum, l=[]):
# 	diff_list = []
# 	pair_list= []
# 	for i in range (len(l)):
# 		temp = sum - l[i]
# 		if temp <= sum and temp in diff_list:
# 			pair_list.append((temp, l[i]))
# 		else:
# 			diff_list.append(l[i])
# 	return (pair_list)

# f= find_sum_pair_unsorted(8, [1,3,2,5,4,7,4])
# print(f)



# def find_sum_pair_unsorted(sum, l=[]):
# 	diff_list = []
# 	pair_list= []
# 	for i in range (len(l)):
# 		temp = sum - l[i]
# 		if temp <= sum and temp in diff_list:
# 			return (temp, l[i])
# 		else:
# 			diff_list.append(l[i])

# f= find_sum_pair_unsorted(8, [1,3,2,5,4,7,4])
# print(f)

