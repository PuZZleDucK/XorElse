# XorElse

A simple java program that XORs two or more hexidecimal strings

## Build:

java XorElse.java

### Semaphore badge:

[![Build Status](https://semaphoreci.com/api/v1/PuZZleDucK/xorelse/branches/master/badge.svg)](https://semaphoreci.com/PuZZleDucK/xorelse)

## Usage:

java XorElse <hex> ... <strings>
XorElse will strip out any spaces, dashes, commas, dots and preceding "0x" from the input strings which are assumed to be hexidecimal strings. These strings are then parsed as BigIntegers and Xor'ed together. The result is then displayed allong with the inputs.

## Example: 

java XorElse "0000 0000" "1010-0101" "11111111"

