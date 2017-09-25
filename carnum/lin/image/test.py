#encoding: utf-8
'''
Created on 2017年9月18日

@author: linxue
'''
import numpy as np
import cv2
import os
import pybrain

dir = '../data/sample'
imgPath = []
for files in os.walk(dir):
#    print files[0]
    for i in files[2]:
        imgPath.append(files[0] + '/' + i)

imgPath = imgPath[1:]
for i in imgPath:
    print i
        
        
#for files in imgPath:
#    img = cv2.imread(imgPath, cv2.CV_LOAD_IMAGE_COLOR)
#    cv2.namedWindow("车辆图像")
#    cv2.imshow('车辆图', img)

print type(imgPath)
print len(imgPath)

img = cv2.imread(imgPath[9], cv2.CV_LOAD_IMAGE_COLOR)
cv2.namedWindow("车辆图像")
cv2.imshow('车辆图', img)
cv2.waitKey()

#########################

gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
gray = cv2.bitwise_not(gray)
thresh = cv2.threshold(gray, 0, 255, cv2.THRESH_BINARY | cv2.THRESH_OTSU)











    
