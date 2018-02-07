import json
import os

# path to json file
CWD = os.getcwd()
JSON_FILE_PATH = "%s/%s" %(CWD,"details.json")

#dictionary holding json values
DETAILS_DICT={}

#open json file and parsing the value and store them in dictionary

try:
    with open(JSON_FILE_PATH) as data_file:
        DETAILS_DICT = json.load(data_file)
except IOError as e:
    print(e)
    print ("IOError: unable to open json file: termonating execution")
    exit(1)

print (DETAILS_DICT)
print (DETAILS_DICT["first_name"])

