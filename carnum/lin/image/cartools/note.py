#encoding: utf-8
'''
Created on 2017年9月25日

@author: linxue
'''
'''
注意：一般情况下 OpenCV 的函数要比 Numpy 函数快。所以对于相同的操
作最好使用 OpenCV 的函数。当然也有例外，尤其是当使用 Numpy 对视图
（而非复制）进行操作时。
'''
import matplotlib.pyplot as plt
import numpy as np
import cv2.cv as cv
import cv2
import os
import pybrain


from names import getNames

imgPath = getNames('imgNames.txt')
print imgPath[0]

img = cv2.imread(imgPath[0], cv2.CV_LOAD_IMAGE_COLOR)
cv2.namedWindow("车辆图像", cv2.WINDOW_NORMAL)
#cv2.imshow('车辆图', img)
#cv2.waitKey()
#cv2.destroyAllWindows()

'''
for i in range(0,500):
    img.itemset((i,i,0),0)
    img.itemset((i,i,1),0)
    img.itemset((i,i,2),0)
'''    

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
#plt.imshow(farray, cmap = 'Greys_r')
#plt.waitforbuttonpress()

###################
e2 = cv2.getTickCount()
time = (e2 - e1) / cv2.getTickFrequency()

print "time: "
print time
print cv2.useOptimized()

cv2.erode() #erode
cv2.



