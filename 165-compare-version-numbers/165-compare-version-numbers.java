class Solution {
    public int compareVersion(String version1, String version2) {
        
        int v1 = 0;
        int v2 = 0;
        int l1 = version1.length();         
        int l2 = version2.length();
        int i = 0;
        int j = 0;
        
        while(i<l1 || j<l2){
            
            v1 = 0;
            v2 = 0;
            
            while(i<l1 && version1.charAt(i) != '.'){            //iterate through the version1 string, while there is no '.' in the string.
            v1 = v1*10 + version1.charAt(i) - '0'; //version1.charAt(i) - '0' will give the numerical value difference as version1 is a string containing chars and we are substracting 0 in its char                                                        //format('0'). the numerical value difference is the actual number in that place(char) of the string.
            i++;      
            }
            
            while(j<l2 && version2.charAt(j) != '.'){            //same logic as version1 string. This is for version2.
            v2 = v2*10 + version2.charAt(j) - '0';    
            j++;
            }
        
            if(v1>v2)                                            //as per the problem statement.
                return 1;
            else if(v1<v2)
                return -1;
            else
            {
                i++;
                j++;
            }
            
            }
        
        return 0;                                                //coming out of the while loop implies that v1=v2.
        
        }
    }