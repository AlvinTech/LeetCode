package last10;

public class ZigZagConversion {

	/**
	 * @param args
	 */
	public String convert(String s, int nRows) {

		if (nRows <= 1) {
			return s;
		} else {
			int dis = (nRows - 1) * 2;
			int length = s.length();
			int index = 0;
			char[] result = new char[length];
			for (int row = 0; row < nRows; row++) {
				int left = dis - row * 2;
				int right = dis - left;
				char a = ' ';
				int i = row;
				int flag = 1;
				while (i < length) {
				//	System.out.println(s.charAt(i));
					if (flag % 2 == 1 && left != 0) {
						a = s.charAt(i);
						result[index] = a;
						i = i + left;
						index++;

					} else if (flag % 2 == 0 && right != 0) {
						a = s.charAt(i);
						result[index] = a;
						i = i + right;
						index++;

					}
					flag++;
				}

			}
			// System.out.println(result);
			return new String(result);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 3));
		System.out.println(new ZigZagConversion().convert("A", 1));
	}

}
