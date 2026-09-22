

l = [123, 'spam', 1.23]

# sequence operators
'''
print('l = ', l)
print('len(l)', len(l))

print('l[0] = >' + str(l[0]) + '<')
print('l[:-1] = >' + str(l[:-1]) + '<')
print('l + [4, 5, 6] = ', l + [4, 5, 6])
'''


# type-specific Operators
'''
l.append('NI')
print('l.append = ', l)

l.pop(1)
print('l.pop(2) = ', l)

#l.sort() # err: invlids elements
newL = [123, 2, 3, 5, 3]
print('\nnewL = ', newL)
print('newL.sort() = ', newL)

newL.reverse()
print('newL.reverse() = ', newL )
'''


# nesting

M = [[1, 2, 3],
		 [4, 5, 6],
		 [7, 8, 9]]

for row in M:
	print(row)

'''
print('M[1] = ', M[0])
print('M[0][2] = ', M[0][2])
'''


# comprehensions
'''
col2 = [row[1] for row in M]
print('col2 = ', col2)

print('[row[1] + 1 for row in M]', [row[1] + 1 for row in M])
print('[row[1] for row in M if row[1] % 2 == 0]', [row[1] for row in M if row[1] % 2 == 0])

diag = [M[i][i] for i in [0, 1, 2]]
print('diag = ', diag)


doubles = [c * 2 for c in 'spam']
print('doubles = ', doubles)
'''

g = (sum(row) for row in M)
print('next(g) = ', next(g))
print('next(g) = ', next(g))

print('\nlist(map(sum, M))                 ', list(map(sum, M)))

print('\n{sum(row) for row in M}           ', {sum(row) for row in M})

print('\n{i : sum(M[i]) for i in range(3)} ', {i : sum(M[i]) for i in range(3)})

print('\n[ord(x) for x in \'spam\']        ', [ord(x) for x in 'spam'])

print('\n{ord(x) for x in \'spam\'}        ', {ord(x) for x in 'spam'})

print('\n{x : ord(x) for x in \'spam\'}    ', {x : ord(x) for x in 'spam'})

