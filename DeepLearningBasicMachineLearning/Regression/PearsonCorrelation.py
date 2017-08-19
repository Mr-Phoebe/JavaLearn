# -*- coding:utf-8 -*-
import numpy as np
import math
from astropy.units import Ybarn

def computeCorrelation(X,Y):
    xBar = np.mean(X)
    yBar = np.mean(Y)
    
    SSR = 0
    varX = 0
    varY = 0
    for i in range(0,len(X)):
        diffXXBar = X[i]-xBar
        diffYYBar = Y[i]-yBar
        SSR += (diffXXBar * diffYYBar)
        varX += diffXXBar ** 2
        varY += diffYYBar**2
    SST = math.sqrt(varX * varY)
    
    return SSR/SST

def ployfit(x,y,degree):
    result = {}