# -*- coding:utf-8 -*-
from numpy import *
import numpy as np
import random

# def sigmoid(X):
#     return 1.0/(1+exp(-X))
   
class Network(object):#定义神经网络的结构
      
    def __init__(self,sizes):
        self.num_layers = len(sizes)
        self.sizes = sizes
        self.biases = [np.random.randn(y,1)for y in sizes[1:]]#偏向
        self.weights = [np.random.randn(y,x) for x,y in zip(sizes[:-1],sizes[1:])]#
        
      
    
    def feedforward(self,a):
    #return the output of the network if 'a' is input
        for b,w in zip(self.biases,self.weights):
            s = sigmoid(np.dot(w,a)+b)
        return a
    
    def SGD(self,training_data,epochs,mini_batch_size,eta,test_data=None):
        """Train the neural network using mini-batch stochastic gradient descent.
        The "training_data" is a list of tuples "(x,y)" representing the training
        inputs and the desired outputs. The other non-optional are self-explanatory.
        If "test_data" is provided then the network will be evaluated against the 
        test data after each epoch ,and partial progress printed out. This is useful for 
        tracking progress,but slows things down substantially."""
        if test_data:n_test = len(test_data)
        n=len(training_data)
        for j in xrange(epochs):
            random.shuffle(training_data)
            mini_batches = [
                training_data[k:k+mini_batch_size]
                for k in xrange(0,n,mini_batch_size)]
            for mini_batch in mini_batches:
                self.update_mini_batch(mini_batch,eta)#更新权重和偏向
            if test_data:
                print "Epoch {0}:{1}/{2}".format(j, self.evaluate(test_data),n_test)
            else:
                print "Epoch {0} complete".format(j)
     
    def update_mini_batch(self,mini_batch,eta):
        """Updata the network's weights and biases by applying gradient descent using backpropagation
        to a single mini batch.The "mini_batch" is a list of tuples "(x,y)",and "eta" is the learing rate"""
        nabla_b = [np.zeros(b.shape) for b in self.biases]
        nabla_w = [np.zeros(w.shape) for w in self.weights]
        for x,y in mini_batch:
            delta_nabla_b,delta_nabla_w = self.backprop(x,y)
            nabla_b = [nb + dnb for nb,dnb in zip(nabla_b,delta_nabla_b)]
            nabla_w = [nw + dnw for nw,dnw in zip(nabla_w,delta_nabla_w)]
        self.weights = [w - (eta/len(mini_batch))*nw
                        for w,nw in zip(self.weights,nabla_w)]
        self.biases = [b - (eta/len(mini_batch))*nb for b,nb in zip(self.biases,nabla_b)]
         
                
# sizes=[2,3,1]
# bias = [np.random.randn(y,1)for y in sizes[1:]]
# print('bias',bias)
# for x,y in zip(sizes[:-1],sizes[1:]):
#     print (x,y)

net = Network([2,3,1])
# print(net.num_layers)
# print(net.sizes)
# print(net.biases)#偏向3 1 
# print(net.weights)#权重3 2 加 一行三列



