/*
postfix problem

*/


#include<iostream>
#include<stack>
#include<locale>
#include<bits/stdc++.h>
using namespace std;

int preced(char ch)
{
    if (ch == '+' || ch == '-')
    {
        return 1; // Precedence of + or - is 1
    }
    else if (ch == '*' || ch == '/')
    {
        return 2; // Precedence of * or / is 2
    }
    else if (ch == '^')
    {
        return 3; // Precedence of ^ is 3
    }
    else
    {
        return 0;
    }
}
string inToPost(string infix)
{
    stack<char> stk;
    stk.push('#');       // add some extra character to avoid underflow
    string postfix = ""; // initially the postfix string is empty
    string::iterator it;
    for (it = infix.begin(); it != infix.end(); it++)
    {
        if (isalnum(char(*it)))
            postfix += *it; // add to postfix when character is letter or number
        else if (*it == '(')
            stk.push('(');
        else if (*it == '^')
            stk.push('^');
        else if (*it == ')')
        {
            while (stk.top() != '#' && stk.top() != '(')
            {
                postfix += stk.top(); // store and pop until ( has found
                stk.pop();
            }
            stk.pop(); // remove the '(' from stack
        }
        else
        {
            if (preced(*it) > preced(stk.top()))
                stk.push(*it); // push if precedence is high
            else
            {
                while (stk.top() != '#' && preced(*it) <= preced(stk.top()))
                {
                    postfix += stk.top(); // store and pop until higher precedence is found
                    stk.pop();
                }
                stk.push(*it);
            }
        }
    }
    while (stk.top() != '#')
    {
        postfix += stk.top(); // store and pop until stack is not empty.
        stk.pop();
    }
    return postfix;
}


/*
Prefix form : 
*/

string inToPre(string infix)
{
    string prefix;
    reverse(infix.begin(), infix.end()); // reverse the infix expression
    string::iterator it;
    for (it = infix.begin(); it != infix.end(); it++)
    { // reverse the parenthesis after reverse
        if (*it == '(')
            *it = ')';
        else if (*it == ')')
            *it = '(';
    }
    prefix = inToPost(infix);              // convert new reversed infix to postfix form.
    reverse(prefix.begin(), prefix.end()); // again reverse the result to get final prefix form
    return prefix;
}
int main()
{
    string infix = "x^y/(5*z)+2";
    cout << "Prefix Form Is: " << inToPre(infix) << endl;
}