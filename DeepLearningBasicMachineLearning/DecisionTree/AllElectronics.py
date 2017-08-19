# -*- coding:utf-8 -*-
from sklearn.feature_extraction import DictVectorizer
import csv
from sklearn import preprocessing
from sklearn import tree
from sklearn.externals.six import StringIO

allElectronicsData = open(r'../AllElectronics.csv','rb')
reader = csv.reader(allElectronicsData)
headers = reader.next()
print(headers)


featureList = []
labelList = []

for row in reader:
    labelList.append(row[len(row)-1])
    rowDict = {}
    for i in range(1,len(row) -1):
        rowDict[headers[i]] = row[i]
    featureList.append(rowDict)#将字典追加到List中
print(featureList)
print(labelList)
#转化数据，利用DictVectorizer转换数据
vec = DictVectorizer()
dummyX = vec.fit_transform(featureList).toarray()
print('dummX:'+str(dummyX))

print(vec.get_feature_names())#获取特征的名字

print('labelList:'+ str(labelList))


lb= preprocessing.LabelBinarizer()
dummyY = lb.fit_transform(labelList)
print('dummyY:' + str(dummyY))

#构建树的节点
clf = tree.DecisionTreeClassifier(criterion='entropy')#使用信息熵的方法
clf = clf.fit(dummyX,dummyY)#进行建模处理
print('clf: ' + str(clf))

with open("allElectronicInformationGainOri.dot",'w')as f:
    f = tree.export_graphviz(clf, feature_names = vec.get_feature_names(),out_file = f)
oneRowX = dummyX[0,:]
print("oneRowX: " + str(oneRowX))

#输入新的数据，进行预测
newRowX = oneRowX
newRowX[0] = 1
newRowX[2] = 0
print('newRowX: ' + str(newRowX))#打印出预测值
 
predictedY = clf.predict(newRowX)
print("predictedY: " + str(predictedY))