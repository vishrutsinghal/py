import json


with open("States.json") as f:
    data  =json.load(f)

state_list= list()
for state in data["states"]:
    state_list.append(state["name"])
print (state_list[1])
    # print (state["name"])

