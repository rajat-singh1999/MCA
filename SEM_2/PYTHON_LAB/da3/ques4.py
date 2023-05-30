import re

def is_valid_email(email):
    pattern = r'^[\w\.-]+@[\w\.-]+\.\w+$'
    return re.match(pattern, email) is not None

test_cases = [
    "info123@test-domain.com",
    "user,example@example.com",
    "invalid email@example.com",
    "example.com",
    "test@domain",
    "john.doe@example.co.uk",
    "test@example.com",
    "user-name@example.com"
]

for email in test_cases:
    if is_valid_email(email):
        print(f"Valid email address: {email}")
    else:
        print(f"Invalid email address: {email}")
