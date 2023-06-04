#include<iostream>
using namespace std;

int n;
int top1=-1;
int top2=-1;
int top3=-1;
int m1;
int m2;
int m3;

void push(int i, int* arr, int k){
    if(i==1){
        if(top1 != m1){
            if(top1==-1)
                top1=n/3;
            top1--;
            arr[top1] = k;
        }
        else
            cout<<"The first stack is full!"<<endl;
    }
    else if(i==2){
        if(top2 != m2){
            if(top2 == -1)
                top2 = (n/3)-1;
            top2++;
            arr[top2] = k;
        }
        else
            cout<<"The second stack is full!"<<endl;
    }
    else{
        if(top3 != m3){
            if(top3==-1)
                top3 = (2*(n/3))-1;
            top3++;
            arr[top3] = k;
        }
        else
            cout<<"The third stack is full!"<<endl;
    }
}

void pop(int i, int* arr){
    if(i==1){
        if(top1 == -1)
            cout<<"Nothing to pop in stack 1"<<endl;
        else{
            cout<<arr[top1]<<" popped!"<<endl;
            if(top1==((n/3)-1))
                top1=-1;
            else
                top1++;
        }
    }
    else if(i==2){
        if(top1 == -1)
            cout<<"Nothing to pop in stack 1"<<endl;
        else{
            cout<<arr[top2]<<" popped!"<<endl;
            if(top2 == n/3)
                top2=-1;
            else
                top2--;
        }
    }
    else{
        if(top1 == -1)
            cout<<"Nothing to pop in stack 1"<<endl;
        else{
            cout<<arr[top3]<<" popped!"<<endl;
            if(top3 == (2*(n/3)))
                top3=-1;
            else
                top3--;
        }
    }
}

void printS(int i, int* arr){
    if(i==1){
        if(top1 == -1)
            cout<<"First stack is empty!"<<endl;
        else{
            for(int i=(n/3)-1;i>=top1;i--){
                cout<<arr[i]<<" ";
            }
            cout<<endl;
        }
    }
    else if(i==2){
        if(top2 == -1)
            cout<<"First stack is empty!"<<endl;
        else{
            for(int i=(n/3);i<=top2;i++)
                cout<<arr[i]<<" ";
            cout<<endl;
        }
    }
    else{
        if(top3 == -1)
            cout<<"First stack is empty!"<<endl;
        else{
            for(int i=(2*(n/3));i<=top3;i++)
                cout<<arr[i]<<" ";
            cout<<endl;
        }
    }
}

int main(){
    int n = 30;
    int arr[n];
    int top1 = -1;
    int top2 = -1;
    int top3 = -1;
    int m1 = 0;
    int m2 = (2*(n/3))-1;
    int m3 = (3*(n/3))-1;

    push(1, arr, 10);
    push(1, arr, 11);
    push(1, arr, 12);
    push(1, arr, 13);
    push(1, arr, 14);
    push(1, arr, 15);
    printS(1, arr);
    return 0;
}