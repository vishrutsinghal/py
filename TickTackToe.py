import sys

rules = '''
'top-L': 1, 'top-M': 2, 'top-R': 3,
'mid-L': 4, 'mid-M': 5, 'mid-R': 6,
'low-L': 7, 'low-M': 8, 'low-R': 9
'''
print(rules)

theBoard = {'top-L': ' ', 'top-M': ' ', 'top-R': ' ',
            'mid-L': ' ', 'mid-M': ' ', 'mid-R': ' ',
            'low-L': ' ', 'low-M': ' ', 'low-R': ' '}

turn = "X"
flag = 1

def printboard(board):
    print(board["top-L"] + "|" + board["top-M"] + "|" + board["top-R"])
    print("-+-+-")
    print(board["mid-L"] + "|" + board["mid-M"] + "|" + board["mid-R"])
    print("-+-+-")
    print(board["low-L"] + "|" + board["low-M"] + "|" + board["low-R"])
    print("-+-+-")

def value_check(move, turn):

    val1 = [theBoard[val] for val in theBoard]
    if " " not in val1:
        print(" match is draw: NICE GAME")
    if theBoard[move] == ' ':
        theBoard[move] = turn
        print("value of turn : ", turn)
        if turn == "X":
            turn = "O"
            return turn
        else:
            turn = "X"
            return turn
    else:
        print(" This field already contains a value choose different. NO CHEATING!!!!!!!!")
        if turn == "X":
            turn = "X"
            return turn
        else:
            turn = "O"
            return turn 

while True:

    print('Turn for ' + turn + '. Move on which space?')
    printboard(theBoard)
    move = input()
    if move == "1":
        move = "top-L"
        turn = value_check(move, turn)

    if move == "2":
        move = "top-M"
        turn = value_check(move, turn)

    if move == "3":
        move = "top-R"
        turn = value_check(move, turn)

    if move == "4":
        move = "mid-L"
        turn = value_check(move, turn)

    if move == "5":
        move = "mid-M"
        turn = value_check(move, turn)

    if move == "6":
        move = "mid-R"
        turn = value_check(move, turn)

    if move == "7":
        move = "low-L"
        turn = value_check(move, turn)

    if move == "8":
        move = "low-M"
        turn = value_check(move, turn)

    if move == "9":
        move = "low-R"
        turn = value_check(move, turn)

    if (theBoard["top-L"] != " " and theBoard["top-M"] != " " and theBoard["top-R"] != " ") and (theBoard["top-L"] == theBoard["top-M"] == theBoard["top-R"]):
        print ("CONGRATS u r a winner")
        break
    elif (theBoard["mid-L"] != " " and theBoard["mid-M"] != " " and theBoard["mid-R"] != " ") and (theBoard["mid-L"] == theBoard["mid-M"] == theBoard["mid-R"]):
        print ("CONGRATS u r a winner")
        break
    elif (theBoard["low-L"] != " " and theBoard["low-M"] != " " and theBoard["low-R"] != " ") and (theBoard["low-L"] == theBoard["low-M"] == theBoard["low-R"]):
        print ("CONGRATS u r a winner")
        break
    # left cross
    elif (theBoard["top-L"] != " " and theBoard["mid-M"] != " " and theBoard["low-R"] != " ") and (theBoard["top-L"] == theBoard["mid-M"] == theBoard["low-R"]):
        print ("CONGRATS u r a winner")
        break
     # right cross
    elif (theBoard["top-R"] != " " and theBoard["mid-M"] != " " and theBoard["low-L"] != " ") and (theBoard["top-R"] == theBoard["mid-M"] == theBoard["low-L"]):
        print ("CONGRATS u r a winner")
        break
    # left horizontal
    elif (theBoard["top-L"] != " " and theBoard["mid-L"] != " " and theBoard["low-L"] != " ") and (theBoard["top-L"] == theBoard["mid-L"] == theBoard["low-L"]):
        print ("CONGRATS u r a winner")
        break
    # middle horizontal
    elif (theBoard["top-M"] != " " and theBoard["mid-M"] != " " and theBoard["low-M"] != " ") and (theBoard["top-M"] == theBoard["mid-M"] == theBoard["low-M"]):
        print ("CONGRATS u r a winner")
        break
    # right horizontal
    elif (theBoard["top-R"] != " " and theBoard["mid-R"] != " " and theBoard["low-R"] != " ") and (theBoard["top-R"] == theBoard["mid-R"] == theBoard["low-R"]):
        print ("CONGRATS u r a winner")
        break
    # else:
    #     print (" match is drawn----------")
    #     break

printboard(theBoard)
