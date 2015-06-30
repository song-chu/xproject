package jp.iwin.pds.xml2db.common.util;


import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.AttributesImpl;


    public class XMLWriter {

        private int depth = 0;
        private enum State {NOTHING, ELEMENT, DATA}
        private Stack<State> stateStack = new Stack<State>();

    	StringBuilder writer = new StringBuilder();

        public XMLWriter (StringBuilder sb)
        {
        	this.writer = sb;
        }

        public String getXML()
        {
        	return this.writer.toString();
        }

    	public void startElement(String uri, String localName, String qName,
    			Attributes atts)  {
    		this.stateStack.push(State.ELEMENT);
    		//this.state = State.NOTHING;
//
//    		if (this.depth > 0) {
//    			write('\n');
//    		}
//    		doIndent();

    		write('<');
    		writeName(uri, localName, qName, true);

    		if (atts != null) {
    			writeAttributes(atts);
    		}
    		write('>');

//    		this.depth++;
    	}

    	public void startElement(String localName)  {
    		startElement("", localName, "", null);
    	}

    	public void startElement(String localName, Attributes atts)
    			 {
    		startElement("", localName, "", atts);
    	}

    	public void endElement(String uri, String localName, String qName)
    			 {

//    		this.depth--;

//    		if (State.ELEMENT.equals(this.state)) {
//    			write('\n');
//    			doIndent();
//    		}
    		write("</");
    		writeName(uri, localName, qName, true);
    		write('>');
//    		this.state = this.stateStack.pop();
    	}

    	public void endElement(String localName)  {
    		endElement("", localName, "");
    	}

    	public void characters(char ch[], int start, int len)  {
    		//this.state = State.DATA;
    		writeEsc(ch, start, len, false);
    	}

    	public void emptyElement(String uri, String localName, String qName,
    			Attributes atts)  {

    		if (this.depth > 0) {
    			characters("\n");
    		}
    		//doIndent();
    		//this.state = State.ELEMENT;

    		write('<');
    		writeName(uri, localName, qName, true);

    		if (atts != null) {
    			writeAttributes(atts);
    		}
    		write("/>");
    	}

    	public void emptyElement(String localName, Attributes atts)
    			 {
    		emptyElement("", localName, "", atts);
    	}

    	public void emptyElement(String name)  {
    		emptyElement("", name, "", null);
    	}

    	public void dataElement(String uri, String localName, String qName,
    			Attributes atts, String content)  {
    		startElement(uri, localName, qName, atts);
    		characters(content);
    		endElement(uri, localName, qName);
    	}

    	public void dataElement(String localName, Attributes atts, String content)
    			 {
    		dataElement("", localName, "", atts, content);
    	}

    	public void dataElement(String localName, String content)
    			 {
    		dataElement("", localName, "", null, content);
    	}

    	public void characters(String content)  {
    		char ch[] = content.toCharArray();
    		characters(ch, 0, ch.length);
    	}

    	public void addAttribute(AttributesImpl elemAtts, String name, String value) {
    		elemAtts.addAttribute("", name, name, "CDATA", value);
    	}

    	private void write(char c)  {
    		writer.append(c);
    	}

    	private void write(String s)  {
    		writer.append(s);
    	}

    	private void writeAttributes(Attributes atts)  {
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

    	private void writeEsc(char ch[], int start, int length, boolean isAttVal)
    			 {
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

    	private void writeName(String uri, String localName, String qName,
    			boolean isElement)  {
    		write(localName);
    	}

    }

