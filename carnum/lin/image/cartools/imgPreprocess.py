#encoding:utf-8
'''
Created on 2017年9月26日

@author: linxue
'''
import cv2
import numpy as np
import matplotlib.pyplot as plt


def preprocess(img):
#高斯降噪 + 直方均衡

#高斯降噪 + 直方均衡
#blur = cv2.GaussianBlur(img, (5,5), 0)
#blur = cv2.medianBlur(img, 0)#中值滤波对椒盐噪声的去噪效果最好

#【滤波】双边滤波能在保持边界清晰的情况下有效的去除噪音。但是这种操作与其他滤波器相比会比较慢。
    blur = cv2.bilateralFilter(img, 9, 75, 75)
#【降噪】
    clahe = cv2.createCLAHE(clipLimit=2,tileGridSize=(10,10))
    blurred = clahe.apply(blur)
#【图像锐化】

#【二值化】
#【腐蚀】【膨胀】【开运算】【闭运算】
#kernel = np.ones((5,5), np.uint8)
#erosion = cv2.erode(blurred, kernel, iterations = 1)

    cv2.imshow('blurred', blurred)
    cv2.waitKey()

if __name__ == '__main__':
    img = cv2.imread('../123.jpg', 0)
#    cv2.imshow('img', img)
#    cv2.waitKey()
    preprocess(img)