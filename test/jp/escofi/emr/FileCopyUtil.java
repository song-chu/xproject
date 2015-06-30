package jp.escofi.emr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 * ファイルコピー用
 *
 * @author seo.yi
 */
public class FileCopyUtil {

	/**
	 * @param args	起動パラメータ
	 * @throws Exception	例外
	 */
	public static void main(String[] args) throws Exception {

		// int i = 2147483647;
		// long l = 9223372036854775807L;
		// double d = 1.79769313486231E308D;

		for (int i = 0; i < 16; i++) {
			FileCopyUtil.copyFile(
					"Z:\\PDSNgine\\xml\\PILInitialLoader4\\PILINI_E_001_%s",
					378 + i, 394 + i, 394 + i, "");
			FileCopyUtil.copyFile(
					"Z:\\PDSNgine\\xml\\PILInitialLoader4\\PILINI_E_001_%s",
					378 + i, 394 + i, 394 + i, "_Meta");
		}
		// FileCopyUtil.copyFile("Z:\\PDSNgine\\xml\\PILInitialLoader4\\PILINI_E_001_%s",
		// 218, 219, 308, "_Meta");
	}

	/**
	 * @param fileFormat
	 *            ファイル名フォーマット<br>
	 *            <p>
	 *            "Z:\\PDSNgine\\xml\\PILInitialLoader4\\PILINI_E_001_%s"
	 *            </p>
	 * @param from	開始文字
	 * @param st	開始
	 * @param end	終了
	 * @param postFix	postFix
	 */
	private static void copyFile(String fileFormat, int from, int st, int end,
			String postFix) {

		String fileName = fileFormat + postFix;
		fileName += ".xml";

		String newFileName = fileFormat + postFix;
		newFileName += ".xml";

		String fromStr = String.valueOf(from);
		for (int i = st; i < (end + 1); i++) {
			BufferedReader br = null;
			PrintWriter pw = null;
			String to = String.valueOf(i);
			try {
				String fromFileName = String.format(fileName, fromStr);
				String toFileName = String.format(newFileName, to);
				System.out.println(fromFileName + "→" + toFileName);
				br = new BufferedReader(new FileReader(fromFileName));
				pw = new PrintWriter(new File(toFileName));
				boolean endFlag = false;
				while (!endFlag) {
					String line = br.readLine();
					if (line == null) {
						endFlag = true;
					} else {
						if (line.contains(fromStr)) {
							line = line.replaceAll(fromStr, to);
						}
						pw.println(line);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					pw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}