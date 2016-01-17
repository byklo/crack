#!/usr/bin/python

# write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0

import sys
import random

m = random.randint(3, 6)
n = random.randint(3, 6)

given_matrix = []

for i in xrange(m):
	line = []
	for j in xrange(n):
		line.append(random.randint(0, 9))
	given_matrix.append(line)

print 'ORIGINAL'
for i in xrange(m):
	print given_matrix[i]

rows = []
cols = []

for i in xrange(m):
	for j in xrange(n):
		if given_matrix[i][j] == 0:
			rows.append(i)
			cols.append(j)

for i in xrange(m):
	for j in xrange(n):
		if i in rows or j in cols:
			given_matrix[i][j] = 0

print 'VETTED'
for i in xrange(m):
	print given_matrix[i]
