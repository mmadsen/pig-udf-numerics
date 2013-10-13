pig-udf-numerics
================

User defined functions for performing numerical tasks in Apache Pig


### Functions ###

`DoubleConverter` is a UDF which takes a string of input representing a floating point number, 
and ensures that it is output as a plain decimal string, even if it was originally in scientific notation.  Usage works as follows:

```
REGISTER 'lib/udf-numerics-madsenlab.jar';

DEFINE convertDouble org.madsenlab.data.DoubleConverter();

A = load 'foo.txt' using PigStorage(',') as (alpha:int, beta:double, gamma: int);

B = foreach A generate alpha, convertDouble(beta), gamma;

store B into 'cleaned-foo.txt' using PigStorage(',');

```






