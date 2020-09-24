// $ANTLR 3.5.2 MvdXMLv1_1.g 2020-09-24 15:57:55

package generated.mvdxml1dot1.rule_operators;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class MvdXMLv1_1Lexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int T__39=39;
	public static final int T__40=40;
	public static final int AND=4;
	public static final int DIGIT=5;
	public static final int EQUAL=6;
	public static final int ESC_SEQ=7;
	public static final int EXISTS=8;
	public static final int FALSE=9;
	public static final int GREATER_THAN=10;
	public static final int GREATER_THAN_OR_EQUAL=11;
	public static final int HEX_DIGIT=12;
	public static final int INT=13;
	public static final int LESS_THAN=14;
	public static final int LESS_THAN_OR_EQUAL=15;
	public static final int LETTER=16;
	public static final int LPAREN=17;
	public static final int NAND=18;
	public static final int NOR=19;
	public static final int NOT_EQUAL=20;
	public static final int NXOR=21;
	public static final int OCTAL_ESC=22;
	public static final int OR=23;
	public static final int RPAREN=24;
	public static final int SIMPLEID=25;
	public static final int SIZE=26;
	public static final int STRING=27;
	public static final int TRUE=28;
	public static final int TYPE=29;
	public static final int UNICODE_ESC=30;
	public static final int UNIQUE=31;
	public static final int UNKNOWN=32;
	public static final int VALUE=33;
	public static final int WS=34;
	public static final int XOR=35;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public MvdXMLv1_1Lexer() {} 
	public MvdXMLv1_1Lexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public MvdXMLv1_1Lexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "MvdXMLv1_1.g"; }

	// $ANTLR start "T__36"
	public final void mT__36() throws RecognitionException {
		try {
			int _type = T__36;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MvdXMLv1_1.g:6:7: ( '+' )
			// MvdXMLv1_1.g:6:9: '+'
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
	// $ANTLR end "T__36"

	// $ANTLR start "T__37"
	public final void mT__37() throws RecognitionException {
		try {
			int _type = T__37;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MvdXMLv1_1.g:7:7: ( '-' )
			// MvdXMLv1_1.g:7:9: '-'
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
	// $ANTLR end "T__37"

	// $ANTLR start "T__38"
	public final void mT__38() throws RecognitionException {
		try {
			int _type = T__38;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MvdXMLv1_1.g:8:7: ( '.' )
			// MvdXMLv1_1.g:8:9: '.'
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
	// $ANTLR end "T__38"

	// $ANTLR start "T__39"
	public final void mT__39() throws RecognitionException {
		try {
			int _type = T__39;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MvdXMLv1_1.g:9:7: ( 'e' )
			// MvdXMLv1_1.g:9:9: 'e'
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
	// $ANTLR end "T__39"

	// $ANTLR start "T__40"
	public final void mT__40() throws RecognitionException {
		try {
			int _type = T__40;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MvdXMLv1_1.g:10:7: ( 'reg' )
			// MvdXMLv1_1.g:10:9: 'reg'
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
	// $ANTLR end "T__40"

	// $ANTLR start "VALUE"
	public final void mVALUE() throws RecognitionException {
		try {
			int _type = VALUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MvdXMLv1_1.g:158:3: ( '[Value]' | '[value]' | '[VALUE]' )
			int alt1=3;
			int LA1_0 = input.LA(1);
			if ( (LA1_0=='[') ) {
				int LA1_1 = input.LA(2);
				if ( (LA1_1=='V') ) {
					int LA1_2 = input.LA(3);
					if ( (LA1_2=='a') ) {
						alt1=1;
					}
					else if ( (LA1_2=='A') ) {
						alt1=3;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 1, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA1_1=='v') ) {
					alt1=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// MvdXMLv1_1.g:158:5: '[Value]'
					{
					match("[Value]"); 

					}
					break;
				case 2 :
					// MvdXMLv1_1.g:158:17: '[value]'
					{
					match("[value]"); 

					}
					break;
				case 3 :
					// MvdXMLv1_1.g:158:29: '[VALUE]'
					{
					match("[VALUE]"); 

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
	// $ANTLR end "VALUE"

	// $ANTLR start "SIZE"
	public final void mSIZE() throws RecognitionException {
		try {
			int _type = SIZE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MvdXMLv1_1.g:160:3: ( '[Size]' | '[size]' | '[SIZE]' )
			int alt2=3;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='[') ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1=='S') ) {
					int LA2_2 = input.LA(3);
					if ( (LA2_2=='i') ) {
						alt2=1;
					}
					else if ( (LA2_2=='I') ) {
						alt2=3;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 2, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA2_1=='s') ) {
					alt2=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// MvdXMLv1_1.g:160:5: '[Size]'
					{
					match("[Size]"); 

					}
					break;
				case 2 :
					// MvdXMLv1_1.g:160:16: '[size]'
					{
					match("[size]"); 

					}
					break;
				case 3 :
					// MvdXMLv1_1.g:160:27: '[SIZE]'
					{
					match("[SIZE]"); 

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
	// $ANTLR end "SIZE"

	// $ANTLR start "TYPE"
	public final void mTYPE() throws RecognitionException {
		try {
			int _type = TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MvdXMLv1_1.g:162:3: ( '[Type]' | '[type]' | '[TYPE]' )
			int alt3=3;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='[') ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1=='T') ) {
					int LA3_2 = input.LA(3);
					if ( (LA3_2=='y') ) {
						alt3=1;
					}
					else if ( (LA3_2=='Y') ) {
						alt3=3;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 3, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA3_1=='t') ) {
					alt3=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 3, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// MvdXMLv1_1.g:162:5: '[Type]'
					{
					match("[Type]"); 

					}
					break;
				case 2 :
					// MvdXMLv1_1.g:162:16: '[type]'
					{
					match("[type]"); 

					}
					break;
				case 3 :
					// MvdXMLv1_1.g:162:27: '[TYPE]'
					{
					match("[TYPE]"); 

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
	// $ANTLR end "TYPE"

	// $ANTLR start "UNIQUE"
	public final void mUNIQUE() throws RecognitionException {
		try {
			int _type = UNIQUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MvdXMLv1_1.g:164:3: ( '[Unique]' | '[unique]' | '[UNIQUE]' )
			int alt4=3;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='[') ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1=='U') ) {
					int LA4_2 = input.LA(3);
					if ( (LA4_2=='n') ) {
						alt4=1;
					}
					else if ( (LA4_2=='N') ) {
						alt4=3;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 4, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA4_1=='u') ) {
					alt4=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// MvdXMLv1_1.g:164:5: '[Unique]'
					{
					match("[Unique]"); 

					}
					break;
				case 2 :
					// MvdXMLv1_1.g:164:18: '[unique]'
					{
					match("[unique]"); 

					}
					break;
				case 3 :
					// MvdXMLv1_1.g:164:31: '[UNIQUE]'
					{
					match("[UNIQUE]"); 

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
	// $ANTLR end "UNIQUE"

	// $ANTLR start "EXISTS"
	public final void mEXISTS() throws RecognitionException {
		try {
			int _type = EXISTS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MvdXMLv1_1.g:166:3: ( '[Exist]' | '[exists]' | '[EXISTS]' )
			int alt5=3;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='[') ) {
				int LA5_1 = input.LA(2);
				if ( (LA5_1=='E') ) {
					int LA5_2 = input.LA(3);
					if ( (LA5_2=='x') ) {
						alt5=1;
					}
					else if ( (LA5_2=='X') ) {
						alt5=3;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 5, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA5_1=='e') ) {
					alt5=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 5, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// MvdXMLv1_1.g:166:5: '[Exist]'
					{
					match("[Exist]"); 

					}
					break;
				case 2 :
					// MvdXMLv1_1.g:166:17: '[exists]'
					{
					match("[exists]"); 

					}
					break;
				case 3 :
					// MvdXMLv1_1.g:166:30: '[EXISTS]'
					{
					match("[EXISTS]"); 

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
	// $ANTLR end "EXISTS"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MvdXMLv1_1.g:168:2: ( 'AND' | 'and' | 'And' | '&' )
			int alt6=4;
			switch ( input.LA(1) ) {
			case 'A':
				{
				int LA6_1 = input.LA(2);
				if ( (LA6_1=='N') ) {
					alt6=1;
				}
				else if ( (LA6_1=='n') ) {
					alt6=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 6, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 'a':
				{
				alt6=2;
				}
				break;
			case '&':
				{
				alt6=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// MvdXMLv1_1.g:168:4: 'AND'
					{
					match("AND"); 

					}
					break;
				case 2 :
					// MvdXMLv1_1.g:168:12: 'and'
					{
					match("and"); 

					}
					break;
				case 3 :
					// MvdXMLv1_1.g:168:20: 'And'
					{
					match("And"); 

					}
					break;
				case 4 :
					// MvdXMLv1_1.g:168:28: '&'
					{
					match('&'); 
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
			// MvdXMLv1_1.g:170:2: ( 'OR' | 'or' | 'Or' | '|' )
			int alt7=4;
			switch ( input.LA(1) ) {
			case 'O':
				{
				int LA7_1 = input.LA(2);
				if ( (LA7_1=='R') ) {
					alt7=1;
				}
				else if ( (LA7_1=='r') ) {
					alt7=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 7, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 'o':
				{
				alt7=2;
				}
				break;
			case '|':
				{
				alt7=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// MvdXMLv1_1.g:170:4: 'OR'
					{
					match("OR"); 

					}
					break;
				case 2 :
					// MvdXMLv1_1.g:170:11: 'or'
					{
					match("or"); 

					}
					break;
				case 3 :
					// MvdXMLv1_1.g:170:18: 'Or'
					{
					match("Or"); 

					}
					break;
				case 4 :
					// MvdXMLv1_1.g:170:25: '|'
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
			// MvdXMLv1_1.g:172:2: ( 'XOR' | 'xor' )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0=='X') ) {
				alt8=1;
			}
			else if ( (LA8_0=='x') ) {
				alt8=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// MvdXMLv1_1.g:172:4: 'XOR'
					{
					match("XOR"); 

					}
					break;
				case 2 :
					// MvdXMLv1_1.g:172:12: 'xor'
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

	// $ANTLR start "NAND"
	public final void mNAND() throws RecognitionException {
		try {
			int _type = NAND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MvdXMLv1_1.g:174:2: ( 'NAND' | 'nand' )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0=='N') ) {
				alt9=1;
			}
			else if ( (LA9_0=='n') ) {
				alt9=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// MvdXMLv1_1.g:174:4: 'NAND'
					{
					match("NAND"); 

					}
					break;
				case 2 :
					// MvdXMLv1_1.g:174:13: 'nand'
					{
					match("nand"); 

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
	// $ANTLR end "NAND"

	// $ANTLR start "NOR"
	public final void mNOR() throws RecognitionException {
		try {
			int _type = NOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MvdXMLv1_1.g:176:2: ( 'NOR' | 'nor' )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0=='N') ) {
				alt10=1;
			}
			else if ( (LA10_0=='n') ) {
				alt10=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// MvdXMLv1_1.g:176:4: 'NOR'
					{
					match("NOR"); 

					}
					break;
				case 2 :
					// MvdXMLv1_1.g:176:12: 'nor'
					{
					match("nor"); 

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
	// $ANTLR end "NOR"

	// $ANTLR start "NXOR"
	public final void mNXOR() throws RecognitionException {
		try {
			int _type = NXOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MvdXMLv1_1.g:178:2: ( 'NXOR' | 'nxor' )
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0=='N') ) {
				alt11=1;
			}
			else if ( (LA11_0=='n') ) {
				alt11=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// MvdXMLv1_1.g:178:4: 'NXOR'
					{
					match("NXOR"); 

					}
					break;
				case 2 :
					// MvdXMLv1_1.g:178:13: 'nxor'
					{
					match("nxor"); 

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
	// $ANTLR end "NXOR"

	// $ANTLR start "EQUAL"
	public final void mEQUAL() throws RecognitionException {
		try {
			int _type = EQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// MvdXMLv1_1.g:180:2: ( '=' )
			// MvdXMLv1_1.g:180:4: '='
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
			// MvdXMLv1_1.g:182:2: ( '!=' )
			// MvdXMLv1_1.g:182:4: '!='
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
			// MvdXMLv1_1.g:184:2: ( '>' )
			// MvdXMLv1_1.g:184:4: '>'
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
			// MvdXMLv1_1.g:186:2: ( '>=' )
			// MvdXMLv1_1.g:186:4: '>='
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
			// MvdXMLv1_1.g:188:2: ( '<' )
			// MvdXMLv1_1.g:188:4: '<'
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
			// MvdXMLv1_1.g:190:2: ( '<=' )
			// MvdXMLv1_1.g:190:4: '<='
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
			// MvdXMLv1_1.g:192:2: ( 'FALSE' | 'false' )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0=='F') ) {
				alt12=1;
			}
			else if ( (LA12_0=='f') ) {
				alt12=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// MvdXMLv1_1.g:192:4: 'FALSE'
					{
					match("FALSE"); 

					}
					break;
				case 2 :
					// MvdXMLv1_1.g:192:14: 'false'
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
			// MvdXMLv1_1.g:194:2: ( 'TRUE' | 'true' )
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0=='T') ) {
				alt13=1;
			}
			else if ( (LA13_0=='t') ) {
				alt13=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// MvdXMLv1_1.g:194:4: 'TRUE'
					{
					match("TRUE"); 

					}
					break;
				case 2 :
					// MvdXMLv1_1.g:194:13: 'true'
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
			// MvdXMLv1_1.g:196:2: ( 'UNKNOWN' | 'unknown' )
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0=='U') ) {
				alt14=1;
			}
			else if ( (LA14_0=='u') ) {
				alt14=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}

			switch (alt14) {
				case 1 :
					// MvdXMLv1_1.g:196:4: 'UNKNOWN'
					{
					match("UNKNOWN"); 

					}
					break;
				case 2 :
					// MvdXMLv1_1.g:196:16: 'unknown'
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
			// MvdXMLv1_1.g:198:2: ( '0' .. '9' )
			// MvdXMLv1_1.g:
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
			// MvdXMLv1_1.g:200:2: ( ( '0' .. '9' )+ )
			// MvdXMLv1_1.g:200:4: ( '0' .. '9' )+
			{
			// MvdXMLv1_1.g:200:4: ( '0' .. '9' )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( ((LA15_0 >= '0' && LA15_0 <= '9')) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// MvdXMLv1_1.g:
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
					if ( cnt15 >= 1 ) break loop15;
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
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
			// MvdXMLv1_1.g:202:2: ( DIGIT | ( 'a' .. 'f' | 'A' .. 'F' ) )
			// MvdXMLv1_1.g:
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
			// MvdXMLv1_1.g:204:2: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) )
			// MvdXMLv1_1.g:
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
			// MvdXMLv1_1.g:206:2: ( LETTER ( LETTER | DIGIT | '_' )* )
			// MvdXMLv1_1.g:206:4: LETTER ( LETTER | DIGIT | '_' )*
			{
			mLETTER(); 

			// MvdXMLv1_1.g:206:11: ( LETTER | DIGIT | '_' )*
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( ((LA16_0 >= '0' && LA16_0 <= '9')||(LA16_0 >= 'A' && LA16_0 <= 'Z')||LA16_0=='_'||(LA16_0 >= 'a' && LA16_0 <= 'z')) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// MvdXMLv1_1.g:
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
					break loop16;
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
			// MvdXMLv1_1.g:208:2: ( '(' )
			// MvdXMLv1_1.g:208:7: '('
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
			// MvdXMLv1_1.g:210:2: ( ')' )
			// MvdXMLv1_1.g:210:7: ')'
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
			// MvdXMLv1_1.g:212:2: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
			int alt17=3;
			int LA17_0 = input.LA(1);
			if ( (LA17_0=='\\') ) {
				int LA17_1 = input.LA(2);
				if ( ((LA17_1 >= '0' && LA17_1 <= '3')) ) {
					int LA17_2 = input.LA(3);
					if ( ((LA17_2 >= '0' && LA17_2 <= '7')) ) {
						int LA17_4 = input.LA(4);
						if ( ((LA17_4 >= '0' && LA17_4 <= '7')) ) {
							alt17=1;
						}

						else {
							alt17=2;
						}

					}

					else {
						alt17=3;
					}

				}
				else if ( ((LA17_1 >= '4' && LA17_1 <= '7')) ) {
					int LA17_3 = input.LA(3);
					if ( ((LA17_3 >= '0' && LA17_3 <= '7')) ) {
						alt17=2;
					}

					else {
						alt17=3;
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 17, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}

			switch (alt17) {
				case 1 :
					// MvdXMLv1_1.g:212:7: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
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
					// MvdXMLv1_1.g:212:51: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
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
					// MvdXMLv1_1.g:212:84: '\\\\' ( '0' .. '7' )
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
			// MvdXMLv1_1.g:214:2: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
			// MvdXMLv1_1.g:214:7: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
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
			// MvdXMLv1_1.g:216:6: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
			int alt18=3;
			int LA18_0 = input.LA(1);
			if ( (LA18_0=='\\') ) {
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
					alt18=1;
					}
					break;
				case 'u':
					{
					alt18=2;
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
					alt18=3;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 18, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}

			switch (alt18) {
				case 1 :
					// MvdXMLv1_1.g:216:11: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
					// MvdXMLv1_1.g:216:58: UNICODE_ESC
					{
					mUNICODE_ESC(); 

					}
					break;
				case 3 :
					// MvdXMLv1_1.g:216:75: OCTAL_ESC
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
			// MvdXMLv1_1.g:218:2: ( '\\'' ( ESC_SEQ |~ ( '\\\\' | '\\'' ) )* '\\'' )
			// MvdXMLv1_1.g:218:6: '\\'' ( ESC_SEQ |~ ( '\\\\' | '\\'' ) )* '\\''
			{
			match('\''); 
			// MvdXMLv1_1.g:218:11: ( ESC_SEQ |~ ( '\\\\' | '\\'' ) )*
			loop19:
			while (true) {
				int alt19=3;
				int LA19_0 = input.LA(1);
				if ( (LA19_0=='\\') ) {
					alt19=1;
				}
				else if ( ((LA19_0 >= '\u0000' && LA19_0 <= '&')||(LA19_0 >= '(' && LA19_0 <= '[')||(LA19_0 >= ']' && LA19_0 <= '\uFFFF')) ) {
					alt19=2;
				}

				switch (alt19) {
				case 1 :
					// MvdXMLv1_1.g:218:13: ESC_SEQ
					{
					mESC_SEQ(); 

					}
					break;
				case 2 :
					// MvdXMLv1_1.g:218:23: ~ ( '\\\\' | '\\'' )
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
					break loop19;
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
			// MvdXMLv1_1.g:220:2: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
			// MvdXMLv1_1.g:220:4: ( ' ' | '\\t' | '\\n' | '\\r' )+
			{
			// MvdXMLv1_1.g:220:4: ( ' ' | '\\t' | '\\n' | '\\r' )+
			int cnt20=0;
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( ((LA20_0 >= '\t' && LA20_0 <= '\n')||LA20_0=='\r'||LA20_0==' ') ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// MvdXMLv1_1.g:
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
					if ( cnt20 >= 1 ) break loop20;
					EarlyExitException eee = new EarlyExitException(20, input);
					throw eee;
				}
				cnt20++;
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
		// MvdXMLv1_1.g:1:8: ( T__36 | T__37 | T__38 | T__39 | T__40 | VALUE | SIZE | TYPE | UNIQUE | EXISTS | AND | OR | XOR | NAND | NOR | NXOR | EQUAL | NOT_EQUAL | GREATER_THAN | GREATER_THAN_OR_EQUAL | LESS_THAN | LESS_THAN_OR_EQUAL | FALSE | TRUE | UNKNOWN | DIGIT | INT | HEX_DIGIT | LETTER | SIMPLEID | LPAREN | RPAREN | OCTAL_ESC | UNICODE_ESC | ESC_SEQ | STRING | WS )
		int alt21=37;
		alt21 = dfa21.predict(input);
		switch (alt21) {
			case 1 :
				// MvdXMLv1_1.g:1:10: T__36
				{
				mT__36(); 

				}
				break;
			case 2 :
				// MvdXMLv1_1.g:1:16: T__37
				{
				mT__37(); 

				}
				break;
			case 3 :
				// MvdXMLv1_1.g:1:22: T__38
				{
				mT__38(); 

				}
				break;
			case 4 :
				// MvdXMLv1_1.g:1:28: T__39
				{
				mT__39(); 

				}
				break;
			case 5 :
				// MvdXMLv1_1.g:1:34: T__40
				{
				mT__40(); 

				}
				break;
			case 6 :
				// MvdXMLv1_1.g:1:40: VALUE
				{
				mVALUE(); 

				}
				break;
			case 7 :
				// MvdXMLv1_1.g:1:46: SIZE
				{
				mSIZE(); 

				}
				break;
			case 8 :
				// MvdXMLv1_1.g:1:51: TYPE
				{
				mTYPE(); 

				}
				break;
			case 9 :
				// MvdXMLv1_1.g:1:56: UNIQUE
				{
				mUNIQUE(); 

				}
				break;
			case 10 :
				// MvdXMLv1_1.g:1:63: EXISTS
				{
				mEXISTS(); 

				}
				break;
			case 11 :
				// MvdXMLv1_1.g:1:70: AND
				{
				mAND(); 

				}
				break;
			case 12 :
				// MvdXMLv1_1.g:1:74: OR
				{
				mOR(); 

				}
				break;
			case 13 :
				// MvdXMLv1_1.g:1:77: XOR
				{
				mXOR(); 

				}
				break;
			case 14 :
				// MvdXMLv1_1.g:1:81: NAND
				{
				mNAND(); 

				}
				break;
			case 15 :
				// MvdXMLv1_1.g:1:86: NOR
				{
				mNOR(); 

				}
				break;
			case 16 :
				// MvdXMLv1_1.g:1:90: NXOR
				{
				mNXOR(); 

				}
				break;
			case 17 :
				// MvdXMLv1_1.g:1:95: EQUAL
				{
				mEQUAL(); 

				}
				break;
			case 18 :
				// MvdXMLv1_1.g:1:101: NOT_EQUAL
				{
				mNOT_EQUAL(); 

				}
				break;
			case 19 :
				// MvdXMLv1_1.g:1:111: GREATER_THAN
				{
				mGREATER_THAN(); 

				}
				break;
			case 20 :
				// MvdXMLv1_1.g:1:124: GREATER_THAN_OR_EQUAL
				{
				mGREATER_THAN_OR_EQUAL(); 

				}
				break;
			case 21 :
				// MvdXMLv1_1.g:1:146: LESS_THAN
				{
				mLESS_THAN(); 

				}
				break;
			case 22 :
				// MvdXMLv1_1.g:1:156: LESS_THAN_OR_EQUAL
				{
				mLESS_THAN_OR_EQUAL(); 

				}
				break;
			case 23 :
				// MvdXMLv1_1.g:1:175: FALSE
				{
				mFALSE(); 

				}
				break;
			case 24 :
				// MvdXMLv1_1.g:1:181: TRUE
				{
				mTRUE(); 

				}
				break;
			case 25 :
				// MvdXMLv1_1.g:1:186: UNKNOWN
				{
				mUNKNOWN(); 

				}
				break;
			case 26 :
				// MvdXMLv1_1.g:1:194: DIGIT
				{
				mDIGIT(); 

				}
				break;
			case 27 :
				// MvdXMLv1_1.g:1:200: INT
				{
				mINT(); 

				}
				break;
			case 28 :
				// MvdXMLv1_1.g:1:204: HEX_DIGIT
				{
				mHEX_DIGIT(); 

				}
				break;
			case 29 :
				// MvdXMLv1_1.g:1:214: LETTER
				{
				mLETTER(); 

				}
				break;
			case 30 :
				// MvdXMLv1_1.g:1:221: SIMPLEID
				{
				mSIMPLEID(); 

				}
				break;
			case 31 :
				// MvdXMLv1_1.g:1:230: LPAREN
				{
				mLPAREN(); 

				}
				break;
			case 32 :
				// MvdXMLv1_1.g:1:237: RPAREN
				{
				mRPAREN(); 

				}
				break;
			case 33 :
				// MvdXMLv1_1.g:1:244: OCTAL_ESC
				{
				mOCTAL_ESC(); 

				}
				break;
			case 34 :
				// MvdXMLv1_1.g:1:254: UNICODE_ESC
				{
				mUNICODE_ESC(); 

				}
				break;
			case 35 :
				// MvdXMLv1_1.g:1:266: ESC_SEQ
				{
				mESC_SEQ(); 

				}
				break;
			case 36 :
				// MvdXMLv1_1.g:1:274: STRING
				{
				mSTRING(); 

				}
				break;
			case 37 :
				// MvdXMLv1_1.g:1:281: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA21 dfa21 = new DFA21(this);
	static final String DFA21_eotS =
		"\4\uffff\1\43\1\46\1\uffff\2\56\1\uffff\2\46\1\uffff\4\46\2\uffff\1\74"+
		"\1\76\2\56\4\46\1\105\1\56\1\46\7\uffff\1\44\6\uffff\2\44\1\uffff\1\44"+
		"\3\14\10\44\4\uffff\6\44\2\uffff\2\136\2\uffff\1\141\3\11\2\142\1\44\1"+
		"\144\2\44\1\144\7\44\1\136\5\uffff\1\160\1\uffff\1\161\1\160\1\161\2\44"+
		"\2\164\2\44\4\uffff\2\170\1\uffff\2\44\2\uffff\2\44\1\uffff\2\177\2\uffff";
	static final String DFA21_eofS =
		"\u0080\uffff";
	static final String DFA21_minS =
		"\1\11\3\uffff\2\60\1\105\2\60\1\uffff\2\60\1\uffff\4\60\2\uffff\2\75\11"+
		"\60\2\uffff\1\42\4\uffff\1\147\6\uffff\1\104\1\144\1\uffff\1\144\3\60"+
		"\1\122\1\162\1\116\1\122\1\117\1\156\1\162\1\157\4\uffff\1\114\1\154\1"+
		"\125\1\165\1\113\1\153\2\uffff\3\60\1\uffff\6\60\1\104\1\60\1\122\1\144"+
		"\1\60\1\162\1\123\1\163\1\105\1\145\1\116\1\156\1\60\2\uffff\1\60\2\uffff"+
		"\1\60\1\uffff\3\60\1\105\1\145\2\60\1\117\1\157\1\uffff\1\60\2\uffff\2"+
		"\60\1\uffff\1\127\1\167\1\60\1\uffff\1\116\1\156\1\uffff\2\60\2\uffff";
	static final String DFA21_maxS =
		"\1\174\3\uffff\2\172\1\166\2\172\1\uffff\2\172\1\uffff\4\172\2\uffff\2"+
		"\75\6\172\1\71\2\172\2\uffff\1\165\4\uffff\1\147\6\uffff\1\104\1\144\1"+
		"\uffff\1\144\3\172\1\122\1\162\1\116\1\122\1\117\1\156\1\162\1\157\4\uffff"+
		"\1\114\1\154\1\125\1\165\1\113\1\153\2\uffff\2\67\1\146\1\uffff\6\172"+
		"\1\104\1\172\1\122\1\144\1\172\1\162\1\123\1\163\1\105\1\145\1\116\1\156"+
		"\1\67\2\uffff\1\146\2\uffff\1\172\1\uffff\3\172\1\105\1\145\2\172\1\117"+
		"\1\157\1\uffff\1\146\2\uffff\2\172\1\uffff\1\127\1\167\1\146\1\uffff\1"+
		"\116\1\156\1\uffff\2\172\2\uffff";
	static final String DFA21_acceptS =
		"\1\uffff\1\1\1\2\1\3\5\uffff\1\13\2\uffff\1\14\4\uffff\1\21\1\22\13\uffff"+
		"\1\37\1\40\1\uffff\1\44\1\45\1\4\1\36\1\uffff\1\35\1\6\1\7\1\10\1\11\1"+
		"\12\2\uffff\1\34\14\uffff\1\24\1\23\1\26\1\25\6\uffff\1\32\1\33\3\uffff"+
		"\1\43\23\uffff\2\41\1\uffff\1\5\1\15\1\uffff\1\17\11\uffff\1\41\1\uffff"+
		"\1\16\1\20\2\uffff\1\30\3\uffff\1\27\2\uffff\1\42\2\uffff\1\42\1\31";
	static final String DFA21_specialS =
		"\u0080\uffff}>";
	static final String[] DFA21_transitionS = {
			"\2\42\2\uffff\1\42\22\uffff\1\42\1\22\4\uffff\1\11\1\41\1\36\1\37\1\uffff"+
			"\1\1\1\uffff\1\2\1\3\1\uffff\12\33\2\uffff\1\24\1\21\1\23\2\uffff\1\7"+
			"\4\34\1\25\7\35\1\17\1\12\4\35\1\27\1\31\2\35\1\15\2\35\1\6\1\40\4\uffff"+
			"\1\10\3\34\1\4\1\26\7\35\1\20\1\13\2\35\1\5\1\35\1\30\1\32\2\35\1\16"+
			"\2\35\1\uffff\1\14",
			"",
			"",
			"",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\45\25\44",
			"\1\53\15\uffff\1\50\1\51\1\52\1\47\16\uffff\1\53\15\uffff\1\50\1\51"+
			"\1\52\1\47",
			"\12\44\7\uffff\15\44\1\54\14\44\4\uffff\1\44\1\uffff\15\44\1\55\14\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\15\44\1\57\14\44",
			"",
			"\12\44\7\uffff\21\44\1\60\10\44\4\uffff\1\44\1\uffff\21\44\1\61\10\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\21\44\1\62\10\44",
			"",
			"\12\44\7\uffff\16\44\1\63\13\44\4\uffff\1\44\1\uffff\32\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\16\44\1\64\13\44",
			"\12\44\7\uffff\1\65\15\44\1\66\10\44\1\67\2\44\4\uffff\1\44\1\uffff"+
			"\32\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\1\70\15\44\1\71\10\44\1\72"+
			"\2\44",
			"",
			"",
			"\1\73",
			"\1\75",
			"\12\44\7\uffff\1\77\31\44\4\uffff\1\44\1\uffff\32\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\1\100\31\44",
			"\12\44\7\uffff\21\44\1\101\10\44\4\uffff\1\44\1\uffff\32\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\21\44\1\102\10\44",
			"\12\44\7\uffff\15\44\1\103\14\44\4\uffff\1\44\1\uffff\32\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\15\44\1\104\14\44",
			"\12\106",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"",
			"",
			"\1\112\4\uffff\1\112\10\uffff\4\107\4\110\44\uffff\1\112\5\uffff\1\112"+
			"\3\uffff\1\112\7\uffff\1\112\3\uffff\1\112\1\uffff\1\112\1\111",
			"",
			"",
			"",
			"",
			"\1\113",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\114",
			"\1\115",
			"",
			"\1\116",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\117",
			"\1\120",
			"\1\121",
			"\1\122",
			"\1\123",
			"\1\124",
			"\1\125",
			"\1\126",
			"",
			"",
			"",
			"",
			"\1\127",
			"\1\130",
			"\1\131",
			"\1\132",
			"\1\133",
			"\1\134",
			"",
			"",
			"\10\135",
			"\10\137",
			"\12\140\7\uffff\6\140\32\uffff\6\140",
			"",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\143",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\145",
			"\1\146",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\147",
			"\1\150",
			"\1\151",
			"\1\152",
			"\1\153",
			"\1\154",
			"\1\155",
			"\10\156",
			"",
			"",
			"\12\157\7\uffff\6\157\32\uffff\6\157",
			"",
			"",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\162",
			"\1\163",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\165",
			"\1\166",
			"",
			"\12\167\7\uffff\6\167\32\uffff\6\167",
			"",
			"",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"",
			"\1\171",
			"\1\172",
			"\12\173\7\uffff\6\173\32\uffff\6\173",
			"",
			"\1\174",
			"\1\175",
			"",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"",
			""
	};

	static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
	static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
	static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
	static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
	static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
	static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
	static final short[][] DFA21_transition;

	static {
		int numStates = DFA21_transitionS.length;
		DFA21_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
		}
	}

	protected class DFA21 extends DFA {

		public DFA21(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 21;
			this.eot = DFA21_eot;
			this.eof = DFA21_eof;
			this.min = DFA21_min;
			this.max = DFA21_max;
			this.accept = DFA21_accept;
			this.special = DFA21_special;
			this.transition = DFA21_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__36 | T__37 | T__38 | T__39 | T__40 | VALUE | SIZE | TYPE | UNIQUE | EXISTS | AND | OR | XOR | NAND | NOR | NXOR | EQUAL | NOT_EQUAL | GREATER_THAN | GREATER_THAN_OR_EQUAL | LESS_THAN | LESS_THAN_OR_EQUAL | FALSE | TRUE | UNKNOWN | DIGIT | INT | HEX_DIGIT | LETTER | SIMPLEID | LPAREN | RPAREN | OCTAL_ESC | UNICODE_ESC | ESC_SEQ | STRING | WS );";
		}
	}

}
