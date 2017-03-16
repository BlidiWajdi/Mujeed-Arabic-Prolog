// Generated from C:\Users\User\ArabicProlog.g4 by ANTLR 4.1
package antlr4;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ArabicPrologLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		If=1, Point=2, UnifyOperator=3, IsOperator=4, ArabicTrue=5, ArabicFalse=6, 
		NotOp=7, AddOp=8, SubOp=9, MulOp=10, DivOp=11, ModOp=12, EqualOp=13, NotEqualOp=14, 
		LessOp=15, LessOrEqualOp=16, GreaterOp=17, GreaterOrEqualOp=18, Cut=19, 
		Or=20, And=21, Anonymous=22, Variable=23, Constant=24, ArabicChar=25, 
		Number=26, Comma=27, LeftParen=28, RightParen=29, LeftBracket=30, RightBracket=31, 
		Whitespace=32, Newline=33, BlockComment=34, LineComment=35;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"':-'", "'.'", "'='", "'<--'", "'????'", "'???'", "'!'", "'+'", "'-'", 
		"'*'", "'\\'", "'%'", "'=='", "'=!'", "'>'", "'=<'", "'<'", "'=>'", "'/'", 
		"'|'", "'&'", "'_'", "Variable", "Constant", "ArabicChar", "Number", "','", 
		"'('", "')'", "'['", "']'", "Whitespace", "Newline", "BlockComment", "LineComment"
	};
	public static final String[] ruleNames = {
		"If", "Point", "UnifyOperator", "IsOperator", "ArabicTrue", "ArabicFalse", 
		"NotOp", "AddOp", "SubOp", "MulOp", "DivOp", "ModOp", "EqualOp", "NotEqualOp", 
		"LessOp", "LessOrEqualOp", "GreaterOp", "GreaterOrEqualOp", "Cut", "Or", 
		"And", "Anonymous", "Variable", "Constant", "ArabicChar", "Number", "Comma", 
		"LeftParen", "RightParen", "LeftBracket", "RightBracket", "Whitespace", 
		"Newline", "BlockComment", "LineComment"
	};


	public ArabicPrologLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ArabicProlog.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 31: Whitespace_action((RuleContext)_localctx, actionIndex); break;

		case 32: Newline_action((RuleContext)_localctx, actionIndex); break;

		case 33: BlockComment_action((RuleContext)_localctx, actionIndex); break;

		case 34: LineComment_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void BlockComment_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: skip();  break;
		}
	}
	private void LineComment_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3: skip();  break;
		}
	}
	private void Newline_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}
	private void Whitespace_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2%\u00d3\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30"+
		"\3\30\3\30\3\31\6\31\u0086\n\31\r\31\16\31\u0087\3\31\3\31\7\31\u008c"+
		"\n\31\f\31\16\31\u008f\13\31\3\32\3\32\3\33\5\33\u0094\n\33\3\33\6\33"+
		"\u0097\n\33\r\33\16\33\u0098\3\33\3\33\6\33\u009d\n\33\r\33\16\33\u009e"+
		"\5\33\u00a1\n\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\6!\u00ae"+
		"\n!\r!\16!\u00af\3!\3!\3\"\3\"\5\"\u00b6\n\"\3\"\5\"\u00b9\n\"\3\"\3\""+
		"\3#\3#\3#\3#\7#\u00c1\n#\f#\16#\u00c4\13#\3#\3#\3#\3#\3#\3$\3$\7$\u00cd"+
		"\n$\f$\16$\u00d0\13$\3$\3$\3\u00c2%\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b"+
		"\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1"+
		"!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34"+
		"\1\67\35\19\36\1;\37\1= \1?!\1A\"\2C#\3E$\4G%\5\3\2\4\4\2\13\13\"\"\4"+
		"\2\f\f\17\17\u00de\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\3I\3\2\2\2\5L\3\2\2\2\7N\3\2\2\2\tP\3\2\2\2\13T\3"+
		"\2\2\2\rY\3\2\2\2\17]\3\2\2\2\21_\3\2\2\2\23a\3\2\2\2\25c\3\2\2\2\27e"+
		"\3\2\2\2\31g\3\2\2\2\33i\3\2\2\2\35l\3\2\2\2\37o\3\2\2\2!q\3\2\2\2#t\3"+
		"\2\2\2%v\3\2\2\2\'y\3\2\2\2){\3\2\2\2+}\3\2\2\2-\177\3\2\2\2/\u0081\3"+
		"\2\2\2\61\u0085\3\2\2\2\63\u0090\3\2\2\2\65\u0093\3\2\2\2\67\u00a2\3\2"+
		"\2\29\u00a4\3\2\2\2;\u00a6\3\2\2\2=\u00a8\3\2\2\2?\u00aa\3\2\2\2A\u00ad"+
		"\3\2\2\2C\u00b8\3\2\2\2E\u00bc\3\2\2\2G\u00ca\3\2\2\2IJ\7<\2\2JK\7/\2"+
		"\2K\4\3\2\2\2LM\7\60\2\2M\6\3\2\2\2NO\7?\2\2O\b\3\2\2\2PQ\7>\2\2QR\7/"+
		"\2\2RS\7/\2\2S\n\3\2\2\2TU\7A\2\2UV\7A\2\2VW\7A\2\2WX\7A\2\2X\f\3\2\2"+
		"\2YZ\7A\2\2Z[\7A\2\2[\\\7A\2\2\\\16\3\2\2\2]^\7#\2\2^\20\3\2\2\2_`\7-"+
		"\2\2`\22\3\2\2\2ab\7/\2\2b\24\3\2\2\2cd\7,\2\2d\26\3\2\2\2ef\7^\2\2f\30"+
		"\3\2\2\2gh\7\'\2\2h\32\3\2\2\2ij\7?\2\2jk\7?\2\2k\34\3\2\2\2lm\7?\2\2"+
		"mn\7#\2\2n\36\3\2\2\2op\7@\2\2p \3\2\2\2qr\7?\2\2rs\7>\2\2s\"\3\2\2\2"+
		"tu\7>\2\2u$\3\2\2\2vw\7?\2\2wx\7@\2\2x&\3\2\2\2yz\7\61\2\2z(\3\2\2\2{"+
		"|\7~\2\2|*\3\2\2\2}~\7(\2\2~,\3\2\2\2\177\u0080\7a\2\2\u0080.\3\2\2\2"+
		"\u0081\u0082\7\u0621\2\2\u0082\u0083\5\61\31\2\u0083\60\3\2\2\2\u0084"+
		"\u0086\5\63\32\2\u0085\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0085\3"+
		"\2\2\2\u0087\u0088\3\2\2\2\u0088\u008d\3\2\2\2\u0089\u008c\4\62;\2\u008a"+
		"\u008c\5\63\32\2\u008b\u0089\3\2\2\2\u008b\u008a\3\2\2\2\u008c\u008f\3"+
		"\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\62\3\2\2\2\u008f"+
		"\u008d\3\2\2\2\u0090\u0091\4\u0602\u0701\2\u0091\64\3\2\2\2\u0092\u0094"+
		"\7/\2\2\u0093\u0092\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0096\3\2\2\2\u0095"+
		"\u0097\4\62;\2\u0096\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0096\3\2"+
		"\2\2\u0098\u0099\3\2\2\2\u0099\u00a0\3\2\2\2\u009a\u009c\5\5\3\2\u009b"+
		"\u009d\4\62;\2\u009c\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009c\3\2"+
		"\2\2\u009e\u009f\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u009a\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\66\3\2\2\2\u00a2\u00a3\7.\2\2\u00a38\3\2\2\2\u00a4"+
		"\u00a5\7*\2\2\u00a5:\3\2\2\2\u00a6\u00a7\7+\2\2\u00a7<\3\2\2\2\u00a8\u00a9"+
		"\7]\2\2\u00a9>\3\2\2\2\u00aa\u00ab\7_\2\2\u00ab@\3\2\2\2\u00ac\u00ae\t"+
		"\2\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00ad\3\2\2\2\u00af"+
		"\u00b0\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\b!\2\2\u00b2B\3\2\2\2\u00b3"+
		"\u00b5\7\17\2\2\u00b4\u00b6\7\f\2\2\u00b5\u00b4\3\2\2\2\u00b5\u00b6\3"+
		"\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b9\7\f\2\2\u00b8\u00b3\3\2\2\2\u00b8"+
		"\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\b\"\3\2\u00bbD\3\2\2\2"+
		"\u00bc\u00bd\7^\2\2\u00bd\u00be\7,\2\2\u00be\u00c2\3\2\2\2\u00bf\u00c1"+
		"\13\2\2\2\u00c0\u00bf\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c3\3\2\2\2"+
		"\u00c2\u00c0\3\2\2\2\u00c3\u00c5\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5\u00c6"+
		"\7,\2\2\u00c6\u00c7\7\61\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\b#\4\2\u00c9"+
		"F\3\2\2\2\u00ca\u00ce\7^\2\2\u00cb\u00cd\n\3\2\2\u00cc\u00cb\3\2\2\2\u00cd"+
		"\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d1\3\2"+
		"\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d2\b$\5\2\u00d2H\3\2\2\2\17\2\u0087"+
		"\u008b\u008d\u0093\u0098\u009e\u00a0\u00af\u00b5\u00b8\u00c2\u00ce";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}