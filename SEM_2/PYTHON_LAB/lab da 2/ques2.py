def indexOf(char, string):
    for i in range(len(string)):
        if(string[i]==char):
            return i
    return -1

def lastIndexOf(char, string):
    for i in range(len(string)-1,-1,-1):
        if(string[i]==char):
            return i
    return -1

print(indexOf("a", "Rajat"))
print(lastIndexOf("a", "Rajat"))