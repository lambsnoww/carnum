#encoding: utf-8
'''
Created on 2017年9月18日

@author: linxue
'''
import numpy as np
import cv2
import os

dir = '../data/sample'
imgPath = []
for files in os.walk(dir):
#    print files[0]
    for i in files[2]:
#        print files[0] + '/' + i
        imgPath.append(files[0] + '/' + i)

imgPath = imgPath[1:]
        
        
#for files in imgPath:
#    img = cv2.imread(imgPath, cv2.CV_LOAD_IMAGE_COLOR)
#    cv2.namedWindow("车辆图像")
#    cv2.imshow('车辆图', img)

img = cv2.imread(imgPath[1], cv2.CV_LOAD_IMAGE_COLOR)
cv2.namedWindow("车辆图像")
cv2.imshow('车辆图', img)
cv2.waitKey()
    
