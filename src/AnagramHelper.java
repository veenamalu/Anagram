public class AnagramHelper {

    public Boolean isAnagram(String str1, String str2) {
        Boolean match = false;
        int len, len1, len2, i, j, found=0, not_found=0;
        len1 = str1.length();
        len2 = str2.length();

        if(len1 == len2)
        {
            len = len1;
            for(i=0; i<len; i++)
            {
                found = 0;
                for(j=0; j<len; j++)
                {
                    if(str1.charAt(i) == str2.charAt(j))
                    {
                        found = 1;
                        break;
                    }
                }
                if(found == 0)
                {
                    not_found = 1;
                    break;
                }
            }
          if(not_found == 1) {
              // System.out.println("Did not find any Anagrams");
          }
            else
            {
               match = true;
            }
        }

        return match;
    }
}