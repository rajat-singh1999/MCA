s=input("Enter the string: ")
characters=set()
numbers=set()
sp_char=set()
for i in s:
    if(i==" "):
        continue
    elif(i.isalpha()):
        characters.add(i)
    else:
        if(i.isnumeric()):
            numbers.add(i)
        else:
            sp_char.add(i)
print(characters,numbers,sp_char)