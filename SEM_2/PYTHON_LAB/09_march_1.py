import string

s = input("Enter: ")

if(len(s)<6):
    print("Invalid")
elif(s.isalnum()):
    print("Invalid")
elif(s.islower() or s.isupper()):
    print("Invalid")
else:
    print("Valid")
