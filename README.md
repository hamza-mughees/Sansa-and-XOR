The following is an interesting problem from HackerRank. I thought I might share my solution as well as the explanation to this problem, since I found it rather fascinating (The explanation is at the bottom).

# Sansa and XOR

Sansa has an array. She wants to find the value obtained by XOR-ing the contiguous subarrays, followed by XOR-ing the values thus obtained. Determine this value.

For example, if ***arr = [3, 4, 5]***:

<pre>
Subarray        Operation         Result
3               None              3
4               None              4
5               None              5
3,4             3 XOR 4           7
4,5             4 XOR 5           1
3,4,5           3 XOR 4 XOR 5     2
</pre>

Now we take the resultant values and XOR them together:

![](https://latex.codecogs.com/gif.latex?3%20%5Coplus%204%20%5Coplus%205%20%5Coplus%207%20%5Coplus%201%20%5Coplus%202)

**Function Description**

Complete the sansaXor function in the editor below. It should return an integer that represents the results of the calculations.

sansaXor has the following parameter(s):

- arr: an array of integers

**Input Format**

The first line contains an integer ***t***, the number of the test cases.

Each of the next ***t*** pairs of lines is as follows:
- The first line of each test case contains an integer , the number of elements in ***arr***.
- The second line of each test case contains  space-separated integers ***arr[i]***.

**Constraints**

![](https://latex.codecogs.com/gif.latex?1%5Cleq%20t%20%5Cleq%205)  
![](https://latex.codecogs.com/gif.latex?2%5Cleq%20n%20%5Cleq%2010%5E%7B5%7D)  
![](https://latex.codecogs.com/gif.latex?2%5Cleq%20arr%5Bi%5D%20%5Cleq%2010%5E%7B8%7D)

**Output Format**

Print the results of each test case on a separate line.

**Sample Input 0**

<pre>
2
3
1 2 3
4
4 5 7 5
</pre>

**Sample Output 0**

<pre>
2
0
</pre>

**Explanation 0**

Test case 0:

![](https://latex.codecogs.com/gif.latex?1%5Coplus2%5Coplus3%5Coplus%281%5Coplus2%29%5Coplus%282%5Coplus3%29%5Coplus%281%5Coplus2%5Coplus3%29%3D2)

Test case 1:

![](https://latex.codecogs.com/gif.latex?4%5Coplus5%5Coplus7%5Coplus5%5Coplus%284%5Coplus5%29%5Coplus%285%5Coplus7%29%5Coplus%287%5Coplus5%29%5Coplus%284%5Coplus5%5Coplus7%29%5Coplus%285%5Coplus7%5Coplus5%29%5Coplus%284%5Coplus5%5Coplus7%5Coplus5%29%3D0)

**Sample Input 1**

<pre>
2
3
98 74 12
3
50 13 2
</pre>

**Sample Output 1**

<pre>
110
48
</pre>

**Explanation 1**

Test Case 0:

![](https://latex.codecogs.com/gif.latex?98%5Coplus74%5Coplus12%5Coplus%2898%5Coplus74%29%5Coplus%2874%5Coplus12%29%5Coplus%2898%5Coplus74%5Coplus12%29%3D110)

Test Case 1:

![](https://latex.codecogs.com/gif.latex?50%5Coplus13%5Coplus2%5Coplus%2850%5Coplus13%29%5Coplus%2813%5Coplus2%29%5Coplus%2850%5Coplus13%5Coplus2%29%3D48)

## Solution Explained

At first, this problem seems rather daunting. However, after a deeper observation and some trial & error, it comes out to be the total opposite.

Lets analyse a sample input. lets take ***arr = [2, 3, 4, 5]***.

From the question, we can see that this can be put into context as follows:

![](https://latex.codecogs.com/gif.latex?2%5Coplus%203%5Coplus%204%5Coplus%205%5Coplus%20%282%5Coplus%203%29%5Coplus%20%283%5Coplus%204%29%5Coplus%20%284%5Coplus%205%29%5Coplus%20%282%5Coplus%203%5Coplus%204%29%5Coplus%20%283%5Coplus%204%5Coplus%205%29%5Coplus%20%282%5Coplus%203%5Coplus%204%5Coplus%205%29)

From mathematical knowlege, it is understood that *XOR* is a commutitave and associative operator. Therefore, the brackets can be completely ignored, in fact removed, and we would be left with the following:

![](https://latex.codecogs.com/gif.latex?2%5Coplus%203%5Coplus%204%5Coplus%205%5Coplus%202%5Coplus%203%5Coplus%203%5Coplus%204%5Coplus%204%5Coplus%205%5Coplus%202%5Coplus%203%5Coplus%204%5Coplus%203%5Coplus%204%5Coplus%205%5Coplus%202%5Coplus%203%5Coplus%204%5Coplus%205)

Lets now manipulate the expression, so that all the like terms are grouped. For convenience, lets also surround the like terms with brackets, like so:

![](https://latex.codecogs.com/gif.latex?%282%5Coplus%202%5Coplus%202%5Coplus%202%29%5Coplus%20%283%5Coplus%203%5Coplus%203%5Coplus%203%5Coplus%203%5Coplus%203%29%5Coplus%20%284%5Coplus%204%5Coplus%204%5Coplus%204%5Coplus%204%5Coplus%204%29%5Coplus%20%285%5Coplus%205%5Coplus%205%5Coplus%205%29)

Lets now attempt to solve this expression bracket by bracket. Before that, however, lets we have a quick look at what happens when you ***XOR*** a value, with itself. Lets ***XOR*** the binary representation of ***2*** with itself:

![](https://latex.codecogs.com/gif.latex?2_%7B10%7D%3D10_2)

![](https://latex.codecogs.com/gif.latex?1_%7B2%7D%5Coplus%201_%7B2%7D%3D0_%7B2%7D)  
![](https://latex.codecogs.com/gif.latex?0_%7B2%7D%5Coplus%200_%7B2%7D%3D0_%7B2%7D)

![](https://latex.codecogs.com/gif.latex?00_%7B2%7D%3D0_%7B10%7D)

![](https://latex.codecogs.com/gif.latex?%5Ctherefore2%5Coplus%202%3D0)

This shows us that whenever we ***XOR*** a number ***x*** with itself, it always results to zero. If we now ***XOR*** the resulting zero with the same number ***x*** (i.e. ***2***), the following happens:

![](https://latex.codecogs.com/gif.latex?0_2%5Coplus1_2%3D1_2)  
![](https://latex.codecogs.com/gif.latex?0_2%5Coplus0_2%3D0_2)

![](https://latex.codecogs.com/gif.latex?10_2%3D2_%7B10%7D)

![](https://latex.codecogs.com/gif.latex?%5Ctherefore0%5Coplus2%3D2)

This shows us that whenever we ***XOR*** zero with a number ***x***, it always results back the number ***x***. lets now use this knowledge to simplify the above expression.
