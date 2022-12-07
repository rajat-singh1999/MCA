#include<iostream>
using namespace std;

int binSearch(int arr[], int k, int n){
    int start=0;
    int end = n;
    int mid = start + ((end-start)/2);

    while(start<end){
        if(arr[mid] == k)
            return mid;
        else if(arr[mid] > k)
            end = mid-1;
        else
            start = mid+1;
        mid = start + ((end-start)/2);
    }
    return -1;
}

int main(){
    int arr[13] = {11,22,33,44,55,66,77,88,99,111,222,333,444};

    int n=13;
    int k = 11;

    int pos = binSearch(arr, k, n);
    if(pos == -1)
        cout<<endl<<"Key = "<< k <<" Not Found!"<<endl;
    else
        cout<<endl<<"Key = "<< k <<" Found at index: "<<pos<<endl;
    return 0;
}