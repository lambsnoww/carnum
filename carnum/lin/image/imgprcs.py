#encoding: utf-8
'''
Created on 2017年9月25日

@author: linxue
'''

import matplotlib.pyplot as plt
import numpy as np
import cv2.cv as cv
import cv2
import os
import pybrain


from cartools.names import getNames, saveNames
from cartools.imgtools import getBlueRegion

imgPath = getNames('imgNames.txt')
print imgPath[0]

img = cv2.imread(imgPath[0], cv2.CV_LOAD_IMAGE_COLOR)
cv2.namedWindow("车辆图像", cv2.WINDOW_NORMAL)
#cv2.imshow('车辆图', img)
#cv2.waitKey()
#cv2.destroyAllWindows()

res = cv2.resize(img, (img.shape[1] / 2, img.shape[0] / 2))
'''
cv2.imshow('', res)
cv2.waitKey()
cv2.destroyAllWindows()
'''
###########
e1 = cv2.getTickCount()

b, g, r = cv2.split(img)
f = 0.3 * r + 0.59 * g + 0.11 * b
farray = cv.fromarray(f)

res = getBlueRegion(img)
cv2.imshow(res)
cv2.waitKey()








