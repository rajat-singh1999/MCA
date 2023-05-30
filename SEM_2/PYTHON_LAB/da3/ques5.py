def is_leap_year(year):
    if year % 4 == 0:
        if year % 100 == 0:
            if year % 400 == 0:
                return True  # Divisible by 400, leap year
            else:
                return False  # Divisible by 100 but not 400, not a leap year
        else:
            return True  # Divisible by 4 but not 100, leap year
    else:
        return False  # Not divisible by 4, not a leap year

test_cases = [
    2000,
    2020,
    1900,
    2021,
    1600,
    1800
]

for year in test_cases:
    if is_leap_year(year):
        print(f"{year} is a leap year.")
    else:
        print(f"{year} is not a leap year.")
