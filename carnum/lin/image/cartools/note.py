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

cv2.erode() #erode腐蚀
emptyImage3 = cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)  #灰度化
blur = cv2.GaussianBlur(img, (5,5), 0)#高斯模糊

'''
clahe = cv2.createCLAHE(clipLimit=2,tileGridSize=(10,10))
blurred = clahe.apply(img)

clahe = cv2.createCLAHE(clipLimit=2,tileGridSize=(10,10))
cl1 = clahe.apply(img)
res = cv2.equalizeHist(img)
hist_np1 = np.bincount(img.ravel(),minlength=256)
hist_np2 = np.bincount(cl1.ravel(),minlength=256)
hist_np3 = np.bincount(res.ravel(),minlength=256)
plt.subplot(231),plt.plot(hist_np1)
plt.subplot(232),plt.plot(hist_np2)
plt.subplot(233),plt.plot(hist_np3)
plt.subplot(234),plt.imshow(img,'gray')
plt.subplot(235),plt.imshow(cl1,'gray')
plt.subplot(236),plt.imshow(res,'gray')
plt.show()

#cv2.imwrite('../../data/mid/1.jpg', blurred)
'''
'''
res = cv2.resize(img, (img.shape[1] / 2, img.shape[0] / 2))
dst = cv2.addWeighted(img1, 0.7, img2, 0.3, 0)
'''
#opencv方法读取-cv2.calcHist（速度最快）
#图像，通道[0]-灰度图，掩膜-无，灰度级，像素范围
#hist_cv = cv2.calcHist([img],[0],None,[256],[0,256])
#numpy方法读取-np.histogram()
#hist_np,bins = np.histogram(img.ravel(),256,[0,256])
#numpy的另一种方法读取-np.bincount()（速度=10倍法2）
#hist_np2 = np.bincount(img.ravel(),minlength=256)

#直方图均衡化的两种方法
img = cv2.imread('../藏ED2029.jpg',0) #直接读为灰度图像
#高斯降噪 + 直方均衡

#高斯降噪 + 直方均衡
#blur = cv2.GaussianBlur(img, (5,5), 0)
#blur = cv2.medianBlur(img, 0)#中值滤波对椒盐噪声的去噪效果最好

#【】双边滤波能在保持边界清晰的情况下有效的去除噪音。但是这种操作与其他滤波器相比会比较慢。
blur = cv2.bilateralFilter(img, 9, 75, 75)
#【降噪】
clahe = cv2.createCLAHE(clipLimit=2,tileGridSize=(10,10))
blurred = clahe.apply(blur)
#【图像锐化】

#【二值化】

#

#【腐蚀】【膨胀】【开运算】【闭运算】
#kernel = np.ones((5,5), np.uint8)
#erosion = cv2.erode(blurred, kernel, iterations = 1)