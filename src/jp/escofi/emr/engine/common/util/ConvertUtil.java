package jp.escofi.emr.engine.common.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jp.escofi.emr.engine.search.MapComparator;

/**
 * �^�ϊ����[�e�B���e�B�B
 * <DL>
 * <DT>�g�p�ړI/�@�\�T�v�F
 * <DD>�C�j�V�������[�h���Ɏw�肵���I�u�W�F�N�g�^�֌^�ϊ����s�����߂̃��[�e�B���e�B�N���X�B
 * <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 * <DD>2011/08/01 EBS
 * <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 * <DD>
 * <UL>
 * <LI>2011/08/01 EBS �V�K�쐬
 * </UL>
 * </DL>
 * <P>
 * <P>Copyright(c)2011 Earnest Business Solution Co.,Ltd.�@All Rights Reserved</P>
 * @author EBS
 */
public class ConvertUtil {

	/**
	 * ���p��
	 */
	private static final char QUOTE = '"';
	/**
	 * �J���}
	 */
	private static final char COMMA = ',';
	/**
	 * �G�X�P�[�v
	 */
	private static final char ESCAPE = '\\';
	/**
	 * ���s�R�[�h
	 */
	private static final char RETURN_CODE = '\n';
	/**
	 * �󕶎�
	 */
	private static final String BLANK = "";

	/**
	 * �}�b�v�^�̃T�C�Y�ϊ��B
	 * <DL>
	 * <DT>�g�p�ړI/�@�\�T�v�F
	 * <DD>�n���ꂽ�}�b�v�Ɋi�[����Ă���f�[�^���Ƀ}�b�v�̃T�C�Y���k�����A�ԋp����B
	 * </DL>
	 *
	 * @param <K>
	 *            �}�b�v�L�[�^�C�v
	 * @param <V>
	 *            �}�b�v�l�^�C�v
	 * @param map
	 *            �}�b�v�i���T�C�Y�O�j
	 * @return �}�b�v�i���T�C�Y��j
	 * @throw IllegalArgumentException ������null�̏ꍇ
	 */
	public static <K, V> Map<K, V> resizeMap(Map<K, V> map) {
		if (map == null) {
			throw new IllegalArgumentException();
		}
		Map<K, V> result = new HashMap<K, V>(map.size());
		for (Entry<K, V> e : map.entrySet()) {
			result.put(e.getKey(), e.getValue());
		}
		return result;
	}

