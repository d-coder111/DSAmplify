#include <iostream>

// Definition for a singly-linked list node
struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(nullptr) {}
};

ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
    // Create a dummy node as the starting point of the merged list
    ListNode* dummy = new ListNode(0);
    ListNode* current = dummy;

    while (l1 != nullptr && l2 != nullptr) {
        if (l1->val < l2->val) {
            current->next = l1;
            l1 = l1->next;
        } else {
            current->next = l2;
            l2 = l2->next;
        }
        current = current->next;
    }

    // If any list has remaining elements, simply append them to the merged list
    if (l1 != nullptr) {
        current->next = l1;
    }
    if (l2 != nullptr) {
        current->next = l2;
    }

    // The merged list starts from the next of the dummy node
    ListNode* mergedList = dummy->next;
    delete dummy;

    return mergedList;
}

// Function to print a linked list
void printList(ListNode* head) {
    while (head != nullptr) {
        std::cout << head->val << " -> ";
        head = head->next;
    }
    std::cout << "nullptr" << std::endl;
}

int main() {
    // Create two sorted linked lists
    ListNode* list1 = new ListNode(1);
    list1->next = new ListNode(2);
    list1->next->next = new ListNode(4);

    ListNode* list2 = new ListNode(1);
    list2->next = new ListNode(3);
    list2->next->next = new ListNode(4);

    std::cout << "List 1: ";
    printList(list1);

    std::cout << "List 2: ";
    printList(list2);

    ListNode* merged = mergeTwoLists(list1, list2);

    std::cout << "Merged List: ";
    printList(merged);

    // Clean up memory (deallocate nodes)
    while (merged != nullptr) {
        ListNode* temp = merged;
        merged = merged->next;
        delete temp;
    }

    return 0;
}
