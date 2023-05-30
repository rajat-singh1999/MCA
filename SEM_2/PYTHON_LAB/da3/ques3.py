def is_valid_email(email):
    if '@' not in email:
        return False

    username, domain = email.split('@')

    if not username:
        return False

    allowed_username_chars = set('.-_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789')
    if any(char not in allowed_username_chars for char in username):
        return False

    domain_parts = domain.split('.')
    if len(domain_parts) < 2:
        return False

    tld = domain_parts[-1]
    if not tld.isalpha() or len(tld) < 2:
        return False

    return True

test_cases = [
    "test@example.com",
    "john.doe@example.co.uk",
    "info123@test-domain.com",
    "user-name@example.com",
    "example.com",
    "test@domain",
    "user,example@example.com",
    "invalid email@example.com"
]

# Test the email addresses
for email in test_cases:
    if is_valid_email(email):
        print(f"Valid email address: {email}")
    else:
        print(f"Invalid email address: {email}")
