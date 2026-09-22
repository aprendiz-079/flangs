

# mapping operators
'''
d = {'food': 'spam', 'quantity': 4, 'color': 'pink'}

print('\nd[\'food\']', d['food'])

d['quantity'] += 1
print('\nd[\'quantity\'] += 1 = ', d)
'''


# nesting revisited
'''
rec = {'name': {'firt': 'Bob', 'last': 'Smith'},
			'job': ['dev', 'mgr'],
			'age': 40.5}

print('rec = \n', rec)

print('\nrec[\'name\'] = ', rec['name'])

print('\nrec[\'name\'][\'last\'] = ', rec['name']['last'])

print('\nrec[\'job\'] = ')

print('\nrec[\'job\'][-1] = ', rec['job'][-1])


rec['job'].append('janitor')
print('\\nrec[\'job\'].append(\'janitor\') = ', rec)
'''


# sorting keys: for loops
'''
d = {'b': 1, 'c': 2, 'a': 3}

ks = list(d.keys())
print('keis = ', ks)

ks.sort()
print('ks.sort() = ', ks)

for key in ks:
	print(key, '=>', d[key])
'''
'''
for c in 'spam':
	print(c.upper())
'''

x = 4
while x > 0:
	print('spam!' * x)
	x -= 1
