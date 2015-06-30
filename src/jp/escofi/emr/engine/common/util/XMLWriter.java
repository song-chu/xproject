package jp.escofi.emr.engine.common.util;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Stack;

import jp.escofi.emr.engine.common.constant.Constants;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * XMLライター。
 * <DL>
 *	<DT>使用目的/機能概要：
 *	 <DD>
 *    <UL>
 *     <LI>XMLファイルを書き出すクラス。
 *    </UL>
 *  <DT>初版情報（作成日・作成者）：
 *   <DD>2011/08/01 EBS
 *  <DT>変更履歴（変更日、変更者、変更内容）：
 *   <DD>
 *    <UL>
 *     <LI>2011/08/01 EBS 新規作成
 *    </UL>
 * </DL>
 * <P>Copyright(c)2011 Earnest Business Solution Co.,Ltd.　All Rights Reserved</P>
 * @author EBS
 */
public class XMLWriter {

    /**
     * 出力（アウトプット）
     */
    private Writer output;
    /**
     * インデントステップ
     */
    private int indentStep = 0;
    /**
     * エレメントレベル
     */
    private int depth = 0;
    /**
     * ステートタイプ定義
     */
    private enum State {
    	/**
    	 * ステート：該当なし
    	 */
    	NOTHING,
    	/**
    	 * ステート：タグエレメント
    	 */
    	ELEMENT,
    	/**
    	 * ステート：タグデータ
    	 */
    	DATA
    }
    /**
     * ステート
     */
    private State state = State.NOTHING;
    /**
     * ステートスタック
     */
    private Stack<State> stateStack = new Stack<State>();

	/**
	 * コンストラクタ。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>出力を設定する。
	 * </DL>
     * @param writer ライター
     */
	public XMLWriter(Writer writer) {
		setOutput(writer);
	}

    /**
	 * フラッシュ。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>キャッシュに格納されたデータを書き出す。
	 * </DL>
     * @throws IOException ファイル入出力エラー
     */
	public void flush() throws IOException {
		output.flush();
	}

    /**
	 * 出力設定。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>ドキュメントの出力を設定する。
	 * </DL>
     * @param writer ライター
     */
	private void setOutput(Writer writer) {
		if (writer == null) {
			output = new OutputStreamWriter(System.out);
		} else {
			output = writer;
		}
	}

    /**
	 * インデントステップ設定。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>インデントステップを設定する。
	 * </DL>
     * @param indentStep インデントステップ
     */
	public void setIndentStep(int indentStep) {
		this.indentStep = indentStep;
	}

    /**
	 * ドキュメント開始。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>ドキュメントを開始する。
	 *   <DD>XML宣言部を書き出す。
	 * </DL>
     * @throws SAXException XML解析エラー
     */
	public void startDocument() throws SAXException {
		write("<?xml version=\"1.0\" encoding=\"" + Constants.XML_ENCODING + "\"?>\n");
	}

    /**
	 * ドキュメント終了。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>ドキュメントを終了する。
	 * </DL>
     * @throws SAXException XML解析エラー
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
	 * タグ開始書出し。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>開始タグを書き出す。
	 * </DL>
	 * @param uri ネームスペースURI
	 * @param localName タグのローカル名
	 * @param qName タグの修飾名
	 * @param atts アトリビュート情報
	 * @throws SAXException XML解析例外
	 */
	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
		stateStack.push(State.ELEMENT);
		state = State.NOTHING;

		if (depth > 0) {
			write('\n');
		}
		doIndent();

		write('<');
		writeName(uri, localName, qName, true);

		if (atts != null) {
			writeAttributes(atts);
		}
		write('>');

