// Leetcode Problem #2785
/*
Given a 0-indexed string s, permute s to get a new string t such that:

All consonants remain in their original places. More formally, if there is an index i with 0 <= i < s.length such that s[i] is a consonant, then t[i] = s[i].
The vowels must be sorted in the nondecreasing order of their ASCII values. More formally, for pairs of indices i, j with 0 <= i < j < s.length such that s[i] and s[j] are vowels, then t[i] must not have a higher ASCII value than t[j].
Return the resulting string.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in lowercase or uppercase. Consonants comprise all letters that are not vowels.
*/

class Solution {
    bool isVowel(char ch)
    {
        if(ch == 'a' ||ch == 'e' ||ch == 'i' ||ch == 'o' ||ch == 'u' ||ch == 'A' ||ch == 'E' ||ch == 'I' ||ch == 'O' ||ch == 'U')
        return true;
        return false;
    }
public:
    string sortVowels(string s) {
        vector<char> vowels;
        vector<int> indexes;
        int i = 0;
        while(s[i] != '\0')
        {
            if(isVowel(s[i]))
            {
                vowels.push_back(s[i]);
                indexes.push_back(i);
            }
            i++;
        }
        sort(vowels.begin(),vowels.end());
        int size = indexes.size();
        for(int i = 0; i < size; i++)
        {
            s[indexes[i]] = vowels[i];
        }
        return s;
    }
};