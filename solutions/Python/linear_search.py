def linear_search(arr, target):
    for index, value in enumerate(arr):
        if value == target:
            return index  # Return the index of the found element
    return -1  # Return -1 if the target is not found

# Get input from the user
numbers_input = input("Enter a list of numbers separated by spaces: ")
numbers = list(map(int, numbers_input.split()))  # Convert input string to a list of integers

target_input = input("Enter the number to search for: ")
target = int(target_input)  # Convert input string to an integer

result = linear_search(numbers, target)

if result != -1:
    print(f"Element found at index: {result}")
else:
    print("Element not found.")
