/**
 * Problem Statement:
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. 
 * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        int total = 0;
        ListNode* temp = head;
            while(temp!=nullptr){
                total++;
                temp  = temp->next;
            }
        ListNode* prev = NULL, *curr = head, *next=nullptr, *prevstart  = NULL, *newstart=NULL;
        while(curr!=nullptr){
            if(total<k){
                if(newstart==NULL){
                    newstart = curr;
                }
                if(prevstart!=NULL){
                    prevstart->next = curr;
                }
                break;
            }
            ListNode* start = curr;
            prev = NULL;
            int cnt = k;
            while(cnt-- && curr!=nullptr){
                next = curr->next;
                curr->next = prev;
                prev = curr;
                curr = next; 
            }
            if(newstart==NULL){
                newstart = prev;
            }
            if(prevstart!=NULL){
                prevstart->next = prev;
            }
            prevstart = start;
            total-=k;
        }
        return newstart;
    }
};
