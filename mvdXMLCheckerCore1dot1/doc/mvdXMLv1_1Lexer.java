// $ANTLR 3.5.2 mvdXMLv1_1.g 2020-04-17 13:04:17

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class mvdXMLv1_1Lexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int AND=4;
	public static final int DIGIT=5;
	public static final int EQUAL=6;
	public static final int ESC_SEQ=7;
	public static final int FALSE=8;
	public static final int GREATER_THAN=9;
	public static final int GREATER_THAN_OR_EQUAL=10;
	public static final int HEX_DIGIT=11;
	public static final int INT=12;
	public static final int LESS_THAN=13;
	public static final int LESS_THAN_OR_EQUAL=14;
	public static final int LETTER=15;
	public static final int LPAREN=16;
	public static final int NOT_EQUAL=17;
	public static final int OCTAL_ESC=18;
	public static final int OR=19;
	public static final int RPAREN=20;
	public static final int SIMPLEID=21;
	public static final int STRING=22;
	public static final int TRUE=23;
	public static final int UNICODE_ESC=24;
	public static final int UNKNOWN=25;
	public static final int WS=26;
	public static final int XOR=27;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public mvdXMLv1_1Lexer() {} 
	public mvdXMLv1_1Lexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public mvdXMLv1_1Lexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "mvdXMLv1_1.g"; }

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:2:7: ( '+' )
			// mvdXMLv1_1.g:2:9: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:3:7: ( '-' )
			// mvdXMLv1_1.g:3:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__29"

	// $ANTLR start "T__30"
	public final void mT__30() throws RecognitionException {
		try {
			int _type = T__30;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:4:7: ( '.' )
			// mvdXMLv1_1.g:4:9: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:5:7: ( '[Size]' )
			// mvdXMLv1_1.g:5:9: '[Size]'
			{
			match("[Size]"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__31"

	// $ANTLR start "T__32"
	public final void mT__32() throws RecognitionException {
		try {
			int _type = T__32;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:6:7: ( '[Type]' )
			// mvdXMLv1_1.g:6:9: '[Type]'
			{
			match("[Type]"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__32"

	// $ANTLR start "T__33"
	public final void mT__33() throws RecognitionException {
		try {
			int _type = T__33;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:7:7: ( '[Unique]' )
			// mvdXMLv1_1.g:7:9: '[Unique]'
			{
			match("[Unique]"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__33"

	// $ANTLR start "T__34"
	public final void mT__34() throws RecognitionException {
		try {
			int _type = T__34;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:8:7: ( '[Value]' )
			// mvdXMLv1_1.g:8:9: '[Value]'
			{
			match("[Value]"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__34"

	// $ANTLR start "T__35"
	public final void mT__35() throws RecognitionException {
		try {
			int _type = T__35;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:9:7: ( 'e' )
			// mvdXMLv1_1.g:9:9: 'e'
			{
			match('e'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__35"

	// $ANTLR start "T__36"
	public final void mT__36() throws RecognitionException {
		try {
			int _type = T__36;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:10:7: ( 'reg' )
			// mvdXMLv1_1.g:10:9: 'reg'
			{
			match("reg"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__36"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:37:2: ( 'AND' | 'and' | '&' | ';' )
			int alt1=4;
			switch ( input.LA(1) ) {
			case 'A':
				{
				alt1=1;
				}
				break;
			case 'a':
				{
				alt1=2;
				}
				break;
			case '&':
				{
				alt1=3;
				}
				break;
			case ';':
				{
				alt1=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}
			switch (alt1) {
				case 1 :
					// mvdXMLv1_1.g:37:4: 'AND'
					{
					match("AND"); 

					}
					break;
				case 2 :
					// mvdXMLv1_1.g:37:12: 'and'
					{
					match("and"); 

					}
					break;
				case 3 :
					// mvdXMLv1_1.g:37:20: '&'
					{
					match('&'); 
					}
					break;
				case 4 :
					// mvdXMLv1_1.g:37:26: ';'
					{
					match(';'); 
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:39:2: ( 'OR' | 'or' | '|' )
			int alt2=3;
			switch ( input.LA(1) ) {
			case 'O':
				{
				alt2=1;
				}
				break;
			case 'o':
				{
				alt2=2;
				}
				break;
			case '|':
				{
				alt2=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// mvdXMLv1_1.g:39:4: 'OR'
					{
					match("OR"); 

					}
					break;
				case 2 :
					// mvdXMLv1_1.g:39:11: 'or'
					{
					match("or"); 

					}
					break;
				case 3 :
					// mvdXMLv1_1.g:39:18: '|'
					{
					match('|'); 
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "XOR"
	public final void mXOR() throws RecognitionException {
		try {
			int _type = XOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:41:2: ( 'XOR' | 'xor' )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='X') ) {
				alt3=1;
			}
			else if ( (LA3_0=='x') ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// mvdXMLv1_1.g:41:4: 'XOR'
					{
					match("XOR"); 

					}
					break;
				case 2 :
					// mvdXMLv1_1.g:41:12: 'xor'
					{
					match("xor"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "XOR"

	// $ANTLR start "EQUAL"
	public final void mEQUAL() throws RecognitionException {
		try {
			int _type = EQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:43:2: ( '=' )
			// mvdXMLv1_1.g:43:4: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQUAL"

	// $ANTLR start "NOT_EQUAL"
	public final void mNOT_EQUAL() throws RecognitionException {
		try {
			int _type = NOT_EQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:45:2: ( '!=' )
			// mvdXMLv1_1.g:45:4: '!='
			{
			match("!="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT_EQUAL"

	// $ANTLR start "GREATER_THAN"
	public final void mGREATER_THAN() throws RecognitionException {
		try {
			int _type = GREATER_THAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:47:2: ( '>' )
			// mvdXMLv1_1.g:47:4: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GREATER_THAN"

	// $ANTLR start "GREATER_THAN_OR_EQUAL"
	public final void mGREATER_THAN_OR_EQUAL() throws RecognitionException {
		try {
			int _type = GREATER_THAN_OR_EQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:49:2: ( '>=' )
			// mvdXMLv1_1.g:49:4: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GREATER_THAN_OR_EQUAL"

	// $ANTLR start "LESS_THAN"
	public final void mLESS_THAN() throws RecognitionException {
		try {
			int _type = LESS_THAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:51:2: ( '<' )
			// mvdXMLv1_1.g:51:4: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LESS_THAN"

	// $ANTLR start "LESS_THAN_OR_EQUAL"
	public final void mLESS_THAN_OR_EQUAL() throws RecognitionException {
		try {
			int _type = LESS_THAN_OR_EQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:53:2: ( '<=' )
			// mvdXMLv1_1.g:53:4: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LESS_THAN_OR_EQUAL"

	// $ANTLR start "FALSE"
	public final void mFALSE() throws RecognitionException {
		try {
			int _type = FALSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:55:2: ( 'FALSE' | 'false' )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='F') ) {
				alt4=1;
			}
			else if ( (LA4_0=='f') ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// mvdXMLv1_1.g:55:4: 'FALSE'
					{
					match("FALSE"); 

					}
					break;
				case 2 :
					// mvdXMLv1_1.g:55:14: 'false'
					{
					match("false"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FALSE"

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:57:2: ( 'TRUE' | 'true' )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='T') ) {
				alt5=1;
			}
			else if ( (LA5_0=='t') ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// mvdXMLv1_1.g:57:4: 'TRUE'
					{
					match("TRUE"); 

					}
					break;
				case 2 :
					// mvdXMLv1_1.g:57:13: 'true'
					{
					match("true"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRUE"

	// $ANTLR start "UNKNOWN"
	public final void mUNKNOWN() throws RecognitionException {
		try {
			int _type = UNKNOWN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:59:2: ( 'UNKNOWN' | 'unknown' )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0=='U') ) {
				alt6=1;
			}
			else if ( (LA6_0=='u') ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// mvdXMLv1_1.g:59:4: 'UNKNOWN'
					{
					match("UNKNOWN"); 

					}
					break;
				case 2 :
					// mvdXMLv1_1.g:59:16: 'unknown'
					{
					match("unknown"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNKNOWN"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			int _type = DIGIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:61:2: ( '0' .. '9' )
			// mvdXMLv1_1.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIGIT"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:63:2: ( ( '0' .. '9' )+ )
			// mvdXMLv1_1.g:63:4: ( '0' .. '9' )+
			{
			// mvdXMLv1_1.g:63:4: ( '0' .. '9' )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// mvdXMLv1_1.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt7 >= 1 ) break loop7;
					EarlyExitException eee = new EarlyExitException(7, input);
					throw eee;
				}
				cnt7++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "HEX_DIGIT"
	public final void mHEX_DIGIT() throws RecognitionException {
		try {
			int _type = HEX_DIGIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:65:2: ( DIGIT | ( 'a' .. 'f' | 'A' .. 'F' ) )
			// mvdXMLv1_1.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HEX_DIGIT"

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			int _type = LETTER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:67:2: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) )
			// mvdXMLv1_1.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LETTER"

	// $ANTLR start "SIMPLEID"
	public final void mSIMPLEID() throws RecognitionException {
		try {
			int _type = SIMPLEID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:69:2: ( LETTER ( LETTER | DIGIT | '_' )* )
			// mvdXMLv1_1.g:69:4: LETTER ( LETTER | DIGIT | '_' )*
			{
			mLETTER(); 

			// mvdXMLv1_1.g:69:11: ( LETTER | DIGIT | '_' )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= '0' && LA8_0 <= '9')||(LA8_0 >= 'A' && LA8_0 <= 'Z')||LA8_0=='_'||(LA8_0 >= 'a' && LA8_0 <= 'z')) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// mvdXMLv1_1.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop8;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SIMPLEID"

	// $ANTLR start "LPAREN"
	public final void mLPAREN() throws RecognitionException {
		try {
			int _type = LPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:71:2: ( '(' )
			// mvdXMLv1_1.g:71:7: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAREN"

	// $ANTLR start "RPAREN"
	public final void mRPAREN() throws RecognitionException {
		try {
			int _type = RPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:73:2: ( ')' )
			// mvdXMLv1_1.g:73:7: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAREN"

	// $ANTLR start "OCTAL_ESC"
	public final void mOCTAL_ESC() throws RecognitionException {
		try {
			int _type = OCTAL_ESC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:75:2: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
			int alt9=3;
			int LA9_0 = input.LA(1);
			if ( (LA9_0=='\\') ) {
				int LA9_1 = input.LA(2);
				if ( ((LA9_1 >= '0' && LA9_1 <= '3')) ) {
					int LA9_2 = input.LA(3);
					if ( ((LA9_2 >= '0' && LA9_2 <= '7')) ) {
						int LA9_4 = input.LA(4);
						if ( ((LA9_4 >= '0' && LA9_4 <= '7')) ) {
							alt9=1;
						}

						else {
							alt9=2;
						}

					}

					else {
						alt9=3;
					}

				}
				else if ( ((LA9_1 >= '4' && LA9_1 <= '7')) ) {
					int LA9_3 = input.LA(3);
					if ( ((LA9_3 >= '0' && LA9_3 <= '7')) ) {
						alt9=2;
					}

					else {
						alt9=3;
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 9, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// mvdXMLv1_1.g:75:7: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
					{
					match('\\'); 
					if ( (input.LA(1) >= '0' && input.LA(1) <= '3') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 2 :
					// mvdXMLv1_1.g:75:51: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
					{
					match('\\'); 
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 3 :
					// mvdXMLv1_1.g:75:84: '\\\\' ( '0' .. '7' )
					{
					match('\\'); 
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OCTAL_ESC"

	// $ANTLR start "UNICODE_ESC"
	public final void mUNICODE_ESC() throws RecognitionException {
		try {
			int _type = UNICODE_ESC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:77:2: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
			// mvdXMLv1_1.g:77:7: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
			{
			match('\\'); 
			match('u'); 
			mHEX_DIGIT(); 

			mHEX_DIGIT(); 

			mHEX_DIGIT(); 

			mHEX_DIGIT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNICODE_ESC"

	// $ANTLR start "ESC_SEQ"
	public final void mESC_SEQ() throws RecognitionException {
		try {
			int _type = ESC_SEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:79:6: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
			int alt10=3;
			int LA10_0 = input.LA(1);
			if ( (LA10_0=='\\') ) {
				switch ( input.LA(2) ) {
				case '\"':
				case '\'':
				case '\\':
				case 'b':
				case 'f':
				case 'n':
				case 'r':
				case 't':
					{
					alt10=1;
					}
					break;
				case 'u':
					{
					alt10=2;
					}
					break;
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
					{
					alt10=3;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 10, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// mvdXMLv1_1.g:79:11: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
					{
					match('\\'); 
					if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 2 :
					// mvdXMLv1_1.g:79:58: UNICODE_ESC
					{
					mUNICODE_ESC(); 

					}
					break;
				case 3 :
					// mvdXMLv1_1.g:79:75: OCTAL_ESC
					{
					mOCTAL_ESC(); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ESC_SEQ"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:81:2: ( '\\'' ( ESC_SEQ |~ ( '\\\\' | '\\'' ) )* '\\'' )
			// mvdXMLv1_1.g:81:6: '\\'' ( ESC_SEQ |~ ( '\\\\' | '\\'' ) )* '\\''
			{
			match('\''); 
			// mvdXMLv1_1.g:81:11: ( ESC_SEQ |~ ( '\\\\' | '\\'' ) )*
			loop11:
			while (true) {
				int alt11=3;
				int LA11_0 = input.LA(1);
				if ( (LA11_0=='\\') ) {
					alt11=1;
				}
				else if ( ((LA11_0 >= '\u0000' && LA11_0 <= '&')||(LA11_0 >= '(' && LA11_0 <= '[')||(LA11_0 >= ']' && LA11_0 <= '\uFFFF')) ) {
					alt11=2;
				}

				switch (alt11) {
				case 1 :
					// mvdXMLv1_1.g:81:13: ESC_SEQ
					{
					mESC_SEQ(); 

					}
					break;
				case 2 :
					// mvdXMLv1_1.g:81:23: ~ ( '\\\\' | '\\'' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop11;
				}
			}

			match('\''); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mvdXMLv1_1.g:83:2: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
			// mvdXMLv1_1.g:83:4: ( ' ' | '\\t' | '\\n' | '\\r' )+
			{
			// mvdXMLv1_1.g:83:4: ( ' ' | '\\t' | '\\n' | '\\r' )+
			int cnt12=0;
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( ((LA12_0 >= '\t' && LA12_0 <= '\n')||LA12_0=='\r'||LA12_0==' ') ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// mvdXMLv1_1.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt12 >= 1 ) break loop12;
					EarlyExitException eee = new EarlyExitException(12, input);
					throw eee;
				}
				cnt12++;
			}

			 _channel = HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// mvdXMLv1_1.g:1:8: ( T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | AND | OR | XOR | EQUAL | NOT_EQUAL | GREATER_THAN | GREATER_THAN_OR_EQUAL | LESS_THAN | LESS_THAN_OR_EQUAL | FALSE | TRUE | UNKNOWN | DIGIT | INT | HEX_DIGIT | LETTER | SIMPLEID | LPAREN | RPAREN | OCTAL_ESC | UNICODE_ESC | ESC_SEQ | STRING | WS )
		int alt13=33;
		alt13 = dfa13.predict(input);
		switch (alt13) {
			case 1 :
				// mvdXMLv1_1.g:1:10: T__28
				{
				mT__28(); 

				}
				break;
			case 2 :
				// mvdXMLv1_1.g:1:16: T__29
				{
				mT__29(); 

				}
				break;
			case 3 :
				// mvdXMLv1_1.g:1:22: T__30
				{
				mT__30(); 

				}
				break;
			case 4 :
				// mvdXMLv1_1.g:1:28: T__31
				{
				mT__31(); 

				}
				break;
			case 5 :
				// mvdXMLv1_1.g:1:34: T__32
				{
				mT__32(); 

				}
				break;
			case 6 :
				// mvdXMLv1_1.g:1:40: T__33
				{
				mT__33(); 

				}
				break;
			case 7 :
				// mvdXMLv1_1.g:1:46: T__34
				{
				mT__34(); 

				}
				break;
			case 8 :
				// mvdXMLv1_1.g:1:52: T__35
				{
				mT__35(); 

				}
				break;
			case 9 :
				// mvdXMLv1_1.g:1:58: T__36
				{
				mT__36(); 

				}
				break;
			case 10 :
				// mvdXMLv1_1.g:1:64: AND
				{
				mAND(); 

				}
				break;
			case 11 :
				// mvdXMLv1_1.g:1:68: OR
				{
				mOR(); 

				}
				break;
			case 12 :
				// mvdXMLv1_1.g:1:71: XOR
				{
				mXOR(); 

				}
				break;
			case 13 :
				// mvdXMLv1_1.g:1:75: EQUAL
				{
				mEQUAL(); 

				}
				break;
			case 14 :
				// mvdXMLv1_1.g:1:81: NOT_EQUAL
				{
				mNOT_EQUAL(); 

				}
				break;
			case 15 :
				// mvdXMLv1_1.g:1:91: GREATER_THAN
				{
				mGREATER_THAN(); 

				}
				break;
			case 16 :
				// mvdXMLv1_1.g:1:104: GREATER_THAN_OR_EQUAL
				{
				mGREATER_THAN_OR_EQUAL(); 

				}
				break;
			case 17 :
				// mvdXMLv1_1.g:1:126: LESS_THAN
				{
				mLESS_THAN(); 

				}
				break;
			case 18 :
				// mvdXMLv1_1.g:1:136: LESS_THAN_OR_EQUAL
				{
				mLESS_THAN_OR_EQUAL(); 

				}
				break;
			case 19 :
				// mvdXMLv1_1.g:1:155: FALSE
				{
				mFALSE(); 

				}
				break;
			case 20 :
				// mvdXMLv1_1.g:1:161: TRUE
				{
				mTRUE(); 

				}
				break;
			case 21 :
				// mvdXMLv1_1.g:1:166: UNKNOWN
				{
				mUNKNOWN(); 

				}
				break;
			case 22 :
				// mvdXMLv1_1.g:1:174: DIGIT
				{
				mDIGIT(); 

				}
				break;
			case 23 :
				// mvdXMLv1_1.g:1:180: INT
				{
				mINT(); 

				}
				break;
			case 24 :
				// mvdXMLv1_1.g:1:184: HEX_DIGIT
				{
				mHEX_DIGIT(); 

				}
				break;
			case 25 :
				// mvdXMLv1_1.g:1:194: LETTER
				{
				mLETTER(); 

				}
				break;
			case 26 :
				// mvdXMLv1_1.g:1:201: SIMPLEID
				{
				mSIMPLEID(); 

				}
				break;
			case 27 :
				// mvdXMLv1_1.g:1:210: LPAREN
				{
				mLPAREN(); 

				}
				break;
			case 28 :
				// mvdXMLv1_1.g:1:217: RPAREN
				{
				mRPAREN(); 

				}
				break;
			case 29 :
				// mvdXMLv1_1.g:1:224: OCTAL_ESC
				{
				mOCTAL_ESC(); 

				}
				break;
			case 30 :
				// mvdXMLv1_1.g:1:234: UNICODE_ESC
				{
				mUNICODE_ESC(); 

				}
				break;
			case 31 :
				// mvdXMLv1_1.g:1:246: ESC_SEQ
				{
				mESC_SEQ(); 

				}
				break;
			case 32 :
				// mvdXMLv1_1.g:1:254: STRING
				{
				mSTRING(); 

				}
				break;
			case 33 :
				// mvdXMLv1_1.g:1:261: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA13 dfa13 = new DFA13(this);
	static final String DFA13_eotS =
		"\5\uffff\1\45\1\50\2\52\1\uffff\2\50\1\uffff\2\50\2\uffff\1\61\1\63\2"+
		"\52\4\50\1\72\1\52\1\50\13\uffff\1\46\1\uffff\1\46\1\uffff\1\46\2\14\2"+
		"\46\4\uffff\6\46\2\uffff\2\114\2\uffff\1\117\2\11\2\120\6\46\1\114\5\uffff"+
		"\2\46\2\133\2\46\2\uffff\2\137\1\uffff\2\46\2\uffff\2\46\1\uffff\2\146"+
		"\2\uffff";
	static final String DFA13_eofS =
		"\147\uffff";
	static final String DFA13_minS =
		"\1\11\3\uffff\1\123\4\60\1\uffff\2\60\1\uffff\2\60\2\uffff\2\75\11\60"+
		"\2\uffff\1\42\10\uffff\1\147\1\uffff\1\104\1\uffff\1\144\2\60\1\122\1"+
		"\162\4\uffff\1\114\1\154\1\125\1\165\1\113\1\153\2\uffff\3\60\1\uffff"+
		"\5\60\1\123\1\163\1\105\1\145\1\116\1\156\1\60\2\uffff\1\60\2\uffff\1"+
		"\105\1\145\2\60\1\117\1\157\1\uffff\3\60\1\uffff\1\127\1\167\1\60\1\uffff"+
		"\1\116\1\156\1\uffff\2\60\2\uffff";
	static final String DFA13_maxS =
		"\1\174\3\uffff\1\126\4\172\1\uffff\2\172\1\uffff\2\172\2\uffff\2\75\6"+
		"\172\1\71\2\172\2\uffff\1\165\10\uffff\1\147\1\uffff\1\104\1\uffff\1\144"+
		"\2\172\1\122\1\162\4\uffff\1\114\1\154\1\125\1\165\1\113\1\153\2\uffff"+
		"\2\67\1\146\1\uffff\5\172\1\123\1\163\1\105\1\145\1\116\1\156\1\67\2\uffff"+
		"\1\146\2\uffff\1\105\1\145\2\172\1\117\1\157\1\uffff\1\146\2\172\1\uffff"+
		"\1\127\1\167\1\146\1\uffff\1\116\1\156\1\uffff\2\172\2\uffff";
	static final String DFA13_acceptS =
		"\1\uffff\1\1\1\2\1\3\5\uffff\1\12\2\uffff\1\13\2\uffff\1\15\1\16\13\uffff"+
		"\1\33\1\34\1\uffff\1\40\1\41\1\4\1\5\1\6\1\7\1\10\1\32\1\uffff\1\31\1"+
		"\uffff\1\30\5\uffff\1\20\1\17\1\22\1\21\6\uffff\1\26\1\27\3\uffff\1\37"+
		"\14\uffff\2\35\1\uffff\1\11\1\14\6\uffff\1\35\3\uffff\1\24\3\uffff\1\23"+
		"\2\uffff\1\36\2\uffff\1\36\1\25";
	static final String DFA13_specialS =
		"\147\uffff}>";
	static final String[] DFA13_transitionS = {
			"\2\40\2\uffff\1\40\22\uffff\1\40\1\20\4\uffff\1\11\1\37\1\34\1\35\1\uffff"+
			"\1\1\1\uffff\1\2\1\3\1\uffff\12\31\1\uffff\1\11\1\22\1\17\1\21\2\uffff"+
			"\1\7\4\32\1\23\10\33\1\12\4\33\1\25\1\27\2\33\1\15\2\33\1\4\1\36\4\uffff"+
			"\1\10\3\32\1\5\1\24\10\33\1\13\2\33\1\6\1\33\1\26\1\30\2\33\1\16\2\33"+
			"\1\uffff\1\14",
			"",
			"",
			"",
			"\1\41\1\42\1\43\1\44",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\4\46\1\47\25\46",
			"\12\46\7\uffff\15\46\1\51\14\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\15\46\1\53\14\46",
			"",
			"\12\46\7\uffff\21\46\1\54\10\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\21\46\1\55\10\46",
			"",
			"\12\46\7\uffff\16\46\1\56\13\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\16\46\1\57\13\46",
			"",
			"",
			"\1\60",
			"\1\62",
			"\12\46\7\uffff\1\64\31\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\1\65\31\46",
			"\12\46\7\uffff\21\46\1\66\10\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\21\46\1\67\10\46",
			"\12\46\7\uffff\15\46\1\70\14\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\15\46\1\71\14\46",
			"\12\73",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"",
			"",
			"\1\77\4\uffff\1\77\10\uffff\4\74\4\75\44\uffff\1\77\5\uffff\1\77\3\uffff"+
			"\1\77\7\uffff\1\77\3\uffff\1\77\1\uffff\1\77\1\76",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\100",
			"",
			"\1\101",
			"",
			"\1\102",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\103",
			"\1\104",
			"",
			"",
			"",
			"",
			"\1\105",
			"\1\106",
			"\1\107",
			"\1\110",
			"\1\111",
			"\1\112",
			"",
			"",
			"\10\113",
			"\10\115",
			"\12\116\7\uffff\6\116\32\uffff\6\116",
			"",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\121",
			"\1\122",
			"\1\123",
			"\1\124",
			"\1\125",
			"\1\126",
			"\10\127",
			"",
			"",
			"\12\130\7\uffff\6\130\32\uffff\6\130",
			"",
			"",
			"\1\131",
			"\1\132",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\134",
			"\1\135",
			"",
			"\12\136\7\uffff\6\136\32\uffff\6\136",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"",
			"\1\140",
			"\1\141",
			"\12\142\7\uffff\6\142\32\uffff\6\142",
			"",
			"\1\143",
			"\1\144",
			"",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"",
			""
	};

	static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
	static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
	static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
	static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
	static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
	static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
	static final short[][] DFA13_transition;

	static {
		int numStates = DFA13_transitionS.length;
		DFA13_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
		}
	}

	protected class DFA13 extends DFA {

		public DFA13(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 13;
			this.eot = DFA13_eot;
			this.eof = DFA13_eof;
			this.min = DFA13_min;
			this.max = DFA13_max;
			this.accept = DFA13_accept;
			this.special = DFA13_special;
			this.transition = DFA13_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | AND | OR | XOR | EQUAL | NOT_EQUAL | GREATER_THAN | GREATER_THAN_OR_EQUAL | LESS_THAN | LESS_THAN_OR_EQUAL | FALSE | TRUE | UNKNOWN | DIGIT | INT | HEX_DIGIT | LETTER | SIMPLEID | LPAREN | RPAREN | OCTAL_ESC | UNICODE_ESC | ESC_SEQ | STRING | WS );";
		}
	}

}
