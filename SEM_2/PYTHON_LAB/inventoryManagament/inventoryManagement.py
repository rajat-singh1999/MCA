class Category:
    def __init__(self, id, name):
        self.id = id
        self.name = name
    
    def getID(self):
        return self.id
    
    def getCategory(self):
        return self.name


class Product:
    def __init__(self, prodID, name, price, cat):
        self.prodID = prodID
        self.name = name
        self.price = price
        self.cat = cat
    
    def setPrice(self, p):
        self.price = p
    
    def showInfo(self):
        print(f"Product ID: {self.prodID}")
        print(f"Product name: {self.name}")
        print(f"Product Category: {self.cat.getCategory()}")
        print(f"Product price: {self.price}")



class Inventory:
    def __init__(self):
        self.num = 0
        self.productList = []

    def getSize(self):
        return self.num

    def addProduct(self, product):
        self.productList.append(product)
        self.num+=1
    
    def removeProduct(self, prodID):
        for product in self.productList:
            if prodID == product.prodID:
                break
        
        if product.prodID == prodID:
            self.productList.remove(product)
            self.num-=1
        else:
            print("Not found")

    def updateProduct(self, prodID, newPrice):
        for product in self.productList:
            if prodID == product.prodID:
                break
        
        if product.prodID == prodID:
            self.productList.remove(product)
            product.price = newPrice
            self.productList.append(product)
        else:
            print("Not found")

    def searchProductByCategory(self, cat):
        l=[]
        for product in self.productList:
            if cat == product.cat:
                l.append(product)
        
        return l

    def displayInventory(self):
        # display inventory
        if self.num == 0:
            print("Inventory Empty!")
        else:
            product = None
            for product in self.productList:
                print()
                product.showInfo()
                print()

health = Category(1, "Health Product")
junk = Category(2, "Junk Food")
daily = Category(3, "Daily Products")
dairy = Category(4, "Dairy Products")

inv = Inventory()
inv.displayInventory()
inv.addProduct(Product(1, "Vitamin Tablets", 100, health))
inv.addProduct(Product(2, "Calcium Tablets", 120, health))
inv.addProduct(Product(3, "Potato Chips", 15, junk))
inv.addProduct(Product(4, "Toothpaste", 50, daily))
inv.addProduct(Product(5, "Butter", 35, dairy))
inv.displayInventory()
print("-"*100)

inv.removeProduct(4)
inv.displayInventory()
print("-"*100)

inv.addProduct(Product(6, "Crackers", 45, junk))
inv.displayInventory()
print("-"*100)

inv.updateProduct(2, 123.77)
inv.displayInventory()
print("-"*100)

l = inv.searchProductByCategory(dairy)
for i in l:
    i.showInfo()
    print()
