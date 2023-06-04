print("Answer the questions to check insurance eligibility :")
print("just type 'y' for yes ans 'n' for no  , 'm' for male and 'f' for female and age in years :")

mryStatus = input("Are you married ? : ")
gen=input("What is your gender ? : ")
age = int(input("What is your age ? : "))

if(mryStatus=='y'):
    if(gen=='m' and age > 30):
        print("You are eligibel!!")
    elif(gen=='f' and age > 25):
        print("You are eligibel!!")
    else:
        print("you are not eligible!!")
else:
    print("you are not eligible!!")