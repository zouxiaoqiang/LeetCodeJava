package com.zxqnb;

public class T43 {
    private StringBuilder multiply(String num, char digit) {
        // 顺序反过来易于相乘、求和，即123在sb中表示2为321
        StringBuilder sb = new StringBuilder();
        if (digit != '0') {
            int carry = 0, n = num.length(), x = digit - '0';
            for (int i = n - 1; i >= 0; i--) {
                int mul = x * (num.charAt(i) - '0') + carry;
                carry = mul / 10;
                sb.append(mul % 10);
            }
            if (carry > 0) {
                sb.append(carry);
            }
        } else {
            sb.append('0');
        }
        return sb;
    }

    private StringBuilder add(StringBuilder num1, StringBuilder num2, int cnt) {
        StringBuilder ans = new StringBuilder();
        int carry = 0, n1 = num1.length(), n2 = num2.length();
        int i = 0, j = 0;
        while (i < n1 && i < cnt) {
            ans.append(num1.charAt(i++));
        }
        while (i < n1 || j < n2) {
            int sum = carry;
            if (i < n1) {
                sum += (num1.charAt(i++) - '0');
            }
            if (j < n2) {
                sum += (num2.charAt(j++) - '0');
            }
            carry = sum / 10;
            ans.append(sum % 10);
        }
        if (carry > 0) {
            ans.append(carry);
        }
        return ans;
    }

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        int n = num2.length();
        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            StringBuilder sb = multiply(num1, num2.charAt(i));
            ans = add(ans, sb, cnt++);
        }
        return ans.reverse().toString();
    }

    public String multiply1(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int n = num1.length(), m = num2.length();
        int[] ansArr = new int[m + n];
        for (int i = n - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                ansArr[i + j + 1] += a * b;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        int index = ansArr[0] == 0 ? 1 : 0;
        for (; index < m + n; index++) {
            sb.append(ansArr[index]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new T43().multiply1("6", "501"));
    }
}
