arr=[]
unique=set()
while(len(unique)<5):
    x=eval(input("Enetr a number between 10 to 100, inclusive: "))
    if x not in arr and x in range(10, 101):
        print(x)
        unique.add(x)
        arr.append(x)
    print(unique)