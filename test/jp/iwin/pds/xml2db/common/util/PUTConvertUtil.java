package jp.iwin.pds.xml2db.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import jp.iwin.pds.xml2db.common.constant.PCTConstants;
import jp.iwin.pds.xml2db.dumptool.PDMMapComparator;
import jp.iwin.pds.xml2db.dumptool.PDMSetComparator;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;


/**
 * �^�ϊ����[�e�B���e�B�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>�C�j�V�������[�h���Ɏw�肵���I�u�W�F�N�g�^�֌^�ϊ����s�����߂̃��[�e�B���e�B�N���X�B
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1801 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date:: 2010-12-17 17:49:2#$
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/12/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/12/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Nissay Information Technology Co.,Ltd.</P>
 * @version 1.0
 * @since 1.0
 * @author $Author: seo.yj $
 */
public class PUTConvertUtil {

	private static final char QUOTE  = '"';
	private static final char COMMA  = ',';
	private static final char ESCAPE = '\\';
	private static final char RETURNCODE = '\n';
	private static final String BLANK = "";

	/**
	 * �I�u�W�F�N�g�̔z��ϊ��B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�I�u�W�F�N�g��z��ɕϊ�����B
	 *   <TABLE width=40% border='1' bordercolor='redblue' cellpadding=2 cellspacing=0>
	 *    <TR><TD colspan=2>�����̃C���X�^���X��</TD></TR>
	 *    <TR><TD>null�̏ꍇ</TD><TD>Object[0]��ԋp</TD></TR>
	 *    <TR><TD>Object[]�̏ꍇ</TD><TD>���̂܂ܕԋp</TD></TR>
	 *    <TR><TD>Collection�̏ꍇ</TD><TD>�z��ɕϊ����ĕԋp</TD></TR>
	 *    <TR><TD>����ȊO�̏ꍇ</TD><TD>�v�f��1���z��Ƃ��ĕԋp</TD></TR>
	 *   </TABLE><P></P>
	 * </DL>
	 * @param obj �I�u�W�F�N�g
	 * @return �I�u�W�F�N�g��ϊ������z��
	 */
	@SuppressWarnings("rawtypes")
	private static Object[] toArray(Object obj) {
		if (obj == null) {
			return new Object[0];
		} else if (obj.getClass().isArray()) {
			return (Object[]) obj;
		} else if (obj instanceof Collection) {
			return ((Collection) obj).toArray();
		}
		return new Object[] { obj };
	}

	/**
	 * �I�u�W�F�N�g�̃��X�g�ϊ��B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�I�u�W�F�N�g�����X�g�ɕϊ�����B
	 *   <TABLE width=40% border='1' bordercolor='redblue' cellpadding=2 cellspacing=0>
	 *    <TR><TD colspan=2>�����̃C���X�^���X��</TD></TR>
	 *    <TR><TD>null�̏ꍇ</TD><TD>�v�f�������Ȃ�&lt;E&gt;�^�̃��X�g�Ƃ��ĕԋp</TD></TR>
	 *    <TR><TD>Object[]�̏ꍇ</TD><TD>&lt;E&gt;�^�̃��X�g�ɕϊ����ĕԋp</TD></TR>
	 *    <TR><TD>Collection�̏ꍇ</TD><TD>&lt;E&gt;�^�̃��X�g�Ƃ��ĕԋp</TD></TR>
	 *    <TR><TD>����ȊO�̏ꍇ</TD><TD>�v�f��1����&lt;E&gt;�^�̃��X�g�Ƃ��ĕԋp</TD></TR>
	 *   </TABLE><P></P>
	 * </DL>
	 * @param obj �I�u�W�F�N�g
	 * @param elementClass �ԋp���郊�X�g�̗v�f��\���^
	 * @return �I�u�W�F�N�g��ϊ��������X�g
	 * @throws IllegalArgumentException �s��������O
	 *         <UL>
	 *          <LI>����elementClass��null�̏ꍇ
	 *          <LI>obj�܂��͂��̗v�f��&lt;E&gt;�^�ł͂Ȃ��ꍇ
	 *         </UL>
	 */
	@SuppressWarnings("unchecked")
	public static <E> List<E> toList(Object obj, Class<E> elementClass)
			throws IllegalArgumentException {
		if (elementClass == null) {
			throw new IllegalArgumentException("Argument 'elementClass' ("
					+ Class.class.getName() + ") is null");
		}

		Object[] array = toArray(obj);
		List<E> result = new ArrayList<E>();
		for (Object element : array) {
			if (element != null
					&& !elementClass.isAssignableFrom(element.getClass())) {
				String message = "Unable to cast '"
						+ element.getClass().getName() + "' to '"
						+ elementClass.getName() + "'";
				throw new IllegalArgumentException(message,
						new ClassCastException(message));
			}
			result.add((E) element);
		}
		return result;
	}

