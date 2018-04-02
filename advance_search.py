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
import tarfile
import zipfile


class advance_search():
    def __init__(self, path_list=[], user_input_set=set()):
        self.path_list = path_list
        self.user_input_set = user_input_set

    def find_file(self, root_folder, rex, count):
        self.flag = 0
        avoid_keyword = ["Recent", "Recycle", "AppData"]
        for root, dirs, files in os.walk(root_folder):
            for f in files:
                result = rex.search(f)
                if result:
                    self.read_data = os.path.join(root, f)
                    for i in avoid_keyword:
                        if re.search(i, self.read_data):
                            continue
                    self.flag = 1
                    self.path_list.append(self.read_data)
                    # print("path to file is : ", self.read_data)
        if self.drive_len == count:
            for i, en1 in enumerate(self.path_list):
                print(i, en1)

        if self.flag == 0:
            print("There is no such file in : ", root_folder)
        for root, dirs, files in os.walk(root_folder):
            for d in dirs:
                result = rex.search(d)
                if result:
                    self.locate_dir = os.path.join(root, d)
                    print("locating dir: ", self.locate_dir)

    def let_user_choose(self):
        if self.flag == 1:
            self.get_user_input(self.user_input_set)
            for i in self.user_input_set:
                path_no = self.path_list[int(i)]
                self.read_data = path_no
                split_loc = self.read_data.split(".")

                if split_loc[-1] == ("xlsx" or "xls"):
                    print("Inside the excel file: ")
                    self.launch_excel()
                if split_loc[-1] == "docx":
                    print("Inside doc file: ")
                    self.launch_word()
                if split_loc[-1] == "txt":
                    print("inside text file ")
                    self.launch_notepad()
                if split_loc[-1] == "zip":
                    print("way to extract zip file")
                    self.extract_zip()
                if split_loc[-1] == "tar":
                    print("way to extract tar file")
                    self.extract_tar()

    def tsplit(self, s, sep):
        stack = [s]
        for char in sep:
            pieces = []
            for substr in stack:
                pieces.extend(substr.split(char))
            stack = pieces
        return stack

    def get_user_input(self, a=set()):
        raw = input("enter multiple data: ")
        raww = set(raw)
        for i in raww:
            result = re.match("[0-9]", i)
            if result:
                self.user_input_set.add(i)
            elif not len(self.user_input_set):
                print("please enter correct input : ")
        return self.user_input_set

    def find_file_in_all_drives(self, file_name):
        # create a regular expression for the file
        rex = re.compile(file_name)
        drives = win32api.GetLogicalDriveStrings()
        drives = drives.split('\000')[:-1]
        self.drive_len = len(drives)
        count = 0
        for drive in win32api.GetLogicalDriveStrings().split('\000')[:-1]:
            count = count + 1
            self.find_file(drive, rex, count)

    def launch_excel(self):
        var = self.read_data

        split_data = self.tsplit(var, ("\\", ".", ":"))
        new_var = split_data[-2] + "(" + split_data[-3] + ")"
        new_path = var.replace(split_data[-2], new_var)
        os.rename(var, new_path)
        self.file_location = new_path

        xl = Dispatch("Excel.Application")
        xl.Visible = True
        wb = xl.Workbooks.Open(self.file_location)
        os.rename(new_path, self.file_location)
        print(" found excel file in the location ")

    def launch_word(self):
        var = self.read_data

        split_data = self.tsplit(var, ("\\", ".", ":"))
        new_var = split_data[-2] + "(" + split_data[-3] + ")"
        new_path = var.replace(split_data[-2], new_var)
        os.rename(var, new_path)
        self.file_location = new_path

        wordapp = win32com.client.gencache.EnsureDispatch("Word.Application")
        wordapp.Visible = True
        worddoc = wordapp.Documents.Open(self.file_location)
        os.rename(new_path, self.file_location)

        print(" found doc file")

    def launch_notepad(self):
        var = self.read_data

        split_data = self.tsplit(var, ("\\", ".", ":"))
        new_var = split_data[-2] + "(" + split_data[-3] + ")"
        new_path = var.replace(split_data[-2], new_var)
        os.rename(var, new_path)
        self.file_location = new_path
        # old_path = var
        # os.rename(new_path, old_path)

        subprocess.run(['notepad.exe', self.file_location])
        os.rename(new_path, var)
        print("this is after everything: ")

    def extract_zip(self):
        var = self.read_data
        self.file_location = var
        zip_ref = zipfile.ZipFile(self.file_location, 'r')
        zip_ref.extractall("C:\\Users\\vsinghal2\\Desktop")
        zip_ref.close()

        print("file extracted on path is: ", self.file_location)
        print('Data ready!')

    def extract_tar(self):
        var = self.read_data

        # split_data = self.tsplit(var, ("\\", ".", ":"))
        # new_var = split_data[-2] + "(" + split_data[-3] + ")"
        # new_path = var.replace(split_data[-2], new_var)
        # os.rename(var, new_path)
        # self.file_location = new_path

        tar = tarfile.open(self.file_location, "r:")
        tar.extractall("C:\\Users\\vsinghal2\\Desktop")
        tar.close()


if __name__ == '__main__':
    search = advance_search([], set())
    search.find_file_in_all_drives('advance_search')
    search.let_user_choose()
