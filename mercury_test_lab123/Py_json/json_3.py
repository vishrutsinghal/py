import json

people_string= '''
{
    "people":
    [
        {
            "name": "vishrut singhal",
            "phone": "9560606205",
            "emails": ["vishrutsinghal261@gmail.com", "ericartman751@gmail.com"],
            "has_license": "false"
        },
        {
            "name": "vibhor singhal",
            "phone": "123345566",
            "emails": null,
            "has_license": true
        }
    ]
} '''

data =json.loads(people_string)

people_list= list()
for person in data["people"]:
    people_list.append(person["name"])
print (people_list[1])