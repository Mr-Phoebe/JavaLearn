# -*- coding:utf-8 -*-
'''
Created on 2017年6月18日

@author: Administrator
'''

from sklearn import neighbors
from sklearn import datasets

knn = neighbors.KNeighborsClassifier()#kNN分类器

iris = datasets.load_iris()#导入数据

print iris

knn.fit(iris.data,iris.target)#进行建模

predictedLabel = knn.predict([[0.1,0.2,0.3,0.4]])#进行预测

print predictedLabel#打印预测结果