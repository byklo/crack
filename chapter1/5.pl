#!/usr/bin/perl

# implement a method to perform basic string compression using the counts of repeated characters
# for example, the string aabcccccaaa would become a2b1c5a3
# if the "compressed" string would not become smaller than the original string, your method should return the original string

use strict;
use warnings;
use v5.10;

my $given_string = $ARGV[0];

my $counter;
my $old_c = '';
my $new_string = '';
my @char_array = split(//, $given_string);

foreach my $i (0 .. $#char_array) {
	my $c = $char_array[$i];
	if (! $old_c) {
		$old_c = $c;
		$counter = 1;
		next;
	}
	elsif (length($new_string) >= length($given_string)) {
		say $given_string;
		exit 0;
	}
	elsif ($old_c ne $c) {
		$new_string .= $old_c . $counter;
		$counter = 1;
		$old_c = $c;
	}
	elsif ($i == $#char_array) {
		if ($old_c ne $c) {
			$new_string .= $old_c . $counter;
			$new_string .= $c . 1;
		}
		else {
			$new_string .= $old_c . ++$counter;
		}
	}
	else {
		$counter++;
	}
}

say length($new_string) < length($given_string) ? $new_string : $given_string;
