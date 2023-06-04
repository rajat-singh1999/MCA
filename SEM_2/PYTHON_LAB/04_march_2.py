#11
#1221
#123321
#12344321
#43211234
#321123
#2112
#11
n = int(input("Enter a number: "))

for i in range(1,n+1):
    temp=""
    for j in range(1,i+1):
        temp = temp+str(j)

    while j!=0:
        temp = temp + str(j)
        j = j-1
    print(f"{temp}")

i=n
while i>0:
    j=i
    temp=""
    while j>0:
        temp = temp + str(j)
        j=j-1
    
    j=j+1
    while j<i+1:
        temp = temp+str(j)
        j=j+1
    print(temp)
    i=i-1
