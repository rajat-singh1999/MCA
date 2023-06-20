import pandas as pd
data=pd.read_csv(r'data.csv')
fact=1
facts=[]
squars=[m**2 for m in data.N]
sqrts=[m**(0.5) for m in data.N]
for a in data.N:
    for b in range(1,a+1):
        fact*=b
    facts.append(fact)
    fact=1
data['Squares']=squars
data['Square roots']=sqrts
data['Factorials']=facts
data.to_csv('data.csv', index=False)
