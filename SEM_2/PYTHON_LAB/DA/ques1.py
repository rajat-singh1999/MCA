"""
********************
*********  *********
********    ********
*******      *******
******        ******
********************
"""

n = 20
a = int(n/2)
b = 2
i = 1
s = ""

for j in range(20):
    s = s + "*"

print(s)

while i<=4:
    s = ""
    for j in range(a-int(b/2)):
        s = s + "*"
    
    for j in range(b):
        s = s + " "
    
    for j in range(a-int(b/2)):
        s = s + "*"

    print(s)
    b = b+2
    i = i+1

s = ""
for j in range(20):
    s = s + "*"

print(s)
