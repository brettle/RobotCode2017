'''
This program itself is thus far untested.
This tests the functionality of the shooter vision on the Raspberry Pi
and draws the returned point on to the frame. It doesn't check the 
processing frame rate. It includes the exposure script. If you want to 
use it for the gear vision, some things will need to be changed. Figure 
it out. Use hsv_mask_sliders vision codeling to find rangefirst and 
change lower[] and upper[].
'''

import numpy as np
import cv2
import subprocess
import boiler_identify

cap = cv2.VideoCapture(0)
ret = cap.set(3,320)
ret = cap.set(4,180)

subprocess.call("uvcdynctrl -d video1 -s \"Exposure, Auto\" 1", shell=True)
subprocess.call("uvcdynctrl -d video1 -s \"Exposure (Absolute)\" 5", shell=True)

subprocess.call("uvcdynctrl -d video2 -s \"Exposure, Auto\" 1", shell=True)
subprocess.call("uvcdynctrl -d video2 -s \"Exposure (Absolute)\" 5", shell=True)

subprocess.call("uvcdynctrl -d video3 -s \"Exposure, Auto\" 1", shell=True)
subprocess.call("uvcdynctrl -d video3 -s \"Exposure (Absolute)\" 5", shell=True)

subprocess.call("uvcdynctrl -d video0 -s \"Exposure, Auto\" 1", shell=True)
subprocess.call("uvcdynctrl -d video0 -s \"Exposure (Absolute)\" 5", shell=True)

lower = np.array([69, 99, 52])
upper = np.array([85, 255, 133])

while(True):
	# capture frame-by-frame
	ret, frame = cap.read()
	
	# get point [x, y]
	point = boiler_identify.findBoiler(frame, lower, upper)
	
	# draw stuff
	cv2.circle(frame, (point[0], point[1]), 2, (255,0,255))
	print point
	cv2.imshow('frame',frame)
	if cv2.waitKey(1) == 27:
		break

# When everything done, release the capture
cap.release()
cv2.destroyAllWindows()
