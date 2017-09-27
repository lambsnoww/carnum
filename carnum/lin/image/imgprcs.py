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

###########
e1 = cv2.getTickCount()


blur = cv2.GaussianBlur(img, (5,5), 0)#高斯模糊
print type(blur)
#cv2.imwrite("blurred_img", blur)
#cv2.imshow(blur)
#cv2.waitKey()

#res = getBlueRegion(img)
#cv2.imshow(res)
#cv2.waitKey()








