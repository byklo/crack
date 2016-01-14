#!/usr/bin/python

# write a method to replace all spaces in a string with '%20'
# you may assume that the string has sufficient space at the end of the string to hold the additional characters, and that you are given the "true" length of the string
# if implementing in java, please use a character array so that you can perform this operation in place

import sys

given = "Mr John Smith    "
given_string = list(given)
given_length = 13

offset = 0
offsets = [0] * given_length

for i in xrange(given_length):
	if given_string[i] == ' ':
		offset += 2
	else:
		offsets[i] += offset

for i in xrange(given_length - 1, -1, -1):
	swap_index = i + offsets[i]
	temp = given_string[i]
	given_string[i] = given_string[swap_index]
	given_string[swap_index] = temp

space_characters = ['%', '2', '0']
space_count = 0
for i in xrange(len(given_string)):
	if given_string[i] == ' ':
		space_count += 1
		given_string[i] = space_characters[(space_count - 1) % len(space_characters)]

print ''.join(given_string)
