n = int(input("Enter the number : "))
for i in range(n):
    s = ""
    for j in range(10):
        s+="("
    
    if i==0:
        s+=" "
    else:
        s+=f"{i}"

    for j in range(10):
        s+=")"
    print(s)
