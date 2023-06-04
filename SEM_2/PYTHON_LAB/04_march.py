n = int(input("Enter a number: "))
if n>1 and n<21:
    if n>=2 and n<=5:
        print("Not Wierd")
    elif n>=6 and n<=20:
        print("Wierd")
    else:
        print("Not Wierd")
else:
    if n%2 == 0:
        print("Wierd")
    else:
        print("Not Wierd")
