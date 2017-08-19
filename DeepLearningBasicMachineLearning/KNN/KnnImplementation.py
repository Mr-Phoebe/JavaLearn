# -*- coding:utf-8 -*-
'''
Created on 2017年6月18日

@author: Administrator
'''
#自己实现KNN算法

import csv
import random
import math
import operator
#加载数据
def loadDataset(filename,split,trainingSet = [],testSet = []):
    with open(filename,'rb')as csvfile:
        lines = csv.reader(csvfile)
        dataset = list(lines)
        print(len(dataset))
        for x in range(len(dataset)-1):
            for y in range(4):
                dataset[x][y] = float(dataset[x][y])
            if random.random()< split:#数据进行随机分割，分为训练集和测试集
                trainingSet.append(dataset[x])
            else:
                testSet.append(dataset[x])
 #计算距离               
def euclideanDistance(instance1,instance2,length):
    distance = 0
    for x in range(length):
        distance += pow((instance1[x] - instance2[x]),2)
    return math.sqrt(distance)

#返回最近的K个邻居
def getNeighbors(trainingSet,testInstance,k):
    distances = []
    length = len(testInstance)-1
    for x in range(len(trainingSet)):
        dist = euclideanDistance(testInstance,trainingSet[x],length)
        distances.append((trainingSet[x],dist))
    distances.sort(key = operator.itemgetter(1))
    neighbors = []
    for x in range(k):
        neighbors.append(distances[x][0])
    return neighbors

def getResponse(neighbors):
    classVotes = {}
    for x in range(len(neighbors)):
        response = neighbors[x][-1]
        if response in classVotes:#统计分类的个数
            classVotes[response] +=1
        else:
            classVotes[response] = 1
    sortedVotes = sorted(classVotes.iteritems(),key = operator.itemgetter(1),reverse = True)
    return sortedVotes[0][0]

def getAccuracy(testSet,predictions):#进行统计
    correct = 0
    for x in range(len(testSet)):
        if testSet[x][-1] == predictions[x]:
            correct += 1
    return (correct/float(len(testSet)))*100.0
    
def main():
    #prepare data
    trainingSet = []
    testSet = []
    split = 0.67
    loadDataset(r'D:\javaLearning\DeepLearningBasicMachineLearning\KNN\iris.data.txt',split,trainingSet,testSet)
    print 'Train set:'+repr(len(trainingSet))
    print 'Test set:'+repr(len(testSet))
    
    predictions = []
    k = 3
    for x in range(len(testSet)):
        neighbors = getNeighbors(trainingSet,testSet[x],k)
        result = getResponse(neighbors)
        predictions.append(result)
        print('> predicted = ' + repr(result) + ',actual = '+ repr(testSet[x][-1]))
    accuracy = getAccuracy(testSet,predictions)
    print('Accuracy: '+ repr(accuracy) + '%')
    
main()
        