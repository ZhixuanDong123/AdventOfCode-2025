import math
import time
from functools import lru_cache

def get_file_data(file_path):
    try:
        with open(file_path, 'r') as file:
            file = file.read()
            return file
    except FileNotFoundError:
        print("NOT FOUND")
       
#given list of numbers
#if the number is a perfect square or even or larger than 100: cut the number in half 46 ->  4 6 || 456 -> 4 56 , if number is single digit, duplicate it
#else: multiply number by 123

def isPerfectSquare(number):
    num = math.isqrt(number)
    return True if num*num == number else False 

def half(string):
    newString = (str)(string)
    mid = len(newString) // 2
    halfs = [newString[:mid]] + [newString[mid:]]
    return halfs if len(newString) != 1 else [newString, newString] 

@lru_cache(maxsize=None)
def wait_one(number, iterations):
    number = int(number)
    if iterations == 0:
        return number
    if not(number % 2) or isPerfectSquare(number) or number > 100:
        firstHalf = int(half(number)[0])
        secondHalf = int(half(number)[1])
        return wait_one(firstHalf, iterations-1) + wait_one(secondHalf, iterations-1)
    else:
        return wait_one(number * 123, iterations-1)
    

def count_presents(input, iterations):
    total = 0
    numbers = input.split(" ")
    for i in numbers:
        total += wait_one(i, iterations)
    print("\n")
    return total
        
file = get_file_data("/workspaces/AdventOfCode-2025/custom_q/new_file.txt")
start = time.time()
print(count_presents("12 3 5 6 8 4 36", 200))
print(time.time() - start)