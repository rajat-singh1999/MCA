import sys

def aman(a, init, k):
    end = 5
    for x in range(end):
        if a[k][x] == 1:
            if init == x:
                print(" S{} --> S{}     ({},{},{}) --------> DEADLOCK DETECTED".format(k+1, x+1, init+1, k+1, x+1))
                global flag
                flag = 1
                break
            print(" S{} --> S{}     ({},{},{})".format(k+1, x+1, init+1, k+1, x+1))
            aman(a, init, x)

flag = 0

def main():
    init, aa, bb, x = 0, 3, 4, 0
    end = 5

    try:
        with open("Dependencies.txt", "r") as file:
            lines = file.readlines()
            if len(lines) < 3:
                print("Dependencies.txt file is empty or incomplete.")
                return

            a = [[0 for _ in range(end)] for _ in range(end)]
            for line in lines[2:]:
                if len(line) < bb:
                    print("Dependencies.txt file has invalid content.")
                    return

                for y in range(end):
                    a[x][y] = int(line[aa:bb])
                    aa += 2
                    bb += 2
                x += 1

    except FileNotFoundError:
        print("Dependencies.txt file not found.")
        return

    print("____________________________________________________________")
    print()
    print(" CHANDY-MISRA-HAAS DISTRIBUTED DEADLOCK DETECTION ALGORITHM")
    print()
    print("\tS1\tS2\tS3\tS4\tS5")
    for i in range(end):
        print("S{}\t".format(i+1), end="")
        for j in range(end):
            print("{}\t".format(a[i][j]), end="")
        print()

    print()
    try:
        init = int(input("Enter Initiator Site No. : ")) - 1
    except ValueError:
        print("Invalid input for Initiator Site No.")
        return
    j = init

    print()
    print(" DIRECTION\tPROBE")
    print()

    for k in range(end):
        if a[j][k] == 1:
            print(" S{} --> S{}     ({},{},{})".format(j+1, k+1, init+1, j+1, k+1))
            aman(a, j, k)

    if flag == 0:
        print()
        print(" NO DEADLOCK DETECTED")
    print("____________________________________________________________")
    input()

if __name__ == "__main__":
    main()
