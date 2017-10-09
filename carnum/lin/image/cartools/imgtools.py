#encoding: utf-8
'''
Created on 2017年9月25日

@author: linxue
'''
import numpy as np
import cv2.cv as cv
import cv2
import os
import pybrain


def getBlueRegion(img):
    hsv = cv2.cvtColor(img, cv2.COLOR_BGR2HSV)
    lower_blue=np.array([110,50,50])
    upper_blue=np.array([130,255,255])
    mask = cv2.inRange(hsv, lower_blue, upper_blue)
    res = cv2.bitwise_and(img, img, mask = mask)
    cv2.imshow('image', img)
    cv2.imshow('mask', mask)
    cv2.imshow('res', res)
    cv2.waitKey()
    cv2.destroyAllWindows()
    return res
    
def toGrey(img):
    b, g, r = cv2.split(img)
    f = 0.3 * r + 0.59 * g + 0.11 * b
    farray = cv.fromarray(f)
    return img#####################


    
    

    
    
    
    
    