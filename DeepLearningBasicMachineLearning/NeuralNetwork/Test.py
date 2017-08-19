# -*-coding:utf-8 -*-
'''
Created on 2017年6月20日

@author: Administrator
'''
import numpy as np
layers = [3,6,8,2,1]
weights = []

print len(layers)
for i in range(1,len(layers) -1):
    weights.append((2 *np.random.random((layers[i -1] + 1,layers[i])) - 1)*0.25) 
    weights.append((2 *np.random.random((layers[i] + 1,layers[i + 1])) - 1)*0.25)
    
print(weights)

print len(weights)




a = np.array([[1,1],[0,1]])
b = np.array([[2,0],[3,4]])

print a * b

print np.dot(a,b)

a = np.ones(3, dtype=np.int32)
print a

b = np.linspace(0,3.1415926,3)
print b 

c = a + b
print c 

d = np.exp(c * 1j)

print d


a = np.random.random((2,3))
print a
print a.sum()
#axis = 0表示列 axis = 1表示行
b = np.arange(12).reshape(3,4)
print (b)
print b.sum(axis=0)                            # sum of each column
print b.min(axis=1)                            # min of each row
print b.cumsum(axis=1)                         # cumulative sum along each row



