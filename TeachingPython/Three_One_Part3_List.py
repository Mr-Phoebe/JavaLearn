# -*- coding:utf-8 -*-
'''
Created on 2017年6月15日

@author: Administrator
'''
#print换行符还是用\n与C/C++相同
from traceback import print_list
# print("你好\nWho am I?")

#创建list

number_list = [1,2,3,4,5,6,7,8,9]
#print 的输出需要相同的类型，所以把number_list 转换成string形式
# print("number_list:\n" + str(number_list))

#创建string_list
string_list = ["abc","bbc","Python"]

# print("string_list:\n"+str(string_list))

#创建mixed_list

mixed_list = ["Python",1,2,3,"I Love You"]

# print("mixed_list:\n"+str(mixed_list))


#访问列表中的元素
second_number = number_list[1]
print(second_number)

third_string = string_list[2]

print(third_string)

fourth_mixed = mixed_list[3]
print(fourth_mixed)

print("second_num:{0} \nthird_string:{1} \nfourth_mix:{2}".format(second_number,third_string,fourth_mixed))

#更新列表中的元素

number_list[1] = 30

print("number_list after: " + str(number_list))

#删除list中的内容
del number_list[1]

print("number_list del after:"+str(number_list))


#python 脚本语言

print(len([1,2,3]))#长度
print([1,2,3]+[4,5,6])#连和
print(['Hello '*4])
print(3 in[1,2,3])


abcd_list = ['a','b','c','d']
print(abcd_list[1])
print(abcd_list[-2])
print(abcd_list[1:])