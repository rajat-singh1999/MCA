price = int(input("Enter price:"))
offer_pr = int(input("Enter discount:"))
a = price*(10/100) if price>2000 else 0
print(f"after primary discount {price - a}")
disc = price*(offer_pr/100)
print(f"after second discount {price - a - disc}")

tax = price*(12/100)

price = ((price - a - disc) + tax)

print(price)
print(price//1)