	/**
	 * �Z�b�g�^�̃T�C�Y�ϊ��B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�n���ꂽ�Z�b�g�Ɋi�[����Ă���f�[�^���ɃZ�b�g�̃T�C�Y���k�����A�ԋp����B
	 *   <DD>�֌W���Z�q�n���h���[�Q�̃^�O�I���������\�b�h�Ŏg����B
	 * </DL>
	 * @param set �Z�b�g�i���T�C�Y�O�j
	 * @return �Z�b�g�i���T�C�Y��j
	 * @throws IllegalArgumentException ������null�̏ꍇ
	 */
	public static <E> Set<E> resizeSet(Set<E> set)
			throws IllegalArgumentException {
		if (set == null) {
			throw new IllegalArgumentException();
		}
		Set<E> result = new HashSet<E>(set.size());
		for (E element : set) {
			result.add((E) element);
		}
		return result;
	}

	/**
	 * �}�b�v�^�̃T�C�Y�ϊ��B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�n���ꂽ�}�b�v�Ɋi�[����Ă���f�[�^���Ƀ}�b�v�̃T�C�Y���k�����A�ԋp����B
	 * </DL>
	 * @see jp.iwin.pds.initialload.handler.PCHMapHandler
	 * @param map �}�b�v�i���T�C�Y�O�j
	 * @return �}�b�v�i���T�C�Y��j
	 * @throws IllegalArgumentException ������null�̏ꍇ
	 */
	public static <K,V> Map<K,V> resizeMap(Map<K,V> map)
			throws IllegalArgumentException {
		if (map == null) {
			throw new IllegalArgumentException();
		}
		Map<K,V> result = new HashMap<K,V>(map.size());
		for(Entry<K,V> e:map.entrySet()){
			result.put((K) e.getKey(),(V)e.getValue());
		}
		return result;
	}

	/**
	 * �I�u�W�F�N�g�̌^�ϊ��B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>����obj������dataType�̃f�[�^�^�ɕϊ�����B
	 * </DL>
	 * @param obj �I�u�W�F�N�g
	 * @param dataType �f�[�^�^
	 * @return �ϊ���̃I�u�W�F�N�g
	 * @throws IllegalArgumentException ����obj����dataType��null�̏ꍇ
	 * @throws ClassNotFoundException �N���X�������s��O
	 */
	@SuppressWarnings({ "unchecked" })
	public static <T> T convert(Object obj, String dataType)
			throws IllegalArgumentException {
		if (obj == null) {
			throw new IllegalArgumentException("Argument 'obj' ("
					+ Class.class.getName() + ") is null");
		}
		if (dataType == null) {
			throw new IllegalArgumentException("Argument 'dataType' ("
					+ Class.class.getName() + ") is null");
		}

		Class<T> clazz = null;

		try {
			clazz = (Class<T>) Class.forName(dataType);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e);
		}

