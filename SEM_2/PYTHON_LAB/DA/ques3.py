'''
3. Develop a program that helps the HR section to calculate the salary for a particular 
employee, given his basic pay. The HRA amount is calculated as 10 percent of the basic 
pay, and TA as 5 percent.
'''

basic = int(input("Give input: "))
mid = basic + (basic * (10/100))
salary = mid + (basic * (5/100))

print(f"Final salary: {salary}")