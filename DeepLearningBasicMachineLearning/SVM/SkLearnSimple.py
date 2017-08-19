#-*-coding:utf-8-*-
'''
Created on 2017年6月18日

@author: Administrator
'''
print(__doc__)

import numpy as np
import pylab as pl
from sklearn import svm

#we create 40 separable points
np.random.seed(0)#随机函数的随机种子
#通过正态分布产生一系列的数
X = np.r_[np.random.randn(20,2)-[2,2],np.random.randn(20,2)+[2,2]]
Y = [0]*20 + [1]*20

#fit the model
clf = svm.SVC(kernel='linear')
clf.fit(X,Y)

#get the separating hyperplane
w = clf.coef_[0]
a = -w[0]/w[1]
xx = np.linspace(-5,5)#从-5到5产生一些值
yy = a * xx - (clf.intercept_[0])/w[1]

#plot the parallels to the separating hyperplane that pass through the support vectors
b = clf.support_vectors_[0]
yy_down = a * xx + (b[1]- a * b[0])
b = clf.support_vectors_[-1]
yy_up = a * xx + (b[1] - a * b[0])


print "w: ",w
print "a: ",a
print "support_vectors_: ",clf.support_vectors_
print "clf.coef_: ",clf.coef_


pl.plot(xx,yy,'k-')
pl.plot(xx,yy_down,'k--')
pl.plot(xx,yy_up,'k--')
#画的是超平面上的点
pl.scatter(clf.support_vectors_[:,0],clf.support_vectors_[:,1],s = 80,facecolors = 'none')
#画的是正常的点
pl.scatter(X[:,0],X[:,1],c = Y,cmap = pl.cm.Paired)

pl.axis('tight')
pl.show()

