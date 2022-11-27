#include<bits/stdc++.h>
using namespace std;

class Queue
{
	int rear, front;

	int size;
	int *arr;
public:
	Queue(int s)
	{
	front = rear = -1;
	size = s;
	arr = new int[s];
	}

	void enQueue(int value);
	int deQueue();
	int displayQueue();
    void reset();
};


/* Function to create Circular queue */
void Queue::reset(){
    front = -1;
    rear = -1;
}
void Queue::enQueue(int value)
{
	if ((front == 0 && rear == size-1) ||
			(rear == (front-1)%(size-1)))
	{
		printf("\nQueue is Full");
		return;
	}

	else if (front == -1) /* Insert First Element */
	{
		front = rear = 0;
		arr[rear] = value;
	}

	else if (rear == size-1 && front != 0)
	{
		rear = 0;
		arr[rear] = value;
	}

	else
	{
		rear++;
		arr[rear] = value;
	}
}

// Function to delete element from Circular Queue
int Queue::deQueue()
{
	if (front == -1)
	{
		printf("\nQueue is Empty");
		return INT_MIN;
	}

	int data = arr[front];
	arr[front] = -1;
	if (front == rear)
	{
		front = -1;
		rear = -1;
	}
	else if (front == size-1)
		front = 0;
	else
		front++;

	return data;
}

int Queue::displayQueue()
{
	if (front == -1)
	{
		//printf("\nQueue is Empty");
		return -1;
	}
	//printf("\nElements in Circular Queue are: ");
	int c=0;
    if (rear >= front)
	{
		for (int i = front; i <= rear; i++)
			c++;
	}
	else
	{
		for (int i = front; i < size; i++)
			c++;

		for (int i = 0; i <= rear; i++)
			c++;
	}
    return c;
}

/* Driver of the program */
int main()
{
	Queue q(20);

    while(true){
        cout<<"Input age of person: ";
        int d;
        cin>>d;
        if(d==-1)
            break;
        q.enQueue(d);

        if(q.displayQueue() == 20){
            cout<<"20 people available. Roller coster starts!"<<endl;
            q.reset();
        }
    }
    cout<<endl<<"The service is stopped! will resume tommorow.";
	return 0;
}
