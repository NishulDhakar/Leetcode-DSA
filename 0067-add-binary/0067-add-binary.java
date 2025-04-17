class Solution {
    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();

        int i = a.length() -1;
        int j = b.length() -1;
        int carry = 0;

        while(i >= 0 || j >=0 || carry == 1)
        {

            int x = 0;
            if(i >= 0) {
                x = a.charAt(i) - '0';
            }

            int y = 0;
            if(j >= 0) {
                y = b.charAt(j) - '0';
            }

            int sum  = x + y + carry;

            sb.append(sum % 2);
            carry = sum/2;

            i--;
            j--;

        }

        return sb.reverse().toString();

        }
    }
        