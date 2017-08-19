# -*- coding:utf-8 -*-
'''
Created on 2017年6月15日

@author: Administrator
'''

# number = 59
# guess = int(input('Enter an integer:'))
# 
# if guess == number:
#     print('Bingo! you guessed it right.')
#     print('(but you not win any prizes!)')
# elif guess < number:
#     print('No ,the number is higher than that')
# else:
#     print('No, the number is a lower than that')
#     
# print('Done')  



# for i in range(1,10):
#     print(i)
# else:
#     print("The for loop is over!")
# 
# 
# a_list = [1,3,5,7,9]
# for i in a_list:
#     print(i)
    
# a_tuple = (1,3,5,7,9)
# for i in a_tuple:
#     print(i)
#     
a_dictionary = {'Tom':1,'Jerry':3,"Dan":4,"coof":5,"kuen":7}
# for i in a_dictionary:
#     print(str(i) + " : " + str(a_dictionary[i]))

for key,elem in a_dictionary.items():
    print(key,elem)
