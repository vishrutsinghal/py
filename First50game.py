'''
1. define players in ordered dictionary
2. Accept number of users and name
3. Accept keyboard keys
4. define logic for switch based on Y and N
5. define logic for random 0

'''
from collections import OrderedDict
from random import randint

dict = OrderedDict()
min, max = 1, 6
player = None
index = 0
mmax_score = 50

player_count = int(input("Enter number of players to participate "))
scores = [0] * player_count

for i in range(player_count):
    player_name = input("Enter player name ")
    create_player_key = "Player_" + player_name
    dict[create_player_key] = 0
print(dict)

key_list = list(dict.keys())


def players_score():
    for key, value in dict.items():
        print(key, " : ", value)

for key, value in dict.items():
    try:
        while dict[key] < mmax_score:
            print("printing dict key and value ", key, "  ", dict[key])
            player_response = input("Press Y to continue or press N to submit score: ")
            if player_response.upper() == "Y":
                player = key
                roll_num = randint(min, max)
                print("Roll diced ", roll_num)
                # ''' checking for random value 0'''
                if roll_num == 1:
                    dict[key] = 0
                    index = index + 1
                    if index < len(key_list):
                        key = key_list[index]
                    else:
                        index = 0
                        key = key_list[index]
                    key = key_list[index]
                    roll_num = 0
                new_score = dict[key] + roll_num
                dict[key] = new_score
                players_score()

            elif player_response.upper() == "N":
                index = index + 1
                if index < len(key_list):
                    key = key_list[index]
                else:
                    index = 0
                    key = key_list[index]
        else:
            print("Winner is ", key)
            break
    except:
        break
