#include<iostream>
#include<vector>
using namespace std;

int sortNow(int arr[], int n){
    int i, j;
    int c=0;
    for (i = 0; i < n - 1; i++){
        for (j = 0; j < n - i - 1; j++){
            c++;
            if (arr[j] > arr[j + 1]){
                swap(arr[j], arr[j + 1]);
            }
        }
    }
    return c;
}

void countFreq(int arr[], int n)
{
    vector<bool> visited(n, false);
 

    for (int i = 0; i < n; i++) {
 
        if (visited[i] == true)
            continue;
 
        int count = 1;
        for (int j = i + 1; j < n; j++) {
            if (arr[i] == arr[j]) {
                visited[j] = true;
                count++;
            }
        }
        if(count>1)
            cout << arr[i] << " (" << count << " times.)" <<endl;
    }
}

int main(){
    int arr[15] = { 10,4,-3,-1,0,4,3,-15,-8,4,-1,9,3,1,7};
    int pos[15];
    int neg[15];

    int p=0; int q=0;
    for( int i : arr){
        if(i<0){
            neg[q] = i;
            q++;
        }
        else{
            pos[p] = i;
            p++;
        }
    }


    int pos_count = sortNow(pos, p);
    int neg_count = sortNow(neg, q);

    cout<<"Sorted Positives: ";
    for(int i=0; i<p; i++)
        cout<<pos[i]<<" ";
    
    cout<<"\tComparisons: "<<pos_count<<endl;
    
    cout<<"Sorted Negetives: ";    
    for(int i=0; i<q; i++)
        cout<<neg[i]<<" ";

    cout<<"\tComparisons: "<<neg_count<<endl;
    cout<<"Duplicate elements are: "<< endl;
    countFreq(arr, 15);

    return 0;
}