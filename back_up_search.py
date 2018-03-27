import os
import re
import win32api
from win32com.client import Dispatch
import pandas as pd
import openpyxl
from time import sleep
import win32com.client
from pywinauto.application import Application
import subprocess




class search:

    def find_file(self,root_folder, rex):
        self.path_list = []
        for root,dirs,files in os.walk(root_folder):
            for f in files:
                result = rex.search(f)
                if result:
                    self.read_data = os.path.join(root, f)
                    print("file location is : ", self.read_data)
                    split_loc = self.read_data.split(".")

                    if split_loc[-1] == ("xlsx" or "xls"):
                    # if ".xlsx" or ".xls" in self.read_data:
                        print ("Inside the excel file: ")
                        self.launch_excel()
                    if split_loc[-1] == "docx":
                    # elif ".docx" in self.read_data:
                        print ("Inside doc file: ")
                        self.launch_word()
                    if split_loc[-1] == "txt":
                        print ("inside text file ")
                        self.launch_notepad()


    def find_file_in_all_drives(self, file_name):
        #create a regular expression for the file
        rex = re.compile(file_name)
        for drive in win32api.GetLogicalDriveStrings().split('\000')[:-1]:
            self.find_file( drive, rex )
            

    def launch_excel(self):

        var = self.read_data
        self.file_location = var
        xl = Dispatch("Excel.Application")
        xl.Visible = True
        wb= xl.Workbooks.Open(self.file_location)

        print(" found excel file in the location ")

    def launch_word(self):

        var = self.read_data
        self.file_location = var
        wordapp = win32com.client.gencache.EnsureDispatch("Word.Application")
        wordapp.Visible = True
        worddoc = wordapp.Documents.Open(self.file_location)
        print(" found doc file")

    def launch_notepad(self):
        var = self.read_data
        self.file_location = var
        subprocess.run(['notepad.exe', self.file_location])



if __name__ == '__main__':
    search().find_file_in_all_drives( '123456' )
