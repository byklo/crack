#!/usr/bin/perl

# implement a function void reverse(char* str) in C or C++ which reverses a null-terminated string

# will just reverse a string in perl lol

use strict;
use warnings;
use v5.10;
use POSIX;

my @given_string = split(//, $ARGV[0]);

my $left = 0;
my $right = $#given_string;
my $temp = "";

while ($left < $right) {
	$temp = $given_string[$left];
	$given_string[$left] = $given_string[$right];
	$given_string[$right] = $temp;
	$left++;
	$right--;
}

say join('', @given_string);
