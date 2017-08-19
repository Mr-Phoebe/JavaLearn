# -*-coding:utf-8-*-

'''
Created on 2017年6月21日

@author: Administrator
'''
from numpy import genfromtxt
import numpy as np
from sklearn import datasets,linear_model

datapath = r"./DeliveryDummyDone.csv"
deliveryData = genfromtxt(datapath,delimiter = ',')

print 'data'
print deliveryData

X = deliveryData[:,:-1]
y = deliveryData[:,-1]
 
print 'X'
print X
 
print "Y"
print y
 
regr = linear_model.LinearRegression()
regr.fit(X,y)
 
print "cofficients"
print regr.coef_
print "intercept:"
print regr.intercept_
 
# xPred = [102,6]
# yPred = regr.predict(xPred)
# print "predicted y:"
# print yPred

