class Solution {
public:
    bool checkString(string s) 
    {
      int l,r=s.length()-1;
      for(int i=0;i<s.length();i++)
      {
        cout << s[i] << endl;
        if(s[i]=='b')
        {
            l=i;
            while(l<=r)
            {
              if(s[l++]=='a' || s[r--]=='a') return 0;
            }
            return 1;
        }
      }    
      return 1;
    }
};