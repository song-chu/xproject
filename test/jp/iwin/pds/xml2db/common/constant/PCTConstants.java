package jp.iwin.pds.xml2db.common.constant;

/**
 * ���ʒ�`�B
 * <DL>
 *  <DT>�g�p�ړI/�@�\�T�v�F
 *   <DD>���ʒ�`�N���X�B
 *  <DT>�ŏI�J�����r�W�����F
 *   <DD>$Revision: 1230 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date:: 2010-12-09 15:44:09#$
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
 * @author $Author: park.js $
 */
public class PCTConstants {

	/**
	 * �����R�[�h:Cp943C
	 */
	public static final String CHARSET = System.getProperty("file.encoding", "Cp943C");

	/**
	 * ��������\��
	 */
	public static final String ATTR_NAME = "attrname";

	/**
	 * XML�G�������g���Fdatamodel
	 * 	 */
	public static final String ELEMENT_DATAMODEL = "datamodel";
	/**
	 * XML�G�������g���Fkeyitem
	 */
	public static final String ELEMENT_KEYITEM = "keyitem";
	/**
	 * XML�G�������g���Fattrname
	 */
	public static final String ELEMENT_ATTRNAME = "attrname";
	/**
	 * XML�G�������g���Fversion
	 */
	public static final String ELEMENT_VERSION = "version";
	/**
	 * XML�G�������g���Fpattern
	 */
	public static final String ELEMENT_PATTERN = "pattern";
	/**
	 * XML�G�������g���Fdate
	 */
	public static final String ELEMENT_DATE = "date";
	/**
	 * XML�G�������g���Fvalue
	 */
	public static final String ELEMENT_VALUE = "value";
	/**
	 * XML�G�������g���Fsingle
	 */
	public static final String ELEMENT_SINGLE = "single";
	/**
	 * XML�G�������g���Flist
	 */
	public static final String ELEMENT_LIST = "list";
	/**
	 * XML�G�������g���Felem
	 */
	public static final String ELEMENT_ELEM = "elem";
	/**
	 * XML�G�������g���Fmap
	 */
	public static final String ELEMENT_MAP = "map";
	/**
	 * XML�G�������g���Fentry
	 */
	public static final String ELEMENT_ENTRY = "entry";
	/**
	 * XML�G�������g���Frange
	 */
	public static final String ELEMENT_RANGE = "range";
	/**
	 * XML�G�������g���Fupper
	 */
	public static final String ELEMENT_UPPER = "upper";
	/**
	 * XML�G�������g���Flower
	 */
	public static final String ELEMENT_LOWER = "lower";
	/**
	 * XML�G�������g���Fobject
	 */
	public static final String ELEMENT_OBJECT = "object";


	/**
	 * XML�G�������g���Fcondition
	 */
	public static final String ELEMENT_CONDITION = "condition";
	/**
	 * XML�G�������g���Fif
	 */
	public static final String ELEMENT_IF = "if";
	/**
	 * XML�G�������g���Fapply
	 */
	public static final String ELEMENT_APPLY = "apply";
	/**
	 * XML�G�������g���Felse
	 */
	public static final String ELEMENT_ELSE = "else";
	/**
	 * XML�G�������g���Fresult
	 */
	public static final String ELEMENT_RESULT = "result";
	/**
	 * XML�G�������g���Fand
	 */
	public static final String ELEMENT_AND = "and";
	/**
	 * XML�G�������g���For
	 */
	public static final String ELEMENT_OR = "or";
	/**
	 * XML�G�������g���Feq
	 */
	public static final String ELEMENT_EQ = "eq";
	/**
	 * XML�G�������g���Fneq
	 */
	public static final String ELEMENT_NOTEQ = "neq";
	/**
	 * XML�G�������g���Fgt
	 */
	public static final String ELEMENT_GT = "gt";
	/**
	 * XML�G�������g���Fgeq
	 */
	public static final String ELEMENT_GEQ = "geq";
	/**
	 * XML�G�������g���Flt
	 */
	public static final String ELEMENT_LT = "lt";
	/**
	 * XML�G�������g���Fleq
	 */
	public static final String ELEMENT_LEQ = "leq";
	/**
	 * XML�G�������g���Fin
	 */
	public static final String ELEMENT_IN = "in";
	/**
	 * XML�G�������g���Fnotin
	 */
	public static final String ELEMENT_NOTIN = "notin";
	/**
	 * XML�G�������g���Fsubset
	 */
	public static final String ELEMENT_SUBSET = "subset";
	/**
	 * XML�G�������g���Fnsubset
	 */
	public static final String ELEMENT_NOTSUBSET = "nsubset";
	/**
	 * XML�G�������g���Fintersect
	 */
	public static final String ELEMENT_INTERSECT = "intersect";
	/**
	 * XML�G�������g���Fnintersect
	 */
	public static final String ELEMENT_NOTINTERSECT = "nintersect";
	/**
	 * XML�G�������g���Finclude
	 */
	public static final String ELEMENT_INCLUDE = "include";
	/**
	 * XML�G�������g���Fexclude
	 */
	public static final String ELEMENT_EXCLUDE = "exclude";
	/**
	 * XML�G�������g���Fstartswith
	 */
	public static final String ELEMENT_STARTSWITH = "startswith";
	/**
	 * XML�G�������g���Fnstartswith
	 */
	public static final String ELEMENT_NOTSTARTSWITH = "nstartswith";
	/**
	 * XML�G�������g���Fvar
	 */
	public static final String ELEMENT_VAR = "var";
	/**
	 * XML�G�������g���Fconst
	 */
	public static final String ELEMENT_CONST = "const";
	/**
	 * XML�G�������g���Fset
	 */
	public static final String ELEMENT_SET = "set";

