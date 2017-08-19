# -*- coding:utf-8 -*-
'''
Created on 2017年6月16日

@author: Administrator
'''
from tkinter import *
import tkinter.simpledialog as dl
import tkinter.messagebox as mb

#tkinter GUI Input Output Example
#GUI 设置

root= Tk()
w = Label(root,text = 'Label Title')
w.pack()

#设置消息
mb.showinfo("Welcome", "welcome Title")
 
guess = dl.askinteger("Number", "Enter a number")
 
output = "This is output message"
mb.showinfo("Output",output)