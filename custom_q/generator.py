import random
file_path = "new_file.txt"
with open(file_path, 'w') as file:
    data = []
    while len(data) <= 15: 
        random_int = random.randint(1, 99)
        if str(random_int) not in data:
            data.append(str(random_int))
    file.write(' '.join(data))