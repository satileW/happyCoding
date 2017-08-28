**question**

Given a string, find the length of the **longest substring** without repeating characters



answer summary:

This is a question that can be seen as two pointers

and in two pointers solution we should focus on list all cases for traversal and merge into simplest code



For this question, when we meet same character, we should just start new start index from next index of old same character 

" a b c  b a d"

  0  1 2 3 4  5 



| start  | 0           | 2    |
| ------ | ----------- | ---- |
| end    | 0, 1, 2, 3  | 4, 5 |
| length | 1,  2, 3, 4 | 3, 4 |





