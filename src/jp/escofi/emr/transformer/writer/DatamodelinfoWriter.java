package jp.escofi.emr.transformer.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import jp.escofi.emr.engine.common.constant.AttributeType;
import jp.escofi.emr.engine.common.constant.ElementType;
import jp.escofi.emr.engine.common.constant.MessageCode;
import jp.escofi.emr.engine.common.exception.EMRException;
import jp.escofi.emr.engine.common.util.XMLWriter;
import jp.escofi.emr.transformer.constant.PDSConstants;
import jp.escofi.emr.transformer.sql.DatamodelMapper;

import org.apache.ibatis.session.SqlSession;
import org.xml.sax.SAXException;


/**
 * �f�[�^���f����񃉃C�^�[�B
 * <DL>
 *	<DT>�g�p�ړI/�@�\�T�v�F
 *	 <DD>XML�Ǘ��t�@�C���̃f�[�^���f�����({@code <datamodelinfo>})�ȉ��̗v�f���o�͂���XML���C�^�[�B
 *  <DT>���ŏ��i�쐬���E�쐬�ҁj�F
 *   <DD>2011/08/01 EBS
 *  <DT>�ύX�����i�ύX���A�ύX�ҁA�ύX���e�j�F
 *   <DD>
 *    <UL>
 *     <LI>2011/08/01 EBS �V�K�쐬
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Earnest Business Solution Co.,Ltd.�@All Rights Reserved</P>
 * @author EBS
 */
public final class DatamodelinfoWriter extends AbstractXmlWriter {

	/**
	 * �Č��ԍ�
	 */
	private String productCd;
	/**
	 * XML�o�͐�
	 */
	private String xmlBase;


	/**
	 * �R���X�g���N�^�B
	 * <UL>
	 *  <LI>�p�����R���X�g���N�^�ďo���B</LI>
	 *  <LI>�������N���X�ϐ��֕ێ�����B</LI>
	 * </UL>
	 * @param productCd �Č��ԍ�
	 * @param xmlBase XML�o�͐�
	 */
	public DatamodelinfoWriter(String productCd, String xmlBase) {
		super(ElementType.DATA_MODEL_INFO);
		this.productCd = productCd;
		this.xmlBase = xmlBase;
	}


	/**
	 * �o�͏��ҏW�����B
	 * <OL>
	 *  <LI>�ϐ��F�f�[�^���f�����ҏW�}�b�v��V�KLinkedHashMap�ŏ���������B</LI>
	 *  <LI>�f�[�^���f�����o���s���B</LI>
	 *  <LI>���o�����f�[�^���f�������A�ȉ��̏������s���B
	 *   <OL>
	 *    <LI>�f�[�^���f������A�p�����f�[�^���f�������擾����B</LI>
	 *    <LI>�p�����f�[�^���f�������擾�ł����ꍇ�́A�ȉ��̏������s���B
	 *     <OL>
	 *      <LI>�ϐ��F�f�[�^���f�����ҏW�}�b�v����A
	 *�p�����f�[�^���f�������L�[�ɁA�f�[�^���f�����擾����B</LI>
	 *      <LI>�擾�����f�[�^���f���̌p�����f�[�^���f���t���O��true�ɐݒ肷��B</LI>
	 *     </OL>
	 *    </LI>
	 *    <LI>�f�[�^���f���̃^�O���e�ҏW�������ďo���B</LI>
	 *    <LI>�p�����N���X�ϐ��F�q�^�O�Z�b�g�ɁA�f�[�^���f����ǉ�����B</LI>
	 *    <LI>�ϐ��F�f�[�^���f�����ҏW�}�b�v�ɁA�f�[�^���f�������L�[�Ƃ��āA
	 *�f�[�^���f����ǉ�����B</LI>
	 *   </OL>
	 *  </LI>
	 * </OL>
	 * @param session DB�Z�b�V����
	 * @throws EMRException �Ɩ���O
	 */
	private void init(SqlSession session) throws EMRException {
		Map<String, DatamodelWriter> dataModelMap = new LinkedHashMap<String, DatamodelWriter>();
		DatamodelMapper mapper = session.getMapper(DatamodelMapper.class);
		List<DatamodelWriter> writers = mapper.select(productCd);

		if (writers.isEmpty()) {
			throw new EMRException(MessageCode.EMR_B_P912E, new Object[] {
					productCd });
		}
		for (DatamodelWriter writer : writers) {
			String extendsDm = writer.getExtendsDm();

			if (extendsDm != null) {
				dataModelMap.get(extendsDm).setParentDmFlg(true);
			}
			writer.init(session, productCd);

			String key = writer.getAttribute(AttributeType.NAME);

			dataModelMap.put(key, writer);
		}
		childSet.addAll(dataModelMap.values());
	}

