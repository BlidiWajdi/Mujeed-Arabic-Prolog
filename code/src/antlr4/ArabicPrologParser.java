// Generated from C:\Users\User\ArabicProlog.g4 by ANTLR 4.1
package antlr4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ArabicPrologParser extends Parser {
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
	public static final String[] tokenNames = {
		"<INVALID>", "':-'", "'.'", "'='", "'<--'", "'????'", "'???'", "'!'", 
		"'+'", "'-'", "'*'", "'\\'", "'%'", "'=='", "'=!'", "'>'", "'=<'", "'<'", 
		"'=>'", "'/'", "'|'", "'&'", "'_'", "Variable", "Constant", "ArabicChar", 
		"Number", "','", "'('", "')'", "'['", "']'", "Whitespace", "Newline", 
		"BlockComment", "LineComment"
	};
	public static final int
		RULE_arabicProlog = 0, RULE_query = 1, RULE_ruleSet = 2, RULE_rule = 3, 
		RULE_and = 4, RULE_or = 5, RULE_opTerms = 6, RULE_unifyExpression = 7, 
		RULE_isExpression = 8, RULE_leftExpression = 9, RULE_rightExpression = 10, 
		RULE_operand = 11, RULE_exp = 12, RULE_arabicBoolean = 13, RULE_unaryOperator = 14, 
		RULE_binaryOperator = 15, RULE_cut = 16, RULE_simpleSentence = 17, RULE_tuple = 18, 
		RULE_variable = 19, RULE_constant = 20, RULE_anonymous = 21, RULE_listProlog = 22, 
		RULE_emptyList = 23, RULE_elementList = 24;
	public static final String[] ruleNames = {
		"arabicProlog", "query", "ruleSet", "rule", "and", "or", "opTerms", "unifyExpression", 
		"isExpression", "leftExpression", "rightExpression", "operand", "exp", 
		"arabicBoolean", "unaryOperator", "binaryOperator", "cut", "simpleSentence", 
		"tuple", "variable", "constant", "anonymous", "listProlog", "emptyList", 
		"elementList"
	};

	@Override
	public String getGrammarFileName() { return "ArabicProlog.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public ArabicPrologParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ArabicPrologContext extends ParserRuleContext {
		public QueryContext query(int i) {
			return getRuleContext(QueryContext.class,i);
		}
		public List<QueryContext> query() {
			return getRuleContexts(QueryContext.class);
		}
		public RuleSetContext ruleSet() {
			return getRuleContext(RuleSetContext.class,0);
		}
		public ArabicPrologContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arabicProlog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).enterArabicProlog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).exitArabicProlog(this);
		}
	}

	public final ArabicPrologContext arabicProlog() throws RecognitionException {
		ArabicPrologContext _localctx = new ArabicPrologContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_arabicProlog);
		int _la;
		try {
			setState(57);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(50); ruleSet();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ArabicTrue) | (1L << ArabicFalse) | (1L << NotOp) | (1L << Variable) | (1L << Constant) | (1L << Number) | (1L << LeftParen))) != 0)) {
					{
					{
					setState(51); query();
					}
					}
					setState(56);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class QueryContext extends ParserRuleContext {
		public UnifyExpressionContext unifyExpression() {
			return getRuleContext(UnifyExpressionContext.class,0);
		}
		public IsExpressionContext isExpression() {
			return getRuleContext(IsExpressionContext.class,0);
		}
		public OpTermsContext opTerms() {
			return getRuleContext(OpTermsContext.class,0);
		}
		public TerminalNode Point() { return getToken(ArabicPrologParser.Point, 0); }
		public SimpleSentenceContext simpleSentence() {
			return getRuleContext(SimpleSentenceContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).exitQuery(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(59); simpleSentence();
				}
				break;

			case 2:
				{
				setState(60); isExpression();
				}
				break;

			case 3:
				{
				setState(61); unifyExpression();
				}
				break;

			case 4:
				{
				setState(62); opTerms();
				}
				break;
			}
			setState(65); match(Point);
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

	public static class RuleSetContext extends ParserRuleContext {
		public RuleContext rule(int i) {
			return getRuleContext(RuleContext.class,i);
		}
		public List<RuleContext> rule() {
			return getRuleContexts(RuleContext.class);
		}
		public RuleSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).enterRuleSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).exitRuleSet(this);
		}
	}

	public final RuleSetContext ruleSet() throws RecognitionException {
		RuleSetContext _localctx = new RuleSetContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_ruleSet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Constant) | (1L << Number) | (1L << LeftParen))) != 0)) {
				{
				{
				setState(67); rule();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class RuleContext extends ParserRuleContext {
		public CutContext cut(int i) {
			return getRuleContext(CutContext.class,i);
		}
		public List<OpTermsContext> opTerms() {
			return getRuleContexts(OpTermsContext.class);
		}
		public TerminalNode If() { return getToken(ArabicPrologParser.If, 0); }
		public IsExpressionContext isExpression(int i) {
			return getRuleContext(IsExpressionContext.class,i);
		}
		public OpTermsContext opTerms(int i) {
			return getRuleContext(OpTermsContext.class,i);
		}
		public List<AndContext> and() {
			return getRuleContexts(AndContext.class);
		}
		public UnifyExpressionContext unifyExpression(int i) {
			return getRuleContext(UnifyExpressionContext.class,i);
		}
		public List<SimpleSentenceContext> simpleSentence() {
			return getRuleContexts(SimpleSentenceContext.class);
		}
		public List<OrContext> or() {
			return getRuleContexts(OrContext.class);
		}
		public List<UnifyExpressionContext> unifyExpression() {
			return getRuleContexts(UnifyExpressionContext.class);
		}
		public List<IsExpressionContext> isExpression() {
			return getRuleContexts(IsExpressionContext.class);
		}
		public AndContext and(int i) {
			return getRuleContext(AndContext.class,i);
		}
		public OrContext or(int i) {
			return getRuleContext(OrContext.class,i);
		}
		public SimpleSentenceContext simpleSentence(int i) {
			return getRuleContext(SimpleSentenceContext.class,i);
		}
		public TerminalNode Point() { return getToken(ArabicPrologParser.Point, 0); }
		public List<CutContext> cut() {
			return getRuleContexts(CutContext.class);
		}
		public RuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).enterRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).exitRule(this);
		}
	}

	public final RuleContext rule() throws RecognitionException {
		RuleContext _localctx = new RuleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_rule);
		int _la;
		try {
			setState(91);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(73); simpleSentence();
				setState(74); match(Point);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(76); simpleSentence();
				setState(77); match(If);
				setState(85); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(85);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						setState(78); simpleSentence();
						}
						break;

					case 2:
						{
						setState(79); and();
						}
						break;

					case 3:
						{
						setState(80); or();
						}
						break;

					case 4:
						{
						setState(81); cut();
						}
						break;

					case 5:
						{
						setState(82); isExpression();
						}
						break;

					case 6:
						{
						setState(83); unifyExpression();
						}
						break;

					case 7:
						{
						setState(84); opTerms();
						}
						break;
					}
					}
					setState(87); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ArabicTrue) | (1L << ArabicFalse) | (1L << NotOp) | (1L << Cut) | (1L << Variable) | (1L << Constant) | (1L << Number) | (1L << LeftParen))) != 0) );
				setState(89); match(Point);
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

	public static class AndContext extends ParserRuleContext {
		public List<TerminalNode> LeftParen() { return getTokens(ArabicPrologParser.LeftParen); }
		public CutContext cut(int i) {
			return getRuleContext(CutContext.class,i);
		}
		public List<TerminalNode> RightParen() { return getTokens(ArabicPrologParser.RightParen); }
		public List<OpTermsContext> opTerms() {
			return getRuleContexts(OpTermsContext.class);
		}
		public TerminalNode RightParen(int i) {
			return getToken(ArabicPrologParser.RightParen, i);
		}
		public IsExpressionContext isExpression(int i) {
			return getRuleContext(IsExpressionContext.class,i);
		}
		public TerminalNode And(int i) {
			return getToken(ArabicPrologParser.And, i);
		}
		public OpTermsContext opTerms(int i) {
			return getRuleContext(OpTermsContext.class,i);
		}
		public List<AndContext> and() {
			return getRuleContexts(AndContext.class);
		}
		public UnifyExpressionContext unifyExpression(int i) {
			return getRuleContext(UnifyExpressionContext.class,i);
		}
		public TerminalNode LeftParen(int i) {
			return getToken(ArabicPrologParser.LeftParen, i);
		}
		public List<SimpleSentenceContext> simpleSentence() {
			return getRuleContexts(SimpleSentenceContext.class);
		}
		public List<OrContext> or() {
			return getRuleContexts(OrContext.class);
		}
		public List<UnifyExpressionContext> unifyExpression() {
			return getRuleContexts(UnifyExpressionContext.class);
		}
		public List<IsExpressionContext> isExpression() {
			return getRuleContexts(IsExpressionContext.class);
		}
		public List<TerminalNode> And() { return getTokens(ArabicPrologParser.And); }
		public AndContext and(int i) {
			return getRuleContext(AndContext.class,i);
		}
		public OrContext or(int i) {
			return getRuleContext(OrContext.class,i);
		}
		public SimpleSentenceContext simpleSentence(int i) {
			return getRuleContext(SimpleSentenceContext.class,i);
		}
		public List<CutContext> cut() {
			return getRuleContexts(CutContext.class);
		}
		public AndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).exitAnd(this);
		}
	}

	public final AndContext and() throws RecognitionException {
		AndContext _localctx = new AndContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_and);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(112); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(108);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						setState(98);
						switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
						case 1:
							{
							setState(93); simpleSentence();
							}
							break;

						case 2:
							{
							setState(94); cut();
							}
							break;

						case 3:
							{
							setState(95); isExpression();
							}
							break;

						case 4:
							{
							setState(96); unifyExpression();
							}
							break;

						case 5:
							{
							setState(97); opTerms();
							}
							break;
						}
						}
						break;

					case 2:
						{
						setState(100); match(LeftParen);
						setState(101); and();
						setState(102); match(RightParen);
						}
						break;

					case 3:
						{
						setState(104); match(LeftParen);
						setState(105); or();
						setState(106); match(RightParen);
						}
						break;
					}
					setState(110); match(And);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(114); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(131);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(121);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(116); simpleSentence();
					}
					break;

				case 2:
					{
					setState(117); cut();
					}
					break;

				case 3:
					{
					setState(118); isExpression();
					}
					break;

				case 4:
					{
					setState(119); unifyExpression();
					}
					break;

				case 5:
					{
					setState(120); opTerms();
					}
					break;
				}
				}
				break;

			case 2:
				{
				setState(123); match(LeftParen);
				setState(124); and();
				setState(125); match(RightParen);
				}
				break;

			case 3:
				{
				setState(127); match(LeftParen);
				setState(128); or();
				setState(129); match(RightParen);
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

	public static class OrContext extends ParserRuleContext {
		public List<TerminalNode> LeftParen() { return getTokens(ArabicPrologParser.LeftParen); }
		public CutContext cut(int i) {
			return getRuleContext(CutContext.class,i);
		}
		public List<TerminalNode> RightParen() { return getTokens(ArabicPrologParser.RightParen); }
		public List<OpTermsContext> opTerms() {
			return getRuleContexts(OpTermsContext.class);
		}
		public TerminalNode RightParen(int i) {
			return getToken(ArabicPrologParser.RightParen, i);
		}
		public IsExpressionContext isExpression(int i) {
			return getRuleContext(IsExpressionContext.class,i);
		}
		public OpTermsContext opTerms(int i) {
			return getRuleContext(OpTermsContext.class,i);
		}
		public List<AndContext> and() {
			return getRuleContexts(AndContext.class);
		}
		public UnifyExpressionContext unifyExpression(int i) {
			return getRuleContext(UnifyExpressionContext.class,i);
		}
		public TerminalNode LeftParen(int i) {
			return getToken(ArabicPrologParser.LeftParen, i);
		}
		public List<SimpleSentenceContext> simpleSentence() {
			return getRuleContexts(SimpleSentenceContext.class);
		}
		public List<OrContext> or() {
			return getRuleContexts(OrContext.class);
		}
		public List<UnifyExpressionContext> unifyExpression() {
			return getRuleContexts(UnifyExpressionContext.class);
		}
		public List<IsExpressionContext> isExpression() {
			return getRuleContexts(IsExpressionContext.class);
		}
		public TerminalNode Or(int i) {
			return getToken(ArabicPrologParser.Or, i);
		}
		public List<TerminalNode> Or() { return getTokens(ArabicPrologParser.Or); }
		public AndContext and(int i) {
			return getRuleContext(AndContext.class,i);
		}
		public OrContext or(int i) {
			return getRuleContext(OrContext.class,i);
		}
		public SimpleSentenceContext simpleSentence(int i) {
			return getRuleContext(SimpleSentenceContext.class,i);
		}
		public List<CutContext> cut() {
			return getRuleContexts(CutContext.class);
		}
		public OrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).exitOr(this);
		}
	}

	public final OrContext or() throws RecognitionException {
		OrContext _localctx = new OrContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_or);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(152); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(148);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						setState(138);
						switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
						case 1:
							{
							setState(133); simpleSentence();
							}
							break;

						case 2:
							{
							setState(134); cut();
							}
							break;

						case 3:
							{
							setState(135); isExpression();
							}
							break;

						case 4:
							{
							setState(136); unifyExpression();
							}
							break;

						case 5:
							{
							setState(137); opTerms();
							}
							break;
						}
						}
						break;

					case 2:
						{
						setState(140); match(LeftParen);
						setState(141); and();
						setState(142); match(RightParen);
						}
						break;

					case 3:
						{
						setState(144); match(LeftParen);
						setState(145); or();
						setState(146); match(RightParen);
						}
						break;
					}
					setState(150); match(Or);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(154); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(171);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(161);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(156); simpleSentence();
					}
					break;

				case 2:
					{
					setState(157); cut();
					}
					break;

				case 3:
					{
					setState(158); isExpression();
					}
					break;

				case 4:
					{
					setState(159); unifyExpression();
					}
					break;

				case 5:
					{
					setState(160); opTerms();
					}
					break;
				}
				}
				break;

			case 2:
				{
				setState(163); match(LeftParen);
				setState(164); and();
				setState(165); match(RightParen);
				}
				break;

			case 3:
				{
				setState(167); match(LeftParen);
				setState(168); or();
				setState(169); match(RightParen);
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

	public static class OpTermsContext extends ParserRuleContext {
		public RightExpressionContext rightExpression() {
			return getRuleContext(RightExpressionContext.class,0);
		}
		public OpTermsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opTerms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).enterOpTerms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).exitOpTerms(this);
		}
	}

	public final OpTermsContext opTerms() throws RecognitionException {
		OpTermsContext _localctx = new OpTermsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_opTerms);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173); rightExpression();
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

	public static class UnifyExpressionContext extends ParserRuleContext {
		public LeftExpressionContext leftExpression() {
			return getRuleContext(LeftExpressionContext.class,0);
		}
		public RightExpressionContext rightExpression() {
			return getRuleContext(RightExpressionContext.class,0);
		}
		public TerminalNode UnifyOperator() { return getToken(ArabicPrologParser.UnifyOperator, 0); }
		public UnifyExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unifyExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).enterUnifyExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).exitUnifyExpression(this);
		}
	}

	public final UnifyExpressionContext unifyExpression() throws RecognitionException {
		UnifyExpressionContext _localctx = new UnifyExpressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_unifyExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175); leftExpression();
			setState(176); match(UnifyOperator);
			setState(177); rightExpression();
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

	public static class IsExpressionContext extends ParserRuleContext {
		public TerminalNode IsOperator() { return getToken(ArabicPrologParser.IsOperator, 0); }
		public LeftExpressionContext leftExpression() {
			return getRuleContext(LeftExpressionContext.class,0);
		}
		public RightExpressionContext rightExpression() {
			return getRuleContext(RightExpressionContext.class,0);
		}
		public IsExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_isExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).enterIsExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).exitIsExpression(this);
		}
	}

	public final IsExpressionContext isExpression() throws RecognitionException {
		IsExpressionContext _localctx = new IsExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_isExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179); leftExpression();
			setState(180); match(IsOperator);
			setState(181); rightExpression();
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

	public static class LeftExpressionContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public LeftExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).enterLeftExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).exitLeftExpression(this);
		}
	}

	public final LeftExpressionContext leftExpression() throws RecognitionException {
		LeftExpressionContext _localctx = new LeftExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_leftExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183); variable();
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

	public static class RightExpressionContext extends ParserRuleContext {
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public ArabicBooleanContext arabicBoolean() {
			return getRuleContext(ArabicBooleanContext.class,0);
		}
		public UnaryOperatorContext unaryOperator() {
			return getRuleContext(UnaryOperatorContext.class,0);
		}
		public BinaryOperatorContext binaryOperator(int i) {
			return getRuleContext(BinaryOperatorContext.class,i);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public List<BinaryOperatorContext> binaryOperator() {
			return getRuleContexts(BinaryOperatorContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public RightExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rightExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).enterRightExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).exitRightExpression(this);
		}
	}

	public final RightExpressionContext rightExpression() throws RecognitionException {
		RightExpressionContext _localctx = new RightExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_rightExpression);
		int _la;
		try {
			int _alt;
			setState(233);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(185); constant();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(186); arabicBoolean();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(187); operand();
						setState(188); binaryOperator();
						}
						} 
					}
					setState(194);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				}
				setState(197);
				switch (_input.LA(1)) {
				case ArabicTrue:
				case ArabicFalse:
				case Variable:
				case Constant:
				case Number:
					{
					setState(195); operand();
					}
					break;
				case LeftParen:
					{
					setState(196); exp();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(199); binaryOperator();
				setState(202);
				switch (_input.LA(1)) {
				case ArabicTrue:
				case ArabicFalse:
				case Variable:
				case Constant:
				case Number:
					{
					setState(200); operand();
					}
					break;
				case LeftParen:
					{
					setState(201); exp();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(209);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(204); binaryOperator();
						setState(205); operand();
						}
						} 
					}
					setState(211);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ArabicTrue) | (1L << ArabicFalse) | (1L << Variable) | (1L << Constant) | (1L << Number))) != 0)) {
					{
					{
					setState(212); operand();
					setState(213); binaryOperator();
					}
					}
					setState(219);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(220); unaryOperator();
				setState(223);
				switch (_input.LA(1)) {
				case ArabicTrue:
				case ArabicFalse:
				case Variable:
				case Constant:
				case Number:
					{
					setState(221); operand();
					}
					break;
				case LeftParen:
					{
					setState(222); exp();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(230);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(225); binaryOperator();
						setState(226); operand();
						}
						} 
					}
					setState(232);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				}
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

	public static class OperandContext extends ParserRuleContext {
		public ArabicBooleanContext arabicBoolean() {
			return getRuleContext(ArabicBooleanContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).enterOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).exitOperand(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_operand);
		try {
			setState(238);
			switch (_input.LA(1)) {
			case Constant:
			case Number:
				enterOuterAlt(_localctx, 1);
				{
				setState(235); constant();
				}
				break;
			case Variable:
				enterOuterAlt(_localctx, 2);
				{
				setState(236); variable();
				}
				break;
			case ArabicTrue:
			case ArabicFalse:
				enterOuterAlt(_localctx, 3);
				{
				setState(237); arabicBoolean();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ExpContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(ArabicPrologParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(ArabicPrologParser.RightParen, 0); }
		public RightExpressionContext rightExpression() {
			return getRuleContext(RightExpressionContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).exitExp(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240); match(LeftParen);
			setState(241); rightExpression();
			setState(242); match(RightParen);
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

	public static class ArabicBooleanContext extends ParserRuleContext {
		public TerminalNode ArabicTrue() { return getToken(ArabicPrologParser.ArabicTrue, 0); }
		public TerminalNode ArabicFalse() { return getToken(ArabicPrologParser.ArabicFalse, 0); }
		public ArabicBooleanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arabicBoolean; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).enterArabicBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).exitArabicBoolean(this);
		}
	}

	public final ArabicBooleanContext arabicBoolean() throws RecognitionException {
		ArabicBooleanContext _localctx = new ArabicBooleanContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_arabicBoolean);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			_la = _input.LA(1);
			if ( !(_la==ArabicTrue || _la==ArabicFalse) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class UnaryOperatorContext extends ParserRuleContext {
		public TerminalNode NotOp() { return getToken(ArabicPrologParser.NotOp, 0); }
		public UnaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).enterUnaryOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).exitUnaryOperator(this);
		}
	}

	public final UnaryOperatorContext unaryOperator() throws RecognitionException {
		UnaryOperatorContext _localctx = new UnaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_unaryOperator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246); match(NotOp);
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

	public static class BinaryOperatorContext extends ParserRuleContext {
		public TerminalNode GreaterOp() { return getToken(ArabicPrologParser.GreaterOp, 0); }
		public TerminalNode DivOp() { return getToken(ArabicPrologParser.DivOp, 0); }
		public TerminalNode MulOp() { return getToken(ArabicPrologParser.MulOp, 0); }
		public TerminalNode LessOp() { return getToken(ArabicPrologParser.LessOp, 0); }
		public TerminalNode EqualOp() { return getToken(ArabicPrologParser.EqualOp, 0); }
		public TerminalNode AddOp() { return getToken(ArabicPrologParser.AddOp, 0); }
		public TerminalNode SubOp() { return getToken(ArabicPrologParser.SubOp, 0); }
		public TerminalNode ModOp() { return getToken(ArabicPrologParser.ModOp, 0); }
		public TerminalNode GreaterOrEqualOp() { return getToken(ArabicPrologParser.GreaterOrEqualOp, 0); }
		public TerminalNode And() { return getToken(ArabicPrologParser.And, 0); }
		public TerminalNode LessOrEqualOp() { return getToken(ArabicPrologParser.LessOrEqualOp, 0); }
		public TerminalNode Or() { return getToken(ArabicPrologParser.Or, 0); }
		public TerminalNode NotEqualOp() { return getToken(ArabicPrologParser.NotEqualOp, 0); }
		public BinaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).enterBinaryOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).exitBinaryOperator(this);
		}
	}

	public final BinaryOperatorContext binaryOperator() throws RecognitionException {
		BinaryOperatorContext _localctx = new BinaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_binaryOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AddOp) | (1L << SubOp) | (1L << MulOp) | (1L << DivOp) | (1L << ModOp) | (1L << EqualOp) | (1L << NotEqualOp) | (1L << LessOp) | (1L << LessOrEqualOp) | (1L << GreaterOp) | (1L << GreaterOrEqualOp) | (1L << Or) | (1L << And))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class CutContext extends ParserRuleContext {
		public TerminalNode Cut() { return getToken(ArabicPrologParser.Cut, 0); }
		public CutContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cut; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).enterCut(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).exitCut(this);
		}
	}

	public final CutContext cut() throws RecognitionException {
		CutContext _localctx = new CutContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_cut);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250); match(Cut);
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

	public static class SimpleSentenceContext extends ParserRuleContext {
		public List<TupleContext> tuple() {
			return getRuleContexts(TupleContext.class);
		}
		public List<ListPrologContext> listProlog() {
			return getRuleContexts(ListPrologContext.class);
		}
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public TerminalNode LeftParen() { return getToken(ArabicPrologParser.LeftParen, 0); }
		public List<EmptyListContext> emptyList() {
			return getRuleContexts(EmptyListContext.class);
		}
		public TerminalNode RightParen() { return getToken(ArabicPrologParser.RightParen, 0); }
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public EmptyListContext emptyList(int i) {
			return getRuleContext(EmptyListContext.class,i);
		}
		public TerminalNode Comma(int i) {
			return getToken(ArabicPrologParser.Comma, i);
		}
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public AnonymousContext anonymous(int i) {
			return getRuleContext(AnonymousContext.class,i);
		}
		public List<SimpleSentenceContext> simpleSentence() {
			return getRuleContexts(SimpleSentenceContext.class);
		}
		public ListPrologContext listProlog(int i) {
			return getRuleContext(ListPrologContext.class,i);
		}
		public TupleContext tuple(int i) {
			return getRuleContext(TupleContext.class,i);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public SimpleSentenceContext simpleSentence(int i) {
			return getRuleContext(SimpleSentenceContext.class,i);
		}
		public List<AnonymousContext> anonymous() {
			return getRuleContexts(AnonymousContext.class);
		}
		public List<TerminalNode> Comma() { return getTokens(ArabicPrologParser.Comma); }
		public SimpleSentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleSentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).enterSimpleSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).exitSimpleSentence(this);
		}
	}

	public final SimpleSentenceContext simpleSentence() throws RecognitionException {
		SimpleSentenceContext _localctx = new SimpleSentenceContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_simpleSentence);
		try {
			int _alt;
			setState(286);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(252); constant();
				setState(253); match(LeftParen);
				{
				setState(267);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(261);
						switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
						case 1:
							{
							setState(254); variable();
							}
							break;

						case 2:
							{
							setState(255); constant();
							}
							break;

						case 3:
							{
							setState(256); anonymous();
							}
							break;

						case 4:
							{
							setState(257); tuple();
							}
							break;

						case 5:
							{
							setState(258); simpleSentence();
							}
							break;

						case 6:
							{
							setState(259); listProlog();
							}
							break;

						case 7:
							{
							setState(260); emptyList();
							}
							break;
						}
						setState(263); match(Comma);
						}
						} 
					}
					setState(269);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				}
				setState(277);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(270); variable();
					}
					break;

				case 2:
					{
					setState(271); constant();
					}
					break;

				case 3:
					{
					setState(272); anonymous();
					}
					break;

				case 4:
					{
					setState(273); tuple();
					}
					break;

				case 5:
					{
					setState(274); simpleSentence();
					}
					break;

				case 6:
					{
					setState(275); listProlog();
					}
					break;

				case 7:
					{
					setState(276); emptyList();
					}
					break;
				}
				}
				setState(279); match(RightParen);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(281); tuple();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(282); match(LeftParen);
				setState(283); simpleSentence();
				setState(284); match(RightParen);
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

	public static class TupleContext extends ParserRuleContext {
		public List<TupleContext> tuple() {
			return getRuleContexts(TupleContext.class);
		}
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public TerminalNode LeftParen() { return getToken(ArabicPrologParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(ArabicPrologParser.RightParen, 0); }
		public TupleContext tuple(int i) {
			return getRuleContext(TupleContext.class,i);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public TerminalNode Comma(int i) {
			return getToken(ArabicPrologParser.Comma, i);
		}
		public AnonymousContext anonymous(int i) {
			return getRuleContext(AnonymousContext.class,i);
		}
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public List<AnonymousContext> anonymous() {
			return getRuleContexts(AnonymousContext.class);
		}
		public List<TerminalNode> Comma() { return getTokens(ArabicPrologParser.Comma); }
		public TupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tuple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).enterTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).exitTuple(this);
		}
	}

	public final TupleContext tuple() throws RecognitionException {
		TupleContext _localctx = new TupleContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_tuple);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(288); match(LeftParen);
			{
			setState(299);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(293);
					switch (_input.LA(1)) {
					case Variable:
						{
						setState(289); variable();
						}
						break;
					case Constant:
					case Number:
						{
						setState(290); constant();
						}
						break;
					case Anonymous:
						{
						setState(291); anonymous();
						}
						break;
					case LeftParen:
						{
						setState(292); tuple();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(295); match(Comma);
					}
					} 
				}
				setState(301);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			setState(306);
			switch (_input.LA(1)) {
			case Variable:
				{
				setState(302); variable();
				}
				break;
			case Constant:
			case Number:
				{
				setState(303); constant();
				}
				break;
			case Anonymous:
				{
				setState(304); anonymous();
				}
				break;
			case LeftParen:
				{
				setState(305); tuple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
			setState(308); match(RightParen);
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

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode Variable() { return getToken(ArabicPrologParser.Variable, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310); match(Variable);
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

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode Constant() { return getToken(ArabicPrologParser.Constant, 0); }
		public TerminalNode Number() { return getToken(ArabicPrologParser.Number, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			_la = _input.LA(1);
			if ( !(_la==Constant || _la==Number) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class AnonymousContext extends ParserRuleContext {
		public TerminalNode Anonymous() { return getToken(ArabicPrologParser.Anonymous, 0); }
		public AnonymousContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anonymous; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).enterAnonymous(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).exitAnonymous(this);
		}
	}

	public final AnonymousContext anonymous() throws RecognitionException {
		AnonymousContext _localctx = new AnonymousContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_anonymous);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314); match(Anonymous);
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

	public static class ListPrologContext extends ParserRuleContext {
		public TerminalNode RightBracket() { return getToken(ArabicPrologParser.RightBracket, 0); }
		public ElementListContext elementList(int i) {
			return getRuleContext(ElementListContext.class,i);
		}
		public TerminalNode LeftBracket() { return getToken(ArabicPrologParser.LeftBracket, 0); }
		public TerminalNode Or() { return getToken(ArabicPrologParser.Or, 0); }
		public List<ElementListContext> elementList() {
			return getRuleContexts(ElementListContext.class);
		}
		public TerminalNode Comma() { return getToken(ArabicPrologParser.Comma, 0); }
		public ListPrologContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listProlog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).enterListProlog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).exitListProlog(this);
		}
	}

	public final ListPrologContext listProlog() throws RecognitionException {
		ListPrologContext _localctx = new ListPrologContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_listProlog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316); match(LeftBracket);
			setState(317); elementList();
			setState(327);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(322);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(318); match(Comma);
					setState(319); elementList();
					}
					}
					setState(324);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;

			case 2:
				{
				{
				setState(325); match(Or);
				setState(326); elementList();
				}
				}
				break;
			}
			setState(329); match(RightBracket);
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

	public static class EmptyListContext extends ParserRuleContext {
		public TerminalNode RightBracket() { return getToken(ArabicPrologParser.RightBracket, 0); }
		public TerminalNode LeftBracket() { return getToken(ArabicPrologParser.LeftBracket, 0); }
		public EmptyListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).enterEmptyList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).exitEmptyList(this);
		}
	}

	public final EmptyListContext emptyList() throws RecognitionException {
		EmptyListContext _localctx = new EmptyListContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_emptyList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331); match(LeftBracket);
			setState(332); match(RightBracket);
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

	public static class ElementListContext extends ParserRuleContext {
		public TupleContext tuple() {
			return getRuleContext(TupleContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public SimpleSentenceContext simpleSentence() {
			return getRuleContext(SimpleSentenceContext.class,0);
		}
		public AnonymousContext anonymous() {
			return getRuleContext(AnonymousContext.class,0);
		}
		public ElementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).enterElementList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArabicPrologListener ) ((ArabicPrologListener)listener).exitElementList(this);
		}
	}

	public final ElementListContext elementList() throws RecognitionException {
		ElementListContext _localctx = new ElementListContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_elementList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(334); variable();
				}
				break;

			case 2:
				{
				setState(335); constant();
				}
				break;

			case 3:
				{
				setState(336); anonymous();
				}
				break;

			case 4:
				{
				setState(337); tuple();
				}
				break;

			case 5:
				{
				setState(338); simpleSentence();
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3%\u0158\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\7\2\67\n\2\f\2\16\2:\13\2\5\2<\n\2\3\3\3\3\3\3\3\3"+
		"\5\3B\n\3\3\3\3\3\3\4\7\4G\n\4\f\4\16\4J\13\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\6\5X\n\5\r\5\16\5Y\3\5\3\5\5\5^\n\5\3\6\3\6\3"+
		"\6\3\6\3\6\5\6e\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6o\n\6\3\6\3\6\6"+
		"\6s\n\6\r\6\16\6t\3\6\3\6\3\6\3\6\3\6\5\6|\n\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\5\6\u0086\n\6\3\7\3\7\3\7\3\7\3\7\5\7\u008d\n\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\5\7\u0097\n\7\3\7\3\7\6\7\u009b\n\7\r\7\16\7\u009c"+
		"\3\7\3\7\3\7\3\7\3\7\5\7\u00a4\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7"+
		"\u00ae\n\7\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\f\7\f\u00c1\n\f\f\f\16\f\u00c4\13\f\3\f\3\f\5\f\u00c8\n\f\3\f"+
		"\3\f\3\f\5\f\u00cd\n\f\3\f\3\f\3\f\7\f\u00d2\n\f\f\f\16\f\u00d5\13\f\3"+
		"\f\3\f\3\f\7\f\u00da\n\f\f\f\16\f\u00dd\13\f\3\f\3\f\3\f\5\f\u00e2\n\f"+
		"\3\f\3\f\3\f\7\f\u00e7\n\f\f\f\16\f\u00ea\13\f\5\f\u00ec\n\f\3\r\3\r\3"+
		"\r\5\r\u00f1\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0108\n\23\3\23"+
		"\3\23\7\23\u010c\n\23\f\23\16\23\u010f\13\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\5\23\u0118\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0121"+
		"\n\23\3\24\3\24\3\24\3\24\3\24\5\24\u0128\n\24\3\24\3\24\7\24\u012c\n"+
		"\24\f\24\16\24\u012f\13\24\3\24\3\24\3\24\3\24\5\24\u0135\n\24\3\24\3"+
		"\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\7\30\u0143\n\30"+
		"\f\30\16\30\u0146\13\30\3\30\3\30\5\30\u014a\n\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\32\3\32\5\32\u0156\n\32\3\32\2\33\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\2\5\3\2\7\b\4\2\n\24\26\27\4\2"+
		"\32\32\34\34\u018f\2;\3\2\2\2\4A\3\2\2\2\6H\3\2\2\2\b]\3\2\2\2\nr\3\2"+
		"\2\2\f\u009a\3\2\2\2\16\u00af\3\2\2\2\20\u00b1\3\2\2\2\22\u00b5\3\2\2"+
		"\2\24\u00b9\3\2\2\2\26\u00eb\3\2\2\2\30\u00f0\3\2\2\2\32\u00f2\3\2\2\2"+
		"\34\u00f6\3\2\2\2\36\u00f8\3\2\2\2 \u00fa\3\2\2\2\"\u00fc\3\2\2\2$\u0120"+
		"\3\2\2\2&\u0122\3\2\2\2(\u0138\3\2\2\2*\u013a\3\2\2\2,\u013c\3\2\2\2."+
		"\u013e\3\2\2\2\60\u014d\3\2\2\2\62\u0155\3\2\2\2\64<\5\6\4\2\65\67\5\4"+
		"\3\2\66\65\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29<\3\2\2\2:8\3\2\2"+
		"\2;\64\3\2\2\2;8\3\2\2\2<\3\3\2\2\2=B\5$\23\2>B\5\22\n\2?B\5\20\t\2@B"+
		"\5\16\b\2A=\3\2\2\2A>\3\2\2\2A?\3\2\2\2A@\3\2\2\2BC\3\2\2\2CD\7\4\2\2"+
		"D\5\3\2\2\2EG\5\b\5\2FE\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2I\7\3\2\2"+
		"\2JH\3\2\2\2KL\5$\23\2LM\7\4\2\2M^\3\2\2\2NO\5$\23\2OW\7\3\2\2PX\5$\23"+
		"\2QX\5\n\6\2RX\5\f\7\2SX\5\"\22\2TX\5\22\n\2UX\5\20\t\2VX\5\16\b\2WP\3"+
		"\2\2\2WQ\3\2\2\2WR\3\2\2\2WS\3\2\2\2WT\3\2\2\2WU\3\2\2\2WV\3\2\2\2XY\3"+
		"\2\2\2YW\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[\\\7\4\2\2\\^\3\2\2\2]K\3\2\2\2]"+
		"N\3\2\2\2^\t\3\2\2\2_e\5$\23\2`e\5\"\22\2ae\5\22\n\2be\5\20\t\2ce\5\16"+
		"\b\2d_\3\2\2\2d`\3\2\2\2da\3\2\2\2db\3\2\2\2dc\3\2\2\2eo\3\2\2\2fg\7\36"+
		"\2\2gh\5\n\6\2hi\7\37\2\2io\3\2\2\2jk\7\36\2\2kl\5\f\7\2lm\7\37\2\2mo"+
		"\3\2\2\2nd\3\2\2\2nf\3\2\2\2nj\3\2\2\2op\3\2\2\2pq\7\27\2\2qs\3\2\2\2"+
		"rn\3\2\2\2st\3\2\2\2tr\3\2\2\2tu\3\2\2\2u\u0085\3\2\2\2v|\5$\23\2w|\5"+
		"\"\22\2x|\5\22\n\2y|\5\20\t\2z|\5\16\b\2{v\3\2\2\2{w\3\2\2\2{x\3\2\2\2"+
		"{y\3\2\2\2{z\3\2\2\2|\u0086\3\2\2\2}~\7\36\2\2~\177\5\n\6\2\177\u0080"+
		"\7\37\2\2\u0080\u0086\3\2\2\2\u0081\u0082\7\36\2\2\u0082\u0083\5\f\7\2"+
		"\u0083\u0084\7\37\2\2\u0084\u0086\3\2\2\2\u0085{\3\2\2\2\u0085}\3\2\2"+
		"\2\u0085\u0081\3\2\2\2\u0086\13\3\2\2\2\u0087\u008d\5$\23\2\u0088\u008d"+
		"\5\"\22\2\u0089\u008d\5\22\n\2\u008a\u008d\5\20\t\2\u008b\u008d\5\16\b"+
		"\2\u008c\u0087\3\2\2\2\u008c\u0088\3\2\2\2\u008c\u0089\3\2\2\2\u008c\u008a"+
		"\3\2\2\2\u008c\u008b\3\2\2\2\u008d\u0097\3\2\2\2\u008e\u008f\7\36\2\2"+
		"\u008f\u0090\5\n\6\2\u0090\u0091\7\37\2\2\u0091\u0097\3\2\2\2\u0092\u0093"+
		"\7\36\2\2\u0093\u0094\5\f\7\2\u0094\u0095\7\37\2\2\u0095\u0097\3\2\2\2"+
		"\u0096\u008c\3\2\2\2\u0096\u008e\3\2\2\2\u0096\u0092\3\2\2\2\u0097\u0098"+
		"\3\2\2\2\u0098\u0099\7\26\2\2\u0099\u009b\3\2\2\2\u009a\u0096\3\2\2\2"+
		"\u009b\u009c\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u00ad"+
		"\3\2\2\2\u009e\u00a4\5$\23\2\u009f\u00a4\5\"\22\2\u00a0\u00a4\5\22\n\2"+
		"\u00a1\u00a4\5\20\t\2\u00a2\u00a4\5\16\b\2\u00a3\u009e\3\2\2\2\u00a3\u009f"+
		"\3\2\2\2\u00a3\u00a0\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a2\3\2\2\2\u00a4"+
		"\u00ae\3\2\2\2\u00a5\u00a6\7\36\2\2\u00a6\u00a7\5\n\6\2\u00a7\u00a8\7"+
		"\37\2\2\u00a8\u00ae\3\2\2\2\u00a9\u00aa\7\36\2\2\u00aa\u00ab\5\f\7\2\u00ab"+
		"\u00ac\7\37\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00a3\3\2\2\2\u00ad\u00a5\3"+
		"\2\2\2\u00ad\u00a9\3\2\2\2\u00ae\r\3\2\2\2\u00af\u00b0\5\26\f\2\u00b0"+
		"\17\3\2\2\2\u00b1\u00b2\5\24\13\2\u00b2\u00b3\7\5\2\2\u00b3\u00b4\5\26"+
		"\f\2\u00b4\21\3\2\2\2\u00b5\u00b6\5\24\13\2\u00b6\u00b7\7\6\2\2\u00b7"+
		"\u00b8\5\26\f\2\u00b8\23\3\2\2\2\u00b9\u00ba\5(\25\2\u00ba\25\3\2\2\2"+
		"\u00bb\u00ec\5*\26\2\u00bc\u00ec\5\34\17\2\u00bd\u00be\5\30\r\2\u00be"+
		"\u00bf\5 \21\2\u00bf\u00c1\3\2\2\2\u00c0\u00bd\3\2\2\2\u00c1\u00c4\3\2"+
		"\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c7\3\2\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c5\u00c8\5\30\r\2\u00c6\u00c8\5\32\16\2\u00c7\u00c5"+
		"\3\2\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cc\5 \21\2\u00ca"+
		"\u00cd\5\30\r\2\u00cb\u00cd\5\32\16\2\u00cc\u00ca\3\2\2\2\u00cc\u00cb"+
		"\3\2\2\2\u00cd\u00d3\3\2\2\2\u00ce\u00cf\5 \21\2\u00cf\u00d0\5\30\r\2"+
		"\u00d0\u00d2\3\2\2\2\u00d1\u00ce\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1"+
		"\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00ec\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6"+
		"\u00d7\5\30\r\2\u00d7\u00d8\5 \21\2\u00d8\u00da\3\2\2\2\u00d9\u00d6\3"+
		"\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc"+
		"\u00de\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00e1\5\36\20\2\u00df\u00e2\5"+
		"\30\r\2\u00e0\u00e2\5\32\16\2\u00e1\u00df\3\2\2\2\u00e1\u00e0\3\2\2\2"+
		"\u00e2\u00e8\3\2\2\2\u00e3\u00e4\5 \21\2\u00e4\u00e5\5\30\r\2\u00e5\u00e7"+
		"\3\2\2\2\u00e6\u00e3\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8"+
		"\u00e9\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00bb\3\2"+
		"\2\2\u00eb\u00bc\3\2\2\2\u00eb\u00c2\3\2\2\2\u00eb\u00db\3\2\2\2\u00ec"+
		"\27\3\2\2\2\u00ed\u00f1\5*\26\2\u00ee\u00f1\5(\25\2\u00ef\u00f1\5\34\17"+
		"\2\u00f0\u00ed\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00ef\3\2\2\2\u00f1\31"+
		"\3\2\2\2\u00f2\u00f3\7\36\2\2\u00f3\u00f4\5\26\f\2\u00f4\u00f5\7\37\2"+
		"\2\u00f5\33\3\2\2\2\u00f6\u00f7\t\2\2\2\u00f7\35\3\2\2\2\u00f8\u00f9\7"+
		"\t\2\2\u00f9\37\3\2\2\2\u00fa\u00fb\t\3\2\2\u00fb!\3\2\2\2\u00fc\u00fd"+
		"\7\25\2\2\u00fd#\3\2\2\2\u00fe\u00ff\5*\26\2\u00ff\u010d\7\36\2\2\u0100"+
		"\u0108\5(\25\2\u0101\u0108\5*\26\2\u0102\u0108\5,\27\2\u0103\u0108\5&"+
		"\24\2\u0104\u0108\5$\23\2\u0105\u0108\5.\30\2\u0106\u0108\5\60\31\2\u0107"+
		"\u0100\3\2\2\2\u0107\u0101\3\2\2\2\u0107\u0102\3\2\2\2\u0107\u0103\3\2"+
		"\2\2\u0107\u0104\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0106\3\2\2\2\u0108"+
		"\u0109\3\2\2\2\u0109\u010a\7\35\2\2\u010a\u010c\3\2\2\2\u010b\u0107\3"+
		"\2\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e"+
		"\u0117\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0118\5(\25\2\u0111\u0118\5*"+
		"\26\2\u0112\u0118\5,\27\2\u0113\u0118\5&\24\2\u0114\u0118\5$\23\2\u0115"+
		"\u0118\5.\30\2\u0116\u0118\5\60\31\2\u0117\u0110\3\2\2\2\u0117\u0111\3"+
		"\2\2\2\u0117\u0112\3\2\2\2\u0117\u0113\3\2\2\2\u0117\u0114\3\2\2\2\u0117"+
		"\u0115\3\2\2\2\u0117\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011a\7\37"+
		"\2\2\u011a\u0121\3\2\2\2\u011b\u0121\5&\24\2\u011c\u011d\7\36\2\2\u011d"+
		"\u011e\5$\23\2\u011e\u011f\7\37\2\2\u011f\u0121\3\2\2\2\u0120\u00fe\3"+
		"\2\2\2\u0120\u011b\3\2\2\2\u0120\u011c\3\2\2\2\u0121%\3\2\2\2\u0122\u012d"+
		"\7\36\2\2\u0123\u0128\5(\25\2\u0124\u0128\5*\26\2\u0125\u0128\5,\27\2"+
		"\u0126\u0128\5&\24\2\u0127\u0123\3\2\2\2\u0127\u0124\3\2\2\2\u0127\u0125"+
		"\3\2\2\2\u0127\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012a\7\35\2\2"+
		"\u012a\u012c\3\2\2\2\u012b\u0127\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012b"+
		"\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u0134\3\2\2\2\u012f\u012d\3\2\2\2\u0130"+
		"\u0135\5(\25\2\u0131\u0135\5*\26\2\u0132\u0135\5,\27\2\u0133\u0135\5&"+
		"\24\2\u0134\u0130\3\2\2\2\u0134\u0131\3\2\2\2\u0134\u0132\3\2\2\2\u0134"+
		"\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0137\7\37\2\2\u0137\'\3\2\2"+
		"\2\u0138\u0139\7\31\2\2\u0139)\3\2\2\2\u013a\u013b\t\4\2\2\u013b+\3\2"+
		"\2\2\u013c\u013d\7\30\2\2\u013d-\3\2\2\2\u013e\u013f\7 \2\2\u013f\u0149"+
		"\5\62\32\2\u0140\u0141\7\35\2\2\u0141\u0143\5\62\32\2\u0142\u0140\3\2"+
		"\2\2\u0143\u0146\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145"+
		"\u014a\3\2\2\2\u0146\u0144\3\2\2\2\u0147\u0148\7\26\2\2\u0148\u014a\5"+
		"\62\32\2\u0149\u0144\3\2\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a"+
		"\u014b\3\2\2\2\u014b\u014c\7!\2\2\u014c/\3\2\2\2\u014d\u014e\7 \2\2\u014e"+
		"\u014f\7!\2\2\u014f\61\3\2\2\2\u0150\u0156\5(\25\2\u0151\u0156\5*\26\2"+
		"\u0152\u0156\5,\27\2\u0153\u0156\5&\24\2\u0154\u0156\5$\23\2\u0155\u0150"+
		"\3\2\2\2\u0155\u0151\3\2\2\2\u0155\u0152\3\2\2\2\u0155\u0153\3\2\2\2\u0155"+
		"\u0154\3\2\2\2\u0156\63\3\2\2\2&8;AHWY]dnt{\u0085\u008c\u0096\u009c\u00a3"+
		"\u00ad\u00c2\u00c7\u00cc\u00d3\u00db\u00e1\u00e8\u00eb\u00f0\u0107\u010d"+
		"\u0117\u0120\u0127\u012d\u0134\u0144\u0149\u0155";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}