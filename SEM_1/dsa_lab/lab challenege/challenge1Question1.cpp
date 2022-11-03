#include<iostream>
using namespace std;

int pop(int *s, int top){
    if(top==-1)
        cout<<"Nothing to pop!"<<endl;
    else{
        cout<<s[top--]<<"popped out!"<<endl;
        return top;
    }
    return top;
}

void push(int& top, int* s, int k){
    if(top == 99)
        cout<<"Overflow"<<endl;
    else{
        top++;
        s[top] = k;
    }
}

void printS(int* s, int top){
    for(int i=0;i<=top;i++){
        cout<<s[i]<<" ";
    }
    cout<<endl;
}

void printTopTen(int *s, int top){
    for(int i=0;i<=top;i++){
        if(i>=0 && i<=9)
            cout<<s[i]<<" ";
        if(i>9)
            break;
    }
    cout<<endl;
}

int main(){
    int top=-1;
    int s[100];
    push(top, s, 10);
    push(top, s, 20);
    push(top, s, 30);
    push(top, s, 40);
    push(top, s, 50);
    push(top, s, 60);
    push(top, s, 70);
    push(top, s, 80);
    printS(s, top);
    top = pop(s, top);
    top = pop(s, top);
    printS(s, top);
    printTopTen(s, top);

    return 0;
}