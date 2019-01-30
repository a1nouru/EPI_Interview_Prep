Ref: http://p--np.blogspot.com/2011/04/reverse-linked-list-using-only-2.html
Written by: Ashish Pant  
/*

Reverse a linked list using only 2 pointers
Reverse a linked list using only 2 pointers.

This question has created quite an interest in many students and has been asked many times.
So i thought i give a discussion on the underlying techniques to do it.

Some preliminary requirements

1. Swap two variables without using temporary variables.
easy:
 a = a+b
 b = a-b
 a = a-b
problems:
 integer overflow problem
 addition overhead involved

solution using xor
 a = a xor b
 b = a xor b
 a = a xor b

fastest way is to write it in one line
 a = a ^ b ^ (b=a)





2. Cyclic swap of three variables a ,b ,c
using temporary variable
 temp=a
 a=b
 b=c
 c=temp

using two swaps
 swap(a,b)
 swap(b,c)

solution using xor
 a = a^b^c
 b = a^b^c
 c = a^b^c
 a = a^b^c
solution in one line
 c = a ^ b ^ c ^ (a=b) ^ (b=c)
because of symmetry a,b,c can be in any order and all the statements below are valid
 b = a ^ b ^ c ^ (c=a) ^ (a=b)
 a = a ^ b ^ c ^ (b=c) ^ (c=a)




Reverse a linked list using 2 pointers.

Students usually go for recursion when they hear such question of optimizing variables.
Well this can be done interatively. However few special conditions need to be taken in mind.

Algorithm:
let a1 -> a2 -> a3 -> .... -> an be a linked list

An intermediate step involved in reversing the list given below where the list is divided into two parts, reversed and non-reversed.
a1 <- a2 <- ... ak-1 <- ak(p)   (q)ak+1 -> ..... -> an

p is the head of the reversed linked list. p=ak
q is the head of non-reversed linked list. q=ak+1

the next step in the reversing process would be
a1 <- a2 <- ... ak <- ak+1(p)      (q)ak+2 -> ..... -> an
p=ak+1
q=ak+2


which can basically be summarised as
t = q->next
q->next=p
p=q;
q=t

which is very similar to the cyclic swap.
so in one line
q = p ^ q ^ q->next ^ (q->next=p) ^ (p=q)
And this is the only way of doing it.
you may think that just like in cyclic swap all the variables are independend and using symmetry you may replace the above statement as
p = p ^ q ^ q->next ^ (q = q->next) ^ (q->next=p) [ incorrect ]
invalid because q becomes q->next and hence the now q->next is actually old q->next->next...thus is invalid
q->next = p ^ q ^ q->next ^ (p=q) ^ (q=q->next) [ incorrect ]
here too the final assignment done to q->next is not the old q->next because q has already changed.
Both the statements have logical error in them.

*/
//Author: Ashish Pant    
 struct List{
    int info;
    List * next;
};

int main(){
    int a[] = { 1 , 2 , 3 , 4 , 5 };
    List *head=NULL,*p=NULL,*q;

    //create a linked list
    q = new List;
    q->info=a[0];
    q->next=NULL;
    head = p = q;
    for(int i=1; i<5; i++){
        q = new List;
        q->info=a[i];
        q->next=NULL;
        p->next=q;
        p=q;
    }
    
    //reverse the list
    p=head;
    q=p->next;
    p->next=NULL;
    while(q){
        q = (List*) ((int)p ^ (int)q ^ (int)q->next ^ (int)(q->next=p) ^ (int)(p=q));
    }
    head = p;
}
