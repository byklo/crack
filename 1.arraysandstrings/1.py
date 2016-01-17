#!/usr/bin/python

# implement an algorithm to determine if a string has all unique characters
# what if you cannot use additional data structures

# assume characters are ascii

import sys

given_string = sys.argv[1]

ascii_counter = [0] * 128

for i in xrange(len(given_string)):
	ascii_value = ord(given_string[i])
	ascii_counter[ascii_value] += 1
	if ascii_counter[ascii_value] > 1:
		print 'string does not have all unique characters'
		sys.exit(0)

print 'string has all unique characters'