		depth++;
	}

	/**
	 * タグ開始書出し（タグ名のみ）。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>開始タグを書き出す。
	 * </DL>
     * @param localName タグのローカル名
     * @throws SAXException XML解析例外
     */
	public void startElement(String localName) throws SAXException {
		startElement("", localName, "", null);
	}

	/**
	 * タグ開始書出し（タグ名、アトリビュート情報）。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>開始タグを書き出す。
	 * </DL>
     * @param localName タグのローカル名
     * @param atts アトリビュート情報
     * @throws SAXException XML解析例外
     */
	public void startElement(String localName, Attributes atts)
			throws SAXException {
		startElement("", localName, "", atts);
	}

	/**
	 * タグ終了書出し。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>終了タグを書き出す。
	 * </DL>
	 * @param uri ネームスペースURI
	 * @param localName タグのローカル名
	 * @param qName タグの修飾名
	 * @throws SAXException XML解析例外
	 */
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		depth--;

		if (State.ELEMENT.equals(state)) {
			write('\n');
			doIndent();
		}
		write("</");
		writeName(uri, localName, qName, true);
		write('>');
		state = stateStack.pop();
	}

	/**
	 * タグ終了書込み（タグ名のみ）。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>終了タグを書き出す。
	 * </DL>
	 * @param localName タグのローカル名
	 * @throws SAXException XML解析例外
	 */
	public void endElement(String localName) throws SAXException {
		endElement("", localName, "");
	}

	/**
	 * 文字列書き出し。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>文字列書き出す。
	 * </DL>
	 * @param ch 文字列
	 * @param start 開始位置
	 * @param len 文字列の長さ
	 * @throws SAXException XML解析例外
	 */
	public void characters(char ch[], int start, int len) throws SAXException {
		state = State.DATA;
		writeEsc(ch, start, len, false);
	}

    /**
	 * エンプティタグ書き出し
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>エンプティタグを書き出す。
	 * </DL>
	 * @param uri ネームスペースURI
	 * @param localName タグのローカル名
	 * @param qName タグの修飾名
	 * @param atts アトリビュート情報
	 * @throws SAXException XML解析例外
	 */
	public void emptyElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {

		if (depth > 0) {
			characters("\n");
		}
		doIndent();
		state = State.ELEMENT;

		write('<');
		writeName(uri, localName, qName, true);

		if (atts != null) {
			writeAttributes(atts);
		}
		write("/>");
	}

    /**
     * エンプティタグ書込み（タグ名、アトリビュート情報）。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>エンプティタグを書き出す。
	 * </DL>
     * @param localName タグのローカル名
     * @param atts アトリビュート情報
     * @throws SAXException XML解析例外
     */
	public void emptyElement(String localName, Attributes atts)
			throws SAXException {
		emptyElement("", localName, "", atts);
	}

    /**
     * エンプティタグ書込み（タグ名のみ）。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>エンプティタグを書き出す。
	 * </DL>
     * @param name タグのローカル名
     * @throws SAXException XML解析例外
     */
	public void emptyElement(String name) throws SAXException {
		emptyElement("", name, "", null);
	}

    /**
	 * データタグ書き出し。
	 * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>開始タグ、タグ内容、終了タグを書き出す。
	 * </DL>
	 * @param uri ネームスペースURI
	 * @param localName タグのローカル名
	 * @param qName タグの修飾名
	 * @param atts アトリビュート情報
     * @param content タグ内容
	 * @throws SAXException XML解析例外
     */
	public void dataElement(String uri, String localName, String qName,
			Attributes atts, String content) throws SAXException {
		startElement(uri, localName, qName, atts);
		characters(content);
		endElement(uri, localName, qName);
	}

    /**
     * データタグ書き出し(タグ名、アトリビュート情報、タグ内容)。
     * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>開始タグ、タグ内容、終了タグを書き出す。
	 * </DL>
	 * @param localName タグのローカル名
	 * @param atts アトリビュート情報
     * @param content タグ内容
	 * @throws SAXException XML解析例外
     */
	public void dataElement(String localName, Attributes atts, String content)
			throws SAXException {
		dataElement("", localName, "", atts, content);
	}

    /**
     * データタグ書き出し(タグ名、タグ内容)。
     * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>開始タグ、タグ内容、終了タグを書き出す。
	 * </DL>
	 * @param localName タグのローカル名
     * @param content タグ内容
	 * @throws SAXException XML解析例外
     */
	public void dataElement(String localName, String content)
			throws SAXException {
		dataElement("", localName, "", null, content);
	}

    /**
     * 文字列書き出し。
     * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>文字列を書き出す。
	 * </DL>
	 * @param content 文字列
	 * @throws SAXException XML解析例外
     */
	public void characters(String content) throws SAXException {
		char ch[] = content.toCharArray();
		characters(ch, 0, ch.length);
	}

    /**
     * アトリビュート追加。
     * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>アトリビュートを追加する。
	 * </DL>
     * @param elemAtts アトリビュート
     * @param name アトリビュート名
     * @param value アトリビュート値
     */
	public void addAttribute(AttributesImpl elemAtts, String name, String value) {
		elemAtts.addAttribute("", name, name, "CDATA", value);
	}

    /**
     * 文字書き出し。
     * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>文字を書き出す。
	 * </DL>
	 * @param c 文字
	 * @throws SAXException XML解析例外
	 */
	private void write(char c) throws SAXException {
		try {
			output.write(c);
		} catch (IOException e) {
			throw new SAXException(e);
		}
	}

   /**
     * 文字列書き出し。
     * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>文字列を書き出す。
	 * </DL>
	 * @param s 文字列
	 * @throws SAXException XML解析例外
	 */
	private void write(String s) throws SAXException {
		try {
			output.write(s);
		} catch (IOException e) {
			throw new SAXException(e);
		}
	}

   /**
     * アトリビュート書き出し。
     * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>アトリビュートを書き出す。
	 * </DL>
	 * @param atts アトリビュート情報
	 * @throws SAXException XML解析例外
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
     * 特殊文字処理。
     * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>特殊文字を処理し、文字列を書き出す。
	 * </DL>
	 * @param ch 文字列
	 * @param start 開始位置
	 * @param length 文字列の長さ
	 * @param isAttVal アトリビュート可否
	 * @throws SAXException XML解析例外
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
     * ネーム書き出し。
     * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>タグ名又はアトリビュート名を書き出す。
	 * </DL>
	 * @param uri ネームスペースURI
	 * @param localName タグのローカル名
	 * @param qName タグの修飾名
	 * @param isElement エレメント可否
	 * @throws SAXException XML解析例外
	 */
	private void writeName(String uri, String localName, String qName,
			boolean isElement) throws SAXException {
		write(localName);
	}

   /**
     * インデント実行。
     * <DL>
	 *  <DT>使用目的/機能概要：
	 *   <DD>インデントを行う。
	 * </DL>
	 * @throws SAXException XML解析例外
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
