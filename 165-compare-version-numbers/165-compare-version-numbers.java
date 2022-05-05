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
            
            while(i<l1 && version1.charAt(i) != '.'){
            v1 = v1*10 + version1.charAt(i) - '0';  
            i++;
            }
            
            while(j<l2 && version2.charAt(j) != '.'){
            v2 = v2*10 + version2.charAt(j) - '0';    
            j++;
            }
        
            if(v1>v2)
                return 1;
            else if(v1<v2)
                return -1;
            else
            {
                i++;
                j++;
            }
            
            }
        
        return 0;
        
        }
    }