	/**
	 * ������̌^�ϊ��B
	 * <DL>
	 * <DT>�g�p�ړI/�@�\�T�v�F
	 * <DD>����str������dataType�̃f�[�^�^�ɕϊ�����B
	 * </DL>
	 *
	 * @param <T>
	 *            �f�[�^�^�C�v
	 *
	 * @param str
	 *            ������
	 * @param dataType
	 *            �f�[�^�^
	 * @return �ϊ���̃I�u�W�F�N�g
	 * @throw IllegalArgumentException �s��������O
	 *        <UL>
	 *        <LI>����str����dataType��null�̏ꍇ
	 *        <LI>�����̃f�[�^�^�����݂��Ȃ��ꍇ�iClassNotFoundException�j
	 *        </UL>
	 */
	@SuppressWarnings( { "unchecked" })
	public static <T> T convert(String str, String dataType) {

		if (str == null) {
			throw new IllegalArgumentException("Argument 'str' ("
					+ ConvertUtil.class.getName() + ") is null");
		}
		if (dataType == null) {
			throw new IllegalArgumentException("Argument 'dataType' ("
					+ ConvertUtil.class.getName() + ") is null");
		}

		try {
			Class<T> clazz = (Class<T>) Class.forName(dataType);
			return convert(str, clazz);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
	}

	/**
	 * ������̌^�ϊ��B
	 * <DL>
	 * <DT>�g�p�ړI/�@�\�T�v�F
	 * <DD>�������&lt;T&gt;�^�ɕϊ�����B</DT>
	 * </DL>
	 * @param <T> Java�^
	 *
	 * @param str
	 *            ������
	 * @param clazz
	 *            �ϊ���̌^
	 * @return �ϊ���̃I�u�W�F�N�g�B
	 *         <TABLE width=60% border='1' bordercolor='redblue' cellpadding=2 cellspacing=0>
	 *         <TR>
	 *         <TD>clazz��String�^</TD>
	 *         <TD>intern()�����s���A������Pool����I�u�W�F�N�g���擾</TD>
	 *         </TR>
	 *         <TR>
	 *         <TD>clazz��Boolean�^</TD>
	 *         <TD>str��'true'/'false'�̏ꍇ(�������̂ݗL��)�A�ϊ�</TD>
	 *         </TR>
	 *         <TR>
	 *         <TD>��L�ȊO</TD>
	 *         <TD>clazz�̐V�K�C���X�^���X�𐶐����ԋp</TD>
	 *         </TR>
	 *         </TABLE>
	 * @throw IllegalArgumentException �s��������O
	 *        <UL>
	 *        <LI>����str��'true'/'false'������Y�����Ȃ��ꍇ
	 *        <LI>�V�K�C���X�^���X�����Ɏ��s�����ꍇ
	 *        </UL>
	 */
	@SuppressWarnings("unchecked")
	private static <T> T convert(String str, Class<T> clazz) {

		// ������̏ꍇ�͕�����Pool����I�u�W�F�N�g�擾
		if (clazz == String.class) {
			return (T) (str.intern());
			// Boolean�̏ꍇ��
		} else if (clazz == Boolean.class) {
			return (T) isConvertBoolean(str);
		} else {
			try {
				return clazz.getConstructor(String.class).newInstance(str);
			} catch (Exception e) {
				throw new IllegalArgumentException("Argument '" + str
						+ "' (String) cannot be converted to '"
						+ clazz.getName() + "'");
			}
		}
	}

	/**
	 * �}�b�v���\�[�g�B
	 * <DL>
	 * <DT>�g�p�ړI/�@�\�T�v�F
	 * <DD>�}�b�v�̃G���g�����L�[���Ƀ\�[�g����B
	 * </DL>
	 *
	 * @param map
	 *            �}�b�v
	 * @return �G���g�����X�g�i�\�[�g��j
	 */
	public static List<Map.Entry<String, Object>> sortMap(
			Map<String, Object> map) {

		List<Map.Entry<String, Object>> entries = null;
		if (map == null) {
			entries = new ArrayList<Map.Entry<String, Object>>(
					new HashMap<String, Object>().entrySet());
			return entries;
		}

		entries = new ArrayList<Map.Entry<String, Object>>(map.entrySet());
		Collections.sort(entries, new MapComparator());
		return entries;
	}

	/**
	 * Java�f�[�^�^��BigDecimal�ݒ�۔���
	 *
	 * @param javaDataType
	 *            Java�f�[�^�^
	 * @return BigDecimal�ݒ��
	 * @throw IllegalArgumentException �s��������O
	 *        <UL>
	 *        <LI>����Java�f�[�^�^�����݂��Ȃ��ꍇ�iClassNotFoundException�j
	 *        </UL>
	 */
	public static boolean isBigDecimalAssignable(String javaDataType) {

		try {
			return BigDecimal.class.isAssignableFrom(Class
					.forName(javaDataType));
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
	}

	/**
	 * CSV�`���̕�����𕶎���̃��X�g�ɕϊ�����B
	 *
	 * <p>
	 * ������̐擪���J���}�� �n�܂��Ă�����A������̍Ōオ�J���}�ŏI����Ă���ꍇ�ɂ́A
	 * ���ꂼ��ϊ����ʂ̃��X�g�̍ŏ����A���邢�͍Ō�̗v�f���󕶎���ƂȂ�悤�� �ϊ������B
	 * </p>
	 * <p>
	 * �J���}���A�����Ă���ꍇ�ɂ́A�󕶎���Ƃ��ĕϊ������B
	 * </p>
	 * <p>
	 * csvString���󕶎� �������ꍇ�ɂ́A �v�f��0�̃��X�g�ɕϊ������B<br>
	 * csvString�ɉ��s���܂܂�Ă�ꍇ�ɂ́A���s���O�܂ł̃��X�g��Ԃ��B<br>
	 * �t�B�[���h�̒l�Ɋ܂܂��_�u���N�H�[�g�͂��̒��O�Ƀ_�u���N�H�[�g��t���B<br>
	 * �_�u���N�H�[�g�A�J���}���܂ރt�B�[���h�́A�_�u���N�H�[�e�[�V�����ň͂ނׂ��ł���B
	 * </p>
	 *
	 * @param csvString
	 *            CSV�`���̕�����
	 * @return �J���}�ŕ������ꂽ�������v�f�Ɏ����X�g
	 */
	public static List<String> parseCSV(String csvString) {

		List<String> list = new ArrayList<String>(); // ���ڃ��X�g

		int commaPosition = 0;
		int quotePosition = 0;
		int escapePosition = 0;
		int returnPosition = 0;

		if (csvString.equals(BLANK)) {
			return new ArrayList<String>();
		}

		// ���s�R�[�h�̈ʒu
		returnPosition = csvString.indexOf(RETURN_CODE);
		if (returnPosition < 0) {
			returnPosition = Integer.MAX_VALUE;
		}
		// �G�X�P�[�v�̈ʒu�A�_�u���N�H�[�g�̈ʒu��indexOf�Ŏ擾���邩�ǂ����̃t���O
		boolean eFlg = true;
		boolean qFlg = true;

		String tempString = csvString;
		while (true) {
			commaPosition = tempString.indexOf(COMMA);
			if (qFlg && quotePosition != Integer.MAX_VALUE) {
				quotePosition = tempString.indexOf(QUOTE);
				if (quotePosition < 0) {
					quotePosition = Integer.MAX_VALUE;
				}
			}
			if (eFlg && escapePosition != Integer.MAX_VALUE) {
				escapePosition = tempString.indexOf(ESCAPE);
				if (escapePosition < 0) {
					escapePosition = Integer.MAX_VALUE;
				}
			}
			eFlg = qFlg = false;
			// �J���}����Ԑ�ɂ���ꍇ�A�J���}�܂ł��擾
			if (commaPosition >= 0 && commaPosition < quotePosition
					&& commaPosition < escapePosition
					&& commaPosition < returnPosition) {
				list.add(tempString.substring(0, commaPosition).intern());
				tempString = tempString.substring(commaPosition + 1);
				if (tempString.equals(BLANK)) {
					list.add(BLANK);
					return list;
				}
				quotePosition -= (commaPosition + 1);
				escapePosition -= (commaPosition + 1);
				returnPosition -= (commaPosition + 1);
			} else {
				// ����ȊO�̏ꍇ�A�]���ʂ�̏���
				boolean inQuote = false; // �u"�v���O�t���O
				boolean first = true; // ���ڐ擪�t���O
				int currentPosition = 0; // �����񒆂̌��݂̈ʒu
				int endPosition = 0; // ������̍Ō�̈ʒu
				int size = tempString.length();
				char[] chToken = new char[size];
				int pos = 0;

				endPosition = size;
				while (currentPosition < endPosition) {

					boolean addFlg = false;
					char ch = tempString.charAt(currentPosition);

					switch (ch) {
					case QUOTE:
						qFlg = true;
						if (inQuote) {
							// �����s�̏I���Ȃ炻���܂łŃ��^�[��
							if (currentPosition + 1 >= endPosition) {
								list.add(new String(chToken, 0, pos).intern());
								return list;
							}

							// �u"�v�̎��̕����𔻕�
							char nextCh = tempString.charAt(currentPosition + 1);
							switch (nextCh) {
							// �擪���u"�v�Łu",�v�����o�����獀�ڂ̏I���
							case COMMA:
								inQuote = false;
								currentPosition++;
								list.add(new String(chToken, 0, pos).intern()); // ���X�g�ɍ��ڂ�ǉ�
								addFlg = true;
								break;

							// �擪���u"�v�Łu""�v���o�Ă����Ƃ��́A�P�����Ƃ��ĔF���B
							// �u"",�v���o�Ă����Ƃ��������OK
							case QUOTE:
								currentPosition++;
								chToken[pos] = ch;
								pos++;
								break;

							// �擪���u"�v�Łu"(���s)�v�����o�����獀�ڂ̏I���
							// �{���Ȃ��͂�
							case RETURN_CODE:
								list.add(new String(chToken).intern()); // ���X�g�ɍ��ڂ�ǉ�
								return list;
							case ESCAPE:
								eFlg = true;
								break;
							default:
								break;
							}
						} else {
							// ���ڂ̐擪�Ȃ�u"�v���O�t���O�I��
							if (first) {
								inQuote = true;
								first = false;
							} else {// �擪�Ɂu"�v���Ȃ��ꍇ�Ɂu"�v���o�Ă����Ƃ��͖���
							}
						}
						break;

					case COMMA:
						if (inQuote) {
							chToken[pos] = ch;
							pos++;
						} else {
							list.add(new String(chToken, 0, pos).intern());
							addFlg = true;
						}
						break;

					case ESCAPE:
						eFlg = true;
						// �����s�̏I���Ȃ牽�����Ȃ�
						if (currentPosition + 1 >= endPosition) {
							break;
						}
						if (first) {
							first = false;
						}
						// �u\�v�̎��̕����𔻕�
						char nextCh = tempString.charAt(currentPosition + 1);
						switch (nextCh) {
						case ESCAPE: // �u\\�v���o�Ă����Ƃ��͕����Ƃ��ĔF��

							currentPosition++;
							chToken[pos] = ch;
							pos++;
							break;
						case 'n': // �u\n�v���o�Ă����Ƃ��͉��s�Ƃ��ĔF��
							currentPosition++;
							chToken[pos] = RETURN_CODE;
							pos++;
							break;
						default:
							break;
						}
						break;

					case RETURN_CODE: // ���s�R�[�h���o�Ă�����A�����ōs�̏I���Ƃ��āA�c��̃f�[�^�͔j��
						list.add(new String(chToken, 0, pos).intern());
						return list;

					default: // ���ʂ̕����Ȃ獀�ڂ̕�����ɒǉ�
						if (first) {
							first = false;
						}
						chToken[pos] = ch;
						pos++;
					} // switch end
					// ���݈ʒu���C���N�������g
					currentPosition++;

					// �s�̏I���܂ł����炻���܂ł��P���ڂƂ���
					if (currentPosition >= endPosition) {
						if (addFlg) {
							list.add(BLANK);
						} else {
							list.add(new String(chToken, 0, pos).intern());
						}
						return list;
					}

					if (addFlg) {
						tempString = tempString.substring(currentPosition);
						quotePosition -= currentPosition;
						escapePosition -= currentPosition;
						returnPosition -= currentPosition;
						break;
					}
				} // while2 end
			}
		} // while1 end
	}

	/**
	 * �����񃊃X�g�̂b�r�u�����񉻁B
	 * <DL>
	 * <DT>�g�p�ړI/�@�\�T�v�F
	 * <DD>�����񃊃X�g��CSV�����񉻂���B
	 * </DL>
	 *
	 * @param list
	 *            CSV���ڃ��X�g
	 * @return String �b�r�u�s�f�[�^
	 */
	public static String toCsvString(List<String> list) {
		StringBuffer csv = new StringBuffer();
		if (list.size() == 0) {
			return csv.toString();
		}

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == null) {
				// NULL���ڂ������Ă�����A�󕶎��Ƃ���
				list.add(i, BLANK);
			}
			StringBuffer token = new StringBuffer(list.get(i));
			int currentPosition = 0; // �����񒆂̌��݂̈ʒu

			while (currentPosition < token.length()) {
				char ch = token.charAt(currentPosition);
				switch (ch) {
				case QUOTE:
					token.insert(currentPosition, QUOTE);
					currentPosition += 2;
					break;

				case ESCAPE:
					token.insert(currentPosition, ESCAPE);
					currentPosition += 2;
					break;

				case RETURN_CODE:
					token.replace(currentPosition, currentPosition + 1, "\\n");
					currentPosition += 2;
					break;

				default:
					currentPosition++;
				}
			}
			if ((token.toString().indexOf("\"") != -1) || // ������̒��Ɂu"�v�������́u,�v�����݂�����
					(token.toString().indexOf(",") != -1)) { // ���ڂ̍ŏ��ƍŌ�Ɂu"�v��t��
				token.insert(0, QUOTE).append(QUOTE);
			}
			csv.append(token).append(COMMA); // ���ڂ̎��ɃJ���}�t��
		}
		csv.deleteCharAt(csv.length() - 1); // �Ō�̃J���}���폜
		return csv.toString();
	}

	/**
	 * �������<Boolean>�^�ϊ��B
	 * <DL>
	 * <DT>�g�p�ړI/�@�\�T�v�F
	 * <DD>�������&lt;Boolean&gt;�^�ɕϊ�����B</DT>
	 * </DL>
	 *
	 * @param str
	 *            ������
	 * @return �ϊ���̃I�u�W�F�N�g�B
	 * @throw IllegalArgumentException �s��������O
	 *        <UL>
	 *        <LI>����str��'true'/'false'������Y�����Ȃ��ꍇ
	 *        <LI>�V�K�C���X�^���X�����Ɏ��s�����ꍇ
	 *        </UL>
	 */
	public static Boolean isConvertBoolean(String str) {

		if (Boolean.TRUE.toString().equals(str.toLowerCase())) {
			return Boolean.TRUE;
		} else if (Boolean.FALSE.toString().equals(str.toLowerCase())) {
			return Boolean.FALSE;
		}

		throw new IllegalArgumentException("Argument '" + str
				+ "' (String) cannot be converted to '"
				+ Boolean.class.getName() + "'");
	}
}
