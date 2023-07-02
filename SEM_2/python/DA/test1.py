from googlesearch import search

query = "Gopal"
results = search(query, num_results=10)

for result in results:
    print(result)
