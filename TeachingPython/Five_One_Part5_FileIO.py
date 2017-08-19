# -*- coding:utf-8 -*-
'''
Created on 2017年6月15日

@author: Administrator
'''

#文件操作 输入输出流

#接受用户的输入：input()
#输入格式：str(),format

# str_1 = input("Enter a string: ")
# str_2 = input("Enter another string : ")
# 
# print("str_1 is :" + str_1 + ".str_2 is :" + str_2)
# print("str_1 is {} + str_2 is {}".format(str_1,str_2))


#文件的输入输出
# some_sentences = '''\
# I love learning phyton
# because python is fun
# and also easy to use
# '''
# #Open for 'w'irting
# f = open('sentences.txt','w')
# #write text to file
# f.write(some_sentences)
# f.close()

#open for reading
f = open('sentences.txt')
while True:
    line = f.readline()
    if len(line) == 0:
        break
    print(line)
f.close()


