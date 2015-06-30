package jp.iwin.pds.xml2db.common.util;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Stack;

import jp.iwin.pds.xml2db.common.constant.PCTConstants;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * XML���C�^�[�B
 * <DL>
 *	<DT>�g�p�ړI/�@�\�T�v�F
 *	 <DD>
 *    <UL>
 *     <LI>XML�t�@�C���������o���N���X�B
 *    </UL>
 *  <DT>�ŏI�J�����r�W�����F
 *    <DD>$Revision: 1748 $
 *  <DT>�ŏI�J�������F
 *   <DD>$Date:: 2010-12-17 10:02:44 +0900#$
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
public class PUTXMLWriter {

    /**
     * �o�́i�A�E�g�v�b�g�j
     */
    private Writer output;
    /**
     * �C���f���g�X�e�b�v
     */
    private int indentStep = 0;
    /**
     * �G�������g���x��
     */
    private int depth = 0;
    /**
     * �X�e�[�g�^�C�v��`
     */
    private enum State {NOTHING, ELEMENT, DATA}
    /**
     * �X�e�[�g
     */
    private State state = State.NOTHING;
    /**
     * �X�e�[�g�X�^�b�N
     */
    private Stack<State> stateStack = new Stack<State>();

	/**
	 * �R���X�g���N�^�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�o�͂�ݒ肷��B
	 * </DL>
     * @param writer ���C�^�[
     */
	public PUTXMLWriter(Writer writer) {
		setOutput(writer);
	}

    /**
	 * �t���b�V���B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�L���b�V���Ɋi�[���ꂽ�f�[�^�������o���B
	 * </DL>
     * @throws IOException �t�@�C�����o�̓G���[
     */
	public void flush() throws IOException {
		output.flush();
	}

    /**
	 * �o�͐ݒ�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�h�L�������g�̏o�͂�ݒ肷��B
	 * </DL>
     * @param writer ���C�^�[
     */
	private void setOutput(Writer writer) {
		if (writer == null) {
			output = new OutputStreamWriter(System.out);
		} else {
			output = writer;
		}
	}

    /**
	 * �C���f���g�X�e�b�v�ݒ�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�C���f���g�X�e�b�v��ݒ肷��B
	 * </DL>
     * @param indentStep �C���f���g�X�e�b�v
     */
	public void setIndentStep(int indentStep) {
		this.indentStep = indentStep;
	}

    /**
	 * �h�L�������g�J�n�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�h�L�������g���J�n����B
	 *   <DD>XML�錾���������o���B
	 * </DL>
     * @throws SAXException XML��̓G���[
     */
	public void startDocument() throws SAXException {
		write("<?xml version=\"1.0\" encoding=\"Shift_JIS\"?>\n");
	}

    /**
	 * �h�L�������g�I���B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�h�L�������g���I������B
	 * </DL>
     * @throws SAXException XML��̓G���[
     */
	public void endDocument() throws SAXException {
		write('\n');
		try {
			flush();
		} catch (IOException e) {
			throw new SAXException(e);
		}
	}

	/**
	 * �^�O�J�n���o���B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�J�n�^�O�������o���B
	 * </DL>
	 * @param uri �l�[���X�y�[�XURI
	 * @param localName �^�O�̃��[�J����
	 * @param qName �^�O�̏C����
	 * @param atts �A�g���r���[�g���
	 * @throws SAXException XML��͗�O
	 */
	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
		this.stateStack.push(State.ELEMENT);
		this.state = State.NOTHING;

		if (this.depth > 0) {
			write('\n');
		}
		doIndent();

		write('<');
		writeName(uri, localName, qName, true);

		if (atts != null) {
			writeAttributes(atts);
		}
		write('>');

		this.depth++;
	}

	/**
	 * �^�O�J�n���o���i�^�O���̂݁j�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�J�n�^�O�������o���B
	 * </DL>
     * @param localName �^�O�̃��[�J����
     * @throws SAXException XML��͗�O
     */
	public void startElement(String localName) throws SAXException {
		startElement("", localName, "", null);
	}

	/**
	 * �^�O�J�n���o���i�^�O���A�A�g���r���[�g���j�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�J�n�^�O�������o���B
	 * </DL>
     * @param localName �^�O�̃��[�J����
     * @param atts �A�g���r���[�g���
     * @throws SAXException XML��͗�O
     */
	public void startElement(String localName, Attributes atts)
			throws SAXException {
		startElement("", localName, "", atts);
	}

	/**
	 * �^�O�I�����o���B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�I���^�O�������o���B
	 * </DL>
	 * @param uri �l�[���X�y�[�XURI
	 * @param localName �^�O�̃��[�J����
	 * @param qName �^�O�̏C����
	 * @throws SAXException XML��͗�O
	 */
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		this.depth--;

		if (State.ELEMENT.equals(this.state)) {
			write('\n');
			doIndent();
		}
		write("</");
		writeName(uri, localName, qName, true);
		write('>');
		this.state = this.stateStack.pop();
	}

	/**
	 * �^�O�I�������݁i�^�O���̂݁j�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�I���^�O�������o���B
	 * </DL>
	 * @param localName �^�O�̃��[�J����
	 * @throws SAXException XML��͗�O
	 */
	public void endElement(String localName) throws SAXException {
		endElement("", localName, "");
	}

	/**
	 * �����񏑂��o���B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�����񏑂��o���B
	 * </DL>
	 * @param ch ������
	 * @param start �J�n�ʒu
	 * @param len ������̒���
	 * @throws SAXException XML��͗�O
	 */
	public void characters(char ch[], int start, int len) throws SAXException {
		this.state = State.DATA;
		writeEsc(ch, start, len, false);
	}

    /**
	 * �G���v�e�B�^�O�����o��
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�G���v�e�B�^�O�������o���B
	 * </DL>
	 * @param uri �l�[���X�y�[�XURI
	 * @param localName �^�O�̃��[�J����
	 * @param qName �^�O�̏C����
	 * @param atts �A�g���r���[�g���
	 * @throws SAXException XML��͗�O
	 */
	public void emptyElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {

		if (this.depth > 0) {
			characters("\n");
		}
		doIndent();
		this.state = State.ELEMENT;

		write('<');
		writeName(uri, localName, qName, true);

		if (atts != null) {
			writeAttributes(atts);
		}
		write("/>");
	}

    /**
     * �G���v�e�B�^�O�����݁i�^�O���A�A�g���r���[�g���j�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�G���v�e�B�^�O�������o���B
	 * </DL>
     * @param localName �^�O�̃��[�J����
     * @param atts �A�g���r���[�g���
     * @throws SAXException XML��͗�O
     */
	public void emptyElement(String localName, Attributes atts)
			throws SAXException {
		emptyElement("", localName, "", atts);
	}

    /**
     * �G���v�e�B�^�O�����݁i�^�O���̂݁j�B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�G���v�e�B�^�O�������o���B
	 * </DL>
     * @param localName �^�O�̃��[�J����
     * @throws SAXException XML��͗�O
     */
	public void emptyElement(String name) throws SAXException {
		emptyElement("", name, "", null);
	}

    /**
	 * �f�[�^�^�O�����o���B
	 * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�J�n�^�O�A�^�O���e�A�I���^�O�������o���B
	 * </DL>
	 * @param uri �l�[���X�y�[�XURI
	 * @param localName �^�O�̃��[�J����
	 * @param qName �^�O�̏C����
	 * @param atts �A�g���r���[�g���
     * @param content �^�O���e
	 * @throws SAXException XML��͗�O
     */
	public void dataElement(String uri, String localName, String qName,
			Attributes atts, String content) throws SAXException {
		startElement(uri, localName, qName, atts);
		characters(content);
		endElement(uri, localName, qName);
	}

    /**
     * �f�[�^�^�O�����o��(�^�O���A�A�g���r���[�g���A�^�O���e)�B
     * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�J�n�^�O�A�^�O���e�A�I���^�O�������o���B
	 * </DL>
	 * @param localName �^�O�̃��[�J����
	 * @param atts �A�g���r���[�g���
     * @param content �^�O���e
	 * @throws SAXException XML��͗�O
     */
	public void dataElement(String localName, Attributes atts, String content)
			throws SAXException {
		dataElement("", localName, "", atts, content);
	}

    /**
     * �f�[�^�^�O�����o��(�^�O���A�A�g���r���[�g���A�^�O���e)�B
     * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�J�n�^�O�A�^�O���e�A�I���^�O�������o���B
	 * </DL>
	 * @param localName �^�O�̃��[�J����
     * @param content �^�O���e
	 * @throws SAXException XML��͗�O
     */
	public void dataElement(String localName, String content)
			throws SAXException {
		dataElement("", localName, "", null, content);
	}

    /**
     * �����񏑂��o���B
     * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>������������o���B
	 * </DL>
	 * @param content ������
	 * @throws SAXException XML��͗�O
     */
	public void characters(String content) throws SAXException {
		char ch[] = content.toCharArray();
		characters(ch, 0, ch.length);
	}

    /**
     * �A�g���r���[�g�ǉ��B
     * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�A�g���r���[�g��ǉ�����B
	 * </DL>
     * @param elemAtts �A�g���r���[�g
     * @param name �A�g���r���[�g��
     * @param value �A�g���r���[�g�l
     */
	public void addAttribute(AttributesImpl elemAtts, String name, String value) {
		elemAtts.addAttribute("", name, name, "CDATA", value);
	}

    /**
     * ���������o���B
     * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�����������o���B
	 * </DL>
	 * @param c ����
	 * @throws SAXException XML��͗�O
	 */
	private void write(char c) throws SAXException {
		try {
			output.write(c);
		} catch (IOException e) {
			throw new SAXException(e);
		}
	}

   /**
     * �����񏑂��o���B
     * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>������������o���B
	 * </DL>
	 * @param s ������
	 * @throws SAXException XML��͗�O
	 */
	private void write(String s) throws SAXException {
		try {
			output.write(s);
		} catch (IOException e) {
			throw new SAXException(e);
		}
	}

   /**
     * �A�g���r���[�g�����o���B
     * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�A�g���r���[�g�������o���B
	 * </DL>
	 * @param atts �A�g���r���[�g���
	 * @throws SAXException XML��͗�O
	 */
	private void writeAttributes(Attributes atts) throws SAXException {
		int len = atts.getLength();
		for (int i = 0; i < len; i++) {
			char ch[] = atts.getValue(i).toCharArray();
			write(' ');
			writeName(atts.getURI(i), atts.getLocalName(i), atts.getQName(i),
					false);
			write("=\"");
			writeEsc(ch, 0, ch.length, true);
			write('"');
		}
	}

   /**
     * ���ꕶ�������B
     * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>���ꕶ�����������A������������o���B
	 * </DL>
	 * @param ch ������
	 * @param start �J�n�ʒu
	 * @param len ������̒���
	 * @param isAttVal �A�g���r���[�g��
	 * @throws SAXException XML��͗�O
     */
	private void writeEsc(char ch[], int start, int length, boolean isAttVal)
			throws SAXException {
		for (int i = start; i < start + length; i++) {
			switch (ch[i]) {
			case '&':
				write("&amp;");
				break;
			case '<':
				write("&lt;");
				break;
			case '>':
				write("&gt;");
				break;
			case '\"':
				if (isAttVal) {
					write("&quot;");
				} else {
					write('\"');
				}
				break;
			case '\'':
				if (isAttVal) {
					write("&apos;");
				} else {
					write('\'');
				}
				break;
			default:
				write(ch[i]);
			}
		}
	}

   /**
     * �l�[�������o���B
     * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�^�O�����̓A�g���r���[�g���������o���B
	 * </DL>
	 * @param uri �l�[���X�y�[�XURI
	 * @param localName �^�O�̃��[�J����
	 * @param qName �^�O�̏C����
	 * @param isElement �G�������g��
	 * @throws SAXException XML��͗�O
	 */
	private void writeName(String uri, String localName, String qName,
			boolean isElement) throws SAXException {
		write(localName);
	}

   /**
     * �C���f���g���s�B
     * <DL>
	 *  <DT>�g�p�ړI/�@�\�T�v�F
	 *   <DD>�C���f���g���s���B
	 * </DL>
	 * @throws SAXException XML��͗�O
	 */
	private void doIndent() throws SAXException {
		if (indentStep > 0 && depth > 0) {
			int n = indentStep * depth;
			char ch[] = new char[n];
			for (int i = 0; i < n; i++) {
				ch[i] = ' ';
			}
			characters(ch, 0, n);
		}
	}
}
