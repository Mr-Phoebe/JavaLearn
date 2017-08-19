# -*-coding:utf-8 -*-
import math
#求两点之间的距离
def ComputerEuclideanDistance(x1,y1,x2,y2):
    d = math.sqrt(math.pow((x1-x2),2)+math.pow((y1-y2),2))
    return d
d_ag = ComputerEuclideanDistance(3,104,18,90)
d_bg = ComputerEuclideanDistance(2,100,18,90)
d_cg = ComputerEuclideanDistance(1,81,18,90)
d_dg = ComputerEuclideanDistance(101,10,18,90)
d_eg = ComputerEuclideanDistance(99,5,18,90)
d_fg = ComputerEuclideanDistance(98,2,18,90)
print"d_ag",d_ag
print"d_bg",d_bg
print"d_cg",d_cg
print"d_dg",d_dg
print"d_eg",d_eg
print"d_fg",d_fg

