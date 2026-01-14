path = "/workspaces/AdventOfCode-2025/partner/input.txt"
output = 0
try:
    with open(path, "r") as file:
        data = file.readlines()
except FileNotFoundError:
    print(f"Error: The file at {path} was not found.")

def runtime(orig_func):
    import time
    def wrapper(*args, **kwargs):
        start_time = time.time()
        result = orig_func(*args, **kwargs)
        end_time = time.time()
        print(f"Runtime: {end_time - start_time} seconds")
        return result
    return wrapper

@runtime
def solve(input_data):
    output = 0
    for i in input_data:
        character = i[0]
        numbers = i[1:]
        if sum(int(x) for x in list(numbers.strip())) == ord(character) - 64:
            output += 1
    return output

print(solve(data))
