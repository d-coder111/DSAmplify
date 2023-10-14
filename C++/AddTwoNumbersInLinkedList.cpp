 /**
 * Problem statement:-
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
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
    string findSum(string str1, string str2) 
    { 
        if (str1.length() > str2.length()) 
            swap(str1, str2); 
        string str = ""; 
        long long int n1 = str1.length(), n2 = str2.length(); 
        long long int carry = 0; 
        for (long long int i=0; i<n1; i++) 
        { 
            long long int sum = ((str1[i]-'0')+(str2[i]-'0')+carry); 
            str.push_back(sum%10 + '0'); 

            carry = sum/10; 
        } 
        for (long long int i=n1; i<n2; i++) 
        { 
            long long int sum = ((str2[i]-'0')+carry); 
            str.push_back(sum%10 + '0'); 
            carry = sum/10; 
        } 
        if (carry) 
            str.push_back(carry+'0'); 
        //reverse(str.begin(), str.end()); 
        return str; 
    }
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        string s1,s2,ans;
        ListNode *temp=l1;
        while(temp!=nullptr){
            s1+=(temp->val)+'0';
            temp=temp->next;
        }
        temp=l2;
        while(temp!=nullptr){
            s2+=(temp->val)+'0';
            temp=temp->next;
        }
        ans=findSum(s1,s2);
        ListNode *start=nullptr,*prev;
        for(long long int i=0;i<ans.size();i++){
            ListNode *n=new ListNode;
            n->val=(ans[i]-'0');
            n->next=nullptr;
            if(start==nullptr){
                start=n;
            }
            else{
                prev->next=n;
            }
            prev=n;
        }
        return start;
    }
};
