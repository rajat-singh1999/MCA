while True:
    user_input = input("Enter a value: ")
    if user_input == "q":
        break
    if user_input.isdigit():
        print(f"Data Type of '{user_input}' is int")
    elif user_input.replace(".", "", 1).isdigit():
        print(f"Data Type of '{user_input}' is float")
    elif user_input.lower() == "true" or user_input.lower() == "false":
        print(f"Data Type of '{user_input}' is bool")
    else:
        print(f"Data Type of '{user_input}' is str")

