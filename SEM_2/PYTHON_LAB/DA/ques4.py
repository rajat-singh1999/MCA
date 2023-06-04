n=int(input("Enter the number of items purchased : "))
name=[]
quantity=[]
pricePerUnit=[]
total=[]

for i in range(n) :
    name.append(input("Enter the name of the item purchased : "))
    quantity.append(int(input("Enter the quantity of items purchased : ")))
    pricePerUnit.append(int(input("Enter price Per Unit : ")))
    total.append((quantity[i]*pricePerUnit[i]))

print("-----------------Invoice-----------------")
print("Name   ",end="")
print("Quantity   ",end="")
print("Price per unit   ",end="")
print("Total      ")

for i in range(n):
    print(name[i],end="       ")
    print(quantity[i],end="       ")
    print(pricePerUnit[i],end="         ")
    print(total[i])

print("Total amount to be paid is : ", sum(total))
