// $ANTLR 3.5.2 MvdXMLv1_1.g 2020-09-24 15:57:55

package generated.mvdxml1dot1.rule_operators;
import java.util.HashMap;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

import de.rwth_aachen.dc.mvd.mvdxml1dot1.AbstractRule;
import nl.tue.ddss.mvdxml1dot1.ifc_check.IfcHashMapBuilder.ObjectToValue;
import nl.tue.ddss.mvdxml1dot1.ifc_check.Metric;
import nl.tue.ddss.mvdxml1dot1.ifc_check.Parameter;
import nl.tue.ddss.mvdxml1dot1.rule_operators.AndOperator;
import nl.tue.ddss.mvdxml1dot1.rule_operators.EqualOperator;
import nl.tue.ddss.mvdxml1dot1.rule_operators.GreaterEqualOperator;
import nl.tue.ddss.mvdxml1dot1.rule_operators.GreaterOperator;
import nl.tue.ddss.mvdxml1dot1.rule_operators.InEqualOperator;
import nl.tue.ddss.mvdxml1dot1.rule_operators.LessEqualOperator;
import nl.tue.ddss.mvdxml1dot1.rule_operators.LessOperator;
import nl.tue.ddss.mvdxml1dot1.rule_operators.OrOperator;
import nl.tue.ddss.mvdxml1dot1.rule_operators.XorOperator;
import nl.tue.ddss.mvdxml1dot1.rule_operators.NandOperator;
import nl.tue.ddss.mvdxml1dot1.rule_operators.NorOperator;
import nl.tue.ddss.mvdxml1dot1.rule_operators.NxorOperator;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class MvdXMLv1_1Parser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "DIGIT", "EQUAL", "ESC_SEQ", 
		"EXISTS", "FALSE", "GREATER_THAN", "GREATER_THAN_OR_EQUAL", "HEX_DIGIT", 
		"INT", "LESS_THAN", "LESS_THAN_OR_EQUAL", "LETTER", "LPAREN", "NAND", 
		"NOR", "NOT_EQUAL", "NXOR", "OCTAL_ESC", "OR", "RPAREN", "SIMPLEID", "SIZE", 
		"STRING", "TRUE", "TYPE", "UNICODE_ESC", "UNIQUE", "UNKNOWN", "VALUE", 
		"WS", "XOR", "'+'", "'-'", "'.'", "'e'", "'reg'"
	};
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public MvdXMLv1_1Parser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public MvdXMLv1_1Parser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return MvdXMLv1_1Parser.tokenNames; }
	@Override public String getGrammarFileName() { return "MvdXMLv1_1.g"; }


	HashMap <AbstractRule,ObjectToValue> hashMap;
	public MvdXMLv1_1Parser(TokenStream input,HashMap <AbstractRule,ObjectToValue> hashMap) {
	        this(input, new RecognizerSharedState());
	        this.hashMap=hashMap;
	    }



	// $ANTLR start "expression"
	// MvdXMLv1_1.g:50:1: expression returns [Boolean expressionReturns] : boolean_expression ;
	public final Boolean expression() throws RecognitionException {
		Boolean expressionReturns = null;


		Boolean boolean_expression1 =null;

		try {
			// MvdXMLv1_1.g:51:2: ( boolean_expression )
			// MvdXMLv1_1.g:51:4: boolean_expression
			{
			pushFollow(FOLLOW_boolean_expression_in_expression37);
			boolean_expression1=boolean_expression();
			state._fsp--;

			expressionReturns =boolean_expression1;
				
			}

		}
		catch (RecognitionException re) {

				
		}

		finally {
			// do for sure before leaving
		}
		return expressionReturns;
	}
	// $ANTLR end "expression"



	// $ANTLR start "boolean_expression"
	// MvdXMLv1_1.g:56:1: boolean_expression returns [Boolean result] : left= boolean_term ( AND right= boolean_expression )? ( OR right= boolean_expression )? ( XOR right= boolean_expression )? ( NAND right= boolean_expression )? ( NOR right= boolean_expression )? ( NXOR right= boolean_expression )? ;
	public final Boolean boolean_expression() throws RecognitionException {
		Boolean result = null;


		Boolean left =null;
		Boolean right =null;

		try {
			// MvdXMLv1_1.g:57:6: (left= boolean_term ( AND right= boolean_expression )? ( OR right= boolean_expression )? ( XOR right= boolean_expression )? ( NAND right= boolean_expression )? ( NOR right= boolean_expression )? ( NXOR right= boolean_expression )? )
			// MvdXMLv1_1.g:57:8: left= boolean_term ( AND right= boolean_expression )? ( OR right= boolean_expression )? ( XOR right= boolean_expression )? ( NAND right= boolean_expression )? ( NOR right= boolean_expression )? ( NXOR right= boolean_expression )?
			{
			pushFollow(FOLLOW_boolean_term_in_boolean_expression64);
			left=boolean_term();
			state._fsp--;

			result =left;
			// MvdXMLv1_1.g:57:41: ( AND right= boolean_expression )?
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==AND) ) {
				alt1=1;
			}
			switch (alt1) {
				case 1 :
					// MvdXMLv1_1.g:57:42: AND right= boolean_expression
					{
					match(input,AND,FOLLOW_AND_in_boolean_expression68); 
					pushFollow(FOLLOW_boolean_expression_in_boolean_expression72);
					right=boolean_expression();
					state._fsp--;


					    	AndOperator andOperator=new AndOperator(left,right);
					    	result =andOperator.getResult();
					    	
					}
					break;

			}

			// MvdXMLv1_1.g:62:6: ( OR right= boolean_expression )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==OR) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// MvdXMLv1_1.g:62:7: OR right= boolean_expression
					{
					match(input,OR,FOLLOW_OR_in_boolean_expression91); 
					pushFollow(FOLLOW_boolean_expression_in_boolean_expression95);
					right=boolean_expression();
					state._fsp--;


					    	OrOperator orOperator=new OrOperator(left,right);
					      result =orOperator.getResult();
					    	
					}
					break;

			}

			// MvdXMLv1_1.g:67:6: ( XOR right= boolean_expression )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==XOR) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// MvdXMLv1_1.g:67:7: XOR right= boolean_expression
					{
					match(input,XOR,FOLLOW_XOR_in_boolean_expression114); 
					pushFollow(FOLLOW_boolean_expression_in_boolean_expression118);
					right=boolean_expression();
					state._fsp--;


					    	XorOperator xorOperator=new XorOperator(left,right);
					    	result =xorOperator.getResult();
					    	
					}
					break;

			}

			// MvdXMLv1_1.g:72:6: ( NAND right= boolean_expression )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==NAND) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// MvdXMLv1_1.g:72:7: NAND right= boolean_expression
					{
					match(input,NAND,FOLLOW_NAND_in_boolean_expression137); 
					pushFollow(FOLLOW_boolean_expression_in_boolean_expression141);
					right=boolean_expression();
					state._fsp--;


					    	NandOperator nandOperator=new NandOperator(left,right);
					    	result =nandOperator.getResult();
					    	
					}
					break;

			}

			// MvdXMLv1_1.g:77:6: ( NOR right= boolean_expression )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==NOR) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// MvdXMLv1_1.g:77:7: NOR right= boolean_expression
					{
					match(input,NOR,FOLLOW_NOR_in_boolean_expression160); 
					pushFollow(FOLLOW_boolean_expression_in_boolean_expression164);
					right=boolean_expression();
					state._fsp--;


					    	NorOperator norOperator=new NorOperator(left,right);
					      result =norOperator.getResult();
					    	
					}
					break;

			}

			// MvdXMLv1_1.g:82:6: ( NXOR right= boolean_expression )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==NXOR) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// MvdXMLv1_1.g:82:7: NXOR right= boolean_expression
					{
					match(input,NXOR,FOLLOW_NXOR_in_boolean_expression183); 
					pushFollow(FOLLOW_boolean_expression_in_boolean_expression187);
					right=boolean_expression();
					state._fsp--;


					    	NxorOperator nxorOperator=new NxorOperator(left,right);
					    	result =nxorOperator.getResult();
					    	
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
		return result;
	}
	// $ANTLR end "boolean_expression"



	// $ANTLR start "boolean_term"
	// MvdXMLv1_1.g:90:1: boolean_term returns [Boolean boolTermReturns] : ( ( (leftOperand= parameter (leftOperand= metric[leftOperand] )? ) op= operator (rightOperand= value |rightOperand= parameter (rightOperand= metric[rightOperand] )? ) ) | ( LPAREN valueReturns= boolean_expression RPAREN ) );
	public final Boolean boolean_term() throws RecognitionException {
		Boolean boolTermReturns = null;


		Object leftOperand =null;
		String op =null;
		Object rightOperand =null;
		Boolean valueReturns =null;

		try {
			// MvdXMLv1_1.g:91:2: ( ( (leftOperand= parameter (leftOperand= metric[leftOperand] )? ) op= operator (rightOperand= value |rightOperand= parameter (rightOperand= metric[rightOperand] )? ) ) | ( LPAREN valueReturns= boolean_expression RPAREN ) )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==SIMPLEID) ) {
				alt10=1;
			}
			else if ( (LA10_0==LPAREN) ) {
				alt10=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// MvdXMLv1_1.g:91:4: ( (leftOperand= parameter (leftOperand= metric[leftOperand] )? ) op= operator (rightOperand= value |rightOperand= parameter (rightOperand= metric[rightOperand] )? ) )
					{
					// MvdXMLv1_1.g:91:4: ( (leftOperand= parameter (leftOperand= metric[leftOperand] )? ) op= operator (rightOperand= value |rightOperand= parameter (rightOperand= metric[rightOperand] )? ) )
					// MvdXMLv1_1.g:91:5: (leftOperand= parameter (leftOperand= metric[leftOperand] )? ) op= operator (rightOperand= value |rightOperand= parameter (rightOperand= metric[rightOperand] )? )
					{
					// MvdXMLv1_1.g:91:5: (leftOperand= parameter (leftOperand= metric[leftOperand] )? )
					// MvdXMLv1_1.g:91:7: leftOperand= parameter (leftOperand= metric[leftOperand] )?
					{
					pushFollow(FOLLOW_parameter_in_boolean_term235);
					leftOperand=parameter();
					state._fsp--;

					// MvdXMLv1_1.g:91:29: (leftOperand= metric[leftOperand] )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0==EXISTS||LA7_0==SIZE||LA7_0==TYPE||LA7_0==UNIQUE||LA7_0==VALUE) ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// MvdXMLv1_1.g:91:31: leftOperand= metric[leftOperand]
							{
							pushFollow(FOLLOW_metric_in_boolean_term241);
							leftOperand=metric(leftOperand);
							state._fsp--;

							}
							break;

					}

					}

					pushFollow(FOLLOW_operator_in_boolean_term250);
					op=operator();
					state._fsp--;

					// MvdXMLv1_1.g:91:79: (rightOperand= value |rightOperand= parameter (rightOperand= metric[rightOperand] )? )
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( (LA9_0==DIGIT||LA9_0==FALSE||LA9_0==INT||(LA9_0 >= STRING && LA9_0 <= TRUE)||LA9_0==UNKNOWN||(LA9_0 >= 36 && LA9_0 <= 37)||LA9_0==40) ) {
						alt9=1;
					}
					else if ( (LA9_0==SIMPLEID) ) {
						alt9=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 9, 0, input);
						throw nvae;
					}

					switch (alt9) {
						case 1 :
							// MvdXMLv1_1.g:91:81: rightOperand= value
							{
							pushFollow(FOLLOW_value_in_boolean_term256);
							rightOperand=value();
							state._fsp--;

							}
							break;
						case 2 :
							// MvdXMLv1_1.g:91:102: rightOperand= parameter (rightOperand= metric[rightOperand] )?
							{
							pushFollow(FOLLOW_parameter_in_boolean_term262);
							rightOperand=parameter();
							state._fsp--;

							// MvdXMLv1_1.g:91:125: (rightOperand= metric[rightOperand] )?
							int alt8=2;
							int LA8_0 = input.LA(1);
							if ( (LA8_0==EXISTS||LA8_0==SIZE||LA8_0==TYPE||LA8_0==UNIQUE||LA8_0==VALUE) ) {
								alt8=1;
							}
							switch (alt8) {
								case 1 :
									// MvdXMLv1_1.g:91:127: rightOperand= metric[rightOperand]
									{
									pushFollow(FOLLOW_metric_in_boolean_term268);
									rightOperand=metric(rightOperand);
									state._fsp--;

									}
									break;

							}

							}
							break;

					}

					}

					if (op.equals("=")){
						 EqualOperator equalOperator=new EqualOperator(leftOperand,rightOperand);
						 boolTermReturns =equalOperator.getResult();
					   }if (op.equals(">")){
					   GreaterOperator greaterOperator=new GreaterOperator(leftOperand,rightOperand);
					   boolTermReturns =greaterOperator.getResult();
					   }if (op.equals("<")){
					   LessOperator lessOperator=new LessOperator(leftOperand,rightOperand);
					   boolTermReturns =lessOperator.getResult();
					   }if (op.equals(">=")){
					   GreaterEqualOperator greaterEqualOperator=new GreaterEqualOperator(leftOperand,rightOperand);
					   boolTermReturns =greaterEqualOperator.getResult();
					   }if (op.equals("<=")){
					   LessEqualOperator lessEqualOperator=new LessEqualOperator(leftOperand,rightOperand);
					   boolTermReturns =lessEqualOperator.getResult();
					   }if (op.equals("!=")){
					   InEqualOperator inEqualOperator=new InEqualOperator(leftOperand,rightOperand);
					   boolTermReturns =inEqualOperator.getResult();
					   }  

					}
					break;
				case 2 :
					// MvdXMLv1_1.g:111:5: ( LPAREN valueReturns= boolean_expression RPAREN )
					{
					// MvdXMLv1_1.g:111:5: ( LPAREN valueReturns= boolean_expression RPAREN )
					// MvdXMLv1_1.g:111:7: LPAREN valueReturns= boolean_expression RPAREN
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_boolean_term286); 
					pushFollow(FOLLOW_boolean_expression_in_boolean_term290);
					valueReturns=boolean_expression();
					state._fsp--;

					match(input,RPAREN,FOLLOW_RPAREN_in_boolean_term292); 
					}

					boolTermReturns =valueReturns;
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
		return boolTermReturns;
	}
	// $ANTLR end "boolean_term"



	// $ANTLR start "parameter"
	// MvdXMLv1_1.g:114:1: parameter returns [Object paraReturns] : SIMPLEID ;
	public final Object parameter() throws RecognitionException {
		Object paraReturns = null;


		Token SIMPLEID2=null;

		try {
			// MvdXMLv1_1.g:115:2: ( SIMPLEID )
			// MvdXMLv1_1.g:115:4: SIMPLEID
			{
			SIMPLEID2=(Token)match(input,SIMPLEID,FOLLOW_SIMPLEID_in_parameter310); 
			Parameter parameter=new Parameter((SIMPLEID2!=null?SIMPLEID2.getText():null),hashMap);
				paraReturns =parameter.getResult();
				
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return paraReturns;
	}
	// $ANTLR end "parameter"



	// $ANTLR start "metric"
	// MvdXMLv1_1.g:119:1: metric[Object value] returns [Object metricReturns] : ( VALUE | SIZE | TYPE | UNIQUE | EXISTS );
	public final Object metric(Object value) throws RecognitionException {
		Object metricReturns = null;


		try {
			// MvdXMLv1_1.g:120:2: ( VALUE | SIZE | TYPE | UNIQUE | EXISTS )
			int alt11=5;
			switch ( input.LA(1) ) {
			case VALUE:
				{
				alt11=1;
				}
				break;
			case SIZE:
				{
				alt11=2;
				}
				break;
			case TYPE:
				{
				alt11=3;
				}
				break;
			case UNIQUE:
				{
				alt11=4;
				}
				break;
			case EXISTS:
				{
				alt11=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// MvdXMLv1_1.g:120:4: VALUE
					{
					match(input,VALUE,FOLLOW_VALUE_in_metric329); 
					Metric metric=new Metric(value);metricReturns =metric.getMetricValue();
					}
					break;
				case 2 :
					// MvdXMLv1_1.g:121:4: SIZE
					{
					match(input,SIZE,FOLLOW_SIZE_in_metric336); 
					Metric metric=new Metric(value);metricReturns =metric.getMetricSize();
					}
					break;
				case 3 :
					// MvdXMLv1_1.g:122:4: TYPE
					{
					match(input,TYPE,FOLLOW_TYPE_in_metric343); 
					Metric metric=new Metric(value);metricReturns =metric.getMetricType();
					}
					break;
				case 4 :
					// MvdXMLv1_1.g:122:84: UNIQUE
					{
					match(input,UNIQUE,FOLLOW_UNIQUE_in_metric348); 
					}
					break;
				case 5 :
					// MvdXMLv1_1.g:122:93: EXISTS
					{
					match(input,EXISTS,FOLLOW_EXISTS_in_metric352); 
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
		return metricReturns;
	}
	// $ANTLR end "metric"



	// $ANTLR start "operator"
	// MvdXMLv1_1.g:125:1: operator returns [String op] : ( EQUAL | NOT_EQUAL | GREATER_THAN | GREATER_THAN_OR_EQUAL | LESS_THAN | LESS_THAN_OR_EQUAL );
	public final String operator() throws RecognitionException {
		String op = null;


		try {
			// MvdXMLv1_1.g:126:2: ( EQUAL | NOT_EQUAL | GREATER_THAN | GREATER_THAN_OR_EQUAL | LESS_THAN | LESS_THAN_OR_EQUAL )
			int alt12=6;
			switch ( input.LA(1) ) {
			case EQUAL:
				{
				alt12=1;
				}
				break;
			case NOT_EQUAL:
				{
				alt12=2;
				}
				break;
			case GREATER_THAN:
				{
				alt12=3;
				}
				break;
			case GREATER_THAN_OR_EQUAL:
				{
				alt12=4;
				}
				break;
			case LESS_THAN:
				{
				alt12=5;
				}
				break;
			case LESS_THAN_OR_EQUAL:
				{
				alt12=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// MvdXMLv1_1.g:126:4: EQUAL
					{
					match(input,EQUAL,FOLLOW_EQUAL_in_operator366); 
					op ="=";
					}
					break;
				case 2 :
					// MvdXMLv1_1.g:126:22: NOT_EQUAL
					{
					match(input,NOT_EQUAL,FOLLOW_NOT_EQUAL_in_operator371); 
					op ="!=";
					}
					break;
				case 3 :
					// MvdXMLv1_1.g:126:45: GREATER_THAN
					{
					match(input,GREATER_THAN,FOLLOW_GREATER_THAN_in_operator376); 
					op =">";
					}
					break;
				case 4 :
					// MvdXMLv1_1.g:126:71: GREATER_THAN_OR_EQUAL
					{
					match(input,GREATER_THAN_OR_EQUAL,FOLLOW_GREATER_THAN_OR_EQUAL_in_operator382); 
					op =">=";
					}
					break;
				case 5 :
					// MvdXMLv1_1.g:126:106: LESS_THAN
					{
					match(input,LESS_THAN,FOLLOW_LESS_THAN_in_operator387); 
					op ="<";
					}
					break;
				case 6 :
					// MvdXMLv1_1.g:126:128: LESS_THAN_OR_EQUAL
					{
					match(input,LESS_THAN_OR_EQUAL,FOLLOW_LESS_THAN_OR_EQUAL_in_operator392); 
					op ="<=";
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
		return op;
	}
	// $ANTLR end "operator"



	// $ANTLR start "value"
	// MvdXMLv1_1.g:128:1: value returns [Object valueReturns] : ( logical_literal | real_literal | string_literal | regular_expression );
	public final Object value() throws RecognitionException {
		Object valueReturns = null;


		Boolean logical_literal3 =null;
		ParserRuleReturnScope real_literal4 =null;
		String string_literal5 =null;
		String regular_expression6 =null;

		try {
			// MvdXMLv1_1.g:129:2: ( logical_literal | real_literal | string_literal | regular_expression )
			int alt13=4;
			switch ( input.LA(1) ) {
			case FALSE:
			case TRUE:
			case UNKNOWN:
				{
				alt13=1;
				}
				break;
			case DIGIT:
			case INT:
			case 36:
			case 37:
				{
				alt13=2;
				}
				break;
			case STRING:
				{
				alt13=3;
				}
				break;
			case 40:
				{
				alt13=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}
			switch (alt13) {
				case 1 :
					// MvdXMLv1_1.g:129:4: logical_literal
					{
					pushFollow(FOLLOW_logical_literal_in_value407);
					logical_literal3=logical_literal();
					state._fsp--;


						valueReturns =logical_literal3;
						
					}
					break;
				case 2 :
					// MvdXMLv1_1.g:131:6: real_literal
					{
					pushFollow(FOLLOW_real_literal_in_value412);
					real_literal4=real_literal();
					state._fsp--;


					  valueReturns =(real_literal4!=null?((MvdXMLv1_1Parser.real_literal_return)real_literal4).realReturns:null);
					  
					}
					break;
				case 3 :
					// MvdXMLv1_1.g:133:6: string_literal
					{
					pushFollow(FOLLOW_string_literal_in_value417);
					string_literal5=string_literal();
					state._fsp--;


					  valueReturns =string_literal5;
					  
					}
					break;
				case 4 :
					// MvdXMLv1_1.g:135:6: regular_expression
					{
					pushFollow(FOLLOW_regular_expression_in_value422);
					regular_expression6=regular_expression();
					state._fsp--;


					  valueReturns =regular_expression6;
					  
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
		return valueReturns;
	}
	// $ANTLR end "value"



	// $ANTLR start "logical_literal"
	// MvdXMLv1_1.g:139:1: logical_literal returns [Boolean logicalReturns] : ( FALSE | TRUE | UNKNOWN );
	public final Boolean logical_literal() throws RecognitionException {
		Boolean logicalReturns = null;


		try {
			// MvdXMLv1_1.g:140:2: ( FALSE | TRUE | UNKNOWN )
			int alt14=3;
			switch ( input.LA(1) ) {
			case FALSE:
				{
				alt14=1;
				}
				break;
			case TRUE:
				{
				alt14=2;
				}
				break;
			case UNKNOWN:
				{
				alt14=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}
			switch (alt14) {
				case 1 :
					// MvdXMLv1_1.g:140:5: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_logical_literal438); 
					logicalReturns =false;
					}
					break;
				case 2 :
					// MvdXMLv1_1.g:140:37: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_logical_literal443); 
					logicalReturns =true;
					}
					break;
				case 3 :
					// MvdXMLv1_1.g:140:67: UNKNOWN
					{
					match(input,UNKNOWN,FOLLOW_UNKNOWN_in_logical_literal448); 
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
		return logicalReturns;
	}
	// $ANTLR end "logical_literal"


	public static class real_literal_return extends ParserRuleReturnScope {
		public Double realReturns;
	};


	// $ANTLR start "real_literal"
	// MvdXMLv1_1.g:142:1: real_literal returns [Double realReturns] : ( sign )? ( DIGIT | INT ) ( '.' )? ( ( DIGIT | INT ) )? ( 'e' ( sign )? ( DIGIT | INT ) )? ;
	public final MvdXMLv1_1Parser.real_literal_return real_literal() throws RecognitionException {
		MvdXMLv1_1Parser.real_literal_return retval = new MvdXMLv1_1Parser.real_literal_return();
		retval.start = input.LT(1);

		try {
			// MvdXMLv1_1.g:143:2: ( ( sign )? ( DIGIT | INT ) ( '.' )? ( ( DIGIT | INT ) )? ( 'e' ( sign )? ( DIGIT | INT ) )? )
			// MvdXMLv1_1.g:143:4: ( sign )? ( DIGIT | INT ) ( '.' )? ( ( DIGIT | INT ) )? ( 'e' ( sign )? ( DIGIT | INT ) )?
			{
			// MvdXMLv1_1.g:143:4: ( sign )?
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( ((LA15_0 >= 36 && LA15_0 <= 37)) ) {
				alt15=1;
			}
			switch (alt15) {
				case 1 :
					// MvdXMLv1_1.g:143:5: sign
					{
					pushFollow(FOLLOW_sign_in_real_literal463);
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
			// MvdXMLv1_1.g:143:28: ( '.' )?
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==38) ) {
				alt16=1;
			}
			switch (alt16) {
				case 1 :
					// MvdXMLv1_1.g:143:29: '.'
					{
					match(input,38,FOLLOW_38_in_real_literal478); 
					}
					break;

			}

			// MvdXMLv1_1.g:143:35: ( ( DIGIT | INT ) )?
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==DIGIT||LA17_0==INT) ) {
				alt17=1;
			}
			switch (alt17) {
				case 1 :
					// MvdXMLv1_1.g:
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

			// MvdXMLv1_1.g:143:56: ( 'e' ( sign )? ( DIGIT | INT ) )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==39) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// MvdXMLv1_1.g:143:58: 'e' ( sign )? ( DIGIT | INT )
					{
					match(input,39,FOLLOW_39_in_real_literal499); 
					// MvdXMLv1_1.g:143:62: ( sign )?
					int alt18=2;
					int LA18_0 = input.LA(1);
					if ( ((LA18_0 >= 36 && LA18_0 <= 37)) ) {
						alt18=1;
					}
					switch (alt18) {
						case 1 :
							// MvdXMLv1_1.g:143:63: sign
							{
							pushFollow(FOLLOW_sign_in_real_literal502);
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

			retval.realReturns =Double.parseDouble(input.toString(retval.start,input.LT(-1)));
			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "real_literal"



	// $ANTLR start "string_literal"
	// MvdXMLv1_1.g:145:1: string_literal returns [String stringReturns] : STRING ;
	public final String string_literal() throws RecognitionException {
		String stringReturns = null;


		Token STRING7=null;

		try {
			// MvdXMLv1_1.g:146:2: ( STRING )
			// MvdXMLv1_1.g:146:4: STRING
			{
			STRING7=(Token)match(input,STRING,FOLLOW_STRING_in_string_literal533); 
			stringReturns =(STRING7!=null?STRING7.getText():null).substring(1,(STRING7!=null?STRING7.getText():null).length()-1);
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return stringReturns;
	}
	// $ANTLR end "string_literal"



	// $ANTLR start "regular_expression"
	// MvdXMLv1_1.g:148:1: regular_expression returns [String regReturns] : 'reg' STRING ;
	public final String regular_expression() throws RecognitionException {
		String regReturns = null;


		Token STRING8=null;

		try {
			// MvdXMLv1_1.g:149:2: ( 'reg' STRING )
			// MvdXMLv1_1.g:149:4: 'reg' STRING
			{
			match(input,40,FOLLOW_40_in_regular_expression549); 
			STRING8=(Token)match(input,STRING,FOLLOW_STRING_in_regular_expression551); 
			regReturns ="reg "+(STRING8!=null?STRING8.getText():null).substring(1,(STRING8!=null?STRING8.getText():null).length()-1);
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return regReturns;
	}
	// $ANTLR end "regular_expression"



	// $ANTLR start "sign"
	// MvdXMLv1_1.g:150:1: sign : ( '+' | '-' );
	public final void sign() throws RecognitionException {
		try {
			// MvdXMLv1_1.g:151:2: ( '+' | '-' )
			// MvdXMLv1_1.g:
			{
			if ( (input.LA(1) >= 36 && input.LA(1) <= 37) ) {
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



	public static final BitSet FOLLOW_boolean_expression_in_expression37 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_boolean_term_in_boolean_expression64 = new BitSet(new long[]{0x0000000800AC0012L});
	public static final BitSet FOLLOW_AND_in_boolean_expression68 = new BitSet(new long[]{0x0000000002020000L});
	public static final BitSet FOLLOW_boolean_expression_in_boolean_expression72 = new BitSet(new long[]{0x0000000800AC0002L});
	public static final BitSet FOLLOW_OR_in_boolean_expression91 = new BitSet(new long[]{0x0000000002020000L});
	public static final BitSet FOLLOW_boolean_expression_in_boolean_expression95 = new BitSet(new long[]{0x00000008002C0002L});
	public static final BitSet FOLLOW_XOR_in_boolean_expression114 = new BitSet(new long[]{0x0000000002020000L});
	public static final BitSet FOLLOW_boolean_expression_in_boolean_expression118 = new BitSet(new long[]{0x00000000002C0002L});
	public static final BitSet FOLLOW_NAND_in_boolean_expression137 = new BitSet(new long[]{0x0000000002020000L});
	public static final BitSet FOLLOW_boolean_expression_in_boolean_expression141 = new BitSet(new long[]{0x0000000000280002L});
	public static final BitSet FOLLOW_NOR_in_boolean_expression160 = new BitSet(new long[]{0x0000000002020000L});
	public static final BitSet FOLLOW_boolean_expression_in_boolean_expression164 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_NXOR_in_boolean_expression183 = new BitSet(new long[]{0x0000000002020000L});
	public static final BitSet FOLLOW_boolean_expression_in_boolean_expression187 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_parameter_in_boolean_term235 = new BitSet(new long[]{0x00000002A410CD40L});
	public static final BitSet FOLLOW_metric_in_boolean_term241 = new BitSet(new long[]{0x000000000010CC40L});
	public static final BitSet FOLLOW_operator_in_boolean_term250 = new BitSet(new long[]{0x000001311A002220L});
	public static final BitSet FOLLOW_value_in_boolean_term256 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_parameter_in_boolean_term262 = new BitSet(new long[]{0x00000002A4000102L});
	public static final BitSet FOLLOW_metric_in_boolean_term268 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_boolean_term286 = new BitSet(new long[]{0x0000000002020000L});
	public static final BitSet FOLLOW_boolean_expression_in_boolean_term290 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_RPAREN_in_boolean_term292 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SIMPLEID_in_parameter310 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VALUE_in_metric329 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SIZE_in_metric336 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TYPE_in_metric343 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UNIQUE_in_metric348 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EXISTS_in_metric352 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EQUAL_in_operator366 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_EQUAL_in_operator371 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GREATER_THAN_in_operator376 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GREATER_THAN_OR_EQUAL_in_operator382 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESS_THAN_in_operator387 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESS_THAN_OR_EQUAL_in_operator392 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_logical_literal_in_value407 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_real_literal_in_value412 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_string_literal_in_value417 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_regular_expression_in_value422 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_logical_literal438 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_logical_literal443 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UNKNOWN_in_logical_literal448 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sign_in_real_literal463 = new BitSet(new long[]{0x0000000000002020L});
	public static final BitSet FOLLOW_set_in_real_literal467 = new BitSet(new long[]{0x000000C000002022L});
	public static final BitSet FOLLOW_38_in_real_literal478 = new BitSet(new long[]{0x0000008000002022L});
	public static final BitSet FOLLOW_39_in_real_literal499 = new BitSet(new long[]{0x0000003000002020L});
	public static final BitSet FOLLOW_sign_in_real_literal502 = new BitSet(new long[]{0x0000000000002020L});
	public static final BitSet FOLLOW_set_in_real_literal506 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_string_literal533 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_40_in_regular_expression549 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_STRING_in_regular_expression551 = new BitSet(new long[]{0x0000000000000002L});
}
