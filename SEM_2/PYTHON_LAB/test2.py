price = int(input("Enter price:"))
offer_pr = int(input("Enter discount:"))
price = round(((price - (price*(10/100) if price>2000 else 0) - (price*(offer_pr/100))) + (price*(12/100))))
print(price)
