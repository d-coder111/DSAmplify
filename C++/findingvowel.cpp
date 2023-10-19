#include <iostream>
using namespace std;

// we will use if else to find out if given character is a vowel or consonant
int main(){
      /*  char c = 'e';
        if(c=='a' || c=='e' || c =='i' || c=='o' || c=='u')
        cout <<c << " is a vowel";
        else
        cout <<c <<" is a consonant" ;
        return 0; */

        // now we take input from user

        char c;
        cin >> c;
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
        cout << c <<" is a vowel";
        else
        cout <<c <<" is a consonant";
        return 0;

}
