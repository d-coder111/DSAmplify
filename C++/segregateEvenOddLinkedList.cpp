//segregate odd and even nodes(By Value) of a linked list
#include<bits/stdc++.h>
using namespace std;
struct node {
    int data;
    node *next;
    node(int x){
        data = x;
        next = NULL;
    }
};
void print (node *head){
    node *curr = head;
    while(curr!= NULL){
        cout<<curr->data<<" ";
        curr = curr ->next;
    }
}
 node * solution(node *head){
    node *evn_start = NULL , * odd_start = NULL;
    node *evn_end = NULL , * odd_end = NULL;
    node *curr = head;
    while(curr != NULL){
        if(curr->data % 2 == 0){
            if(evn_start == NULL){
                evn_start = curr;
                evn_end = evn_start;
            }
            else {
                evn_start ->next = curr;
                evn_end = evn_start->next;
            }
        }
        else {
            if(odd_start == NULL){
                odd_start = curr;
                odd_end = odd_start;
            }
            else {
                odd_start ->next = curr;
                odd_end = odd_start->next;
            }
        }
        curr = curr->next;
    }
    if(evn_start == NULL || odd_start == NULL) return head;
    evn_end ->next = odd_start;
    odd_end ->next = NULL;

    return evn_start;

}
int main(){
    node *head = new node(17);
    head ->next = new node(10);
    head->next->next =new node(15);
    head->next->next->next = new node(12);
    cout<<"Input Linked List is :"<<endl;
    print(head);
    cout<<"\nOutput : "<<endl;
    print(solution(head));

}