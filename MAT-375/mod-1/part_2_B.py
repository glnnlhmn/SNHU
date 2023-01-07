import pandas as pd
import matplotlib.pyplot as plt

"""Ask the question

In which generation will rabit population exceed 100,000 pairs? 
"""

"""Assumptions

1. Rabbit generations are distinct and do not overlap
2. Rabbits are immortal
3. Each rabbit pair produces a single pair of offspring 
4. Each rabbit pair produces offspring after the 4th generation
5. Rabbits will continue to produce offspring forever

"""
generations = 1000  # Artificially limit the number of generations
population_goal = 100000

""" Rabbits born in next generation

    Rabbits in generation n + 1 = Rabbits in generation n + rabbits born in generation n - 3
"""
def next_4gen_rabbit_count():
    n1 = 1
    n2 = 0
    n3 = 0
    m = 0

    while True:
        t = m + n1 + n2 + n3
        yield t
        n1, n2, n3, m = m, n1, n2, m + n3


def main():
    n = 0

    obj = next_4gen_rabbit_count()

    # create an Empty DataFrame object
    df = pd.DataFrame(columns=['Generation', 'Rabbit_Pairs', ])

    for i in range(1,generations):  # generations used to prevent a runaway loop
        n = next(obj)
        new_row = {'Generation': i, 'Rabbit_Pairs': n}
        df = df.append(new_row, ignore_index=True)    # get next fibonacci number
        if n > population_goal:  # check if population goal has been exceeded
            print(f'In generation {i} the rabbit population is {n} which exceeds {population_goal} rabbit pairs\n')
            break

    print(df.to_string(index=False))

    plt.plot(df['Generation'], df['Rabbit_Pairs'])
    plt.xlabel('Generation')
    plt.ylabel('Rabbit Pairs')
    plt.show()

if __name__ == '__main__':
    main()
