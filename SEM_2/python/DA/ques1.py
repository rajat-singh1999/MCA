def find_minimum_waiting_time(N, M, C, Lst):
    Lst.sort()  # Sort the arrival times in ascending order
    
    left = 0
    right = N * C
    
    while left <= right:
        mid = (left + right) // 2
        buses_needed = 0
        students_waiting = 0
        last_student_boarded = 0
        
        for arrival_time in Lst:
            if arrival_time - mid <= last_student_boarded:
                if students_waiting == C:
                    buses_needed += 1
                    students_waiting = 0
                students_waiting += 1
            else:
                last_student_boarded = arrival_time
        if buses_needed <= M and students_waiting == 0:
            right = mid - 1
        else:
            left = mid + 1
    
    return left

# Example usage
N = 4
M = 3
C = 3
Lst = [5, 3, 7, 8]
result = find_minimum_waiting_time(N, M, C, Lst)
print(f"Minimum possible waiting time: {result}")
