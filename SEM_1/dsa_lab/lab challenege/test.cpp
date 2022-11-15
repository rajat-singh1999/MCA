#include<iostream>
using namespace std;

class A{
    public:
    int a;
    int b;

   
    void show(){
        cout<<"Parent: "<<a<<b<<endl;
    }
};

class B: public A{
    public:
    void show(){

        cout<<"Child: "<<a<<b<<endl;
    }
};

int main(){
    B obj;
    obj.a=3;
    obj.b=5;
    obj.show();
    return 0;
}