package org.overrun.mechanicalkineticenergy.antlr.loadYaml;// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class YamlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, ID=4, LINE_COMMENT=5, WS=6, TAB=7;
	public static final int
		RULE_yaml = 0, RULE_y = 1, RULE_code = 2, RULE_listCode = 3, RULE_codeT = 4, 
		RULE_tabCode = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"yaml", "y", "code", "listCode", "codeT", "tabCode"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "': '", "'- '", "':'", null, null, "'\\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "ID", "LINE_COMMENT", "WS", "TAB"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public YamlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YamlContext extends ParserRuleContext {
		public List<YContext> y() {
			return getRuleContexts(YContext.class);
		}
		public YContext y(int i) {
			return getRuleContext(YContext.class,i);
		}
		public YamlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yaml; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlListener) ((YamlListener)listener).enterYaml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlListener) ((YamlListener)listener).exitYaml(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YamlVisitor) return ((YamlVisitor<? extends T>)visitor).visitYaml(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YamlContext yaml() throws RecognitionException {
		YamlContext _localctx = new YamlContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_yaml);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(12);
				y();
				}
				}
				setState(15); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID || _la==TAB );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YContext extends ParserRuleContext {
		public CodeTContext codeT() {
			return getRuleContext(CodeTContext.class,0);
		}
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public TabCodeContext tabCode() {
			return getRuleContext(TabCodeContext.class,0);
		}
		public YContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_y; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlListener) ((YamlListener)listener).enterY(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlListener) ((YamlListener)listener).exitY(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YamlVisitor) return ((YamlVisitor<? extends T>)visitor).visitY(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YContext y() throws RecognitionException {
		YContext _localctx = new YContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_y);
		try {
			setState(20);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(17);
				codeT();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(18);
				code();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(19);
				tabCode();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CodeContext extends ParserRuleContext {
		public Token pre;
		public Token sub;
		public List<TerminalNode> ID() { return getTokens(YamlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(YamlParser.ID, i);
		}
		public CodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlListener) ((YamlListener)listener).enterCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlListener) ((YamlListener)listener).exitCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YamlVisitor) return ((YamlVisitor<? extends T>)visitor).visitCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_code);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			((CodeContext)_localctx).pre = match(ID);
			setState(23);
			match(T__0);
			setState(24);
			((CodeContext)_localctx).sub = match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListCodeContext extends ParserRuleContext {
		public Token tabs;
		public Token list;
		public TerminalNode TAB() { return getToken(YamlParser.TAB, 0); }
		public TerminalNode ID() { return getToken(YamlParser.ID, 0); }
		public ListCodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listCode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlListener) ((YamlListener)listener).enterListCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlListener) ((YamlListener)listener).exitListCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YamlVisitor) return ((YamlVisitor<? extends T>)visitor).visitListCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListCodeContext listCode() throws RecognitionException {
		ListCodeContext _localctx = new ListCodeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_listCode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			((ListCodeContext)_localctx).tabs = match(TAB);

			    var a = YamlLexer.getspaceCount(((ListCodeContext)_localctx).tabs.getText()) / 2;
			    System.out.println(a);

			setState(28);
			match(T__1);
			setState(29);
			((ListCodeContext)_localctx).list = match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CodeTContext extends ParserRuleContext {
		public Token tabs;
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public TerminalNode TAB() { return getToken(YamlParser.TAB, 0); }
		public CodeTContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codeT; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlListener) ((YamlListener)listener).enterCodeT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlListener) ((YamlListener)listener).exitCodeT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YamlVisitor) return ((YamlVisitor<? extends T>)visitor).visitCodeT(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeTContext codeT() throws RecognitionException {
		CodeTContext _localctx = new CodeTContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_codeT);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			((CodeTContext)_localctx).tabs = match(TAB);

			    var a = YamlLexer.getspaceCount(((CodeTContext)_localctx).tabs.getText()) / 2;
			    System.out.println(a);

			setState(33);
			code();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TabCodeContext extends ParserRuleContext {
		public Token pre;
		public Token tabs;
		public TerminalNode ID() { return getToken(YamlParser.ID, 0); }
		public TerminalNode TAB() { return getToken(YamlParser.TAB, 0); }
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public CodeTContext codeT() {
			return getRuleContext(CodeTContext.class,0);
		}
		public TabCodeContext tabCode() {
			return getRuleContext(TabCodeContext.class,0);
		}
		public ListCodeContext listCode() {
			return getRuleContext(ListCodeContext.class,0);
		}
		public TabCodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tabCode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlListener) ((YamlListener)listener).enterTabCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlListener) ((YamlListener)listener).exitTabCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YamlVisitor) return ((YamlVisitor<? extends T>)visitor).visitTabCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TabCodeContext tabCode() throws RecognitionException {
		TabCodeContext _localctx = new TabCodeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tabCode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			((TabCodeContext)_localctx).pre = match(ID);
			setState(36);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==T__2) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(37);
			((TabCodeContext)_localctx).tabs = match(TAB);

			    var a = YamlLexer.getspaceCount(((TabCodeContext)_localctx).tabs.getText()) / 2;
			    System.out.println(a);

			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(39);
				code();
				}
				break;
			case 2:
				{
				setState(40);
				codeT();
				}
				break;
			case 3:
				{
				setState(41);
				tabCode();
				}
				break;
			case 4:
				{
				setState(42);
				listCode();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0007.\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0004\u0000\u000e\b\u0000\u000b\u0000\f"+
		"\u0000\u000f\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u0015\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005,\b\u0005\u0001\u0005"+
		"\u0000\u0000\u0006\u0000\u0002\u0004\u0006\b\n\u0000\u0001\u0002\u0000"+
		"\u0001\u0001\u0003\u0003-\u0000\r\u0001\u0000\u0000\u0000\u0002\u0014"+
		"\u0001\u0000\u0000\u0000\u0004\u0016\u0001\u0000\u0000\u0000\u0006\u001a"+
		"\u0001\u0000\u0000\u0000\b\u001f\u0001\u0000\u0000\u0000\n#\u0001\u0000"+
		"\u0000\u0000\f\u000e\u0003\u0002\u0001\u0000\r\f\u0001\u0000\u0000\u0000"+
		"\u000e\u000f\u0001\u0000\u0000\u0000\u000f\r\u0001\u0000\u0000\u0000\u000f"+
		"\u0010\u0001\u0000\u0000\u0000\u0010\u0001\u0001\u0000\u0000\u0000\u0011"+
		"\u0015\u0003\b\u0004\u0000\u0012\u0015\u0003\u0004\u0002\u0000\u0013\u0015"+
		"\u0003\n\u0005\u0000\u0014\u0011\u0001\u0000\u0000\u0000\u0014\u0012\u0001"+
		"\u0000\u0000\u0000\u0014\u0013\u0001\u0000\u0000\u0000\u0015\u0003\u0001"+
		"\u0000\u0000\u0000\u0016\u0017\u0005\u0004\u0000\u0000\u0017\u0018\u0005"+
		"\u0001\u0000\u0000\u0018\u0019\u0005\u0004\u0000\u0000\u0019\u0005\u0001"+
		"\u0000\u0000\u0000\u001a\u001b\u0005\u0007\u0000\u0000\u001b\u001c\u0006"+
		"\u0003\uffff\uffff\u0000\u001c\u001d\u0005\u0002\u0000\u0000\u001d\u001e"+
		"\u0005\u0004\u0000\u0000\u001e\u0007\u0001\u0000\u0000\u0000\u001f \u0005"+
		"\u0007\u0000\u0000 !\u0006\u0004\uffff\uffff\u0000!\"\u0003\u0004\u0002"+
		"\u0000\"\t\u0001\u0000\u0000\u0000#$\u0005\u0004\u0000\u0000$%\u0007\u0000"+
		"\u0000\u0000%&\u0005\u0007\u0000\u0000&+\u0006\u0005\uffff\uffff\u0000"+
		"\',\u0003\u0004\u0002\u0000(,\u0003\b\u0004\u0000),\u0003\n\u0005\u0000"+
		"*,\u0003\u0006\u0003\u0000+\'\u0001\u0000\u0000\u0000+(\u0001\u0000\u0000"+
		"\u0000+)\u0001\u0000\u0000\u0000+*\u0001\u0000\u0000\u0000,\u000b\u0001"+
		"\u0000\u0000\u0000\u0003\u000f\u0014+";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}