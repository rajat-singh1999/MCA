/*
To facilitate a thorough net surfing, any web browser has back and forward buttons 
that allow the user to move backward and forward through a series of web pages. To 
allow the user to move both forward and backward two stacks are employed. When 
the user presses the back button, the link to the current web page is stored on a 
separate stack for the forward button. As the user moves backward through a series 
of previous pages, the link to each page is moved in turn from the back to the 
forward stack. 
When the user presses the forward button, the action is the reverse of the back 
button. Now the item from the forward stack is popped, and becomes the current 
web page. The previous web page is pushed on the back stack. Simulate the 
functioning of these buttons using array implementation of 
Stack. Also provide options for displaying the contents of both the stacks whenever 
required
*/
#include<bits/stdc++.h>
using namespace std;

    int current, temp, topBack=-1, topFront=-1;
    int back[100];
    int front[100];

void newPage(int temp){
 //add new page
 //update back stack and front stack
 // update tops and current
    topFront=-1;
    back[++topBack] = current;
    current = temp;
}

void goForward(){
    // go forward
    //update front and back stacks
    //update tops and current
    if(topFront==-1)
        cout<<"No web pages in forward positions."<<endl;
    else{
        back[++topBack] = current;
        current = front[topFront--];
    }
}

void goBack(){
    // go back
    // update front and back satck
    // update tops and current
    if(topBack==-1)
        cout<<"No web pages in backward positions."<<endl;
    else{
        front[++topFront] = current;
        current = back[topBack--];
    }
}

void showBack(){
    //print backStack
    for(int i=topBack;i>0;i--){
        cout<<back[i]<<" ";
    }
    cout<<endl;
}

void showFront(){
    //print front Stack
    for(int i=topFront;i>=0;i--){
        cout<<front[i]<<" ";
    }
    cout<<endl;
}

int main(){

    while(true){
        int c;
        cout<<"1. Enter a new webpage depicted by a number."<<endl;
        cout<<"2. Forward."<<endl;
        cout<<"3. Backward."<<endl;
        cout<<"4. Display Backward Stack."<<endl;
        cout<<"5. Display Forward Stack."<<endl;
        cout<<"6. Show current page."<<endl;
        cout<<"0. Exit."<<endl;
        cin>>c;
        switch(c){
            case 1: cout<<"Enter a number: ";
                    cin>>temp;
                    newPage(temp);
                    cout<<endl;
                    break;
            
            case 2: cout<<"Going forward..."<<endl;
                    goForward();
                    break;
            
            case 3: cout<<"Going back..."<<endl;
                    goBack();
                    break;
            
            case 4: cout<<"Showing back stack:"<<endl;
                    showBack();
                    break;

            case 5: cout<<"Showing front stack:"<<endl;
                    showFront();
                    break;

            case 6: cout<<"Current = "<<current<<endl;
                    break;

            case 0: return 0;

            default: cout<<"Wrong Input, Try Again!"<<endl;
        }
    }
    return 0;
}