		if(dataType.equals(PCTConstants.CODE_STRING)){
			return (T) ((String) convert(obj, clazz, true)).intern();
		}else if(dataType.equals(PCTConstants.CODE_BOOLEAN)){
			return (T) Boolean.valueOf((Boolean) convert(obj, clazz, true));
		}else{
			return convert(obj, clazz, true);
		}
	}

	/**
	 * �I�u�W�F�N�g�̌^�ϊ��B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�I�u�W�F�N�g��&lt;T&gt;�^�ɕϊ�����B
	 *  </DT>
	 * </DL>
	 * @param obj �I�u�W�F�N�g
	 * @param clazz �ϊ���̌^
	 * @param allowsNull ����obj��null�̏ꍇ�����e���邩�ǂ���
	 * @return �ϊ���̃I�u�W�F�N�g�B
	 *   <TABLE width=60% border='1' bordercolor='redblue' cellpadding=2 cellspacing=0>
	 *    <TR><TD>allowsNull��false����obj��null</TD><TD>��O���X���[</TD></TR>
	 *    <TR><TD>allowsNull��true����obj��null</TD><TD>null��ԋp</TD></TR>
	 *    <TR><TD>obj��clazz�^</TD><TD>���̂܂ܕԋp</TD></TR>
	 *    <TR><TD>obj��clazz�^�ł͂Ȃ�</TD><TD>{@link ConvertUtils}���g�p���ēK�؂Ȍ^�ɕϊ����ĕԋp
	 *    </TD></TR></TABLE><P></P>
	 * @throws IllegalArgumentException �s��������O
	 *         <UL>
	 *          <LI>����clazz��null�̏ꍇ
	 *          <LI>����allowsNull��false������obj��null�̏ꍇ
	 *          <LI>�ϊ��Ɏ��s�����ꍇ
	 *         </UL>
	 */
	@SuppressWarnings("unchecked")
	private static <T> T convert(Object obj, Class<T> clazz, boolean allowsNull)
			throws IllegalArgumentException {

		if (clazz.isAssignableFrom(obj.getClass())) {
			return (T) obj;
		}

		Object result = null;
		try {
			result = ConvertUtils.convert(obj.toString(), clazz);
		} catch (ConversionException e) {
			throw new IllegalArgumentException(e);
		}
		return (T) result;
	}

	/**
	 * �}�b�v���\�[�g�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�}�b�v�̃G���g�����L�[���Ƀ\�[�g����B
	 * </DL>
	 * @param map �}�b�v
	 * @return �G���g�����X�g�i�\�[�g��j
	 */
	public static List<Map.Entry<String, Object>> sortMap(
			Map<String, Object> map) {

		if (map == null) {
			map = new HashMap<String, Object>();
		}

		List<Map.Entry<String, Object>> entries = new ArrayList<Map.Entry<String, Object>>(
				map.entrySet());

		Collections.sort(entries, new PDMMapComparator());

		return entries;
	}

	/**
	 * �Z�b�g���\�[�g�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�Z�b�g��v�f���Ƀ\�[�g����B
	 * </DL>
	 * @param set �Z�b�g
	 * @return ���X�g�i�\�[�g��j
	 */
	public static List<Object> sortSet(Set<Object> set) {

		List<Object> list = toList(set, Object.class);

		Collections.sort(list, new PDMSetComparator());

		return list;
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
	 * csvString �� null/�󕶎� �������ꍇ�ɂ́A �v�f��0�̃��X�g�ɕϊ������B<br>
	 * �G�X�P�[�v����(�_�u���N�H�[�g)�̌�̃J���}�͋�؂蕶�� �Ƃ��Ă͔F�����Ȃ��B<br>
	 * �G�X�P�[�v����(�_�u���N�H�[�g)�̌�̃G�X�P�[�v�����̓G�X�P�[�v�����Ƃ��� �F�����Ȃ��B<br>
	 * ���s�iCRLF�j�A�_�u���N�H�[�g�A�J���}���܂ރt�B�[���h�́A�_�u���N�H�[�e�[�V�����ň͂ނׂ��ł���B
	 * </p>
	 *
	 * @param csvString
	 *            CSV�`���̕�����
	 * @return �J���}�ŕ������ꂽ�������v�f�Ɏ����X�g
	 */
	public static List<String> parseCSV(String csvString) {

		List<String> list = new ArrayList<String>();	// ���ڃ��X�g

		int commaPosition = 0;
		int quotePosition = 0;
		int escapePosition = 0;
		int returnPosition = 0;

		if(csvString.equals(BLANK)){
			return new ArrayList<String>();
		}

		// ���s�R�[�h�̈ʒu
		returnPosition = csvString.indexOf(RETURNCODE);
		if(returnPosition<0){
			returnPosition = Integer.MAX_VALUE;
		}
		// �G�X�P�[�v�̈ʒu�A�_�u���N�H�[�g�̈ʒu��indexOf�Ŏ擾���邩�ǂ����̃t���O
		boolean eFlg = true;
		boolean qFlg = true;

		while(true){
			commaPosition = csvString.indexOf(COMMA);
			if(qFlg && quotePosition!=Integer.MAX_VALUE){
				quotePosition = csvString.indexOf(QUOTE);
				if(quotePosition<0){
					quotePosition = Integer.MAX_VALUE;
				}
			}
			if(eFlg && escapePosition!=Integer.MAX_VALUE){
				escapePosition = csvString.indexOf(ESCAPE);
				if(escapePosition<0){
					escapePosition = Integer.MAX_VALUE;
				}
			}
			eFlg = qFlg = false;
			//�J���}����Ԑ�ɂ���ꍇ�A�J���}�܂ł��擾
			if(commaPosition>=0 && commaPosition<quotePosition && commaPosition<escapePosition && commaPosition<returnPosition){
				list.add(csvString.substring(0,commaPosition));
				csvString = csvString.substring(commaPosition+1);
				if(csvString.equals(BLANK)){
					list.add(BLANK);
					return list;
				}
				quotePosition -=(commaPosition+1);
				escapePosition -=(commaPosition+1);
				returnPosition -=(commaPosition+1);
			}else{
				//����ȊO�̏ꍇ�A�]���ʂ�̏���
				boolean inquote = false;					//�u"�v���O�t���O
				boolean first = true;						// ���ڐ擪�t���O
				int currentPosition = 0;					// �����񒆂̌��݂̈ʒu
				int endPosition = 0;			// ������̍Ō�̈ʒu
				int size = csvString.length();
				char[] chToken = new char[size];
				int pos = 0;

				endPosition = size;
				while ( currentPosition < endPosition ) {

					boolean addFlg=false;
					char ch = csvString.charAt(currentPosition);

					switch ( ch ){
						case QUOTE:
							qFlg = true;
							if ( inquote ) {
								// �����s�̏I���Ȃ炻���܂łŃ��^�[��
								if( currentPosition+1 >= endPosition ) {
									list.add(new String(chToken,0,pos));
									return list;
								}

								// �u"�v�̎��̕����𔻕�
								char nextch = csvString.charAt(currentPosition+1);
								switch( nextch ){
									// �擪���u"�v�Łu",�v�����o�����獀�ڂ̏I���
									case COMMA:
										inquote = false;
										currentPosition ++;
										list.add(new String(chToken,0,pos));		// ���X�g�ɍ��ڂ�ǉ�
										addFlg = true;
										break;

									// �擪���u"�v�Łu""�v���o�Ă����Ƃ��́A�P�����Ƃ��ĔF���B
									// �u"",�v���o�Ă����Ƃ��������OK
									case QUOTE:
										currentPosition ++;
										chToken[pos] = ch;
										pos++;
										break;

									// �擪���u"�v�Łu"(���s)�v�����o�����獀�ڂ̏I���
									// �{���Ȃ��͂�
									case RETURNCODE:
										list.add(new String(chToken));		// ���X�g�ɍ��ڂ�ǉ�
										return list;
									case ESCAPE:
										eFlg = true;
										break;
									default:
										break;
								}
							} else {
								// ���ڂ̐擪�Ȃ�u"�v���O�t���O�I��
								if( first ) {
									inquote = true;
									first = false;
								} else {// �擪�Ɂu"�v���Ȃ��ꍇ�Ɂu"�v���o�Ă����Ƃ��͖���
								}
							}
							break;

						case COMMA:
							if ( inquote ) {
								chToken[pos] = ch;
								pos++;
							} else {
								list.add(new String(chToken,0,pos));
								addFlg = true;
							}
							break;

						case ESCAPE:
							eFlg = true;
							// �����s�̏I���Ȃ牽�����Ȃ�
							if( currentPosition+1 >= endPosition ) {
								break;
							}
							if( first ){
								first = false;
							}
							// �u\�v�̎��̕����𔻕�
							char nextch = csvString.charAt(currentPosition+1);
							switch( nextch ) {
								case ESCAPE:		// �u\\�v���o�Ă����Ƃ��͕����Ƃ��ĔF��

									currentPosition ++;
									chToken[pos] = ch;
									pos++;
									break;
								case 'n':		// �u\n�v���o�Ă����Ƃ��͉��s�Ƃ��ĔF��
									currentPosition ++;
									chToken[pos] = RETURNCODE;
									pos++;
									break;
								default:
									break;
							}
							break;

						case RETURNCODE:	// ���s�R�[�h���o�Ă�����A�����ōs�̏I���Ƃ��āA�c��̃f�[�^�͔j��
							list.add(new String(chToken,0,pos));
							return list;

						default:		// ���ʂ̕����Ȃ獀�ڂ̕�����ɒǉ�
							if( first ){
								first = false;
							}
							chToken[pos] = ch;
							pos++;
					} // switch end
					// ���݈ʒu���C���N�������g
					currentPosition ++;

					// �s�̏I���܂ł����炻���܂ł��P���ڂƂ���
					if( currentPosition >= endPosition ) {
						if(addFlg){
							list.add("");
						}else{
							list.add(new String(chToken,0,pos));
						}
						return list;
					}

					if(addFlg){
						csvString = csvString.substring(currentPosition);
						quotePosition -=currentPosition;
						escapePosition -=currentPosition;
						returnPosition -=currentPosition;
						break;
					}
				} // while2 end
			}
		} // while1 end
	}
}
