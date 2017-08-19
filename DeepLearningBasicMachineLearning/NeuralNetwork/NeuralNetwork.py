# -*-coding:utf-8 -*-

import numpy as np

def tanh(x):#定义双曲函数
    return np.tanh(x)

def tanh_deriv(x):#双曲函数的导数
    return 1.0 -np.tanh(x)*np.tanh(x)

def logistic(x):#定义逻辑函数
    return 1/(1 + np.exp(-x))

def logistic_derivative(x):#逻辑函数的导数
    return logistic(x)*(1 - logistic(x))

class NeuralNetwork:
    def __init__(self,layers,activation = 'tanh'):#类的构造函数
        """
        :param layes:A list containing the number of units in each layer.should be at least two values
        :param activation:The activation function tobe used.Can be "logistics" or "tanh"
        """
        if activation == 'logistic':
            self.activation = logistic
            self.activation_deriv = logistic_derivative
        elif activation == 'tanh':
            self.activation = tanh
            self.activation_deriv = tanh_deriv
        
        self.weights = []
        for i in range(1,len(layers) -1):
            self.weights.append((2 *np.random.random((layers[i -1] + 1,layers[i] + 1)) - 1)*0.25) 
            self.weights.append((2 *np.random.random((layers[i] + 1,layers[i + 1])) - 1)*0.25)
                      
    def fit(self,X,y,learning_rate = 0.2,epochs = 10000):  
        X = np.atleast_2d(X)#数据类型改为
        #X.shape([0]矩阵行，矩阵列X.shape[1]
        temp = np.ones([X.shape[0],X.shape[1] + 1])#初始化一个矩阵，对bais进行赋值
        # temp[:,0:-1]行数取所有的行，列数取除了最后一列
        temp[:,0:-1] = X #adding the bias unit to the input layer
        X = temp
        y = np.array(y)
        for k in range(epochs):
            i = np.random.randint(X.shape[0])
            a = [X[i]] 
            for l in range(len(self.weights)):#表示层数 
                a.append(self.activation(np.dot(a[l],self.weights[l])))#点乘和非线性转化
                #正向更新完成
            error = y[i] - a[-1]
            deltas = [error * self.activation_deriv(a[-1])]#输出层的误差 
            #开始计算     
            for l in range(len(a) -2,0,-1):
                deltas.append(deltas[-1].dot(self.weights[l].T)*self.activation_deriv(a[l]))    
            deltas.reverse()
            for i in range(len(self.weights)):
                layer = np.atleast_2d(a[i])
                delta = np.atleast_2d(deltas[i])
                self.weights[i] += learning_rate * layer.T.dot(delta)#先转置在点乘
                
    def predict(self,x):
        x = np.array(x)
        temp = np.ones(x.shape[0] + 1)
        temp[0:-1] = x
        a = temp        
        for l in range(0,len(self.weights)):
            a = self.activation(np.dot(a,self.weights[l]))
        return a
    