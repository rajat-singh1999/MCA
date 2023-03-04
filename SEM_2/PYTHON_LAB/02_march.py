import string

num = 5
students = list()
i=1

while i!=num+1:
    print(f"Enter the name for student {i}")
    temp = input()
    students.append(temp)
    i = i+1

students.sort()

reg = list()

i=1

while i!=num+1:
    temp = "22MCA00"+str(i)
    reg.append(temp)
    i = i+1

f=0
ch = int(input("Enter 1 if you want to search by name\nEnter 2 if you want to search by reg no\n"))
if ch == 1:
    name = input("Enter name to search: ")
    i=0
    for n in students:
        if n == name:
            f=1
            break
        i=i+1
    
    if f==1:
        print(f"Reg no of {name}: {reg[i]}")
    else:
        print("Not found.")
else:
    a = input("Enter name to search: ")
    i=0
    f=0
    for r in reg:
        if r == a:
            f=1
            break
        i=i+1
    
    if f==1:
        print(f"Name of reg no {a}: {students[i]}")
    else:
        print("Not found.")

