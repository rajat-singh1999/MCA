from numpy import sort


a = input("Input: ")
b = input("Input: ")

f = True
for i in b:
    if i not in a:
        f=False
        break

if f == True and len(a)==len(b):
    print("Duplicate")
else:
    print("Unique")