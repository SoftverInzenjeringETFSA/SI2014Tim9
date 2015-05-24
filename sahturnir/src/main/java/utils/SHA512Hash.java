package utils;

public class SHA512Hash {

	public static String convertToHex(byte[] raw) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < raw.length; i++) {
			sb.append(Integer.toString((raw[i] & 0xff) + 0x100, 16)
					.substring(1));
		}
		return sb.toString();
	}
}
