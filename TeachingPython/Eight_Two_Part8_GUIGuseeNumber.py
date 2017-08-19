# -*- coding:utf-8 -*-
'''
Created on 2017年6月16日

@author: Administrator
'''
from tkinter import *

import tkinter.simpledialog as dl
import tkinter.messagebox as mb

#设置GUI
root = Tk()
w = Label(root,text = "Guess Number Game")
w.pack()

#设置消息
mb.showinfo("Welcome","Welcome to Guess Number Game")

#处理消息
number = 59

while True:
    guess = dl.askinteger("Number", "What's your guess?")
    if guess == number:
        output = 'Bingo! you guessed it right,but you do not win any prize!'
        mb.showinfo("Hint", output)
        break
    elif guess<number:
        output = "No,the number is a higher than that"
        mb.showinfo("Hint:", output)
    else:
        output = "No, the umber is a lower than that"
        mb.showinfo("Hint:", output)
print("Done")        