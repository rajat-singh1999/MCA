def isPalindrome(string):
    m=len(string)
    n=int(len(string)/2)
    for i in range(n):
        if(string[i]!=string[m-i-1]):
            return False
    return True

def permutations(string):
    if len(string)==1:
        return(string)
    perms=[]
    for i,c in enumerate(string):
        for perm in permutations(string[:i] + string[i+1:]):
            perms.append(c+perm)
    return perms

def allPermutation(string):
    p=permutations(string)
    for i in p:
        if(isPalindrome(i)):
            return True
    return False

s=input("Enter a string: ")
if(isPalindrome(s)):
    print("Palindrome!")
else:
    if(allPermutation(s)):
        print("Palindrome!")
    else:
        print("Not Possible!")