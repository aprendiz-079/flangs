
'''
s = 'opa'

print('s[0] = ', s[0])
print('s[1] = ', s[1])
'''

'''
s = 'bom dia para nois ksksks'
print('\n\ns = ', s)
print('len(s) = ', len(s))

print('\n\n s[0:3] = ', s[0:3])

print('\n\n s[4:] = ', s[4:])

print('\n\n s[:3] = ', s[:3])

print('\n\n s[:-4] = ', s[:-4])
print('\n\n s[-4] = ', s[-4])
'''

'''
s = 'opa.'

print('s + \' bom dia\' = ', s + ' bom dia')
print('s, \' bom dia\' = ', s, ' bom dia')
'''


''' imutability '''
'''
s = 'abcdefghijklmnopqrstuvwxyz'

s[0] = '4' # err
Traceback (most recent call last):
  File "/home/demo/docs/flanguages/py/learning_python/datatype/strings.py", line 34, in <module>
    s[0] = '4' # err
    ~^^^
TypeError: 'str' object does not support item assignment


s = '4' + s[1:] # s[0] = '4'
print('\'4\' + s[1:]', s)
s = s[:18] + '5' + s[19:] # s[19] = '5'
print('\ns[:18] + \'5\' + s[19:]', s)
'''



'''type-specify methods'''
# find, replace
'''
s = 'opa. bom dia'
print('s = ', s)
print(\n's.find(\' \') = ', s.find(' ')) # 4
print('\ns.replace(\'\', \'123\')', s.replace(' ', '123')) #'opa.123bom123dia'
'''


# split, upper, isalpha, rstrip, lstrip
'''
s = ' opa bom dia '

print('s = >' + s + '<')
print('\ns.split(\' \') = ', s.split(' '))
print('\ns.upper() = >' + s.upper() + '<')
print('\ns.isalpha() = ', s.isalpha())
print('\ns.rstrip() = >' + s.rstrip() + '<')
print('\ns.lstrip() = >' + s.lstrip() + '<')
'''


# parametres and the format method
'''
print('%s. bom %s' % ('opa', 'dia'))
print('{0}. bom {1}'.format('opa', 'dia'))
'''


# getting help
'''
s = 'opa. bom dia'
print(dir(s)) # return a list of all methods avalliable
print(help(s.replace)) # print the replace helper
'''


# other ways to code strings
'''
s = 'A\nB\tC'
print('\ns = >' + s + '<')
print('\nlen(s) = ', len(s))

print('ord(\'\\n\') = ', ord('\n'))  #\n is a byte with the binary value 10 in ASCII

s = 'A\0B\0C' # \0, a binary zero byte, does not terminate string
print('s = >' + s + '<')
'''
s = '''
opa. bom dia
bom

dia
asdasd
'''
'''
print('s = >' + s + '<')
'''


# patern matching
'''
import re

match = re.match('Hello[ \t]*(.*)world', 'Hello Python world')
print(match.group(1))

match = re.match('/(.*)/(.*)/(.*)', '/usr/home/lumberjack')
print(match.groups())
'''

