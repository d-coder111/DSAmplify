#include<bits/stdc++.h>
using namespace std;


// a function that will handle the below condition 
bool isSafe(int srcX, int srcY, int newX, int newY,int row ,int col , int maze[][4], vector<vector<bool>> &visited){
    if((maze[newX][newY] == 1) &&
    ( newX >= 0 && newX < row) &&
     (newY >= 0 && newY < col) && 
    (visited[newX][newY] == false)){
        return true;
    }
    else return false; 
}


void printAllPath(int maze[][4], int row, int col,int srcX, int srcY, string &output,vector<vector<bool>> &visited){
    // base case 
    //  destination [row-1] [ col - 1]

    if(srcX == row-1 && srcY == col-1){
        cout<< output << endl;
        return;
    }

   

    // UP
    int newX = srcX -1 ; 
    int newY = srcY;
    if(isSafe(srcX, srcY, newX, newY, row, col, maze, visited)){
        // mark visited
        visited[newX][newY] = true;
        // call recursion
        output.push_back('U');
        printAllPath(maze, row, col, newX, newY, output,visited);
        // backtracking
        output.pop_back();
        visited[newX][newY] = false;
    }

    // DOWN
    newX = srcX + 1; 
    newY = srcY ;
    if(isSafe(srcX, srcY, newX, newY, row, col, maze, visited)){
        // mark visited
        visited[newX][newY] = true;
        // call recursion
        output.push_back('D');
        printAllPath(maze, row, col, newX, newY, output,visited);
        // backtracking
        output.pop_back();
        visited[newX][newY] = false;
    }

    // Left 
    newX = srcX ; 
    newY = srcY - 1;
    if(isSafe(srcX, srcY, newX, newY, row, col, maze, visited)){
        // mark visited
        visited[newX][newY] = true;
        // call recursion
        output.push_back('L');
        printAllPath(maze, row, col, newX, newY, output,visited);
        // backtracking
        output.pop_back();
        visited[newX][newY] = false;
    }

    // Right
    newX = srcX  ; 
    newY = srcY + 1;
    if(isSafe(srcX, srcY, newX, newY, row, col, maze, visited)){
        // mark visited
        visited[newX][newY] = true;
        // call recursion
        output.push_back('R');
        printAllPath(maze, row, col, newX, newY, output,visited);
        // backtracking
        output.pop_back();
        visited[newX][newY] = false;
    }

}
int main(){
    int maze[4][4] = {
        {1,0,0,0},
        {1,1,0,0},
        {1,1,1,0},
        {1,1,1,1}
    };
    int row = 4;
    int col = 4;
    int srcX = 0;
    int srcY = 0;
    string output = "";
    vector<vector<bool>> visited(row, vector<bool>(col, false) );
    if(maze[0][0] == 0){
        // src position is closed, that means rat will not move
         cout<< "Path not Existed";
    }
    else{
        visited[srcX][srcY] = true;
        printAllPath(maze, row, col, srcX, srcY, output, visited);
        
    }
    return 0;
}