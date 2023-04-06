def giveAverage(data, name):
    marks = data[name]
    avg = (sum(marks))/len(marks)

    return avg

n = int(input("Enter the number of students: "))

i=1
data = {}
while i<=n:
    name = input(f"Enter name of student number {i}: ")
    marks = []
    sub_num = int(input(f"Enter the number of subjects for {name}: "))
    j = 1
    while j<=sub_num:
        temp = int(input(f"Enter marks of {name} for subject {j}: "))
        marks.append(temp)
        j+=1

    data[name] = marks
    i+=1

query = input("Which students average do you want to see: ")
if query in data:
    avg = giveAverage(data, query)
    print(f"Average marks for {query} is {avg:0,.2f}.")
else:
    print("The name you entered does not exist in the data. Try again!")
