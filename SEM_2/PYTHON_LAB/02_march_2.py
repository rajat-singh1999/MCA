from pickle import TRUE


reg = input("Enter registration number: ")


while(TRUE):
    name = input("Enter name: ")
    f=1
    for i in name:
        if ord(i) not in range(ord('a'),ord('z')+1):
            f=0
            break
    if f==0:
        continue
    break


while(TRUE):
    age = int(input("Enter age: "))
    if age<0 or age>101:
        continue
    break

while(TRUE):
    ph = input("Enter Phone number: ")
    if(len(ph) != 10):
        continue
    break


while(TRUE):
    gen = input("Enter gender: ")
    if gen != 'M' and gen != 'F':
        continue
    break

while(TRUE):
    email = input("Enter email: ")
    f=0
    i=0
    for c in email:
        if c=='.':
            break
        if c == '@':
            f=1
            break
        i=i+1
    
    if f==0:
        continue
    if i==0:
        continue
    if i==(len(email)-1):
        continue
    if email[i+1] == '.':
        continue
    temp = i
    f=0
    while temp!=len(email):
        if email[temp] == '@':
            break
        if email[temp] == '.':
            f=1
            break
    
    if i==(len(email)-1):
        continue
    break



