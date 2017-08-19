#-*- coding: utf-8 -*-
'''
Created on 2017年6月15日

@author: Administrator
'''
#创建只包含一个元素的tuple
a_tuple = (2,)

#创建一个tuple中的list
mixed_tuple = (1,2,['a','b'])
print("mixed_tuple :" + str(mixed_tuple))


#修改tuple中的list元素
mixed_tuple[2][0] = 'c'
mixed_tuple[2][1] = 'd'

print("mixed_tuple :" + str(mixed_tuple))
