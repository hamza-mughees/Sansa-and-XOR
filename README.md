The following is an interesting problem from HackerRank. I thought I might share my solution to this problem as well as the explanation, I found it rather fascinating. Click [here](#solution-explained) to skip to the solution explanation.

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

At first, this problem seems a little daunting. However, after a deeper observation, and a little bit of trial & error, it comes out to be the total opposite.

Lets analyse a sample input. Lets take ***arr = [2, 3, 4, 5]***.

From the question, we can see that this can be represented as follows:

![](https://latex.codecogs.com/gif.latex?2%5Coplus%203%5Coplus%204%5Coplus%205%5Coplus%20%282%5Coplus%203%29%5Coplus%20%283%5Coplus%204%29%5Coplus%20%284%5Coplus%205%29%5Coplus%20%282%5Coplus%203%5Coplus%204%29%5Coplus%20%283%5Coplus%204%5Coplus%205%29%5Coplus%20%282%5Coplus%203%5Coplus%204%5Coplus%205%29)

From mathematical knowlege, it is understood that *XOR* is a commutitave and associative operator. Therefore, the brackets can be completely ignored, in fact removed, and we would be left with the following:

![](https://latex.codecogs.com/gif.latex?2%5Coplus%203%5Coplus%204%5Coplus%205%5Coplus%202%5Coplus%203%5Coplus%203%5Coplus%204%5Coplus%204%5Coplus%205%5Coplus%202%5Coplus%203%5Coplus%204%5Coplus%203%5Coplus%204%5Coplus%205%5Coplus%202%5Coplus%203%5Coplus%204%5Coplus%205)

Lets manipulate the above expression, so that all the like terms are grouped. For convenience, lets also surround the like terms with brackets, like so:

![](https://latex.codecogs.com/gif.latex?%282%5Coplus%202%5Coplus%202%5Coplus%202%29%5Coplus%20%283%5Coplus%203%5Coplus%203%5Coplus%203%5Coplus%203%5Coplus%203%29%5Coplus%20%284%5Coplus%204%5Coplus%204%5Coplus%204%5Coplus%204%5Coplus%204%29%5Coplus%20%285%5Coplus%205%5Coplus%205%5Coplus%205%29)

Lets now attempt to solve this expression bracket by bracket. Before that, however, lets have a quick look at what happens when you ***XOR*** a value, with itself. Lets ***XOR*** the binary representation of ***2*** with itself:

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

This shows us that whenever we ***XOR*** zero with a number ***x***, it always results back the number ***x***. lets now go back and use this knowledge to simplify the expression. Looking at the first bracket, we have the following:

![](https://latex.codecogs.com/gif.latex?2%5Coplus%202%5Coplus%202%5Coplus%202)

lets put brackets around groups of two terms and solve them each:

![](https://latex.codecogs.com/gif.latex?%282%5Coplus%202%29%5Coplus%20%282%5Coplus%202%29)

As discussed, the resulting values in both of these brackets will be zero:

![](https://latex.codecogs.com/gif.latex?%280%29%5Coplus%20%280%29)  
![](https://latex.codecogs.com/gif.latex?0)

From this, we can tell that if the following conditions are met:
1. We have an expression in which any value ***x*** is being ***XOR***'ed with itself any number of times
2. We can divide the expression into subexpressions of two terms with no remaining terms (i.e. number of ***x***'s is even)  
the resulting value will be zero.

We have established that the first subexpression of the original expression simplifies to 0. We can now simplify the next part.

![](https://latex.codecogs.com/gif.latex?3%5Coplus%203%5Coplus%203%5Coplus%203%5Coplus%203%5Coplus%203)

We can straight away see that the number of ***3***'s in the above subexpression is 6 (even), which means that it would simplify to zero. The Third and fourth subexpressions also simplify to zero, since the number of ***4***'s and ***5***'s in each subexpression, respectively, is even.

![](https://latex.codecogs.com/gif.latex?0%5Coplus%200%5Coplus%200%5Coplus%200)  
![](https://latex.codecogs.com/gif.latex?0)

With further inspection, it is observed that, in fact, for all input arrays that have an even length, the output is zero since all the values in an input array of even length occur exactly an even amount of times in the expression. From this, we can speculate that the problem must lie in the amount of times a number, ***x***, occurs within the expression. If we can somehow find a pattern that reveals to us whether each element of the array occurs an even or odd number of times, we could use this to solve the problem.

Taking all of the above into account, what if the length of the input array is odd? Lets take ***arr = [2, 3, 4]*** to evaluate this scenario.

The following expression would follow:

![](https://latex.codecogs.com/gif.latex?2%5Coplus%203%5Coplus%204%5Coplus%20%282%5Coplus%203%29%5Coplus%20%283%5Coplus%204%29%5Coplus%20%282%5Coplus%203%5Coplus%204%29)

Following the exact same steps as with the previous scenario, we end up with the following expression:

![](https://latex.codecogs.com/gif.latex?%282%5Coplus%202%5Coplus%202%29%5Coplus%20%283%5Coplus%203%5Coplus%203%5Coplus%203%29%5Coplus%20%284%5Coplus%204%5Coplus%204%29)

As before, lets take the first bracket of the above expression and divide it into subexpressions of two terms:

![](https://latex.codecogs.com/gif.latex?%282%5Coplus%202%29%5Coplus%202)

We can notice that the number of ***2***'s in the above subexpression is 3 (odd). We can simplify the grouped terms to zero, furthermore, we know that when we ***XOR*** any value with zero, we get the same value back. This implies the following:

![](https://latex.codecogs.com/gif.latex?0%5Coplus%202)  
![](https://latex.codecogs.com/gif.latex?2)

Looking at the second part of the expression, we can see that there are an even number of ***3***'s in the subexpression. Therefore, as before, this part of the expression would simplify to zero. Finally, the third part of the equation has an odd number of ***4***'s, which we now know would simplify to ***4***. The following expression is obtained:

![](https://latex.codecogs.com/gif.latex?2%5Coplus%200%5Coplus%204)

The above expression is the key to the solution. Lets take a minute to compare this expression with our input array:

![](https://latex.codecogs.com/gif.latex?%5B2%2C%203%2C%204%5D)  
![](https://latex.codecogs.com/gif.latex?2%5Coplus%200%5Coplus%204)

We can observe that the first element of the array, ***arr[0]*** (even index), is equal to the first term of the expression. Similarly, the third element of the array, ***arr[2]*** (even index), is also equal to the third term of the expression. However, the second term of the expression is zero, which is not equal to the second element of the array, ***arr[1]*** (odd index). Now that we have noticed something, lets quickly simplify the expression to get the answer:

![](https://latex.codecogs.com/gif.latex?2%5Coplus%200%5Coplus%204)  
![](https://latex.codecogs.com/gif.latex?2%5Coplus%204)  
![](https://latex.codecogs.com/gif.latex?6)

After observing other inputs for confirmation, we can verify a pattern. For any ***arr = [a, b, c, d, e, f, g, ...]*** where the length of ***arr*** is odd, the following would be the output:

![](https://latex.codecogs.com/gif.latex?a%5Coplus%200%5Coplus%20c%5Coplus%200%5Coplus%20e%5Coplus%200%5Coplus%20g)  
![](https://latex.codecogs.com/gif.latex?a%5Coplus%20c%5Coplus%20e%5Coplus%20g)

All the elements at even indeces of the input array, occur exactly an odd number of times in the expression, therefore being carried into the answer. All the elements at odd indeces of the input array, occur exactly an even number of times in the expression, therefore being reduced to zero.

With this information, coding the solution becomes much easier.
