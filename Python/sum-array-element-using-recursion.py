# Recursive function to sum elements of an array
def sum_array(ary):
    # Base case: if the array is empty, the sum is 0
    if len(ary) == 0:
        return 0
    # Recursive case: add the first element to the sum of the rest of the array
    else:
        return ary[0] + sum_array(ary[1:])

# Example usage:
my_ary = [111, 222, 333, 444, 555, 73, 48, 59, 99, 67, 93, 54, 87, 63, 51, 71, 70, 250, 230, 21]
result = sum_array(my_ary)
print("The sum of the array is:", result)
