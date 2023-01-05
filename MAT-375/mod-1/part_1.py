import pandas as pd
import matplotlib.pyplot as plt

"""Ask the question

In which generation will rabit population exceed 10,000? (5,000 pairs)
"""

"""Assumptions

1. Rabbit generations are distinct and do not overlap
2. Rabbits are immortal
3. Each rabbit pair produces a single pair of offspring 
4. Each rabbit pair produces offspring after the 2nd generation
5. Rabbits will continue to produce offspring forever

"""
generations = 1000  # Artificially limit the number of generations
population_goal = 5000

""" Rabbits born in next generation
    Rabbits in generation n + 1 = Rabbits in generation n + rabbits born in generation n + 1
"""

"""Rabbits who can give birth
    Rabbits in generation n + 1 = Rabbits in generation n + rabbits born in generation n - 1
"""
def next_fibonacci_number():
    a=0
    b=1
    while True:
        yield b
        a,b= b,a+b

def main():
    n = 0

    obj = next_fibonacci_number()

    # create an Empty DataFrame object
    df = pd.DataFrame(columns=['Generation', 'Rabbits', ])

    for i in range(1,generations):  # generations used to prevent a runaway loop
        n = next(obj)
        new_row = {'Generation': i, 'Rabbits': n * 2}
        df = df.append(new_row, ignore_index=True)    # get next fibonacci number
        if n > population_goal:  # check if population goal has been exceeded
            print(f'In generation {i} the rabbit population is {n * 2} which exceeds {population_goal * 2} rabbits\n')
            break

    print(df.to_string(index=False))

    plt.plot(df['Generation'], df['Rabbits'])
    plt.xlabel('Generation')
    plt.ylabel('Rabbits')
    plt.show()

if __name__ == '__main__':
    main()
