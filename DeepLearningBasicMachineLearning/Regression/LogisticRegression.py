# -*- coding:utf-8 -*-
import numpy as np
import random
from numpy import gradient

#
def gradientDescent(x,y,theta,alpha,m,numIterations):
    xTrans = x.transpose()#求矩阵的转置
    for i in range(0,numIterations):#循环次数
        hypothesis = np.dot(x,theta)#内积x * theta
        loss = hypothesis - y
        cost = np.sum(loss ** 2)/(2 *m)
        print("Iteration %d | cost: %f"%(i,cost))
        
        gradient = np.dot(xTrans,loss)/m
        
        theta = theta - alpha * gradient
    return theta

def genData(numPoints,bias,variance):
    x = np.zeros(shape = (numPoints,2))
    y = np.zeros(shape = numPoints)
    
    for i in range(0,numPoints):
        x[i][0] = 1
        x[i][1] = i
        
        y[i] = (i + bias) + random.uniform(0,1)*variance
        
    return x,y

x,y = genData(100,25,10)
# print "x:"
# print x
# print "y:"
# print y
m,n = np.shape(x)
n_y = np.shape(y)

print "x shape:",str(m)," ",str(n)
print "y length:",str(n_y)
 
 
numIterations = 100000
alpha = 0.0005
theta = np.ones(n)
theta = gradientDescent(x, y, theta, alpha, m, numIterations)
print theta

 
        
        