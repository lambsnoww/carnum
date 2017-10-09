#encoding:utf-8
'''
Created on 2017年9月26日

@author: linxue
'''
import cv2
import cv2.cv as cv
import numpy as np
import matplotlib.pyplot as plt

def preprocess(img_origin):
    img = img_origin.copy()

#【滤波/降噪】双边滤波能在保持边界清晰的情况下有效的去除噪音。但是这种操作与其他滤波器相比会比较慢。
#    img = cv2.bilateralFilter(img, 9, 75, 75)
#【滤波/降噪】
#    img = cv2.GaussianBlur(img, (5,5), 0)
    img = cv2.medianBlur(img, 0)#中值滤波对椒盐噪声的去噪效果最好
    print "【中值滤波】\n"
#【区域直方图均衡化】
    clahe = cv2.createCLAHE(clipLimit=2,tileGridSize=(10,10))
    img = clahe.apply(img)
    print "【区域直方图均衡化】\n"
#【边缘锐化】
    img = cv2.Laplacian(img, 0, ksize = 3)
    print "【边缘锐化】\n"
    return img

def edgeDet(imgEdge):
    imgMat = imgEdge.matrix
    print imgMat

if __name__ == '__main__':
    img = cv2.imread('../2.jpg', 0)
    imgEdge = preprocess(img)
    
    imgEdge = cv2.resize(imgEdge, (imgEdge.shape[1]/2, imgEdge.shape[0]/2))
    print imgEdge
    cv2.imshow("", imgEdge)
    cv2.waitKey()
    
    
    
    
    
    
