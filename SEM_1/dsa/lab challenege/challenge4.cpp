#include<iostream>
#include<string>
using namespace std;

class Node{
    public:
    char data;
    Node* next;

    Node(int data){
        this->data = data;
        this->next = NULL;
    }
};

class SLL{
    public:
    Node* head;
    int length;

    SLL(){
        length = 0;
        head = NULL;
    }

    void printList(){
        if(head!=NULL){
            Node* temp = head;
            while(temp!=NULL){
                cout<<temp->data<<"-->";
                temp = temp->next;
            }
            cout<<endl;
        }
        else
            cout<<"Nothing to print!"<<endl;
    }

    void insertAtHead(char d){
        Node* newnode = new Node(d);
        if(head == NULL){
            head = newnode;
        }
        else{
            newnode->next = head;
            head = newnode;
        }
        length++;
    }

    void insertAtEnd(char d){
        Node* newnode = new Node(d);
        if(head == NULL){
            head = newnode;
        }
        else{
            Node* temp = head;
            while(temp->next != NULL){
                temp = temp->next;
            }
            temp->next = newnode;
        }
        length++;
    }

    void insert(int pos, char d){
        if(pos==1)
            insertAtHead(d);
        else if(pos>length+1)
            cout<<"You want to insert at position "<<pos<<"."<<" Not possible! There are only "<<length<<" elements in the list."<<endl;
        else if(pos<1)
            cout<<"You want to insert at position "<<pos<<"."<<" Are you serius bruh!?"<<endl;
        else{
            int c=1;
            Node* temp = head;
            while(c<pos-1){
                temp = temp->next;
                c++;
            }
            Node* newnode = new Node(d);

            if(temp->next == NULL)
                temp->next = newnode;
            else{
                newnode->next = temp->next;
                temp->next = newnode;
            }
            length++;
        }
    }

    void removeAtPos(int pos){
        if(head != NULL){
            if(pos == 1){
                head = head->next;
                length--;
            }
            else if(pos>length)
                cout<<"You want to remove at position "<<pos<<"."<<" Not possible! There are only "<<length<<" elements in the list."<<endl;
            else if(pos<1)
                cout<<"You want to remove at position "<<pos<<"."<<" Are you serius bruh!?"<<endl;
            else{
                Node* temp = head;
                int c = 1;
                while(c<pos-1){
                    temp=temp->next;
                    c++;
                }
                Node* p = temp;
                p = p->next;
                temp->next = p->next;
                length--;
            }
        }
        else
            cout<<"Nothing to remove!"<<endl;
    }

    void remove(int d){
        if(head != NULL){
            Node* prev = head;
            if(prev->data == d){
                head = head->next;
                length--;
                return ;
            }
            Node* temp = head;
            temp = head->next;
            while(temp!=NULL){
                if(temp->data == d){
                    prev->next = temp->next;
                    length--;
                    return ;
                }
                prev = prev->next;
                temp = temp->next;
            }
            cout<<"Not found."<<endl;
        }
        else
            cout<<"Nothing to remove!"<<endl;
    }

    void flames_fun(int k){
        Node* temp = head;
        int c=1;
        while(length!=1){
            if(c==k){
                char d = temp->data;
                remove(d);
                temp=head;
                c=1;
                continue;
            }
            if(temp->next!=NULL){
                temp=temp->next;
                c++;
                continue;
            }
            temp = head;
            c++;
        }
        cout<<endl<<"Answer: "<<head->data<<endl;
    }
};

int countUncommon(string s1, string s2){

    for(int i = 0;i<s1.length();i++){
        for(int j=0;j<s2.length();j++){
            cout<<endl<<s1[i]<<" "<<s2[j]<<endl;
            if(s1[i]==s2[j]){
                cout<<endl<<"erase"<<endl;
                s1.erase(s1.begin()+i);
                s2.erase(s2.begin()+j);
                j=-1;
            }
        }
    }
    cout<<endl<<s1<<"   "<<s2<<endl;
    return (s1.length() + s2.length());
}

int main(){
    string name1, name2;
    cout<<"Enter first name: ";
    getline(cin, name1);
    cout<<"Enter second name: ";
    getline(cin,name2);
    int count = countUncommon(name1, name2);
    cout<<endl<<count<<endl;

    SLL* flames = new SLL();
    flames->insertAtEnd('F');
    flames->insertAtEnd('L');
    flames->insertAtEnd('A');
    flames->insertAtEnd('M');
    flames->insertAtEnd('E');
    flames->insertAtEnd('S');
    flames->flames_fun(count);
    return 0;
}