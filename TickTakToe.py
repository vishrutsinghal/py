import sys

rules = '''

'top-L': 1, 'top-M': 2, 'top-R': 3,
'mid-L': 4, 'mid-M': 5, 'mid-R': 6,
'low-L': 7, 'low-M': 8, 'low-R': 9

'''


theBoard = {'top-L': ' ', 'top-M': ' ', 'top-R': ' ',
            'mid-L': ' ', 'mid-M': ' ', 'mid-R': ' ',
            'low-L': ' ', 'low-M': ' ', 'low-R': ' '}


print(rules)

turn = "X"
no_of_turn = 1


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
        print(" match is drawn: NICE GAME")
        return None

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

printboard(theBoard)
