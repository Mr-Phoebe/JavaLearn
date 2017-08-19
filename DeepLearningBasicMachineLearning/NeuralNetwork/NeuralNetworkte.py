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
    def __init__(self,layers,activation = 'tanh'):
        if activation == 'logistic':
            self.activation = logistic
            self.activation_deriv = logistic_derivative
        if activation == 'tanh':
            self.activation = tanh
            self.activation_deriv = tanh_deriv
        self.weights = []
        for i in range(1,len(layers)-1):
            self.weights.Append((2 * np.random.random((layers[i -1] + 1,layers[i] + 1)) - 1)*0.25)
            self.weights.Append((2 * np.random.random((layers[i] + 1,layers[i+1])) - 1)*0.25)
    
    
    def fit(self,X,y,learning_rate = 0.2,epochs = 10000):  
        X = np.atleast_2d(X)
        
        print X.shape[0]
        print X.shape[1]
        
        temp = np.ones(X.shape[0],X.shape[1] + 1) 
        temp[:,0:-1] = X
        
        X = temp
        y = np.array(y)
        
        for k in range(epochs):
            i = np.random.randint(X.shape[0])
            a = [X[i]]
            
            for l in range(len(self.weights)):