#include<bits/stdc++.h>
using namespace std; 
struct Tree{
    int val;
    Tree *left,*right;
    Tree(int x){
        val = x;
        left = right = NULL;
    }
};
Tree * createTree(){
    Tree *root = new Tree(1);
    root->left = new Tree(2);
    root->right= new Tree(3);
    root->right->left = new Tree(4);
    root->right->right = new Tree(5);
    root->right->left->left = new Tree(8);
    root->right->right->left = new Tree(6);
    root->right->right->right = new Tree(7);

    return root;
}
Tree * Lca(Tree *root,Tree *p,Tree *q){
    if(root==NULL||root==p || root==q) return root;
    Tree *left = Lca(root->left,p,q);
    Tree *right = Lca(root->right,p,q);

    if(left==NULL) return right;
    else if(right==NULL) return left;
    else{
        return root;
    }

}
int main(){
    Tree *root = createTree();
    cout<<Lca(root,root->right->right->right,root->right->left->left)->val<<" ";
    return 0;
    
}