	/**
	 * XML�o�͏����B
	 * <OL>
	 *  <LI>�o�͏��ҏW����</LI>
	 *  <LI>XML�Ǘ��t�@�C����XML���C�^�[���擾����B</LI>
	 *  <LI>XML���C�^�[�ɏo�͂���XML�̃C���f���g����ݒ肵�āAXML�o�͂��J�n����B</LI>
	 *  <LI>�f�[�^���f�����^�O�̓��e���o�͂���B</LI>
	 *  <LI>XML���C�^�[��XML�o�͂��I������B</LI>
	 *  <LI>�p�����N���X�ϐ��F�q�^�O�Z�b�g�̃C�e���[�^���擾���A
	 *�C�e���[�^�Ŏ��������Ȃ�܂ňȉ��̏������J�Ԃ��B
	 *   <OL>
	 *    <LI>�C�e���[�^����A�q�^�O(�f�[�^���f��)���C�^�[���擾����B</LI>
	 *    <LI>�f�[�^���f�����C�^�[����A�t�@�C�������擾����B</LI>
	 *    <LI>�f�[�^���f���t�@�C����XML���C�^�[���擾����B</LI>
	 *    <LI>XML���C�^�[�ɏo�͂���XML�̃C���f���g����ݒ肵�āAXML�o�͂��J�n����B</LI>
	 *    <LI>�f�[�^���f�����C�^�[�̃f�[�^���f���o�͏������ďo���B</LI>
	 *    <LI>XML���C�^�[��XML�o�͂��I������B</LI>
	 *    <LI>�C�e���[�^����o�͂����f�[�^���f�����C�^�[���폜����B</LI>
	 *   </OL>
	 *  </LI>
	 * </OL>
	 * @param session SQL�Z�b�V����
	 * @throws SAXException XML�o�͗�O
	 * @throws IOException �t�@�C�����o�͗�O
	 * @throws EMRException �Ɩ���O
	 * @throws ParserConfigurationException XML��͐ݒ��O
	 */
	public void write(SqlSession session)
	throws SAXException, IOException, EMRException, ParserConfigurationException {

		init(session);

		XMLWriter writer = getWriter(PDSConstants.FILE_META.toString());

		writer.setIndentStep(4);
		writer.startDocument();

		startElement(writer);
		outputBody(writer);
		endElement(writer);

		writer.endDocument();

		Iterator<AbstractXmlWriter> ite = childSet.iterator();

		while (ite.hasNext()) {
			AbstractXmlWriter child = ite.next();
			String fileName = child.getAttribute(AttributeType.FILE);

			writer = getWriter(fileName);
			writer.setIndentStep(4);
			writer.startDocument();

			((DatamodelWriter) child).writeDataModel(writer, session);

			writer.endDocument();
			ite.remove();
		}
	}


	/**
	 * XML���C�^�[�擾�B
	 * <OL>
	 *  <LI>XML�t�@�C���p�X�ҏW</LI>
	 *  <LI>�t�@�C�������݃`�F�b�N(�t�@�C�������A�������̓t�@�C��������)</LI>
	 *  <LI>�t�@�C�������݃`�F�b�N�����s�����ꍇ�́AEMRxception�𐶐��Athrow����B</LI>
	 *  <LI>XML�t�@�C���p�X����A�t�@�C���o�͂𐶐�����B</LI>
	 *  <LI>���������R�[�h�萔����A�����R�[�h�Z�b�g�𐶐�����B</LI>
	 *  <LI>�t�@�C���o�́A�����R�[�h�Z�b�g����A�o�̓��C�^�[�𐶐�����B</LI>
	 *  <LI>�o�̓��C�^�[����AXML���C�^�[�𐶐����ĕԋp����B</LI>
	 * </OL>
	 * @param fileName �o�͂���t�@�C����
	 * @return �w�肵���t�@�C���փf�[�^���o�͂���XML���C�^�[
	 * @throws IOException �t�@�C�����o�͗�O
	 * @throws EMRException �t�@�C�������݃`�F�b�N�G���[
	 */
	private XMLWriter getWriter(String fileName) throws IOException, EMRException {
		File xmlFile = new File(xmlBase + File.separator + fileName);

		if (!xmlFile.createNewFile() && !xmlFile.canWrite()) {
			throw new EMRException(MessageCode.EMR_B_P904E, new Object[] { xmlFile.getAbsolutePath() });
		}
		FileOutputStream out = new FileOutputStream(xmlFile);
		Charset cSet = Charset.forName(PDSConstants.CHARSET.toString());

		return new XMLWriter(new OutputStreamWriter(out, cSet));
	}

}
