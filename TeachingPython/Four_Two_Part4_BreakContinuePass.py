# -*- coding:utf-8 -*-
'''
Created on 2017年6月15日

@author: Administrator
'''

#break and continue
# number = 59
# 
# while True:
#     guess = int(input('Enter an integer:'))
#     if guess == number:
#         break
#     elif guess < number:
#         print('No ,the number is higher than that')
#         continue
#     else:
#         print('No, the number is a lower than that')
#         continue
# print('Bingo! you guessed it right.')
# print('(but you not win any prizes!)')     
# print('Done')  


#continue and pass different

a_list = [0,1,2]
print("using continue")
for i in a_list:
    if not i:
        continue
    print(i)
    
print("using pass")
for i in a_list:
    if not i:
        pass
    print(i)