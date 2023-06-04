n=eval(input("Enter the number of students: "))
dictionary={}
registernumber=1
name=[]
for i in range(n):
    name.append(input('Enter the name: '))
name.sort()
for i in name:
    if(registernumber<10):
        reg_no="2023MCA00"+str(registernumber)
        dictionary[reg_no]=i
    elif(registernumber<100):
        reg_no="2023MCA0"+str(registernumber)
        dictionary[reg_no]=i
    else:
        reg_no="2023MCA"+str(registernumber)
        dictionary[reg_no]=i
    registernumber+=1
print(dictionary)