	/**
	 * �����F�f�[�^���f����
	 */
	public static final String ATTRIBUTE_NAME = "name";
	/**
	 * �����F�V�[�P���X�ԍ�
	 */
	public static final String ATTRIBUTE_SEQ = "seq";
	/**
	 * �����F�t�@�C����
	 */
	public static final String ATTRIBUTE_FILE = "file";
	/**
	 * �����F�g��
	 */
	public static final String ATTRIBUTE_EXTENDSDM = "extendsdm";
	/**
	 * �����F�p�����t���O
	 */
	public static final String ATTRIBUTE_PARENTFLG = "parentflg";
	/**
	 * �����F�}�b�v���
	 */
	public static final String ATTRIBUTE_MAPTYPE = "maptype";
	/**
	 * �����F�g������
	 */
	public static final String ATTRIBUTE_EXTENDSITEM = "extendsitem";
	/**
	 * �����F�����l
	 */
	public static final String ATTRIBUTE_INITVALUE = "initvalue";
	/**
	 * �����F�L�[����
	 */
	public static final String ATTRIBUTE_KEY = "key";
	/**
	 * �����F�p�������
	 */
	public static final String ATTRIBUTE_ORG = "org";
	/**
	 * �����F�폜�t���O
	 */
	public static final String ATTRIBUTE_DELFLG = "delflg";
	/**
	 * �����F�������t���O
	 */
	public static final String ATTRIBUTE_CONDFLG = "condflg";
	/**
	 * �����F�X�e�[�^�X
	 */
	public static final String ATTRIBUTE_STATUS = "status";
	/**
	 * �����F����Java�f�[�^�^
	 */
	public static final String ATTRIBUTE_JAVADATATYPE = "javadatatype";
	/**
	 * �����F�܂ރt���O
	 */
	public static final String ATTRIBUTE_EQ = "eq";
	/**
	 * �����F�N���X��
	 */
	public static final String ATTRIBUTE_CLASSNAME = "classname";
	/**
	 * �����F�N���X���
	 */
	public static final String ATTRIBUTE_CLASSINFO = "classinfo";
	/**
	 * �����Fsubinfo
	 */
	public static final String ATTRIBUTE_SUBINFO = "subinfo";
	/**
	 * �����F�f�[�^���
	 */
	public static final String ATTRIBUTE_DATATYPE = "datatype";
	/**
	 * �����F�������ڎ擾���
	 */
	public static final String ATTRIBUTE_VARINFO = "varinfo";
	/**
	 * �����F�����l�܂�
	 */
	public static final String ATTRIBUTE_LOWEREQ = "lowereq";
	/**
	 * �����F����l�܂�
	 */
	public static final String ATTRIBUTE_UPPEREQ = "uppereq";

	/**
	 * �}�b�v��ʁFHashMap
	 */
	public static final String CODE_HASHMAP = "hashmap";
	/**
	 * �}�b�v��ʁFTreeMap
	 */
	public static final String CODE_TREEMAP = "treemap";
	/**
	 * �p����f�[�^���f�����F�e
	 */
	public static final String ATTRNAME_PARENT = "attrnameParent";
	/**
	 * �p����f�[�^���f�����F�q
	 */
	public static final String ATTRNAME_CHILD = "attrnameChild";
	/**
	 * �f�[�^�^�C�v�FInteger�^
	 */
	public static final String CODE_INTEGER = "java.lang.Integer";
	/**
	 * �f�[�^�^�C�v�FLong�^
	 */
	public static final String CODE_LONG = "java.lang.Long";
	/**
	 * �f�[�^�^�C�v�FDouble�^
	 */
	public static final String CODE_DOUBLE = "java.lang.Double";
	/**
	 * �f�[�^�^�C�v�FString�^
	 */
	public static final String CODE_STRING ="java.lang.String";
	/**
	 * �f�[�^�^�C�v�FBoolean�^
	 */
	public static final String CODE_BOOLEAN ="java.lang.Boolean";
	/**
	 * �f�[�^�^�C�v�FBigDecimal�^
	 */
	public static final String CODE_BICDECIMAL ="java.math.BigDecimal";
	/**
	 * �f�[�^���f�����Fall
	 */
	public static final String DATAMODEL_ALL ="all";

	/**
	 * JDBC�h���C�o
	 */
	public static final String JDBC_DRIVER ="jdbc.driver";
	/**
	 * JDBC URL
	 */
	public static final String JDBC_URL ="jdbc.url";
	/**
	 * JDBC ���[�U��
	 */
	public static final String JDBC_USERNAME = "jdbc.username";
	/**
	 * JDBC �p�X���[�h
	 */
	public static final String JDBC_PASSWORD = "jdbc.password";

}
