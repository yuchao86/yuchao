import socket
import image
import os,sys,pygame
from pygame.locals import *

pygame.init()
screen = pygame.display.set_mode((160,120))
pygame.display.set_caption("web cam")

pygame.display.flip()
svrsocket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
svrsocket.bind(("127.0.0.1", 1234))
clock = pygame.time.Clock()    #计算帧速
while 1:
    data, address = svrsocket.recvfrom(80000)
    camshot = pygame.image.frombuffer(data, (160,120), "RGB")
    for event in pygame.event.get():
    if event.type == pygame.QUIT: sys.exit()
    screen.blit(camshot, (0,0))
    pygame.display.update() 
    print clock.get_fps()     #在终端打印帧速
clock.tick()
