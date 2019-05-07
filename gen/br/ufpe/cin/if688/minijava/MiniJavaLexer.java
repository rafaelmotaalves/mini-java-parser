// Generated from C:/Users/rma7/Documents/mini-java-compiler/src/main/java/br/ufpe/cin/if688/minijava\MiniJava.g4 by ANTLR 4.7.2
package br.ufpe.cin.if688.minijava;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniJavaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MiniJava=1, MainClass=2, Identifier=3, CLASS=4, OPEN_BLOCK=5, CLOSE_BLOCK=6, 
		WS=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"MiniJava", "MainClass", "Identifier", "CLASS", "OPEN_BLOCK", "CLOSE_BLOCK", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'ID'", "'class'", "'}'", "'{'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "MiniJava", "MainClass", "Identifier", "CLASS", "OPEN_BLOCK", "CLOSE_BLOCK", 
			"WS"
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


	public MiniJavaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MiniJava.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\t\67\b\1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\3\3\3\3\3\3\3\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\2\2"+
		"\t\3\3\5\4\7\5\t\6\13\7\r\b\17\t\3\2\3\5\2\13\f\17\17\"\"\2\67\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\3\21\3\2\2\2\5\"\3\2\2\2\7&\3\2\2\2\t)\3\2\2\2\13/\3\2\2\2\r"+
		"\61\3\2\2\2\17\63\3\2\2\2\21\37\5\5\3\2\22\23\7r\2\2\23\24\7n\2\2\24\25"+
		"\7c\2\2\25\26\7e\2\2\26\27\7g\2\2\27\30\7j\2\2\30\31\7q\2\2\31\32\7n\2"+
		"\2\32\33\7f\2\2\33\34\7g\2\2\34\36\7t\2\2\35\22\3\2\2\2\36!\3\2\2\2\37"+
		"\35\3\2\2\2\37 \3\2\2\2 \4\3\2\2\2!\37\3\2\2\2\"#\5\t\5\2#$\5\7\4\2$%"+
		"\5\13\6\2%\6\3\2\2\2&\'\7K\2\2\'(\7F\2\2(\b\3\2\2\2)*\7e\2\2*+\7n\2\2"+
		"+,\7c\2\2,-\7u\2\2-.\7u\2\2.\n\3\2\2\2/\60\7\177\2\2\60\f\3\2\2\2\61\62"+
		"\7}\2\2\62\16\3\2\2\2\63\64\t\2\2\2\64\65\3\2\2\2\65\66\b\b\2\2\66\20"+
		"\3\2\2\2\4\2\37\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}