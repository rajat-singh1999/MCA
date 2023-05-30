import pandas as pd
import matplotlib.pyplot as plt

# Load the dataset
data = pd.read_csv('CO2 Emissions_Canada.csv')

# Extract the relevant columns from the dataset
make = data['Make']
model = data['Model']
year = data['Year']
co2_emissions = data['CO2 Emissions(g/km)']

# Bar graph
plt.figure(figsize=(12, 6))
plt.bar(make[:10], co2_emissions[:10])
plt.xlabel('Make')
plt.ylabel('CO2 Emissions (g/km)')
plt.title('Top 10 Makes by CO2 Emissions')
plt.xticks(rotation=45)
plt.show()

# Line graph
plt.figure(figsize=(12, 6))
plt.plot(year, co2_emissions)
plt.xlabel('Year')
plt.ylabel('CO2 Emissions (g/km)')
plt.title('CO2 Emissions Trend Over Years')
plt.show()

# Histogram
plt.figure(figsize=(12, 6))
plt.hist(co2_emissions, bins=20, edgecolor='black')
plt.xlabel('CO2 Emissions (g/km)')
plt.ylabel('Frequency')
plt.title('CO2 Emissions Distribution')
plt.show()

# Pie chart
make_counts = make.value_counts().head(5)
plt.figure(figsize=(8, 8))
plt.pie(make_counts, labels=make_counts.index, autopct='%1.1f%%')
plt.title('Top 5 Makes Contribution to CO2 Emissions')
plt.show()

# Scatter plot
plt.figure(figsize=(12, 6))
plt.scatter(year, co2_emissions, alpha=0.5)
plt.xlabel('Year')
plt.ylabel('CO2 Emissions (g/km)')
plt.title('CO2 Emissions vs Year')
plt.show()
