// $ANTLR 3.5.2 mvdXMLv1_1.g 2020-04-18 21:37:21

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class mvdXMLv1_1Parser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "DIGIT", "EQUAL", "ESC_SEQ", 
		"FALSE", "GREATER_THAN", "GREATER_THAN_OR_EQUAL", "HEX_DIGIT", "INT", 
		"LESS_THAN", "LESS_THAN_OR_EQUAL", "LETTER", "LPAREN", "NOT_EQUAL", "OCTAL_ESC", 
		"OR", "RPAREN", "SIMPLEID", "STRING", "Size", "TRUE", "Type", "UNICODE_ESC", 
		"UNKNOWN", "Unique", "Value", "WS", "XOR", "'+'", "'-'", "'.'", "'e'", 
		"'reg'"
	};
	public static final int EOF=-1;
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
	public static final int Size=23;
	public static final int TRUE=24;
	public static final int Type=25;
	public static final int UNICODE_ESC=26;
	public static final int UNKNOWN=27;
	public static final int Unique=28;
	public static final int Value=29;
	public static final int WS=30;
	public static final int XOR=31;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public mvdXMLv1_1Parser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public mvdXMLv1_1Parser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return mvdXMLv1_1Parser.tokenNames; }
	@Override public String getGrammarFileName() { return "mvdXMLv1_1.g"; }



	// $ANTLR start "expression"
	// mvdXMLv1_1.g:6:1: expression : boolean_expression ;
	public final void expression() throws RecognitionException {
		try {
			// mvdXMLv1_1.g:7:2: ( boolean_expression )
			// mvdXMLv1_1.g:7:4: boolean_expression
			{
			pushFollow(FOLLOW_boolean_expression_in_expression14);
			boolean_expression();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "expression"



	// $ANTLR start "boolean_expression"
	// mvdXMLv1_1.g:8:1: boolean_expression : boolean_term ( logical_interconnection boolean_term )* ;
	public final void boolean_expression() throws RecognitionException {
		try {
			// mvdXMLv1_1.g:9:6: ( boolean_term ( logical_interconnection boolean_term )* )
			// mvdXMLv1_1.g:9:8: boolean_term ( logical_interconnection boolean_term )*
			{
			pushFollow(FOLLOW_boolean_term_in_boolean_expression27);
			boolean_term();
			state._fsp--;

			// mvdXMLv1_1.g:9:21: ( logical_interconnection boolean_term )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==AND||LA1_0==OR||LA1_0==XOR) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// mvdXMLv1_1.g:9:22: logical_interconnection boolean_term
					{
					pushFollow(FOLLOW_logical_interconnection_in_boolean_expression30);
					logical_interconnection();
					state._fsp--;

					pushFollow(FOLLOW_boolean_term_in_boolean_expression32);
					boolean_term();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "boolean_expression"



	// $ANTLR start "boolean_term"
	// mvdXMLv1_1.g:10:1: boolean_term : ( ( ( parameter ( metric )? | metric ) operator ( value | parameter ( metric )? ) ) | ( LPAREN boolean_expression RPAREN ) );
	public final void boolean_term() throws RecognitionException {
		try {
			// mvdXMLv1_1.g:11:2: ( ( ( parameter ( metric )? | metric ) operator ( value | parameter ( metric )? ) ) | ( LPAREN boolean_expression RPAREN ) )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==SIMPLEID||LA6_0==Size||LA6_0==Type||(LA6_0 >= Unique && LA6_0 <= Value)) ) {
				alt6=1;
			}
			else if ( (LA6_0==LPAREN) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// mvdXMLv1_1.g:11:4: ( ( parameter ( metric )? | metric ) operator ( value | parameter ( metric )? ) )
					{
					// mvdXMLv1_1.g:11:4: ( ( parameter ( metric )? | metric ) operator ( value | parameter ( metric )? ) )
					// mvdXMLv1_1.g:11:5: ( parameter ( metric )? | metric ) operator ( value | parameter ( metric )? )
					{
					// mvdXMLv1_1.g:11:5: ( parameter ( metric )? | metric )
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==SIMPLEID) ) {
						alt3=1;
					}
					else if ( (LA3_0==Size||LA3_0==Type||(LA3_0 >= Unique && LA3_0 <= Value)) ) {
						alt3=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 3, 0, input);
						throw nvae;
					}

					switch (alt3) {
						case 1 :
							// mvdXMLv1_1.g:11:7: parameter ( metric )?
							{
							pushFollow(FOLLOW_parameter_in_boolean_term47);
							parameter();
							state._fsp--;

							// mvdXMLv1_1.g:11:17: ( metric )?
							int alt2=2;
							int LA2_0 = input.LA(1);
							if ( (LA2_0==Size||LA2_0==Type||(LA2_0 >= Unique && LA2_0 <= Value)) ) {
								alt2=1;
							}
							switch (alt2) {
								case 1 :
									// mvdXMLv1_1.g:11:19: metric
									{
									pushFollow(FOLLOW_metric_in_boolean_term51);
									metric();
									state._fsp--;

									}
									break;

							}

							}
							break;
						case 2 :
							// mvdXMLv1_1.g:11:31: metric
							{
							pushFollow(FOLLOW_metric_in_boolean_term58);
							metric();
							state._fsp--;

							}
							break;

					}

					pushFollow(FOLLOW_operator_in_boolean_term62);
					operator();
					state._fsp--;

					// mvdXMLv1_1.g:11:49: ( value | parameter ( metric )? )
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==DIGIT||LA5_0==FALSE||LA5_0==INT||LA5_0==STRING||LA5_0==TRUE||LA5_0==UNKNOWN||(LA5_0 >= 32 && LA5_0 <= 33)||LA5_0==36) ) {
						alt5=1;
					}
					else if ( (LA5_0==SIMPLEID) ) {
						alt5=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 5, 0, input);
						throw nvae;
					}

					switch (alt5) {
						case 1 :
							// mvdXMLv1_1.g:11:51: value
							{
							pushFollow(FOLLOW_value_in_boolean_term66);
							value();
							state._fsp--;

							}
							break;
						case 2 :
							// mvdXMLv1_1.g:11:59: parameter ( metric )?
							{
							pushFollow(FOLLOW_parameter_in_boolean_term70);
							parameter();
							state._fsp--;

							// mvdXMLv1_1.g:11:69: ( metric )?
							int alt4=2;
							int LA4_0 = input.LA(1);
							if ( (LA4_0==Size||LA4_0==Type||(LA4_0 >= Unique && LA4_0 <= Value)) ) {
								alt4=1;
							}
							switch (alt4) {
								case 1 :
									// mvdXMLv1_1.g:11:71: metric
									{
									pushFollow(FOLLOW_metric_in_boolean_term74);
									metric();
									state._fsp--;

									}
									break;

							}

							}
							break;

					}

					}

					}
					break;
				case 2 :
					// mvdXMLv1_1.g:11:89: ( LPAREN boolean_expression RPAREN )
					{
					// mvdXMLv1_1.g:11:89: ( LPAREN boolean_expression RPAREN )
					// mvdXMLv1_1.g:11:91: LPAREN boolean_expression RPAREN
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_boolean_term89); 
					pushFollow(FOLLOW_boolean_expression_in_boolean_term91);
					boolean_expression();
					state._fsp--;

					match(input,RPAREN,FOLLOW_RPAREN_in_boolean_term93); 
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "boolean_term"



	// $ANTLR start "parameter"
	// mvdXMLv1_1.g:12:1: parameter : SIMPLEID ;
	public final void parameter() throws RecognitionException {
		try {
			// mvdXMLv1_1.g:13:2: ( SIMPLEID )
			// mvdXMLv1_1.g:13:4: SIMPLEID
			{
			match(input,SIMPLEID,FOLLOW_SIMPLEID_in_parameter104); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "parameter"



	// $ANTLR start "metric"
	// mvdXMLv1_1.g:14:1: metric : ( Value | Size | Type | Unique );
	public final void metric() throws RecognitionException {
		try {
			// mvdXMLv1_1.g:15:2: ( Value | Size | Type | Unique )
			// mvdXMLv1_1.g:
			{
			if ( input.LA(1)==Size||input.LA(1)==Type||(input.LA(1) >= Unique && input.LA(1) <= Value) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "metric"



	// $ANTLR start "logical_interconnection"
	// mvdXMLv1_1.g:16:1: logical_interconnection : ( AND | OR | XOR );
	public final void logical_interconnection() throws RecognitionException {
		try {
			// mvdXMLv1_1.g:17:2: ( AND | OR | XOR )
			// mvdXMLv1_1.g:
			{
			if ( input.LA(1)==AND||input.LA(1)==OR||input.LA(1)==XOR ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "logical_interconnection"



	// $ANTLR start "operator"
	// mvdXMLv1_1.g:18:1: operator : ( EQUAL | NOT_EQUAL | GREATER_THAN | GREATER_THAN_OR_EQUAL | LESS_THAN | LESS_THAN_OR_EQUAL );
	public final void operator() throws RecognitionException {
		try {
			// mvdXMLv1_1.g:19:2: ( EQUAL | NOT_EQUAL | GREATER_THAN | GREATER_THAN_OR_EQUAL | LESS_THAN | LESS_THAN_OR_EQUAL )
			// mvdXMLv1_1.g:
			{
			if ( input.LA(1)==EQUAL||(input.LA(1) >= GREATER_THAN && input.LA(1) <= GREATER_THAN_OR_EQUAL)||(input.LA(1) >= LESS_THAN && input.LA(1) <= LESS_THAN_OR_EQUAL)||input.LA(1)==NOT_EQUAL ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "operator"



	// $ANTLR start "value"
	// mvdXMLv1_1.g:20:1: value : ( logical_literal | real_literal | string_literal | regular_expression );
	public final void value() throws RecognitionException {
		try {
			// mvdXMLv1_1.g:21:2: ( logical_literal | real_literal | string_literal | regular_expression )
			int alt7=4;
			switch ( input.LA(1) ) {
			case FALSE:
			case TRUE:
			case UNKNOWN:
				{
				alt7=1;
				}
				break;
			case DIGIT:
			case INT:
			case 32:
			case 33:
				{
				alt7=2;
				}
				break;
			case STRING:
				{
				alt7=3;
				}
				break;
			case 36:
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
					// mvdXMLv1_1.g:21:4: logical_literal
					{
					pushFollow(FOLLOW_logical_literal_in_value184);
					logical_literal();
					state._fsp--;

					}
					break;
				case 2 :
					// mvdXMLv1_1.g:21:22: real_literal
					{
					pushFollow(FOLLOW_real_literal_in_value188);
					real_literal();
					state._fsp--;

					}
					break;
				case 3 :
					// mvdXMLv1_1.g:21:37: string_literal
					{
					pushFollow(FOLLOW_string_literal_in_value192);
					string_literal();
					state._fsp--;

					}
					break;
				case 4 :
					// mvdXMLv1_1.g:21:54: regular_expression
					{
					pushFollow(FOLLOW_regular_expression_in_value196);
					regular_expression();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "value"



	// $ANTLR start "logical_literal"
	// mvdXMLv1_1.g:22:1: logical_literal : ( FALSE | TRUE | UNKNOWN );
	public final void logical_literal() throws RecognitionException {
		try {
			// mvdXMLv1_1.g:23:2: ( FALSE | TRUE | UNKNOWN )
			// mvdXMLv1_1.g:
			{
			if ( input.LA(1)==FALSE||input.LA(1)==TRUE||input.LA(1)==UNKNOWN ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "logical_literal"



	// $ANTLR start "real_literal"
	// mvdXMLv1_1.g:24:1: real_literal : ( sign )? ( DIGIT | INT ) ( '.' )? ( ( DIGIT | INT ) )? ( 'e' ( sign )? ( DIGIT | INT ) )? ;
	public final void real_literal() throws RecognitionException {
		try {
			// mvdXMLv1_1.g:25:2: ( ( sign )? ( DIGIT | INT ) ( '.' )? ( ( DIGIT | INT ) )? ( 'e' ( sign )? ( DIGIT | INT ) )? )
			// mvdXMLv1_1.g:25:4: ( sign )? ( DIGIT | INT ) ( '.' )? ( ( DIGIT | INT ) )? ( 'e' ( sign )? ( DIGIT | INT ) )?
			{
			// mvdXMLv1_1.g:25:4: ( sign )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( ((LA8_0 >= 32 && LA8_0 <= 33)) ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// mvdXMLv1_1.g:25:5: sign
					{
					pushFollow(FOLLOW_sign_in_real_literal225);
					sign();
					state._fsp--;

					}
					break;

			}

			if ( input.LA(1)==DIGIT||input.LA(1)==INT ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			// mvdXMLv1_1.g:25:28: ( '.' )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==34) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// mvdXMLv1_1.g:25:29: '.'
					{
					match(input,34,FOLLOW_34_in_real_literal240); 
					}
					break;

			}

			// mvdXMLv1_1.g:25:35: ( ( DIGIT | INT ) )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==DIGIT||LA10_0==INT) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// mvdXMLv1_1.g:
					{
					if ( input.LA(1)==DIGIT||input.LA(1)==INT ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}

			// mvdXMLv1_1.g:25:56: ( 'e' ( sign )? ( DIGIT | INT ) )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==35) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// mvdXMLv1_1.g:25:58: 'e' ( sign )? ( DIGIT | INT )
					{
					match(input,35,FOLLOW_35_in_real_literal261); 
					// mvdXMLv1_1.g:25:62: ( sign )?
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( ((LA11_0 >= 32 && LA11_0 <= 33)) ) {
						alt11=1;
					}
					switch (alt11) {
						case 1 :
							// mvdXMLv1_1.g:25:63: sign
							{
							pushFollow(FOLLOW_sign_in_real_literal264);
							sign();
							state._fsp--;

							}
							break;

					}

					if ( input.LA(1)==DIGIT||input.LA(1)==INT ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "real_literal"



	// $ANTLR start "string_literal"
	// mvdXMLv1_1.g:26:1: string_literal : STRING ;
	public final void string_literal() throws RecognitionException {
		try {
			// mvdXMLv1_1.g:27:2: ( STRING )
			// mvdXMLv1_1.g:27:4: STRING
			{
			match(input,STRING,FOLLOW_STRING_in_string_literal288); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "string_literal"



	// $ANTLR start "regular_expression"
	// mvdXMLv1_1.g:28:1: regular_expression : 'reg' STRING ;
	public final void regular_expression() throws RecognitionException {
		try {
			// mvdXMLv1_1.g:29:2: ( 'reg' STRING )
			// mvdXMLv1_1.g:29:4: 'reg' STRING
			{
			match(input,36,FOLLOW_36_in_regular_expression297); 
			match(input,STRING,FOLLOW_STRING_in_regular_expression299); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "regular_expression"



	// $ANTLR start "sign"
	// mvdXMLv1_1.g:30:1: sign : ( '+' | '-' );
	public final void sign() throws RecognitionException {
		try {
			// mvdXMLv1_1.g:31:2: ( '+' | '-' )
			// mvdXMLv1_1.g:
			{
			if ( (input.LA(1) >= 32 && input.LA(1) <= 33) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "sign"

	// Delegated rules



	public static final BitSet FOLLOW_boolean_expression_in_expression14 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_boolean_term_in_boolean_expression27 = new BitSet(new long[]{0x0000000080080012L});
	public static final BitSet FOLLOW_logical_interconnection_in_boolean_expression30 = new BitSet(new long[]{0x0000000032A10000L});
	public static final BitSet FOLLOW_boolean_term_in_boolean_expression32 = new BitSet(new long[]{0x0000000080080012L});
	public static final BitSet FOLLOW_parameter_in_boolean_term47 = new BitSet(new long[]{0x0000000032826640L});
	public static final BitSet FOLLOW_metric_in_boolean_term51 = new BitSet(new long[]{0x0000000000026640L});
	public static final BitSet FOLLOW_metric_in_boolean_term58 = new BitSet(new long[]{0x0000000000026640L});
	public static final BitSet FOLLOW_operator_in_boolean_term62 = new BitSet(new long[]{0x0000001309601120L});
	public static final BitSet FOLLOW_value_in_boolean_term66 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_parameter_in_boolean_term70 = new BitSet(new long[]{0x0000000032800002L});
	public static final BitSet FOLLOW_metric_in_boolean_term74 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_boolean_term89 = new BitSet(new long[]{0x0000000032A10000L});
	public static final BitSet FOLLOW_boolean_expression_in_boolean_term91 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_RPAREN_in_boolean_term93 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SIMPLEID_in_parameter104 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_logical_literal_in_value184 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_real_literal_in_value188 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_string_literal_in_value192 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_regular_expression_in_value196 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sign_in_real_literal225 = new BitSet(new long[]{0x0000000000001020L});
	public static final BitSet FOLLOW_set_in_real_literal229 = new BitSet(new long[]{0x0000000C00001022L});
	public static final BitSet FOLLOW_34_in_real_literal240 = new BitSet(new long[]{0x0000000800001022L});
	public static final BitSet FOLLOW_35_in_real_literal261 = new BitSet(new long[]{0x0000000300001020L});
	public static final BitSet FOLLOW_sign_in_real_literal264 = new BitSet(new long[]{0x0000000000001020L});
	public static final BitSet FOLLOW_set_in_real_literal268 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_string_literal288 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_36_in_regular_expression297 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_STRING_in_regular_expression299 = new BitSet(new long[]{0x0000000000000002L});
}
