# -*- coding:utf-8 -*-
'''
Created on 2017年6月18日

@author: Administrator
'''
from sklearn import svm
x = [[2,0],[1,1],[2,3]]
y = [0,0,1]
clf = svm.SVC(kernel = 'linear')#使用的是线性的核函数
clf.fit(x,y)#分类器fit，建立的Lis特征向量值和区域划分
print clf

print clf.support_vectors_

print clf.support_

print clf.n_support_

print clf.predict([0,0])