#encoding: utf-8
'''
Created on 2017年9月21日

@author: linxue
'''
import os

class Dir(object):

    def __init__(self):
        pass
    
    @staticmethod
    def listdir(self, path, list_name):
        print 'listdir'
        for file in os.listdir(path):
            file_path = os.path.join(path, file)
            if os.path.isdir(file_path):
                self.listdir(self, file_path, list_name)
            elif os.path.splitext(file_path)[1]=='.jpg':
                list_name += file_path
        return list_name
                
if __name__ == '__main__':
    name = ''
    print(Dir().listdir(Dir, '../', name))
    print "**"
    print name


        