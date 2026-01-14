try: 
    with open("/workspaces/AdventOfCode-2025/Day8/data", 'r') as file:
        file = file.readlines()
        for index1, coords in enumerate(file):
            for index2, coords2 in enumerate(file):
                if index2 <= index1:
                    continue
                    
                
                print(index1, index2)




except FileNotFoundError:
    print("not found")