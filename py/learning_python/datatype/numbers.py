
'''
x = 123 + 123
print('123 + 123 = ', x)

x = 1.4 * 3
print('\n\n1.4 * 3 = ', x)

x = 2 ** 10
print('\n\n2 ** 10 = ', x)

x =	3 ** 4
x_sz = len(str(x))

print('\n\n3 ** 4 = ', x, '\n', 'x_sz: ', x_sz)
'''

'''
>>> 3.1415 * 2 # repr: as code
6.2830000000000004
>>> print(3.1415 * 2) # str: user-friendly
6.283
'''



############################################################################
'''
import math


print('\nmath.pi = ', math.pi)

x = math.sqrt(56)
print('\n\nsqrt(56) = ', x)
'''
############################################################################


import random

print('\n\nrandom.random() = ', random.random())

#print('\n\nrandom.choice([2, 5, 3, 7]) = ', random.choice([2, 5, 3, 7]))

print('\n\nint(random.random() * (10 ** 3)) = ', int(random.random() * (10 ** 3)))
'''int(random.random() * (10 ** n)) -> to n integer numbers;
