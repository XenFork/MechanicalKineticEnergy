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
		RULE_yaml = 0, RULE_y = 1, RULE_code = 2, RULE_tabCode = 3, RULE_listCode = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"yaml", "y", "code", "tabCode", "listCode"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "': '", "':'", "'- '"
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
			setState(11); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(10);
				y();
				}
				}
				setState(13); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
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
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
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
	public static class CodeContext extends ParserRuleContext {
		public Token pre;
		public Token sub;
		public List<TerminalNode> ID() { return getTokens(YamlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(YamlParser.ID, i);
		}
		public List<TabCodeContext> tabCode() {
			return getRuleContexts(TabCodeContext.class);
		}
		public TabCodeContext tabCode(int i) {
			return getRuleContext(TabCodeContext.class,i);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			((CodeContext)_localctx).pre = match(ID);
			setState(26);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(18);
				match(T__0);
				setState(19);
				((CodeContext)_localctx).sub = match(ID);
				}
				break;
			case T__1:
				{
				setState(20);
				match(T__1);
				setState(22); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(21);
						tabCode();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(24); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TabCodeContext extends ParserRuleContext {
		public Token tabs;
		public TerminalNode TAB() { return getToken(YamlParser.TAB, 0); }
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public List<ListCodeContext> listCode() {
			return getRuleContexts(ListCodeContext.class);
		}
		public ListCodeContext listCode(int i) {
			return getRuleContext(ListCodeContext.class,i);
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
		enterRule(_localctx, 6, RULE_tabCode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			((TabCodeContext)_localctx).tabs = match(TAB);
			setState(35);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(29);
				code();
				}
				break;
			case T__2:
				{
				setState(31); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(30);
					listCode();
					}
					}
					setState(33); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__2 );
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ListCodeContext extends ParserRuleContext {
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
		enterRule(_localctx, 8, RULE_listCode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(T__2);
			setState(38);
			match(ID);
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
		"\u0004\u0001\u0007)\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0004\u0000\f\b\u0000\u000b\u0000\f\u0000\r\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0004\u0002"+
		"\u0017\b\u0002\u000b\u0002\f\u0002\u0018\u0003\u0002\u001b\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0004\u0003 \b\u0003\u000b\u0003\f\u0003"+
		"!\u0003\u0003$\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0000\u0000\u0005\u0000\u0002\u0004\u0006\b\u0000\u0000(\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0002\u000f\u0001\u0000\u0000\u0000\u0004\u0011"+
		"\u0001\u0000\u0000\u0000\u0006\u001c\u0001\u0000\u0000\u0000\b%\u0001"+
		"\u0000\u0000\u0000\n\f\u0003\u0002\u0001\u0000\u000b\n\u0001\u0000\u0000"+
		"\u0000\f\r\u0001\u0000\u0000\u0000\r\u000b\u0001\u0000\u0000\u0000\r\u000e"+
		"\u0001\u0000\u0000\u0000\u000e\u0001\u0001\u0000\u0000\u0000\u000f\u0010"+
		"\u0003\u0004\u0002\u0000\u0010\u0003\u0001\u0000\u0000\u0000\u0011\u001a"+
		"\u0005\u0004\u0000\u0000\u0012\u0013\u0005\u0001\u0000\u0000\u0013\u001b"+
		"\u0005\u0004\u0000\u0000\u0014\u0016\u0005\u0002\u0000\u0000\u0015\u0017"+
		"\u0003\u0006\u0003\u0000\u0016\u0015\u0001\u0000\u0000\u0000\u0017\u0018"+
		"\u0001\u0000\u0000\u0000\u0018\u0016\u0001\u0000\u0000\u0000\u0018\u0019"+
		"\u0001\u0000\u0000\u0000\u0019\u001b\u0001\u0000\u0000\u0000\u001a\u0012"+
		"\u0001\u0000\u0000\u0000\u001a\u0014\u0001\u0000\u0000\u0000\u001b\u0005"+
		"\u0001\u0000\u0000\u0000\u001c#\u0005\u0007\u0000\u0000\u001d$\u0003\u0004"+
		"\u0002\u0000\u001e \u0003\b\u0004\u0000\u001f\u001e\u0001\u0000\u0000"+
		"\u0000 !\u0001\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000!\"\u0001"+
		"\u0000\u0000\u0000\"$\u0001\u0000\u0000\u0000#\u001d\u0001\u0000\u0000"+
		"\u0000#\u001f\u0001\u0000\u0000\u0000$\u0007\u0001\u0000\u0000\u0000%"+
		"&\u0005\u0003\u0000\u0000&\'\u0005\u0004\u0000\u0000\'\t\u0001\u0000\u0000"+
		"\u0000\u0005\r\u0018\u001a!#";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}