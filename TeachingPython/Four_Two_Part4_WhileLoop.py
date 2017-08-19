# -*- coding:utf-8 -*-
'''
Created on 2017年6月15日

@author: Administrator
'''
#while Loop 

# number = 59
# guess_flag = False
# while guess_flag == False:
#     guess = int(input('Enter an integer : '))
#     if guess == number:
#         guess_flag = True
#     elif guess < number:
#         print('No ,the number is higher than that')
#     else:
#         print('No, the number is a lower than that')
# 
# print('Bingo! you guessed it right.')
# print('(but you not win any prizes!)')     
# print('Done')  


#for example

number = 59
number_changes = 3
print("you have only 3 chances tp guess ")

for i in range(1,number_changes + 1):
    print("chance " + str(i))
    guess = int(input('Enter an integer : '))
    if guess == number:
        print('Bingo! you guessed it right.')
        print('(but you not win any prizes!)') 
        break
    elif guess < number:
        print('No ,the number is higher than that')
    else:
        print('No, the number is a lower than that')
 
  
print('Done')  
