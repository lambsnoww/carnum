# -*- coding: UTF-8 -*-
'''
Created on 2017年9月18日

@author: linxue
'''
import cv2.cv as cv
image = cv.LoadImage("123.jpg", cv.CV_LOAD_IMAGE_COLOR)
cv.NamedWindow("a_window", cv.CV_WINDOW_AUTOSIZE)
cv.ShowImage("a_window", image)

cv.WaitKey(0)




