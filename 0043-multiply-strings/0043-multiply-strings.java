// do exactly what you learned in school (long multiplication)

//       123
// ×      45
// ------------
//       615      (123 × 5)
// +    4920      (123 × 4, shifted left)
// ------------
//      5535

class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n]; // m digits * n digts ~ m+n digit result

        for (int i = m - 1; i >= 0; i--) {
            int d1 = num1.charAt(i) - '0';

            for (int j = n - 1; j >= 0; j--) {
                int d2 = num2.charAt(j) - '0';
                int mul = d1 * d2;

                int pos1 = i + j;
                int pos2 = i + j + 1;

                int sum = mul + result[pos2];

                result[pos2] = sum % 10; // carry
                result[pos1] += sum / 10; // digit
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}