#encoding:utf-8
'''
Created on 2017年9月25日

@author: linxue
'''

import numpy as np
import cv2
import os
import pybrain

def getNames(filename):
    ll = []
    f = open(filename, 'r')
    
    for line in f.readlines():
        linestr = line.strip()
        #print linestr
#        print type(linestr)
        l = linestr.split("\t")
        ll.extend(l) #注意用extend扩展list，append把每个l作为一个list加入ll这个list
    return ll 

def saveNames(dir):
#    dir = '/Users/linxue/workspace/carnum/lin/data/sample'
    imgPath = []
    for files in os.walk(dir):
        #    print files[0]
        for i in files[2]:
            imgPath.append(files[0] + '/' + i)
           
    imgPath = imgPath[2:]
    for i in imgPath:
        print i
    output = open('../imgNames.txt','w')
    for files in imgPath:
        output.write(files)
        output.write('\n')
    output.close()        

    print type(imgPath)
    print len(imgPath)
    
if __name__ == '__main__':
    saveNames('/Users/linxue/workspace/carnum/lin/data/sample')
    print "names saved in imgNames\n"
