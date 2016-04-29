import socket
import image
from VideoCapture import Device
cam = Device()
cam.setResolution(320,240)
clisocket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
while 1:
    im = cam.getImage()
    im = im.resize((160,120))
    da = im.tostring()
    clisocket.sendto(da, ("127.0.0.1", 1234))
s.close()
